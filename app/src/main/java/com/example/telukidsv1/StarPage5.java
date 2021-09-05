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

public class StarPage5 extends AppCompatActivity {

    VideoView videoViewSTPG5 ;
    ImageButton backSTPG5,nextbtnSTPG5  ;
    String videoPathSTPG5 ;
    Uri uriSTPG5 ;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_page5);

        videoViewSTPG5  = findViewById(R.id.videoSTPG5 );
        backSTPG5  = findViewById(R.id.btnbackSTPG5 );
        nextbtnSTPG5 = findViewById(R.id.nextbtnSTPG5);

        videoPathSTPG5  = "android.resource://" + getPackageName() + "/" + R.raw.star5;
        uriSTPG5  = Uri.parse(videoPathSTPG5 );
        videoViewSTPG5 .setVideoURI(uriSTPG5 );

        MediaController mediaController= new MediaController(this);
        videoViewSTPG5.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewSTPG5);

        videoViewSTPG5 .start();

        videoViewSTPG5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(StarPage5.this, StarPage6.class));

            }
        });

        backSTPG5 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StarPage5.this,StarPage4.class));
            }
        });

        nextbtnSTPG5 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StarPage5.this, StarPage6.class));

            }
        });
    }
}