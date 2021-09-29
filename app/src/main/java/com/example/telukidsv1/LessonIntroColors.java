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

public class LessonIntroColors extends AppCompatActivity {

    ImageButton btncloseIC;
    VideoView videoViewIC;
    String videoPathIC;
    Uri uriIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_colors);

        btncloseIC = findViewById(R.id.btncloseIC);
        videoViewIC = findViewById(R.id.videoIC);
        videoPathIC = "android.resource://" + getPackageName() + "/" + R.raw.colorsintrovideo;
        uriIC = Uri.parse(videoPathIC);
        videoViewIC.setVideoURI(uriIC);

        MediaController mediaController = new MediaController(this);
        videoViewIC.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIC);

        videoViewIC.start();


        btncloseIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonIntroColors.this,ChooseModeColors.class));

            }
        });

        videoViewIC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroColors.this,ChooseModeColors.class));

            }
        });

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btncloseIC.setVisibility(View.VISIBLE);
            }
        },5000);
    }
}