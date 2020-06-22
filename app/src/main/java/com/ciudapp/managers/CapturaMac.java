package com.ciudapp.managers;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.preference.Preference;
import android.text.TextUtils;

import com.ciudapp.R;

/**
 * Created by cgonzalez on 31/3/16.
 *
 * http://stackoverflow.com/questions/11705906/programmatically-getting-the-mac-of-an-android-device
 */
public class CapturaMac {
    /*
    variables
     */
    private WifiManager wifiManager;
    String myMac;
    Context context;

    /**
     * constructor
     */
    public CapturaMac(Context context){
        this.context = context;
    }

    /**
     * capturar la mac del dispositivo
     * @return
     */
    public String capturarMac(){
        wifiManager = (WifiManager)this.context.getSystemService(Context.WIFI_SERVICE);
        myMac = wifiManager.getConnectionInfo().getMacAddress();
        if(myMac == null){
            myMac = "Device don't have mac address or wi-fi is disabled";
        }else{
        }
        return myMac;
    }




}
