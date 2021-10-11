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

    VideoView videoViewDG79;
    String videoPathDG79;
    Uri uriDG79;
    ImageButton backbtnDG79,nextbtnDG79;
    MediaController mediaController;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_doing_good);
        videoViewDG79 = findViewById(R.id.videoDG79);
        backbtnDG79 = findViewById(R.id.btnbackDG79);
        nextbtnDG79 = findViewById(R.id.nextbtnDG79);

        mediaController = new MediaController(this);
        videoViewDG79.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewDG79);

        BackgroundSoundService.onPause();

        good1();
    }

    public void good1(){
        videoPathDG79 = "android.resource://" + getPackageName() + "/" + R.raw.good1;
        uriDG79 = Uri.parse(videoPathDG79);
        videoViewDG79.setVideoURI(uriDG79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewDG79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewDG79.start();
                
            }
        });

        videoViewDG79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                good2();

            }
        });

        backbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewDG79.stopPlayback();
                startActivity(new Intent(LessonDoingGood.this,ChooseModeDoingGood.class));

            }
        });

        nextbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewDG79.stopPlayback();
                good2();

            }
        });
    }

    public void good2(){
        videoPathDG79 = "android.resource://" + getPackageName() + "/" + R.raw.good2;
        uriDG79 = Uri.parse(videoPathDG79);
        videoViewDG79.setVideoURI(uriDG79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewDG79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewDG79.start();
                
            }
        });

        videoViewDG79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewDG79.stopPlayback();
                good3();

            }
        });

        backbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewDG79.stopPlayback();
                good1();

            }
        });

        nextbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewDG79.stopPlayback();
                good3();

            }
        });
    }

    public void good3(){
        videoPathDG79 = "android.resource://" + getPackageName() + "/" + R.raw.good3;
        uriDG79 = Uri.parse(videoPathDG79);
        videoViewDG79.setVideoURI(uriDG79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewDG79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewDG79.start();
                
            }
        });

        videoViewDG79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewDG79.stopPlayback();
                good4();

            }
        });

        backbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewDG79.stopPlayback();
                good2();

            }
        });

        nextbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewDG79.stopPlayback();
                good4();

            }
        });
    }

    public void good4() {
        videoPathDG79 = "android.resource://" + getPackageName() + "/" + R.raw.good4;
        uriDG79 = Uri.parse(videoPathDG79);
        videoViewDG79.setVideoURI(uriDG79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewDG79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewDG79.start();
                
            }
        });

        videoViewDG79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewDG79.stopPlayback();
                startActivity(new Intent(LessonDoingGood.this, DoingGoodLessonCongrats.class));

            }
        });

        backbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewDG79.stopPlayback();
                good3();

            }
        });

        nextbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewDG79.stopPlayback();
                startActivity(new Intent(LessonDoingGood.this, DoingGoodLessonCongrats.class));

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

        super.onUserLeaveHint();
    }
}