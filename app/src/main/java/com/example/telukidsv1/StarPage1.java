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

public class StarPage1 extends AppCompatActivity {
    VideoView videoViewSTPG1 ;
    ImageButton backSTPG1,nextbtnSTPG1;
    String videoPathSTPG1;
    Uri uriSTPG1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_page1);

        videoViewSTPG1  = findViewById(R.id.videoSTPG1 );
        backSTPG1  = findViewById(R.id.btnbackSTPG1 );
        nextbtnSTPG1  = findViewById(R.id.nextbtnSTPG1 );

        videoPathSTPG1  = "android.resource://" + getPackageName() + "/" + R.raw.star1;
        uriSTPG1  = Uri.parse(videoPathSTPG1 );
        videoViewSTPG1 .setVideoURI(uriSTPG1 );

        MediaController mediaController= new MediaController(this);
        videoViewSTPG1.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewSTPG1);

        videoViewSTPG1 .start();

        videoViewSTPG1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(StarPage1.this, StarPage2.class));

            }
        });
        
        backSTPG1 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StarPage1.this,SquarePage6.class));
            }
        });

        nextbtnSTPG1 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StarPage1.this, StarPage2.class));

            }
        });
    }
}