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

public class LessonIntroResponsibility extends AppCompatActivity {

    ImageButton btncloseRP;
    VideoView videoViewRP;
    String videoPathRP;
    Uri uriRP;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_vid);

        btncloseRP = findViewById(R.id.btncloseLIV);
        videoViewRP = findViewById(R.id.videoLIV);
        videoPathRP = "android.resource://" + getPackageName() + "/" + R.raw.responsibilityintrovideo;
        uriRP = Uri.parse(videoPathRP);
        videoViewRP.setVideoURI(uriRP);

        MediaController mediaController = new MediaController(this);
        videoViewRP.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewRP);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();

        videoViewRP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewRP.start();

            }
        });

        btncloseRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewRP.stopPlayback();
                startActivity(new Intent(LessonIntroResponsibility.this,ChooseModeResponsibility.class));

            }
        });

        videoViewRP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewRP.stopPlayback();
                startActivity(new Intent(LessonIntroResponsibility.this,ChooseModeResponsibility.class));

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

        videoViewRP.pause();
        currentPosition = videoViewRP.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewRP.seekTo(currentPosition);
        videoViewRP.start();

        super.onResume();

    }
}