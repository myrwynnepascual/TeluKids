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

public class LessonObedience extends AppCompatActivity {

    VideoView videoViewO;
    String videoPathO;
    Uri uriO;
    ImageButton backbtnO,nextbtnO;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        
        videoViewO = findViewById(R.id.video);
        backbtnO = findViewById(R.id.btnback);
        nextbtnO = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewO.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewO);
        
        BackgroundSoundService.onPause();

        obedience1();
    }

    public void obedience1(){
        videoPathO = "android.resource://" + getPackageName() + "/" + R.raw.obedience1;
        uriO = Uri.parse(videoPathO);
        videoViewO.setVideoURI(uriO);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO.start();
                
            }
        });

        videoViewO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO.stopPlayback();
                obedience2();

            }
        });

        backbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                startActivity(new Intent(LessonObedience.this,ChooseModeObedience.class));

            }
        });

        nextbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience2();

            }
        });
    }

    public void obedience2(){
        videoPathO = "android.resource://" + getPackageName() + "/" + R.raw.obedience2;
        uriO = Uri.parse(videoPathO);
        videoViewO.setVideoURI(uriO);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO.start();
                
            }
        });

        videoViewO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO.stopPlayback();
                obedience3();

            }
        });

        backbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience1();

            }
        });

        nextbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience3();

            }
        });
    }

    public void obedience3(){
        videoPathO = "android.resource://" + getPackageName() + "/" + R.raw.obedience3;
        uriO = Uri.parse(videoPathO);
        videoViewO.setVideoURI(uriO);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO.start();
                
            }
        });

        videoViewO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO.stopPlayback();
                obedience4();

            }
        });

        backbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience2();

            }
        });

        nextbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience4();

            }
        });
    }

    public void obedience4(){
        videoPathO = "android.resource://" + getPackageName() + "/" + R.raw.obedience4;
        uriO = Uri.parse(videoPathO);
        videoViewO.setVideoURI(uriO);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO.start();
                
            }
        });

        videoViewO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO.stopPlayback();
                obedience5();

            }
        });

        backbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience3();

            }
        });

        nextbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience5();

            }
        });
    }

    public void obedience5(){
        videoPathO = "android.resource://" + getPackageName() + "/" + R.raw.obedience5;
        uriO = Uri.parse(videoPathO);
        videoViewO.setVideoURI(uriO);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO.start();
                
            }
        });

        videoViewO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO.stopPlayback();
                obedience6();

            }
        });

        backbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience4();

            }
        });

        nextbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience6();

            }
        });
    }

    public void obedience6(){
        videoPathO = "android.resource://" + getPackageName() + "/" + R.raw.obedience6;
        uriO = Uri.parse(videoPathO);
        videoViewO.setVideoURI(uriO);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO.start();
                
            }
        });

        videoViewO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO.stopPlayback();
                obedience7();

            }
        });

        backbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience5();

            }
        });

        nextbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience7();

            }
        });
    }

    public void obedience7() {
        videoPathO = "android.resource://" + getPackageName() + "/" + R.raw.obedience7;
        uriO = Uri.parse(videoPathO);
        videoViewO.setVideoURI(uriO);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO.start();
                
            }
        });

        videoViewO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO.stopPlayback();
                startActivity(new Intent(LessonObedience.this, ObedienceLessonCongrats.class));

            }
        });

        backbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                obedience7();

            }
        });

        nextbtnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewO.stopPlayback();
                startActivity(new Intent(LessonObedience.this, ObedienceLessonCongrats.class));

            }
        });
    }

    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onUserLeaveHint(){

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.release();

            }
        });

        videoViewO.pause();
        currentPosition = videoViewO.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewO.seekTo(currentPosition);
        videoViewO.start();

        super.onResume();

    }
}