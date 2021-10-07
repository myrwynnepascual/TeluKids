
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

public class ResultsSociability extends AppCompatActivity {
    private int  score_sociability;
    private int initialScore_sociability;
    MediaPlayer congrats;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_sociability;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_sociability);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Sociability);
        ImageView imgTrophy_Sociability = findViewById(R.id.imgTrophy_Sociability);
        ImageButton gmrc36btn = findViewById(R.id.backbtnSCR);
        ImageButton achievementsbtnCLC_Sociability = findViewById(R.id.achievementsbtnCLC_Sociability);
        ImageButton btnReadLesson_Quiz_Sociability = findViewById(R.id.btnReadLesson_Quiz_Sociability);
        ImageButton homepageCLC_Sociability = findViewById(R.id.homepageCLC_Sociability);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        BackgroundSoundService.onResume();

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_sociability = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Sociability", 0);
        totalScoreLabel.setText(score_sociability + " / 5");

        if (score_sociability == 0 || score_sociability == 1 || score_sociability == 2){
            imgTrophy_Sociability.setImageResource(R.drawable.congratsbadgesociability);
            achievement_sociability = "Sociability Beginner";
        }
        if (score_sociability == 3 || score_sociability == 4){
            imgTrophy_Sociability.setImageResource(R.drawable.congratsmedalsociability);
            achievement_sociability = "Sociability Expert";
        }
        if (score_sociability == 5){
            imgTrophy_Sociability.setImageResource(R.drawable.congratstrophysociability);
            achievement_sociability = "Sociability Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_sociability = documentSnapshot.getLong("sociability quiz score").intValue();

                if(score_sociability >= initialScore_sociability) {
                    transaction.update(docRef, "sociability quiz score", score_sociability);
                    transaction.update(docRef, "sociability achievement", achievement_sociability);
                }
                if(score_sociability < initialScore_sociability){
                    transaction.update(docRef, "sociability quiz score", initialScore_sociability);
                }
                return null;
            }
        });
        gmrc36btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ResultsSociability.this,Gmrc3to6.class));
            }
        });
        achievementsbtnCLC_Sociability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsSociability.this, Achievements3to6Sociability2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Sociability", score_sociability);
                startActivity(proceed);
            }
        });
        btnReadLesson_Quiz_Sociability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsSociability.this, LessonSociability.class);
                startActivity(proceed);
            }
        });
        homepageCLC_Sociability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                Intent proceed = new Intent(ResultsSociability.this, Homepage3to6.class);
                startActivity(proceed);
            }
        });
    }

    @Override
    public void onBackPressed(){

        Toast toast = Toast.makeText(this, "Uh oh! Back button is disabled! You cannot go back to the quiz now ✌", Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        toast.show();

    }
}