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

public class LessonIntroSubtraction extends AppCompatActivity {

    ImageButton btncloseISB;
    VideoView videoViewISB;
    String videoPathISB;
    Uri uriISB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_subtraction);

        btncloseISB = findViewById(R.id.btncloseISB);
        videoViewISB = findViewById(R.id.videoISB);
        videoPathISB = "android.resource://" + getPackageName() + "/" + R.raw.subtractionintrovideo;
        uriISB = Uri.parse(videoPathISB);
        videoViewISB.setVideoURI(uriISB);

        MediaController mediaController = new MediaController(this);
        videoViewISB.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewISB);

        videoViewISB.start();


        btncloseISB.setOnClickListener(new View.OnClickListener() {
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

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btncloseISB.setVisibility(View.VISIBLE);
            }
        },5000);
    }
}