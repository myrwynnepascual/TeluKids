package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
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

public class ObedienceLessonCongrats extends AppCompatActivity {

    ImageButton btnbackOLC,btnachievementsOLC, btnassessmentOLC, btnhomepageOLC;
    ImageView certificateOLC;
    MediaPlayer congrats;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obedience_lesson_congrats);

        btnbackOLC = findViewById(R.id.backbtnOLC);
        btnachievementsOLC = findViewById(R.id.achievementsbtnOLC);
        certificateOLC = findViewById(R.id.certificateOLC);
        btnassessmentOLC = findViewById(R.id.asessmentbtnOLC);
        btnhomepageOLC = findViewById(R.id.homepageOLC);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "obedience lesson", "Completed");
                return null;
            }
        });

        btnbackOLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ObedienceLessonCongrats.this, Gmrc7to9.class));
            }
        });

        btnachievementsOLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ObedienceLessonCongrats.this, Achievements7to9Obedience.class));
            }
        });

        btnassessmentOLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ObedienceLessonCongrats.this, QuizObedience.class));
            }
        });

        btnhomepageOLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ObedienceLessonCongrats.this, Homepage7to9.class));
            }
        });
    }
}