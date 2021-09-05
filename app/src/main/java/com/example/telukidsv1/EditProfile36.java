package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

import java.util.HashMap;
import java.util.Map;

public class EditProfile36 extends AppCompatActivity {
    ImageButton btnBackEP36,btnSaveEP36,icon1EP36,icon2EP36,icon3EP36,icon4EP36,icon5EP36,icon6EP36,icon7EP36,icon8EP36;
    EditText nUsername,oPassword,nPassword,nCPassword;
    TextView changesStatus;
    String userIcon;
    Boolean userIconSelected = false;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile36);

        btnBackEP36 = findViewById(R.id.backbtnEP36);
        btnSaveEP36 = findViewById(R.id.savebtnEP36);

        nUsername = findViewById(R.id.nusernameEP36);
        oPassword = findViewById(R.id.oldpasswordEP36);
        nPassword = findViewById(R.id.npasswordEP36);
        nCPassword = findViewById(R.id.ncpasswordEP36);

        changesStatus = findViewById(R.id.settingsstatusEP36);

        icon1EP36 = findViewById(R.id.icon1EP36);
        icon2EP36 = findViewById(R.id.icon2EP36);
        icon3EP36 = findViewById(R.id.icon3EP36);
        icon4EP36 = findViewById(R.id.icon4EP36);
        icon5EP36 = findViewById(R.id.icon5EP36);
        icon6EP36 = findViewById(R.id.icon6EP36);
        icon7EP36 = findViewById(R.id.icon7EP36);
        icon8EP36 = findViewById(R.id.icon8EP36);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();

        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        btnBackEP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditProfile36.this,UserProfile36.class));
            }
        });


        icon1EP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon1EP36.setImageResource(R.drawable.tigerselected);
                icon2EP36.setImageResource(R.drawable.owlselect);
                icon3EP36.setImageResource(R.drawable.lionselect);
                icon4EP36.setImageResource(R.drawable.butterflyselect);
                icon5EP36.setImageResource(R.drawable.foxselect);
                icon6EP36.setImageResource(R.drawable.beeselect);
                icon7EP36.setImageResource(R.drawable.catselect);
                icon8EP36.setImageResource(R.drawable.chickenselect);

                userIcon = "tiger";
                userIconSelected = true;
            }
        });

        icon2EP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon1EP36.setImageResource(R.drawable.tigerselect);
                icon2EP36.setImageResource(R.drawable.owlselected);
                icon3EP36.setImageResource(R.drawable.lionselect);
                icon4EP36.setImageResource(R.drawable.butterflyselect);
                icon5EP36.setImageResource(R.drawable.foxselect);
                icon6EP36.setImageResource(R.drawable.beeselect);
                icon7EP36.setImageResource(R.drawable.catselect);
                icon8EP36.setImageResource(R.drawable.chickenselect);

                userIcon = "owl";
                userIconSelected = true;
            }
        });

        icon3EP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon1EP36.setImageResource(R.drawable.tigerselect);
                icon2EP36.setImageResource(R.drawable.owlselect);
                icon3EP36.setImageResource(R.drawable.lionselected);
                icon4EP36.setImageResource(R.drawable.butterflyselect);
                icon5EP36.setImageResource(R.drawable.foxselect);
                icon6EP36.setImageResource(R.drawable.beeselect);
                icon7EP36.setImageResource(R.drawable.catselect);
                icon8EP36.setImageResource(R.drawable.chickenselect);

                userIcon = "lion";
                userIconSelected = true;
            }
        });

        icon4EP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon1EP36.setImageResource(R.drawable.tigerselect);
                icon2EP36.setImageResource(R.drawable.owlselect);
                icon3EP36.setImageResource(R.drawable.lionselect);
                icon4EP36.setImageResource(R.drawable.butterflyselected);
                icon5EP36.setImageResource(R.drawable.foxselect);
                icon6EP36.setImageResource(R.drawable.beeselect);
                icon7EP36.setImageResource(R.drawable.catselect);
                icon8EP36.setImageResource(R.drawable.chickenselect);

                userIcon = "butterfly";
                userIconSelected = true;
            }
        });

        icon5EP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon1EP36.setImageResource(R.drawable.tigerselect);
                icon2EP36.setImageResource(R.drawable.owlselect);
                icon3EP36.setImageResource(R.drawable.lionselect);
                icon4EP36.setImageResource(R.drawable.butterflyselect);
                icon5EP36.setImageResource(R.drawable.foxselected);
                icon6EP36.setImageResource(R.drawable.beeselect);
                icon7EP36.setImageResource(R.drawable.catselect);
                icon8EP36.setImageResource(R.drawable.chickenselect);

                userIcon = "fox";
                userIconSelected = true;
            }
        });

        icon6EP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon1EP36.setImageResource(R.drawable.tigerselect);
                icon2EP36.setImageResource(R.drawable.owlselect);
                icon3EP36.setImageResource(R.drawable.lionselect);
                icon4EP36.setImageResource(R.drawable.butterflyselect);
                icon5EP36.setImageResource(R.drawable.foxselect);
                icon6EP36.setImageResource(R.drawable.beeselected);
                icon7EP36.setImageResource(R.drawable.catselect);
                icon8EP36.setImageResource(R.drawable.chickenselect);

                userIcon = "bee";
                userIconSelected = true;
            }
        });

        icon7EP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon1EP36.setImageResource(R.drawable.tigerselect);
                icon2EP36.setImageResource(R.drawable.owlselect);
                icon3EP36.setImageResource(R.drawable.lionselect);
                icon4EP36.setImageResource(R.drawable.butterflyselect);
                icon5EP36.setImageResource(R.drawable.foxselect);
                icon6EP36.setImageResource(R.drawable.beeselect);
                icon7EP36.setImageResource(R.drawable.catselected);
                icon8EP36.setImageResource(R.drawable.chickenselect);

                userIcon = "cat";
                userIconSelected = true;
            }
        });

        icon8EP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon1EP36.setImageResource(R.drawable.tigerselect);
                icon2EP36.setImageResource(R.drawable.owlselect);
                icon3EP36.setImageResource(R.drawable.lionselect);
                icon4EP36.setImageResource(R.drawable.butterflyselect);
                icon5EP36.setImageResource(R.drawable.foxselect);
                icon6EP36.setImageResource(R.drawable.beeselect);
                icon7EP36.setImageResource(R.drawable.catselect);
                icon8EP36.setImageResource(R.drawable.chickenselected);

                userIcon = "chicken";
                userIconSelected = true;
            }
        });

        btnSaveEP36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //USERNAME
                if (!nUsername.getText().toString().isEmpty()){
                    String newUsername = nUsername.getText().toString();

                    fStore.runTransaction(new Transaction.Function<Void>() {
                        @Override
                        public Void apply(Transaction transaction) throws FirebaseFirestoreException {

                            DocumentSnapshot snapshot = transaction.get(docRef);

                            transaction.update(docRef, "username", newUsername);
                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                            changesStatus.setText("Username Updated.");
                            nUsername.getText().clear();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            changesStatus.setText("Username Update Failed.");
                            nUsername.getText().clear();

                        }
                    });

                }

                //PASSWORD
                if((!oPassword.getText().toString().isEmpty()) && (nPassword.getText().toString().isEmpty())){
                    nPassword.setError("Enter new Password");
                }

                if ((!nPassword.getText().toString().isEmpty()) && (nPassword.length() < 8)){
                    nPassword.setError("Password must be at least 8 characters.");
                }

                if ((!nPassword.getText().toString().isEmpty()) && (nCPassword.getText().toString().isEmpty())){
                    nCPassword.setError("Confirm Password is Required");
                }

                if ((!nPassword.getText().toString().isEmpty()) && (!nCPassword.getText().toString().isEmpty())){
                    if(!nPassword.getText().toString().trim().equals(nCPassword.getText().toString().trim())){
                        nPassword.setError("Passwords do not match.");
                        nCPassword.setError("Passwords do not match.");
                        return;
                    }
                    else{
                        String newPassword = nCPassword.getText().toString().trim();
                        String oldPassword = oPassword.getText().toString().trim();

                        //re-authentication
                        AuthCredential authCredential = EmailAuthProvider.getCredential(user.getEmail(),oldPassword);
                        user.reauthenticate(authCredential).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                user.updatePassword(newPassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {

                                        changesStatus.setText("Password Updated.");

                                        oPassword.getText().clear();
                                        nPassword.getText().clear();
                                        nCPassword.getText().clear();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        changesStatus.setText(e.getMessage());

                                    }
                                });
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                changesStatus.setText(e.getMessage());
                            }
                        });
                    }
                }

                //USER ICON
                if(userIconSelected.equals(true)){
                    fStore.runTransaction(new Transaction.Function<Void>() {
                        @Override
                        public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(docRef);

                            transaction.update(docRef, "uicon", userIcon);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                            changesStatus.setText("Icon Updated.");
                            userIconSelected = false;
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            changesStatus.setText("Icon Update Failed.");

                        }
                    });
                }

                //RESET EVERYTHING
                icon1EP36.setImageResource(R.drawable.tigerselect);
                icon2EP36.setImageResource(R.drawable.owlselect);
                icon3EP36.setImageResource(R.drawable.lionselect);
                icon4EP36.setImageResource(R.drawable.butterflyselect);
                icon5EP36.setImageResource(R.drawable.foxselect);
                icon6EP36.setImageResource(R.drawable.beeselect);
                icon7EP36.setImageResource(R.drawable.catselect);
                icon8EP36.setImageResource(R.drawable.chickenselect);
            }
        });
    }
}