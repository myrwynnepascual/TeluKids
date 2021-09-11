package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class Achievements3to6Addition2 extends AppCompatActivity {

    private int score_shapes;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    // Ages 3-6 Achievements and Lessons
    String achievement_counting, achievement_addition, achievement_subtraction, achievement_colors, achievement_shapes;
    String achievement_discipline, achievement_honesty, achievement_respect, achievement_sociability, achievement_compassion;
    String lesson_counting, lesson_addition, lesson_subtraction, lesson_colors, lesson_shapes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements3to6_addition2);

        ImageButton backbtnAchievements3to6 = findViewById(R.id.backbtnAchievements36Addition2);

        //Trophies
        //GMRC 3-6
        ImageView imgAchievements_DisciplineTrophy = findViewById(R.id.trophydiscipline36Addition2);
        ImageView imgAchievements_HonestyTrophy = findViewById(R.id.trophyhonesty36Addition2);
        ImageView imgAchievements_RespectTrophy = findViewById(R.id.trophyrespect36Addition2);
        ImageView imgAchievements_SociabilityTrophy = findViewById(R.id.trophysociability36Addition2);
        ImageView imgAchievements_CompassionTrophy = findViewById(R.id.trophycompassion36Addition2);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityTrophy = findViewById(R.id.trophyresponsibility36Addition2);
        ImageView imgAchievements_LoveTrophy = findViewById(R.id.trophylove36Addition2);
        ImageView imgAchievements_ObedienceTrophy = findViewById(R.id.trophyobedience36Addition2);
        ImageView imgAchievements_DoingGoodTrophy = findViewById(R.id.trophydoinggood36Addition2);

        //Basic Concepts
        ImageView imgAchievements_ColorsTrophy = findViewById(R.id.trophycolors36Addition2);
        ImageView imgAchievements_CountingTrophy = findViewById(R.id.trophycounting36Addition2);
        ImageView imgAchievements_AdditionTrophy = findViewById(R.id.trophyaddition36Addition2);
        ImageView imgAchievements_SubtractionTrophy = findViewById(R.id.trophysubtraction36Addition2);
        ImageView imgAchievements_ShapesTrophy = findViewById(R.id.trophyshapes36Addition2);

        //Medals
        //GMRC 3-6
        ImageView imgAchievements_DisciplineMedal = findViewById(R.id.medaldiscipline36Addition2);
        ImageView imgAchievements_HonestyMedal = findViewById(R.id.medalhonesty36Addition2);
        ImageView imgAchievements_RespectMedal = findViewById(R.id.medalrespect36Addition2);
        ImageView imgAchievements_SociabilityMedal = findViewById(R.id.medalsociability36Addition2);
        ImageView imgAchievements_CompassionMedal = findViewById(R.id.medalcompassion36Addition2);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityMedal = findViewById(R.id.medalresponsibility36Addition2);
        ImageView imgAchievements_LoveMedal = findViewById(R.id.medallove36Addition2);
        ImageView imgAchievements_ObedienceMedal = findViewById(R.id.medalobedience36Addition2);
        ImageView imgAchievements_DoingGoodMedal = findViewById(R.id.medaldoinggood36Addition2);

        //Basic Concepts
        ImageView imgAchievements_ColorsMedal = findViewById(R.id.medalcolors36Addition2);
        ImageView imgAchievements_CountingMedal = findViewById(R.id.medalcounting36Addition2);
        ImageView imgAchievements_AdditionMedal = findViewById(R.id.medaladdition36Addition2);
        ImageView imgAchievements_SubtractionMedal = findViewById(R.id.medalsubtraction36Addition2);
        ImageView imgAchievements_ShapesMedal = findViewById(R.id.medalshapes36Addition2);


        //Badges
        //GMRC 3-6
        ImageView imgAchievements_DisciplineBadge = findViewById(R.id.badgediscipline36Addition2);
        ImageView imgAchievements_HonestyBadge = findViewById(R.id.badgehonesty36Addition2);
        ImageView imgAchievements_RespectBadge = findViewById(R.id.badgerespect36Addition2);
        ImageView imgAchievements_SociabilityBadge = findViewById(R.id.badgesociability36Addition2);
        ImageView imgAchievements_CompassionBadge = findViewById(R.id.badgecompassion36Addition2);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityBadge = findViewById(R.id.badgeresponsibility36Addition2);
        ImageView imgAchievements_LoveBadge = findViewById(R.id.badgelove36Addition2);
        ImageView imgAchievements_ObedienceBadge = findViewById(R.id.badgeobedience36Addition2);
        ImageView imgAchievements_DoingGoodBadge = findViewById(R.id.badgedoinggood36Addition2);

        //Basic Concepts
        ImageView imgAchievements_ColorsBadge = findViewById(R.id.badgecolors36Addition2);
        ImageView imgAchievements_CountingBadge = findViewById(R.id.badgecounting36Addition2);
        ImageView imgAchievements_AdditionBadge = findViewById(R.id.badgeaddition36Addition2);
        ImageView imgAchievements_SubtractionBadge = findViewById(R.id.badgesubtraction36Addition2);
        ImageView imgAchievements_ShapesBadge = findViewById(R.id.badgeshapes36Addition2);


        //Certificates
        //GMRC 3-6
        ImageView imgAchievements_DisciplineCertificate = findViewById(R.id.certificatediscipline36Addition2);
        ImageView imgAchievements_HonestyCertificate = findViewById(R.id.certificatehonesty36Addition2);
        ImageView imgAchievements_RespectCertificate = findViewById(R.id.certificaterespect36Addition2);
        ImageView imgAchievements_SociabilityCertificate = findViewById(R.id.certificatesociability36Addition2);
        ImageView imgAchievements_CompassionCertificate = findViewById(R.id.certificatecompassion36Addition2);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityCertificate = findViewById(R.id.certificateresponsibility36Addition2);
        ImageView imgAchievements_LoveCertificate = findViewById(R.id.certificatelove36Addition2);
        ImageView imgAchievements_ObedienceCertificate = findViewById(R.id.certificateobedience36Addition2);
        ImageView imgAchievements_DoingGoodCertificate = findViewById(R.id.certificatedoinggood36Addition2);

        //Basic Concepts
        ImageView imgAchievements_ColorsCertificate = findViewById(R.id.certificatecolors36Addition2);
        ImageView imgAchievements_CountingCertificate = findViewById(R.id.certificatecounting36Addition2);
        ImageView imgAchievements_AdditionCertificate = findViewById(R.id.certificateaddition36Addition2);
        ImageView imgAchievements_SubtractionCertificate = findViewById(R.id.certificatesubtraction36Addition2);
        ImageView imgAchievements_ShapesCertificate = findViewById(R.id.certificateshapes36Addition2);

        //Firebase Firestore
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());


        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Colors
                achievement_colors = documentSnapshot.getString("colors achievement");
                lesson_colors = documentSnapshot.getString("colors lesson");

                if (achievement_colors.equals("Colors Beginner")){
                    imgAchievements_ColorsBadge.setImageResource(R.drawable.badgecolors);
                }
                if (achievement_colors.equals("Colors Expert")){
                    imgAchievements_ColorsMedal.setImageResource(R.drawable.medalcolors);
                    imgAchievements_ColorsBadge.setImageResource(R.drawable.badgecolors);
                }
                if (achievement_colors.equals("Colors Master")){
                    imgAchievements_ColorsTrophy.setImageResource(R.drawable.trophycolors);
                    imgAchievements_ColorsMedal.setImageResource(R.drawable.medalcolors);
                    imgAchievements_ColorsBadge.setImageResource(R.drawable.badgecolors);
                }
                if (lesson_colors.equals("Completed")){
                    imgAchievements_ColorsCertificate.setImageResource(R.drawable.certificatecolors);
                }
                return null;
            }
        });

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Counting
                achievement_counting = documentSnapshot.getString("counting achievement");
                lesson_counting = documentSnapshot.getString("counting lesson");

                if (achievement_counting.equals("Counting Beginner")){
                    imgAchievements_CountingBadge.setImageResource(R.drawable.badgecounting);
                }
                if (achievement_counting.equals("Counting Expert")){
                    imgAchievements_CountingMedal.setImageResource(R.drawable.medalcounting);
                    imgAchievements_CountingBadge.setImageResource(R.drawable.badgecounting);
                }
                if (achievement_counting.equals("Counting Master")){
                    imgAchievements_CountingTrophy.setImageResource(R.drawable.trophycounting);
                    imgAchievements_CountingMedal.setImageResource(R.drawable.medalcounting);
                    imgAchievements_CountingBadge.setImageResource(R.drawable.badgecounting);
                }
                if (lesson_counting.equals("Completed")){
                    imgAchievements_CountingCertificate.setImageResource(R.drawable.certificatecounting);
                }
                return null;
            }
        });

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Addition
                achievement_addition = documentSnapshot.getString("addition achievement");
                lesson_addition = documentSnapshot.getString("addition lesson");

                if (achievement_addition.equals("Addition Beginner")){
                    imgAchievements_AdditionBadge.setImageResource(R.drawable.badgeaddition);
                }
                if (achievement_addition.equals("Addition Expert")){
                    imgAchievements_AdditionMedal.setImageResource(R.drawable.medaladdition);
                    imgAchievements_AdditionBadge.setImageResource(R.drawable.badgeaddition);
                }
                if (achievement_addition.equals("Addition Master")){
                    imgAchievements_AdditionTrophy.setImageResource(R.drawable.trophyaddition);
                    imgAchievements_AdditionMedal.setImageResource(R.drawable.medaladdition);
                    imgAchievements_AdditionBadge.setImageResource(R.drawable.badgeaddition);
                }
                if (lesson_addition.equals("Completed")){
                    imgAchievements_AdditionCertificate.setImageResource(R.drawable.certificateaddition);
                }
                return null;
            }
        });


        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Shapes
                achievement_shapes = documentSnapshot.getString("shapes achievement");
                lesson_shapes = documentSnapshot.getString("shapes lesson");

                if (achievement_shapes.equals("Shapes Beginner")){
                    imgAchievements_ShapesBadge.setImageResource(R.drawable.badgeshapes);
                }
                if (achievement_shapes.equals("Shapes Expert")){
                    imgAchievements_ShapesMedal.setImageResource(R.drawable.medalshapes);
                    imgAchievements_ShapesBadge.setImageResource(R.drawable.badgeshapes);
                }
                if (achievement_shapes.equals("Shapes Master")){
                    imgAchievements_ShapesTrophy.setImageResource(R.drawable.trophyshapes);
                    imgAchievements_ShapesMedal.setImageResource(R.drawable.medalshapes);
                    imgAchievements_ShapesBadge.setImageResource(R.drawable.badgeshapes);
                }
                if (lesson_shapes.equals("Completed")){
                    imgAchievements_ShapesCertificate.setImageResource(R.drawable.certificateshapes);
                }
                return null;
            }
        });

        backbtnAchievements3to6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(Achievements3to6Addition2.this, ResultsAddition.class);
                startActivity(proceed);
            }
        });
    }
}