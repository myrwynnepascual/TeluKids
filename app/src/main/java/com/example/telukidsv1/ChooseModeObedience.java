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
        setContentView(R.layout.activity_choose_mode_obedience);

        backCMO79 = findViewById(R.id.bconceptsbtnCMO79);
        learnCMO79 = findViewById(R.id.learnCMO79);
        assessCMO79 = findViewById(R.id.assessCMO79);
        replayCMO79 = findViewById(R.id.replayintroCMO79);

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

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }
}