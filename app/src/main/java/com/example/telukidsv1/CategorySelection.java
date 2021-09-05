package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CategorySelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_selection);

        ImageButton btnAge3to6,btnAge7to9;

        btnAge3to6 = findViewById(R.id.categoryage3to6CS);
        btnAge7to9 = findViewById(R.id.categoryage7to9CS);

        btnAge3to6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategorySelection.this, Homepage3to6.class));
            }
        });

       btnAge7to9.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(CategorySelection.this, Homepage7to9.class));
           }
       });

    }
}