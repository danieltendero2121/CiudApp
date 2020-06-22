package com.ciudapp.managers.Listeners;

import android.content.Intent;
import android.view.View;

import com.ciudapp.views.MainActivity;
import com.ciudapp.views.WebActivity;

/**
 * Created by circegonzalezreyes on 10/12/15.
 */
public class ListenWeb implements View.OnClickListener {
    /*
    variables
     */
    private WebActivity webActivity;

    /**
     * constructor
     * @param webActivity
     */
    public ListenWeb(WebActivity webActivity){
        this.webActivity = webActivity;
    }
    @Override
    public void onClick(View v) {

    }


}
