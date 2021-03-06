package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeShapes extends AppCompatActivity {

    ImageButton backCMS,learnCMS,assessCMS,replayCMS;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);

        backCMS = findViewById(R.id.bconceptsbtnCM);
        learnCMS = findViewById(R.id.learnCM);
        assessCMS = findViewById(R.id.assessCM);
        replayCMS = findViewById(R.id.replayintroCM);

        BackgroundSoundService.onResume();

        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        backCMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeShapes.this,BasicConcepts.class));
            }
        });

        learnCMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeShapes.this, LessonShapes.class));
            }
        });

        assessCMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeShapes.this,QuizShapes.class));
            }
        });

        replayCMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeShapes.this,LessonIntroShapes.class));
            }
        });

    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(ChooseModeShapes.this,BasicConcepts.class));
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