package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroObedience extends AppCompatActivity {

    VideoView videoViewO;
    String videoPathO;
    Uri uriO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_obedience);

        videoViewO = findViewById(R.id.videoO79);
        videoPathO = "android.resource://" + getPackageName() + "/" + R.raw.obedienceintrovideo;
        uriO = Uri.parse(videoPathO);
        videoViewO.setVideoURI(uriO);

        MediaController mediaController = new MediaController(this);
        videoViewO.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewO);

        videoViewO.start();


        videoViewO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonIntroObedience.this,ChooseModeObedience.class));

            }
        });

        videoViewO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroObedience.this,ChooseModeObedience.class));

            }
        });
    }
}