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

    VideoView videoViewO79;
    String videoPathO79;
    Uri uriO79;
    ImageButton backbtnO79,nextbtnO79;
    MediaController mediaController;
    MediaPlayer sfx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_obedience);
        
        videoViewO79 = findViewById(R.id.videoO79);
        backbtnO79 = findViewById(R.id.btnbackO79);
        nextbtnO79 = findViewById(R.id.nextbtnO79);

        mediaController = new MediaController(this);
        videoViewO79.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewO79);
        
        BackgroundSoundService.onPause();

        obedience1();
    }

    public void obedience1(){
        videoPathO79 = "android.resource://" + getPackageName() + "/" + R.raw.obedience1;
        uriO79 = Uri.parse(videoPathO79);
        videoViewO79.setVideoURI(uriO79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO79.start();
                
            }
        });

        videoViewO79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO79.stopPlayback();
                obedience2();

            }
        });

        backbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                startActivity(new Intent(LessonObedience.this,ChooseModeObedience.class));

            }
        });

        nextbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience2();

            }
        });
    }

    public void obedience2(){
        videoPathO79 = "android.resource://" + getPackageName() + "/" + R.raw.obedience2;
        uriO79 = Uri.parse(videoPathO79);
        videoViewO79.setVideoURI(uriO79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO79.start();
                
            }
        });

        videoViewO79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO79.stopPlayback();
                obedience3();

            }
        });

        backbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience1();

            }
        });

        nextbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience3();

            }
        });
    }

    public void obedience3(){
        videoPathO79 = "android.resource://" + getPackageName() + "/" + R.raw.obedience3;
        uriO79 = Uri.parse(videoPathO79);
        videoViewO79.setVideoURI(uriO79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO79.start();
                
            }
        });

        videoViewO79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO79.stopPlayback();
                obedience4();

            }
        });

        backbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience2();

            }
        });

        nextbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience4();

            }
        });
    }

    public void obedience4(){
        videoPathO79 = "android.resource://" + getPackageName() + "/" + R.raw.obedience4;
        uriO79 = Uri.parse(videoPathO79);
        videoViewO79.setVideoURI(uriO79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO79.start();
                
            }
        });

        videoViewO79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO79.stopPlayback();
                obedience5();

            }
        });

        backbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience3();

            }
        });

        nextbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience5();

            }
        });
    }

    public void obedience5(){
        videoPathO79 = "android.resource://" + getPackageName() + "/" + R.raw.obedience5;
        uriO79 = Uri.parse(videoPathO79);
        videoViewO79.setVideoURI(uriO79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO79.start();
                
            }
        });

        videoViewO79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO79.stopPlayback();
                obedience6();

            }
        });

        backbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience4();

            }
        });

        nextbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience6();

            }
        });
    }

    public void obedience6(){
        videoPathO79 = "android.resource://" + getPackageName() + "/" + R.raw.obedience6;
        uriO79 = Uri.parse(videoPathO79);
        videoViewO79.setVideoURI(uriO79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO79.start();
                
            }
        });

        videoViewO79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO79.stopPlayback();
                obedience7();

            }
        });

        backbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience5();

            }
        });

        nextbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience7();

            }
        });
    }

    public void obedience7() {
        videoPathO79 = "android.resource://" + getPackageName() + "/" + R.raw.obedience7;
        uriO79 = Uri.parse(videoPathO79);
        videoViewO79.setVideoURI(uriO79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewO79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewO79.start();
                
            }
        });

        videoViewO79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO79.stopPlayback();
                startActivity(new Intent(LessonObedience.this, ObedienceLessonCongrats.class));

            }
        });

        backbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                obedience7();

            }
        });

        nextbtnO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewO79.stopPlayback();
                startActivity(new Intent(LessonObedience.this, ObedienceLessonCongrats.class));

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

        super.onUserLeaveHint();
    }
}