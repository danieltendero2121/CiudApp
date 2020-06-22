package com.ciudapp.Utils;

import com.orm.SugarRecord;

/**
 * Created by cgonzalez on 6/6/16.
 */
public class VotacionServicios extends SugarRecord{

    public String ubicacion;
    public String aparcamiento;
    public String policia;
    public String atencion_sanitaria;
    public String colegios;
    public String transporte_publico;
    public String bibliotecas;

    public VotacionServicios(){
        //dejar vacío
    }

    public VotacionServicios(String ubicacion, String aparcamiento, String policia, String atencion_sanitaria, String colegios, String transporte_publico, String bibliotecas){
        this.ubicacion = ubicacion;
        this.aparcamiento = aparcamiento;
        this.policia = policia;
        this.atencion_sanitaria = atencion_sanitaria;
        this.colegios = colegios;
        this.transporte_publico = transporte_publico;
        this.bibliotecas = bibliotecas;
    }
}
