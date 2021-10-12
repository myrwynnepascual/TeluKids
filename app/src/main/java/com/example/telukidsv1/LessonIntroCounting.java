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

public class LessonIntroCounting extends AppCompatActivity {

    ImageButton btnCloseICN;
    VideoView videoViewICN;
    String videoPathICN;
    Uri uriICN;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_vid);

        btnCloseICN = findViewById(R.id.btncloseLIV);
        videoViewICN = findViewById(R.id.videoLIV);
        videoPathICN = "android.resource://" + getPackageName() + "/" + R.raw.countingintrovideo;
        uriICN = Uri.parse(videoPathICN);
        videoViewICN.setVideoURI(uriICN);

        MediaController mediaController = new MediaController(this);
        videoViewICN.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewICN);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();


        videoViewICN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewICN.start();

            }
        });

        btnCloseICN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewICN.stopPlayback();
                startActivity(new Intent(LessonIntroCounting.this,ChooseModeCounting.class));

            }
        });

        videoViewICN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewICN.stopPlayback();
                startActivity(new Intent(LessonIntroCounting.this,ChooseModeCounting.class));

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

        videoViewICN.pause();
        currentPosition = videoViewICN.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewICN.seekTo(currentPosition);
        videoViewICN.start();

        super.onResume();

    }
}