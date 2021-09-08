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

public class Addition7 extends AppCompatActivity {

    VideoView videoViewA7;
    String videoPathA7;
    Uri uriA7;
    ImageButton backbtnA7,nextbtnA7;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition7);

        videoViewA7 = findViewById(R.id.videoA7);
        backbtnA7 = findViewById(R.id.btnbackA7);
        nextbtnA7 = findViewById(R.id.nextbtnA7);

        videoPathA7 = "android.resource://" + getPackageName() + "/" + R.raw.addition7;
        uriA7 = Uri.parse(videoPathA7);
        videoViewA7.setVideoURI(uriA7);

        mediaController = new MediaController(this);
        videoViewA7.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewA7);

        videoViewA7.start();

        videoViewA7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(Addition7.this, Addition8.class));

            }
        });

        backbtnA7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition7.this,Addition6.class));

            }
        });

        nextbtnA7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Addition7.this, Addition8.class));

            }
        });
    }
}