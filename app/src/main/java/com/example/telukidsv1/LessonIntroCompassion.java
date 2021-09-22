package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroCompassion extends AppCompatActivity {

    VideoView videoViewICP;
    String videoPathICP;
    Uri uriICP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_compassion);

        videoViewICP = findViewById(R.id.videoICP);
        videoPathICP = "android.resource://" + getPackageName() + "/" + R.raw.compassionintrovideo;
        uriICP = Uri.parse(videoPathICP);
        videoViewICP.setVideoURI(uriICP);

        MediaController mediaController = new MediaController(this);
        videoViewICP.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewICP);

        videoViewICP.start();


        videoViewICP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonIntroCompassion.this,ChooseModeCompassion.class));

            }
        });

        videoViewICP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroCompassion.this,ChooseModeCompassion.class));

            }
        });
    }
}