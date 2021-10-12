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

public class LessonResponsibility extends AppCompatActivity {

    VideoView videoViewRP;
    String videoPathRP;
    Uri uriRP;
    ImageButton backbtnRP,nextbtnRP;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewRP = findViewById(R.id.video);
        backbtnRP = findViewById(R.id.btnback);
        nextbtnRP = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewRP.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRP);

        BackgroundSoundService.onPause();

        responsibility1();
    }

    public void responsibility1(){
        videoPathRP = "android.resource://" + getPackageName() + "/" + R.raw.responsibility1;
        uriRP = Uri.parse(videoPathRP);
        videoViewRP.setVideoURI(uriRP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewRP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewRP.start();
                
            }
        });

        videoViewRP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRP.stopPlayback();
                responsibility2();

            }
        });

        backbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                startActivity(new Intent(LessonResponsibility.this,ChooseModeResponsibility.class));

            }
        });

        nextbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility2();

            }
        });
    }

    public void responsibility2(){
        videoPathRP = "android.resource://" + getPackageName() + "/" + R.raw.responsibility2;
        uriRP = Uri.parse(videoPathRP);
        videoViewRP.setVideoURI(uriRP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewRP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewRP.start();
                
            }
        });

        videoViewRP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRP.stopPlayback();
                responsibility3();

            }
        });

        backbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility1();

            }
        });

        nextbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility3();

            }
        });
    }

    public void responsibility3(){
        videoPathRP = "android.resource://" + getPackageName() + "/" + R.raw.responsibility3;
        uriRP = Uri.parse(videoPathRP);
        videoViewRP.setVideoURI(uriRP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewRP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewRP.start();
                
            }
        });

        videoViewRP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRP.stopPlayback();
                responsibility4();

            }
        });

        backbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility2();

            }
        });

        nextbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility4();

            }
        });
    }

    public void responsibility4(){
        videoPathRP = "android.resource://" + getPackageName() + "/" + R.raw.responsibility4;
        uriRP = Uri.parse(videoPathRP);
        videoViewRP.setVideoURI(uriRP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewRP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewRP.start();
                
            }
        });

        videoViewRP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRP.stopPlayback();
                responsibility5();

            }
        });

        backbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility3();

            }
        });

        nextbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility5();

            }
        });
    }

    public void responsibility5(){
        videoPathRP = "android.resource://" + getPackageName() + "/" + R.raw.responsibility5;
        uriRP = Uri.parse(videoPathRP);
        videoViewRP.setVideoURI(uriRP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewRP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewRP.start();
                
            }
        });

        videoViewRP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRP.stopPlayback();
                responsibility6();

            }
        });

        backbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility4();

            }
        });

        nextbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility6();

            }
        });
    }

    public void responsibility6(){
        videoPathRP = "android.resource://" + getPackageName() + "/" + R.raw.responsibility6;
        uriRP = Uri.parse(videoPathRP);
        videoViewRP.setVideoURI(uriRP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewRP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewRP.start();
                
            }
        });

        videoViewRP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRP.stopPlayback();
                responsibility7();

            }
        });

        backbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility5();

            }
        });

        nextbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility7();

            }
        });
    }

    public void responsibility7(){
        videoPathRP = "android.resource://" + getPackageName() + "/" + R.raw.responsibility7;
        uriRP = Uri.parse(videoPathRP);
        videoViewRP.setVideoURI(uriRP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewRP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewRP.start();
                
            }
        });

        videoViewRP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRP.stopPlayback();
                responsibility8();

            }
        });

        backbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility6();

            }
        });

        nextbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility8();

            }
        });
    }

    public void responsibility8(){
        videoPathRP = "android.resource://" + getPackageName() + "/" + R.raw.responsibility8;
        uriRP = Uri.parse(videoPathRP);
        videoViewRP.setVideoURI(uriRP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewRP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewRP.start();
                
            }
        });

        videoViewRP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRP.stopPlayback();
                startActivity(new Intent(LessonResponsibility.this, ResponsibilityLessonCongrats.class));

            }
        });

        backbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                responsibility7();

            }
        });

        nextbtnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRP.stopPlayback();
                startActivity(new Intent(LessonResponsibility.this, ResponsibilityLessonCongrats.class));

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

        videoViewRP.pause();
        currentPosition = videoViewRP.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewRP.seekTo(currentPosition);
        videoViewRP.start();

        super.onResume();

    }
}