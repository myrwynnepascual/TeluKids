package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeShapes extends AppCompatActivity {

    ImageButton backCMS,learnCMS,assessCMS,replayCMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_shapes);

        backCMS = findViewById(R.id.bconceptsbtnCMS);
        learnCMS = findViewById(R.id.learnCMS);
        assessCMS = findViewById(R.id.assessCMS);
        replayCMS = findViewById(R.id.replayintroCMS);

        backCMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeShapes.this,BasicConcepts.class));
            }
        });

        learnCMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeShapes.this, CirclePage1.class));
            }
        });

        assessCMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeShapes.this,QuizShapes.class));
            }
        });

        replayCMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeShapes.this,LessonIntroShapes.class));
            }
        });
    }
}