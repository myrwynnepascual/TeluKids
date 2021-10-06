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

public class QuizResponsibility extends AppCompatActivity {
    private TextView countLabel_Responsibility;
    private TextView questionLabel_Responsibility;
    private TextView prompt_Responsibility;
    private LinearLayout quizLayout_Responsibility;
    private ConstraintLayout background_Responsibility;

    MediaPlayer voiceover1;
    MediaPlayer voiceover2;
    MediaPlayer choice1;
    MediaPlayer choice2;

    int background_Question;

    Button btnAnswer1_Responsibility;
    Button btnAnswer2_Responsibility;
    Button btnConfirm_Responsibility;

    private String rightAnswer_Responsibility;
    private String wrongAnswer_Responsibility;
    private int rightAnswerCount_Responsibility = 0;
    private int quizCount_Responsibility = 1;
    static final private int QUIZ_COUNT = 6;
    private int confirmClicked_Responsibility = 0;


    ArrayList<ArrayList<String>> quizArray_Responsibility = new ArrayList<>();

    String quizData_Responsibility[][] = {
            //{"Question", "Background Image 1", "Question Voice Over 1", "Background Image 2", "Question Voice Over 2" "Right Answer", "Wrong Answer", "Choice 1 Voice Over", "Choice 2 Voice Over"}
            {"What should Marga do?", String.valueOf(R.drawable.rp1bg1), String.valueOf(R.raw.rpq1_1), String.valueOf(R.drawable.rp1bg2), String.valueOf(R.raw.rpq1_2), "Keep up the good work and study harder for math", "Ignore math because she finds it hard", String.valueOf(R.raw.rpq1c1), String.valueOf(R.raw.rpq1c2) },
            {"What should Max do?", String.valueOf(R.drawable.rp2bg1), String.valueOf(R.raw.rpq2_1), String.valueOf(R.drawable.rp2bg2), String.valueOf(R.raw.rpq2_2), "Trust himself and keep moving forward", "Doubt himself and back out", String.valueOf(R.raw.rpq2c1), String.valueOf(R.raw.rpq2c2) },
            {"What should Julie practice?", String.valueOf(R.drawable.rp3bg1), String.valueOf(R.raw.rpq3_1), String.valueOf(R.drawable.rp3bg2), String.valueOf(R.raw.rpq3_2), "Practice good hand washing technique", "Not care about her health at all", String.valueOf(R.raw.rpq3c1), String.valueOf(R.raw.rpq3c2) },
            {"What should Julie do?", String.valueOf(R.drawable.rp4bg1), String.valueOf(R.raw.rpq4_1), String.valueOf(R.drawable.rp4bg2), String.valueOf(R.raw.rpq4_2), "Follow her doctor's instructions", "Refuse to take the vitamins and just sleep", String.valueOf(R.raw.rpq4c1), String.valueOf(R.raw.rpq4c2) },
            {"What should Max do?", String.valueOf(R.drawable.rp5bg1), String.valueOf(R.raw.rpq5_1), String.valueOf(R.drawable.rp5bg2), String.valueOf(R.raw.rpq5_2), "Avoid chocolates and sweets", "Continue to eat chocolates", String.valueOf(R.raw.rpq5c1), String.valueOf(R.raw.rpq5c2) },
            {"What should Marga do?", String.valueOf(R.drawable.rp6bg1), String.valueOf(R.raw.rpq6_1), String.valueOf(R.drawable.rp6bg2), String.valueOf(R.raw.rpq6_2), "Join her family for dinner", "Continue playing games on her gadget", String.valueOf(R.raw.rpq6c1), String.valueOf(R.raw.rpq6c2) },
            {"What should Joey do?", String.valueOf(R.drawable.rp7bg1), String.valueOf(R.raw.rpq7_1), String.valueOf(R.drawable.rp7bg2), String.valueOf(R.raw.rpq7_2), "Get some water for Julie", "Shout at Julie and tell her to get her own water", String.valueOf(R.raw.rpq7c1), String.valueOf(R.raw.rpq7c2) },
            {"What should Julie do?", String.valueOf(R.drawable.rp8bg1), String.valueOf(R.raw.rpq8_1), String.valueOf(R.drawable.rp8bg2), String.valueOf(R.raw.rpq8_2), "Encourage her brother and help him with his homework", "Not care about her little brother", String.valueOf(R.raw.rpq8c1), String.valueOf(R.raw.rpq8c2) }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_responsibility);

        BackgroundSoundService.onPause();

        background_Responsibility = (ConstraintLayout) findViewById(R.id.background_Responsibility);
        quizLayout_Responsibility = (LinearLayout)findViewById(R.id.quizLayout_Responsibility);
        countLabel_Responsibility = (TextView)findViewById(R.id.countLabel_Responsibility);
        questionLabel_Responsibility = (TextView)findViewById(R.id.questionLabel_Responsibility);
        btnAnswer1_Responsibility = (Button)findViewById(R.id.btnAnswer1_Responsibility);
        btnAnswer2_Responsibility = (Button)findViewById(R.id.btnAnswer2_Responsibility);
        prompt_Responsibility = (TextView)findViewById(R.id.prompt_Responsibility);
        btnConfirm_Responsibility = (Button)findViewById(R.id.btnConfirm_Responsibility);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Responsibility.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Responsibility[i][0]); //Question
            tmpArray.add(quizData_Responsibility[i][1]); //Background Image 1
            tmpArray.add(quizData_Responsibility[i][2]); //Question Voice Over 1
            tmpArray.add(quizData_Responsibility[i][3]); //Background Image 2
            tmpArray.add(quizData_Responsibility[i][4]); //Question Voice Over 2
            tmpArray.add(quizData_Responsibility[i][5]); //Right Answer
            tmpArray.add(quizData_Responsibility[i][6]); //Wrong Answer
            tmpArray.add(quizData_Responsibility[i][7]); //Choice 1 Voice Over
            tmpArray.add(quizData_Responsibility[i][8]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_Responsibility.add(tmpArray);
        }
        assessmenttitle();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Responsibility.setText("Question #" + quizCount_Responsibility);
        confirmClicked_Responsibility = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Responsibility.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Responsibility.get(randomNum);

        //Set Question and Right Answer

        //Hide question and choices
        quizLayout_Responsibility.setVisibility(View.INVISIBLE);
        countLabel_Responsibility.setVisibility(View.INVISIBLE);
        questionLabel_Responsibility.setVisibility(View.INVISIBLE);
        btnAnswer1_Responsibility.setVisibility(View.INVISIBLE);
        btnAnswer2_Responsibility.setVisibility(View.INVISIBLE);
        btnConfirm_Responsibility.setVisibility(View.INVISIBLE);
        btnAnswer1_Responsibility.setBackgroundResource(R.drawable.answerbutton);
        btnAnswer2_Responsibility.setBackgroundResource(R.drawable.answerbutton);
        btnAnswer1_Responsibility.setEnabled(true);
        btnAnswer2_Responsibility.setEnabled(true);
        btnConfirm_Responsibility.setEnabled(true);

        questionLabel_Responsibility.setText(quiz.get(0));
        background_Responsibility.setBackgroundResource(Integer.parseInt(quiz.get(1)));
        voiceover1 = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        background_Question = Integer.parseInt(quiz.get(3));
        voiceover2 = MediaPlayer.create(this, Integer.parseInt(quiz.get(4)));
        voiceover1.start();
        voiceover1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                voiceover1.release();
                voiceover2.start();
                background_Responsibility.setBackgroundResource(background_Question);
                quizLayout_Responsibility.setVisibility(View.VISIBLE);
                countLabel_Responsibility.setVisibility(View.VISIBLE);
                questionLabel_Responsibility.setVisibility(View.VISIBLE);
                btnAnswer1_Responsibility.setVisibility(View.VISIBLE);
                btnAnswer2_Responsibility.setVisibility(View.VISIBLE);
                btnConfirm_Responsibility.setVisibility(View.VISIBLE);
            }
        });
        rightAnswer_Responsibility = quiz.get(5);
        wrongAnswer_Responsibility = quiz.get(6);
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
        btnAnswer1_Responsibility.setText(quiz.get(0));
        btnAnswer2_Responsibility.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Responsibility.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Responsibility){
            btnAnswer1_Responsibility.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Responsibility.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Responsibility){
            btnAnswer2_Responsibility.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Responsibility.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_Responsibility)){
            voiceover1.release();
            voiceover2.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_Responsibility) && answerBtn != btnConfirm_Responsibility){
            voiceover1.release();
            voiceover2.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_Responsibility) && !btnText.equals(wrongAnswer_Responsibility)){
            prompt_Responsibility.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prompt_Responsibility.setText("");
                }
            },3000);

        }
        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Responsibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Responsibility)){
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
                    rightAnswerCount_Responsibility++;
                    btnConfirm_Responsibility.setEnabled(false);
                    btnAnswer1_Responsibility.setEnabled(false);
                    btnAnswer2_Responsibility.setEnabled(false);
                    confirmClicked_Responsibility++;
                    quizCount_Responsibility++;
                    if (quizCount_Responsibility == QUIZ_COUNT && confirmClicked_Responsibility != 0){
                        //Show Result
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), ResultsResponsibility.class);
                                intent.putExtra("RIGHT_ANSWER_COUNT_Responsibility", rightAnswerCount_Responsibility);
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
                if (btnText.equals(wrongAnswer_Responsibility)) {
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
                    btnConfirm_Responsibility.setEnabled(false);
                    btnAnswer1_Responsibility.setEnabled(false);
                    btnAnswer2_Responsibility.setEnabled(false);
                    confirmClicked_Responsibility++;
                    quizCount_Responsibility++;
                    if (quizCount_Responsibility == QUIZ_COUNT && confirmClicked_Responsibility != 0){
                        //Show Result
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), ResultsResponsibility.class);
                                intent.putExtra("RIGHT_ANSWER_COUNT_Responsibility", rightAnswerCount_Responsibility);
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
                else if (!btnText.equals(rightAnswer_Responsibility) && !btnText.equals(wrongAnswer_Responsibility)){
                    prompt_Responsibility.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Responsibility.setText("");
                        }
                    },3000);
                }
            }
        });

        background_Responsibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!btnText.equals(btnAnswer1_Responsibility.getText().toString()) && !btnText.equals(btnAnswer2_Responsibility.getText().toString())){
                    //Check if user selected an answer
                    prompt_Responsibility.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Responsibility.setText("");
                        }
                    },3000);
                }
                else if(confirmClicked_Responsibility == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Responsibility.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Responsibility.setText("");
                        }
                    },3000);
                }
            }
        });
    }
    public void assessmenttitle(){
        background_Responsibility.setBackgroundResource(R.drawable.responsibilitytitle);
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