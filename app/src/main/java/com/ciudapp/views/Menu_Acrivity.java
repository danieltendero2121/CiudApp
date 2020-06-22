package com.ciudapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;

import com.ciudapp.R;
import com.ciudapp.managers.Listeners.ListenersMenuPpal;


public class Menu_Acrivity extends AppCompatActivity {

    @InjectView(R.id.container_habitabilidad)RelativeLayout container_habitabilidad;
    @InjectView(R.id.container_ocio)RelativeLayout container_ocio;
    @InjectView(R.id.container_servicios)RelativeLayout container_servicios;
    @InjectView(R.id.container_seguridad)RelativeLayout container_seguridad;
    private ListenersMenuPpal listenersMenuPpal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ppal);
        ButterKnife.inject(this);
        listenersMenuPpal = new ListenersMenuPpal(this);

        container_habitabilidad.setOnClickListener(listenersMenuPpal);
        container_ocio.setOnClickListener(listenersMenuPpal);
        container_servicios.setOnClickListener(listenersMenuPpal);
        container_seguridad.setOnClickListener(listenersMenuPpal);
    }

    public RelativeLayout getContainer_habitabilidad() {
        return container_habitabilidad;
    }

    public void setContainer_habitabilidad(RelativeLayout container_habitabilidad) {
        this.container_habitabilidad = container_habitabilidad;
    }

    public RelativeLayout getContainer_ocio() {
        return container_ocio;
    }

    public void setContainer_ocio(RelativeLayout container_ocio) {
        this.container_ocio = container_ocio;
    }

    public RelativeLayout getContainer_servicios() {
        return container_servicios;
    }

    public void setContainer_servicios(RelativeLayout container_servicios) {
        this.container_servicios = container_servicios;
    }

    public RelativeLayout getContainer_seguridad() {
        return container_seguridad;
    }

    public void setContainer_seguridad(RelativeLayout container_seguridad) {
        this.container_seguridad = container_seguridad;
    }
}
