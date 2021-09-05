
package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telukidsv1.QuizShapes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

import java.util.HashMap;
import java.util.Map;

public class ResultsShapes extends AppCompatActivity {
    private int initial_score_shapes, score_shapes;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_shapes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_shapes);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel_Shapes);
        ImageView imgTrophy_Shapes = findViewById(R.id.imgTrophy_Shapes);
        Button btnNext_Quiz_Shapes = findViewById(R.id.btnNext_Quiz_Shapes);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        score_shapes = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_Shapes", 0);
        totalScoreLabel.setText(score_shapes + " / 5");

        if (score_shapes == 0 || score_shapes == 1 || score_shapes == 2){
            imgTrophy_Shapes.setImageResource(R.drawable.medal_good_rounded);
            achievement_shapes = "Shapes Beginner";
        }
        if (score_shapes == 3 || score_shapes == 4){
            imgTrophy_Shapes.setImageResource(R.drawable.medal_verygood_rounded);
            achievement_shapes = "Shapes Expert";
        }
        if (score_shapes == 5){
            imgTrophy_Shapes.setImageResource(R.drawable.trophy_shapesmaster_rounded);
            achievement_shapes = "Shapes Master";
        }

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "shapes quiz score", score_shapes);
                transaction.update(docRef, "shapes achievement", achievement_shapes);
                return null;
            }
        });

        btnNext_Quiz_Shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(ResultsShapes.this, CongratsPageShapes.class);
                startActivity(proceed);
            }
        });
    }
}