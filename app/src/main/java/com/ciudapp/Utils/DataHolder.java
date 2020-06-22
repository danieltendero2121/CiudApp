package com.ciudapp.Utils;

/**
 * Created by cgonzalez on 24/5/16.
 */
public class DataHolder {

    private String ubicacion_usuario = "Galapagar";
    private String cp = "28260";
    private String idioma;
    private static final DataHolder holder = new DataHolder();
    private String pregunta;
    private String activity_origin;
    private String device_mac;
    private String hab_emitido1 = "0.00", hab_emitido2 = "0.00", hab_emitido3 = "0.00", hab_emitido4 = "0.00", hab_emitido5 = "0.00", hab_emitido6 = "0.00";
    private String ocio_emitido1 = "0.00", ocio_emitido2 = "0.00", ocio_emitido3 = "0.00", ocio_emitido4 = "0.00", ocio_emitido5 = "0.00", ocio_emitido6 = "0.00";
    private String ser_emitido1 = "0.00", ser_emitido2 = "0.00", ser_emitido3 = "0.00", ser_emitido4 = "0.00", ser_emitido5 = "0.00", ser_emitido6 = "0.00";
    private String seg_emitido1 = "0.00", seg_emitido2 = "0.00", seg_emitido3 = "0.00", seg_emitido4 = "0.00", seg_emitido5 = "0.00";

    /**
     * obtener instancia del dataHolder actual
     * @return
     */
    public static DataHolder getInstance() {
        return holder;
    }

    public String getUbicacion_usuario() {
        return ubicacion_usuario;
    }

    public void setUbicacion_usuario(String ubicacion_usuario) {
        this.ubicacion_usuario = ubicacion_usuario;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getActivity_origin() {
        return activity_origin;
    }

    public void setActivity_origin(String activity_origin) {
        this.activity_origin = activity_origin;
    }

    public String getHab_emitido1() {
        return hab_emitido1;
    }

    public void setHab_emitido1(String hab_emitido1) {
        this.hab_emitido1 = hab_emitido1;
    }

    public String getHab_emitido2() {
        return hab_emitido2;
    }

    public void setHab_emitido2(String hab_emitido2) {
        this.hab_emitido2 = hab_emitido2;
    }

    public String getHab_emitido3() {
        return hab_emitido3;
    }

    public void setHab_emitido3(String hab_emitido3) {
        this.hab_emitido3 = hab_emitido3;
    }

    public String getHab_emitido4() {
        return hab_emitido4;
    }

    public void setHab_emitido4(String hab_emitido4) {
        this.hab_emitido4 = hab_emitido4;
    }

    public String getHab_emitido5() {
        return hab_emitido5;
    }

    public void setHab_emitido5(String hab_emitido5) {
        this.hab_emitido5 = hab_emitido5;
    }

    public String getHab_emitido6() {
        return hab_emitido6;
    }

    public void setHab_emitido6(String hab_emitido6) {
        this.hab_emitido6 = hab_emitido6;
    }

    public String getOcio_emitido1() {
        return ocio_emitido1;
    }

    public void setOcio_emitido1(String ocio_emitido1) {
        this.ocio_emitido1 = ocio_emitido1;
    }

    public String getOcio_emitido2() {
        return ocio_emitido2;
    }

    public void setOcio_emitido2(String ocio_emitido2) {
        this.ocio_emitido2 = ocio_emitido2;
    }

    public String getOcio_emitido3() {
        return ocio_emitido3;
    }

    public void setOcio_emitido3(String ocio_emitido3) {
        this.ocio_emitido3 = ocio_emitido3;
    }

    public String getOcio_emitido4() {
        return ocio_emitido4;
    }

    public void setOcio_emitido4(String ocio_emitido4) {
        this.ocio_emitido4 = ocio_emitido4;
    }

    public String getOcio_emitido5() {
        return ocio_emitido5;
    }

    public void setOcio_emitido5(String ocio_emitido5) {
        this.ocio_emitido5 = ocio_emitido5;
    }

    public String getOcio_emitido6() {
        return ocio_emitido6;
    }

    public void setOcio_emitido6(String ocio_emitido6) {
        this.ocio_emitido6 = ocio_emitido6;
    }

    public String getSer_emitido1() {
        return ser_emitido1;
    }

    public void setSer_emitido1(String ser_emitido1) {
        this.ser_emitido1 = ser_emitido1;
    }

    public String getSer_emitido2() {
        return ser_emitido2;
    }

    public void setSer_emitido2(String ser_emitido2) {
        this.ser_emitido2 = ser_emitido2;
    }

    public String getSer_emitido3() {
        return ser_emitido3;
    }

    public void setSer_emitido3(String ser_emitido3) {
        this.ser_emitido3 = ser_emitido3;
    }

    public String getSer_emitido4() {
        return ser_emitido4;
    }

    public void setSer_emitido4(String ser_emitido4) {
        this.ser_emitido4 = ser_emitido4;
    }

    public String getSer_emitido5() {
        return ser_emitido5;
    }

    public void setSer_emitido5(String ser_emitido5) {
        this.ser_emitido5 = ser_emitido5;
    }

    public String getSer_emitido6() {
        return ser_emitido6;
    }

    public void setSer_emitido6(String ser_emitido6) {
        this.ser_emitido6 = ser_emitido6;
    }

    public String getSeg_emitido1() {
        return seg_emitido1;
    }

    public void setSeg_emitido1(String seg_emitido1) {
        this.seg_emitido1 = seg_emitido1;
    }

    public String getSeg_emitido2() {
        return seg_emitido2;
    }

    public void setSeg_emitido2(String seg_emitido2) {
        this.seg_emitido2 = seg_emitido2;
    }

    public String getSeg_emitido3() {
        return seg_emitido3;
    }

    public void setSeg_emitido3(String seg_emitido3) {
        this.seg_emitido3 = seg_emitido3;
    }

    public String getSeg_emitido4() {
        return seg_emitido4;
    }

    public void setSeg_emitido4(String seg_emitido4) {
        this.seg_emitido4 = seg_emitido4;
    }

    public String getSeg_emitido5() {
        return seg_emitido5;
    }

    public void setSeg_emitido5(String seg_emitido5) {
        this.seg_emitido5 = seg_emitido5;
    }

    public String getDevice_mac() {
        return device_mac;
    }

    public void setDevice_mac(String device_mac) {
        this.device_mac = device_mac;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
