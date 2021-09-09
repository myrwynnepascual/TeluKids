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

public class LessonShapes extends AppCompatActivity {

    VideoView videoViewCPG1;
    String videoPathCPG1;
    Uri uriCPG1;
    ImageButton backbtnCPG1,nextbtnCPG1;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_shapes);

        videoViewCPG1 = findViewById(R.id.videoCPG1);
        backbtnCPG1 = findViewById(R.id.btnbackCPG1);
        nextbtnCPG1 = findViewById(R.id.nextbtnCPG1);

        circle1();

    }

    public void circle1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                circle2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonShapes.this,ChooseModeShapes.class));

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               circle2();

            }
        });
    }

    public void circle2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                circle3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                circle1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                circle3();

            }
        });
    }

    public void circle3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                circle4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                circle2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                circle4();

            }
        });
    }

    public void circle4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                circle5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                circle3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                circle5();

            }
        });
    }

    public void circle5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                circle6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                circle4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                circle6();

            }
        });
    }

    public void circle6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                square1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                circle5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square1();

            }
        });
    }

    public void square1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                square2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                circle6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square2();

            }
        });
    }

    public void square2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                square3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square3();

            }
        });
    }

    public void square3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                square4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square4();

            }
        });
    }

    public void square4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                square5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square5();

            }
        });
    }

    public void square5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                square6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square6();

            }
        });
    }

    public void square6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                triangle1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle1();

            }
        });
    }

    public void triangle1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                triangle2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                square6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle2();

            }
        });
    }

    public void triangle2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                triangle3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle3();

            }
        });
    }

    public void triangle3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                triangle4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle4();

            }
        });
    }

    public void triangle4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                triangle5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle5();

            }
        });
    }

    public void triangle5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                triangle6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle6();

            }
        });
    }

    public void triangle6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                star1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star1();

            }
        });
    }

    public void star1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                star2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triangle6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star2();

            }
        });
    }

    public void star2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                star3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star3();

            }
        });
    }

    public void star3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                star4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star4();

            }
        });
    }

    public void star4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                star5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star5();

            }
        });
    }

    public void star5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                star6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star6();

            }
        });
    }

    public void star6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                heart1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart1();

            }
        });
    }

    public void heart1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                heart2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                star6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart2();

            }
        });
    }

    public void heart2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                heart3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart3();

            }
        });
    }

    public void heart3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                heart4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart4();

            }
        });
    }

    public void heart4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                heart5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart5();

            }
        });
    }

    public void heart5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                heart6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart6();

            }
        });
    }

    public void heart6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                rectangle1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle1();

            }
        });
    }

    public void rectangle1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                rectangle2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle2();

            }
        });
    }

    public void rectangle2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                rectangle3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle3();

            }
        });
    }

    public void rectangle3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                rectangle4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle4();

            }
        });
    }

    public void rectangle4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                rectangle5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle5();

            }
        });
    }

    public void rectangle5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                rectangle6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle6();

            }
        });
    }

    public void rectangle6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                diamond1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diamond1();

            }
        });
    }

    public void diamond1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                diamond2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rectangle6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diamond2();

            }
        });
    }

    public void diamond2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                diamond3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diamond1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diamond3();

            }
        });
    }

    public void diamond3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                diamond4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diamond2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diamond4();

            }
        });
    }

    public void diamond4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                diamond5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diamond3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diamond5();

            }
        });
    }

    public void diamond5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                diamond6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diamond4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diamond6();

            }
        });
    }

    public void diamond6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        videoViewCPG1.start();

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonShapes.this,ShapesLessonCongrats.class));

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diamond5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonShapes.this,ShapesLessonCongrats.class));

            }
        });
    }
}