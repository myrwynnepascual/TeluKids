package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroAddition extends AppCompatActivity {

    VideoView videoViewIA;
    String videoPathIA;
    Uri uriIA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_addition);

        videoViewIA = findViewById(R.id.videoIA);
        videoPathIA = "android.resource://" + getPackageName() + "/" + R.raw.shapesintrovideo;
        uriIA = Uri.parse(videoPathIA);
        videoViewIA.setVideoURI(uriIA);

        MediaController mediaController = new MediaController(this);
        videoViewIA.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIA);

        videoViewIA.start();


        videoViewIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonIntroAddition.this,ChooseModeAddition.class));

            }
        });

        videoViewIA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroAddition.this,ChooseModeAddition.class));

            }
        });
    }
}