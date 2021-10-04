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

public class CountingLessonCongrats extends AppCompatActivity {

    ImageButton btnbackCTLC,btnachievementsCTLC, btnassessmentCTLC, btnhomepageCTLC;
    ImageView certificateCTLC;
    MediaPlayer congrats;

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

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);


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
                sfx.start();
                startActivity(new Intent(CountingLessonCongrats.this, Numbers.class));
            }
        });

        btnachievementsCTLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(CountingLessonCongrats.this, Achievements3to6Counting.class));
            }
        });

        btnassessmentCTLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(CountingLessonCongrats.this, QuizCountingNumbers.class));
            }
        });

        btnhomepageCTLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(CountingLessonCongrats.this, Homepage3to6.class));
            }
        });
    }

    @Override
    protected void onUserLeaveHint(){
        congrats.stop();
        congrats.release();
    }
}