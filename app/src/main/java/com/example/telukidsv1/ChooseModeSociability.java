package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeSociability extends AppCompatActivity {

    ImageButton backCMSC,learnCMSC,assessCMSC,replayCMSC;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);

        backCMSC = findViewById(R.id.bconceptsbtnCM);
        learnCMSC = findViewById(R.id.learnCM);
        assessCMSC = findViewById(R.id.assessCM);
        replayCMSC = findViewById(R.id.replayintroCM);

        BackgroundSoundService.onResume();

        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        backCMSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeSociability.this,Gmrc3to6.class));
            }
        });

        learnCMSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeSociability.this, LessonSociability.class));
            }
        });

        assessCMSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeSociability.this, QuizSociability.class));
            }
        });

        replayCMSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeSociability.this,LessonIntroSociability.class));
            }
        });

    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(ChooseModeSociability.this,Gmrc3to6.class));
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