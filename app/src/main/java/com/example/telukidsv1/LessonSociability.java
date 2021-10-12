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

    VideoView videoViewSC;
    String videoPathSC;
    Uri uriSC;
    ImageButton backbtnSC,nextbtnSC;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewSC = findViewById(R.id.video);
        backbtnSC = findViewById(R.id.btnback);
        nextbtnSC = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewSC.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewSC);

        BackgroundSoundService.onPause();

        sociability1();
    }

    public void sociability1(){
        videoPathSC = "android.resource://" + getPackageName() + "/" + R.raw.sociability1;
        uriSC = Uri.parse(videoPathSC);
        videoViewSC.setVideoURI(uriSC);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewSC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSC.start();
                
            }
        });

        videoViewSC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSC.stopPlayback();
                sociability2();

            }
        });

        backbtnSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSC.stopPlayback();
                startActivity(new Intent(LessonSociability.this,ChooseModeSociability.class));

            }
        });

        nextbtnSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSC.stopPlayback();
                sociability2();

            }
        });
    }

    public void sociability2(){
        videoPathSC = "android.resource://" + getPackageName() + "/" + R.raw.sociability2;
        uriSC = Uri.parse(videoPathSC);
        videoViewSC.setVideoURI(uriSC);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewSC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewSC.start();

            }
        });

        videoViewSC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSC.stopPlayback();
                sociability3();

            }
        });

        backbtnSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSC.stopPlayback();
                sociability1();

            }
        });

        nextbtnSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSC.stopPlayback();
                sociability3();

            }
        });
    }

    public void sociability3(){
        videoPathSC = "android.resource://" + getPackageName() + "/" + R.raw.sociability3;
        uriSC = Uri.parse(videoPathSC);
        videoViewSC.setVideoURI(uriSC);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewSC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewSC.start();

            }
        });

        videoViewSC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSC.stopPlayback();
                sociability4();

            }
        });

        backbtnSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSC.stopPlayback();
                sociability2();

            }
        });

        nextbtnSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSC.stopPlayback();
                sociability4();

            }
        });
    }

    public void sociability4(){
        videoPathSC = "android.resource://" + getPackageName() + "/" + R.raw.sociability4;
        uriSC = Uri.parse(videoPathSC);
        videoViewSC.setVideoURI(uriSC);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewSC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewSC.start();

            }
        });

        videoViewSC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSC.stopPlayback();
                startActivity(new Intent(LessonSociability.this, SociabilityLessonCongrats.class));

            }
        });

        backbtnSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSC.stopPlayback();
                sociability3();

            }
        });

        nextbtnSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSC.stopPlayback();
                startActivity(new Intent(LessonSociability.this, SociabilityLessonCongrats.class));

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

        videoViewSC.pause();
        currentPosition = videoViewSC.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewSC.seekTo(currentPosition);
        videoViewSC.start();

        super.onResume();

    }
}