package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Gmrc7to9 extends AppCompatActivity {

    ImageButton btnBack, btnResponsibility, btnLove, btnObedience, btnDoingGood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmrc7to9);

        btnBack = findViewById(R.id.btnbackG79);
        btnResponsibility = findViewById(R.id.btnResponsibilityG79);
        btnLove = findViewById(R.id.btnLoveG79);
        btnObedience = findViewById(R.id.btnObedienceG79);
        btnDoingGood = findViewById(R.id.btnDoingGoodG79);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Gmrc7to9.this, Homepage7to9.class));
            }
        });

        btnResponsibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Gmrc7to9.this, LessonIntroResponsibility.class));
            }
        });

        btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Gmrc7to9.this, LessonIntroLove.class));
            }
        });

        btnObedience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Gmrc7to9.this, LessonIntroObedience.class));
            }
        });

        btnDoingGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Gmrc7to9.this, LessonIntroDoingGood.class));
            }
        });


    }
}