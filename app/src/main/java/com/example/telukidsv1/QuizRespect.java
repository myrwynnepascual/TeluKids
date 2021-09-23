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

public class QuizRespect extends AppCompatActivity {
    private TextView countLabel_Respect;
    private TextView questionLabel_Respect;
    private TextView prompt_Respect;
    private LinearLayout quizLayout_Respect;
    private ConstraintLayout background_Respect;

    MediaPlayer voiceover1;
    MediaPlayer voiceover2;
    MediaPlayer choice1;
    MediaPlayer choice2;

    int background_Question;

    Button btnAnswer1_Respect;
    Button btnAnswer2_Respect;
    Button btnConfirm_Respect;

    private String rightAnswer_Respect;
    private String wrongAnswer_Respect;
    private int rightAnswerCount_Respect = 0;
    private int quizCount_Respect = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Respect = 0;


    ArrayList<ArrayList<String>> quizArray_Respect = new ArrayList<>();

    String quizData_Respect[][] = {
            //{"Question", "Background Image 1", "Question Voice Over 1", "Background Image 2", "Question Voice Over 2" "Right Answer", "Wrong Answer", "Choice 1 Voice Over", "Choice 2 Voice Over"}
            {"What should Marga do?", String.valueOf(R.drawable.r1n2bg1), String.valueOf(R.raw.rq1_1), String.valueOf(R.drawable.r1n2bg2), String.valueOf(R.raw.rq1_2), "Listen to her teacher", "Talk to her seatmates", String.valueOf(R.raw.rq1c1), String.valueOf(R.raw.rq1c2) },
            {"What should Marga do?", String.valueOf(R.drawable.r1n2bg1), String.valueOf(R.raw.rq2_1), String.valueOf(R.drawable.r1n2bg2), String.valueOf(R.raw.rq2_2), "Wait for the teacher to finish and raise a hand to ask a question ", "Interrupt the teacher and shout the question", String.valueOf(R.raw.rq2c1), String.valueOf(R.raw.rq2c2) },
            {"What should Marga do?", String.valueOf(R.drawable.r3n4bg1), String.valueOf(R.raw.rq3_1), String.valueOf(R.drawable.r3n4bg2), String.valueOf(R.raw.rq3_2), "Start calling him Joey", "Ignore him and call him a funny name", String.valueOf(R.raw.rq3c1), String.valueOf(R.raw.rq3c2) },
            {"What should Joey do?", String.valueOf(R.drawable.r3n4bg1), String.valueOf(R.raw.rq4_1), String.valueOf(R.drawable.r3n4bg2), String.valueOf(R.raw.rq4_2), "Apologize to Marga and call her right by her name", "Ignore Marga and pretend nothing happened", String.valueOf(R.raw.rq4c1), String.valueOf(R.raw.rq4c2)},
            {"What should Julie do?", String.valueOf(R.drawable.r5bg1), String.valueOf(R.raw.rq5_1), String.valueOf(R.drawable.r5bg2), String.valueOf(R.raw.rq5_2), "Stand properly and put her hand on her chest", "Talk with her classmate", String.valueOf(R.raw.rq5c1), String.valueOf(R.raw.rq5c2) }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_respect);

        background_Respect = (ConstraintLayout) findViewById(R.id.background_Respect);
        quizLayout_Respect = (LinearLayout)findViewById(R.id.quizLayout_Respect);
        countLabel_Respect = (TextView)findViewById(R.id.countLabel_Respect);
        questionLabel_Respect = (TextView)findViewById(R.id.questionLabel_Respect);
        btnAnswer1_Respect = (Button)findViewById(R.id.btnAnswer1_Respect);
        btnAnswer2_Respect = (Button)findViewById(R.id.btnAnswer2_Respect);
        prompt_Respect = (TextView)findViewById(R.id.prompt_Respect);
        btnConfirm_Respect = (Button)findViewById(R.id.btnConfirm_Respect);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Respect.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Respect[i][0]); //Question
            tmpArray.add(quizData_Respect[i][1]); //Background Image 1
            tmpArray.add(quizData_Respect[i][2]); //Question Voice Over 1
            tmpArray.add(quizData_Respect[i][3]); //Background Image 2
            tmpArray.add(quizData_Respect[i][4]); //Question Voice Over 2
            tmpArray.add(quizData_Respect[i][5]); //Right Answer
            tmpArray.add(quizData_Respect[i][6]); //Wrong Answer
            tmpArray.add(quizData_Respect[i][7]); //Choice 1 Voice Over
            tmpArray.add(quizData_Respect[i][8]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_Respect.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Respect.setText("Question #" + quizCount_Respect);
        confirmClicked_Respect = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Respect.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Respect.get(randomNum);

        //Set Question and Right Answer

        //Hide question and choices
        quizLayout_Respect.setVisibility(View.INVISIBLE);
        countLabel_Respect.setVisibility(View.INVISIBLE);
        questionLabel_Respect.setVisibility(View.INVISIBLE);
        btnAnswer1_Respect.setVisibility(View.INVISIBLE);
        btnAnswer2_Respect.setVisibility(View.INVISIBLE);
        btnConfirm_Respect.setVisibility(View.INVISIBLE);

        questionLabel_Respect.setText(quiz.get(0));
        background_Respect.setBackgroundResource(Integer.parseInt(quiz.get(1)));
        voiceover1 = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        background_Question = Integer.parseInt(quiz.get(3));
        voiceover2 = MediaPlayer.create(this, Integer.parseInt(quiz.get(4)));
        voiceover1.start();
        voiceover1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                voiceover1.release();
                voiceover2.start();
                background_Respect.setBackgroundResource(background_Question);
                quizLayout_Respect.setVisibility(View.VISIBLE);
                countLabel_Respect.setVisibility(View.VISIBLE);
                questionLabel_Respect.setVisibility(View.VISIBLE);
                btnAnswer1_Respect.setVisibility(View.VISIBLE);
                btnAnswer2_Respect.setVisibility(View.VISIBLE);
                btnConfirm_Respect.setVisibility(View.VISIBLE);
            }
        });
        rightAnswer_Respect = quiz.get(5);
        wrongAnswer_Respect = quiz.get(6);
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
        btnAnswer1_Respect.setText(quiz.get(0));
        btnAnswer2_Respect.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Respect.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Respect){
            btnAnswer1_Respect.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Respect.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Respect){
            btnAnswer2_Respect.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Respect.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_Respect)){
            voiceover1.release();
            voiceover2.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_Respect) && answerBtn != btnConfirm_Respect){
            voiceover1.release();
            voiceover2.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_Respect) && !btnText.equals(wrongAnswer_Respect)){
            prompt_Respect.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prompt_Respect.setText("");
                }
            },3000);

        }
        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Respect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Respect)){
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
                    rightAnswerCount_Respect++;
                    btnConfirm_Respect.setEnabled(false);
                    btnAnswer1_Respect.setEnabled(false);
                    btnAnswer2_Respect.setEnabled(false);
                    confirmClicked_Respect++;
                }
                if (btnText.equals(wrongAnswer_Respect)) {
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
                    btnConfirm_Respect.setEnabled(false);
                    btnAnswer1_Respect.setEnabled(false);
                    btnAnswer2_Respect.setEnabled(false);
                    confirmClicked_Respect++;
                }
                else if (!btnText.equals(rightAnswer_Respect) && !btnText.equals(wrongAnswer_Respect)){
                    prompt_Respect.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Respect.setText("");
                        }
                    },3000);
                }
            }
        });

        background_Respect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizCount_Respect == QUIZ_COUNT && confirmClicked_Respect != 0){
                    //Show Result
                    Intent intent = new Intent(getApplicationContext(), ResultsRespect.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT_Respect", rightAnswerCount_Respect);
                    startActivity(intent);
                }
                else if (!btnText.equals(btnAnswer1_Respect.getText().toString()) && !btnText.equals(btnAnswer2_Respect.getText().toString())){
                    //Check if user selected an answer
                    prompt_Respect.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Respect.setText("");
                        }
                    },3000);
                }
                else if(confirmClicked_Respect == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Respect.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Respect.setText("");
                        }
                    },3000);
                }
                else{
                    quizCount_Respect++;
                    btnAnswer1_Respect.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Respect.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer1_Respect.setEnabled(true);
                    btnAnswer2_Respect.setEnabled(true);
                    btnConfirm_Respect.setEnabled(true);
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