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

public class LessonDiscipline extends AppCompatActivity {

    VideoView videoViewD36;
    String videoPathD36;
    Uri uriD36;
    ImageButton backbtnD36,nextbtnD36;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_discipline);

        videoViewD36 = findViewById(R.id.videoD36);
        backbtnD36 = findViewById(R.id.btnbackD36);
        nextbtnD36 = findViewById(R.id.nextbtnD36);

        mediaController = new MediaController(this);
        videoViewD36.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewD36);

        BackgroundSoundService.onPause();

        discipline1();
    }

    public void discipline1(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline1;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD36.start();
                
            }
        });

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewD36.stopPlayback();
                discipline2();

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewD36.stopPlayback();
                startActivity(new Intent(LessonDiscipline.this,ChooseModeDiscipline.class));

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewD36.stopPlayback();
                discipline2();

            }
        });
    }

    public void discipline2(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline2;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD36.start();
                
            }
        });

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();
                
                videoViewD36.stopPlayback();
                discipline3();

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();


                videoViewD36.stopPlayback();
                discipline1();

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewD36.stopPlayback();
                discipline3();

            }
        });
    }

    public void discipline3(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline3;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD36.start();
                
            }
        });

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewD36.stopPlayback();
                discipline4();

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewD36.stopPlayback();
                discipline2();

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewD36.stopPlayback();
                discipline4();

            }
        });
    }

    public void discipline4(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline4;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD36.start();
                
            }
        });

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewD36.stopPlayback();
                discipline5();

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewD36.stopPlayback();
                discipline3();

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewD36.stopPlayback();
                discipline5();

            }
        });
    }

    public void discipline5(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline5;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD36.start();
                
            }
        });

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewD36.stopPlayback();
                discipline6();

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewD36.stopPlayback();
                discipline4();

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewD36.stopPlayback();
                discipline6();

            }
        });
    }

    public void discipline6(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline6;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD36.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD36.start();
                
            }
        });

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewD36.stopPlayback();
                startActivity(new Intent(LessonDiscipline.this, DisciplineLessonCongrats.class));

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewD36.stopPlayback();
                discipline5();

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                
                videoViewD36.stopPlayback();
                startActivity(new Intent(LessonDiscipline.this, DisciplineLessonCongrats.class));

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

        videoViewD36.pause();
        currentPosition = videoViewD36.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewD36.seekTo(currentPosition);
        videoViewD36.start();

        super.onResume();

    }
}