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

public class LessonIntroSubtraction extends AppCompatActivity {

    ImageButton btncloseISB;
    VideoView videoViewISB;
    String videoPathISB;
    Uri uriISB;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_vid);

        btncloseISB = findViewById(R.id.btncloseLIV);
        videoViewISB = findViewById(R.id.videoLIV);
        videoPathISB = "android.resource://" + getPackageName() + "/" + R.raw.subtractionintrovideo;
        uriISB = Uri.parse(videoPathISB);
        videoViewISB.setVideoURI(uriISB);

        MediaController mediaController = new MediaController(this);
        videoViewISB.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewISB);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();


        videoViewISB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewISB.start();

            }
        });

        btncloseISB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewISB.stopPlayback();
                startActivity(new Intent(LessonIntroSubtraction.this,ChooseModeSubtraction.class));

            }
        });

        videoViewISB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewISB.stopPlayback();
                startActivity(new Intent(LessonIntroSubtraction.this,ChooseModeSubtraction.class));

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

        videoViewISB.pause();
        currentPosition = videoViewISB.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewISB.seekTo(currentPosition);
        videoViewISB.start();

        super.onResume();

    }
}