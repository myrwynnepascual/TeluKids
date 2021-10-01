
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

public class ResultsDoingGood extends AppCompatActivity {
    private int  score_doinggood;
    private int initialScore_doinggood;
    MediaPlayer congrats;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_doinggood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_doinggood);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_DoingGood);
        ImageView imgTrophy_DoingGood = findViewById(R.id.imgTrophy_DoingGood);
        ImageButton gmrc79btn = findViewById(R.id.backbtnDGR);
        ImageButton achievementsbtnCLC_DoingGood = findViewById(R.id.achievementsbtnCLC_DoingGood);
        ImageButton btnReadLesson_Quiz_DoingGood = findViewById(R.id.btnReadLesson_Quiz_DoingGood);
        ImageButton homepageCLC_DoingGood = findViewById(R.id.homepageCLC_DoingGood);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_doinggood = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_DoingGood", 0);
        totalScoreLabel.setText(score_doinggood + " / 5");

        if (score_doinggood == 0 || score_doinggood == 1 || score_doinggood == 2){
            imgTrophy_DoingGood.setImageResource(R.drawable.congratsbadgedoinggood);
            achievement_doinggood = "Doing Good Beginner";
        }
        if (score_doinggood == 3 || score_doinggood == 4){
            imgTrophy_DoingGood.setImageResource(R.drawable.congratsmedaldoinggood);
            achievement_doinggood = "Doing Good Expert";
        }
        if (score_doinggood == 5){
            imgTrophy_DoingGood.setImageResource(R.drawable.congratstrophydoinggood);
            achievement_doinggood = "Doing Good Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_doinggood = documentSnapshot.getLong("doing good quiz score").intValue();

                if(score_doinggood >= initialScore_doinggood) {
                    transaction.update(docRef, "doing good quiz score", score_doinggood);
                    transaction.update(docRef, "doing good achievement", achievement_doinggood);
                }
                if(score_doinggood < initialScore_doinggood){
                    transaction.update(docRef, "doing good quiz score", initialScore_doinggood);
                }
                return null;
            }
        });

        achievementsbtnCLC_DoingGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsDoingGood.this, Achievements7to9DoingGood2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_DoingGood", score_doinggood);
                startActivity(proceed);
            }
        });
        gmrc79btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultsDoingGood.this, Gmrc7to9.class));
            }
        });
        btnReadLesson_Quiz_DoingGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsDoingGood.this, LessonDoingGood.class);
                startActivity(proceed);
            }
        });
        homepageCLC_DoingGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(ResultsDoingGood.this, Homepage7to9.class);
                startActivity(proceed);
            }
        });
    }
}