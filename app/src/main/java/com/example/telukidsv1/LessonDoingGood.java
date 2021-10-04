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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_doing_good);
        videoViewDG79 = findViewById(R.id.videoDG79);
        backbtnDG79 = findViewById(R.id.btnbackDG79);
        nextbtnDG79 = findViewById(R.id.nextbtnDG79);

        BackgroundSoundService.onPause();

        mediaController = new MediaController(this);
        videoViewDG79.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewDG79);

        good1();
    }

    public void good1(){
        videoPathDG79 = "android.resource://" + getPackageName() + "/" + R.raw.good1;
        uriDG79 = Uri.parse(videoPathDG79);
        videoViewDG79.setVideoURI(uriDG79);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewDG79.start();

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
                startActivity(new Intent(LessonDoingGood.this,ChooseModeDoingGood.class));

            }
        });

        nextbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                good2();

            }
        });
    }

    public void good2(){
        videoPathDG79 = "android.resource://" + getPackageName() + "/" + R.raw.good2;
        uriDG79 = Uri.parse(videoPathDG79);
        videoViewDG79.setVideoURI(uriDG79);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewDG79.start();

        videoViewDG79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                good3();

            }
        });

        backbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                good1();

            }
        });

        nextbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                good3();

            }
        });
    }

    public void good3(){
        videoPathDG79 = "android.resource://" + getPackageName() + "/" + R.raw.good3;
        uriDG79 = Uri.parse(videoPathDG79);
        videoViewDG79.setVideoURI(uriDG79);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewDG79.start();

        videoViewDG79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                good4();

            }
        });

        backbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                good2();

            }
        });

        nextbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                good4();

            }
        });
    }

    public void good4() {
        videoPathDG79 = "android.resource://" + getPackageName() + "/" + R.raw.good4;
        uriDG79 = Uri.parse(videoPathDG79);
        videoViewDG79.setVideoURI(uriDG79);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewDG79.start();

        videoViewDG79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonDoingGood.this, DoingGoodLessonCongrats.class));

            }
        });

        backbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                good3();

            }
        });

        nextbtnDG79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LessonDoingGood.this, DoingGoodLessonCongrats.class));

            }
        });
    }
}