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

public class SociabilityLessonCongrats extends AppCompatActivity {

    ImageButton btnbackSCLC,btnachievementsSCLC, btnassessmentSCLC, btnhomepageSCLC;
    ImageView certificateSCLC;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sociability_lesson_congrats);

        btnbackSCLC = findViewById(R.id.backbtnSCLC);
        btnachievementsSCLC = findViewById(R.id.achievementsbtnSCLC);
        certificateSCLC = findViewById(R.id.certificateSCLC);
        btnassessmentSCLC = findViewById(R.id.asessmentbtnSCLC);
        btnhomepageSCLC = findViewById(R.id.homepageSCLC);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "sociability lesson", "Completed");
                return null;
            }
        });

        btnbackSCLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SociabilityLessonCongrats.this, Numbers.class));
            }
        });

        btnachievementsSCLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SociabilityLessonCongrats.this, Achievements3to6Sociability.class));
            }
        });

        btnassessmentSCLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(SociabilityLessonCongrats.this, QuizSociability.class));
            }
        });

        btnhomepageSCLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SociabilityLessonCongrats.this, Homepage3to6.class));
            }
        });
    }
}