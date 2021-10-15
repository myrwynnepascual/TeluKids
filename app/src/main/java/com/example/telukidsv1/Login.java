package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText emailLI,passwordLI;
    TextView emessageLI;
    ImageButton backbtnLI,forgotpwLI,loginbtnLI;
    FirebaseAuth fAuth;
    MediaPlayer sfx;

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

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        backbtnLI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(Login.this,SignUpOrLogInPage.class));
            }
        });

        forgotpwLI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(Login.this,ForgotPassword.class));
            }
        });


        loginbtnLI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                String email = emailLI.getText().toString().trim();
                String password = passwordLI.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    emailLI.setError("Email is Required.");
                }
                else{
                    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        emailLI.setError("Enter a valid email address.");
                    }
                }

                if(TextUtils.isEmpty(password)){
                    passwordLI.setError("Password is Required.");
                }
                else if(password.length() < 8){
                    passwordLI.setError("Password must be at least 8 characters.");
                }

                if((!TextUtils.isEmpty(email)) && (!TextUtils.isEmpty(password))){
                    fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(getApplicationContext(),SuccessfulLogin.class));
                            }
                            else{
                                emessageLI.setText(task.getException().getMessage());
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        emessageLI.setText("");
                                    }
                                },3000);;
                            }
                        }
                    });
                }
            }
        });

    }

    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onUserLeaveHint(){
        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

        super.onUserLeaveHint();
    }
}