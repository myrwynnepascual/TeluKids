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

public class QuizLove extends AppCompatActivity {
    private TextView countLabel_Love;
    private TextView questionLabel_Love;
    private TextView prompt_Love;
    private LinearLayout quizLayout_Love;
    private ConstraintLayout background_Love;

    MediaPlayer voiceover1;
    MediaPlayer voiceover2;
    MediaPlayer choice1;
    MediaPlayer choice2;

    int background_Question;

    Button btnAnswer1_Love;
    Button btnAnswer2_Love;
    Button btnConfirm_Love;

    private String rightAnswer_Love;
    private String wrongAnswer_Love;
    private int rightAnswerCount_Love = 0;
    private int quizCount_Love = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Love = 0;


    ArrayList<ArrayList<String>> quizArray_Love = new ArrayList<>();

    String quizData_Love[][] = {
            //{"Question", "Background Image 1", "Question Voice Over 1", "Background Image 2", "Question Voice Over 2" "Right Answer", "Wrong Answer", "Choice 1 Voice Over", "Choice 2 Voice Over"}
            {"What should Julie do?", String.valueOf(R.drawable.l1bg1), String.valueOf(R.raw.lq1_1), String.valueOf(R.drawable.l1bg2), String.valueOf(R.raw.lq1_2), "Hug her friend", "Laugh at her friend", String.valueOf(R.raw.lq1c1), String.valueOf(R.raw.lq1c2) },
            {"What should Marga do?", String.valueOf(R.drawable.sc2bg1), String.valueOf(R.raw.lq2_1), String.valueOf(R.drawable.sc2bg2), String.valueOf(R.raw.lq2_2), "Greet her grandparents by 'mano'", "Lock in her door", String.valueOf(R.raw.lq2c1), String.valueOf(R.raw.lq2c2) },
            {"What is the right attitude for Joey?", String.valueOf(R.drawable.h1bg1), String.valueOf(R.raw.lq3_1), String.valueOf(R.drawable.h1bg2), String.valueOf(R.raw.lq3_2), "Tell his mother the truth", "Lie and say he doesn't know what happened", String.valueOf(R.raw.lq3c1), String.valueOf(R.raw.lq3c2) },
            {"What should Marga do?", String.valueOf(R.drawable.l4bg1), String.valueOf(R.raw.lq4_1), String.valueOf(R.drawable.l4bg2), String.valueOf(R.raw.lq4_2), "Help her teacher", "Ignore her teacher", String.valueOf(R.raw.lq4c1), String.valueOf(R.raw.lq4c2) },
            {"How can Joey show generosity?", String.valueOf(R.drawable.c3bg1), String.valueOf(R.raw.lq5_1), String.valueOf(R.drawable.c3bg2), String.valueOf(R.raw.lq5_2), "Give 1 apple to his seatmate", "Ignore his seatmate and let her starve", String.valueOf(R.raw.lq5c1), String.valueOf(R.raw.lq5c2) }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_love);

        BackgroundSoundService.onPause();

        background_Love = (ConstraintLayout) findViewById(R.id.background_Love);
        quizLayout_Love = (LinearLayout)findViewById(R.id.quizLayout_Love);
        countLabel_Love = (TextView)findViewById(R.id.countLabel_Love);
        questionLabel_Love = (TextView)findViewById(R.id.questionLabel_Love);
        btnAnswer1_Love = (Button)findViewById(R.id.btnAnswer1_Love);
        btnAnswer2_Love = (Button)findViewById(R.id.btnAnswer2_Love);
        prompt_Love = (TextView)findViewById(R.id.prompt_Love);
        btnConfirm_Love = (Button)findViewById(R.id.btnConfirm_Love);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Love.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Love[i][0]); //Question
            tmpArray.add(quizData_Love[i][1]); //Background Image 1
            tmpArray.add(quizData_Love[i][2]); //Question Voice Over 1
            tmpArray.add(quizData_Love[i][3]); //Background Image 2
            tmpArray.add(quizData_Love[i][4]); //Question Voice Over 2
            tmpArray.add(quizData_Love[i][5]); //Right Answer
            tmpArray.add(quizData_Love[i][6]); //Wrong Answer
            tmpArray.add(quizData_Love[i][7]); //Choice 1 Voice Over
            tmpArray.add(quizData_Love[i][8]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_Love.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Love.setText("Question #" + quizCount_Love);
        confirmClicked_Love = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Love.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Love.get(randomNum);

        //Set Question and Right Answer

        //Hide question and choices
        quizLayout_Love.setVisibility(View.INVISIBLE);
        countLabel_Love.setVisibility(View.INVISIBLE);
        questionLabel_Love.setVisibility(View.INVISIBLE);
        btnAnswer1_Love.setVisibility(View.INVISIBLE);
        btnAnswer2_Love.setVisibility(View.INVISIBLE);
        btnConfirm_Love.setVisibility(View.INVISIBLE);

        questionLabel_Love.setText(quiz.get(0));
        background_Love.setBackgroundResource(Integer.parseInt(quiz.get(1)));
        voiceover1 = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        background_Question = Integer.parseInt(quiz.get(3));
        voiceover2 = MediaPlayer.create(this, Integer.parseInt(quiz.get(4)));
        voiceover1.start();
        voiceover1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                voiceover1.release();
                voiceover2.start();
                background_Love.setBackgroundResource(background_Question);
                quizLayout_Love.setVisibility(View.VISIBLE);
                countLabel_Love.setVisibility(View.VISIBLE);
                questionLabel_Love.setVisibility(View.VISIBLE);
                btnAnswer1_Love.setVisibility(View.VISIBLE);
                btnAnswer2_Love.setVisibility(View.VISIBLE);
                btnConfirm_Love.setVisibility(View.VISIBLE);
            }
        });
        rightAnswer_Love = quiz.get(5);
        wrongAnswer_Love = quiz.get(6);
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
        btnAnswer1_Love.setText(quiz.get(0));
        btnAnswer2_Love.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Love.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Love){
            btnAnswer1_Love.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Love.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Love){
            btnAnswer2_Love.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Love.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_Love)){
            voiceover1.release();
            voiceover2.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_Love) && answerBtn != btnConfirm_Love){
            voiceover1.release();
            voiceover2.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_Love) && !btnText.equals(wrongAnswer_Love)){
            prompt_Love.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prompt_Love.setText("");
                }
            },3000);

        }
        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Love)){
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
                    rightAnswerCount_Love++;
                    btnConfirm_Love.setEnabled(false);
                    btnAnswer1_Love.setEnabled(false);
                    btnAnswer2_Love.setEnabled(false);
                    confirmClicked_Love++;
                }
                if (btnText.equals(wrongAnswer_Love)) {
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
                    btnConfirm_Love.setEnabled(false);
                    btnAnswer1_Love.setEnabled(false);
                    btnAnswer2_Love.setEnabled(false);
                    confirmClicked_Love++;
                }
                else if (!btnText.equals(rightAnswer_Love) && !btnText.equals(wrongAnswer_Love)){
                    prompt_Love.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Love.setText("");
                        }
                    },3000);
                }
            }
        });

        background_Love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizCount_Love == QUIZ_COUNT && confirmClicked_Love != 0){
                    //Show Result
                    Intent intent = new Intent(getApplicationContext(), ResultsLove.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT_Love", rightAnswerCount_Love);
                    startActivity(intent);
                }
                else if (!btnText.equals(btnAnswer1_Love.getText().toString()) && !btnText.equals(btnAnswer2_Love.getText().toString())){
                    //Check if user selected an answer
                    prompt_Love.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Love.setText("");
                        }
                    },3000);
                }
                else if(confirmClicked_Love == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Love.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Love.setText("");
                        }
                    },3000);
                }
                else{
                    quizCount_Love++;
                    btnAnswer1_Love.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Love.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer1_Love.setEnabled(true);
                    btnAnswer2_Love.setEnabled(true);
                    btnConfirm_Love.setEnabled(true);
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