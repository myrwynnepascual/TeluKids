
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

public class ResultsDiscipline extends AppCompatActivity {
    private int  score_discipline;
    private int initialScore_discipline;
    MediaPlayer congrats;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_discipline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_discipline);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Discipline);
        ImageView imgTrophy_Discipline = findViewById(R.id.imgTrophy_Discipline);
        ImageButton gmrc36btn = findViewById(R.id.backbtnDR);
        ImageButton achievementsbtnCLC_Discipline = findViewById(R.id.achievementsbtnCLC_Discipline);
        ImageButton btnReadLesson_Quiz_Discipline = findViewById(R.id.btnReadLesson_Quiz_Discipline);
        ImageButton homepageCLC_Discipline = findViewById(R.id.homepageCLC_Discipline);
        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        BackgroundSoundService.onResume();

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_discipline = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Discipline", 0);
        totalScoreLabel.setText(score_discipline + " / 5");

        if (score_discipline == 0 || score_discipline == 1 || score_discipline == 2){
            imgTrophy_Discipline.setImageResource(R.drawable.congratsbadgediscipline);
            achievement_discipline = "Discipline Beginner";
        }
        if (score_discipline == 3 || score_discipline == 4){
            imgTrophy_Discipline.setImageResource(R.drawable.congratsmedaldiscipline);
            achievement_discipline = "Discipline Expert";
        }
        if (score_discipline == 5){
            imgTrophy_Discipline.setImageResource(R.drawable.congratstrophydiscipline);
            achievement_discipline = "Discipline Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_discipline = documentSnapshot.getLong("discipline quiz score").intValue();

                if(score_discipline >= initialScore_discipline) {
                    transaction.update(docRef, "discipline quiz score", score_discipline);
                    transaction.update(docRef, "discipline achievement", achievement_discipline);
                }
                if(score_discipline < initialScore_discipline){
                    transaction.update(docRef, "discipline quiz score", initialScore_discipline);
                }
                return null;
            }
        });

        achievementsbtnCLC_Discipline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsDiscipline.this, Achievements3to6Discipline2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Discipline", score_discipline);
                startActivity(proceed);
            }
        });
        gmrc36btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(ResultsDiscipline.this, Gmrc3to6.class));
            }
        });
        btnReadLesson_Quiz_Discipline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                Intent proceed = new Intent(ResultsDiscipline.this, LessonDiscipline.class);
                startActivity(proceed);
            }
        });
        homepageCLC_Discipline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sfx.start();
                Intent proceed = new Intent(ResultsDiscipline.this, Homepage3to6.class);
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