package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroDoingGood extends AppCompatActivity {

    VideoView videoViewDG;
    String videoPathDG;
    Uri uriDG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_doing_good);

        videoViewDG = findViewById(R.id.videoDG79);
        videoPathDG = "android.resource://" + getPackageName() + "/" + R.raw.goodintrovideo;
        uriDG = Uri.parse(videoPathDG);
        videoViewDG.setVideoURI(uriDG);

        MediaController mediaController = new MediaController(this);
        videoViewDG.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewDG);

        videoViewDG.start();


        videoViewDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonIntroDoingGood.this,ChooseModeDoingGood.class));

            }
        });

        videoViewDG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroDoingGood.this,ChooseModeDoingGood.class));

            }
        });
    }
}