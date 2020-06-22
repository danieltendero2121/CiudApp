package com.ciudapp.Utils;

import com.orm.SugarRecord;

/**
 * Created by cgonzalez on 6/6/16.
 */
public class VotacionSeguridad extends SugarRecord {

    public String ubicacion;
    public String drogas;
    public String altercados;
    public String prostitucion;
    public String robos;
    public String otros;

    public VotacionSeguridad(){
        //dejar vacío
    }

    public VotacionSeguridad(String ubicacion, String drogas, String altercados, String prostitucion, String robos, String otros){
        this.ubicacion = ubicacion;
        this.drogas = drogas;
        this.altercados = altercados;
        this.prostitucion = prostitucion;
        this.robos = robos;
        this.otros = otros;

    }
}
