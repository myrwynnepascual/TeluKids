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

    VideoView videoViewRDPG1;
    String videoPathRDPG1;
    Uri uriRDPG1;
    ImageButton backbtnRDPG1,nextbtnRDPG1;
    MediaController mediaController;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_colors);

        videoViewRDPG1 = findViewById(R.id.videoRDPG1);
        backbtnRDPG1 = findViewById(R.id.btnbackRDPG1);
        nextbtnRDPG1 = findViewById(R.id.nextbtnRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        BackgroundSoundService.onPause();

        red1();
    }

    public void red1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                red2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                startActivity(new Intent(LessonColors.this,ChooseModeColors.class));

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               sfx.start();
               videoViewRDPG1.stopPlayback();
               red2();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void red2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                red3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                red1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                red3();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void red3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                red4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                red2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                red4();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void red4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                red5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                red3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                red5();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void red5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                red6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                red4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                red6();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void red6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                blue1();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                red5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue1();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void blue1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                blue2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                red6();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue2();

            }
        });
    }

    public void blue2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                blue3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue3();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void blue3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                blue4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue4();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void blue4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                blue5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue5();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void blue5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                blue6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue6();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void blue6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                yellow1();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow1();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void yellow1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                yellow2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                blue6();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow2();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void yellow2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                yellow3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow3();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void yellow3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                yellow4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow4();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void yellow4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                yellow5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow5();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void yellow5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                yellow6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow6();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void yellow6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                orange1();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange1();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void orange1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                orange2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                yellow6();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange2();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void orange2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                orange3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange3();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void orange3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                orange4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange4();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void orange4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                orange5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange5();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void orange5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                orange6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange6();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void orange6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                purple1();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple1();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void purple1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  
        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                purple2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                orange6();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple2();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void purple2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                purple3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple3();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void purple3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                purple4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple4();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void purple4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                purple5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple5();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void purple5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                purple6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple6();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void purple6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                green1();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                green1();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void green1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                green2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                purple6();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                green2();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void green2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                green3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                green1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                green3();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void green3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                green4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                green2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                green4();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void green4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                green5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                green3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                green5();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void green5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                green6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                green4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                green6();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }

    public void green6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);  

        videoViewRDPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRDPG1.start();

            }
        });

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRDPG1.stopPlayback();
                startActivity(new Intent(LessonColors.this,ColorsLessonCongrats.class));

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                green5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRDPG1.stopPlayback();
                startActivity(new Intent(LessonColors.this,ColorsLessonCongrats.class));

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