package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutConfirmation36 extends AppCompatActivity {

    ImageButton btnconfirmLO, btncancelLO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_confirmation36);


        btnconfirmLO = findViewById(R.id.confirmlogoutbtn36);
        btncancelLO = findViewById(R.id.cancellogoutbtn36);

        btnconfirmLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(LogoutConfirmation36.this,SignUpOrLogInPage.class));
            }
        });

        btncancelLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LogoutConfirmation36.this,UserProfile36.class));
                finish();
            }
        });
    }
}