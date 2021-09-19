package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Gmrc3to6 extends AppCompatActivity {

    ImageButton btnBack,btnDiscipline, btnHonesty, btnRespect, btnSociability, btnCompassion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmrc3to6);

        btnBack = findViewById(R.id.btnbackG36);
        btnDiscipline = findViewById(R.id.btnDisciplineG36);
        btnHonesty = findViewById(R.id.btnHonestyG36);
        btnRespect = findViewById(R.id.btnRespectG36);
        btnSociability = findViewById(R.id.btnSociabilityG36);
        btnCompassion = findViewById(R.id.btnCompassionG36);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Gmrc3to6.this, Homepage3to6.class));

            }
        });

        btnDiscipline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Gmrc3to6.this, LessonIntroDiscipline.class));

            }
        });

        btnHonesty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Gmrc3to6.this, LessonIntroHonesty.class));

            }
        });

        btnRespect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(Gmrc3to6.this, LessonIntroRespect.class));

            }
        });

        btnSociability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(Gmrc3to6.this, LessonIntroSociability.class));

            }
        });

        btnCompassion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(Gmrc3to6.this, LessonIntroCompassion.class));

            }
        });

    }
}