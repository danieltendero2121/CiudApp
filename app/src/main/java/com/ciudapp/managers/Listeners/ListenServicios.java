package com.ciudapp.managers.Listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ciudapp.R;
import com.ciudapp.views.Habitabilidad_Activity;
import com.ciudapp.views.Ocio_Activity;
import com.ciudapp.views.Seguridad_Activity;
import com.ciudapp.views.Servicios_Activity;
import com.ciudapp.views.Settings_activity;
import com.ciudapp.views.WebActivity;


/**
 * Created by circegonzalezreyes on 10/12/15.
 */
public class ListenServicios implements View.OnClickListener {
    /*
    variables
     */
    private Servicios_Activity servicios_activity;
    private Context context;

    /**
     * constructor
     * @param servicios_activity
     */
    public ListenServicios(Servicios_Activity servicios_activity, Context context){
        this.servicios_activity = servicios_activity;
        this.context = context;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == servicios_activity.getButtonWeb().getId()){
            Intent intent = new Intent(servicios_activity, WebActivity.class);
            servicios_activity.startActivity(intent);
            servicios_activity.finish();
        }
        if(v.getId() == servicios_activity.getContainer_habitabilidad().getId()){
            Intent intent = new Intent(servicios_activity, Habitabilidad_Activity.class);
            servicios_activity.startActivity(intent);
            servicios_activity.finish();
        }
        if(v.getId() == servicios_activity.getContainer_ocio().getId()){
            Intent intent = new Intent(servicios_activity, Ocio_Activity.class);
            servicios_activity.startActivity(intent);
            servicios_activity.finish();
        }
        if(v.getId() == servicios_activity.getContainer_servicios().getId()){
            //nada
        }
        if(v.getId() == servicios_activity.getContainer_seguridad().getId()){
            Intent intent = new Intent(servicios_activity, Seguridad_Activity.class);
            servicios_activity.startActivity(intent);
            servicios_activity.finish();
        }
        // las preguntas de cada sección

        if(v.getId() == servicios_activity.getButton_pregunta1().getId()){
            String pregunta = context.getString(R.string.servicios_pregunta_aparcamiento);
            servicios_activity.showDialog(pregunta, 1);
        }
        if(v.getId() == servicios_activity.getButton_pregunta2().getId()){
            String pregunta = context.getString(R.string.servicios_preguntas_policia);
            servicios_activity.showDialog(pregunta, 2);
        }
        if(v.getId() == servicios_activity.getButton_pregunta3().getId()){
            String pregunta = context.getString(R.string.servicios_pregunta_atencionSanitaria);
            servicios_activity.showDialog(pregunta, 3);
        }
        if(v.getId() == servicios_activity.getButton_pregunta4().getId()){
            String pregunta = context.getString(R.string.servicios_preguntas_colegios);
            servicios_activity.showDialog(pregunta, 4);
        }
        if(v.getId() == servicios_activity.getButton_pregunta5().getId()){
            String pregunta = context.getString(R.string.servicios_pregunta_transporte);
            servicios_activity.showDialog(pregunta, 5);
        }
        if(v.getId() == servicios_activity.getButton_pregunta6().getId()){
            String pregunta = context.getString(R.string.servicios_preguntas_bibliotecas);
            servicios_activity.showDialog(pregunta, 6);
        }
    }
}
