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
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_shapes);

        videoViewCPG1 = findViewById(R.id.videoCPG1);
        backbtnCPG1 = findViewById(R.id.btnbackCPG1);
        nextbtnCPG1 = findViewById(R.id.nextbtnCPG1);

        mediaController = new MediaController(this);
        videoViewCPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCPG1);

        BackgroundSoundService.onPause();

        circle1();

    }

    public void circle1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                startActivity(new Intent(LessonShapes.this,ChooseModeShapes.class));

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle2();

            }
        });
    }

    public void circle2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle3();

            }
        });
    }

    public void circle3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle4();

            }
        });
    }

    public void circle4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle5();

            }
        });
    }

    public void circle5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle6();

            }
        });
    }

    public void circle6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.circle6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square1();

            }
        });
    }

    public void square1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                circle6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square2();

            }
        });
    }

    public void square2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square3();

            }
        });
    }

    public void square3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square4();

            }
        });
    }

    public void square4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square5();

            }
        });
    }

    public void square5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square6();

            }
        });
    }

    public void square6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.square6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle1();

            }
        });
    }

    public void triangle1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                square6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle2();

            }
        });
    }

    public void triangle2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle3();

            }
        });
    }

    public void triangle3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle4();

            }
        });
    }

    public void triangle4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle5();

            }
        });
    }

    public void triangle5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle6();

            }
        });
    }

    public void triangle6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.triangle6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star1();

            }
        });
    }

    public void star1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                triangle6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star2();

            }
        });
    }

    public void star2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star3();

            }
        });
    }

    public void star3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star4();

            }
        });
    }

    public void star4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star5();

            }
        });
    }

    public void star5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star6();

            }
        });
    }

    public void star6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.star6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart1();

            }
        });
    }

    public void heart1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                star6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart2();

            }
        });
    }

    public void heart2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart3();

            }
        });
    }

    public void heart3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart4();

            }
        });
    }

    public void heart4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart5();

            }
        });
    }

    public void heart5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart6();

            }
        });
    }

    public void heart6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.heart6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle1();

            }
        });
    }

    public void rectangle1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                heart6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle2();

            }
        });
    }

    public void rectangle2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle3();

            }
        });
    }

    public void rectangle3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle4();

            }
        });
    }

    public void rectangle4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle5();

            }
        });
    }

    public void rectangle5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle6();

            }
        });
    }

    public void rectangle6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond1();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond1();

            }
        });
    }

    public void diamond1(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond1;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond2();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                rectangle6();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond2();

            }
        });
    }

    public void diamond2(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond2;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond3();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond1();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond3();

            }
        });
    }

    public void diamond3(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond3;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond4();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond2();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond4();

            }
        });
    }

    public void diamond4(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond4;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond5();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond3();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond5();

            }
        });
    }

    public void diamond5(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond5;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond6();

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond4();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond6();

            }
        });
    }

    public void diamond6(){

        videoPathCPG1 = "android.resource://" + getPackageName() + "/" + R.raw.diamond6;
        uriCPG1 = Uri.parse(videoPathCPG1);
        videoViewCPG1.setVideoURI(uriCPG1);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewCPG1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCPG1.start();
                
            }
        });

        videoViewCPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                startActivity(new Intent(LessonShapes.this,ShapesLessonCongrats.class));

            }
        });

        backbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                diamond5();

            }
        });

        nextbtnCPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCPG1.stopPlayback();
                startActivity(new Intent(LessonShapes.this,ShapesLessonCongrats.class));

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

        videoViewCPG1.pause();
        currentPosition = videoViewCPG1.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewCPG1.seekTo(currentPosition);
        videoViewCPG1.start();

        super.onResume();

    }
}