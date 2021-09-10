package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroSubtraction extends AppCompatActivity {

    VideoView videoViewISB;
    String videoPathISB;
    Uri uriISB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_subtraction);

        videoViewISB = findViewById(R.id.videoISB);
        videoPathISB = "android.resource://" + getPackageName() + "/" + R.raw.shapesintrovideo;
        uriISB = Uri.parse(videoPathISB);
        videoViewISB.setVideoURI(uriISB);

        MediaController mediaController = new MediaController(this);
        videoViewISB.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewISB);

        videoViewISB.start();


        videoViewISB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonIntroSubtraction.this,ChooseModeSubtraction.class));

            }
        });

        videoViewISB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroSubtraction.this,ChooseModeSubtraction.class));

            }
        });
    }
}