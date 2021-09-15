
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

public class ResultsCountingNumbers extends AppCompatActivity {
    private int score_counting;
    MediaPlayer congrats;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_counting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_countingnumbers);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Counting);
        ImageView imgTrophy_Counting = findViewById(R.id.imgTrophy_Counting);
        ImageButton achievementsbtnCLC_Counting = findViewById(R.id.achievementsbtnCLC_Counting);
        ImageButton btnReadLesson_Quiz_Counting = findViewById(R.id.btnReadLesson_Quiz_Counting);
        ImageButton homepageCLC_Counting = findViewById(R.id.homepageCLC_Counting);;

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_counting = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Counting", 0);
        totalScoreLabel.setText(score_counting + " / 5");

        if (score_counting == 0 || score_counting == 1 || score_counting == 2){
            imgTrophy_Counting.setImageResource(R.drawable.congratsbadgecounting);
            achievement_counting = "Counting Beginner";
        }
        if (score_counting == 3 || score_counting == 4){
            imgTrophy_Counting.setImageResource(R.drawable.congratsmedalcounting);
            achievement_counting = "Counting Expert";
        }
        if (score_counting == 5){
            imgTrophy_Counting.setImageResource(R.drawable.congratstrophycounting);
            achievement_counting = "Counting Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "counting quiz score", score_counting);
                transaction.update(docRef, "counting achievement", achievement_counting);
                return null;
            }
        });

        achievementsbtnCLC_Counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsCountingNumbers.this, Achievements3to6Counting2.class);
                startActivity(proceed);
            }
        });
        btnReadLesson_Quiz_Counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultsCountingNumbers.this,BasicConcepts.class));
            }
        });
        homepageCLC_Counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(ResultsCountingNumbers.this, Homepage3to6.class);
                startActivity(proceed);
            }
        });
    }
}