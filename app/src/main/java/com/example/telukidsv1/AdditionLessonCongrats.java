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

public class AdditionLessonCongrats extends AppCompatActivity {

    ImageButton btnbackALC,btnachievementsALC, btnassessmentALC, btnhomepageALC;
    ImageView certificateALC;
    MediaPlayer congrats;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_lesson_congrats);

        btnbackALC = findViewById(R.id.backbtnALC);
        btnachievementsALC = findViewById(R.id.achievementsbtnALC);
        certificateALC = findViewById(R.id.certificateALC);
        btnassessmentALC = findViewById(R.id.asessmentbtnALC);
        btnhomepageALC = findViewById(R.id.homepageALC);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        BackgroundSoundService.onResume();

        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "addition lesson", "Completed");
                return null;
            }
        });

        btnbackALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(AdditionLessonCongrats.this, Numbers.class));
            }
        });

        btnachievementsALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(AdditionLessonCongrats.this, Achievements3to6Addition.class));
            }
        });

        btnassessmentALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(AdditionLessonCongrats.this, QuizAddition.class));
            }
        });

        btnhomepageALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(AdditionLessonCongrats.this, Homepage3to6.class));
            }
        });
    }

    @Override
    protected void onUserLeaveHint(){
        congrats.stop();
        congrats.release();
    }
}