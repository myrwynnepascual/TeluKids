package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeCompassion extends AppCompatActivity {

    ImageButton backCMCP,learnCMCP,assessCMCP,replayCMCP;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_compassion);

        backCMCP = findViewById(R.id.bconceptsbtnCMCP);
        learnCMCP = findViewById(R.id.learnCMCP);
        assessCMCP = findViewById(R.id.assessCMCP);
        replayCMCP = findViewById(R.id.replayintroCMCP);

        BackgroundSoundService.onResume();

        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        backCMCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeCompassion.this, Gmrc3to6.class));
            }
        });

        learnCMCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeCompassion.this, LessonCompassion.class));
            }
        });

        assessCMCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeCompassion.this,QuizCompassion.class));
            }
        });

        replayCMCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeCompassion.this,LessonIntroCompassion.class));
            }
        });

    }

    @Override
    protected void onUserLeaveHint(){
        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

        super.onUserLeaveHint();
    }
}