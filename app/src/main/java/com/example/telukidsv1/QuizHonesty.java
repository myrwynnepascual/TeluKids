package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

public class QuizHonesty extends AppCompatActivity {
    private TextView countLabel_Honesty;
    private TextView questionLabel_Honesty;
    private TextView prompt_Honesty;
    private LinearLayout quizLayout_Honesty;
    private ConstraintLayout background_Honesty;

    MediaPlayer voiceover1;
    MediaPlayer voiceover2;
    MediaPlayer choice1;
    MediaPlayer choice2;

    int background_Question;

    Button btnAnswer1_Honesty;
    Button btnAnswer2_Honesty;
    Button btnConfirm_Honesty;

    private String rightAnswer_Honesty;
    private String wrongAnswer_Honesty;
    private int rightAnswerCount_Honesty = 0;
    private int quizCount_Honesty = 1;
    static final private int QUIZ_COUNT = 6;
    private int confirmClicked_Honesty = 0;


    ArrayList<ArrayList<String>> quizArray_Honesty = new ArrayList<>();

    String quizData_Honesty[][] = {
            //{"Question", "Background Image 1", "Question Voice Over 1", "Background Image 2", "Question Voice Over 2" "Right Answer", "Wrong Answer", "Choice 1 Voice Over", "Choice 2 Voice Over"}
            {"What should Max do?", String.valueOf(R.drawable.h1bg1), String.valueOf(R.raw.hq1_1), String.valueOf(R.drawable.h1bg2), String.valueOf(R.raw.hq1_2), "Tell his parents the truth", "Lie and tell his parents he doesn't know", String.valueOf(R.raw.hq1c1), String.valueOf(R.raw.hq1c2) },
            {"What should Marga say?", String.valueOf(R.drawable.h2bg1), String.valueOf(R.raw.hq2_1), String.valueOf(R.drawable.h2bg2), String.valueOf(R.raw.hq2_2), "I'm sorry I ate the cake", "No, I didn't even go near it", String.valueOf(R.raw.hq2c1), String.valueOf(R.raw.hq2c2) },
            {"What should Julie do?", String.valueOf(R.drawable.h3bg1), String.valueOf(R.raw.hq3_1), String.valueOf(R.drawable.h3bg2), String.valueOf(R.raw.hq3_2), "Tell it to the lady and return the money", "Pick up the money and keep it in her pocket", String.valueOf(R.raw.hq3c1), String.valueOf(R.raw.hq3c2) },
            {"What should Julie do?", String.valueOf(R.drawable.h4bg1), String.valueOf(R.raw.hq4_1), String.valueOf(R.drawable.h4bg2), String.valueOf(R.raw.hq4_2), "Take it home but return in the next time she sees Marga", "Take it home and never return it", String.valueOf(R.raw.hq4c1), String.valueOf(R.raw.hq4c2) },
            {"What should Joey do?", String.valueOf(R.drawable.h5bg1), String.valueOf(R.raw.hq5_1), String.valueOf(R.drawable.h5bg2), String.valueOf(R.raw.hq5_2), "Ask permission if he can borrow the pencil", "Take the pencil immediately", String.valueOf(R.raw.hq5c1), String.valueOf(R.raw.hq5c2) },
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_honesty);

        BackgroundSoundService.onPause();

        background_Honesty = (ConstraintLayout) findViewById(R.id.background_Honesty);
        quizLayout_Honesty = (LinearLayout)findViewById(R.id.quizLayout_Honesty);
        countLabel_Honesty = (TextView)findViewById(R.id.countLabel_Honesty);
        questionLabel_Honesty = (TextView)findViewById(R.id.questionLabel_Honesty);
        btnAnswer1_Honesty = (Button)findViewById(R.id.btnAnswer1_Honesty);
        btnAnswer2_Honesty = (Button)findViewById(R.id.btnAnswer2_Honesty);
        prompt_Honesty = (TextView)findViewById(R.id.prompt_Honesty);
        btnConfirm_Honesty = (Button)findViewById(R.id.btnConfirm_Honesty);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Honesty.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Honesty[i][0]); //Question
            tmpArray.add(quizData_Honesty[i][1]); //Background Image 1
            tmpArray.add(quizData_Honesty[i][2]); //Question Voice Over 1
            tmpArray.add(quizData_Honesty[i][3]); //Background Image 2
            tmpArray.add(quizData_Honesty[i][4]); //Question Voice Over 2
            tmpArray.add(quizData_Honesty[i][5]); //Right Answer
            tmpArray.add(quizData_Honesty[i][6]); //Wrong Answer
            tmpArray.add(quizData_Honesty[i][7]); //Choice 1 Voice Over
            tmpArray.add(quizData_Honesty[i][8]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_Honesty.add(tmpArray);
        }
        assessmenttitle();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Honesty.setText("Question #" + quizCount_Honesty);
        confirmClicked_Honesty = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Honesty.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Honesty.get(randomNum);

        //Set Question and Right Answer

        //Hide question and choices
        quizLayout_Honesty.setVisibility(View.INVISIBLE);
        countLabel_Honesty.setVisibility(View.INVISIBLE);
        questionLabel_Honesty.setVisibility(View.INVISIBLE);
        btnAnswer1_Honesty.setVisibility(View.INVISIBLE);
        btnAnswer2_Honesty.setVisibility(View.INVISIBLE);
        btnConfirm_Honesty.setVisibility(View.INVISIBLE);
        btnAnswer1_Honesty.setBackgroundResource(R.drawable.answerbutton);
        btnAnswer2_Honesty.setBackgroundResource(R.drawable.answerbutton);
        btnAnswer1_Honesty.setEnabled(true);
        btnAnswer2_Honesty.setEnabled(true);
        btnConfirm_Honesty.setEnabled(true);

        questionLabel_Honesty.setText(quiz.get(0));
        background_Honesty.setBackgroundResource(Integer.parseInt(quiz.get(1)));
        voiceover1 = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        background_Question = Integer.parseInt(quiz.get(3));
        voiceover2 = MediaPlayer.create(this, Integer.parseInt(quiz.get(4)));
        voiceover1.start();
        voiceover1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                voiceover1.release();
                voiceover2.start();
                background_Honesty.setBackgroundResource(background_Question);
                quizLayout_Honesty.setVisibility(View.VISIBLE);
                countLabel_Honesty.setVisibility(View.VISIBLE);
                questionLabel_Honesty.setVisibility(View.VISIBLE);
                btnAnswer1_Honesty.setVisibility(View.VISIBLE);
                btnAnswer2_Honesty.setVisibility(View.VISIBLE);
                btnConfirm_Honesty.setVisibility(View.VISIBLE);
            }
        });
        rightAnswer_Honesty = quiz.get(5);
        wrongAnswer_Honesty = quiz.get(6);
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
        btnAnswer1_Honesty.setText(quiz.get(0));
        btnAnswer2_Honesty.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Honesty.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Honesty){
            btnAnswer1_Honesty.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Honesty.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Honesty){
            btnAnswer2_Honesty.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Honesty.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_Honesty)){
            voiceover1.release();
            voiceover2.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_Honesty) && answerBtn != btnConfirm_Honesty){
            voiceover1.release();
            voiceover2.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_Honesty) && !btnText.equals(wrongAnswer_Honesty)){
            prompt_Honesty.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prompt_Honesty.setText("");
                }
            },3000);

        }
        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Honesty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Honesty)){
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
                    rightAnswerCount_Honesty++;
                    btnConfirm_Honesty.setEnabled(false);
                    btnAnswer1_Honesty.setEnabled(false);
                    btnAnswer2_Honesty.setEnabled(false);
                    confirmClicked_Honesty++;
                    quizCount_Honesty++;
                    if (quizCount_Honesty == QUIZ_COUNT && confirmClicked_Honesty != 0){
                        //Show Result
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), ResultsHonesty.class);
                                intent.putExtra("RIGHT_ANSWER_COUNT_Honesty", rightAnswerCount_Honesty);
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
                if (btnText.equals(wrongAnswer_Honesty)) {
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
                    btnConfirm_Honesty.setEnabled(false);
                    btnAnswer1_Honesty.setEnabled(false);
                    btnAnswer2_Honesty.setEnabled(false);
                    confirmClicked_Honesty++;
                    quizCount_Honesty++;
                    if (quizCount_Honesty == QUIZ_COUNT && confirmClicked_Honesty != 0){
                        //Show Result
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), ResultsHonesty.class);
                                intent.putExtra("RIGHT_ANSWER_COUNT_Honesty", rightAnswerCount_Honesty);
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
                else if (!btnText.equals(rightAnswer_Honesty) && !btnText.equals(wrongAnswer_Honesty)){
                    prompt_Honesty.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Honesty.setText("");
                        }
                    },3000);
                }
            }
        });

        background_Honesty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!btnText.equals(btnAnswer1_Honesty.getText().toString()) && !btnText.equals(btnAnswer2_Honesty.getText().toString())){
                    //Check if user selected an answer
                    prompt_Honesty.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Honesty.setText("");
                        }
                    },3000);
                }
                else if(confirmClicked_Honesty == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Honesty.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Honesty.setText("");
                        }
                    },3000);
                }
            }
        });
    }
    public void assessmenttitle(){
        background_Honesty.setBackgroundResource(R.drawable.honestytitle);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showNextQuiz();
            }
        },2000);
    }

    @Override
    public void onBackPressed(){

        Toast toast = Toast.makeText(this, "Uh oh! Back button is disabled! Please continue the quiz ✌", Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        toast.show();

    }
}