package com.ciudapp.Utils;

import com.orm.SugarRecord;
/**
 * Created by cgonzalez on 6/6/16.
 */
public class VotacionHabitabilidad extends SugarRecord{
    //siempre públicas
    public String ubicacion;
    public String zonas_infantiles;
    public String trafico;
    public String parques;
    public String limpieza;
    public String cesta_compra;
    public String ruido;

    public VotacionHabitabilidad(){
        //dejar vacío
    }

    public VotacionHabitabilidad(String ubicacion, String zonas_infantiles, String trafico, String parques, String limpieza, String cesta_compra, String ruido){
        this.ubicacion = ubicacion;
        this.zonas_infantiles = zonas_infantiles;
        this.trafico = trafico;
        this.parques = parques;
        this.limpieza = limpieza;
        this.cesta_compra = cesta_compra;
        this.ruido = ruido;
    }
}
