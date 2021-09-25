package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeLove extends AppCompatActivity {

    ImageButton backCML79,learnCML79,assessCML79,replayCML79;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_love);

        backCML79 = findViewById(R.id.bconceptsbtnCML79);
        learnCML79 = findViewById(R.id.learnCML79);
        assessCML79 = findViewById(R.id.assessCML79);
        replayCML79 = findViewById(R.id.replayintroCML79);

        backCML79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeLove.this,Gmrc7to9.class));
            }
        });

        learnCML79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeLove.this, LessonLove.class));
            }
        });

        assessCML79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(ChooseModeLove.this, QuizLove.class));
            }
        });

        replayCML79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseModeLove.this,LessonIntroLove.class));
            }
        });
    }
}