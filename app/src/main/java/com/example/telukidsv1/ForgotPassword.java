package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
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
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailFP = findViewById(R.id.emailaddressFP);
        emessageFP = findViewById(R.id.errormsgFP);
        backbtnFP = findViewById(R.id.backbtnFP);
        changepwFP = findViewById(R.id.changepwbtnFP);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        fAuth = FirebaseAuth.getInstance();

        backbtnFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                startActivity(new Intent(ForgotPassword.this, Login.class));
            }
        });

        changepwFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                String email = emailFP.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    emailFP.setError("Enter a valid email address.");
                }

                else{
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