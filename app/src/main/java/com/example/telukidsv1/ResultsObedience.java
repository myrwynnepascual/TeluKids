
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

public class ResultsObedience extends AppCompatActivity {
    private int  score_obedience;
    private int initialScore_obedience;
    MediaPlayer congrats,sfx;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_obedience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_obedience);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Obedience);
        ImageView imgTrophy_Obedience = findViewById(R.id.imgTrophy_Obedience);
        ImageButton gmrc79btn = findViewById(R.id.backbtnOR);
        ImageButton achievementsbtnCLC_Obedience = findViewById(R.id.achievementsbtnCLC_Obedience);
        ImageButton btnReadLesson_Quiz_Obedience = findViewById(R.id.btnReadLesson_Quiz_Obedience);
        ImageButton homepageCLC_Obedience = findViewById(R.id.homepageCLC_Obedience);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_obedience = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Obedience", 0);
        totalScoreLabel.setText(score_obedience + " / 5");

        if (score_obedience == 0 || score_obedience == 1 || score_obedience == 2){
            imgTrophy_Obedience.setImageResource(R.drawable.congratsbadgeobedience);
            achievement_obedience = "Obedience Beginner";
        }
        if (score_obedience == 3 || score_obedience == 4){
            imgTrophy_Obedience.setImageResource(R.drawable.congratsmedalobedience);
            achievement_obedience = "Obedience Expert";
        }
        if (score_obedience == 5){
            imgTrophy_Obedience.setImageResource(R.drawable.congratstrophyobedience);
            achievement_obedience = "Obedience Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_obedience = documentSnapshot.getLong("obedience quiz score").intValue();

                if(score_obedience >= initialScore_obedience) {
                    transaction.update(docRef, "obedience quiz score", score_obedience);
                    transaction.update(docRef, "obedience achievement", achievement_obedience);
                }
                if(score_obedience < initialScore_obedience){
                    transaction.update(docRef, "obedience quiz score", initialScore_obedience);
                }
                return null;
            }
        });
        
        gmrc79btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ResultsObedience.this, Gmrc7to9.class));
            }
        });

        achievementsbtnCLC_Obedience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsObedience.this, Achievements7to9Obedience2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Obedience", score_obedience);
                startActivity(proceed);
            }
        });

        btnReadLesson_Quiz_Obedience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsObedience.this, LessonObedience.class);
                startActivity(proceed);
            }
        });

        homepageCLC_Obedience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                Intent proceed = new Intent(ResultsObedience.this, Homepage7to9.class);
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