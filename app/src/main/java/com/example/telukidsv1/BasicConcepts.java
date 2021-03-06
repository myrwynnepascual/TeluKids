package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class BasicConcepts extends AppCompatActivity {

    ImageButton btnbackBConcepts,btnColors,btnNumbers,btnShapes;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_concepts);

        btnbackBConcepts = findViewById(R.id.btnbackBConcepts);
        btnColors = findViewById(R.id.btnColors);
        btnNumbers = findViewById(R.id.btnNumbers);
        btnShapes = findViewById(R.id.btnShapes);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        btnbackBConcepts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                startActivity(new Intent(BasicConcepts.this, Homepage3to6.class));
            }
        });

        btnColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                startActivity(new Intent(BasicConcepts.this, LessonIntroColors.class));
            }
        });

        btnNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                startActivity(new Intent(BasicConcepts.this, Numbers.class));
            }
        });

        btnShapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                startActivity(new Intent(BasicConcepts.this, LessonIntroShapes.class));

            }
        });
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(BasicConcepts.this, Homepage3to6.class));
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