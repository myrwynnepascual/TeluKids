
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

public class ResultsCountingNumbers extends AppCompatActivity {
    private int  score_counting;
    private int initialScore_counting;
    MediaPlayer congrats,sfx;
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
        ImageButton numbersbtnCLC_Counting = findViewById(R.id.backbtnCTR);
        ImageButton achievementsbtnCLC_Counting = findViewById(R.id.achievementsbtnCLC_Counting);
        ImageButton btnReadLesson_Quiz_Counting = findViewById(R.id.btnReadLesson_Quiz_Counting);
        ImageButton homepageCLC_Counting = findViewById(R.id.homepageCLC_Counting);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);

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
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_counting = documentSnapshot.getLong("counting quiz score").intValue();

                if(score_counting >= initialScore_counting) {
                    transaction.update(docRef, "counting quiz score", score_counting);
                    transaction.update(docRef, "counting achievement", achievement_counting);
                }
                if(score_counting < initialScore_counting){
                    transaction.update(docRef, "counting quiz score", initialScore_counting);
                }
                return null;
            }
        });

        achievementsbtnCLC_Counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsCountingNumbers.this, Achievements3to6Counting2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Counting", score_counting);
                startActivity(proceed);
            }
        });
        numbersbtnCLC_Counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ResultsCountingNumbers.this, Numbers.class));
            }
        });
        btnReadLesson_Quiz_Counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsCountingNumbers.this, LessonCounting.class);
                startActivity(proceed);
            }
        });
        homepageCLC_Counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                Intent proceed = new Intent(ResultsCountingNumbers.this, Homepage3to6.class);
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