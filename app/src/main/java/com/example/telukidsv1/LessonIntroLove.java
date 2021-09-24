package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroLove extends AppCompatActivity {

    VideoView videoViewL;
    String videoPathL;
    Uri uriL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_love);

        videoViewL = findViewById(R.id.videoL79);
        videoPathL = "android.resource://" + getPackageName() + "/" + R.raw.loveintrovideo;
        uriL = Uri.parse(videoPathL);
        videoViewL.setVideoURI(uriL);

        MediaController mediaController = new MediaController(this);
        videoViewL.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewL);

        videoViewL.start();


        videoViewL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonIntroLove.this,ChooseModeLove.class));

            }
        });

        videoViewL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroLove.this,ChooseModeLove.class));

            }
        });
    }
}