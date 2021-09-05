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

public class RectanglePage3 extends AppCompatActivity {

    VideoView videoViewRPG3;
    String videoPathRPG3;
    Uri uriRPG3;
    ImageButton backbtnRPG3,nextbtnRPG3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_page3);

        videoViewRPG3 = findViewById(R.id.videoRPG3);
        backbtnRPG3 = findViewById(R.id.btnbackRPG3);
        nextbtnRPG3 = findViewById(R.id.nextbtnRPG3);

        videoPathRPG3 = "android.resource://" + getPackageName() + "/" + R.raw.rectangle3;
        uriRPG3 = Uri.parse(videoPathRPG3);
        videoViewRPG3.setVideoURI(uriRPG3);

        MediaController mediaController= new MediaController(this);
        videoViewRPG3.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewRPG3);

        videoViewRPG3.start();

        videoViewRPG3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(RectanglePage3.this, RectanglePage4.class));

            }
        });

        backbtnRPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RectanglePage3.this,RectanglePage2.class));

            }
        });

        nextbtnRPG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RectanglePage3.this, RectanglePage4.class));

            }
        });
    }
}