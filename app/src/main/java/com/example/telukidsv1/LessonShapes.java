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

    VideoView videoViewSH;
    String videoPathSH;
    Uri uriSH;
    ImageButton backbtnSH,nextbtnSH;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewSH = findViewById(R.id.video);
        backbtnSH = findViewById(R.id.btnback);
        nextbtnSH = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewSH.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewSH);

        BackgroundSoundService.onPause();

        circle1();

    }

    public void circle1(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.circle1;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                circle2();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                startActivity(new Intent(LessonShapes.this,ChooseModeShapes.class));

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                circle2();

            }
        });
    }

    public void circle2(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.circle2;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                circle3();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                circle1();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                circle3();

            }
        });
    }

    public void circle3(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.circle3;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                circle4();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                circle2();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                circle4();

            }
        });
    }

    public void circle4(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.circle4;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                circle5();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                circle3();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                circle5();

            }
        });
    }

    public void circle5(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.circle5;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                circle6();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                circle4();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                circle6();

            }
        });
    }

    public void circle6(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.circle6;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                square1();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                circle5();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square1();

            }
        });
    }

    public void square1(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.square1;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                square2();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                circle6();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square2();

            }
        });
    }

    public void square2(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.square2;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                square3();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square1();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square3();

            }
        });
    }

    public void square3(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.square3;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                square4();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square2();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square4();

            }
        });
    }

    public void square4(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.square4;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                square5();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square3();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square5();

            }
        });
    }

    public void square5(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.square5;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                square6();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square4();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square6();

            }
        });
    }

    public void square6(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.square6;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                triangle1();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square5();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle1();

            }
        });
    }

    public void triangle1(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.triangle1;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                triangle2();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                square6();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle2();

            }
        });
    }

    public void triangle2(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.triangle2;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                triangle3();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle1();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle3();

            }
        });
    }

    public void triangle3(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.triangle3;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                triangle4();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle2();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle4();

            }
        });
    }

    public void triangle4(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.triangle4;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                triangle5();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle3();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle5();

            }
        });
    }

    public void triangle5(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.triangle5;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                triangle6();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle4();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle6();

            }
        });
    }

    public void triangle6(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.triangle6;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                star1();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle5();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star1();

            }
        });
    }

    public void star1(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.star1;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                star2();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                triangle6();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star2();

            }
        });
    }

    public void star2(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.star2;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                star3();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star1();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star3();

            }
        });
    }

    public void star3(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.star3;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                star4();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star2();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star4();

            }
        });
    }

    public void star4(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.star4;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                star5();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star3();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star5();

            }
        });
    }

    public void star5(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.star5;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                star6();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star4();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star6();

            }
        });
    }

    public void star6(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.star6;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                heart1();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star5();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart1();

            }
        });
    }

    public void heart1(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.heart1;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                heart2();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                star6();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart2();

            }
        });
    }

    public void heart2(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.heart2;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                heart3();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart1();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart3();

            }
        });
    }

    public void heart3(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.heart3;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                heart4();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart2();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart4();

            }
        });
    }

    public void heart4(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.heart4;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                heart5();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart3();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart5();

            }
        });
    }

    public void heart5(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.heart5;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                heart6();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart4();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart6();

            }
        });
    }

    public void heart6(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.heart6;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                rectangle1();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart5();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle1();

            }
        });
    }

    public void rectangle1(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.rectangle1;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                rectangle2();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                heart6();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle2();

            }
        });
    }

    public void rectangle2(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.rectangle2;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                rectangle3();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle1();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle3();

            }
        });
    }

    public void rectangle3(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.rectangle3;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                rectangle4();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle2();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle4();

            }
        });
    }

    public void rectangle4(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.rectangle4;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                rectangle5();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle3();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle5();

            }
        });
    }

    public void rectangle5(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.rectangle5;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                rectangle6();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle4();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle6();

            }
        });
    }

    public void rectangle6(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.rectangle6;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                diamond1();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle5();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                diamond1();

            }
        });
    }

    public void diamond1(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.diamond1;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                diamond2();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                rectangle6();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                diamond2();

            }
        });
    }

    public void diamond2(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.diamond2;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                diamond3();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                diamond1();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                diamond3();

            }
        });
    }

    public void diamond3(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.diamond3;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                diamond4();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                diamond2();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                diamond4();

            }
        });
    }

    public void diamond4(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.diamond4;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                diamond5();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                diamond3();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                diamond5();

            }
        });
    }

    public void diamond5(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.diamond5;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                diamond6();

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                diamond4();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                diamond6();

            }
        });
    }

    public void diamond6(){

        videoPathSH = "android.resource://" + getPackageName() + "/" + R.raw.diamond6;
        uriSH = Uri.parse(videoPathSH);
        videoViewSH.setVideoURI(uriSH);
        sfx = MediaPlayer.create(this, R.raw.btnsfx); 

         videoViewSH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewSH.start();
                
            }
        });

        videoViewSH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewSH.stopPlayback();
                startActivity(new Intent(LessonShapes.this,ShapesLessonCongrats.class));

            }
        });

        backbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
                diamond5();

            }
        });

        nextbtnSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewSH.stopPlayback();
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

        videoViewSH.pause();
        currentPosition = videoViewSH.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewSH.seekTo(currentPosition);
        videoViewSH.start();

        super.onResume();

    }
}