package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class SuccessfulSignUp extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_sign_up);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SuccessfulSignUp.this, AgeCategorySelection.class));
                finish();
            }
        },3000);


        fStore.runTransaction(new Transaction.Function<Void>() {
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                transaction.update(docRef, "addition quiz score", 0);
                transaction.update(docRef, "colors quiz score", 0);
                transaction.update(docRef, "compassion quiz score", 0);
                transaction.update(docRef, "counting quiz score", 0);
                transaction.update(docRef, "discipline quiz score", 0);
                transaction.update(docRef, "doing good quiz score", 0);
                transaction.update(docRef, "honesty quiz score", 0);
                transaction.update(docRef, "love quiz score", 0);
                transaction.update(docRef, "obedience quiz score", 0);
                transaction.update(docRef, "respect quiz score", 0);
                transaction.update(docRef, "responsibility quiz score", 0);
                transaction.update(docRef, "shapes quiz score", 0);
                transaction.update(docRef, "sociability quiz score", 0);
                transaction.update(docRef, "subtraction quiz score", 0);
                return null;
            }
        });
    }
}