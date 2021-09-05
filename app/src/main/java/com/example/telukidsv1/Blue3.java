package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class Blue3 extends AppCompatActivity {

    VideoView videoViewBDPG3;
    String videoPathBDPG3;
    Uri uriBDPG3;
    ImageButton backbtnBDPG3,nextbtnBDPG3;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue3);

        videoViewBDPG3 = findViewById(R.id.videoBDPG3);
        backbtnBDPG3 = findViewById(R.id.btnbackBDPG3);
        nextbtnBDPG3 = findViewById(R.id.nextbtnBDPG3);

        videoPathBDPG3 = "android.resource://" + getPackageName() + "/" + R.raw.blue3;
        uriBDPG3 = Uri.parse(videoPathBDPG3);
        videoViewBDPG3.setVideoURI(uriBDPG3);

        mediaController = new MediaController(this);
        videoViewBDPG3.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewBDPG3);

        videoViewBDPG3.start();

        videoViewBDPG3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Blue3.this, Blue4.class));

            }
        });

        backbtnBDPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue3.this,Blue2.class));

            }
        });

        nextbtnBDPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Blue3.this, Blue4.class));

            }
        });
    }
}