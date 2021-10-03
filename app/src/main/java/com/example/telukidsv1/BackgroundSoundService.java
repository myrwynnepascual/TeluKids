package com.example.telukidsv1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    public static MediaPlayer player;
    public static int length;
    //MediaPlayer player;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.bgmusic1);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return START_STICKY;
    }

    public void onStart(Intent intent, int startId) {
        // TO DO
    }
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public static void lowerVolume() {
        player.setVolume(10,10);
    }

    public static void onPause() {
        player.pause();
        length = player.getCurrentPosition();
    }

    public static void onResume(){
        player.seekTo(length);
        player.start();
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }
}
