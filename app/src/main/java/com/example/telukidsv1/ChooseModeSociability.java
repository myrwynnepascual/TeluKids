package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeSociability extends AppCompatActivity {

    ImageButton backCMSC,learnCMSC,assessCMSC,replayCMSC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_sociability);

        backCMSC = findViewById(R.id.bconceptsbtnCMSC);
        learnCMSC = findViewById(R.id.learnCMSC);
        assessCMSC = findViewById(R.id.assessCMSC);
        replayCMSC = findViewById(R.id.replayintroCMSC);

        backCMSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeSociability.this,Gmrc3to6.class));
            }
        });

        learnCMSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeSociability.this, LessonSociability.class));
            }
        });

        assessCMSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(ChooseModeSociability.this, QuizSociability.class));
            }
        });

        replayCMSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeSociability.this,LessonIntroSociability.class));
            }
        });
    }
}