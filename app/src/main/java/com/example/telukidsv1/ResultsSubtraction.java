
package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
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

public class ResultsSubtraction extends AppCompatActivity {
    private int  score_subtraction;
    private int initialScore_subtraction;
    MediaPlayer congrats,sfx;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_subtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_subtraction);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Subtraction);
        ImageView imgTrophy_Subtraction = findViewById(R.id.imgTrophy_Subtraction);
        ImageButton numbersbtnCLC_Subtraction = findViewById(R.id.backbtnSBR);
        ImageButton achievementsbtnCLC_Subtraction = findViewById(R.id.achievementsbtnCLC_Subtraction);
        ImageButton btnReadLesson_Quiz_Subtraction = findViewById(R.id.btnReadLesson_Quiz_Subtraction);
        ImageButton homepageCLC_Subtraction = findViewById(R.id.homepageCLC_Subtraction);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_subtraction = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Subtraction", 0);
        totalScoreLabel.setText(score_subtraction + " / 5");

        if (score_subtraction == 0 || score_subtraction == 1 || score_subtraction == 2){
            imgTrophy_Subtraction.setImageResource(R.drawable.congratsbadgesubtraction);
            achievement_subtraction = "Subtraction Beginner";
        }
        if (score_subtraction == 3 || score_subtraction == 4){
            imgTrophy_Subtraction.setImageResource(R.drawable.congratsmedalsubtraction);
            achievement_subtraction = "Subtraction Expert";
        }
        if (score_subtraction == 5){
            imgTrophy_Subtraction.setImageResource(R.drawable.congratstrophysubtraction);
            achievement_subtraction = "Subtraction Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_subtraction = documentSnapshot.getLong("subtraction quiz score").intValue();

                if(score_subtraction >= initialScore_subtraction) {
                    transaction.update(docRef, "subtraction quiz score", score_subtraction);
                    transaction.update(docRef, "subtraction achievement", achievement_subtraction);
                }
                if(score_subtraction < initialScore_subtraction){
                    transaction.update(docRef, "subtraction quiz score", initialScore_subtraction);
                }
                return null;
            }
        });

        achievementsbtnCLC_Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsSubtraction.this, Achievements3to6Subtraction2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Subtraction", score_subtraction);
                startActivity(proceed);
            }
        });

        numbersbtnCLC_Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ResultsSubtraction.this, Numbers.class));
            }
        });

        btnReadLesson_Quiz_Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsSubtraction.this, LessonSubtraction.class);
                startActivity(proceed);
            }
        });

        homepageCLC_Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                Intent proceed = new Intent(ResultsSubtraction.this, Homepage3to6.class);
                startActivity(proceed);
            }
        });

    }

    @Override
    public void onBackPressed(){

        Toast toast = Toast.makeText(this, "Uh oh! Back button is disabled! You cannot go back to the quiz now ???", Toast.LENGTH_SHORT);
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

        super.onUserLeaveHint();
    }
}