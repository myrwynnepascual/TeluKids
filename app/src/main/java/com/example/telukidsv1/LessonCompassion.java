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

    VideoView videoViewCP36;
    String videoPathCP36;
    Uri uriCP36;
    ImageButton backbtnCP36,nextbtnCP36;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_compassion);

        videoViewCP36 = findViewById(R.id.videoCP36);
        backbtnCP36 = findViewById(R.id.btnbackCP36);
        nextbtnCP36 = findViewById(R.id.nextbtnCP36);

        mediaController = new MediaController(this);
        videoViewCP36.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCP36);

        compassion1();
    }

    public void compassion1(){
        videoPathCP36 = "android.resource://" + getPackageName() + "/" + R.raw.compassion1;
        uriCP36 = Uri.parse(videoPathCP36);
        videoViewCP36.setVideoURI(uriCP36);

        videoViewCP36.start();

        videoViewCP36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                compassion2();

            }
        });

        backbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonCompassion.this, ChooseModeCompassion.class));

            }
        });

        nextbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compassion2();

            }
        });
    }

    public void compassion2(){
        videoPathCP36 = "android.resource://" + getPackageName() + "/" + R.raw.compassion2;
        uriCP36 = Uri.parse(videoPathCP36);
        videoViewCP36.setVideoURI(uriCP36);

        videoViewCP36.start();

        videoViewCP36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                compassion3();

            }
        });

        backbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compassion1();

            }
        });

        nextbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compassion3();

            }
        });
    }

    public void compassion3(){
        videoPathCP36 = "android.resource://" + getPackageName() + "/" + R.raw.compassion3;
        uriCP36 = Uri.parse(videoPathCP36);
        videoViewCP36.setVideoURI(uriCP36);

        videoViewCP36.start();

        videoViewCP36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                compassion4();

            }
        });

        backbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compassion2();

            }
        });

        nextbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compassion4();

            }
        });
    }

    public void compassion4(){
        videoPathCP36 = "android.resource://" + getPackageName() + "/" + R.raw.compassion4;
        uriCP36 = Uri.parse(videoPathCP36);
        videoViewCP36.setVideoURI(uriCP36);

        videoViewCP36.start();

        videoViewCP36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                compassion5();

            }
        });

        backbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compassion3();

            }
        });

        nextbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compassion5();

            }
        });
    }

    public void compassion5(){
        videoPathCP36 = "android.resource://" + getPackageName() + "/" + R.raw.compassion5;
        uriCP36 = Uri.parse(videoPathCP36);
        videoViewCP36.setVideoURI(uriCP36);

        videoViewCP36.start();

        videoViewCP36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonCompassion.this, CompassionLessonCongrats.class));

            }
        });

        backbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compassion4();

            }
        });

        nextbtnCP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonCompassion.this, CompassionLessonCongrats.class));

            }
        });
    }
}