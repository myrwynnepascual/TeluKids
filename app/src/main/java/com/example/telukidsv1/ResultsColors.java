
package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class ResultsColors extends AppCompatActivity {
    private int  score_colors;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_colors);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Colors);
        ImageView imgTrophy_Colors = findViewById(R.id.imgTrophy_Colors);
        ImageButton achievementsbtnCLC_Colors = findViewById(R.id.achievementsbtnCLC_Colors);
        ImageButton btnReadLesson_Quiz_Colors = findViewById(R.id.btnReadLesson_Quiz_Colors);
        ImageButton homepageCLC_Colors = findViewById(R.id.homepageCLC_Colors);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_colors = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Colors", 0);
        totalScoreLabel.setText(score_colors + " / 5");

        if (score_colors == 0 || score_colors == 1 || score_colors == 2){
            imgTrophy_Colors.setImageResource(R.drawable.congratsbadgecolors);
            achievement_colors = "Colors Beginner";
        }
        if (score_colors == 3 || score_colors == 4){
            imgTrophy_Colors.setImageResource(R.drawable.congratsmedalcolors);
            achievement_colors = "Colors Expert";
        }
        if (score_colors == 5){
            imgTrophy_Colors.setImageResource(R.drawable.congratstrophycolors);
            achievement_colors = "Colors Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "colors quiz score", score_colors);
                transaction.update(docRef, "colors achievement", achievement_colors);
                return null;
            }
        });

        achievementsbtnCLC_Colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsColors.this, BasicConcepts.class);
                startActivity(proceed);
            }
        });
        btnReadLesson_Quiz_Colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(ResultsColors.this, BasicConcepts.class);
                startActivity(proceed);
            }
        });
        homepageCLC_Colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(ResultsColors.this, Homepage3to6.class);
                startActivity(proceed);
            }
        });
    }
}