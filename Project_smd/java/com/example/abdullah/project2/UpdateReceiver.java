package com.example.abdullah.project2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class UpdateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager cm =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo()==null){
            Toast.makeText(context, "Internet Disconnected", Toast.LENGTH_LONG).show();
        }
        else Log.i("INTERNET","---------------------> Internet Disconnected. ");
    }


}
