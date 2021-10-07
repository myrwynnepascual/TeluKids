package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class AgeCategorySelection extends AppCompatActivity {

    ImageButton btnAge3to6,btnAge7to9;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_category_selection);

        btnAge3to6 = findViewById(R.id.categoryage3to6CS);
        btnAge7to9 = findViewById(R.id.categoryage7to9CS);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        btnAge3to6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();

                sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        sfx.release();
                    }
                });

                startActivity(new Intent(AgeCategorySelection.this, Homepage3to6.class));
            }
        });

       btnAge7to9.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               sfx.start();

               sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                   @Override
                   public void onCompletion(MediaPlayer mp) {
                       sfx.release();
                   }
               });

               startActivity(new Intent(AgeCategorySelection.this, Homepage7to9.class));
           }
       });

    }
}