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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_colors);

        videoViewRDPG1 = findViewById(R.id.videoRDPG1);
        backbtnRDPG1 = findViewById(R.id.btnbackRDPG1);
        nextbtnRDPG1 = findViewById(R.id.nextbtnRDPG1);

        red1();
    }

    public void red1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                red2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonColors.this,ChooseModeColors.class));

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               red2();

            }
        });
    }

    public void red2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                red3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                red1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                red3();

            }
        });
    }

    public void red3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                red4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                red2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                red4();

            }
        });
    }

    public void red4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                red5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                red3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                red5();

            }
        });
    }

    public void red5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                red6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                red4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                red6();

            }
        });
    }

    public void red6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                blue1();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                red5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue1();

            }
        });
    }

    public void blue1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                blue2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                red6();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue2();

            }
        });
    }

    public void blue2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                blue3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue3();

            }
        });
    }

    public void blue3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                blue4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue4();

            }
        });
    }

    public void blue4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                blue5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue5();

            }
        });
    }

    public void blue5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                blue6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue6();

            }
        });
    }

    public void blue6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.blue6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                yellow1();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow1();

            }
        });
    }

    public void yellow1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                yellow2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blue6();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow2();

            }
        });
    }

    public void yellow2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                yellow3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow3();

            }
        });
    }

    public void yellow3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                yellow4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow4();

            }
        });
    }

    public void yellow4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                yellow5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow5();

            }
        });
    }

    public void yellow5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                yellow6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow6();

            }
        });
    }

    public void yellow6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.yellow6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                orange1();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange1();

            }
        });
    }

    public void orange1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                orange2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yellow6();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange2();

            }
        });
    }

    public void orange2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                orange3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange3();

            }
        });
    }

    public void orange3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                orange4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange4();

            }
        });
    }

    public void orange4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                orange5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange5();

            }
        });
    }

    public void orange5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                orange6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange6();

            }
        });
    }

    public void orange6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.orange6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                purple1();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple1();

            }
        });
    }

    public void purple1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                purple2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orange6();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple2();

            }
        });
    }

    public void purple2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                purple3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple3();

            }
        });
    }

    public void purple3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                purple4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple4();

            }
        });
    }

    public void purple4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                purple5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple5();

            }
        });
    }

    public void purple5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                purple6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple6();

            }
        });
    }

    public void purple6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.purple6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                green1();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green1();

            }
        });
    }

    public void green1(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                green2();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                purple6();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green2();

            }
        });
    }

    public void green2(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green2;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                green3();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green1();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green3();

            }
        });
    }

    public void green3(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green3;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                green4();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green2();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green4();

            }
        });
    }

    public void green4(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green4;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                green5();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green3();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green5();

            }
        });
    }

    public void green5(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green5;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                green6();

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green4();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green6();

            }
        });
    }

    public void green6(){

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.green6;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonColors.this,ColorsLessonCongrats.class));

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                green5();

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonColors.this,ColorsLessonCongrats.class));

            }
        });
    }


}