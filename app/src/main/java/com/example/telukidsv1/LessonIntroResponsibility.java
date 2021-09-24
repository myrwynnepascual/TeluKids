package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroResponsibility extends AppCompatActivity {

    VideoView videoViewRP;
    String videoPathRP;
    Uri uriRP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_responsibility);

        videoViewRP = findViewById(R.id.videoRP79);
        videoPathRP = "android.resource://" + getPackageName() + "/" + R.raw.responsibilityintrovideo;
        uriRP = Uri.parse(videoPathRP);
        videoViewRP.setVideoURI(uriRP);

        MediaController mediaController = new MediaController(this);
        videoViewRP.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewRP);

        videoViewRP.start();


        videoViewRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonIntroResponsibility.this,ChooseModeResponsibility.class));

            }
        });

        videoViewRP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroResponsibility.this,ChooseModeResponsibility.class));

            }
        });
    }
}