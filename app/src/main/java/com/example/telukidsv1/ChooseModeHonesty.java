package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseModeHonesty extends AppCompatActivity {

    ImageButton backCMH36,learnCMH36,assessCMH36,replayCMH36;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode_honesty);

        backCMH36 = findViewById(R.id.bconceptsbtnCMH36);
        learnCMH36 = findViewById(R.id.learnCMH36);
        assessCMH36 = findViewById(R.id.assessCMH36);
        replayCMH36 = findViewById(R.id.replayintroCMH36);

        BackgroundSoundService.onResume();

        MediaPlayer sfx = MediaPlayer.create(this, R.raw.btnsfx);


        backCMH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        sfx.release();
                    }
                });

                startActivity(new Intent(ChooseModeHonesty.this,Gmrc3to6.class));
            }
        });

        learnCMH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        sfx.release();
                    }
                });

                startActivity(new Intent(ChooseModeHonesty.this, LessonHonesty.class));
            }
        });

        assessCMH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        sfx.release();
                    }
                });

                startActivity(new Intent(ChooseModeHonesty.this,QuizHonesty.class));
            }
        });

        replayCMH36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfx.start();

                sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        sfx.release();
                    }
                });

                startActivity(new Intent(ChooseModeHonesty.this,LessonIntroHonesty.class));
            }
        });
    }
}