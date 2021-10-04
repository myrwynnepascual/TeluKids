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

public class QuizDoingGood extends AppCompatActivity {
    private TextView countLabel_DoingGood;
    private TextView questionLabel_DoingGood;
    private TextView prompt_DoingGood;
    private LinearLayout quizLayout_DoingGood;
    private ConstraintLayout background_DoingGood;

    MediaPlayer voiceover1;
    MediaPlayer voiceover2;
    MediaPlayer choice1;
    MediaPlayer choice2;

    int background_Question;

    Button btnAnswer1_DoingGood;
    Button btnAnswer2_DoingGood;
    Button btnConfirm_DoingGood;

    private String rightAnswer_DoingGood;
    private String wrongAnswer_DoingGood;
    private int rightAnswerCount_DoingGood = 0;
    private int quizCount_DoingGood = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_DoingGood = 0;


    ArrayList<ArrayList<String>> quizArray_DoingGood = new ArrayList<>();

    String quizData_DoingGood[][] = {
            //{"Question", "Background Image 1", "Question Voice Over 1", "Background Image 2", "Question Voice Over 2" "Right Answer", "Wrong Answer", "Choice 1 Voice Over", "Choice 2 Voice Over"}
            {"What should Max do?", String.valueOf(R.drawable.dg1bg1), String.valueOf(R.raw.dgq1_1), String.valueOf(R.drawable.dg1bg2), String.valueOf(R.raw.dgq1_2), "Bow his head and pray", "Eat the food first", String.valueOf(R.raw.dgq1c1), String.valueOf(R.raw.dgq1c2) },
            {"What should Marga do?", String.valueOf(R.drawable.dg2bg1), String.valueOf(R.raw.dgq2_1), String.valueOf(R.drawable.dg2bg2), String.valueOf(R.raw.dgq2_2), "Pray and ask god for strength", "Cry and give up", String.valueOf(R.raw.dgq2c1), String.valueOf(R.raw.dgq2c2) },
            {"What should Julie do?", String.valueOf(R.drawable.dg3bg1), String.valueOf(R.raw.dgq3_1), String.valueOf(R.drawable.dg3bg2), String.valueOf(R.raw.dgq3_2), "Pray to God for strength to do good", "Back out of the auditions", String.valueOf(R.raw.dgq3c1), String.valueOf(R.raw.dgq3c2) },
            {"What should Joey do?", String.valueOf(R.drawable.o5bg1), String.valueOf(R.raw.dgq4_1), String.valueOf(R.drawable.o5bg2), String.valueOf(R.raw.dgq4_2), "Volunteer and help other people", "Ignore the donation drive", String.valueOf(R.raw.dgq4c1), String.valueOf(R.raw.dgq4c2) },
            {"What should Marga do?", String.valueOf(R.drawable.dg5bg1), String.valueOf(R.raw.dgq5_1), String.valueOf(R.drawable.dg5bg2), String.valueOf(R.raw.dgq5_2), "Pray to God for strength and guidance", "Refuse to go to school tomorrow", String.valueOf(R.raw.dgq5c1), String.valueOf(R.raw.dgq5c2) }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_doinggood);

        BackgroundSoundService.onPause();

        background_DoingGood = (ConstraintLayout) findViewById(R.id.background_DoingGood);
        quizLayout_DoingGood = (LinearLayout)findViewById(R.id.quizLayout_DoingGood);
        countLabel_DoingGood = (TextView)findViewById(R.id.countLabel_DoingGood);
        questionLabel_DoingGood = (TextView)findViewById(R.id.questionLabel_DoingGood);
        btnAnswer1_DoingGood = (Button)findViewById(R.id.btnAnswer1_DoingGood);
        btnAnswer2_DoingGood = (Button)findViewById(R.id.btnAnswer2_DoingGood);
        prompt_DoingGood = (TextView)findViewById(R.id.prompt_DoingGood);
        btnConfirm_DoingGood = (Button)findViewById(R.id.btnConfirm_DoingGood);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_DoingGood.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_DoingGood[i][0]); //Question
            tmpArray.add(quizData_DoingGood[i][1]); //Background Image 1
            tmpArray.add(quizData_DoingGood[i][2]); //Question Voice Over 1
            tmpArray.add(quizData_DoingGood[i][3]); //Background Image 2
            tmpArray.add(quizData_DoingGood[i][4]); //Question Voice Over 2
            tmpArray.add(quizData_DoingGood[i][5]); //Right Answer
            tmpArray.add(quizData_DoingGood[i][6]); //Wrong Answer
            tmpArray.add(quizData_DoingGood[i][7]); //Choice 1 Voice Over
            tmpArray.add(quizData_DoingGood[i][8]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_DoingGood.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_DoingGood.setText("Question #" + quizCount_DoingGood);
        confirmClicked_DoingGood = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_DoingGood.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_DoingGood.get(randomNum);

        //Set Question and Right Answer

        //Hide question and choices
        quizLayout_DoingGood.setVisibility(View.INVISIBLE);
        countLabel_DoingGood.setVisibility(View.INVISIBLE);
        questionLabel_DoingGood.setVisibility(View.INVISIBLE);
        btnAnswer1_DoingGood.setVisibility(View.INVISIBLE);
        btnAnswer2_DoingGood.setVisibility(View.INVISIBLE);
        btnConfirm_DoingGood.setVisibility(View.INVISIBLE);

        questionLabel_DoingGood.setText(quiz.get(0));
        background_DoingGood.setBackgroundResource(Integer.parseInt(quiz.get(1)));
        voiceover1 = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        background_Question = Integer.parseInt(quiz.get(3));
        voiceover2 = MediaPlayer.create(this, Integer.parseInt(quiz.get(4)));
        voiceover1.start();
        voiceover1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                voiceover1.release();
                voiceover2.start();
                background_DoingGood.setBackgroundResource(background_Question);
                quizLayout_DoingGood.setVisibility(View.VISIBLE);
                countLabel_DoingGood.setVisibility(View.VISIBLE);
                questionLabel_DoingGood.setVisibility(View.VISIBLE);
                btnAnswer1_DoingGood.setVisibility(View.VISIBLE);
                btnAnswer2_DoingGood.setVisibility(View.VISIBLE);
                btnConfirm_DoingGood.setVisibility(View.VISIBLE);
            }
        });
        rightAnswer_DoingGood = quiz.get(5);
        wrongAnswer_DoingGood = quiz.get(6);
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
        btnAnswer1_DoingGood.setText(quiz.get(0));
        btnAnswer2_DoingGood.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_DoingGood.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_DoingGood){
            btnAnswer1_DoingGood.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_DoingGood.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_DoingGood){
            btnAnswer2_DoingGood.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_DoingGood.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_DoingGood)){
            voiceover1.release();
            voiceover2.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_DoingGood) && answerBtn != btnConfirm_DoingGood){
            voiceover1.release();
            voiceover2.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_DoingGood) && !btnText.equals(wrongAnswer_DoingGood)){
            prompt_DoingGood.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prompt_DoingGood.setText("");
                }
            },3000);

        }
        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_DoingGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_DoingGood)){
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
                    rightAnswerCount_DoingGood++;
                    btnConfirm_DoingGood.setEnabled(false);
                    btnAnswer1_DoingGood.setEnabled(false);
                    btnAnswer2_DoingGood.setEnabled(false);
                    confirmClicked_DoingGood++;
                }
                if (btnText.equals(wrongAnswer_DoingGood)) {
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
                    btnConfirm_DoingGood.setEnabled(false);
                    btnAnswer1_DoingGood.setEnabled(false);
                    btnAnswer2_DoingGood.setEnabled(false);
                    confirmClicked_DoingGood++;
                }
                else if (!btnText.equals(rightAnswer_DoingGood) && !btnText.equals(wrongAnswer_DoingGood)){
                    prompt_DoingGood.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_DoingGood.setText("");
                        }
                    },3000);
                }
            }
        });

        background_DoingGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizCount_DoingGood == QUIZ_COUNT && confirmClicked_DoingGood != 0){
                    //Show Result
                    Intent intent = new Intent(getApplicationContext(), ResultsDoingGood.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT_DoingGood", rightAnswerCount_DoingGood);
                    startActivity(intent);
                }
                else if (!btnText.equals(btnAnswer1_DoingGood.getText().toString()) && !btnText.equals(btnAnswer2_DoingGood.getText().toString())){
                    //Check if user selected an answer
                    prompt_DoingGood.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_DoingGood.setText("");
                        }
                    },3000);
                }
                else if(confirmClicked_DoingGood == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_DoingGood.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_DoingGood.setText("");
                        }
                    },3000);
                }
                else{
                    quizCount_DoingGood++;
                    btnAnswer1_DoingGood.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_DoingGood.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer1_DoingGood.setEnabled(true);
                    btnAnswer2_DoingGood.setEnabled(true);
                    btnConfirm_DoingGood.setEnabled(true);
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