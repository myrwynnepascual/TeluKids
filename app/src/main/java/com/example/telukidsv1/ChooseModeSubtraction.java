package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeSubtraction extends AppCompatActivity {

    ImageButton backCMSB,learnCMSB,assessCMSB,replayCMSB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_subtraction);

        backCMSB = findViewById(R.id.bconceptsbtnCMSB);
        learnCMSB = findViewById(R.id.learnCMSB);
        assessCMSB = findViewById(R.id.assessCMSB);
        replayCMSB = findViewById(R.id.replayintroCMSB);

        backCMSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeSubtraction.this,Numbers.class));
            }
        });

        learnCMSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeSubtraction.this, LessonSubtraction.class));
            }
        });

        assessCMSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeSubtraction.this,QuizSubtraction.class));
            }
        });

        replayCMSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeSubtraction.this,LessonIntroAddition.class));
            }
        });
    }
}