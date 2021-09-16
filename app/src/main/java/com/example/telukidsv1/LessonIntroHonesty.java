package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroHonesty extends AppCompatActivity {

    VideoView videoViewIH;
    String videoPathIH;
    Uri uriIH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_honesty);

        videoViewIH = findViewById(R.id.videoIH);
        videoPathIH = "android.resource://" + getPackageName() + "/" + R.raw.honestyintrovideo;
        uriIH = Uri.parse(videoPathIH);
        videoViewIH.setVideoURI(uriIH);

        MediaController mediaController = new MediaController(this);
        videoViewIH.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIH);

        videoViewIH.start();


        videoViewIH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonIntroHonesty.this,ChooseModeHonesty.class));

            }
        });

        videoViewIH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroHonesty.this,ChooseModeHonesty.class));

            }
        });
        
    }
}