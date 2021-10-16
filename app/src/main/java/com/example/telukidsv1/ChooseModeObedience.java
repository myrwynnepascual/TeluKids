package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeObedience extends AppCompatActivity {

    ImageButton backCMO79,learnCMO79,assessCMO79,replayCMO79;
    MediaPlayer sfx ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);

        backCMO79 = findViewById(R.id.bconceptsbtnCM);
        learnCMO79 = findViewById(R.id.learnCM);
        assessCMO79 = findViewById(R.id.assessCM);
        replayCMO79 = findViewById(R.id.replayintroCM);

        BackgroundSoundService.onResume();

        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        backCMO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeObedience.this,Gmrc7to9.class));
            }
        });

        learnCMO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeObedience.this, LessonObedience.class));
            }
        });

        assessCMO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeObedience.this, QuizObedience.class));
            }
        });

        replayCMO79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeObedience.this,LessonIntroObedience.class));
            }
        });

    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(ChooseModeObedience.this,Gmrc7to9.class));
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