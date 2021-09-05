package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BasicConcepts extends AppCompatActivity {

    ImageButton btnbackBConcepts,btnColors,btnNumbers,btnShapes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_concepts);

        btnbackBConcepts = findViewById(R.id.btnbackBConcepts);
        btnColors = findViewById(R.id.btnColors);
        btnNumbers = findViewById(R.id.btnNumbers);
        btnShapes = findViewById(R.id.btnShapes);



        btnbackBConcepts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BasicConcepts.this, Homepage3to6.class));
            }
        });
        btnColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BasicConcepts.this, LessonIntroColors.class));
            }
        });
        btnNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BasicConcepts.this, Numbers.class));
            }
        });
        btnShapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BasicConcepts.this, LessonIntroShapes.class));

            }
        });

    }
}