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

public class Homepage7to9 extends AppCompatActivity {

    ImageButton btnbackH79,btnUserProf79, btnGMRC79Topics, btnAchievements;
    String userID, usericon;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage7to9);

        btnbackH79 = findViewById(R.id.backbtnH79);
        btnUserProf79 = findViewById(R.id.userprofilebtn79);
        btnGMRC79Topics = findViewById(R.id.gmrcH79);
        btnAchievements = findViewById(R.id.achivementsH79);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();


        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                usericon = documentSnapshot.getString("uicon");

                if(usericon.equalsIgnoreCase("tiger")){
                    btnUserProf79.setImageResource(R.drawable.tigersettings);
                }
                else if(usericon.equalsIgnoreCase("owl")){
                    btnUserProf79.setImageResource(R.drawable.owlsettings);
                }
                else if(usericon.equalsIgnoreCase("lion")){
                    btnUserProf79.setImageResource(R.drawable.lionsettings);
                }
                else if(usericon.equalsIgnoreCase("butterfly")){
                    btnUserProf79.setImageResource(R.drawable.butterflysettings);
                }
                else if(usericon.equalsIgnoreCase("fox")){
                    btnUserProf79.setImageResource(R.drawable.foxsettings);
                }
                else if(usericon.equalsIgnoreCase("bee")){
                    btnUserProf79.setImageResource(R.drawable.beesettings);
                }
                else if(usericon.equalsIgnoreCase("cat")){
                    btnUserProf79.setImageResource(R.drawable.catsettings);
                }
                else if(usericon.equalsIgnoreCase("chicken")){
                    btnUserProf79.setImageResource(R.drawable.chickensettings);
                }
            }
        });


        btnbackH79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage7to9.this, CategorySelection.class));
            }
        });

        btnUserProf79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage7to9.this, UserProfile79.class));
            }
        });

        btnGMRC79Topics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Homepage7to9.this, GMRC79Page.class));
            }
        });

        btnAchievements.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
                 //startActivity(new Intent(Homepage7to9.this, Achivements.class));
            }
         });

    }
}