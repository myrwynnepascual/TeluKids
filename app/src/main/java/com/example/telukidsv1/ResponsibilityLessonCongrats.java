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

public class ResponsibilityLessonCongrats extends AppCompatActivity {

    ImageButton btnbackRPLC,btnachievementsRPLC, btnassessmentRPLC, btnhomepageRPLC;
    ImageView certificateRPLC;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responsibility_lesson_congrats);

        btnbackRPLC = findViewById(R.id.backbtnRPLC);
        btnachievementsRPLC = findViewById(R.id.achievementsbtnRPLC);
        certificateRPLC = findViewById(R.id.certificateRPLC);
        btnassessmentRPLC = findViewById(R.id.asessmentbtnRPLC);
        btnhomepageRPLC = findViewById(R.id.homepageRPLC);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "responsibility lesson", "Completed");
                return null;
            }
        });

        btnbackRPLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResponsibilityLessonCongrats.this, Gmrc7to9.class));
            }
        });

        btnachievementsRPLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResponsibilityLessonCongrats.this, Achievements7to9Responsibility.class));
            }
        });

        btnassessmentRPLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(ResponsibilityLessonCongrats.this, QuizResponsibility.class));
            }
        });

        btnhomepageRPLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResponsibilityLessonCongrats.this, Homepage3to6.class));
            }
        });
    }
}