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

public class CountingLessonCongrats extends AppCompatActivity {

    ImageButton btnbackCTLC,btnachievementsCTLC, btnassessmentCTLC, btnhomepageCTLC;
    ImageView certificateCTLC;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting_lesson_congrats);

        btnbackCTLC = findViewById(R.id.backbtnCTLC);
        btnachievementsCTLC = findViewById(R.id.achievementsbtnCTLC);
        certificateCTLC = findViewById(R.id.certificateCTLC);
        btnassessmentCTLC = findViewById(R.id.asessmentbtnCTLC);
        btnhomepageCTLC = findViewById(R.id.homepageCTLC);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "counting lesson", "Completed");
                return null;
            }
        });

        btnbackCTLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CountingLessonCongrats.this, BasicConcepts.class));
            }
        });

        btnachievementsCTLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CountingLessonCongrats.this,CountingAchievements3to6.class));
            }
        });

        btnassessmentCTLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(CountingLessonCongrats.this, QuizCounting.class));
            }
        });

        btnhomepageCTLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CountingLessonCongrats.this, Homepage3to6.class));
            }
        });
    }
}