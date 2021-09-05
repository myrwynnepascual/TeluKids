package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        backbtnSU.setOnClickListener(v -> startActivity(new Intent(SignUp.this,SignUpOrLogInPage.class)));

        signupbtnSU.setOnClickListener(v -> {
            String fname = fnameSU.getText().toString();
            String lname = lnameSU.getText().toString();
            String email = emailSU.getText().toString().trim();
            String username = usernameSU.getText().toString();
            String password = passwordSU.getText().toString().trim();
            String password2 = confirmpwSU.getText().toString().trim();
            uicon = "tiger";

            if(TextUtils.isEmpty(fname)){
                fnameSU.setError("First Name is Required.");
                return;
            }

            if(TextUtils.isEmpty(lname)){
                lnameSU.setError("Last Name is Required.");
                return;
            }

            if(TextUtils.isEmpty(email)){
                emailSU.setError("Email is Required.");
                return;
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailSU.setError("Enter a valid email address.");
                return;
            }

            if(TextUtils.isEmpty(username)){
                usernameSU.setError("Username is Required.");
                return;
            }

            if(TextUtils.isEmpty(password)){
                passwordSU.setError("Password is Required.");
                return;
            }

            if(password.length() < 8){
                passwordSU.setError("Password must be at least 8 characters.");
                return;
            }

            if(TextUtils.isEmpty(password2)){
                confirmpwSU.setError("Confirm Password is Required.");
                return;
            }

            if(!password.equals(password2)){
                passwordSU.setError("Passwords do not match.");
                confirmpwSU.setError("Passwords do not match.");
                return;
            }

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

                    documentReference.set(user).addOnSuccessListener(aVoid -> Log.d("TAG","onSuccess: user profile is created for " +userID));

                    startActivity(new Intent(getApplicationContext(),SuccessfulSignUp.class));
                }

                else {
                    emessageSU.setText(task.getException().getMessage());
                }
            });
        });
    }
}