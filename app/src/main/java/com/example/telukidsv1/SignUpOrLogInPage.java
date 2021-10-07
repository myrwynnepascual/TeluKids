package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpOrLogInPage extends AppCompatActivity {
    ImageButton signupbtnSOL,loginbtnSOL;
    FirebaseAuth fAuth;

    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_or_log_in_page);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        signupbtnSOL = findViewById(R.id.signupbtnSOL);
        loginbtnSOL = findViewById(R.id.loginbtnSOL);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), AgeCategorySelection.class));
            finish();
        }

        signupbtnSOL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        sfx.release();
                    }
                });

                startActivity(new Intent(SignUpOrLogInPage.this, SignUp.class));

            }
        });

        loginbtnSOL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        sfx.release();
                    }
                });

                startActivity(new Intent(SignUpOrLogInPage.this, Login.class));
            }
        });
    }
}