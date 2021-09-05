package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText emailFP;
    TextView emessageFP;
    ImageButton backbtnFP, changepwFP;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailFP = findViewById(R.id.emailaddressFP);
        emessageFP = findViewById(R.id.errormsgFP);
        backbtnFP = findViewById(R.id.backbtnFP);
        changepwFP = findViewById(R.id.changepwbtnFP);

        fAuth = FirebaseAuth.getInstance();

        backbtnFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPassword.this,login.class));
            }
        });

        changepwFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = emailFP.getText().toString();
                fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Toast.makeText(login.this, "Reset link sent to email.", Toast.LENGTH_SHORT).show();
                        emessageFP.setText("Reset link sent to email.");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Toast.makeText(login.this,"Error: " +e.getMessage(), Toast.LENGTH_SHORT).show();
                        emessageFP.setText(e.getMessage());
                    }
                });
            }
        });


    }
}