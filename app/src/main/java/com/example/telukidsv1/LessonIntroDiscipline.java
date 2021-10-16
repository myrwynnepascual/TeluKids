package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroDiscipline extends AppCompatActivity {

    ImageButton btnCloseID;
    VideoView videoViewID;
    String videoPathID;
    Uri uriID;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_vid);

        btnCloseID = findViewById(R.id.btncloseLIV);
        videoViewID = findViewById(R.id.videoLIV);
        videoPathID = "android.resource://" + getPackageName() + "/" + R.raw.disciplineintrovideo;
        uriID = Uri.parse(videoPathID);
        videoViewID.setVideoURI(uriID);

        MediaController mediaController = new MediaController(this);
        videoViewID.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewID);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        BackgroundSoundService.onPause();


        videoViewID.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewID.start();

            }
        });

        btnCloseID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LessonIntroDiscipline.this,ChooseModeDiscipline.class));

            }
        });

        videoViewID.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonIntroDiscipline.this,ChooseModeDiscipline.class));

            }
        });
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(LessonIntroDiscipline.this,Gmrc3to6.class));
    }

    @Override
    protected void onUserLeaveHint(){

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

        videoViewID.pause();
        currentPosition = videoViewID.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewID.seekTo(currentPosition);
        videoViewID.start();

        super.onResume();

    }
}