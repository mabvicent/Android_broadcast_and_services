package com.example.broadcasrservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Switch wifiSwitch;
    private WifiManager wifiManager;
    Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiSwitch = findViewById(R.id.wifi_switch);;

        start = findViewById(R.id.start_service);
        stop = findViewById(R.id.stop_service);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);



        wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    wifiManager.setWifiEnabled(true);
                    wifiSwitch.setText("WiFi is on.............");
                }else {
                    wifiManager.setWifiEnabled(false);
                    wifiSwitch.setText("Hoops WiFi is off!");
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);

        registerReceiver(wifiStateReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
    }

    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifeStateExtract = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifeStateExtract){
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiManager.setWifiEnabled(true);
                    wifiSwitch.setText("WiFi is on.............");
            break;
            case WifiManager.WIFI_STATE_DISABLED:
                wifiManager.setWifiEnabled(false);
                wifiSwitch.setText("WiFi is off");


            }

        }
    };

    @Override
    public void onClick(View v) {

        if(v==start){

            startService(new Intent(this,MyService.class));

        }else if(v==stop){
            stopService(new Intent(this,MyService.class));



        }

    }
}
