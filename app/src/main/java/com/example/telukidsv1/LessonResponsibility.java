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

public class LessonResponsibility extends AppCompatActivity {

    VideoView videoViewRP79;
    String videoPathRP79;
    Uri uriRP79;
    ImageButton backbtnRP79,nextbtnRP79;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_responsibility);

        videoViewRP79 = findViewById(R.id.videoRP79);
        backbtnRP79 = findViewById(R.id.btnbackRP79);
        nextbtnRP79 = findViewById(R.id.nextbtnRP79);

        mediaController = new MediaController(this);
        videoViewRP79.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRP79);

        responsibility1();
    }

    public void responsibility1(){
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.responsibility1;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                responsibility2();

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonResponsibility.this,ChooseModeResponsibility.class));

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility2();

            }
        });
    }

    public void responsibility2(){
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.responsibility2;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                responsibility3();

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility1();

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility3();

            }
        });
    }

    public void responsibility3(){
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.responsibility3;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                responsibility4();

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility2();

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility4();

            }
        });
    }

    public void responsibility4(){
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.responsibility4;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                responsibility5();

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility3();

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility5();

            }
        });
    }

    public void responsibility5(){
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.responsibility5;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                responsibility6();

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility4();

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility6();

            }
        });
    }

    public void responsibility6(){
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.responsibility6;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                responsibility7();

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility5();

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility7();

            }
        });
    }

    public void responsibility7(){
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.responsibility7;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                responsibility8();

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility6();

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility8();

            }
        });
    }

    public void responsibility8(){
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.responsibility8;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonResponsibility.this, ResponsibilityLessonCongrats.class));

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsibility7();

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonResponsibility.this, ResponsibilityLessonCongrats.class));

            }
        });
    }
}