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

public class LessonIntroLove extends AppCompatActivity {

    ImageButton btncloseIL;
    VideoView videoViewIL;
    String videoPathIL;
    Uri uriIL;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_vid);

        btncloseIL = findViewById(R.id.btncloseLIV);
        videoViewIL = findViewById(R.id.videoLIV);
        videoPathIL = "android.resource://" + getPackageName() + "/" + R.raw.loveintrovideo;
        uriIL = Uri.parse(videoPathIL);
        videoViewIL.setVideoURI(uriIL);

        MediaController mediaController = new MediaController(this);
        videoViewIL.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIL);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();


        videoViewIL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewIL.start();

            }
        });

        btncloseIL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewIL.stopPlayback();
                startActivity(new Intent(LessonIntroLove.this,ChooseModeLove.class));

            }
        });

        videoViewIL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewIL.stopPlayback();
                startActivity(new Intent(LessonIntroLove.this,ChooseModeLove.class));

            }
        });
    }

    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onUserLeaveHint(){

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

        videoViewIL.pause();
        currentPosition = videoViewIL.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewIL.seekTo(currentPosition);
        videoViewIL.start();

        super.onResume();

    }
}