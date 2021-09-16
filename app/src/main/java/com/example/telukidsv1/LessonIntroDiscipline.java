package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonIntroDiscipline extends AppCompatActivity {

    VideoView videoViewID;
    String videoPathID;
    Uri uriID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_intro_discipline);

        videoViewID = findViewById(R.id.videoID);
        videoPathID = "android.resource://" + getPackageName() + "/" + R.raw.disciplineintrovideo;
        uriID = Uri.parse(videoPathID);
        videoViewID.setVideoURI(uriID);

        MediaController mediaController = new MediaController(this);
        videoViewID.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewID);

        videoViewID.start();


        videoViewID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
}