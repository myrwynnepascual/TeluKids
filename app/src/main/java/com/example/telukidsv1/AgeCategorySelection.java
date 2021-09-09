package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class AgeCategorySelection extends AppCompatActivity {

    ImageButton btnAge3to6,btnAge7to9;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_category_selection);


        btnAge3to6 = findViewById(R.id.categoryage3to6CS);
        btnAge7to9 = findViewById(R.id.categoryage7to9CS);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(docRef);

                transaction.update(docRef, "last page", "age category selection");
                return null;
            }
        });

        btnAge3to6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AgeCategorySelection.this, Homepage3to6.class));
            }
        });

       btnAge7to9.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(AgeCategorySelection.this, Homepage7to9.class));
           }
       });

    }
}