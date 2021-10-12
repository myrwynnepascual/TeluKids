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

public class LessonIntroHonesty extends AppCompatActivity {

    ImageButton btncloseIH;
    VideoView videoViewIH;
    String videoPathIH;
    Uri uriIH;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_vid);

        btncloseIH = findViewById(R.id.btncloseLIV);
        videoViewIH = findViewById(R.id.videoLIV);
        videoPathIH = "android.resource://" + getPackageName() + "/" + R.raw.honestyintrovideo;
        uriIH = Uri.parse(videoPathIH);
        videoViewIH.setVideoURI(uriIH);

        MediaController mediaController = new MediaController(this);
        videoViewIH.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIH);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();

        videoViewIH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewIH.start();

            }
        });

        btncloseIH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewIH.stopPlayback();
                startActivity(new Intent(LessonIntroHonesty.this,ChooseModeHonesty.class));

            }
        });

        videoViewIH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewIH.stopPlayback();
                startActivity(new Intent(LessonIntroHonesty.this,ChooseModeHonesty.class));

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

        videoViewIH.pause();
        currentPosition = videoViewIH.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewIH.seekTo(currentPosition);
        videoViewIH.start();

        super.onResume();

    }
}