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

public class DisciplineLessonCongrats extends AppCompatActivity {

    ImageButton btnbackDLC,btnachievementsDLC, btnassessmentDLC, btnhomepageDLC;
    ImageView certificateDLC;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discipline_lesson_congrats);

        btnbackDLC = findViewById(R.id.backbtnDLC);
        btnachievementsDLC = findViewById(R.id.achievementsbtnDLC);
        certificateDLC = findViewById(R.id.certificateDLC);
        btnassessmentDLC = findViewById(R.id.asessmentbtnDLC);
        btnhomepageDLC = findViewById(R.id.homepageDLC);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "discipline lesson", "Completed");
                return null;
            }
        });

        btnbackDLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisciplineLessonCongrats.this, Gmrc3to6.class));
            }
        });

        btnachievementsDLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisciplineLessonCongrats.this, Achievements3to6Discipline.class));
            }
        });

        btnassessmentDLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisciplineLessonCongrats.this, QuizDiscipline.class));
            }
        });

        btnhomepageDLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisciplineLessonCongrats.this, Homepage3to6.class));
            }
        });
    }
}