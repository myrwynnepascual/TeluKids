
package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.telukidsv1.QuizShapes;

public class CongratsPageShapes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congratspage_shapes);


        Button btnReadLesson_Quiz_Shapes = findViewById(R.id.btnReadLesson_Quiz_Shapes);
        Button btnGoToHomepage_Quiz_Shapes = findViewById(R.id.btnGoToHomepage_Quiz_Shapes);

        btnReadLesson_Quiz_Shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(CongratsPageShapes.this, BasicConcepts.class);
                startActivity(proceed);
            }
        });
        btnGoToHomepage_Quiz_Shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(CongratsPageShapes.this, Homepage3to6.class);
                startActivity(proceed);
            }
        });

    }
}