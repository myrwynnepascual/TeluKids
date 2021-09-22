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

public class CompassionLessonCongrats extends AppCompatActivity {

    ImageButton btnbackCPLC,btnachievementsCPLC, btnassessmentCPLC, btnhomepageCPLC;
    ImageView certificateCPLC;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compassion_lesson_congrats);

        btnbackCPLC = findViewById(R.id.backbtnCPLC);
        btnachievementsCPLC = findViewById(R.id.achievementsbtnCPLC);
        certificateCPLC = findViewById(R.id.certificateCPLC);
        btnassessmentCPLC = findViewById(R.id.asessmentbtnCPLC);
        btnhomepageCPLC = findViewById(R.id.homepageCPLC);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "compassion lesson", "Completed");
                return null;
            }
        });

        btnbackCPLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CompassionLessonCongrats.this, Gmrc3to6.class));
            }
        });

        btnachievementsCPLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CompassionLessonCongrats.this, Achievements3to6Compassion.class));
            }
        });

        btnassessmentCPLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(CompassionLessonCongrats.this, QuizCompassion.class));
            }
        });

        btnhomepageCPLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CompassionLessonCongrats.this, Homepage3to6.class));
            }
        });
    }
}