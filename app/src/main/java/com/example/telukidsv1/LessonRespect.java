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

public class LessonRespect extends AppCompatActivity {

    VideoView videoViewR36;
    String videoPathR36;
    Uri uriR36;
    ImageButton backbtnR36,nextbtnR36;
    MediaController mediaController;
    MediaPlayer sfx;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_respect);

        videoViewR36 = findViewById(R.id.videoR36);
        backbtnR36 = findViewById(R.id.btnbackR36);
        nextbtnR36 = findViewById(R.id.nextbtnR36);

        mediaController = new MediaController(this);
        videoViewR36.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewR36);

        BackgroundSoundService.onPause();

        respect1();
    }

    public void respect1(){
        videoPathR36 = "android.resource://" + getPackageName() + "/" + R.raw.respect1;
        uriR36 = Uri.parse(videoPathR36);
        videoViewR36.setVideoURI(uriR36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewR36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewR36.start();

            }
        });

        videoViewR36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewR36.stopPlayback();
                respect2();

            }
        });

        backbtnR36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewR36.stopPlayback();
                startActivity(new Intent(LessonRespect.this,ChooseModeRespect.class));

            }
        });

        nextbtnR36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewR36.stopPlayback();
                respect2();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void respect2(){
        videoPathR36 = "android.resource://" + getPackageName() + "/" + R.raw.respect2;
        uriR36 = Uri.parse(videoPathR36);
        videoViewR36.setVideoURI(uriR36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewR36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewR36.start();
                
            }
        });

        videoViewR36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewR36.stopPlayback();
                respect3();

            }
        });

        backbtnR36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewR36.stopPlayback();
                respect1();

            }
        });

        nextbtnR36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewR36.stopPlayback();
                respect3();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void respect3(){
        videoPathR36 = "android.resource://" + getPackageName() + "/" + R.raw.respect3;
        uriR36 = Uri.parse(videoPathR36);
        videoViewR36.setVideoURI(uriR36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewR36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewR36.start();
                
            }
        });

        videoViewR36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewR36.stopPlayback();
                respect4();

            }
        });

        backbtnR36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewR36.stopPlayback();
                respect2();

            }
        });

        nextbtnR36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewR36.stopPlayback();
                respect4();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void respect4(){
        videoPathR36 = "android.resource://" + getPackageName() + "/" + R.raw.respect4;
        uriR36 = Uri.parse(videoPathR36);
        videoViewR36.setVideoURI(uriR36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewR36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewR36.start();
                
            }
        });

        videoViewR36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewR36.stopPlayback();
                startActivity(new Intent(LessonRespect.this, RespectLessonCongrats.class));

            }
        });

        backbtnR36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewR36.stopPlayback();
                respect3();

            }
        });

        nextbtnR36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewR36.stopPlayback();
                startActivity(new Intent(LessonRespect.this, RespectLessonCongrats.class));

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }
}