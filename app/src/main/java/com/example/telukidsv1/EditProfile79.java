package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class EditProfile79 extends AppCompatActivity {

    ImageButton btnBackEP79,btnSaveEP79,icon1EP79,icon2EP79,icon3EP79,icon4EP79,icon5EP79,icon6EP79,icon7EP79,icon8EP79;
    EditText nUsername,oPassword,nPassword,nCPassword;
    TextView changesStatus;
    String userIcon;
    Boolean userIconSelected = false;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        btnBackEP79 = findViewById(R.id.backbtnEP);
        btnSaveEP79 = findViewById(R.id.savebtnEP);

        nUsername = findViewById(R.id.nusernameEP);
        oPassword = findViewById(R.id.oldpasswordEP);
        nPassword = findViewById(R.id.npasswordEP);
        nCPassword = findViewById(R.id.ncpasswordEP);

        changesStatus = findViewById(R.id.settingsstatusEP);

        icon1EP79 = findViewById(R.id.icon1EP);
        icon2EP79 = findViewById(R.id.icon2EP);
        icon3EP79 = findViewById(R.id.icon3EP);
        icon4EP79 = findViewById(R.id.icon4EP);
        icon5EP79 = findViewById(R.id.icon5EP);
        icon6EP79 = findViewById(R.id.icon6EP);
        icon7EP79 = findViewById(R.id.icon7EP);
        icon8EP79 = findViewById(R.id.icon8EP);

        sfx = MediaPlayer.create(this, R.raw.btnsfx);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();

        DocumentReference docRef = fStore.collection("users").document(user.getUid());

        btnBackEP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();
                startActivity(new Intent(EditProfile79.this,UserProfile79.class));
            }
        });


        icon1EP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                icon1EP79.setImageResource(R.drawable.tigerselected);
                icon2EP79.setImageResource(R.drawable.owlselect);
                icon3EP79.setImageResource(R.drawable.lionselect);
                icon4EP79.setImageResource(R.drawable.butterflyselect);
                icon5EP79.setImageResource(R.drawable.foxselect);
                icon6EP79.setImageResource(R.drawable.beeselect);
                icon7EP79.setImageResource(R.drawable.catselect);
                icon8EP79.setImageResource(R.drawable.chickenselect);

                userIcon = "tiger";
                userIconSelected = true;
            }
        });

        icon2EP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                icon1EP79.setImageResource(R.drawable.tigerselect);
                icon2EP79.setImageResource(R.drawable.owlselected);
                icon3EP79.setImageResource(R.drawable.lionselect);
                icon4EP79.setImageResource(R.drawable.butterflyselect);
                icon5EP79.setImageResource(R.drawable.foxselect);
                icon6EP79.setImageResource(R.drawable.beeselect);
                icon7EP79.setImageResource(R.drawable.catselect);
                icon8EP79.setImageResource(R.drawable.chickenselect);

                userIcon = "owl";
                userIconSelected = true;
            }
        });

        icon3EP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                icon1EP79.setImageResource(R.drawable.tigerselect);
                icon2EP79.setImageResource(R.drawable.owlselect);
                icon3EP79.setImageResource(R.drawable.lionselected);
                icon4EP79.setImageResource(R.drawable.butterflyselect);
                icon5EP79.setImageResource(R.drawable.foxselect);
                icon6EP79.setImageResource(R.drawable.beeselect);
                icon7EP79.setImageResource(R.drawable.catselect);
                icon8EP79.setImageResource(R.drawable.chickenselect);

                userIcon = "lion";
                userIconSelected = true;
            }
        });

        icon4EP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                icon1EP79.setImageResource(R.drawable.tigerselect);
                icon2EP79.setImageResource(R.drawable.owlselect);
                icon3EP79.setImageResource(R.drawable.lionselect);
                icon4EP79.setImageResource(R.drawable.butterflyselected);
                icon5EP79.setImageResource(R.drawable.foxselect);
                icon6EP79.setImageResource(R.drawable.beeselect);
                icon7EP79.setImageResource(R.drawable.catselect);
                icon8EP79.setImageResource(R.drawable.chickenselect);

                userIcon = "butterfly";
                userIconSelected = true;
            }
        });

        icon5EP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                icon1EP79.setImageResource(R.drawable.tigerselect);
                icon2EP79.setImageResource(R.drawable.owlselect);
                icon3EP79.setImageResource(R.drawable.lionselect);
                icon4EP79.setImageResource(R.drawable.butterflyselect);
                icon5EP79.setImageResource(R.drawable.foxselected);
                icon6EP79.setImageResource(R.drawable.beeselect);
                icon7EP79.setImageResource(R.drawable.catselect);
                icon8EP79.setImageResource(R.drawable.chickenselect);

                userIcon = "fox";
                userIconSelected = true;
            }
        });

        icon6EP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                icon1EP79.setImageResource(R.drawable.tigerselect);
                icon2EP79.setImageResource(R.drawable.owlselect);
                icon3EP79.setImageResource(R.drawable.lionselect);
                icon4EP79.setImageResource(R.drawable.butterflyselect);
                icon5EP79.setImageResource(R.drawable.foxselect);
                icon6EP79.setImageResource(R.drawable.beeselected);
                icon7EP79.setImageResource(R.drawable.catselect);
                icon8EP79.setImageResource(R.drawable.chickenselect);

                userIcon = "bee";
                userIconSelected = true;
            }
        });

        icon7EP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                icon1EP79.setImageResource(R.drawable.tigerselect);
                icon2EP79.setImageResource(R.drawable.owlselect);
                icon3EP79.setImageResource(R.drawable.lionselect);
                icon4EP79.setImageResource(R.drawable.butterflyselect);
                icon5EP79.setImageResource(R.drawable.foxselect);
                icon6EP79.setImageResource(R.drawable.beeselect);
                icon7EP79.setImageResource(R.drawable.catselected);
                icon8EP79.setImageResource(R.drawable.chickenselect);

                userIcon = "cat";
                userIconSelected = true;
            }
        });

        icon8EP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                icon1EP79.setImageResource(R.drawable.tigerselect);
                icon2EP79.setImageResource(R.drawable.owlselect);
                icon3EP79.setImageResource(R.drawable.lionselect);
                icon4EP79.setImageResource(R.drawable.butterflyselect);
                icon5EP79.setImageResource(R.drawable.foxselect);
                icon6EP79.setImageResource(R.drawable.beeselect);
                icon7EP79.setImageResource(R.drawable.catselect);
                icon8EP79.setImageResource(R.drawable.chickenselected);

                userIcon = "chicken";
                userIconSelected = true;
            }
        });

        btnSaveEP79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();


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

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    changesStatus.setText("");
                                }
                            },3000);;

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            changesStatus.setText("Username Update Failed.");
                            nUsername.getText().clear();

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    changesStatus.setText("");
                                }
                            },3000);;

                        }
                    });

                }

                //PASSWORD
                if((oPassword.getText().toString().isEmpty()) && ((!nPassword.getText().toString().isEmpty()) || (!nCPassword.getText().toString().isEmpty()))){
                    oPassword.setError("Enter old password");
                }
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

                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                changesStatus.setText("");
                                            }
                                        },3000);;

                                        oPassword.getText().clear();
                                        nPassword.getText().clear();
                                        nCPassword.getText().clear();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        changesStatus.setText(e.getMessage());

                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                changesStatus.setText("");
                                            }
                                        },3000);;

                                    }
                                });
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                changesStatus.setText(e.getMessage());

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        changesStatus.setText("");
                                    }
                                },3000);;
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

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    changesStatus.setText("");
                                }
                            },3000);;

                        }
                    });
                }

                //RESET EVERYTHING
                icon1EP79.setImageResource(R.drawable.tigerselect);
                icon2EP79.setImageResource(R.drawable.owlselect);
                icon3EP79.setImageResource(R.drawable.lionselect);
                icon4EP79.setImageResource(R.drawable.butterflyselect);
                icon5EP79.setImageResource(R.drawable.foxselect);
                icon6EP79.setImageResource(R.drawable.beeselect);
                icon7EP79.setImageResource(R.drawable.catselect);
                icon8EP79.setImageResource(R.drawable.chickenselect);
            }
        });

    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(EditProfile79.this,UserProfile79.class));
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