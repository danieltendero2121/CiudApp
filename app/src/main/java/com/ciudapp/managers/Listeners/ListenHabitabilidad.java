package com.ciudapp.managers.Listeners;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ciudapp.R;
import com.ciudapp.Utils.DataHolder;
import com.ciudapp.views.Habitabilidad_Activity;
import com.ciudapp.views.Ocio_Activity;
import com.ciudapp.views.Seguridad_Activity;
import com.ciudapp.views.Servicios_Activity;
import com.ciudapp.views.WebActivity;

/**
 * Created by circegonzalezreyes on 10/12/15.
 */
public class ListenHabitabilidad implements View.OnClickListener {
    /*
    variables
     */
    private Habitabilidad_Activity habitabilidad_activity;
    private Context context;



    public ListenHabitabilidad(Habitabilidad_Activity habitabilidad_activity, Context context){
        this.habitabilidad_activity = habitabilidad_activity;
        this.context = context;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == habitabilidad_activity.getButtonWeb().getId()){
            Intent intent = new Intent(habitabilidad_activity, WebActivity.class);
            habitabilidad_activity.startActivity(intent);
            habitabilidad_activity.finish();
        }
        if(v.getId() == habitabilidad_activity.getContainer_habitabilidad().getId()){
            //nada
        }
        if(v.getId() == habitabilidad_activity.getContainer_ocio().getId()){
            Intent intent = new Intent(habitabilidad_activity, Ocio_Activity.class);
            habitabilidad_activity.startActivity(intent);
            habitabilidad_activity.finish();
        }
        if(v.getId() == habitabilidad_activity.getContainer_servicios().getId()){
            Intent intent = new Intent(habitabilidad_activity, Servicios_Activity.class);
            habitabilidad_activity.startActivity(intent);
            habitabilidad_activity.finish();
        }
        if(v.getId() == habitabilidad_activity.getContainer_seguridad().getId()){
            Intent intent = new Intent(habitabilidad_activity, Seguridad_Activity.class);
            habitabilidad_activity.startActivity(intent);
            habitabilidad_activity.finish();
        }
        // las preguntas de cada sección

        if(v.getId() == habitabilidad_activity.getButton_pregunta1().getId()){
            String pregunta = context.getString(R.string.habitabilidad_pregunta_zonasInfantiles);
            habitabilidad_activity.showDialog(pregunta, 1);

        }
        if(v.getId() == habitabilidad_activity.getButton_pregunta2().getId()){
            String pregunta = context.getString(R.string.habitabilidad_pregunta_trafico);
            habitabilidad_activity.showDialog(pregunta, 2);

        }
        if(v.getId() == habitabilidad_activity.getButton_pregunta3().getId()){
            String pregunta = context.getString(R.string.habitabilidad_pregunta_parques);
            habitabilidad_activity.showDialog(pregunta, 3);

        }
        if(v.getId() == habitabilidad_activity.getButton_pregunta4().getId()){
            String pregunta = context.getString(R.string.habitabilidad_pregunta_limpieza);
            habitabilidad_activity.showDialog(pregunta, 4);

        }
        if(v.getId() == habitabilidad_activity.getButton_pregunta5().getId()){
            String pregunta = context.getString(R.string.habitabilidad_pregunta_cestaCompra);
            habitabilidad_activity.showDialog(pregunta, 5);

        }
        if(v.getId() == habitabilidad_activity.getButton_pregunta6().getId()){
            String pregunta = context.getString(R.string.habitabilidad_pregunta_ruido);
            habitabilidad_activity. showDialog(pregunta, 6);

        }


    }



}
