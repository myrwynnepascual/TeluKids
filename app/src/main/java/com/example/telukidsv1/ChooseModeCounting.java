package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeCounting extends AppCompatActivity {

    ImageButton backCMCN,learnCMCN,assessCMCN,replayCMCN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_counting);

        backCMCN = findViewById(R.id.bconceptsbtnCMCN);
        learnCMCN = findViewById(R.id.learnCMCN);
        assessCMCN = findViewById(R.id.assessCMCN);
        replayCMCN = findViewById(R.id.replayintroCMCN);

        backCMCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeCounting.this,Numbers.class));
            }
        });

        learnCMCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(ChooseModeCounting.this, Counting1.class));
            }
        });

        assessCMCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(ChooseModeCounting.this,QuizCounting.class));
            }
        });

        replayCMCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeCounting.this,LessonIntroCounting.class));
            }
        });
    }
}