package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeColors extends AppCompatActivity {

    ImageButton backCMC,learnCMC,assessCMC,replayCMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_colors);

        backCMC = findViewById(R.id.bconceptsbtnCMC);
        learnCMC = findViewById(R.id.learnCMC);
        assessCMC = findViewById(R.id.assessCMC);
        replayCMC = findViewById(R.id.replayintroCMC);

        backCMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeColors.this,BasicConcepts.class));
            }
        });

        learnCMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeColors.this, Red1.class));
            }
        });

        assessCMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeColors.this,QuizColors.class));
            }
        });

        replayCMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeColors.this,LessonIntroCounting.class));
            }
        });
    }
}