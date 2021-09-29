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

public class LessonIntroRespect extends AppCompatActivity {

    ImageButton btncloseIR;
    VideoView videoViewIR;
    String videoPathIR;
    Uri uriIR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_respect);

        btncloseIR = findViewById(R.id.btncloseIR);
        videoViewIR = findViewById(R.id.videoIR);
        videoPathIR = "android.resource://" + getPackageName() + "/" + R.raw.respectintrovideo;
        uriIR = Uri.parse(videoPathIR);
        videoViewIR.setVideoURI(uriIR);

        MediaController mediaController = new MediaController(this);
        videoViewIR.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIR);

        videoViewIR.start();


        btncloseIR.setOnClickListener(new View.OnClickListener() {
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

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btncloseIR.setVisibility(View.VISIBLE);
            }
        },5000);
    }
}