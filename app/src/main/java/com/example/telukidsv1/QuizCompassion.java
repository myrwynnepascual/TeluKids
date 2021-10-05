package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telukidsv1.R;
import com.example.telukidsv1.ResultsCompassion;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizCompassion extends AppCompatActivity {
    private TextView countLabel_Compassion;
    private TextView questionLabel_Compassion;
    private TextView prompt_Compassion;
    private LinearLayout quizLayout_Compassion;
    private ConstraintLayout background_Compassion;

    MediaPlayer voiceover1;
    MediaPlayer voiceover2;
    MediaPlayer choice1;
    MediaPlayer choice2;

    int background_Question;

    Button btnAnswer1_Compassion;
    Button btnAnswer2_Compassion;
    Button btnConfirm_Compassion;

    private String rightAnswer_Compassion;
    private String wrongAnswer_Compassion;
    private int rightAnswerCount_Compassion = 0;
    private int quizCount_Compassion = 1;
    static final private int QUIZ_COUNT = 6;
    private int confirmClicked_Compassion = 0;


    ArrayList<ArrayList<String>> quizArray_Compassion = new ArrayList<>();

    String quizData_Compassion[][] = {
            //{"Question", "Background Image 1", "Question Voice Over 1", "Background Image 2", "Question Voice Over 2" "Right Answer", "Wrong Answer", "Choice 1 Voice Over", "Choice 2 Voice Over"}
            {"What should Julie do?", String.valueOf(R.drawable.c1bg1), String.valueOf(R.raw.cq1_1), String.valueOf(R.drawable.c1bg2), String.valueOf(R.raw.cq1_2), "Help Max to get up", "Laugh at Max for being silly", String.valueOf(R.raw.cq1c1), String.valueOf(R.raw.cq1c2) },
            {"What should Max do?", String.valueOf(R.drawable.c2bg1), String.valueOf(R.raw.cq2_1), String.valueOf(R.drawable.c2bg2), String.valueOf(R.raw.cq2_2), "Help Marga reach for her toy", "Ignore Marga and continue playing", String.valueOf(R.raw.cq2c1), String.valueOf(R.raw.cq2c2) },
            {"What should Joey do?", String.valueOf(R.drawable.c3bg1), String.valueOf(R.raw.cq3_1), String.valueOf(R.drawable.c3bg2), String.valueOf(R.raw.cq3_2), "Share his apple with Marga", "Ignore Marga and let her go hungry", String.valueOf(R.raw.cq3c1), String.valueOf(R.raw.cq3c2) },
            {"What should be Marga's answer?", String.valueOf(R.drawable.c4bg1), String.valueOf(R.raw.cq4_1), String.valueOf(R.drawable.c4bg2), String.valueOf(R.raw.cq4_2), "It's okay I can share it with you", "This is mine, go ask your parents to buy you one", String.valueOf(R.raw.cq4c1), String.valueOf(R.raw.cq4c2) },
            {"What should Max do?", String.valueOf(R.drawable.c5bg1), String.valueOf(R.raw.cq5_1), String.valueOf(R.drawable.c5bg2), String.valueOf(R.raw.cq5_2), "Offer Joey to share his other crayons", "Stay silent and don't lend Joey his crayons", String.valueOf(R.raw.cq5c1), String.valueOf(R.raw.cq5c2) },
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_compassion);

        BackgroundSoundService.onPause();

        background_Compassion = (ConstraintLayout) findViewById(R.id.background_Compassion);
        quizLayout_Compassion = (LinearLayout)findViewById(R.id.quizLayout_Compassion);
        countLabel_Compassion = (TextView)findViewById(R.id.countLabel_Compassion);
        questionLabel_Compassion = (TextView)findViewById(R.id.questionLabel_Compassion);
        btnAnswer1_Compassion = (Button)findViewById(R.id.btnAnswer1_Compassion);
        btnAnswer2_Compassion = (Button)findViewById(R.id.btnAnswer2_Compassion);
        prompt_Compassion = (TextView)findViewById(R.id.prompt_Compassion);
        btnConfirm_Compassion = (Button)findViewById(R.id.btnConfirm_Compassion);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Compassion.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Compassion[i][0]); //Question
            tmpArray.add(quizData_Compassion[i][1]); //Background Image 1
            tmpArray.add(quizData_Compassion[i][2]); //Question Voice Over 1
            tmpArray.add(quizData_Compassion[i][3]); //Background Image 2
            tmpArray.add(quizData_Compassion[i][4]); //Question Voice Over 2
            tmpArray.add(quizData_Compassion[i][5]); //Right Answer
            tmpArray.add(quizData_Compassion[i][6]); //Wrong Answer
            tmpArray.add(quizData_Compassion[i][7]); //Choice 1 Voice Over
            tmpArray.add(quizData_Compassion[i][8]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_Compassion.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Compassion.setText("Question #" + quizCount_Compassion);
        confirmClicked_Compassion = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Compassion.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Compassion.get(randomNum);

        //Set Question and Right Answer

        //Hide question and choices
        quizLayout_Compassion.setVisibility(View.INVISIBLE);
        countLabel_Compassion.setVisibility(View.INVISIBLE);
        questionLabel_Compassion.setVisibility(View.INVISIBLE);
        btnAnswer1_Compassion.setVisibility(View.INVISIBLE);
        btnAnswer2_Compassion.setVisibility(View.INVISIBLE);
        btnConfirm_Compassion.setVisibility(View.INVISIBLE);
        btnAnswer1_Compassion.setBackgroundResource(R.drawable.answerbutton);
        btnAnswer2_Compassion.setBackgroundResource(R.drawable.answerbutton);
        btnAnswer1_Compassion.setEnabled(true);
        btnAnswer2_Compassion.setEnabled(true);
        btnConfirm_Compassion.setEnabled(true);

        questionLabel_Compassion.setText(quiz.get(0));
        background_Compassion.setBackgroundResource(Integer.parseInt(quiz.get(1)));
        voiceover1 = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        background_Question = Integer.parseInt(quiz.get(3));
        voiceover2 = MediaPlayer.create(this, Integer.parseInt(quiz.get(4)));
        voiceover1.start();
        voiceover1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                voiceover1.release();
                voiceover2.start();
                background_Compassion.setBackgroundResource(background_Question);
                quizLayout_Compassion.setVisibility(View.VISIBLE);
                countLabel_Compassion.setVisibility(View.VISIBLE);
                questionLabel_Compassion.setVisibility(View.VISIBLE);
                btnAnswer1_Compassion.setVisibility(View.VISIBLE);
                btnAnswer2_Compassion.setVisibility(View.VISIBLE);
                btnConfirm_Compassion.setVisibility(View.VISIBLE);
            }
        });
        rightAnswer_Compassion = quiz.get(5);
        wrongAnswer_Compassion = quiz.get(6);
        choice1 = MediaPlayer.create(this, Integer.parseInt(quiz.get(7)));
        choice2 = MediaPlayer.create(this, Integer.parseInt(quiz.get(8)));

        //Shuffle Choices
        quiz.remove(0);
        quiz.remove(0);
        quiz.remove(0);
        quiz.remove(0);
        quiz.remove(0);
        quiz.remove(2);
        quiz.remove(2);
        Collections.shuffle(quiz);

        //Set Choices
        btnAnswer1_Compassion.setText(quiz.get(0));
        btnAnswer2_Compassion.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Compassion.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Compassion){
            btnAnswer1_Compassion.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Compassion.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Compassion){
            btnAnswer2_Compassion.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Compassion.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_Compassion)){
            voiceover1.release();
            voiceover2.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_Compassion) && answerBtn != btnConfirm_Compassion){
            voiceover1.release();
            voiceover2.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_Compassion) && !btnText.equals(wrongAnswer_Compassion)){
            prompt_Compassion.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prompt_Compassion.setText("");
                }
            },3000);

        }
        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Compassion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Compassion)){
                    //Correct
                    voiceover1.release();
                    voiceover2.release();
                    choice1.release();
                    choice2.release();
                    wrong_sound.release();
                    answerBtn.setBackgroundResource(R.drawable.correctanswerbutton);
                    correct_sound.start();
                    correct_sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            correct_sound.release();
                        }
                    });
                    rightAnswerCount_Compassion++;
                    btnConfirm_Compassion.setEnabled(false);
                    btnAnswer1_Compassion.setEnabled(false);
                    btnAnswer2_Compassion.setEnabled(false);
                    confirmClicked_Compassion++;
                    quizCount_Compassion++;
                    if (quizCount_Compassion == QUIZ_COUNT && confirmClicked_Compassion != 0){
                        //Show Result
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), ResultsCompassion.class);
                                intent.putExtra("RIGHT_ANSWER_COUNT_Compassion", rightAnswerCount_Compassion);
                                startActivity(intent);
                            }
                        }, 2000);
                    }
                    else {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                showNextQuiz();
                            }
                        }, 2000);
                    }
                }
                if (btnText.equals(wrongAnswer_Compassion)) {
                    //Wrong
                    voiceover1.release();
                    voiceover2.release();
                    choice1.release();
                    choice2.release();
                    correct_sound.release();
                    answerBtn.setBackgroundResource(R.drawable.wronganswerbutton);
                    wrong_sound.start();
                    wrong_sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {

                            wrong_sound.release();
                        }
                    });
                    btnConfirm_Compassion.setEnabled(false);
                    btnAnswer1_Compassion.setEnabled(false);
                    btnAnswer2_Compassion.setEnabled(false);
                    confirmClicked_Compassion++;
                    quizCount_Compassion++;
                    if (quizCount_Compassion == QUIZ_COUNT && confirmClicked_Compassion != 0){
                        //Show Result
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), ResultsCompassion.class);
                                intent.putExtra("RIGHT_ANSWER_COUNT_Compassion", rightAnswerCount_Compassion);
                                startActivity(intent);
                            }
                        }, 2000);
                    }
                    else {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                showNextQuiz();
                            }
                        }, 2000);
                    }
                }
                else if (!btnText.equals(rightAnswer_Compassion) && !btnText.equals(wrongAnswer_Compassion)){
                    prompt_Compassion.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Compassion.setText("");
                        }
                    },3000);
                }
            }
        });

        background_Compassion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!btnText.equals(btnAnswer1_Compassion.getText().toString()) && !btnText.equals(btnAnswer2_Compassion.getText().toString())){
                    //Check if user selected an answer
                    prompt_Compassion.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Compassion.setText("");
                        }
                    },3000);
                }
                else if(confirmClicked_Compassion == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Compassion.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Compassion.setText("");
                        }
                    },3000);
                }
            }
        });
    }
}