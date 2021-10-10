package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutConfirmation79 extends AppCompatActivity {

    ImageButton btnconfirmLO, btncancelLO;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_confirmation79);


        btnconfirmLO = findViewById(R.id.confirmlogoutbtn79);
        btncancelLO = findViewById(R.id.cancellogoutbtn79);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        btnconfirmLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(LogoutConfirmation79.this,SignUpOrLogInPage.class));
            }
        });

        btncancelLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LogoutConfirmation79.this,UserProfile79.class));
                finish();
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