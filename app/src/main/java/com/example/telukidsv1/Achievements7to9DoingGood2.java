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

public class Achievements7to9DoingGood2 extends AppCompatActivity {
    private int score_doinggood;
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
        setContentView(R.layout.activity_achievements7to9_doing_good2);

        ImageButton backbtnAchievements7to9= findViewById(R.id.backbtnAchievements79DoingGood2);

        //Trophies
        //GMRC 3-6
        ImageView imgAchievements_DisciplineTrophy = findViewById(R.id.trophydiscipline79DoingGood2);
        ImageView imgAchievements_HonestyTrophy = findViewById(R.id.trophyhonesty79DoingGood2);
        ImageView imgAchievements_RespectTrophy = findViewById(R.id.trophyrespect79DoingGood2);
        ImageView imgAchievements_SociabilityTrophy = findViewById(R.id.trophysociability79DoingGood2);
        ImageView imgAchievements_CompassionTrophy = findViewById(R.id.trophycompassion79DoingGood2);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityTrophy = findViewById(R.id.trophyresponsibility79DoingGood2);
        ImageView imgAchievements_LoveTrophy = findViewById(R.id.trophylove79DoingGood2);
        ImageView imgAchievements_ObedienceTrophy = findViewById(R.id.trophyobedience79DoingGood2);
        ImageView imgAchievements_DoingGoodTrophy = findViewById(R.id.trophydoinggood79DoingGood2);

        //Basic Concepts
        ImageView imgAchievements_ColorsTrophy = findViewById(R.id.trophycolors79DoingGood2);
        ImageView imgAchievements_CountingTrophy = findViewById(R.id.trophycounting79DoingGood2);
        ImageView imgAchievements_AdditionTrophy = findViewById(R.id.trophyaddition79DoingGood2);
        ImageView imgAchievements_SubtractionTrophy = findViewById(R.id.trophysubtraction79DoingGood2);
        ImageView imgAchievements_ShapesTrophy = findViewById(R.id.trophyshapes79DoingGood2);

        //Medals
        //GMRC 3-6
        ImageView imgAchievements_DisciplineMedal = findViewById(R.id.medaldiscipline79DoingGood2);
        ImageView imgAchievements_HonestyMedal = findViewById(R.id.medalhonesty79DoingGood2);
        ImageView imgAchievements_RespectMedal = findViewById(R.id.medalrespect79DoingGood2);
        ImageView imgAchievements_SociabilityMedal = findViewById(R.id.medalsociability79DoingGood2);
        ImageView imgAchievements_CompassionMedal = findViewById(R.id.medalcompassion79DoingGood2);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityMedal = findViewById(R.id.medalresponsibility79DoingGood2);
        ImageView imgAchievements_LoveMedal = findViewById(R.id.medallove79DoingGood2);
        ImageView imgAchievements_ObedienceMedal = findViewById(R.id.medalobedience79DoingGood2);
        ImageView imgAchievements_DoingGoodMedal = findViewById(R.id.medaldoinggood79DoingGood2);

        //Basic Concepts
        ImageView imgAchievements_ColorsMedal = findViewById(R.id.medalcolors79DoingGood2);
        ImageView imgAchievements_CountingMedal = findViewById(R.id.medalcounting79DoingGood2);
        ImageView imgAchievements_AdditionMedal = findViewById(R.id.medaladdition79DoingGood2);
        ImageView imgAchievements_SubtractionMedal = findViewById(R.id.medalsubtraction79DoingGood2);
        ImageView imgAchievements_ShapesMedal = findViewById(R.id.medalshapes79DoingGood2);


        //Badges
        //GMRC 3-6
        ImageView imgAchievements_DisciplineBadge = findViewById(R.id.badgediscipline79DoingGood2);
        ImageView imgAchievements_HonestyBadge = findViewById(R.id.badgehonesty79DoingGood2);
        ImageView imgAchievements_RespectBadge = findViewById(R.id.badgerespect79DoingGood2);
        ImageView imgAchievements_SociabilityBadge = findViewById(R.id.badgesociability79DoingGood2);
        ImageView imgAchievements_CompassionBadge = findViewById(R.id.badgecompassion79DoingGood2);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityBadge = findViewById(R.id.badgeresponsibility79DoingGood2);
        ImageView imgAchievements_LoveBadge = findViewById(R.id.badgelove79DoingGood2);
        ImageView imgAchievements_ObedienceBadge = findViewById(R.id.badgeobedience79DoingGood2);
        ImageView imgAchievements_DoingGoodBadge = findViewById(R.id.badgedoinggood79DoingGood2);

        //Basic Concepts
        ImageView imgAchievements_ColorsBadge = findViewById(R.id.badgecolors79DoingGood2);
        ImageView imgAchievements_CountingBadge = findViewById(R.id.badgecounting79DoingGood2);
        ImageView imgAchievements_AdditionBadge = findViewById(R.id.badgeaddition79DoingGood2);
        ImageView imgAchievements_SubtractionBadge = findViewById(R.id.badgesubtraction79DoingGood2);
        ImageView imgAchievements_ShapesBadge = findViewById(R.id.badgeshapes79DoingGood2);


        //Certificates
        //GMRC 3-6
        ImageView imgAchievements_DisciplineCertificate = findViewById(R.id.certificatediscipline79DoingGood2);
        ImageView imgAchievements_HonestyCertificate = findViewById(R.id.certificatehonesty79DoingGood2);
        ImageView imgAchievements_RespectCertificate = findViewById(R.id.certificaterespect79DoingGood2);
        ImageView imgAchievements_SociabilityCertificate = findViewById(R.id.certificatesociability79DoingGood2);
        ImageView imgAchievements_CompassionCertificate = findViewById(R.id.certificatecompassion79DoingGood2);

        //GMRC 7-9
        ImageView imgAchievements_ResponsibilityCertificate = findViewById(R.id.certificateresponsibility79DoingGood2);
        ImageView imgAchievements_LoveCertificate = findViewById(R.id.certificatelove79DoingGood2);
        ImageView imgAchievements_ObedienceCertificate = findViewById(R.id.certificateobedience79DoingGood2);
        ImageView imgAchievements_DoingGoodCertificate = findViewById(R.id.certificatedoinggood79DoingGood2);

        //Basic Concepts
        ImageView imgAchievements_ColorsCertificate = findViewById(R.id.certificatecolors79DoingGood2);
        ImageView imgAchievements_CountingCertificate = findViewById(R.id.certificatecounting79DoingGood2);
        ImageView imgAchievements_AdditionCertificate = findViewById(R.id.certificateaddition79DoingGood2);
        ImageView imgAchievements_SubtractionCertificate = findViewById(R.id.certificatesubtraction79DoingGood2);
        ImageView imgAchievements_ShapesCertificate = findViewById(R.id.certificateshapes79DoingGood2);

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

                //Colors Achievement
                achievement_colors = documentSnapshot.getString("colors achievement");

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
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Colors Lesson
                lesson_colors = documentSnapshot.getString("colors lesson");

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

                //Counting Achievement
                achievement_counting = documentSnapshot.getString("counting achievement");

                if (achievement_counting.equals("Counting Beginner")){
                    imgAchievements_CountingBadge.setImageResource(R.drawable.badgecounting);
                }
                if (achievement_counting.equals("Counting Expert")){
                    imgAchievements_CountingMedal.setImageResource(R.drawable.medalcounting);
                    imgAchievements_CountingBadge.setImageResource(R.drawable.badgecounting);
                }
                if (achievement_counting.equals("Counting Master")) {
                    imgAchievements_CountingTrophy.setImageResource(R.drawable.trophycounting);
                    imgAchievements_CountingMedal.setImageResource(R.drawable.medalcounting);
                    imgAchievements_CountingBadge.setImageResource(R.drawable.badgecounting);
                }
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Counting Lesson
                lesson_counting = documentSnapshot.getString("counting lesson");

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

                //Addition Achievement
                achievement_addition = documentSnapshot.getString("addition achievement");

                if (achievement_addition.equals("Addition Beginner")){
                    imgAchievements_AdditionBadge.setImageResource(R.drawable.badgeaddition);
                }
                if (achievement_addition.equals("Addition Expert")){
                    imgAchievements_AdditionMedal.setImageResource(R.drawable.medaladdition);
                    imgAchievements_AdditionBadge.setImageResource(R.drawable.badgeaddition);
                }
                if (achievement_addition.equals("Addition Master")) {
                    imgAchievements_AdditionTrophy.setImageResource(R.drawable.trophyaddition);
                    imgAchievements_AdditionMedal.setImageResource(R.drawable.medaladdition);
                    imgAchievements_AdditionBadge.setImageResource(R.drawable.badgeaddition);
                }
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Addition Lesson
                lesson_addition = documentSnapshot.getString("addition lesson");

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

                //Subtraction Achievement
                achievement_subtraction = documentSnapshot.getString("subtraction achievement");

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
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Subtraction Lesson
                lesson_subtraction = documentSnapshot.getString("subtraction lesson");

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

                //Shapes Achievement
                achievement_shapes = documentSnapshot.getString("shapes achievement");

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
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Shapes Lesson
                lesson_shapes = documentSnapshot.getString("shapes lesson");

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

                //Discipline Achievement
                achievement_discipline = documentSnapshot.getString("discipline achievement");

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
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Discipline Lesson
                lesson_discipline = documentSnapshot.getString("discipline lesson");
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

                //Honesty Achievement
                achievement_honesty = documentSnapshot.getString("honesty achievement");

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
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Honesty Lesson
                lesson_honesty = documentSnapshot.getString("honesty lesson");

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

                //Respect Achievement
                achievement_respect = documentSnapshot.getString("respect achievement");

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

                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Respect Lesson
                lesson_respect = documentSnapshot.getString("respect lesson");

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

                //Sociability Achievement
                achievement_sociability = documentSnapshot.getString("sociability achievement");

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
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Sociability Lesson
                lesson_sociability = documentSnapshot.getString("sociability lesson");

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

                //Compassion Achievement
                achievement_compassion = documentSnapshot.getString("compassion achievement");

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
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Compassion Lesson
                lesson_compassion = documentSnapshot.getString("compassion lesson");

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

                //Responsibility Achievement
                achievement_responsibility = documentSnapshot.getString("responsibility achievement");

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
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Responsibility Lesson
                lesson_responsibility = documentSnapshot.getString("responsibility lesson");

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

                //Love Achievement
                achievement_love = documentSnapshot.getString("love achievement");

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
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Love Lesson
                lesson_love = documentSnapshot.getString("love lesson");

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

                //Obedience Achievement
                achievement_obedience = documentSnapshot.getString("obedience achievement");

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
                    imgAchievements_ObedienceBadge.setImageResource(R.drawable.badgeobedience);
                }
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Obedience Lesson
                lesson_obedience = documentSnapshot.getString("obedience lesson");

                if (lesson_obedience.equals("Completed")){
                    imgAchievements_ObedienceCertificate.setImageResource(R.drawable.certificateobedience);
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
                return null;
            }
        });
        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot documentSnapshot = transaction.get(docRef);

                //Doing Good Lesson
                lesson_doinggood = documentSnapshot.getString("doing good lesson");

                if (lesson_doinggood.equals("Completed")){
                    imgAchievements_DoingGoodCertificate.setImageResource(R.drawable.certificatedoinggood);
                }
                return null;
            }
        });

        score_doinggood = getIntent().getIntExtra("RIGHT_ANSWER_COUNT_DoingGood", 0);
        backbtnAchievements7to9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(Achievements7to9DoingGood2.this, ResultsDoingGood.class);
                proceed.putExtra("RIGHT_ANSWER_COUNT_DoingGood", score_doinggood);
                startActivity(proceed);
            }
        });

    }
}