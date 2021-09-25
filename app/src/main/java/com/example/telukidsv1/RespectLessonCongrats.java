package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class RespectLessonCongrats extends AppCompatActivity {

    ImageButton btnbackRLC,btnachievementsRLC, btnassessmentRLC, btnhomepageRLC;
    ImageView certificateRLC;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respect_lesson_congrats);

        btnbackRLC = findViewById(R.id.backbtnRLC);
        btnachievementsRLC = findViewById(R.id.achievementsbtnRLC);
        certificateRLC = findViewById(R.id.certificateRLC);
        btnassessmentRLC = findViewById(R.id.asessmentbtnRLC);
        btnhomepageRLC = findViewById(R.id.homepageRLC);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "respect lesson", "Completed");
                return null;
            }
        });

        btnbackRLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RespectLessonCongrats.this, Gmrc3to6.class));
            }
        });

        btnachievementsRLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RespectLessonCongrats.this, Achievements3to6Respect.class));
            }
        });

        btnassessmentRLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RespectLessonCongrats.this, QuizRespect.class));
            }
        });

        btnhomepageRLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RespectLessonCongrats.this, Homepage3to6.class));
            }
        });
    }
}