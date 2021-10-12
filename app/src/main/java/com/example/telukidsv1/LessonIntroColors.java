package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroColors extends AppCompatActivity {

    ImageButton btncloseIC;
    VideoView videoViewIC;
    String videoPathIC;
    Uri uriIC;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_vid);

        btncloseIC = findViewById(R.id.btncloseLIV);
        videoViewIC = findViewById(R.id.videoLIV);
        videoPathIC = "android.resource://" + getPackageName() + "/" + R.raw.colorsintrovideo;
        uriIC = Uri.parse(videoPathIC);
        videoViewIC.setVideoURI(uriIC);

        MediaController mediaController = new MediaController(this);
        videoViewIC.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIC);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();


        videoViewIC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewIC.start();

            }
        });

        btncloseIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewIC.stopPlayback();
                startActivity(new Intent(LessonIntroColors.this,ChooseModeColors.class));

            }
        });

        videoViewIC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewIC.stopPlayback();
                startActivity(new Intent(LessonIntroColors.this,ChooseModeColors.class));
            }
        });
    }

    @Override
    protected void onUserLeaveHint(){

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

        videoViewIC.pause();
        currentPosition = videoViewIC.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewIC.seekTo(currentPosition);
        videoViewIC.start();

        super.onResume();

    }
}