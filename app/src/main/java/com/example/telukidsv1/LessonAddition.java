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

public class LessonAddition extends AppCompatActivity {

    VideoView videoViewAD;
    String videoPathAD;
    Uri uriAD;
    ImageButton backbtnAD,nextbtnAD;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewAD = findViewById(R.id.video);
        backbtnAD = findViewById(R.id.btnback);
        nextbtnAD = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewAD.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewAD);

        BackgroundSoundService.onPause();

        additionx();

    }

    public void additionx(){

        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.additionx;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAD.start();
            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                additiony();

            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                startActivity(new Intent(LessonAddition.this,ChooseModeAddition.class));

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                additiony();

            }
        });

    }

    public void additiony(){

        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.additiony;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewAD.start();

            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                addition1();

            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                additionx();

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition1();

            }
        });

    }

    public void addition1(){
        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.addition1;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewAD.start();

            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                addition2();

            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                additionx();

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition2();

            }
        });

    }

    public void addition2(){
        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.addition2;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewAD.start();

            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                addition3();

            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition1();

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition3();

            }
        });

    }

    public void addition3(){
        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.addition3;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewAD.start();

            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                addition4();

            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition2();

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition4();

            }
        });

    }

    public void addition4(){
        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.addition4;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewAD.start();

            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                addition5();
            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition3();

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition5();

            }
        });

    }

    public void addition5(){
        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.addition5;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewAD.start();

            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                addition6();

            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewAD.stopPlayback();
                addition4();

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition6();

            }
        });

    }

    public void addition6(){
        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.addition6;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewAD.start();

            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                addition7();

            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition5();

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition7();

            }
        });

    }

    public void addition7(){
        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.addition7;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewAD.start();

            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                addition8();

            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition6();

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition8();

            }
        });

    }

    public void addition8(){
        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.addition8;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewAD.start();

            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                addition9();

            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition7();

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition9();

            }
        });

    }

    public void addition9(){
        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.addition9;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewAD.start();

            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                addition10();

            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition8();

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition10();

            }
        });

    }

    public void addition10(){
        videoPathAD = "android.resource://" + getPackageName() + "/" + R.raw.addition10;
        uriAD = Uri.parse(videoPathAD);
        videoViewAD.setVideoURI(uriAD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewAD.start();

            }
        });

        videoViewAD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAD.stopPlayback();
                startActivity(new Intent(LessonAddition.this,AdditionLessonCongrats.class));

            }
        });

        backbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                addition9();

            }
        });

        nextbtnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                sfx.start();

                videoViewAD.stopPlayback();
                startActivity(new Intent(LessonAddition.this,AdditionLessonCongrats.class));

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
        
        videoViewAD.pause();
        currentPosition = videoViewAD.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewAD.seekTo(currentPosition);
        videoViewAD.start();

        super.onResume();

    }


}