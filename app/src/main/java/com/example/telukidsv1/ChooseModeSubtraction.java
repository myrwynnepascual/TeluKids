package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeSubtraction extends AppCompatActivity {

    ImageButton backCMSB,learnCMSB,assessCMSB,replayCMSB;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);

        backCMSB = findViewById(R.id.bconceptsbtnCM);
        learnCMSB = findViewById(R.id.learnCM);
        assessCMSB = findViewById(R.id.assessCM);
        replayCMSB = findViewById(R.id.replayintroCM);

        BackgroundSoundService.onResume();

        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        backCMSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeSubtraction.this,Numbers.class));
            }
        });

        learnCMSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeSubtraction.this, LessonSubtraction.class));
            }
        });

        assessCMSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeSubtraction.this,QuizSubtraction.class));
            }
        });

        replayCMSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeSubtraction.this,LessonIntroSubtraction.class));
            }
        });

    }

    @Override
    public void onBackPressed(){

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