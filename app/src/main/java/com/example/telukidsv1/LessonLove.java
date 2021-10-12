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

public class LessonLove extends AppCompatActivity {

    VideoView videoViewL;
    String videoPathL;
    Uri uriL;
    ImageButton backbtnL,nextbtnL;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewL = findViewById(R.id.video);
        backbtnL = findViewById(R.id.btnback);
        nextbtnL = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewL.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewL);

        BackgroundSoundService.onPause();

        love1();
    }

    public void love1(){
        videoPathL = "android.resource://" + getPackageName() + "/" + R.raw.love1;
        uriL = Uri.parse(videoPathL);
        videoViewL.setVideoURI(uriL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewL.start();
                
            }
        });

        videoViewL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewL.stopPlayback();
                love2();

            }
        });

        backbtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewL.stopPlayback();
                startActivity(new Intent(LessonLove.this,ChooseModeLove.class));

            }
        });

        nextbtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewL.stopPlayback();
                love2();

            }
        });
    }

    public void love2(){
        videoPathL = "android.resource://" + getPackageName() + "/" + R.raw.love2;
        uriL = Uri.parse(videoPathL);
        videoViewL.setVideoURI(uriL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewL.start();
                
            }
        });

        videoViewL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewL.stopPlayback();
                love3();

            }
        });

        backbtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewL.stopPlayback();
                love1();

            }
        });

        nextbtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewL.stopPlayback();
                love3();

            }
        });
    }

    public void love3(){
        videoPathL = "android.resource://" + getPackageName() + "/" + R.raw.love3;
        uriL = Uri.parse(videoPathL);
        videoViewL.setVideoURI(uriL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewL.start();
                
            }
        });

        videoViewL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewL.stopPlayback();
                love4();

            }
        });

        backbtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewL.stopPlayback();
                love2();

            }
        });

        nextbtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewL.stopPlayback();
                love4();

            }
        });
    }

    public void love4(){
        videoPathL = "android.resource://" + getPackageName() + "/" + R.raw.love4;
        uriL = Uri.parse(videoPathL);
        videoViewL.setVideoURI(uriL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewL.start();
                
            }
        });

        videoViewL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewL.stopPlayback();
                love5();

            }
        });

        backbtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewL.stopPlayback();
                love3();

            }
        });

        nextbtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewL.stopPlayback();
                love5();

            }
        });
    }
    

    public void love5(){
        videoPathL = "android.resource://" + getPackageName() + "/" + R.raw.love5;
        uriL = Uri.parse(videoPathL);
        videoViewL.setVideoURI(uriL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewL.start();
                
            }
        });

        videoViewL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewL.stopPlayback();
                startActivity(new Intent(LessonLove.this, LoveLessonCongrats.class));

            }
        });

        backbtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewL.stopPlayback();
                love5();

            }
        });

        nextbtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewL.stopPlayback();
                startActivity(new Intent(LessonLove.this, LoveLessonCongrats.class));

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

        videoViewL.pause();
        currentPosition = videoViewL.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewL.seekTo(currentPosition);
        videoViewL.start();

        super.onResume();

    }
}