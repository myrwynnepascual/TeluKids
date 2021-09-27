
package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class ResultsCompassion extends AppCompatActivity {
    private int  score_compassion;
    private int initialScore_compassion;
    MediaPlayer congrats;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_compassion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_compassion);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Compassion);
        ImageView imgTrophy_Compassion = findViewById(R.id.imgTrophy_Compassion);
        ImageButton achievementsbtnCLC_Compassion = findViewById(R.id.achievementsbtnCLC_Compassion);
        ImageButton btnReadLesson_Quiz_Compassion = findViewById(R.id.btnReadLesson_Quiz_Compassion);
        ImageButton homepageCLC_Compassion = findViewById(R.id.homepageCLC_Compassion);

        congrats = MediaPlayer.create(this, R.raw.yaysfx);
        congrats.start();

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_compassion = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Compassion", 0);
        totalScoreLabel.setText(score_compassion + " / 5");

        if (score_compassion == 0 || score_compassion == 1 || score_compassion == 2){
            imgTrophy_Compassion.setImageResource(R.drawable.congratsbadgecompassion);
            achievement_compassion = "Compassion Beginner";
        }
        if (score_compassion == 3 || score_compassion == 4){
            imgTrophy_Compassion.setImageResource(R.drawable.congratsmedalcompassion);
            achievement_compassion = "Compassion Expert";
        }
        if (score_compassion == 5){
            imgTrophy_Compassion.setImageResource(R.drawable.congratstrophycompassion);
            achievement_compassion = "Compassion Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                initialScore_compassion = documentSnapshot.getLong("compassion quiz score").intValue();

                if(score_compassion >= initialScore_compassion) {
                    transaction.update(docRef, "compassion quiz score", score_compassion);
                    transaction.update(docRef, "compassion achievement", achievement_compassion);
                }
                if (score_compassion < initialScore_compassion){
                    transaction.update(docRef, "compassion quiz score", initialScore_compassion);
                }
                return null;
            }
        });

        achievementsbtnCLC_Compassion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsCompassion.this, Achievements3to6Compassion2.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_Compassion", score_compassion);
                startActivity(proceed);
            }
        });
        btnReadLesson_Quiz_Compassion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsCompassion.this, Gmrc3to6.class);
                startActivity(proceed);
            }
        });
        homepageCLC_Compassion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(ResultsCompassion.this, Homepage3to6.class);
                startActivity(proceed);
            }
        });
    }
}