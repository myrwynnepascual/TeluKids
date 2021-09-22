package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroRespect extends AppCompatActivity {

    VideoView videoViewIR;
    String videoPathIR;
    Uri uriIR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_respect);

        videoViewIR = findViewById(R.id.videoIR);
        videoPathIR = "android.resource://" + getPackageName() + "/" + R.raw.respectintrovideo;
        uriIR = Uri.parse(videoPathIR);
        videoViewIR.setVideoURI(uriIR);

        MediaController mediaController = new MediaController(this);
        videoViewIR.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIR);

        videoViewIR.start();


        videoViewIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonIntroRespect.this,ChooseModeRespect.class));

            }
        });

        videoViewIR.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroRespect.this,ChooseModeRespect.class));

            }
        });
    }
}