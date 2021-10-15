package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Gmrc3to6 extends AppCompatActivity {

    ImageButton btnBack,btnDiscipline, btnHonesty, btnRespect, btnSociability, btnCompassion;
    MediaPlayer sfx;

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

        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(Gmrc3to6.this, Homepage3to6.class));

            }
        });

        btnDiscipline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(Gmrc3to6.this, LessonIntroDiscipline.class));

            }
        });

        btnHonesty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(Gmrc3to6.this, LessonIntroHonesty.class));

            }
        });

        btnRespect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(Gmrc3to6.this, LessonIntroRespect.class));

            }
        });

        btnSociability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(Gmrc3to6.this, LessonIntroSociability.class));

            }
        });

        btnCompassion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(Gmrc3to6.this, LessonIntroCompassion.class));

            }
        });

    }

    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onUserLeaveHint(){
        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

        super.onUserLeaveHint();
    }
}