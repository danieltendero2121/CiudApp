package com.ciudapp.Splash;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import se.simbio.encryption.Encryption;

import com.ciudapp.R;
import com.ciudapp.Utils.DataHolder;
import com.ciudapp.managers.CapturaMac;
import com.ciudapp.managers.GestorBD;
import com.ciudapp.views.MainActivity;
import com.ciudapp.views.Settings_activity;

/**
 * Created by cgonzalez on 6/6/16.
 */
public class Splash extends AppCompatActivity {

    private SharedPreferences preferences;
    private Intent intent;
    private CapturaMac capturaMac;
    private GestorBD gestorBD;
    @InjectView(R.id.text_titulo_splash)TextView titulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        gestorBD = new GestorBD();
        comprobarIdiomaRegistrado();
        ButterKnife.inject(this);
        preferences = getSharedPreferences("Configuration", Context.MODE_PRIVATE);

        if(preferences.getBoolean("FirstRun", true)){
            //FirtsTime ft = new FirtsTime();
            //ft.execute();
            capturaMac = new CapturaMac(this);
            //registerDevice();//encriptar mac del dispositivo
            gestorBD.registerDevice(capturaMac);

            intent = new Intent(Splash.this, Settings_activity.class);

        }else{
            intent = new Intent(Splash.this, MainActivity.class);
        }
        titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    public void comprobarIdiomaRegistrado(){
        //recuperar el idioma de la configuración del usuario
        preferences = getSharedPreferences("Configuration", Context.MODE_PRIVATE);
        preferences.getString("Languaje", "es");
        String idioma = preferences.getString("Languaje", "es");
        DataHolder.getInstance().setIdioma(idioma);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }



    class FirtsTime extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            //TODO comunicar con el servidor y descargar los datos
            //gestorBD.cargarVotaciones();
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result) {
           // preferences.edit().putBoolean("FirstRun",false).commit();

        }
    }
}
