package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeAddition extends AppCompatActivity {

    ImageButton backCMA,learnCMA,assessCMA,replayCMA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_addition);

        backCMA = findViewById(R.id.bconceptsbtnCMA);
        learnCMA = findViewById(R.id.learnCMA);
        assessCMA = findViewById(R.id.assessCMA);
        replayCMA = findViewById(R.id.replayintroCMA);

        //Intent svc = new Intent(this, BackgroundSoundService.class);
        //startService(svc);

        backCMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeAddition.this,Numbers.class));
            }
        });

        learnCMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeAddition.this, LessonAddition.class));
            }
        });

        assessCMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeAddition.this,QuizAddition.class));
            }
        });

        replayCMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeAddition.this,LessonIntroAddition.class));
            }
        });
    }
}