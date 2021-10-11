
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

public class ResultsRespect extends AppCompatActivity {
    private int  score_respect;
    private int initialScore_respect;
    MediaPlayer congrats,sfx;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_respect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_respect);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Respect);
        ImageView imgTrophy_Respect = findViewById(R.id.imgTrophy_Respect);
        ImageButton gmrc36btn = findViewById(R.id.backbtnRR);
        ImageButton achievementsbtnCLC_Respect = findViewById(R.id.achievementsbtnCLC_Respect);
        ImageButton btnReadLesson_Quiz_Respect = findViewById(R.id.btnReadLesson_Quiz_Respect);
        ImageButton homepageCLC_Respect = findViewById(R.id.homepageCLC_Respect);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_respect = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Respect", 0);
        totalScoreLabel.setText(score_respect + " / 5");

        if (score_respect == 0 || score_respect == 1 || score_respect == 2){
            imgTrophy_Respect.setImageResource(R.drawable.congratsbadgerespect);
            achievement_respect = "Respect Beginner";
        }
        if (score_respect == 3 || score_respect == 4){
            imgTrophy_Respect.setImageResource(R.drawable.congratsmedalrespect);
            achievement_respect = "Respect Expert";
        }
        if (score_respect == 5){
            imgTrophy_Respect.setImageResource(R.drawable.congratstrophyrespect);
            achievement_respect = "Respect Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_respect = documentSnapshot.getLong("respect quiz score").intValue();

                if(score_respect >=  initialScore_respect) {
                    transaction.update(docRef, "respect quiz score", score_respect);
                    transaction.update(docRef, "respect achievement", achievement_respect);
                }
                if(score_respect < initialScore_respect){
                    transaction.update(docRef, "respect quiz score", initialScore_respect);
                }
                return null;
            }
        });

        gmrc36btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ResultsRespect.this, Gmrc3to6.class));
            }
        });

        achievementsbtnCLC_Respect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsRespect.this, Achievements3to6Respect2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Respect", score_respect);
                startActivity(proceed);
            }
        });

        btnReadLesson_Quiz_Respect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsRespect.this, LessonRespect.class);
                startActivity(proceed);
            }
        });

        homepageCLC_Respect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                Intent proceed = new Intent(ResultsRespect.this, Homepage3to6.class);
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