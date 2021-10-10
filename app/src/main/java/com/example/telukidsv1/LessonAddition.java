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

    VideoView videoViewAX = null;
    String videoPathAX;
    Uri uriAX;
    ImageButton backbtnAX,nextbtnAX;
    MediaController mediaController;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_addition);

        videoViewAX = findViewById(R.id.videoAX);
        backbtnAX = findViewById(R.id.btnbackAX);
        nextbtnAX = findViewById(R.id.nextbtnAX);

        mediaController = new MediaController(this);
        videoViewAX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewAX);

        BackgroundSoundService.onPause();

        additionx();
    }

    public void additionx(){

        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.additionx;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX); 

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                additiony();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                startActivity(new Intent(LessonAddition.this,ChooseModeAddition.class));

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                additiony();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void additiony(){

        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.additiony;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX); 

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                addition1();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                additionx();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition1();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void addition1(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition1;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                addition2();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                additionx();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition2();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void addition2(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition2;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX); 

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                addition3();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition1();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition3();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void addition3(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition3;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX); 

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                addition4();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition2();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition4();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void addition4(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition4;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX); 

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                addition5();
            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition3();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition5();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void addition5(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition5;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX); 

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                addition6();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition4();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition6();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void addition6(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition6;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX); 

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                addition7();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition5();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition7();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void addition7(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition7;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX); 

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                addition8();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition6();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition8();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void addition8(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition8;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX); 

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                addition9();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition7();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition9();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void addition9(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition9;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX); 

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                addition10();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition8();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition10();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void addition10(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition10;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX); 

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewAX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewAX.start();
            }
        });

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewAX.stopPlayback();
                startActivity(new Intent(LessonAddition.this,AdditionLessonCongrats.class));

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                addition9();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewAX.stopPlayback();
                startActivity(new Intent(LessonAddition.this,AdditionLessonCongrats.class));

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