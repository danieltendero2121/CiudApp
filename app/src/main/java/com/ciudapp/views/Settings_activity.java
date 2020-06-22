package com.ciudapp.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.ciudapp.R;
import com.ciudapp.Utils.DataHolder;
import com.ciudapp.Utils.VotacionHabitabilidad;
import com.ciudapp.Utils.VotacionOcio;
import com.ciudapp.Utils.VotacionSeguridad;
import com.ciudapp.Utils.VotacionServicios;
import com.ciudapp.managers.CapturaMac;
import com.ciudapp.managers.GestorBD;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.InjectView;
import se.simbio.encryption.Encryption;

/**
 * utilizar el codigo postal para localizar el lugar de residencia
 *
 * http://stackoverflow.com/questions/5220761/fast-and-simple-string-encrypt-decrypt-in-java
 */
public class Settings_activity extends FragmentActivity implements OnMapReadyCallback {

    private String ubicacion_usuario;
    private GoogleMap googleMap;
    private Marker marker;
    private SharedPreferences preferences;
    private GestorBD gestorBD;
    @InjectView(R.id.editTextCodigoPostal) EditText editText_codigoPostal;
    @InjectView(R.id.buttonOk_codigo_postal) Button buttonOk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        gestorBD = new GestorBD();
        cambiarArranque();

        ButterKnife.inject(this);
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_map);
        mapFragment.getMapAsync(this);
        mapFragment.getView().setClickable(false);//deshabilitar eventos
        editText_codigoPostal.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);
        editText_codigoPostal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                try {
                    List<Address> addresses = geocoder.getFromLocationName(editText_codigoPostal.getText().toString()+"spain", 2);
                    String ubicacion = null;
                    if(addresses.size() >0){
                        LatLng lugar = new LatLng(addresses.get(0).getLatitude(),addresses.get(0).getLongitude() );
                        if(addresses.get(0).getSubLocality() == null){
                            ubicacion = addresses.get(0).getLocality();
                        }else{
                            ubicacion  = addresses.get(0).getSubLocality();
                        }
                        setUbicacion_usuario(ubicacion);
                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(lugar));
                        googleMap.animateCamera(CameraUpdateFactory.zoomTo(11.0f));

                        addMarker(lugar, getUbicacion_usuario());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DataHolder.getInstance().setUbicacion_usuario(getUbicacion_usuario());//almacenamos la ubicación
               gestorBD.setUbicacion(getUbicacion_usuario());
               SharedPreferences.Editor editor = preferences.edit();
               editor.putString("Ubicacion",DataHolder.getInstance().getUbicacion_usuario());
               editor.commit();

               Intent inten = new Intent(Settings_activity.this, MainActivity.class);
               startActivity(inten);
           }
       });
    }


    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        LatLng origen = new LatLng(40.4165000, -3.7025600);//españa
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(origen));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(05.0f));
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

            }
        });
        //deshabilitar eventos en el mapa
        googleMap.setIndoorEnabled(false);
        googleMap.getUiSettings().setIndoorLevelPickerEnabled(false);
        googleMap.getUiSettings().setCompassEnabled(false);
        googleMap.getUiSettings().setAllGesturesEnabled(false);
        googleMap.getUiSettings().setRotateGesturesEnabled(false);
        googleMap.getUiSettings().setZoomControlsEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.getUiSettings().setScrollGesturesEnabled(false);
    }



    /**
     * establecer la localización en el mapa
     * @param latLng
     */
    public void addMarker(LatLng latLng, String nombre){
        marker = googleMap.addMarker(new MarkerOptions().position(latLng).title(nombre));//agrega un pin
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(11.0f));

    }



    public void cambiarArranque(){
        preferences = getSharedPreferences("Configuration", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("FirstRun", false).commit();
        //cargarVotaciones();
    }




    public String getUbicacion_usuario() {
        return ubicacion_usuario;
    }

    public void setUbicacion_usuario(String ubicacion_usuario) {
        this.ubicacion_usuario = ubicacion_usuario;
    }



}
