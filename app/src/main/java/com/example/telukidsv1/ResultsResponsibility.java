
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

public class ResultsResponsibility extends AppCompatActivity {
    private int  score_responsibility;
    private int initialScore_responsibility;
    MediaPlayer congrats;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_responsibility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_responsibility);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Responsibility);
        ImageView imgTrophy_Responsibility = findViewById(R.id.imgTrophy_Responsibility);
        ImageButton achievementsbtnCLC_Responsibility = findViewById(R.id.achievementsbtnCLC_Responsibility);
        ImageButton btnReadLesson_Quiz_Responsibility = findViewById(R.id.btnReadLesson_Quiz_Responsibility);
        ImageButton homepageCLC_Responsibility = findViewById(R.id.homepageCLC_Responsibility);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_responsibility = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Responsibility", 0);
        totalScoreLabel.setText(score_responsibility + " / 5");

        if (score_responsibility == 0 || score_responsibility == 1 || score_responsibility == 2){
            imgTrophy_Responsibility.setImageResource(R.drawable.congratsbadgeresponsibility);
            achievement_responsibility = "Responsibility Beginner";
        }
        if (score_responsibility == 3 || score_responsibility == 4){
            imgTrophy_Responsibility.setImageResource(R.drawable.congratsmedalresponsibility);
            achievement_responsibility = "Responsibility Expert";
        }
        if (score_responsibility == 5){
            imgTrophy_Responsibility.setImageResource(R.drawable.congratstrophyresponsibility);
            achievement_responsibility = "Responsibility Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_responsibility = documentSnapshot.getLong("responsibility quiz score").intValue();

                if(score_responsibility >= initialScore_responsibility) {
                    transaction.update(docRef, "responsibility quiz score", score_responsibility);
                    transaction.update(docRef, "responsibility achievement", achievement_responsibility);
                }
                if(score_responsibility < initialScore_responsibility){
                    transaction.update(docRef, "responsibility quiz score", initialScore_responsibility);
                }
                return null;
            }
        });

        achievementsbtnCLC_Responsibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsResponsibility.this, Achievements7to9Responsibility2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Responsibility", score_responsibility);
                startActivity(proceed);
            }
        });
        btnReadLesson_Quiz_Responsibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsResponsibility.this, Gmrc7to9.class);
                startActivity(proceed);
            }
        });
        homepageCLC_Responsibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(ResultsResponsibility.this, Homepage7to9.class);
                startActivity(proceed);
            }
        });
    }
}