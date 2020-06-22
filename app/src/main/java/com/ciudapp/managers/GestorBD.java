package com.ciudapp.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.ciudapp.Splash.Splash;
import com.ciudapp.Utils.DataHolder;
import com.ciudapp.Utils.VotacionHabitabilidad;
import com.ciudapp.Utils.VotacionOcio;
import com.ciudapp.Utils.VotacionSeguridad;
import com.ciudapp.Utils.VotacionServicios;

import java.util.List;

import se.simbio.encryption.Encryption;

/**
 * Created by circegonzalezreyes on 8/6/16.
 */
public class GestorBD {

    private VotacionHabitabilidad votacionHabitabilidad;
    private VotacionOcio votacionOcio;
    private VotacionSeguridad votacionSeguridad;
    private VotacionServicios votacionServicios;
    private String ubicacion;
    private String cp;
    private String mac_encriptada;
    private SharedPreferences preferences;
    private Splash splash;


    public GestorBD(){

    }

    /**
     * registrar la MAC del dispositivo encriptada en la bd
     */
    public void registerDevice(CapturaMac capturaMac){
        String mac =  capturaMac.capturarMac();
        Encryption encryption = Encryption.getDefault("Key", "Salt", new byte[16]);
        String mac_encrypted = encryption.encryptOrNull(mac);
        DataHolder.getInstance().setDevice_mac(mac_encrypted);//almacenamos la mac encriptada
        //String mac_decrypted = encryption.decryptOrNull(mac_encrypted);
        //TODO falta codigo para almacenarla en la bd del servidor

    }

    /**
     * borrar datos de la bd interna
     */
    public void deleteRegistro(String ubicacion){

        List<VotacionHabitabilidad> lista_votaciones_habitabilidad = VotacionHabitabilidad.find(VotacionHabitabilidad.class, "UBICACION = ?", ubicacion);
        List<VotacionOcio> lista_votaciones_ocio = VotacionOcio.find(VotacionOcio.class, "UBICACION = ?", ubicacion);
        List<VotacionServicios> lista_votaciones_servicios = VotacionServicios.find(VotacionServicios.class, "UBICACION = ?", ubicacion);
        List<VotacionSeguridad> lista_votaciones_seguridad = VotacionSeguridad.find(VotacionSeguridad.class, "UBICACION = ?", ubicacion);

        if(lista_votaciones_habitabilidad.isEmpty()){

        }else{
            votacionHabitabilidad = lista_votaciones_habitabilidad.get(0);
            votacionHabitabilidad.delete();
        }

        if(lista_votaciones_ocio.isEmpty()){

        }else{
            votacionOcio = lista_votaciones_ocio.get(0);
            votacionOcio.delete();
        }

        if(lista_votaciones_servicios.isEmpty()){

        }else{
            votacionServicios = lista_votaciones_servicios.get(0);
            votacionServicios.delete();
        }

        if(lista_votaciones_seguridad.isEmpty()){

        }else{
            votacionSeguridad = lista_votaciones_seguridad.get(0);
            votacionSeguridad.delete();
        }

        //TODO falta codigo para almacenarla en la bd del servidor

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Ubicacion", DataHolder.getInstance().getUbicacion_usuario());
        editor.clear();
    }

    /**
     * cargar las votaciones de la bd interna
     */
    public void cargarVotaciones(String ubicacion){

        List<VotacionHabitabilidad> lista_votaciones_habitabilidad = VotacionHabitabilidad.find(VotacionHabitabilidad.class, "UBICACION = ?", ubicacion);
        List<VotacionOcio> lista_votaciones_ocio = VotacionOcio.find(VotacionOcio.class, "UBICACION = ?", ubicacion);
        List<VotacionServicios> lista_votaciones_servicios = VotacionServicios.find(VotacionServicios.class, "UBICACION = ?", ubicacion);
        List<VotacionSeguridad> lista_votaciones_seguridad = VotacionSeguridad.find(VotacionSeguridad.class, "UBICACION = ?", ubicacion);

        if(lista_votaciones_habitabilidad.isEmpty()){
            votacionHabitabilidad = new VotacionHabitabilidad(DataHolder.getInstance().getUbicacion_usuario(), DataHolder.getInstance().getHab_emitido1(),
                    DataHolder.getInstance().getHab_emitido2(), DataHolder.getInstance().getHab_emitido3(), DataHolder.getInstance().getHab_emitido4(), DataHolder.getInstance().getHab_emitido5(), DataHolder.getInstance().getHab_emitido6());
        }else{
            votacionHabitabilidad = lista_votaciones_habitabilidad.get(0);
            DataHolder.getInstance().setHab_emitido1(votacionHabitabilidad.zonas_infantiles);
            DataHolder.getInstance().setHab_emitido2(votacionHabitabilidad.trafico);
            DataHolder.getInstance().setHab_emitido3(votacionHabitabilidad.parques);
            DataHolder.getInstance().setHab_emitido4(votacionHabitabilidad.limpieza);
            DataHolder.getInstance().setHab_emitido5(votacionHabitabilidad.cesta_compra);
            DataHolder.getInstance().setHab_emitido6(votacionHabitabilidad.ruido);
        }

        if(lista_votaciones_ocio.isEmpty()){
            votacionOcio = new VotacionOcio(DataHolder.getInstance().getUbicacion_usuario(), DataHolder.getInstance().getOcio_emitido1(), DataHolder.getInstance().getOcio_emitido2(),
                    DataHolder.getInstance().getOcio_emitido3(), DataHolder.getInstance().getOcio_emitido4(), DataHolder.getInstance().getOcio_emitido5(), DataHolder.getInstance().getOcio_emitido6());
        }else{
            votacionOcio = lista_votaciones_ocio.get(0);
            DataHolder.getInstance().setOcio_emitido1(votacionOcio.cines);
            DataHolder.getInstance().setOcio_emitido2(votacionOcio.bares);
            DataHolder.getInstance().setOcio_emitido3(votacionOcio.restaurantes);
            DataHolder.getInstance().setOcio_emitido4(votacionOcio.discotecas);
            DataHolder.getInstance().setOcio_emitido5(votacionOcio.oferta_cultural);
            DataHolder.getInstance().setOcio_emitido6(votacionOcio.centros_comerciales);
        }

        if(lista_votaciones_servicios.isEmpty()){
            votacionServicios = new VotacionServicios(DataHolder.getInstance().getUbicacion_usuario(), DataHolder.getInstance().getSer_emitido1(), DataHolder.getInstance().getSer_emitido2(),
                    DataHolder.getInstance().getSer_emitido3(), DataHolder.getInstance().getSer_emitido4(), DataHolder.getInstance().getSer_emitido5(), DataHolder.getInstance().getSer_emitido6());
        }else{
            votacionServicios = lista_votaciones_servicios.get(0);
            DataHolder.getInstance().setSer_emitido1(votacionServicios.aparcamiento);
            DataHolder.getInstance().setSer_emitido2(votacionServicios.policia);
            DataHolder.getInstance().setSer_emitido3(votacionServicios.atencion_sanitaria);
            DataHolder.getInstance().setSer_emitido4(votacionServicios.colegios);
            DataHolder.getInstance().setSer_emitido5(votacionServicios.transporte_publico);
            DataHolder.getInstance().setSer_emitido6(votacionServicios.bibliotecas);

        }

        if(lista_votaciones_seguridad.isEmpty()){
            votacionSeguridad = new VotacionSeguridad(DataHolder.getInstance().getUbicacion_usuario(), DataHolder.getInstance().getSeg_emitido1(), DataHolder.getInstance().getSeg_emitido2(),
                    DataHolder.getInstance().getSeg_emitido3(), DataHolder.getInstance().getSeg_emitido4(), DataHolder.getInstance().getSeg_emitido5());
        }else{
            votacionSeguridad = lista_votaciones_seguridad.get(0);
            DataHolder.getInstance().setSeg_emitido1(votacionSeguridad.drogas);
            DataHolder.getInstance().setSeg_emitido2(votacionSeguridad.altercados);
            DataHolder.getInstance().setSeg_emitido3(votacionSeguridad.prostitucion);
            DataHolder.getInstance().setSeg_emitido4(votacionSeguridad.robos);
            DataHolder.getInstance().setSeg_emitido5(votacionSeguridad.otros);
        }

        //TODO falta codigo para almacenarla en la bd del servidor

    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getMac_encriptada() {
        return mac_encriptada;
    }

    public void setMac_encriptada(String mac_encriptada) {
        this.mac_encriptada = mac_encriptada;
    }

    public VotacionHabitabilidad getVotacionHabitabilidad() {
        return votacionHabitabilidad;
    }

    public void setVotacionHabitabilidad(VotacionHabitabilidad votacionHabitabilidad) {
        this.votacionHabitabilidad = votacionHabitabilidad;
    }

    public VotacionOcio getVotacionOcio() {
        return votacionOcio;
    }

    public void setVotacionOcio(VotacionOcio votacionOcio) {
        this.votacionOcio = votacionOcio;
    }

    public VotacionSeguridad getVotacionSeguridad() {
        return votacionSeguridad;
    }

    public void setVotacionSeguridad(VotacionSeguridad votacionSeguridad) {
        this.votacionSeguridad = votacionSeguridad;
    }

    public VotacionServicios getVotacionServicios() {
        return votacionServicios;
    }

    public void setVotacionServicios(VotacionServicios votacionServicios) {
        this.votacionServicios = votacionServicios;
    }

    public Splash getSplash() {
        return splash;
    }

    public void setSplash(Splash splash) {
        this.splash = splash;
    }
}
