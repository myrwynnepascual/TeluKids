package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeAddition extends AppCompatActivity {

    ImageButton backCMA,learnCMA,assessCMA,replayCMA;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);

        backCMA = findViewById(R.id.bconceptsbtnCM);
        learnCMA = findViewById(R.id.learnCM);
        assessCMA = findViewById(R.id.assessCM);
        replayCMA = findViewById(R.id.replayintroCM);

        BackgroundSoundService.onResume();

        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        backCMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeAddition.this,Numbers.class));
            }
        });

        learnCMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeAddition.this, LessonAddition.class));
            }
        });

        assessCMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeAddition.this, QuizAddition.class));
            }
        });

        replayCMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeAddition.this,LessonIntroAddition.class));
            }
        });

    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(ChooseModeAddition.this,Numbers.class));
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