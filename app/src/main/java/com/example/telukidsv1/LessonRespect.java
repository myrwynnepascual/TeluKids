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

    VideoView videoViewRS;
    String videoPathRS;
    Uri uriRS;
    ImageButton backbtnRS,nextbtnRS;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewRS = findViewById(R.id.video);
        backbtnRS = findViewById(R.id.btnback);
        nextbtnRS = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewRS.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRS);

        BackgroundSoundService.onPause();

        respect1();
    }

    public void respect1(){
        videoPathRS = "android.resource://" + getPackageName() + "/" + R.raw.respect1;
        uriRS = Uri.parse(videoPathRS);
        videoViewRS.setVideoURI(uriRS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewRS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRS.start();

            }
        });

        videoViewRS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRS.stopPlayback();
                respect2();

            }
        });

        backbtnRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRS.stopPlayback();
                startActivity(new Intent(LessonRespect.this,ChooseModeRespect.class));

            }
        });

        nextbtnRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRS.stopPlayback();
                respect2();

            }
        });
    }

    public void respect2(){
        videoPathRS = "android.resource://" + getPackageName() + "/" + R.raw.respect2;
        uriRS = Uri.parse(videoPathRS);
        videoViewRS.setVideoURI(uriRS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewRS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRS.start();
                
            }
        });

        videoViewRS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRS.stopPlayback();
                respect3();

            }
        });

        backbtnRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRS.stopPlayback();
                respect1();

            }
        });

        nextbtnRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRS.stopPlayback();
                respect3();

            }
        });
    }

    public void respect3(){
        videoPathRS = "android.resource://" + getPackageName() + "/" + R.raw.respect3;
        uriRS = Uri.parse(videoPathRS);
        videoViewRS.setVideoURI(uriRS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewRS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRS.start();
                
            }
        });

        videoViewRS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRS.stopPlayback();
                respect4();

            }
        });

        backbtnRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRS.stopPlayback();
                respect2();

            }
        });

        nextbtnRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRS.stopPlayback();
                respect4();

            }
        });
    }

    public void respect4(){
        videoPathRS = "android.resource://" + getPackageName() + "/" + R.raw.respect4;
        uriRS = Uri.parse(videoPathRS);
        videoViewRS.setVideoURI(uriRS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewRS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewRS.start();
                
            }
        });

        videoViewRS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRS.stopPlayback();
                startActivity(new Intent(LessonRespect.this, RespectLessonCongrats.class));

            }
        });

        backbtnRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRS.stopPlayback();
                respect3();

            }
        });

        nextbtnRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewRS.stopPlayback();
                startActivity(new Intent(LessonRespect.this, RespectLessonCongrats.class));

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

        videoViewRS.pause();
        currentPosition = videoViewRS.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewRS.seekTo(currentPosition);
        videoViewRS.start();

        super.onResume();

    }
}