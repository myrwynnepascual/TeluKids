package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeRespect extends AppCompatActivity {

    ImageButton backCMR,learnCMR,assessCMR,replayCMR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_respect);

        backCMR = findViewById(R.id.bconceptsbtnCMR);
        learnCMR = findViewById(R.id.learnCMR);
        assessCMR = findViewById(R.id.assessCMR);
        replayCMR = findViewById(R.id.replayintroCMR);

        backCMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeRespect.this,Gmrc3to6.class));
            }
        });

        learnCMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeRespect.this, LessonRespect.class));
            }
        });

        assessCMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeRespect.this, QuizRespect.class));
            }
        });

        replayCMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeRespect.this,LessonIntroRespect.class));
            }
        });
    }
}