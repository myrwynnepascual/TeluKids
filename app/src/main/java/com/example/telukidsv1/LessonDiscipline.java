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

    VideoView videoViewD36;
    String videoPathD36;
    Uri uriD36;
    ImageButton backbtnD36,nextbtnD36;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_discipline);

        videoViewD36 = findViewById(R.id.videoD36);
        backbtnD36 = findViewById(R.id.btnbackD36);
        nextbtnD36 = findViewById(R.id.nextbtnD36);

        mediaController = new MediaController(this);
        videoViewD36.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewD36);

        discipline1();
    }

    public void discipline1(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline1;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);

        videoViewD36.start();

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                discipline2();

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonDiscipline.this,ChooseModeDiscipline.class));

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                discipline2();

            }
        });
    }

    public void discipline2(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline2;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);

        videoViewD36.start();

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                discipline3();

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                discipline1();

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                discipline3();

            }
        });
    }

    public void discipline3(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline3;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);

        videoViewD36.start();

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                discipline4();

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                discipline2();

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                discipline4();

            }
        });
    }

    public void discipline4(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline4;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);

        videoViewD36.start();

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                discipline5();

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                discipline3();

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                discipline5();

            }
        });
    }

    public void discipline5(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline5;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);

        videoViewD36.start();

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                discipline6();

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                discipline4();

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                discipline6();

            }
        });
    }

    public void discipline6(){
        videoPathD36 = "android.resource://" + getPackageName() + "/" + R.raw.discipline6;
        uriD36 = Uri.parse(videoPathD36);
        videoViewD36.setVideoURI(uriD36);

        videoViewD36.start();

        videoViewD36.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonDiscipline.this, DisciplineLessonCongrats.class));

            }
        });

        backbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                discipline5();

            }
        });

        nextbtnD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonDiscipline.this, DisciplineLessonCongrats.class));

            }
        });
    }
}