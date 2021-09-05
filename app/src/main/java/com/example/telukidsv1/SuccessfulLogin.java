package com.example.telukidsv1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class SuccessfulLogin extends AppCompatActivity {

    ImageView profIconSSL;
    String userID, usericon;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_login);

        profIconSSL = findViewById(R.id.iconSSL);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                usericon = documentSnapshot.getString("uicon");

                if(usericon.equalsIgnoreCase("tiger")){
                    profIconSSL.setImageResource(R.drawable.slitiger);

                }
                else if(usericon.equalsIgnoreCase("owl")){
                    profIconSSL.setImageResource(R.drawable.sliowl);
                }
                else if(usericon.equalsIgnoreCase("lion")){
                    profIconSSL.setImageResource(R.drawable.slilion);
                }
                else if(usericon.equalsIgnoreCase("butterfly")){
                    profIconSSL.setImageResource(R.drawable.slibutterfly);
                }
                else if(usericon.equalsIgnoreCase("fox")){
                    profIconSSL.setImageResource(R.drawable.slifox);
                }
                else if(usericon.equalsIgnoreCase("bee")){
                    profIconSSL.setImageResource(R.drawable.slibee);
                }
                else if(usericon.equalsIgnoreCase("cat")){
                    profIconSSL.setImageResource(R.drawable.slicat);
                }
                else if(usericon.equalsIgnoreCase("chicken")){
                    profIconSSL.setImageResource(R.drawable.slichicken);
                }

                profIconSSL.setVisibility(View.VISIBLE);

            }
        });

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SuccessfulLogin.this,CategorySelection.class));
                finish();
            }
        },3000);
    }
}