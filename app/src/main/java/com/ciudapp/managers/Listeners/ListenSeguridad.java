package com.ciudapp.managers.Listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ciudapp.R;
import com.ciudapp.views.Habitabilidad_Activity;
import com.ciudapp.views.Ocio_Activity;
import com.ciudapp.views.Seguridad_Activity;
import com.ciudapp.views.Servicios_Activity;
import com.ciudapp.views.WebActivity;


/**
 * Created by circegonzalezreyes on 10/12/15.
 */
public class ListenSeguridad implements View.OnClickListener {
    /*
    variables
     */
    private Seguridad_Activity seguridad_activity;
    private Context context;


    /**
     * constructor
     * @param seguridad_activity
     */
    public ListenSeguridad(Seguridad_Activity seguridad_activity, Context context){
        this.seguridad_activity = seguridad_activity;
        this.context = context;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == seguridad_activity.getButtonWeb().getId()){
            Intent intent = new Intent(seguridad_activity, WebActivity.class);
            seguridad_activity.startActivity(intent);
            seguridad_activity.finish();
        }
        if(v.getId() == seguridad_activity.getContainer_habitabilidad().getId()){
            Intent intent = new Intent(seguridad_activity, Habitabilidad_Activity.class);
            seguridad_activity.startActivity(intent);
            seguridad_activity.finish();
        }
        if(v.getId() == seguridad_activity.getContainer_ocio().getId()){
            Intent intent = new Intent(seguridad_activity, Ocio_Activity.class);
            seguridad_activity.startActivity(intent);
            seguridad_activity.finish();
        }
        if(v.getId() == seguridad_activity.getContainer_servicios().getId()){
            Intent intent = new Intent(seguridad_activity, Servicios_Activity.class);
            seguridad_activity.startActivity(intent);
            seguridad_activity.finish();
        }
        if(v.getId() == seguridad_activity.getContainer_seguridad().getId()){
            //nada
        }
        // las preguntas de cada sección

        if(v.getId() == seguridad_activity.getButton_pregunta1().getId()){
            String pregunta = context.getString(R.string.seguridad_pregunta_drogas);
            seguridad_activity.showDialog(pregunta, 1);
        }
        if(v.getId() == seguridad_activity.getButton_pregunta2().getId()){
            String pregunta = context.getString(R.string.seguridad_pregunta_altercados);
            seguridad_activity.showDialog(pregunta, 2);
        }
        if(v.getId() == seguridad_activity.getButton_pregunta3().getId()){
            String pregunta = context.getString(R.string.seguridad_pregunta_prostitucion);
            seguridad_activity.showDialog(pregunta, 3);
        }
        if(v.getId() == seguridad_activity.getButton_pregunta4().getId()){
            String pregunta = context.getString(R.string.seguridad_pregunta_robos);
            seguridad_activity.showDialog(pregunta, 4);
        }
        if(v.getId() == seguridad_activity.getButton_pregunta5().getId()){
            String pregunta = context.getString(R.string.seguridad_pregunta_otros);
            seguridad_activity.showDialog(pregunta, 5);
        }

    }
}
