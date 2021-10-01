
package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class ResultsShapes extends AppCompatActivity {
    private int  score_shapes;
    private int initialScore_shapes;
    MediaPlayer congrats;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_shapes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_shapes);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Shapes);
        ImageView imgTrophy_Shapes = findViewById(R.id.imgTrophy_Shapes);
        ImageButton bconceptsbtn = findViewById(R.id.backbtnSR);
        ImageButton achievementsbtnCLC_Shapes = findViewById(R.id.achievementsbtnCLC_Shapes);
        ImageButton btnReadLesson_Quiz_Shapes = findViewById(R.id.btnReadLesson_Quiz_Shapes);
        ImageButton homepageCLC_Shapes = findViewById(R.id.homepageCLC_Shapes);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_shapes = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Shapes", 0);
        totalScoreLabel.setText(score_shapes + " / 5");

        if (score_shapes == 0 || score_shapes == 1 || score_shapes == 2){
            imgTrophy_Shapes.setImageResource(R.drawable.congratsbadgeshapes);
            achievement_shapes = "Shapes Beginner";
        }
        if (score_shapes == 3 || score_shapes == 4){
            imgTrophy_Shapes.setImageResource(R.drawable.congratsmedalshapes);
            achievement_shapes = "Shapes Expert";
        }
        if (score_shapes == 5){
            imgTrophy_Shapes.setImageResource(R.drawable.congratstrophyshapes);
            achievement_shapes = "Shapes Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_shapes = documentSnapshot.getLong("shapes quiz score").intValue();

                if(score_shapes >= initialScore_shapes) {
                    transaction.update(docRef, "shapes quiz score", score_shapes);
                    transaction.update(docRef, "shapes achievement", achievement_shapes);
                }
                if(score_shapes < initialScore_shapes){
                    transaction.update(docRef, "shapes quiz score", initialScore_shapes);
                }
                return null;
            }
        });
        bconceptsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultsShapes.this, BasicConcepts.class));
            }
        });
        achievementsbtnCLC_Shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(getApplicationContext(), Achievements3to6Shapes2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Shapes", score_shapes);
                startActivity(proceed);
            }
        });
        btnReadLesson_Quiz_Shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsShapes.this, LessonShapes.class);
                startActivity(proceed);
            }
        });
        homepageCLC_Shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(ResultsShapes.this, Homepage3to6.class);
                startActivity(proceed);
            }
        });
    }
}