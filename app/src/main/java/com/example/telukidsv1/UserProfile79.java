package com.example.telukidsv1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class UserProfile79 extends AppCompatActivity {

    ImageButton btnbackUP, btneditUP, btnlogoutUP,btnsurveyUP, btnhelpUP;
    ImageView profIconUP;
    TextView greetUP;
    String userID, username, usericon;
    MediaPlayer sfx;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile79);

        profIconUP = findViewById(R.id.usericonUP79);
        greetUP = findViewById(R.id.greetingsUP79);
        btnbackUP = findViewById(R.id.backbtnUP79);
        btneditUP = findViewById(R.id.editprofilebtnUP79);
        btnlogoutUP = findViewById(R.id.logoutbtnUP79);
        btnsurveyUP = findViewById(R.id.surveybtnUP79);
        btnhelpUP = findViewById(R.id.helpbtnUP79);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        //EXTRACTING DATA FROM FIRESTORE
        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                usericon = documentSnapshot.getString("uicon");
                username = documentSnapshot.getString("username");

                if(usericon.equalsIgnoreCase("tiger")){
                    profIconUP.setImageResource(R.drawable.tigerprof);
                }
                else if(usericon.equalsIgnoreCase("owl")){
                    profIconUP.setImageResource(R.drawable.owlprof);
                }
                else if(usericon.equalsIgnoreCase("lion")){
                    profIconUP.setImageResource(R.drawable.lionprof);
                }
                else if(usericon.equalsIgnoreCase("butterfly")){
                    profIconUP.setImageResource(R.drawable.butterflyprof);
                }
                else if(usericon.equalsIgnoreCase("fox")){
                    profIconUP.setImageResource(R.drawable.foxprof);
                }
                else if(usericon.equalsIgnoreCase("bee")){
                    profIconUP.setImageResource(R.drawable.beeprof);
                }
                else if(usericon.equalsIgnoreCase("cat")){
                    profIconUP.setImageResource(R.drawable.catprof);
                }
                else if(usericon.equalsIgnoreCase("chicken")){
                    profIconUP.setImageResource(R.drawable.chickenprof);
                }

                profIconUP.setVisibility(View.VISIBLE);
                greetUP.setText("Hi, " +username + "!");

            }
        });


        btnbackUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(UserProfile79.this,Homepage7to9.class));
            }
        });

        btnhelpUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(UserProfile79.this, HelpPage79.class));
            }
        });

        btnsurveyUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://forms.gle/vHNoGH3f3oNce6FXA")));

            }
        });

        btneditUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(UserProfile79.this, EditProfile79.class));
            }
        });

        btnlogoutUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(UserProfile79.this, LogoutConfirmation36.class));

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });
    }
}