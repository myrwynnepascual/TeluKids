package com.example.telukidsv1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Homepage3to6 extends AppCompatActivity {

    ImageButton btnbackH36, btnUserProf36, btnBConcepts, btnGMRC36Topics, btnAchievements;
    String userID, usericon;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage3to6);


        btnbackH36 = findViewById(R.id.backbtnH36);
        btnUserProf36 = findViewById(R.id.userprofilebtn);
        btnBConcepts = findViewById(R.id.basicconceptsH36);
        btnGMRC36Topics = findViewById(R.id.gmrcH36);
        btnAchievements = findViewById(R.id.achivementsH36);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                usericon = documentSnapshot.getString("uicon");

                if(usericon.equalsIgnoreCase("tiger")){
                    btnUserProf36.setImageResource(R.drawable.tigersettings);
                }
                else if(usericon.equalsIgnoreCase("owl")){
                    btnUserProf36.setImageResource(R.drawable.owlsettings);
                }
                else if(usericon.equalsIgnoreCase("lion")){
                    btnUserProf36.setImageResource(R.drawable.lionsettings);
                }
                else if(usericon.equalsIgnoreCase("butterfly")){
                    btnUserProf36.setImageResource(R.drawable.butterflysettings);
                }
                else if(usericon.equalsIgnoreCase("fox")){
                    btnUserProf36.setImageResource(R.drawable.foxsettings);
                }
                else if(usericon.equalsIgnoreCase("bee")){
                    btnUserProf36.setImageResource(R.drawable.beesettings);
                }
                else if(usericon.equalsIgnoreCase("cat")){
                    btnUserProf36.setImageResource(R.drawable.catsettings);
                }
                else if(usericon.equalsIgnoreCase("chicken")){
                    btnUserProf36.setImageResource(R.drawable.chickensettings);
                }

                btnUserProf36.setVisibility(View.VISIBLE);

            }
        });

        btnbackH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage3to6.this, CategorySelection.class));
            }
        });

        btnUserProf36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage3to6.this, UserProfile36.class));
            }
        });

        btnBConcepts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage3to6.this, BasicConcepts.class));
            }
        });

        btnGMRC36Topics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Homepage3to6.this, GMRC36Page.class));
            }
        });

        btnAchievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage3to6.this, Achievements3to6.class));
            }
        });

    }
}