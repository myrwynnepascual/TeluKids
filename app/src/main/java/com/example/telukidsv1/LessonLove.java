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

        love1();
    }

    public void love1(){
        videoPathL79 = "android.resource://" + getPackageName() + "/" + R.raw.love1;
        uriL79 = Uri.parse(videoPathL79);
        videoViewL79.setVideoURI(uriL79);

        videoViewL79.start();

        videoViewL79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                love2();

            }
        });

        backbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonLove.this,ChooseModeLove.class));

            }
        });

        nextbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                love2();

            }
        });
    }

    public void love2(){
        videoPathL79 = "android.resource://" + getPackageName() + "/" + R.raw.love2;
        uriL79 = Uri.parse(videoPathL79);
        videoViewL79.setVideoURI(uriL79);

        videoViewL79.start();

        videoViewL79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                love3();

            }
        });

        backbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                love1();

            }
        });

        nextbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                love3();

            }
        });
    }

    public void love3(){
        videoPathL79 = "android.resource://" + getPackageName() + "/" + R.raw.love3;
        uriL79 = Uri.parse(videoPathL79);
        videoViewL79.setVideoURI(uriL79);

        videoViewL79.start();

        videoViewL79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                love4();

            }
        });

        backbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                love2();

            }
        });

        nextbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                love4();

            }
        });
    }

    public void love4(){
        videoPathL79 = "android.resource://" + getPackageName() + "/" + R.raw.love4;
        uriL79 = Uri.parse(videoPathL79);
        videoViewL79.setVideoURI(uriL79);

        videoViewL79.start();

        videoViewL79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                love5();

            }
        });

        backbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                love3();

            }
        });

        nextbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                love5();

            }
        });
    }
    

    public void love5(){
        videoPathL79 = "android.resource://" + getPackageName() + "/" + R.raw.love5;
        uriL79 = Uri.parse(videoPathL79);
        videoViewL79.setVideoURI(uriL79);

        videoViewL79.start();

        videoViewL79.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonLove.this, LoveLessonCongrats.class));

            }
        });

        backbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                love5();

            }
        });

        nextbtnL79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonLove.this, LoveLessonCongrats.class));

            }
        });
    }
}