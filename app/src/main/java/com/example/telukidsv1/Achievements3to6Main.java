package com.example.telukidsv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class Achievements3to6Main extends AppCompatActivity {

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    // Ages 3-6 Achievements and Lessons
    String achievement_counting, achievement_addition, achievement_subtraction, achievement_colors, achievement_shapes;
    String achievement_discipline, achievement_honesty, achievement_respect, achievement_sociability, achievement_compassion;

    String lesson_counting, lesson_addition, lesson_subtraction, lesson_colors, lesson_shapes;
    String lesson_discipline, lesson_honesty, lesson_respect, lesson_sociability, lesson_compassion;

    // Ages 7-9 Achievements and Lessons
    String achievement_responsibility, achievement_love, achievement_obedience, achievement_doinggood;
    String lesson_responsibility, lesson_love, lesson_obedience, lesson_doinggood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements3to6_main);

        ImageButton backbtnAchievements3to6 = findViewById(R.id.backbtnAchievements36Main);

        //Trophies
        //GMRC 3-6
        ImageView imgAchievements_DisciplineTrophy = findViewById(R.id.trophydiscipline36Main);
        ImageView imgAchievements_HonestyTrophy = findViewById(R.id.trophyhonesty36Main);
        ImageView imgAchievements_RespectTrophy = findViewById(R.id.trophyrespect36Main);
        ImageView imgAchievements_SociabilityTrophy = findViewById(R.id.trophysociability36Main);
        ImageView imgAchievements_CompassionTrophy = findViewById(R.id.trophycompassion36Main);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityTrophy = findViewById(R.id.trophyresponsibility36Main);
        ImageView imgAchievements_LoveTrophy = findViewById(R.id.trophylove36Main);
        ImageView imgAchievements_ObedienceTrophy = findViewById(R.id.trophyobedience36Main);
        ImageView imgAchievements_DoingGoodTrophy = findViewById(R.id.trophydoinggood36Main);

        //Basic Concepts
        ImageView imgAchievements_ColorsTrophy = findViewById(R.id.trophycolors36Main);
        ImageView imgAchievements_CountingTrophy = findViewById(R.id.trophycounting36Main);
        ImageView imgAchievements_AdditionTrophy = findViewById(R.id.trophyaddition36Main);
        ImageView imgAchievements_SubtractionTrophy = findViewById(R.id.trophysubtraction36Main);
        ImageView imgAchievements_ShapesTrophy = findViewById(R.id.trophyshapes36Main);

        //Medals
        //GMRC 3-6
        ImageView imgAchievements_DisciplineMedal = findViewById(R.id.medaldiscipline36Main);
        ImageView imgAchievements_HonestyMedal = findViewById(R.id.medalhonesty36Main);
        ImageView imgAchievements_RespectMedal = findViewById(R.id.medalrespect36Main);
        ImageView imgAchievements_SociabilityMedal = findViewById(R.id.medalsociability36Main);
        ImageView imgAchievements_CompassionMedal = findViewById(R.id.medalcompassion36Main);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityMedal = findViewById(R.id.medalresponsibility36Main);
        ImageView imgAchievements_LoveMedal = findViewById(R.id.medallove36Main);
        ImageView imgAchievements_ObedienceMedal = findViewById(R.id.medalobedience36Main);
        ImageView imgAchievements_DoingGoodMedal = findViewById(R.id.medaldoinggood36Main);

        //Basic Concepts
        ImageView imgAchievements_ColorsMedal = findViewById(R.id.medalcolors36Main);
        ImageView imgAchievements_CountingMedal = findViewById(R.id.medalcounting36Main);
        ImageView imgAchievements_AdditionMedal = findViewById(R.id.medaladdition36Main);
        ImageView imgAchievements_SubtractionMedal = findViewById(R.id.medalsubtraction36Main);
        ImageView imgAchievements_ShapesMedal = findViewById(R.id.medalshapes36Main);


        //Badges
        //GMRC 3-6
        ImageView imgAchievements_DisciplineBadge = findViewById(R.id.badgediscipline36Main);
        ImageView imgAchievements_HonestyBadge = findViewById(R.id.badgehonesty36Main);
        ImageView imgAchievements_RespectBadge = findViewById(R.id.badgerespect36Main);
        ImageView imgAchievements_SociabilityBadge = findViewById(R.id.badgesociability36Main);
        ImageView imgAchievements_CompassionBadge = findViewById(R.id.badgecompassion36Main);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityBadge = findViewById(R.id.badgeresponsibility36Main);
        ImageView imgAchievements_LoveBadge = findViewById(R.id.badgelove36Main);
        ImageView imgAchievements_ObedienceBadge = findViewById(R.id.badgeobedience36Main);
        ImageView imgAchievements_DoingGoodBadge = findViewById(R.id.badgedoinggood36Main);

        //Basic Concepts
        ImageView imgAchievements_ColorsBadge = findViewById(R.id.badgecolors36Main);
        ImageView imgAchievements_CountingBadge = findViewById(R.id.badgecounting36Main);
        ImageView imgAchievements_AdditionBadge = findViewById(R.id.badgeaddition36Main);
        ImageView imgAchievements_SubtractionBadge = findViewById(R.id.badgesubtraction36Main);
        ImageView imgAchievements_ShapesBadge = findViewById(R.id.badgeshapes36Main);


        //Certificates
        //GMRC 3-6
        ImageView imgAchievements_DisciplineCertificate = findViewById(R.id.certificatediscipline36Main);
        ImageView imgAchievements_HonestyCertificate = findViewById(R.id.certificatehonesty36Main);
        ImageView imgAchievements_RespectCertificate = findViewById(R.id.certificaterespect36Main);
        ImageView imgAchievements_SociabilityCertificate = findViewById(R.id.certificatesociability36Main);
        ImageView imgAchievements_CompassionCertificate = findViewById(R.id.certificatecompassion36Main);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityCertificate = findViewById(R.id.certificateresponsibility36Main);
        ImageView imgAchievements_LoveCertificate = findViewById(R.id.certificatelove36Main);
        ImageView imgAchievements_ObedienceCertificate = findViewById(R.id.certificateobedience36Main);
        ImageView imgAchievements_DoingGoodCertificate = findViewById(R.id.certificatedoinggood36Main);

        //Basic Concepts
        ImageView imgAchievements_ColorsCertificate = findViewById(R.id.certificatecolors36Main);
        ImageView imgAchievements_CountingCertificate = findViewById(R.id.certificatecounting36Main);
        ImageView imgAchievements_AdditionCertificate = findViewById(R.id.certificateaddition36Main);
        ImageView imgAchievements_SubtractionCertificate = findViewById(R.id.certificatesubtraction36Main);
        ImageView imgAchievements_ShapesCertificate = findViewById(R.id.certificateshapes36Main);

        //Firebase Firestore
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());



        // BASIC CONCEPTS
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

                //Subtraction
                achievement_subtraction = documentSnapshot.getString("subtraction achievement");
                lesson_subtraction = documentSnapshot.getString("subtraction lesson");

                if (achievement_subtraction.equals("Subtraction Beginner")){
                    imgAchievements_SubtractionBadge.setImageResource(R.drawable.badgesubtraction);
                }
                if (achievement_subtraction.equals("Subtraction Expert")){
                    imgAchievements_SubtractionMedal.setImageResource(R.drawable.medalsubtraction);
                    imgAchievements_SubtractionBadge.setImageResource(R.drawable.badgesubtraction);
                }
                if (achievement_subtraction.equals("Subtraction Master")){
                    imgAchievements_SubtractionTrophy.setImageResource(R.drawable.trophysubtraction);
                    imgAchievements_SubtractionMedal.setImageResource(R.drawable.medalsubtraction);
                    imgAchievements_SubtractionBadge.setImageResource(R.drawable.badgesubtraction);
                }
                if (lesson_subtraction.equals("Completed")){
                    imgAchievements_SubtractionCertificate.setImageResource(R.drawable.certificatesubtraction);
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


        //GMRC 3-6
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Discipline
                achievement_discipline = documentSnapshot.getString("discipline achievement");
                lesson_discipline = documentSnapshot.getString("discipline lesson");

                if (achievement_discipline.equals("Discipline Beginner")){
                    imgAchievements_DisciplineBadge.setImageResource(R.drawable.badgesdiscipline);
                }
                if (achievement_discipline.equals("Discipline Expert")){
                    imgAchievements_DisciplineMedal.setImageResource(R.drawable.medaldiscipline);
                    imgAchievements_DisciplineBadge.setImageResource(R.drawable.badgesdiscipline);
                }
                if (achievement_discipline.equals("Discipline Master")){
                    imgAchievements_DisciplineTrophy.setImageResource(R.drawable.trophydiscipline);
                    imgAchievements_DisciplineMedal.setImageResource(R.drawable.medaldiscipline);
                    imgAchievements_DisciplineBadge.setImageResource(R.drawable.badgesdiscipline);
                }
                if (lesson_discipline.equals("Completed")){
                    imgAchievements_DisciplineCertificate.setImageResource(R.drawable.certificatediscipline);
                }
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Honesty
                achievement_honesty = documentSnapshot.getString("honesty achievement");
                lesson_honesty = documentSnapshot.getString("honesty lesson");

                if (achievement_honesty.equals("Honesty Beginner")){
                    imgAchievements_HonestyBadge.setImageResource(R.drawable.badgehonesty);
                }
                if (achievement_honesty.equals("Honesty Expert")){
                    imgAchievements_HonestyMedal.setImageResource(R.drawable.medalhonesty);
                    imgAchievements_HonestyBadge.setImageResource(R.drawable.badgehonesty);
                }
                if (achievement_honesty.equals("Honesty Master")){
                    imgAchievements_HonestyTrophy.setImageResource(R.drawable.trophyhonesty);
                    imgAchievements_HonestyMedal.setImageResource(R.drawable.medalhonesty);
                    imgAchievements_HonestyBadge.setImageResource(R.drawable.badgehonesty);
                }
                if (lesson_honesty.equals("Completed")){
                    imgAchievements_HonestyCertificate.setImageResource(R.drawable.certificatehonesty);
                }
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Respect
                achievement_respect = documentSnapshot.getString("respect achievement");
                lesson_respect = documentSnapshot.getString("respect lesson");

                if (achievement_respect.equals("Respect Beginner")){
                    imgAchievements_RespectBadge.setImageResource(R.drawable.badgerespect);
                }
                if (achievement_respect.equals("Respect Expert")){
                    imgAchievements_RespectMedal.setImageResource(R.drawable.medalrespect);
                    imgAchievements_RespectBadge.setImageResource(R.drawable.badgerespect);
                }
                if (achievement_respect.equals("Respect Master")){
                    imgAchievements_RespectTrophy.setImageResource(R.drawable.trophyrespect);
                    imgAchievements_RespectMedal.setImageResource(R.drawable.medalrespect);
                    imgAchievements_RespectBadge.setImageResource(R.drawable.badgerespect);
                }
                if (lesson_respect.equals("Completed")){
                    imgAchievements_RespectCertificate.setImageResource(R.drawable.certificaterespect);
                }
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Sociability
                achievement_sociability = documentSnapshot.getString("sociability achievement");
                lesson_sociability = documentSnapshot.getString("sociability lesson");

                if (achievement_sociability.equals("Sociability Beginner")){
                    imgAchievements_SociabilityBadge.setImageResource(R.drawable.badgesociability);
                }
                if (achievement_sociability.equals("Sociability Expert")){
                    imgAchievements_SociabilityMedal.setImageResource(R.drawable.medalsociability);
                    imgAchievements_SociabilityBadge.setImageResource(R.drawable.badgesociability);
                }
                if (achievement_sociability.equals("Sociability Master")){
                    imgAchievements_SociabilityTrophy.setImageResource(R.drawable.trophysociability);
                    imgAchievements_SociabilityMedal.setImageResource(R.drawable.medalsociability);
                    imgAchievements_SociabilityBadge.setImageResource(R.drawable.badgesociability);
                }
                if (lesson_sociability.equals("Completed")){
                    imgAchievements_SociabilityCertificate.setImageResource(R.drawable.certificatesociability);
                }
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Compassion
                achievement_compassion = documentSnapshot.getString("compassion achievement");
                lesson_compassion = documentSnapshot.getString("compassion lesson");

                if (achievement_compassion.equals("Compassion Beginner")){
                    imgAchievements_CompassionBadge.setImageResource(R.drawable.badgecompassion);
                }
                if (achievement_compassion.equals("Compassion Expert")){
                    imgAchievements_CompassionMedal.setImageResource(R.drawable.medalcompassion);
                    imgAchievements_CompassionBadge.setImageResource(R.drawable.badgecompassion);
                }
                if (achievement_compassion.equals("Compassion Master")){
                    imgAchievements_CompassionTrophy.setImageResource(R.drawable.trophycompassion);
                    imgAchievements_CompassionMedal.setImageResource(R.drawable.medalcompassion);
                    imgAchievements_CompassionBadge.setImageResource(R.drawable.badgecompassion);
                }
                if (lesson_compassion.equals("Completed")){
                    imgAchievements_CompassionCertificate.setImageResource(R.drawable.certificatecompassion);
                }
                return null;
            }
        });


        //GMRC 7-9
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Responsibility
                achievement_responsibility = documentSnapshot.getString("responsibility achievement");
                lesson_responsibility = documentSnapshot.getString("responsibility lesson");

                if (achievement_responsibility.equals("Responsibility Beginner")){
                    imgAchievements_ResponsibilityBadge.setImageResource(R.drawable.badgeresponsibility);
                }
                if (achievement_responsibility.equals("Responsibility Expert")){
                    imgAchievements_ResponsibilityMedal.setImageResource(R.drawable.medalresponsibility);
                    imgAchievements_ResponsibilityBadge.setImageResource(R.drawable.badgeresponsibility);
                }
                if (achievement_responsibility.equals("Responsibility Master")){
                    imgAchievements_ResponsibilityTrophy.setImageResource(R.drawable.trophyresponsibility);
                    imgAchievements_ResponsibilityMedal.setImageResource(R.drawable.medalresponsibility);
                    imgAchievements_ResponsibilityBadge.setImageResource(R.drawable.badgeresponsibility);
                }
                if (lesson_responsibility.equals("Completed")){
                    imgAchievements_ResponsibilityCertificate.setImageResource(R.drawable.certificateresponsibility);
                }
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Love
                achievement_love = documentSnapshot.getString("love achievement");
                lesson_love = documentSnapshot.getString("love lesson");

                if (achievement_love.equals("Love Beginner")){
                    imgAchievements_LoveBadge.setImageResource(R.drawable.badgelove);
                }
                if (achievement_love.equals("Love Expert")){
                    imgAchievements_LoveMedal.setImageResource(R.drawable.medallove);
                    imgAchievements_LoveBadge.setImageResource(R.drawable.badgelove);
                }
                if (achievement_love.equals("Love Master")){
                    imgAchievements_LoveTrophy.setImageResource(R.drawable.trophylove);
                    imgAchievements_LoveMedal.setImageResource(R.drawable.medallove);
                    imgAchievements_LoveBadge.setImageResource(R.drawable.badgelove);
                }
                if (lesson_love.equals("Completed")){
                    imgAchievements_LoveCertificate.setImageResource(R.drawable.certificatelove);
                }
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Obedience
                achievement_obedience = documentSnapshot.getString("obedience achievement");
                lesson_obedience = documentSnapshot.getString("obedience lesson");

                if (achievement_obedience.equals("Obedience Beginner")){
                    imgAchievements_ObedienceBadge.setImageResource(R.drawable.badgeobedience);
                }
                if (achievement_obedience.equals("Obedience Expert")){
                    imgAchievements_ObedienceMedal.setImageResource(R.drawable.medalobedience);
                    imgAchievements_ObedienceBadge.setImageResource(R.drawable.badgeobedience);
                }
                if (achievement_obedience.equals("Obedience Master")){
                    imgAchievements_ObedienceTrophy.setImageResource(R.drawable.trophyobedience);
                    imgAchievements_ObedienceMedal.setImageResource(R.drawable.medalobedience);
                    imgAchievements_ObedienceBadge.setImageResource(R.drawable.certificateobedience);
                }
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Doing Good
                achievement_doinggood = documentSnapshot.getString("doing good achievement");
                lesson_doinggood = documentSnapshot.getString("doing good lesson");

                if (achievement_doinggood.equals("Doing Good Beginner")){
                    imgAchievements_DoingGoodBadge.setImageResource(R.drawable.badgedoinggood);
                }
                if (achievement_doinggood.equals("Doing Good Expert")){
                    imgAchievements_DoingGoodMedal.setImageResource(R.drawable.medaldoinggood);
                    imgAchievements_DoingGoodBadge.setImageResource(R.drawable.badgedoinggood);
                }
                if (achievement_doinggood.equals("Doing Good Master")){
                    imgAchievements_DoingGoodTrophy.setImageResource(R.drawable.trophydoinggood);
                    imgAchievements_DoingGoodMedal.setImageResource(R.drawable.medaldoinggood);
                    imgAchievements_DoingGoodBadge.setImageResource(R.drawable.badgedoinggood);
                }
                if (lesson_doinggood.equals("Completed")){
                    imgAchievements_DoingGoodCertificate.setImageResource(R.drawable.certificatedoinggood);
                }
                return null;
            }
        });

        backbtnAchievements3to6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(Achievements3to6Main.this, Homepage3to6.class);
                startActivity(proceed);
            }
        });

    }
}
