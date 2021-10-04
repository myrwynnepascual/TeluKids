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

    VideoView videoViewH36;
    String videoPathH36;
    Uri uriH36;
    ImageButton backbtnH36,nextbtnH36;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_honesty);

        videoViewH36 = findViewById(R.id.videoH36);
        backbtnH36 = findViewById(R.id.btnbackH36);
        nextbtnH36 = findViewById(R.id.nextbtnH36);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();

        mediaController = new MediaController(this);
        videoViewH36.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewH36);

        honesty1();
    }

    public void honesty1(){
        videoPathH36 = "android.resource://" + getPackageName() + "/" + R.raw.honesty1;
        uriH36 = Uri.parse(videoPathH36);
        videoViewH36.setVideoURI(uriH36);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewH36.start();

        videoViewH36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                honesty2();

            }
        });

        backbtnH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LessonHonesty.this, ChooseModeHonesty.class));

            }
        });

        nextbtnH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                honesty2();

            }
        });
    }

    public void honesty2(){
        videoPathH36 = "android.resource://" + getPackageName() + "/" + R.raw.honesty2;
        uriH36 = Uri.parse(videoPathH36);
        videoViewH36.setVideoURI(uriH36);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewH36.start();

        videoViewH36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                honesty3();

            }
        });

        backbtnH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                honesty1();

            }
        });

        nextbtnH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                honesty3();

            }
        });
    }

    public void honesty3(){
        videoPathH36 = "android.resource://" + getPackageName() + "/" + R.raw.honesty3;
        uriH36 = Uri.parse(videoPathH36);
        videoViewH36.setVideoURI(uriH36);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewH36.start();

        videoViewH36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                honesty4();

            }
        });

        backbtnH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                honesty2();

            }
        });

        nextbtnH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                honesty4();

            }
        });
    }

    public void honesty4(){
        videoPathH36 = "android.resource://" + getPackageName() + "/" + R.raw.honesty4;
        uriH36 = Uri.parse(videoPathH36);
        videoViewH36.setVideoURI(uriH36);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewH36.start();

        videoViewH36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                honesty5();

            }
        });

        backbtnH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                honesty3();

            }
        });

        nextbtnH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                honesty5();

            }
        });
    }

    public void honesty5(){
        videoPathH36 = "android.resource://" + getPackageName() + "/" + R.raw.honesty5;
        uriH36 = Uri.parse(videoPathH36);
        videoViewH36.setVideoURI(uriH36);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewH36.start();

        videoViewH36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonHonesty.this, HonestyLessonCongrats.class));

            }
        });

        backbtnH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                honesty4();

            }
        });

        nextbtnH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LessonHonesty.this, HonestyLessonCongrats.class));

            }
        });
    }
}