package com.example.telukidsv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class Achievements3to6 extends AppCompatActivity {
    private int score_shapes;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String achievement_numbers, achievement_colors, achievement_shapes;
    String achievement_discipline, achievement_honesty, achievement_respect;
    String lesson_numbers, lesson_colors, lesson_shapes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievements_ages36);

        ImageView imgAchievements_ColorsTrophy = findViewById(R.id.imgAchievements_ColorsTrophy);
        ImageView imgAchievements_NumbersTrophy = findViewById(R.id.imgAchievements_NumbersTrophy);
        ImageView imgAchievements_ShapesTrophy = findViewById(R.id.imgAchievements_ShapesTrophy);
        ImageView imgAchievements_ColorsMedal = findViewById(R.id.imgAchievements_ColorsMedal);
        ImageView imgAchievements_NumbersMedal = findViewById(R.id.imgAchievements_NumbersMedal);
        ImageView imgAchievements_ShapesMedal = findViewById(R.id.imgAchievements_ShapesMedal);
        ImageView imgAchievements_ColorsCertificate = findViewById(R.id.imgAchievements_ColorsCertificate);
        ImageView imgAchievements_NumbersCertificate = findViewById(R.id.imgAchievements_NumbersCertificate);
        ImageView imgAchievements_ShapesCertificate = findViewById(R.id.imgAchievements_ShapesCertificate);
        ImageButton backbtnAchievements3to6 = findViewById(R.id.backbtnAchievements3to6);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());


        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);
                achievement_shapes = documentSnapshot.getString("shapes achievement");
                lesson_shapes = documentSnapshot.getString("shapes lesson");
                if (achievement_shapes.equals("Shapes Beginner")){
                    imgAchievements_ShapesMedal.setImageResource(R.drawable.medal_shapesbeginner);
                }
                if (achievement_shapes.equals("Shapes Expert")){
                    imgAchievements_ShapesMedal.setImageResource(R.drawable.medal_shapesexpert);
                }
                if (achievement_shapes.equals("Shapes Master")){
                    imgAchievements_ShapesTrophy.setImageResource(R.drawable.trophy_shapesmaster);
                    imgAchievements_ShapesMedal.setImageResource(R.drawable.medal_shapesexpert);
                }
                if (lesson_shapes.equals("Completed")){
                    imgAchievements_ShapesCertificate.setImageResource(R.drawable.certificate_shapes);
                }
                return null;
            }
        });

        backbtnAchievements3to6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(Achievements3to6.this, Homepage3to6.class);
                startActivity(proceed);
            }
        });

    }
}
