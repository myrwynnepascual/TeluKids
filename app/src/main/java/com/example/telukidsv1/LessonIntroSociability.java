package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroSociability extends AppCompatActivity {

    VideoView videoViewISC;
    String videoPathISC;
    Uri uriISC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_sociability);

        videoViewISC = findViewById(R.id.videoISC);
        videoPathISC = "android.resource://" + getPackageName() + "/" + R.raw.shapesintrovideo;
        uriISC = Uri.parse(videoPathISC);
        videoViewISC.setVideoURI(uriISC);

        MediaController mediaController = new MediaController(this);
        videoViewISC.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewISC);

        videoViewISC.start();


        videoViewISC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonIntroSociability.this,ChooseModeSociability.class));

            }
        });

        videoViewISC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroSociability.this,ChooseModeSociability.class));

            }
        });
    }
}