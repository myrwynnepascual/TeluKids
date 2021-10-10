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

public class LessonIntroCompassion extends AppCompatActivity {

    ImageButton btncloseICP;
    VideoView videoViewICP;
    String videoPathICP;
    Uri uriICP;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_compassion);

        btncloseICP = findViewById(R.id.btncloseICP);
        videoViewICP = findViewById(R.id.videoICP);
        videoPathICP = "android.resource://" + getPackageName() + "/" + R.raw.compassionintrovideo;
        uriICP = Uri.parse(videoPathICP);
        videoViewICP.setVideoURI(uriICP);

        MediaController mediaController = new MediaController(this);
        videoViewICP.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewICP);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();


        videoViewICP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewICP.start();

            }
        });

        btncloseICP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                videoViewICP.stopPlayback();
                startActivity(new Intent(LessonIntroCompassion.this,ChooseModeCompassion.class));

            }
       });

       videoViewICP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
           @Override
           public void onCompletion(MediaPlayer mp) {

               videoViewICP.stopPlayback();
               startActivity(new Intent(LessonIntroCompassion.this,ChooseModeCompassion.class));

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