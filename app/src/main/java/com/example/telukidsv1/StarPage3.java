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

public class StarPage3 extends AppCompatActivity {

    VideoView videoViewSTPG3 ;
    ImageButton backSTPG3,nextbtnSTPG3  ;
    String videoPathSTPG3 ;
    Uri uriSTPG3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_page3);

        videoViewSTPG3  = findViewById(R.id.videoSTPG3 );
        backSTPG3  = findViewById(R.id.btnbackSTPG3 );
        nextbtnSTPG3  = findViewById(R.id.nextbtnSTPG3 );

        videoPathSTPG3  = "android.resource://" + getPackageName() + "/" + R.raw.star3;
        uriSTPG3  = Uri.parse(videoPathSTPG3 );
        videoViewSTPG3 .setVideoURI(uriSTPG3 );

        MediaController mediaController= new MediaController(this);
        videoViewSTPG3.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewSTPG3);

        videoViewSTPG3 .start();

        videoViewSTPG3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(StarPage3.this, StarPage4.class));

            }
        });

        backSTPG3 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StarPage3.this,StarPage2.class));
            }
        });

        nextbtnSTPG3 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StarPage3.this, StarPage4.class));

            }
        });
    }
}