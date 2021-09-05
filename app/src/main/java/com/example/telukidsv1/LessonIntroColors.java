package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroColors extends AppCompatActivity {

    VideoView videoViewIC;
    String videoPathIC;
    Uri uriIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_colors);

        videoViewIC = findViewById(R.id.videoIC);
        videoPathIC = "android.resource://" + getPackageName() + "/" + R.raw.colorsintrovideo;
        uriIC = Uri.parse(videoPathIC);
        videoViewIC.setVideoURI(uriIC);

        MediaController mediaController = new MediaController(this);
        videoViewIC.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIC);

        videoViewIC.start();


        videoViewIC.setOnClickListener(new View.OnClickListener() {
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
    }
}