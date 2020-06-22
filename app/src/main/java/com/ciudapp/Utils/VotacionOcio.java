package com.ciudapp.Utils;

import com.orm.SugarRecord;

/**
 * Created by cgonzalez on 6/6/16.
 */
public class VotacionOcio extends SugarRecord {

    public String ubicacion;
    public String cines;
    public String bares;
    public String restaurantes;
    public String discotecas;
    public String oferta_cultural;
    public String centros_comerciales;

    public VotacionOcio(){
        //dejar vacío
    }

    public VotacionOcio(String ubicacion, String cines, String bares, String restaurantes, String discotecas, String oferta_cultural, String centros_comerciales){
        this.ubicacion = ubicacion;
        this.cines = cines;
        this.bares = bares;
        this.restaurantes = restaurantes;
        this.discotecas = discotecas;
        this.oferta_cultural = oferta_cultural;
        this.centros_comerciales = centros_comerciales;
    }
}
