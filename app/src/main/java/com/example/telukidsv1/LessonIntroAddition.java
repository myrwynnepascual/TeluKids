package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroAddition extends AppCompatActivity {

    ImageButton btncloseIA;
    VideoView videoViewIA;
    String videoPathIA;
    Uri uriIA;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_addition);

        btncloseIA = findViewById(R.id.btncloseIA);
        videoViewIA = findViewById(R.id.videoIA);
        videoPathIA = "android.resource://" + getPackageName() + "/" + R.raw.additionintrovideo;
        uriIA = Uri.parse(videoPathIA);
        videoViewIA.setVideoURI(uriIA);

        MediaController mediaController = new MediaController(this);
        videoViewIA.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIA);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();


        videoViewIA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewIA.start();

            }
        });

        btncloseIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewIA.stopPlayback();
                startActivity(new Intent(LessonIntroAddition.this,ChooseModeAddition.class));

            }
        });

        videoViewIA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewIA.stopPlayback();
                startActivity(new Intent(LessonIntroAddition.this,ChooseModeAddition.class));

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