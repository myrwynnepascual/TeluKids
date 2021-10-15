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

public class LessonColors extends AppCompatActivity {

    VideoView videoViewCL;
    String videoPathCL;
    Uri uriCL;
    ImageButton backbtnCL,nextbtnCL;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewCL = findViewById(R.id.video);
        backbtnCL = findViewById(R.id.btnback);
        nextbtnCL = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewCL.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCL);

        BackgroundSoundService.onPause();

        red1();
    }

    public void red1(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.red1;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
        

        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                red2();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCL.stopPlayback();
                startActivity(new Intent(LessonColors.this,ChooseModeColors.class));

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
               
               videoViewCL.stopPlayback();
               red2();

            }
        });
    }

    public void red2(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.red2;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
        

        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                red3();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                red1();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                red3();

            }
        });
    }

    public void red3(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.red3;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                red4();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                red2();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                red4();

            }
        });
    }

    public void red4(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.red4;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                red5();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                red3();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                red5();

            }
        });
    }

    public void red5(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.red5;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                red6();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                red4();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                red6();

            }
        });
    }

    public void red6(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.red6;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                blue1();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                red5();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue1();

            }
        });
    }

    public void blue1(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.blue1;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                blue2();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                red6();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue2();

            }
        });
    }

    public void blue2(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.blue2;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                blue3();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue1();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue3();

            }
        });
    }

    public void blue3(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.blue3;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                blue4();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue2();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue4();

            }
        });
    }

    public void blue4(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.blue4;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                blue5();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue3();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue5();

            }
        });
    }

    public void blue5(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.blue5;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                blue6();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue4();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue6();

            }
        });
    }

    public void blue6(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.blue6;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                yellow1();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue5();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow1();

            }
        });
    }

    public void yellow1(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.yellow1;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                yellow2();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                blue6();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow2();

            }
        });
    }

    public void yellow2(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.yellow2;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                yellow3();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow1();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow3();

            }
        });
    }

    public void yellow3(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.yellow3;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                yellow4();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow2();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow4();

            }
        });
    }

    public void yellow4(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.yellow4;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                yellow5();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow3();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow5();

            }
        });
    }

    public void yellow5(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.yellow5;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                yellow6();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow4();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow6();

            }
        });
    }

    public void yellow6(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.yellow6;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                orange1();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow5();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange1();

            }
        });
    }

    public void orange1(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.orange1;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                orange2();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                yellow6();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange2();

            }
        });
    }

    public void orange2(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.orange2;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                orange3();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange1();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange3();

            }
        });
    }

    public void orange3(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.orange3;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                orange4();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange2();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange4();

            }
        });
    }

    public void orange4(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.orange4;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                orange5();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange3();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange5();

            }
        });
    }

    public void orange5(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.orange5;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                orange6();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange4();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange6();

            }
        });
    }

    public void orange6(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.orange6;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                purple1();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange5();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple1();

            }
        });
    }

    public void purple1(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.purple1;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                purple2();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                orange6();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple2();

            }
        });
    }

    public void purple2(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.purple2;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                purple3();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple1();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple3();

            }
        });
    }

    public void purple3(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.purple3;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                purple4();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple2();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple4();

            }
        });
    }

    public void purple4(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.purple4;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                purple5();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple3();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple5();

            }
        });
    }

    public void purple5(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.purple5;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                purple6();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple4();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple6();

            }
        });
    }

    public void purple6(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.purple6;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                green1();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple5();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                green1();

            }
        });
    }

    public void green1(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.green1;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                green2();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                purple6();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                green2();

            }
        });
    }

    public void green2(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.green2;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                green3();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                green1();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                green3();

            }
        });
    }

    public void green3(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.green3;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                green4();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                green2();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                green4();

            }
        });
    }

    public void green4(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.green4;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                green5();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                green3();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                green5();

            }
        });
    }

    public void green5(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.green5;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                green6();

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                green4();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                green6();

            }
        });
    }

    public void green6(){

        videoPathCL = "android.resource://" + getPackageName() + "/" + R.raw.green6;
        uriCL = Uri.parse(videoPathCL);
        videoViewCL.setVideoURI(uriCL);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        videoViewCL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCL.start();

            }
        });

        videoViewCL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCL.stopPlayback();
                startActivity(new Intent(LessonColors.this,ColorsLessonCongrats.class));

            }
        });

        backbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                green5();

            }
        });

        nextbtnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCL.stopPlayback();
                startActivity(new Intent(LessonColors.this,ColorsLessonCongrats.class));

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
        
        videoViewCL.pause();
        currentPosition = videoViewCL.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewCL.seekTo(currentPosition);
        videoViewCL.start();

        super.onResume();

    }

}