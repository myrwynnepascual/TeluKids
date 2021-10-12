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

public class LessonCompassion extends AppCompatActivity {

    VideoView videoViewCP;
    String videoPathCP;
    Uri uriCP;
    ImageButton backbtnCP,nextbtnCP;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewCP = findViewById(R.id.video);
        backbtnCP = findViewById(R.id.btnback);
        nextbtnCP = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewCP.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCP);

        BackgroundSoundService.onPause();

        compassion1();
    }

    public void compassion1(){
        videoPathCP = "android.resource://" + getPackageName() + "/" + R.raw.compassion1;
        uriCP = Uri.parse(videoPathCP);
        videoViewCP.setVideoURI(uriCP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCP.start();

            }
        });

        videoViewCP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCP.stopPlayback();
                compassion2();

            }
        });

        backbtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCP.stopPlayback();
                startActivity(new Intent(LessonCompassion.this, ChooseModeCompassion.class));

            }
        });

        nextbtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCP.stopPlayback();
                compassion2();

            }
        });

    }

    public void compassion2(){
        videoPathCP = "android.resource://" + getPackageName() + "/" + R.raw.compassion2;
        uriCP = Uri.parse(videoPathCP);
        videoViewCP.setVideoURI(uriCP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCP.start();

            }
        });

        videoViewCP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCP.stopPlayback();
                compassion3();

            }
        });

        backbtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCP.stopPlayback();
                compassion1();

            }
        });

        nextbtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCP.stopPlayback();
                compassion3();

            }
        });
    }

    public void compassion3(){
        videoPathCP = "android.resource://" + getPackageName() + "/" + R.raw.compassion3;
        uriCP = Uri.parse(videoPathCP);
        videoViewCP.setVideoURI(uriCP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCP.start();

            }
        });

        videoViewCP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCP.stopPlayback();
                compassion4();

            }
        });

        backbtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCP.stopPlayback();
                compassion2();

            }
        });

        nextbtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCP.stopPlayback();
                compassion4();

            }
        });
    }

    public void compassion4(){
        videoPathCP = "android.resource://" + getPackageName() + "/" + R.raw.compassion4;
        uriCP = Uri.parse(videoPathCP);
        videoViewCP.setVideoURI(uriCP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCP.start();

            }
        });

        videoViewCP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCP.stopPlayback();
                compassion5();

            }
        });

        backbtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCP.stopPlayback();
                compassion3();

            }
        });

        nextbtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCP.stopPlayback();
                compassion5();

            }
        });
    }

    public void compassion5(){
        videoPathCP = "android.resource://" + getPackageName() + "/" + R.raw.compassion5;
        uriCP = Uri.parse(videoPathCP);
        videoViewCP.setVideoURI(uriCP);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCP.start();
                
            }
        });

        videoViewCP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCP.stopPlayback();
                startActivity(new Intent(LessonCompassion.this, CompassionLessonCongrats.class));

            }
        });

        backbtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCP.stopPlayback();
                compassion4();

            }
        });

        nextbtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCP.stopPlayback();
                startActivity(new Intent(LessonCompassion.this, CompassionLessonCongrats.class));

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

        videoViewCP.pause();
        currentPosition = videoViewCP.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewCP.seekTo(currentPosition);
        videoViewCP.start();

        super.onResume();

    }
}