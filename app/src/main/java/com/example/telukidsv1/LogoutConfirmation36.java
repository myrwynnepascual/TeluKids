package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutConfirmation36 extends AppCompatActivity {

    ImageButton btnconfirmLO, btncancelLO;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_confirmation);


        btnconfirmLO = findViewById(R.id.confirmlogoutbtn);
        btncancelLO = findViewById(R.id.cancellogoutbtn);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        btnconfirmLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(LogoutConfirmation36.this,SignUpOrLogInPage.class));
            }
        });

        btncancelLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                startActivity(new Intent(LogoutConfirmation36.this,UserProfile36.class));
                finish();
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