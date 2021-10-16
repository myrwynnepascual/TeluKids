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

public class LessonIntroDoingGood extends AppCompatActivity {

    ImageButton btncloseDG;
    VideoView videoViewDG;
    String videoPathDG;
    Uri uriDG;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_vid);

        btncloseDG = findViewById(R.id.btncloseLIV);
        videoViewDG = findViewById(R.id.videoLIV);
        videoPathDG = "android.resource://" + getPackageName() + "/" + R.raw.goodintrovideo;
        uriDG = Uri.parse(videoPathDG);
        videoViewDG.setVideoURI(uriDG);

        MediaController mediaController = new MediaController(this);
        videoViewDG.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewDG);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();

        videoViewDG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewDG.start();

            }
        });

        btncloseDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewDG.stopPlayback();
                startActivity(new Intent(LessonIntroDoingGood.this,ChooseModeDoingGood.class));

            }
        });

        videoViewDG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewDG.stopPlayback();
                startActivity(new Intent(LessonIntroDoingGood.this,ChooseModeDoingGood.class));

            }
        });
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(LessonIntroDoingGood.this,Gmrc7to9.class));
    }

    @Override
    protected void onUserLeaveHint(){

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

        videoViewDG.pause();
        currentPosition = videoViewDG.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewDG.seekTo(currentPosition);
        videoViewDG.start();

        super.onResume();

    }
}