package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonCompassion extends AppCompatActivity {

    VideoView videoViewCP36;
    String videoPathCP36;
    Uri uriCP36;
    ImageButton backbtnCP36,nextbtnCP36;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_compassion);

        videoViewCP36 = findViewById(R.id.videoCP36);
        backbtnCP36 = findViewById(R.id.btnbackCP36);
        nextbtnCP36 = findViewById(R.id.nextbtnCP36);

        mediaController = new MediaController(this);
        videoViewCP36.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCP36);

        BackgroundSoundService.onPause();

        compassion1();
    }

    public void compassion1(){
        videoPathCP36 = "android.resource://" + getPackageName() + "/" + R.raw.compassion1;
        uriCP36 = Uri.parse(videoPathCP36);
        videoViewCP36.setVideoURI(uriCP36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCP36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                sfx.start();
                videoViewCP36.start();

            }
        });

        videoViewCP36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCP36.stopPlayback();
                compassion2();

            }
        });

        backbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewCP36.stopPlayback();
                startActivity(new Intent(LessonCompassion.this, ChooseModeCompassion.class));

            }
        });

        nextbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewCP36.stopPlayback();
                compassion2();

            }
        });

    }

    public void compassion2(){
        videoPathCP36 = "android.resource://" + getPackageName() + "/" + R.raw.compassion2;
        uriCP36 = Uri.parse(videoPathCP36);
        videoViewCP36.setVideoURI(uriCP36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCP36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                sfx.start();

                videoViewCP36.start();

            }
        });

        videoViewCP36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCP36.stopPlayback();
                compassion3();

            }
        });

        backbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCP36.stopPlayback();
                compassion1();

            }
        });

        nextbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCP36.stopPlayback();
                compassion3();

            }
        });
    }

    public void compassion3(){
        videoPathCP36 = "android.resource://" + getPackageName() + "/" + R.raw.compassion3;
        uriCP36 = Uri.parse(videoPathCP36);
        videoViewCP36.setVideoURI(uriCP36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCP36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                sfx.start();

                videoViewCP36.start();

            }
        });

        videoViewCP36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCP36.stopPlayback();
                compassion4();

            }
        });

        backbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCP36.stopPlayback();
                compassion2();

            }
        });

        nextbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewCP36.stopPlayback();
                compassion4();

            }
        });
    }

    public void compassion4(){
        videoPathCP36 = "android.resource://" + getPackageName() + "/" + R.raw.compassion4;
        uriCP36 = Uri.parse(videoPathCP36);
        videoViewCP36.setVideoURI(uriCP36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCP36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                sfx.start();

                videoViewCP36.start();

            }
        });

        videoViewCP36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCP36.stopPlayback();
                compassion5();

            }
        });

        backbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewCP36.stopPlayback();
                compassion3();

            }
        });

        nextbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewCP36.stopPlayback();
                compassion5();

            }
        });
    }

    public void compassion5(){
        videoPathCP36 = "android.resource://" + getPackageName() + "/" + R.raw.compassion5;
        uriCP36 = Uri.parse(videoPathCP36);
        videoViewCP36.setVideoURI(uriCP36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCP36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                sfx.start();

                videoViewCP36.start();
                
            }
        });

        videoViewCP36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCP36.stopPlayback();
                startActivity(new Intent(LessonCompassion.this, CompassionLessonCongrats.class));

            }
        });

        backbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewCP36.stopPlayback();
                compassion4();

            }
        });

        nextbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewCP36.stopPlayback();
                startActivity(new Intent(LessonCompassion.this, CompassionLessonCongrats.class));

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

        videoViewCP36.pause();
        currentPosition = videoViewCP36.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewCP36.seekTo(currentPosition);
        videoViewCP36.start();

        super.onResume();

    }
}