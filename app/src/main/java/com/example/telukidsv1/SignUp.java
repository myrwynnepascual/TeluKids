package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    EditText fnameSU,lnameSU,emailSU,usernameSU,passwordSU,confirmpwSU;
    TextView emessageSU;
    ImageButton backbtnSU,signupbtnSU;
    String userID,uicon;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    MediaPlayer sfx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fnameSU = findViewById(R.id.firstnameSU);
        lnameSU = findViewById(R.id.lastnameSU);
        emailSU = findViewById(R.id.emailaddressSU);
        usernameSU = findViewById(R.id.usernameSU);
        passwordSU = findViewById(R.id.passwordSU);
        confirmpwSU = findViewById(R.id.confirmpasswordSU);
        emessageSU = findViewById(R.id.errormsgSU);
        backbtnSU = findViewById(R.id.backbtnSU);
        signupbtnSU = findViewById(R.id.signupbtnSU);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        backbtnSU.setOnClickListener(v ->  {sfx.start();
        startActivity(new Intent(SignUp.this,SignUpOrLogInPage.class));});

        signupbtnSU.setOnClickListener(v -> {
            sfx.start();

            String fname = fnameSU.getText().toString();
            String lname = lnameSU.getText().toString();
            String email = emailSU.getText().toString().trim();
            String username = usernameSU.getText().toString();
            String password = passwordSU.getText().toString().trim();
            String password2 = confirmpwSU.getText().toString().trim();
            uicon = "tiger";

            if(TextUtils.isEmpty(fname)){
                fnameSU.setError("First Name is Required.");
            }

            if(TextUtils.isEmpty(lname)){
                lnameSU.setError("Last Name is Required.");
            }

            if(TextUtils.isEmpty(email)){
                emailSU.setError("Email is Required.");
            }
            else{
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    emailSU.setError("Enter a valid email address.");
                }
            }

            if(TextUtils.isEmpty(username)){
                usernameSU.setError("Username is Required.");
            }

            if(TextUtils.isEmpty(password)){
                passwordSU.setError("Password is Required.");
            }

            if(password.length() < 8){
                passwordSU.setError("Password must be at least 8 characters.");
            }

            if(TextUtils.isEmpty(password2)){
                confirmpwSU.setError("Confirm Password is Required.");
            }

            if(!password.equals(password2)){
                passwordSU.setError("Passwords do not match.");
                confirmpwSU.setError("Passwords do not match.");
            }

            if((!TextUtils.isEmpty(fname)) && (!TextUtils.isEmpty(lname)) && (!TextUtils.isEmpty(email) && (!TextUtils.isEmpty(username)) && (!TextUtils.isEmpty(password)) && (!TextUtils.isEmpty(password2)))){
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                    if(task.isSuccessful()){

                        //store user profile data in firebase firestore
                        userID = fAuth.getCurrentUser().getUid(); // get current user
                        DocumentReference documentReference = fStore.collection("users").document(userID);

                        Map<String,Object> user = new HashMap<>();
                        user.put("fname",fname);
                        user.put("lname",lname);
                        user.put("email",email);
                        user.put("username",username);
                        user.put("uicon",uicon);
                        user.put("addition quiz score",0);
                        user.put("colors quiz score",0);
                        user.put("compassion quiz score",0);
                        user.put("counting quiz score",0);
                        user.put("discipline quiz score",0);
                        user.put("doing good quiz score",0);
                        user.put("honesty quiz score",0);
                        user.put("love quiz score",0);
                        user.put("obedience quiz score",0);
                        user.put("respect quiz score",0);
                        user.put("responsibility quiz score",0);
                        user.put("shapes quiz score",0);
                        user.put("sociability quiz score",0);
                        user.put("subtraction quiz score",0);

                        documentReference.set(user).addOnSuccessListener(aVoid -> Log.d("TAG","onSuccess: user profile is created for " +userID));

                        startActivity(new Intent(getApplicationContext(),SuccessfulSignUp.class));
                    }

                    else {
                        emessageSU.setText(task.getException().getMessage());
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                emessageSU.setText("");
                            }
                        },3000);;
                    }
                });
            }
        });

    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(SignUp.this,SignUpOrLogInPage.class));
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