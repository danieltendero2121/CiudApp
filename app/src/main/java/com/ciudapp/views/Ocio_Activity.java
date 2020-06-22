package com.ciudapp.views;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ciudapp.R;
import com.ciudapp.Utils.DataHolder;
import com.ciudapp.Utils.VotacionHabitabilidad;
import com.ciudapp.Utils.VotacionOcio;
import com.ciudapp.managers.Listeners.ListenOcio;

import java.util.List;


public class Ocio_Activity extends AppCompatActivity {

    @InjectView(R.id.textViewTitulo)TextView textViewTitulo;
    @InjectView(R.id.button_pregunta1)Button button_pregunta1;
    @InjectView(R.id.button_pregunta2)Button button_pregunta2;
    @InjectView(R.id.button_pregunta3)Button button_pregunta3;
    @InjectView(R.id.button_pregunta4)Button button_pregunta4;
    @InjectView(R.id.button_pregunta5)Button button_pregunta5;
    @InjectView(R.id.button_pregunta6)Button button_pregunta6;
    @InjectView(R.id.emitido1)TextView emitido1;
    @InjectView(R.id.emitido2)TextView emitido2;
    @InjectView(R.id.emitido3)TextView emitido3;
    @InjectView(R.id.emitido4)TextView emitido4;
    @InjectView(R.id.emitido5)TextView emitido5;
    @InjectView(R.id.emitido6)TextView emitido6;
    @InjectView(R.id.total1)TextView total1;
    @InjectView(R.id.total2)TextView total2;
    @InjectView(R.id.total3)TextView total3;
    @InjectView(R.id.total4)TextView total4;
    @InjectView(R.id.total5)TextView total5;
    @InjectView(R.id.total6)TextView total6;
    @InjectView(R.id.buttonWeb) Button buttonWeb;
    @InjectView(R.id.container_habitabilidad) RelativeLayout container_habitabilidad;
    @InjectView(R.id.container_ocio) RelativeLayout container_ocio;
    @InjectView(R.id.container_servicios) RelativeLayout container_servicios;
    @InjectView(R.id.container_seguridad) RelativeLayout container_seguridad;

    private ListenOcio listenOcio;
    Dialog dialogo = null;
    private boolean seleccionable = false;
    private VotacionOcio votacion_ocio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocio_);
        ButterKnife.inject(this);

        listenOcio = new ListenOcio(this, getApplicationContext());
        button_pregunta1.setOnClickListener(listenOcio);
        button_pregunta2.setOnClickListener(listenOcio);
        button_pregunta3.setOnClickListener(listenOcio);
        button_pregunta4.setOnClickListener(listenOcio);
        button_pregunta5.setOnClickListener(listenOcio);
        button_pregunta6.setOnClickListener(listenOcio);

        buttonWeb.setOnClickListener(listenOcio);
        buttonWeb.setBackgroundResource(R.drawable.button_color_ocio);
        buttonWeb.setTextColor(getResources().getColor(R.color.white));

        container_habitabilidad.setOnClickListener(listenOcio);
        container_ocio.setOnClickListener(listenOcio);
        container_servicios.setOnClickListener(listenOcio);
        container_seguridad.setOnClickListener(listenOcio);
        DataHolder.getInstance().setActivity_origin("ocio");

        emitido1.setText("Tu voto : " + DataHolder.getInstance().getOcio_emitido1());
        emitido2.setText("Tu voto : " + DataHolder.getInstance().getOcio_emitido2());
        emitido3.setText("Tu voto : " + DataHolder.getInstance().getOcio_emitido3());
        emitido4.setText("Tu voto : " + DataHolder.getInstance().getOcio_emitido4());
        emitido5.setText("Tu voto : " + DataHolder.getInstance().getOcio_emitido5());
        emitido6.setText("Tu voto : " + DataHolder.getInstance().getOcio_emitido6());


    }

    /**
     * mostrar diálogo de pregunta
     * @param pregunta
     */
    public void showDialog(String pregunta, final int numero){
        final String[] voto = new String[1];
        dialogo = new Dialog(this, R.style.Theme_Dialog_Translucent);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(true);
        dialogo.setContentView(R.layout.dialogo_pregunta);

        TextView textView = (TextView)dialogo.findViewById(R.id.text_dialogo);
        textView.setText(pregunta);
        final Button button = (Button)dialogo.findViewById(R.id.button_dialogo);
        button.setBackgroundResource(R.drawable.button_transparente_ocio);
        button.setTextColor(getResources().getColor(R.color.ocio));
        button.setClickable(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seleccionable == true){
                    dialogo.dismiss();
                }else{

                }

            }
        });
        RatingBar ratingBar = (RatingBar)dialogo.findViewById(R.id.ratingBar_dialogo);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                button.setBackgroundResource(R.drawable.button_color_ocio);
                button.setTextColor(getResources().getColor(R.color.white));
                voto[0] = Float.toString(rating*2);
                seleccionable = true;
                switch (numero){
                    case 1:
                        getEmitido1().setText("Tu voto: "+voto[0]);
                        DataHolder.getInstance().setOcio_emitido1(voto[0]);
                        //TODO almacenar en bd del servidor
                        guardarVotaciones(DataHolder.getInstance().getUbicacion_usuario(), 1, voto[0]);
                        break;
                    case 2:
                        getEmitido2().setText("Tu voto: "+voto[0]);
                        DataHolder.getInstance().setOcio_emitido2(voto[0]);
                        //TODO almacenar en bd del servidor
                        guardarVotaciones(DataHolder.getInstance().getUbicacion_usuario(), 2, voto[0]);
                        break;
                    case 3:
                        getEmitido3().setText("Tu voto: "+voto[0]);
                        DataHolder.getInstance().setOcio_emitido3(voto[0]);
                        //TODO almacenar en bd del servidor
                        guardarVotaciones(DataHolder.getInstance().getUbicacion_usuario(), 3, voto[0]);
                        break;
                    case 4:
                        getEmitido4().setText("Tu voto: "+voto[0]);
                        DataHolder.getInstance().setOcio_emitido4(voto[0]);
                        //TODO almacenar en bd del servidor
                        guardarVotaciones(DataHolder.getInstance().getUbicacion_usuario(), 4, voto[0]);
                        break;
                    case 5:
                        getEmitido5().setText("Tu voto: "+voto[0]);
                        DataHolder.getInstance().setOcio_emitido5(voto[0]);
                        //TODO almacenar en bd del servidor
                        guardarVotaciones(DataHolder.getInstance().getUbicacion_usuario(), 5, voto[0]);
                        break;
                    case 6:
                        getEmitido6().setText("Tu voto: "+voto[0]);
                        DataHolder.getInstance().setOcio_emitido6(voto[0]);
                        //TODO almacenar en bd del servidor
                        guardarVotaciones(DataHolder.getInstance().getUbicacion_usuario(), 6, voto[0]);
                        break;
                }
            }
        });

        dialogo.show();
    }


    /**
     * almacenar en bd interna las votaciones del usuario
     * @param ubicacion
     */
    public void guardarVotaciones(String ubicacion, int pregunta, String voto){
        List<VotacionOcio> lista_votaciones = VotacionOcio.find(VotacionOcio.class, "UBICACION = ?", ubicacion);

        if(lista_votaciones.isEmpty()){
            votacion_ocio = new VotacionOcio(DataHolder.getInstance().getUbicacion_usuario(), DataHolder.getInstance().getOcio_emitido1(), DataHolder.getInstance().getOcio_emitido2(),
                    DataHolder.getInstance().getOcio_emitido3(), DataHolder.getInstance().getOcio_emitido4(), DataHolder.getInstance().getOcio_emitido5(), DataHolder.getInstance().getOcio_emitido6());
        }else{
            votacion_ocio = lista_votaciones.get(0);
        }

        switch (pregunta){
            case 1:
                votacion_ocio.cines = voto;
                break;
            case 2:
                votacion_ocio.bares = voto;
                break;
            case 3:
                votacion_ocio.restaurantes = voto;
                break;
            case 4:
                votacion_ocio.discotecas = voto;
                break;
            case 5:
                votacion_ocio.oferta_cultural = voto;
                break;
            case 6:
                votacion_ocio.centros_comerciales = voto;
                break;
        }
        votacion_ocio.save();
    }

    public TextView getTextViewTitulo() {
        return textViewTitulo;
    }

    public void setTextViewTitulo(TextView textViewTitulo) {
        this.textViewTitulo = textViewTitulo;
    }

    public Button getButton_pregunta1() {
        return button_pregunta1;
    }

    public void setButton_pregunta1(Button button_pregunta1) {
        this.button_pregunta1 = button_pregunta1;
    }

    public Button getButton_pregunta2() {
        return button_pregunta2;
    }

    public void setButton_pregunta2(Button button_pregunta2) {
        this.button_pregunta2 = button_pregunta2;
    }

    public Button getButton_pregunta3() {
        return button_pregunta3;
    }

    public void setButton_pregunta3(Button button_pregunta3) {
        this.button_pregunta3 = button_pregunta3;
    }

    public Button getButton_pregunta4() {
        return button_pregunta4;
    }

    public void setButton_pregunta4(Button button_pregunta4) {
        this.button_pregunta4 = button_pregunta4;
    }

    public Button getButton_pregunta5() {
        return button_pregunta5;
    }

    public void setButton_pregunta5(Button button_pregunta5) {
        this.button_pregunta5 = button_pregunta5;
    }

    public Button getButton_pregunta6() {
        return button_pregunta6;
    }

    public void setButton_pregunta6(Button button_pregunta6) {
        this.button_pregunta6 = button_pregunta6;
    }

    public Button getButtonWeb() {
        return buttonWeb;
    }

    public void setButtonWeb(Button buttonWeb) {
        this.buttonWeb = buttonWeb;
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

    public TextView getEmitido1() {
        return emitido1;
    }

    public void setEmitido1(TextView emitido1) {
        this.emitido1 = emitido1;
    }

    public TextView getEmitido2() {
        return emitido2;
    }

    public void setEmitido2(TextView emitido2) {
        this.emitido2 = emitido2;
    }

    public TextView getEmitido3() {
        return emitido3;
    }

    public void setEmitido3(TextView emitido3) {
        this.emitido3 = emitido3;
    }

    public TextView getEmitido4() {
        return emitido4;
    }

    public void setEmitido4(TextView emitido4) {
        this.emitido4 = emitido4;
    }

    public TextView getEmitido5() {
        return emitido5;
    }

    public void setEmitido5(TextView emitido5) {
        this.emitido5 = emitido5;
    }

    public TextView getEmitido6() {
        return emitido6;
    }

    public void setEmitido6(TextView emitido6) {
        this.emitido6 = emitido6;
    }
}
