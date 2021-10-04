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

public class LessonSubtraction extends AppCompatActivity {

    VideoView videoViewS;
    String videoPathS;
    Uri uriS;
    ImageButton backbtnS,nextbtnS;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_subtraction);

        videoViewS = findViewById(R.id.videoS);
        backbtnS = findViewById(R.id.btnbackS);
        nextbtnS = findViewById(R.id.nextbtnS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();

        subtractionx();
    }

    public void subtractionx(){

        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtractionx;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        mediaController = new MediaController(this);
        videoViewS.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewS);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                subtractiony();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LessonSubtraction.this,ChooseModeSubtraction.class));

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtractiony();

            }
        });
    }

    public void subtractiony(){

        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtractiony;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        mediaController = new MediaController(this);
        videoViewS.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewS);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                subtraction1();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LessonSubtraction.this,ChooseModeSubtraction.class));

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction1();

            }
        });
    }

    public void subtraction1(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction1;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                subtraction2();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtractionx();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction2();

            }
        });
    }

    public void subtraction2(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction2;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                subtraction3();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction1();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction3();

            }
        });
    }

    public void subtraction3(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction3;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                subtraction4();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction2();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction4();

            }
        });
    }

    public void subtraction4(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction4;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                subtraction5();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction3();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction5();

            }
        });
    }

    public void subtraction5(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction5;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                subtraction6();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction4();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction6();

            }
        });
    }

    public void subtraction6(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction6;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                subtraction7();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction5();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction7();

            }
        });
    }

    public void subtraction7(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction7;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                subtraction8();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction6();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction8();

            }
        });
    }

    public void subtraction8(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction8;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                subtraction9();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction7();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction9();

            }
        });
    }

    public void subtraction9(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction9;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                subtraction10();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction8();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction10();

            }
        });
    }

    public void subtraction10(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction10;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewS.start();

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonSubtraction.this,SubtractionLessonCongrats.class));

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                subtraction9();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LessonSubtraction.this,SubtractionLessonCongrats.class));

            }
        });
    }
}