package com.ciudapp.views;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.ScrollView;
import android.widget.TextView;
import com.ciudapp.R;
import com.ciudapp.Utils.DataHolder;
import com.ciudapp.Utils.VotacionHabitabilidad;
import com.ciudapp.Utils.VotacionOcio;
import com.ciudapp.Utils.VotacionSeguridad;
import com.ciudapp.Utils.VotacionServicios;
import com.ciudapp.managers.GestorBD;

import java.util.List;
import java.util.Locale;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity {

    private String ubicacion_usuario;
    private Dialog dialogo_idioma = null;
    private Dialog dialogo_legal = null;
    private SharedPreferences preferences;
    private GestorBD gestorBD;
//    private VotacionHabitabilidad votacionHabitabilidad;
//    private VotacionOcio votacionOcio;
//    private VotacionServicios votacionServicios;
//    private VotacionSeguridad votacionSeguridad;
    @InjectView(R.id.button_menu)ImageButton button_menu;
    @InjectView(R.id.imgBtnLogo) ImageButton imgBtnLogo;
    @InjectView(R.id.txtNombreApp) TextView txtNombreApp;
    @InjectView(R.id.txt_tu_barrio) TextView txt_tu_barrio;
    @InjectView(R.id.txt_nombre_barrio) TextView txt_nombre_barrio;
    @InjectView(R.id.txt_nota_actual) TextView txt_nota_actual;
    @InjectView(R.id.txt_nota) TextView txt_nota;
    @InjectView(R.id.panelVerde) ScrollView panelVerde;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comprobarIdiomaRegistrado();
        ButterKnife.inject(this);
        gestorBD = new GestorBD();
        String ubicacion = DataHolder.getInstance().getUbicacion_usuario();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Menu_Acrivity.class);
                startActivity(intent);
            }
        };
        imgBtnLogo.setOnClickListener(listener);
        txtNombreApp.setText(R.string.app_name);
        txtNombreApp.setOnClickListener(listener);
        panelVerde.setOnClickListener(listener);
        txt_tu_barrio.setText(R.string.txt_tu_barrio);
        txt_nombre_barrio.setText(ubicacion);
        txt_nota_actual.setText(R.string.txt_nota_actual);
        txt_nota.setText(R.string.txt_nota);
        registerForContextMenu(button_menu);
        cargarVotaciones();
    }

    public void comprobarIdiomaRegistrado(){
        //recuperar el idioma de la configuración del usuario
        preferences = getSharedPreferences("Configuration", Context.MODE_PRIVATE);
        preferences.getString("Languaje", "es");
        String idioma = preferences.getString("Languaje", "es");
        DataHolder.getInstance().setIdioma(idioma);
    }

    /**
     * construir el menú
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_setitngs, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.idioma:
                showDialogIdioma();
                return true;
            case R.id.residencia:
                Intent intent = new Intent(this, Settings_activity.class);
                intent.putExtra("cambiar", "ubicacion");
                startActivity(intent);
                finish();
                return true;
            case R.id.legal:
                showDialogLegal();
                return true;

        }
        return super.onContextItemSelected(item);
    }

    /**
     * mostrar diálogo de seleeción de idioma
     */
    public void showDialogIdioma(){
        dialogo_idioma = new Dialog(this, R.style.Theme_Dialog_Translucent);
        dialogo_idioma.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo_idioma.setCancelable(true);
        dialogo_idioma.setContentView(R.layout.dialogo_idioma);
        final Button button_castelano = (Button)dialogo_idioma.findViewById(R.id.button_castellano);
        final Button button_catalan = (Button)dialogo_idioma.findViewById(R.id.button_catalan);
        final Button button_gallego = (Button)dialogo_idioma.findViewById(R.id.button_gallego);
        final Button button_euskera = (Button)dialogo_idioma.findViewById(R.id.button_euskera);
        final Button button_ingles = (Button)dialogo_idioma.findViewById(R.id.button_ingles);

        button_catalan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = MainActivity.this.getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                android.content.res.Configuration conf = res.getConfiguration();
                conf.locale = new Locale("ca");
                res.updateConfiguration(conf, dm);
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Language","ca");
                editor.commit();

                dialogo_idioma.dismiss();
                startActivity(i);

            }
        });
        button_castelano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = MainActivity.this.getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                android.content.res.Configuration conf = res.getConfiguration();
                conf.locale = new Locale("es");
                res.updateConfiguration(conf, dm);
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Language","es");
                editor.commit();

                dialogo_idioma.dismiss();
                startActivity(i);
            }
        });

        button_gallego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = MainActivity.this.getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                android.content.res.Configuration conf = res.getConfiguration();
                conf.locale = new Locale("gl");
                res.updateConfiguration(conf, dm);
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Language","gl");
                editor.commit();

                dialogo_idioma.dismiss();
                startActivity(i);

            }
        });
        button_ingles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = MainActivity.this.getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                android.content.res.Configuration conf = res.getConfiguration();
                conf.locale = new Locale("en");
                res.updateConfiguration(conf, dm);
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Language","en");
                editor.commit();

                dialogo_idioma.dismiss();
                startActivity(i);

            }
        });
        button_euskera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = MainActivity.this.getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                android.content.res.Configuration conf = res.getConfiguration();
                conf.locale = new Locale("eu");
                res.updateConfiguration(conf, dm);
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Language","eu");
                editor.commit();

                dialogo_idioma.dismiss();
                startActivity(i);

            }
        });

        dialogo_idioma.show();
    }

    /**
     * mostrar diálogo de información legal
     */
    public void showDialogLegal(){
        dialogo_legal = new Dialog(this, R.style.Theme_Dialog_Translucent);
        dialogo_legal.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo_legal.setCancelable(true);
        dialogo_legal.setContentView(R.layout.dialogo_legal);
        final Button button = (Button)dialogo_legal.findViewById(R.id.buttonOk_legal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo_legal.dismiss();

            }
        });
        dialogo_legal.show();
    }

    /**
     * borrar datos de la bd interna
     */
    public void deleteRegistro(){
        preferences = getSharedPreferences("Configuration", Context.MODE_PRIVATE);
        String ubicacion = preferences.getString("Ubicacion", "Galapagar");

        gestorBD.deleteRegistro(ubicacion);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Ubicacion",DataHolder.getInstance().getUbicacion_usuario());
        editor.clear();
    }

    /**
     * cargar las votaciones de la bd interna
     */
    public void cargarVotaciones(){
        preferences = getSharedPreferences("Configuration", Context.MODE_PRIVATE);
        String ubicacion = preferences.getString("Ubicacion", "Galapagar");

        gestorBD.cargarVotaciones(ubicacion);

    }

    public String getUbicacion_usuario() {
        return ubicacion_usuario;
    }

    public void setUbicacion_usuario(String ubicacion_usuario) {
        this.ubicacion_usuario = ubicacion_usuario;
    }
}
