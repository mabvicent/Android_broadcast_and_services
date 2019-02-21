package com.example.broadcasrservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {


        if(intent.getAction()==Intent.ACTION_POWER_CONNECTED){
            Toast.makeText(context,"POWER CONNECTED", Toast.LENGTH_LONG).show();
        }
        if(intent.getAction()==Intent.ACTION_POWER_DISCONNECTED){
            Toast.makeText(context,"POWER DISCONNECTED", Toast.LENGTH_SHORT).show();
        }
        if(intent.getAction()==Intent.ACTION_BATTERY_LOW){
            Toast.makeText(context,"BATTERY LOW",Toast.LENGTH_SHORT).show();
        }
        if(intent.getAction()==Intent.ACTION_BATTERY_OKAY){
            Toast.makeText(context,"BATTERY OKAY",Toast.LENGTH_SHORT).show();
        }
        if(intent.getAction()==Intent.ACTION_DEVICE_STORAGE_LOW){
            Toast.makeText(context,"DEVICE STORAGE LOW",Toast.LENGTH_SHORT).show();
        }
        if(intent.getAction()==Intent.ACTION_DEVICE_STORAGE_OK){
            Toast.makeText(context,"DEVICE STORAGE OK", Toast.LENGTH_SHORT).show();
        }
        if(intent.getAction()==Intent.ACTION_HEADSET_PLUG){
            Toast.makeText(context,"HEADSET CONNECTED", Toast.LENGTH_SHORT).show();
        }
        if(intent.getAction()== AudioManager.ACTION_AUDIO_BECOMING_NOISY){
            Toast.makeText(context,"AUDIO BECOMES NOISY",Toast.LENGTH_SHORT).show();
        }

    }
}
