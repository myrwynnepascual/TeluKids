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

public class StarPage2 extends AppCompatActivity {

    VideoView videoViewSTPG2 ;
    ImageButton backSTPG2,nextbtnSTPG2  ;
    String videoPathSTPG2 ;
    Uri uriSTPG2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_page2);

        videoViewSTPG2  = findViewById(R.id.videoSTPG2 );
        backSTPG2  = findViewById(R.id.btnbackSTPG2 );
        nextbtnSTPG2  = findViewById(R.id.nextbtnSTPG2 );

        videoPathSTPG2  = "android.resource://" + getPackageName() + "/" + R.raw.star2;
        uriSTPG2  = Uri.parse(videoPathSTPG2 );
        videoViewSTPG2 .setVideoURI(uriSTPG2 );

        MediaController mediaController= new MediaController(this);
        videoViewSTPG2.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewSTPG2);

        videoViewSTPG2 .start();

        videoViewSTPG2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(StarPage2.this, StarPage3.class));

            }
        });

        backSTPG2 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StarPage2.this,StarPage1.class));
            }
        });

        nextbtnSTPG2 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StarPage2.this, StarPage3.class));

            }
        });
    }
}