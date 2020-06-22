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
public class ListenOcio implements View.OnClickListener{

    private Ocio_Activity ocio_activity;
    private Context context;

    public ListenOcio(Ocio_Activity ocio_activity, Context context){
        this.context = context;
        this.ocio_activity = ocio_activity;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == ocio_activity.getButtonWeb().getId()){
            Intent intent = new Intent(ocio_activity, WebActivity.class);
            ocio_activity.startActivity(intent);
            ocio_activity.finish();
        }
        if(v.getId() == ocio_activity.getContainer_habitabilidad().getId()){
            Intent intent = new Intent(ocio_activity, Habitabilidad_Activity.class);
            ocio_activity.startActivity(intent);
            ocio_activity.finish();
        }
        if(v.getId() == ocio_activity.getContainer_ocio().getId()){

        }
        if(v.getId() == ocio_activity.getContainer_servicios().getId()){
            Intent intent = new Intent(ocio_activity, Servicios_Activity.class);
            ocio_activity.startActivity(intent);
            ocio_activity.finish();
        }
        if(v.getId() == ocio_activity.getContainer_seguridad().getId()){
            Intent intent = new Intent(ocio_activity, Seguridad_Activity.class);
            ocio_activity.startActivity(intent);
            ocio_activity.finish();
        }
        // las preguntas de cada sección

        if(v.getId() == ocio_activity.getButton_pregunta1().getId()){
            String pregunta = context.getString(R.string.ocio_pregunta_cines);
            ocio_activity.showDialog(pregunta, 1);

        }
        if(v.getId() == ocio_activity.getButton_pregunta2().getId()){
            String pregunta = context.getString(R.string.ocio_pregunta_bares);
            ocio_activity.showDialog(pregunta, 2);
        }
        if(v.getId() == ocio_activity.getButton_pregunta3().getId()){
            String pregunta = context.getString(R.string.ocio_pregunta_restaurantes);
            ocio_activity.showDialog(pregunta, 3);
        }
        if(v.getId() == ocio_activity.getButton_pregunta4().getId()){
            String pregunta = context.getString(R.string.ocio_pregunta_discotecas);
            ocio_activity.showDialog(pregunta, 4);
        }
        if(v.getId() == ocio_activity.getButton_pregunta5().getId()){
            String pregunta = context.getString(R.string.ocio_pregunta_ofertaCultural);
            ocio_activity.showDialog(pregunta, 5);
        }
        if(v.getId() == ocio_activity.getButton_pregunta6().getId()){
            String pregunta = context.getString(R.string.ocio_pregunta_centrosComerciales);
            ocio_activity.showDialog(pregunta, 6);
        }

    }
}
