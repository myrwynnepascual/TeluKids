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

public class LessonIntroObedience extends AppCompatActivity {

    ImageButton btncloseO;
    VideoView videoViewO;
    String videoPathO;
    Uri uriO;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_obedience);

        btncloseO = findViewById(R.id.btncloseO79);
        videoViewO = findViewById(R.id.videoO79);
        videoPathO = "android.resource://" + getPackageName() + "/" + R.raw.obedienceintrovideo;
        uriO = Uri.parse(videoPathO);
        videoViewO.setVideoURI(uriO);

        MediaController mediaController = new MediaController(this);
        videoViewO.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewO);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();


        videoViewO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewO.start();

            }
        });

        btncloseO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                videoViewO.stopPlayback();
                startActivity(new Intent(LessonIntroObedience.this,ChooseModeObedience.class));
            }
        });

        videoViewO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewO.stopPlayback();
                startActivity(new Intent(LessonIntroObedience.this,ChooseModeObedience.class));
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