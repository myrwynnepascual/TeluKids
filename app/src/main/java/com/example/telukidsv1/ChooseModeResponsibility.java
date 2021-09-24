package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeResponsibility extends AppCompatActivity {

    ImageButton backCMRP79,learnCMRP79,assessCMRP79,replayCMRP79;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_responsibility);

        backCMRP79 = findViewById(R.id.bconceptsbtnCMRP79);
        learnCMRP79 = findViewById(R.id.learnCMRP79);
        assessCMRP79 = findViewById(R.id.assessCMRP79);
        replayCMRP79 = findViewById(R.id.replayintroCMRP79);

        backCMRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeResponsibility.this,Gmrc7to9.class));
            }
        });

        learnCMRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeResponsibility.this, LessonResponsibility.class));
            }
        });

        assessCMRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(ChooseModeResponsibility.this, QuizResponsibility.class));
            }
        });

        replayCMRP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeResponsibility.this,LessonIntroResponsibility.class));
            }
        });
    }
}