
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

public class ResultsHonesty extends AppCompatActivity {
    private int  score_honesty;
    private int initialScore_honesty;
    MediaPlayer congrats,sfx;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_honesty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_honesty);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Honesty);
        ImageView imgTrophy_Honesty = findViewById(R.id.imgTrophy_Honesty);
        ImageButton gmrc36btn = findViewById(R.id.backbtnHR);
        ImageButton achievementsbtnCLC_Honesty = findViewById(R.id.achievementsbtnCLC_Honesty);
        ImageButton btnReadLesson_Quiz_Honesty = findViewById(R.id.btnReadLesson_Quiz_Honesty);
        ImageButton homepageCLC_Honesty = findViewById(R.id.homepageCLC_Honesty);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_honesty = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Honesty", 0);
        totalScoreLabel.setText(score_honesty + " / 5");

        if (score_honesty == 0 || score_honesty == 1 || score_honesty == 2){
            imgTrophy_Honesty.setImageResource(R.drawable.congratsbadgehonesty);
            achievement_honesty = "Honesty Beginner";
        }
        if (score_honesty == 3 || score_honesty == 4){
            imgTrophy_Honesty.setImageResource(R.drawable.congratsmedalhonesty);
            achievement_honesty = "Honesty Expert";
        }
        if (score_honesty == 5){
            imgTrophy_Honesty.setImageResource(R.drawable.congratstrophyhonesty);
            achievement_honesty = "Honesty Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_honesty = documentSnapshot.getLong("honesty quiz score").intValue();

                if(score_honesty >= initialScore_honesty) {
                    transaction.update(docRef, "honesty quiz score", score_honesty);
                    transaction.update(docRef, "honesty achievement", achievement_honesty);
                }
                if(score_honesty < initialScore_honesty){
                    transaction.update(docRef, "honesty quiz score", initialScore_honesty);
                }
                return null;
            }
        });
        gmrc36btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ResultsHonesty.this,Gmrc3to6.class));
            }
        });
        achievementsbtnCLC_Honesty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsHonesty.this, Achievements3to6Honesty2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Honesty", score_honesty);
                startActivity(proceed);
            }
        });
        btnReadLesson_Quiz_Honesty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsHonesty.this, LessonHonesty.class);
                startActivity(proceed);
            }
        });
        homepageCLC_Honesty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                Intent proceed = new Intent(ResultsHonesty.this, Homepage3to6.class);
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