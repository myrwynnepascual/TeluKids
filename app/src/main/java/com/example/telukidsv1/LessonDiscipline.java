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

    VideoView videoViewD;
    String videoPathD;
    Uri uriD;
    ImageButton backbtnD,nextbtnD;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewD = findViewById(R.id.video);
        backbtnD = findViewById(R.id.btnback);
        nextbtnD = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewD.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewD);

        BackgroundSoundService.onPause();

        discipline1();
    }

    public void discipline1(){
        videoPathD = "android.resource://" + getPackageName() + "/" + R.raw.discipline1;
        uriD = Uri.parse(videoPathD);
        videoViewD.setVideoURI(uriD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD.start();
                
            }
        });

        videoViewD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewD.stopPlayback();
                discipline2();

            }
        });

        backbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewD.stopPlayback();
                startActivity(new Intent(LessonDiscipline.this,ChooseModeDiscipline.class));

            }
        });

        nextbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewD.stopPlayback();
                discipline2();

            }
        });
    }

    public void discipline2(){
        videoPathD = "android.resource://" + getPackageName() + "/" + R.raw.discipline2;
        uriD = Uri.parse(videoPathD);
        videoViewD.setVideoURI(uriD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD.start();
                
            }
        });

        videoViewD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                
                videoViewD.stopPlayback();
                discipline3();

            }
        });

        backbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewD.stopPlayback();
                discipline1();

            }
        });

        nextbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewD.stopPlayback();
                discipline3();

            }
        });
    }

    public void discipline3(){
        videoPathD = "android.resource://" + getPackageName() + "/" + R.raw.discipline3;
        uriD = Uri.parse(videoPathD);
        videoViewD.setVideoURI(uriD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD.start();
                
            }
        });

        videoViewD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewD.stopPlayback();
                discipline4();

            }
        });

        backbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewD.stopPlayback();
                discipline2();

            }
        });

        nextbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewD.stopPlayback();
                discipline4();

            }
        });
    }

    public void discipline4(){
        videoPathD = "android.resource://" + getPackageName() + "/" + R.raw.discipline4;
        uriD = Uri.parse(videoPathD);
        videoViewD.setVideoURI(uriD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD.start();
                
            }
        });

        videoViewD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewD.stopPlayback();
                discipline5();

            }
        });

        backbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewD.stopPlayback();
                discipline3();

            }
        });

        nextbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewD.stopPlayback();
                discipline5();

            }
        });
    }

    public void discipline5(){
        videoPathD = "android.resource://" + getPackageName() + "/" + R.raw.discipline5;
        uriD = Uri.parse(videoPathD);
        videoViewD.setVideoURI(uriD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD.start();
                
            }
        });

        videoViewD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewD.stopPlayback();
                discipline6();

            }
        });

        backbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewD.stopPlayback();
                discipline4();

            }
        });

        nextbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewD.stopPlayback();
                discipline6();

            }
        });
    }

    public void discipline6(){
        videoPathD = "android.resource://" + getPackageName() + "/" + R.raw.discipline6;
        uriD = Uri.parse(videoPathD);
        videoViewD.setVideoURI(uriD);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
         

        videoViewD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewD.start();
                
            }
        });

        videoViewD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewD.stopPlayback();
                startActivity(new Intent(LessonDiscipline.this, DisciplineLessonCongrats.class));

            }
        });

        backbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewD.stopPlayback();
                discipline5();

            }
        });

        nextbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewD.stopPlayback();
                startActivity(new Intent(LessonDiscipline.this, DisciplineLessonCongrats.class));

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

        videoViewD.pause();
        currentPosition = videoViewD.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewD.seekTo(currentPosition);
        videoViewD.start();

        super.onResume();

    }
}