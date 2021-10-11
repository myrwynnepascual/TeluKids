package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class SubtractionLessonCongrats extends AppCompatActivity {

    ImageButton btnbackSLC,btnachievementsSLC, btnassessmentSLC, btnhomepageSLC;
    ImageView certificateSLC;
    MediaPlayer congrats,sfx;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_lesson_congrats);

        btnbackSLC = findViewById(R.id.backbtnSLC);
        btnachievementsSLC = findViewById(R.id.achievementsbtnSLC);
        certificateSLC = findViewById(R.id.certificateSLC);
        btnassessmentSLC = findViewById(R.id.asessmentbtnSLC);
        btnhomepageSLC = findViewById(R.id.homepageSLC);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "subtraction lesson", "Completed");
                return null;
            }
        });

        btnbackSLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(SubtractionLessonCongrats.this, Numbers.class));
            }
        });

        btnachievementsSLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(SubtractionLessonCongrats.this, Achievements3to6Subtraction.class));
            }
        });

        btnassessmentSLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(SubtractionLessonCongrats.this, QuizSubtraction.class));
            }
        });

        btnhomepageSLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(SubtractionLessonCongrats.this, Homepage3to6.class));
            }
        });
    }

    @Override
    public void onBackPressed(){

        Toast toast = Toast.makeText(this, "Uh oh! Back button is disabled! You cannot go back to the lesson now ✌", Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        toast.show();

    }

    @Override
    protected void onUserLeaveHint(){

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

        congrats.stop();
        congrats.release();

        super.onUserLeaveHint();

    }
}