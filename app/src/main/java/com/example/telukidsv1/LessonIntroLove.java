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

public class LessonIntroLove extends AppCompatActivity {

    ImageButton btncloseL;
    VideoView videoViewL;
    String videoPathL;
    Uri uriL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_love);

        btncloseL = findViewById(R.id.btncloseL79);
        videoViewL = findViewById(R.id.videoL79);
        videoPathL = "android.resource://" + getPackageName() + "/" + R.raw.loveintrovideo;
        uriL = Uri.parse(videoPathL);
        videoViewL.setVideoURI(uriL);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();

        MediaController mediaController = new MediaController(this);
        videoViewL.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewL);

        videoViewL.start();


        btncloseL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
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