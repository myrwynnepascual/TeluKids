package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Numbers extends AppCompatActivity {

    ImageButton btnbackN,btncountN,btnaddN,btnsubN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        btnbackN = findViewById(R.id.btnbackN);
        btncountN = findViewById(R.id.btncountingN);
        btnaddN = findViewById(R.id.btnadditionN);
        btnsubN = findViewById(R.id.btnsubtractionN);

        btnbackN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Numbers.this,BasicConcepts.class));

            }
        });

        btncountN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Numbers.this,LessonIntroCounting.class));

            }
        });

        btnaddN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(Numbers.this,LessonIntroAddition.class));

            }
        });

        btnsubN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(Numbers.this,LessonIntroSubtraction.class));

            }
        });
    }
}