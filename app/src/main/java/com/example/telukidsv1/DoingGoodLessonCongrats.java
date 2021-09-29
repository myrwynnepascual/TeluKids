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

public class DoingGoodLessonCongrats extends AppCompatActivity {

    ImageButton btnbackDGLC,btnachievementsDGLC, btnassessmentDGLC, btnhomepageDGLC;
    ImageView certificateDGLC;
    MediaPlayer congrats;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doing_good_lesson_congrats);

        btnbackDGLC = findViewById(R.id.backbtnDGLC);
        btnachievementsDGLC = findViewById(R.id.achievementsbtnDGLC);
        certificateDGLC = findViewById(R.id.certificateDGLC);
        btnassessmentDGLC = findViewById(R.id.asessmentbtnDGLC);
        btnhomepageDGLC = findViewById(R.id.homepageDGLC);

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

                transaction.update(docRef, "doingGood lesson", "Completed");
                return null;
            }
        });

        btnbackDGLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoingGoodLessonCongrats.this, Gmrc7to9.class));
            }
        });

        btnachievementsDGLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoingGoodLessonCongrats.this, Achievements7to9DoingGood.class));
            }
        });

        btnassessmentDGLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoingGoodLessonCongrats.this, QuizDoingGood.class));
            }
        });

        btnhomepageDGLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoingGoodLessonCongrats.this, Homepage7to9.class));
            }
        });
    }
}