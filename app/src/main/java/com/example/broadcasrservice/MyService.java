package com.example.broadcasrservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.widget.Button;

public class MyService extends Service {


    private MediaPlayer mediaPlayer;
   @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

         mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
         //MediaStore class

        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
