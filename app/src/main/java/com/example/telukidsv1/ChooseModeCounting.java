package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeCounting extends AppCompatActivity {

    ImageButton backCMCN,learnCMCN,assessCMCN,replayCMCN;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);

        backCMCN = findViewById(R.id.bconceptsbtnCM);
        learnCMCN = findViewById(R.id.learnCM);
        assessCMCN = findViewById(R.id.assessCM);
        replayCMCN = findViewById(R.id.replayintroCM);

        BackgroundSoundService.onResume();

        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        backCMCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                startActivity(new Intent(ChooseModeCounting.this,Numbers.class));
            }
        });

        learnCMCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                startActivity(new Intent(ChooseModeCounting.this, LessonCounting.class));
            }
        });

        assessCMCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                startActivity(new Intent(ChooseModeCounting.this,QuizCountingNumbers.class));
            }
        });

        replayCMCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                startActivity(new Intent(ChooseModeCounting.this,LessonIntroCounting.class));
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