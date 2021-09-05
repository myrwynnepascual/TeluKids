package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText emailLI,passwordLI;
    TextView emessageLI;
    ImageButton backbtnLI,forgotpwLI,loginbtnLI;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLI = findViewById(R.id.emailaddressLI);
        passwordLI = findViewById(R.id.passwordLI);
        emessageLI = findViewById(R.id.errormsgLI);

        fAuth = FirebaseAuth.getInstance();

        backbtnLI = findViewById(R.id.backbtnLI);
        forgotpwLI = findViewById(R.id.forgotpwLI);
        loginbtnLI = findViewById(R.id.loginbtnLI);

        backbtnLI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,SignUpOrLogInPage.class));
            }
        });

        forgotpwLI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(login.this,ForgotPassword.class));
            }
        });


        loginbtnLI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailLI.getText().toString().trim();
                String password = passwordLI.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    emailLI.setError("Email is Required.");
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    emailLI.setError("Enter a valid email address.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    passwordLI.setError("Password is Required.");
                    return;
                }

                if(password.length() < 8){
                    passwordLI.setError("Password must be at least 8 characters.");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),SuccessfulLogin.class));
                        }
                        else{
                            emessageLI.setText(task.getException().getMessage());
                        }
                    }
                });


            }
        });
    }
}