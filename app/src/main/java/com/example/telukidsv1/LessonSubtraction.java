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

public class LessonSubtraction extends AppCompatActivity {

    VideoView videoViewS;
    String videoPathS;
    Uri uriS;
    ImageButton backbtnS,nextbtnS;
    MediaController mediaController;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_subtraction);

        videoViewS = findViewById(R.id.videoS);
        backbtnS = findViewById(R.id.btnbackS);
        nextbtnS = findViewById(R.id.nextbtnS);

        mediaController = new MediaController(this);
        videoViewS.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewS);

        BackgroundSoundService.onPause();

        subtractionx();
    }

    public void subtractionx(){

        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtractionx;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                subtractiony();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                startActivity(new Intent(LessonSubtraction.this,ChooseModeSubtraction.class));

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtractiony();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void subtractiony(){

        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtractiony;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                subtraction1();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                startActivity(new Intent(LessonSubtraction.this,ChooseModeSubtraction.class));

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction1();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void subtraction1(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction1;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

         videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                subtraction2();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtractionx();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction2();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void subtraction2(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction2;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

         videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                subtraction3();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction1();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction3();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void subtraction3(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction3;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

         videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                subtraction4();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction2();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction4();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void subtraction4(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction4;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

         videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                subtraction5();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction3();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction5();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void subtraction5(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction5;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

         videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                subtraction6();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction4();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction6();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void subtraction6(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction6;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

         videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                subtraction7();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction5();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction7();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void subtraction7(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction7;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

         videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                subtraction8();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction6();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction8();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void subtraction8(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction8;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

         videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                subtraction9();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction7();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction9();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void subtraction9(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction9;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

         videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                subtraction10();

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction8();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction10();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void subtraction10(){
        videoPathS = "android.resource://" + getPackageName() + "/" + R.raw.subtraction10;
        uriS = Uri.parse(videoPathS);
        videoViewS.setVideoURI(uriS);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

         videoViewS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewS.start();
                
            }
        });

        videoViewS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewS.stopPlayback();
                startActivity(new Intent(LessonSubtraction.this,SubtractionLessonCongrats.class));

            }
        });

        backbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                subtraction9();

            }
        });

        nextbtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewS.stopPlayback();
                startActivity(new Intent(LessonSubtraction.this,SubtractionLessonCongrats.class));

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