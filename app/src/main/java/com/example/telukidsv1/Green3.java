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

public class Green3 extends AppCompatActivity {

    VideoView videoViewGRPG3;
    String videoPathGRPG3;
    Uri uriGRPG3;
    ImageButton backbtnGRPG3,nextbtnGRPG3;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green3);

        videoViewGRPG3 = findViewById(R.id.videoGRPG3);
        backbtnGRPG3 = findViewById(R.id.btnbackGRPG3);
        nextbtnGRPG3 = findViewById(R.id.nextbtnGRPG3);

        videoPathGRPG3 = "android.resource://" + getPackageName() + "/" + R.raw.green3;
        uriGRPG3 = Uri.parse(videoPathGRPG3);
        videoViewGRPG3.setVideoURI(uriGRPG3);

        mediaController = new MediaController(this);
        videoViewGRPG3.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewGRPG3);

        videoViewGRPG3.start();

        videoViewGRPG3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Green3.this, Green4.class));

            }
        });

        backbtnGRPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green3.this,Green2.class));

            }
        });

        nextbtnGRPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Green3.this, Green4.class));

            }
        });
    }
}