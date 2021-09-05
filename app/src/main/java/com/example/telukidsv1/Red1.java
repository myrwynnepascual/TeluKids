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

public class Red1 extends AppCompatActivity {

    VideoView videoViewRDPG1;
    String videoPathRDPG1;
    Uri uriRDPG1;
    ImageButton backbtnRDPG1,nextbtnRDPG1;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red1);

        videoViewRDPG1 = findViewById(R.id.videoRDPG1);
        backbtnRDPG1 = findViewById(R.id.btnbackRDPG1);
        nextbtnRDPG1 = findViewById(R.id.nextbtnRDPG1);

        videoPathRDPG1 = "android.resource://" + getPackageName() + "/" + R.raw.red1;
        uriRDPG1 = Uri.parse(videoPathRDPG1);
        videoViewRDPG1.setVideoURI(uriRDPG1);

        mediaController = new MediaController(this);
        videoViewRDPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRDPG1);

        videoViewRDPG1.start();

        videoViewRDPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Red1.this, Red2.class));

            }
        });

        backbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red1.this,ChooseModeColors.class));

            }
        });

        nextbtnRDPG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Red1.this, Red2.class));

            }
        });
    }
}