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

public class LessonHonesty extends AppCompatActivity {

    VideoView videoViewH;
    String videoPathH;
    Uri uriH;
    ImageButton backbtnH,nextbtnH;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewH = findViewById(R.id.video);
        backbtnH = findViewById(R.id.btnback);
        nextbtnH = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewH.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewH);

        BackgroundSoundService.onPause();

        honesty1();
    }

    public void honesty1(){
        videoPathH = "android.resource://" + getPackageName() + "/" + R.raw.honesty1;
        uriH = Uri.parse(videoPathH);
        videoViewH.setVideoURI(uriH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewH.start();
                
            }
        });

        videoViewH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewH.stopPlayback();
                honesty2();

            }
        });

        backbtnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewH.stopPlayback();
                startActivity(new Intent(LessonHonesty.this, ChooseModeHonesty.class));

            }
        });

        nextbtnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewH.stopPlayback();
                honesty2();

            }
        });
    }

    public void honesty2(){
        videoPathH = "android.resource://" + getPackageName() + "/" + R.raw.honesty2;
        uriH = Uri.parse(videoPathH);
        videoViewH.setVideoURI(uriH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewH.start();
                
            }
        });

        videoViewH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewH.stopPlayback();
                honesty3();

            }
        });

        backbtnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewH.stopPlayback();
                honesty1();

            }
        });

        nextbtnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewH.stopPlayback();
                honesty3();

            }
        });
    }

    public void honesty3(){
        videoPathH = "android.resource://" + getPackageName() + "/" + R.raw.honesty3;
        uriH = Uri.parse(videoPathH);
        videoViewH.setVideoURI(uriH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewH.start();
                
            }
        });

        videoViewH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewH.stopPlayback();
                honesty4();

            }
        });

        backbtnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewH.stopPlayback();
                honesty2();

            }
        });

        nextbtnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewH.stopPlayback();
                honesty4();

            }
        });
    }

    public void honesty4(){
        videoPathH = "android.resource://" + getPackageName() + "/" + R.raw.honesty4;
        uriH = Uri.parse(videoPathH);
        videoViewH.setVideoURI(uriH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewH.start();
                
            }
        });

        videoViewH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewH.stopPlayback();
                honesty5();

            }
        });

        backbtnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewH.stopPlayback();
                honesty3();

            }
        });

        nextbtnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewH.stopPlayback();
                honesty5();

            }
        });
    }

    public void honesty5(){
        videoPathH = "android.resource://" + getPackageName() + "/" + R.raw.honesty5;
        uriH = Uri.parse(videoPathH);
        videoViewH.setVideoURI(uriH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewH.start();
                
            }
        });

        videoViewH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewH.stopPlayback();
                startActivity(new Intent(LessonHonesty.this, HonestyLessonCongrats.class));

            }
        });

        backbtnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewH.stopPlayback();
                honesty4();

            }
        });

        nextbtnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewH.stopPlayback();
                startActivity(new Intent(LessonHonesty.this, HonestyLessonCongrats.class));

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

        videoViewH.pause();
        currentPosition = videoViewH.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewH.seekTo(currentPosition);
        videoViewH.start();

        super.onResume();

    }
}