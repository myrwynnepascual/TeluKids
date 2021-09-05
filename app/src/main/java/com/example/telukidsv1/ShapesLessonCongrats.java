package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class ShapesLessonCongrats extends AppCompatActivity {

    ImageButton btnbackSLC,btnachievementsSLC, btnassessmentSLC, btnhomepageSLC;
    ImageView certificateSLC;
    String userID, username, usericon;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes_lesson_congrats);

        btnbackSLC = findViewById(R.id.backbtnSLC);
        btnachievementsSLC = findViewById(R.id.achievementsbtnSLC);
        certificateSLC = findViewById(R.id.certificateSLC);
        btnassessmentSLC = findViewById(R.id.asessmentbtnSLC);
        btnhomepageSLC = findViewById(R.id.homepageSLC);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "shapes lesson", "Completed");
                return null;
            }
        });

        btnbackSLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShapesLessonCongrats.this, BasicConcepts.class));
            }
        });

        btnachievementsSLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShapesLessonCongrats.this,Achievements3to6.class));
            }
        });

        btnassessmentSLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShapesLessonCongrats.this, QuizShapes.class));
            }
        });

        btnhomepageSLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShapesLessonCongrats.this, BasicConcepts.class));
            }
        });

    }
}