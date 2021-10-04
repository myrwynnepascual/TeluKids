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

public class LessonIntroCounting extends AppCompatActivity {

    ImageButton btnCloseICN;
    VideoView videoViewICN;
    String videoPathICN;
    Uri uriICN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_counting);

        btnCloseICN = findViewById(R.id.btncloseIC);
        videoViewICN = findViewById(R.id.videoIC);
        videoPathICN = "android.resource://" + getPackageName() + "/" + R.raw.countingintrovideo;
        uriICN = Uri.parse(videoPathICN);
        videoViewICN.setVideoURI(uriICN);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();

        MediaController mediaController = new MediaController(this);
        videoViewICN.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewICN);

        videoViewICN.start();


        btnCloseICN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LessonIntroCounting.this,ChooseModeCounting.class));

            }
        });

        videoViewICN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroCounting.this,ChooseModeCounting.class));

            }
        });
    }
}