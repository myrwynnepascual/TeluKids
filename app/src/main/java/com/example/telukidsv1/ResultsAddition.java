
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

public class ResultsAddition extends AppCompatActivity {
    private int  score_addition;
    private int initialScore_addition;
    MediaPlayer congrats,sfx;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_addition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_addition);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Addition);
        ImageView imgTrophy_Addition = findViewById(R.id.imgTrophy_Addition);
        ImageButton numbersbtnCLC_Addition = findViewById(R.id.backbtnAR);
        ImageButton achievementsbtnCLC_Addition = findViewById(R.id.achievementsbtnCLC_Addition);
        ImageButton btnReadLesson_Quiz_Addition = findViewById(R.id.btnReadLesson_Quiz_Addition);
        ImageButton homepageCLC_Addition = findViewById(R.id.homepageCLC_Addition);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        BackgroundSoundService.onResume();

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_addition = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Addition", 0);
        totalScoreLabel.setText(score_addition + " / 5");

        if (score_addition == 0 || score_addition == 1 || score_addition == 2){
            imgTrophy_Addition.setImageResource(R.drawable.congratsbadgeaddition);
            achievement_addition = "Addition Beginner";
        }
        if (score_addition == 3 || score_addition == 4){
            imgTrophy_Addition.setImageResource(R.drawable.congratsmedaladdition);
            achievement_addition = "Addition Expert";
        }
        if (score_addition == 5){
            imgTrophy_Addition.setImageResource(R.drawable.congratstrophyaddition);
            achievement_addition = "Addition Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_addition = documentSnapshot.getLong("addition quiz score").intValue();

                if(score_addition >= initialScore_addition) {
                    transaction.update(docRef, "addition quiz score", score_addition);
                    transaction.update(docRef, "addition achievement", achievement_addition);
                }
                if(score_addition < initialScore_addition){
                    transaction.update(docRef, "addition quiz score", initialScore_addition);
                }
                return null;
            }
        });

        achievementsbtnCLC_Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsAddition.this, Achievements3to6Addition2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Addition", score_addition);
                startActivity(proceed);
            }
        });
        numbersbtnCLC_Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ResultsAddition.this, Numbers.class));
            }
        });
        btnReadLesson_Quiz_Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsAddition.this, LessonAddition.class);
                startActivity(proceed);
            }
        });
        homepageCLC_Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                Intent proceed = new Intent(ResultsAddition.this, Homepage3to6.class);
                startActivity(proceed);
            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
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