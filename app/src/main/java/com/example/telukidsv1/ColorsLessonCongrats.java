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

public class ColorsLessonCongrats extends AppCompatActivity {

    ImageButton btnbackCLC,btnachievementsCLC, btnassessmentCLC, btnhomepageCLC;
    ImageView certificateCLC;
    MediaPlayer congrats;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_lesson_congrats);

        btnbackCLC = findViewById(R.id.backbtnCLC);
        btnachievementsCLC = findViewById(R.id.achievementsbtnCLC);
        certificateCLC = findViewById(R.id.certificateCLC);
        btnassessmentCLC = findViewById(R.id.asessmentbtnCLC);
        btnhomepageCLC = findViewById(R.id.homepageCLC);

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

                transaction.update(docRef, "colors lesson", "Completed");
                return null;
            }
        });

        btnbackCLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ColorsLessonCongrats.this, BasicConcepts.class));
            }
        });

        btnachievementsCLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ColorsLessonCongrats.this, Achievements3to6Colors.class));
            }
        });

        btnassessmentCLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ColorsLessonCongrats.this, QuizColors.class));
            }
        });

        btnhomepageCLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ColorsLessonCongrats.this, Homepage3to6.class));
            }
        });
    }

    @Override
    protected void onUserLeaveHint(){
        congrats.stop();
        congrats.release();
    }
}