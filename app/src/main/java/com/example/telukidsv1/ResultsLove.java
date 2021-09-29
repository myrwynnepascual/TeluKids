
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

public class ResultsLove extends AppCompatActivity {
    private int  score_love;
    private int initialScore_love;
    MediaPlayer congrats;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_love;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_love);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Love);
        ImageView imgTrophy_Love = findViewById(R.id.imgTrophy_Love);
        ImageButton achievementsbtnCLC_Love = findViewById(R.id.achievementsbtnCLC_Love);
        ImageButton btnReadLesson_Quiz_Love = findViewById(R.id.btnReadLesson_Quiz_Love);
        ImageButton homepageCLC_Love = findViewById(R.id.homepageCLC_Love);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_love = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Love", 0);
        totalScoreLabel.setText(score_love + " / 5");

        if (score_love == 0 || score_love == 1 || score_love == 2){
            imgTrophy_Love.setImageResource(R.drawable.congratsbadgelove);
            achievement_love = "Love Beginner";
        }
        if (score_love == 3 || score_love == 4){
            imgTrophy_Love.setImageResource(R.drawable.congratsmedallove);
            achievement_love = "Love Expert";
        }
        if (score_love == 5){
            imgTrophy_Love.setImageResource(R.drawable.congratstrophylove);
            achievement_love = "Love Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_love = documentSnapshot.getLong("love quiz score").intValue();

                if(score_love >= initialScore_love) {
                    transaction.update(docRef, "love quiz score", score_love);
                    transaction.update(docRef, "love achievement", achievement_love);
                }
                if(score_love < initialScore_love){
                    transaction.update(docRef, "love quiz score", initialScore_love);
                }
                return null;
            }
        });

        achievementsbtnCLC_Love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsLove.this, Achievements7to9Love2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Love", score_love);
                startActivity(proceed);
            }
        });
        btnReadLesson_Quiz_Love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsLove.this, Gmrc7to9.class);
                startActivity(proceed);
            }
        });
        homepageCLC_Love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(ResultsLove.this, Homepage7to9.class);
                startActivity(proceed);
            }
        });
    }
}