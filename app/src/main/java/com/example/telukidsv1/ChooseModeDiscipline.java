package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeDiscipline extends AppCompatActivity {

    ImageButton backCMD36,learnCMD36,assessCMD36,replayCMD36;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_discipline);

        backCMD36 = findViewById(R.id.bconceptsbtnCMD36);
        learnCMD36 = findViewById(R.id.learnCMD36);
        assessCMD36 = findViewById(R.id.assessCMD36);
        replayCMD36 = findViewById(R.id.replayintroCMD36);

        BackgroundSoundService.onResume();

        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);


        backCMD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeDiscipline.this,Gmrc3to6.class));
            }
        });

        learnCMD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeDiscipline.this, LessonDiscipline.class));
            }
        });

        assessCMD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeDiscipline.this, QuizDiscipline.class));
            }
        });

        replayCMD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ChooseModeDiscipline.this,LessonIntroDiscipline.class));
            }
        });
    }
}