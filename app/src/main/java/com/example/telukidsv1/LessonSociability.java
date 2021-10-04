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

public class LessonSociability extends AppCompatActivity {

    VideoView videoViewSC36;
    String videoPathSC36;
    Uri uriSC36;
    ImageButton backbtnSC36,nextbtnSC36;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_sociability);

        videoViewSC36 = findViewById(R.id.videoSC36);
        backbtnSC36 = findViewById(R.id.btnbackSC36);
        nextbtnSC36 = findViewById(R.id.nextbtnSC36);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();

        mediaController = new MediaController(this);
        videoViewSC36.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewSC36);

        sociability1();
    }

    public void sociability1(){
        videoPathSC36 = "android.resource://" + getPackageName() + "/" + R.raw.sociability1;
        uriSC36 = Uri.parse(videoPathSC36);
        videoViewSC36.setVideoURI(uriSC36);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewSC36.start();

        videoViewSC36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sociability2();

            }
        });

        backbtnSC36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LessonSociability.this,ChooseModeSociability.class));

            }
        });

        nextbtnSC36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                sociability2();

            }
        });
    }

    public void sociability2(){
        videoPathSC36 = "android.resource://" + getPackageName() + "/" + R.raw.sociability2;
        uriSC36 = Uri.parse(videoPathSC36);
        videoViewSC36.setVideoURI(uriSC36);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewSC36.start();

        videoViewSC36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sociability3();

            }
        });

        backbtnSC36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                sociability1();

            }
        });

        nextbtnSC36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                sociability3();

            }
        });
    }

    public void sociability3(){
        videoPathSC36 = "android.resource://" + getPackageName() + "/" + R.raw.sociability3;
        uriSC36 = Uri.parse(videoPathSC36);
        videoViewSC36.setVideoURI(uriSC36);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewSC36.start();

        videoViewSC36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sociability4();

            }
        });

        backbtnSC36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                sociability2();

            }
        });

        nextbtnSC36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                sociability4();

            }
        });
    }

    public void sociability4(){
        videoPathSC36 = "android.resource://" + getPackageName() + "/" + R.raw.sociability4;
        uriSC36 = Uri.parse(videoPathSC36);
        videoViewSC36.setVideoURI(uriSC36);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewSC36.start();

        videoViewSC36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonSociability.this, SociabilityLessonCongrats.class));

            }
        });

        backbtnSC36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                sociability3();

            }
        });

        nextbtnSC36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LessonSociability.this, SociabilityLessonCongrats.class));

            }
        });
    }
}