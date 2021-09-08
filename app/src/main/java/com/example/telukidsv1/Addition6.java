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

public class Addition6 extends AppCompatActivity {

    VideoView videoViewA6;
    String videoPathA6;
    Uri uriA6;
    ImageButton backbtnA6,nextbtnA6;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition6);

        videoViewA6 = findViewById(R.id.videoA6);
        backbtnA6 = findViewById(R.id.btnbackA6);
        nextbtnA6 = findViewById(R.id.nextbtnA6);

        videoPathA6 = "android.resource://" + getPackageName() + "/" + R.raw.addition1;
        uriA6 = Uri.parse(videoPathA6);
        videoViewA6.setVideoURI(uriA6);

        mediaController = new MediaController(this);
        videoViewA6.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewA6);

        videoViewA6.start();

        videoViewA6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Addition6.this, Addition7.class));

            }
        });

        backbtnA6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition6.this,Addition5.class));

            }
        });

        nextbtnA6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition6.this, Addition7.class));

            }
        });
    }
}