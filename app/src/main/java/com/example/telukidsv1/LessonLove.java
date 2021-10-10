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

public class LessonLove extends AppCompatActivity {

    VideoView videoViewL79;
    String videoPathL79;
    Uri uriL79;
    ImageButton backbtnL79,nextbtnL79;
    MediaController mediaController;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_love);

        videoViewL79 = findViewById(R.id.videoL79);
        backbtnL79 = findViewById(R.id.btnbackL79);
        nextbtnL79 = findViewById(R.id.nextbtnL79);

        mediaController = new MediaController(this);
        videoViewL79.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewL79);

        BackgroundSoundService.onPause();

        love1();
    }

    public void love1(){
        videoPathL79 = "android.resource://" + getPackageName() + "/" + R.raw.love1;
        uriL79 = Uri.parse(videoPathL79);
        videoViewL79.setVideoURI(uriL79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewL79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewL79.start();
                
            }
        });

        videoViewL79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewL79.stopPlayback();
                love2();

            }
        });

        backbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewL79.stopPlayback();
                startActivity(new Intent(LessonLove.this,ChooseModeLove.class));

            }
        });

        nextbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewL79.stopPlayback();
                love2();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void love2(){
        videoPathL79 = "android.resource://" + getPackageName() + "/" + R.raw.love2;
        uriL79 = Uri.parse(videoPathL79);
        videoViewL79.setVideoURI(uriL79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewL79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewL79.start();
                
            }
        });

        videoViewL79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewL79.stopPlayback();
                love3();

            }
        });

        backbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewL79.stopPlayback();
                love1();

            }
        });

        nextbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewL79.stopPlayback();
                love3();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void love3(){
        videoPathL79 = "android.resource://" + getPackageName() + "/" + R.raw.love3;
        uriL79 = Uri.parse(videoPathL79);
        videoViewL79.setVideoURI(uriL79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewL79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewL79.start();
                
            }
        });

        videoViewL79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewL79.stopPlayback();
                love4();

            }
        });

        backbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewL79.stopPlayback();
                love2();

            }
        });

        nextbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewL79.stopPlayback();
                love4();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void love4(){
        videoPathL79 = "android.resource://" + getPackageName() + "/" + R.raw.love4;
        uriL79 = Uri.parse(videoPathL79);
        videoViewL79.setVideoURI(uriL79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewL79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewL79.start();
                
            }
        });

        videoViewL79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewL79.stopPlayback();
                love5();

            }
        });

        backbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewL79.stopPlayback();
                love3();

            }
        });

        nextbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewL79.stopPlayback();
                love5();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }
    

    public void love5(){
        videoPathL79 = "android.resource://" + getPackageName() + "/" + R.raw.love5;
        uriL79 = Uri.parse(videoPathL79);
        videoViewL79.setVideoURI(uriL79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewL79.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewL79.start();
                
            }
        });

        videoViewL79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewL79.stopPlayback();
                startActivity(new Intent(LessonLove.this, LoveLessonCongrats.class));

            }
        });

        backbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewL79.stopPlayback();
                love5();

            }
        });

        nextbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewL79.stopPlayback();
                startActivity(new Intent(LessonLove.this, LoveLessonCongrats.class));

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