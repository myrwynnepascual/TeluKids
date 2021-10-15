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

public class LessonDoingGood extends AppCompatActivity {

    VideoView videoViewDG;
    String videoPathDG;
    Uri uriDG;
    ImageButton backbtnDG,nextbtnDG;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewDG = findViewById(R.id.video);
        backbtnDG = findViewById(R.id.btnback);
        nextbtnDG = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewDG.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewDG);

        BackgroundSoundService.onPause();

        good1();
    }

    public void good1(){
        videoPathDG = "android.resource://" + getPackageName() + "/" + R.raw.good1;
        uriDG = Uri.parse(videoPathDG);
        videoViewDG.setVideoURI(uriDG);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
        

        videoViewDG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewDG.start();
                
            }
        });

        videoViewDG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewDG.stopPlayback();
                good2();

            }
        });

        backbtnDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewDG.stopPlayback();
                startActivity(new Intent(LessonDoingGood.this,ChooseModeDoingGood.class));

            }
        });

        nextbtnDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewDG.stopPlayback();
                good2();

            }
        });
    }

    public void good2(){
        videoPathDG = "android.resource://" + getPackageName() + "/" + R.raw.good2;
        uriDG = Uri.parse(videoPathDG);
        videoViewDG.setVideoURI(uriDG);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
        

        videoViewDG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewDG.start();
                
            }
        });

        videoViewDG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewDG.stopPlayback();
                good3();

            }
        });

        backbtnDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewDG.stopPlayback();
                good1();

            }
        });

        nextbtnDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewDG.stopPlayback();
                good3();

            }
        });
    }

    public void good3(){
        videoPathDG = "android.resource://" + getPackageName() + "/" + R.raw.good3;
        uriDG = Uri.parse(videoPathDG);
        videoViewDG.setVideoURI(uriDG);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
        

        videoViewDG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewDG.start();
                
            }
        });

        videoViewDG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewDG.stopPlayback();
                good4();

            }
        });

        backbtnDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewDG.stopPlayback();
                good2();

            }
        });

        nextbtnDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewDG.stopPlayback();
                good4();

            }
        });
    }

    public void good4() {
        videoPathDG = "android.resource://" + getPackageName() + "/" + R.raw.good4;
        uriDG = Uri.parse(videoPathDG);
        videoViewDG.setVideoURI(uriDG);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
        

        videoViewDG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewDG.start();
                
            }
        });

        videoViewDG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewDG.stopPlayback();
                startActivity(new Intent(LessonDoingGood.this, DoingGoodLessonCongrats.class));

            }
        });

        backbtnDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewDG.stopPlayback();
                good3();

            }
        });

        nextbtnDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewDG.stopPlayback();
                startActivity(new Intent(LessonDoingGood.this, DoingGoodLessonCongrats.class));

            }
        });
    }

    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onUserLeaveHint(){

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.release();

            }
        });

        videoViewDG.pause();
        currentPosition = videoViewDG.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewDG.seekTo(currentPosition);
        videoViewDG.start();

        super.onResume();

    }
}