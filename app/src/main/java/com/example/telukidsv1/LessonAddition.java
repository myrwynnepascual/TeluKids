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

    VideoView videoViewAX;
    String videoPathAX;
    Uri uriAX;
    ImageButton backbtnAX,nextbtnAX;
    MediaController mediaController;

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

        additionx();
    }

    public void additionx(){

        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.additionx;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                additiony();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonAddition.this,ChooseModeAddition.class));

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                additiony();

            }
        });
    }

    public void additiony(){

        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.additiony;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                addition1();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                additionx();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition1();

            }
        });
    }

    public void addition1(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition1;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                addition2();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                additionx();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition2();

            }
        });
    }

    public void addition2(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition2;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                addition3();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition1();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition3();

            }
        });
    }

    public void addition3(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition3;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                addition4();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition2();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition4();

            }
        });
    }

    public void addition4(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition4;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                addition5();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition3();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition5();

            }
        });
    }

    public void addition5(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition5;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                addition6();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition4();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition6();

            }
        });
    }

    public void addition6(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition6;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                addition7();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition5();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition7();

            }
        });
    }

    public void addition7(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition7;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                addition8();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition6();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition8();

            }
        });
    }

    public void addition8(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition8;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                addition9();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition7();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition9();

            }
        });
    }

    public void addition9(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition9;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                addition10();

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition8();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition10();

            }
        });
    }

    public void addition10(){
        videoPathAX = "android.resource://" + getPackageName() + "/" + R.raw.addition10;
        uriAX = Uri.parse(videoPathAX);
        videoViewAX.setVideoURI(uriAX);

        videoViewAX.start();

        videoViewAX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonAddition.this,AdditionLessonCongrats.class));

            }
        });

        backbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addition9();

            }
        });

        nextbtnAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonAddition.this,AdditionLessonCongrats.class));

            }
        });
    }
}