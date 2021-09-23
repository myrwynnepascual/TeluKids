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

public class QuizSociability extends AppCompatActivity {
    private TextView countLabel_Sociability;
    private TextView questionLabel_Sociability;
    private TextView prompt_Sociability;
    private LinearLayout quizLayout_Sociability;
    private ConstraintLayout background_Sociability;

    MediaPlayer voiceover1;
    MediaPlayer voiceover2;
    MediaPlayer choice1;
    MediaPlayer choice2;

    int background_Question;

    Button btnAnswer1_Sociability;
    Button btnAnswer2_Sociability;
    Button btnConfirm_Sociability;


    private String rightAnswer_Sociability;
    private String wrongAnswer_Sociability;
    private int rightAnswerCount_Sociability = 0;
    private int quizCount_Sociability = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Sociability = 0;


    ArrayList<ArrayList<String>> quizArray_Sociability = new ArrayList<>();

    String quizData_Sociability[][] = {
            //{"Question", "Background Image 1", "Question Voice Over 1", "Background Image 2", "Question Voice Over 2" "Right Answer", "Wrong Answer", "Choice 1 Voice Over", "Choice 2 Voice Over"}
            {"What should Max say?", String.valueOf(R.drawable.sc1bg1), String.valueOf(R.raw.scq1_1), String.valueOf(R.drawable.sc1bg2), String.valueOf(R.raw.scq1_2), "Can I watch cartoons please, Thank you", "Hey! I want to watch cartoons", String.valueOf(R.raw.scq1c1), String.valueOf(R.raw.scq1c2) },
            {"What is the right thing to do?", String.valueOf(R.drawable.sc2bg1), String.valueOf(R.raw.scq2_1), String.valueOf(R.drawable.sc2bg2), String.valueOf(R.raw.scq2_2), "Say 'Magandang umaga po Lolo at Lola' ", "Ignore them and just play with her gadget", String.valueOf(R.raw.scq2c1), String.valueOf(R.raw.scq2c2) },
            {"What should Joey do?", String.valueOf(R.drawable.sc3bg1), String.valueOf(R.raw.scq3_1), String.valueOf(R.drawable.sc3bg2), String.valueOf(R.raw.scq3_2), "Tell Max 'I'm sorry, I didn't mean to scare you'", "Continue pushing Max and laugh at him", String.valueOf(R.raw.scq3c1), String.valueOf(R.raw.scq3c2) },
            {"What is the right thing to do?", String.valueOf(R.drawable.sc4n5bg1), String.valueOf(R.raw.scq4_1), String.valueOf(R.drawable.sc4n5bg2), String.valueOf(R.raw.scq4_2), "Be a sport and say 'Oh well, maybe I should hide better next time. Congrats, Joey'", "Be upset and say 'This is unfair. You're cheating, Joey'", String.valueOf(R.raw.scq4c1), String.valueOf(R.raw.scq4c2)},
            {"What should be Joey's attitude?", String.valueOf(R.drawable.sc4n5bg1), String.valueOf(R.raw.scq5_1), String.valueOf(R.drawable.sc4n5bg2), String.valueOf(R.raw.scq5_2), "Stay humble", "Be boastful", String.valueOf(R.raw.scq5c1), String.valueOf(R.raw.scq5c2) }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_sociability);

        background_Sociability = (ConstraintLayout) findViewById(R.id.background_Sociability);
        quizLayout_Sociability = (LinearLayout)findViewById(R.id.quizLayout_Sociability);
        countLabel_Sociability = (TextView)findViewById(R.id.countLabel_Sociability);
        questionLabel_Sociability = (TextView)findViewById(R.id.questionLabel_Sociability);
        btnAnswer1_Sociability = (Button)findViewById(R.id.btnAnswer1_Sociability);
        btnAnswer2_Sociability = (Button)findViewById(R.id.btnAnswer2_Sociability);
        prompt_Sociability = (TextView)findViewById(R.id.prompt_Sociability);
        btnConfirm_Sociability = (Button)findViewById(R.id.btnConfirm_Sociability);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Sociability.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Sociability[i][0]); //Question
            tmpArray.add(quizData_Sociability[i][1]); //Background Image 1
            tmpArray.add(quizData_Sociability[i][2]); //Question Voice Over 1
            tmpArray.add(quizData_Sociability[i][3]); //Background Image 2
            tmpArray.add(quizData_Sociability[i][4]); //Question Voice Over 2
            tmpArray.add(quizData_Sociability[i][5]); //Right Answer
            tmpArray.add(quizData_Sociability[i][6]); //Wrong Answer
            tmpArray.add(quizData_Sociability[i][7]); //Choice 1 Voice Over
            tmpArray.add(quizData_Sociability[i][8]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_Sociability.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Sociability.setText("Question #" + quizCount_Sociability);
        confirmClicked_Sociability = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Sociability.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Sociability.get(randomNum);

        //Set Question and Right Answer

        //Hide question and choices
        quizLayout_Sociability.setVisibility(View.INVISIBLE);
        countLabel_Sociability.setVisibility(View.INVISIBLE);
        questionLabel_Sociability.setVisibility(View.INVISIBLE);
        btnAnswer1_Sociability.setVisibility(View.INVISIBLE);
        btnAnswer2_Sociability.setVisibility(View.INVISIBLE);
        btnConfirm_Sociability.setVisibility(View.INVISIBLE);

        questionLabel_Sociability.setText(quiz.get(0));
        background_Sociability.setBackgroundResource(Integer.parseInt(quiz.get(1)));
        voiceover1 = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        background_Question = Integer.parseInt(quiz.get(3));
        voiceover2 = MediaPlayer.create(this, Integer.parseInt(quiz.get(4)));
        voiceover1.start();
        voiceover1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                voiceover1.release();
                voiceover2.start();
                background_Sociability.setBackgroundResource(background_Question);
                quizLayout_Sociability.setVisibility(View.VISIBLE);
                countLabel_Sociability.setVisibility(View.VISIBLE);
                questionLabel_Sociability.setVisibility(View.VISIBLE);
                btnAnswer1_Sociability.setVisibility(View.VISIBLE);
                btnAnswer2_Sociability.setVisibility(View.VISIBLE);
                btnConfirm_Sociability.setVisibility(View.VISIBLE);
            }
        });
        rightAnswer_Sociability = quiz.get(5);
        wrongAnswer_Sociability = quiz.get(6);
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
        btnAnswer1_Sociability.setText(quiz.get(0));
        btnAnswer2_Sociability.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Sociability.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Sociability){
            btnAnswer1_Sociability.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Sociability.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Sociability){
            btnAnswer2_Sociability.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Sociability.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_Sociability)){
            voiceover1.release();
            voiceover2.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_Sociability) && answerBtn != btnConfirm_Sociability){
            voiceover1.release();
            voiceover2.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_Sociability) && !btnText.equals(wrongAnswer_Sociability)){
            prompt_Sociability.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prompt_Sociability.setText("");
                }
            },3000);

        }
        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Sociability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Sociability)){
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
                    rightAnswerCount_Sociability++;
                    btnConfirm_Sociability.setEnabled(false);
                    btnAnswer1_Sociability.setEnabled(false);
                    btnAnswer2_Sociability.setEnabled(false);
                    confirmClicked_Sociability++;
                }
                if (btnText.equals(wrongAnswer_Sociability)) {
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
                    btnConfirm_Sociability.setEnabled(false);
                    btnAnswer1_Sociability.setEnabled(false);
                    btnAnswer2_Sociability.setEnabled(false);
                    confirmClicked_Sociability++;
                }
                else if (!btnText.equals(rightAnswer_Sociability) && !btnText.equals(wrongAnswer_Sociability)){
                    prompt_Sociability.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Sociability.setText("");
                        }
                    },3000);
                }
            }
        });

        background_Sociability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizCount_Sociability == QUIZ_COUNT && confirmClicked_Sociability != 0){
                    //Show Result
                    Intent intent = new Intent(getApplicationContext(), ResultsSociability.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT_Sociability", rightAnswerCount_Sociability);
                    startActivity(intent);
                }
                else if (!btnText.equals(btnAnswer1_Sociability.getText().toString()) && !btnText.equals(btnAnswer2_Sociability.getText().toString())){
                    //Check if user selected an answer
                    prompt_Sociability.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Sociability.setText("");
                        }
                    },3000);
                }
                else if(confirmClicked_Sociability == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Sociability.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Sociability.setText("");
                        }
                    },3000);
                }
                else{
                    quizCount_Sociability++;
                    btnAnswer1_Sociability.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Sociability.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer1_Sociability.setEnabled(true);
                    btnAnswer2_Sociability.setEnabled(true);
                    btnConfirm_Sociability.setEnabled(true);
                    voiceover1.release();
                    voiceover2.release();
                    choice1.release();
                    choice2.release();
                    correct_sound.release();
                    wrong_sound.release();
                    showNextQuiz();
                }
            }
        });
    }
}