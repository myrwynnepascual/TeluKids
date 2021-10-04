package com.example.telukidsv1;

import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class LessonIntroShapes extends AppCompatActivity {

    ImageButton btncloseIS;
    VideoView videoViewIS;
    String videoPathIS;
    Uri uriIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_shapes);

        btncloseIS = findViewById(R.id.btncloseIS);
        videoViewIS = findViewById(R.id.videoIS);
        videoPathIS = "android.resource://" + getPackageName() + "/" + R.raw.shapesintrovideo;
        uriIS = Uri.parse(videoPathIS);
        videoViewIS.setVideoURI(uriIS);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();

        MediaController mediaController = new MediaController(this);
        videoViewIS.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIS);

        videoViewIS.start();


        btncloseIS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LessonIntroShapes.this,ChooseModeShapes.class));

            }
        });

        videoViewIS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroShapes.this,ChooseModeShapes.class));

            }
        });

    }
}