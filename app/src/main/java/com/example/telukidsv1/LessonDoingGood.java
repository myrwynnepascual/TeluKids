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

    VideoView videoViewRP79;
    String videoPathRP79;
    Uri uriRP79;
    ImageButton backbtnRP79,nextbtnRP79;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_doing_good);
        videoViewRP79 = findViewById(R.id.videoRP79);
        backbtnRP79 = findViewById(R.id.btnbackRP79);
        nextbtnRP79 = findViewById(R.id.nextbtnRP79);

        mediaController = new MediaController(this);
        videoViewRP79.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRP79);

        good1();
    }

    public void good1(){
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.good1;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                good2();

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonDoingGood.this,ChooseModeDoingGood.class));

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                good2();

            }
        });
    }

    public void good2(){
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.good2;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                good3();

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                good1();

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                good3();

            }
        });
    }

    public void good3(){
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.good3;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                good4();

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                good2();

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                good4();

            }
        });
    }

    public void good4() {
        videoPathRP79 = "android.resource://" + getPackageName() + "/" + R.raw.good4;
        uriRP79 = Uri.parse(videoPathRP79);
        videoViewRP79.setVideoURI(uriRP79);

        videoViewRP79.start();

        videoViewRP79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonDoingGood.this, DoingGoodLessonCongrats.class));

            }
        });

        backbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                good3();

            }
        });

        nextbtnRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonDoingGood.this, DoingGoodLessonCongrats.class));

            }
        });
    }
}