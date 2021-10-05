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

public class HonestyLessonCongrats extends AppCompatActivity {

    ImageButton btnbackHLC,btnachievementsHLC, btnassessmentHLC, btnhomepageHLC;
    ImageView certificateHLC;
    MediaPlayer congrats;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honesty_lesson_congrats);


        btnbackHLC = findViewById(R.id.backbtnHLC);
        btnachievementsHLC = findViewById(R.id.achievementsbtnHLC);
        certificateHLC = findViewById(R.id.certificateHLC);
        btnassessmentHLC = findViewById(R.id.asessmentbtnHLC);
        btnhomepageHLC = findViewById(R.id.homepageHLC);

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

                transaction.update(docRef, "honesty lesson", "Completed");
                return null;
            }
        });

        btnbackHLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(HonestyLessonCongrats.this, Gmrc3to6.class));
            }
        });

        btnachievementsHLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(HonestyLessonCongrats.this, Achievements3to6Honesty.class));
            }
        });

        btnassessmentHLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(HonestyLessonCongrats.this, QuizHonesty.class));
            }
        });

        btnhomepageHLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(HonestyLessonCongrats.this, Homepage3to6.class));
            }
        });
    }

    @Override
    protected void onUserLeaveHint(){
        congrats.stop();
        congrats.release();
    }
}