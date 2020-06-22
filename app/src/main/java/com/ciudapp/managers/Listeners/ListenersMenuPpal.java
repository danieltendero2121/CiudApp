package com.ciudapp.managers.Listeners;

import android.content.Intent;
import android.view.View;

import com.ciudapp.views.Habitabilidad_Activity;
import com.ciudapp.views.Menu_Acrivity;
import com.ciudapp.views.Ocio_Activity;
import com.ciudapp.views.Seguridad_Activity;
import com.ciudapp.views.Servicios_Activity;


/**
 * Created by MargaPC on 08/12/2015.
 */
public class ListenersMenuPpal implements android.view.View.OnClickListener{

    private Menu_Acrivity menuActivity;

    public ListenersMenuPpal(Menu_Acrivity activity){
        this.menuActivity = activity;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==menuActivity.getContainer_habitabilidad().getId()){
            Intent intent = new Intent(menuActivity, Habitabilidad_Activity.class);
            menuActivity.startActivity(intent);
        }else if(v.getId()==menuActivity.getContainer_ocio().getId()){
            Intent intent = new Intent(menuActivity, Ocio_Activity.class);
            menuActivity.startActivity(intent);
        }else if(v.getId()==menuActivity.getContainer_servicios().getId()){
            Intent intent = new Intent(menuActivity, Servicios_Activity.class);
            menuActivity.startActivity(intent);
        }else if(v.getId()==menuActivity.getContainer_seguridad().getId()){
            Intent intent = new Intent(menuActivity, Seguridad_Activity.class);
            menuActivity.startActivity(intent);
        }
    }
}
