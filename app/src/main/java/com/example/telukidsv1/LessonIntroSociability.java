package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroSociability extends AppCompatActivity {

    ImageButton btncloseICS;
    VideoView videoViewISC;
    String videoPathISC;
    Uri uriISC;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_vid);

        btncloseICS = findViewById(R.id.btncloseLIV);
        videoViewISC = findViewById(R.id.videoLIV);
        videoPathISC = "android.resource://" + getPackageName() + "/" + R.raw.sociabilityintrovideo;
        uriISC = Uri.parse(videoPathISC);
        videoViewISC.setVideoURI(uriISC);

        MediaController mediaController = new MediaController(this);
        videoViewISC.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewISC);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();


        videoViewISC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewISC.start();

            }
        });

        btncloseICS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewISC.stopPlayback();
                startActivity(new Intent(LessonIntroSociability.this,ChooseModeSociability.class));

            }
        });

        videoViewISC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewISC.stopPlayback();
                startActivity(new Intent(LessonIntroSociability.this,ChooseModeSociability.class));

            }
        });
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(LessonIntroSociability.this,Gmrc3to6.class));
    }

    @Override
    protected void onUserLeaveHint(){

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

        videoViewISC.pause();
        currentPosition = videoViewISC.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewISC.seekTo(currentPosition);
        videoViewISC.start();

        super.onResume();

    }
}