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

public class QuizDiscipline extends AppCompatActivity {
    private TextView countLabel_Discipline;
    private TextView questionLabel_Discipline;
    private TextView prompt_Discipline;
    private LinearLayout quizLayout_Discipline;
    private ConstraintLayout background_Discipline;

    MediaPlayer voiceover1;
    MediaPlayer voiceover2;
    MediaPlayer choice1;
    MediaPlayer choice2;

    int background_Question;

    Button btnAnswer1_Discipline;
    Button btnAnswer2_Discipline;
    Button btnConfirm_Discipline;

    private String rightAnswer_Discipline;
    private String wrongAnswer_Discipline;
    private int rightAnswerCount_Discipline = 0;
    private int quizCount_Discipline = 1;
    static final private int QUIZ_COUNT = 6;
    private int confirmClicked_Discipline = 0;


    ArrayList<ArrayList<String>> quizArray_Discipline = new ArrayList<>();

    String quizData_Discipline[][] = {
            //{"Question", "Background Image 1", "Question Voice Over 1", "Background Image 2", "Question Voice Over 2" "Right Answer", "Wrong Answer", "Choice 1 Voice Over", "Choice 2 Voice Over"}
            {"What should Joey do?", String.valueOf(R.drawable.d1bg1), String.valueOf(R.raw.dq1_1), String.valueOf(R.drawable.d1bg2), String.valueOf(R.raw.dq1_2), "Start coloring his drawing ", "Go around the classroom and talk to his seatmates", String.valueOf(R.raw.dq1c1), String.valueOf(R.raw.dq1c2) },
            {"What should Joey do?", String.valueOf(R.drawable.d2bg1), String.valueOf(R.raw.dq2_1), String.valueOf(R.drawable.d2bg2), String.valueOf(R.raw.dq2_2), "Clean up his toys", "Leave his toys on the floor", String.valueOf(R.raw.dq2c1), String.valueOf(R.raw.dq2c2) },
            {"What should Julie do?", String.valueOf(R.drawable.d3bg1), String.valueOf(R.raw.dq3_1), String.valueOf(R.drawable.d3bg2), String.valueOf(R.raw.dq3_2), "Patiently wait for her turn", "Become grumpy for waiting in line", String.valueOf(R.raw.dq3c1), String.valueOf(R.raw.dq3c2) },
            {"What should Max do?", String.valueOf(R.drawable.d4bg1), String.valueOf(R.raw.dq4_1), String.valueOf(R.drawable.d4bg2), String.valueOf(R.raw.dq4_2), "Tell his parents the truth that he is sad because he failed his exam", "Keep his feelings to himself and tell his parents that everything is okay", String.valueOf(R.raw.dq4c1), String.valueOf(R.raw.dq4c2) },
            {"What should Marga do?", String.valueOf(R.drawable.d5bg1), String.valueOf(R.raw.dq5_1), String.valueOf(R.drawable.d5bg2), String.valueOf(R.raw.dq5_2), "Pick up the piece of paper and throw it in the trash", "Ignore the piece of paper", String.valueOf(R.raw.dq5c1), String.valueOf(R.raw.dq5c2) },
            {"What should Marga do?", String.valueOf(R.drawable.d6bg1), String.valueOf(R.raw.dq6_1), String.valueOf(R.drawable.d6bg2), String.valueOf(R.raw.dq6_2), "Tell her mom she wants to do it by herself and brushes her teeth", "Let her mom brush her teeth", String.valueOf(R.raw.dq6c1), String.valueOf(R.raw.dq6c2) }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_discipline);

        BackgroundSoundService.onPause();

        background_Discipline = (ConstraintLayout) findViewById(R.id.background_Discipline);
        quizLayout_Discipline = (LinearLayout)findViewById(R.id.quizLayout_Discipline);
        countLabel_Discipline = (TextView)findViewById(R.id.countLabel_Discipline);
        questionLabel_Discipline = (TextView)findViewById(R.id.questionLabel_Discipline);
        btnAnswer1_Discipline = (Button)findViewById(R.id.btnAnswer1_Discipline);
        btnAnswer2_Discipline = (Button)findViewById(R.id.btnAnswer2_Discipline);
        prompt_Discipline = (TextView)findViewById(R.id.prompt_Discipline);
        btnConfirm_Discipline = (Button)findViewById(R.id.btnConfirm_Discipline);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Discipline.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Discipline[i][0]); //Question
            tmpArray.add(quizData_Discipline[i][1]); //Background Image 1
            tmpArray.add(quizData_Discipline[i][2]); //Question Voice Over 1
            tmpArray.add(quizData_Discipline[i][3]); //Background Image 2
            tmpArray.add(quizData_Discipline[i][4]); //Question Voice Over 2
            tmpArray.add(quizData_Discipline[i][5]); //Right Answer
            tmpArray.add(quizData_Discipline[i][6]); //Wrong Answer
            tmpArray.add(quizData_Discipline[i][7]); //Choice 1 Voice Over
            tmpArray.add(quizData_Discipline[i][8]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_Discipline.add(tmpArray);
        }
        assessmenttitle();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Discipline.setText("Question #" + quizCount_Discipline);
        confirmClicked_Discipline = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Discipline.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Discipline.get(randomNum);

        //Set Question and Right Answer

        //Hide question and choices
        quizLayout_Discipline.setVisibility(View.INVISIBLE);
        countLabel_Discipline.setVisibility(View.INVISIBLE);
        questionLabel_Discipline.setVisibility(View.INVISIBLE);
        btnAnswer1_Discipline.setVisibility(View.INVISIBLE);
        btnAnswer2_Discipline.setVisibility(View.INVISIBLE);
        btnConfirm_Discipline.setVisibility(View.INVISIBLE);
        btnAnswer1_Discipline.setBackgroundResource(R.drawable.answerbutton);
        btnAnswer2_Discipline.setBackgroundResource(R.drawable.answerbutton);
        btnAnswer1_Discipline.setEnabled(true);
        btnAnswer2_Discipline.setEnabled(true);
        btnConfirm_Discipline.setEnabled(true);

        questionLabel_Discipline.setText(quiz.get(0));
        background_Discipline.setBackgroundResource(Integer.parseInt(quiz.get(1)));
        voiceover1 = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        background_Question = Integer.parseInt(quiz.get(3));
        voiceover2 = MediaPlayer.create(this, Integer.parseInt(quiz.get(4)));
        voiceover1.start();
        voiceover1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                voiceover1.release();
                voiceover2.start();
                background_Discipline.setBackgroundResource(background_Question);
                quizLayout_Discipline.setVisibility(View.VISIBLE);
                countLabel_Discipline.setVisibility(View.VISIBLE);
                questionLabel_Discipline.setVisibility(View.VISIBLE);
                btnAnswer1_Discipline.setVisibility(View.VISIBLE);
                btnAnswer2_Discipline.setVisibility(View.VISIBLE);
                btnConfirm_Discipline.setVisibility(View.VISIBLE);
            }
        });
        rightAnswer_Discipline = quiz.get(5);
        wrongAnswer_Discipline = quiz.get(6);
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
        btnAnswer1_Discipline.setText(quiz.get(0));
        btnAnswer2_Discipline.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Discipline.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Discipline){
            btnAnswer1_Discipline.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Discipline.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Discipline){
            btnAnswer2_Discipline.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Discipline.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_Discipline)){
            voiceover1.release();
            voiceover2.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_Discipline) && answerBtn != btnConfirm_Discipline){
            voiceover1.release();
            voiceover2.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_Discipline) && !btnText.equals(wrongAnswer_Discipline)){
            prompt_Discipline.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prompt_Discipline.setText("");
                }
            },3000);

        }
        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Discipline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Discipline)){
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
                    rightAnswerCount_Discipline++;
                    btnConfirm_Discipline.setEnabled(false);
                    btnAnswer1_Discipline.setEnabled(false);
                    btnAnswer2_Discipline.setEnabled(false);
                    confirmClicked_Discipline++;
                    quizCount_Discipline++;
                    if (quizCount_Discipline == QUIZ_COUNT && confirmClicked_Discipline != 0){
                        //Show Result
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), ResultsDiscipline.class);
                                intent.putExtra("RIGHT_ANSWER_COUNT_Discipline", rightAnswerCount_Discipline);
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
                if (btnText.equals(wrongAnswer_Discipline)) {
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
                    btnConfirm_Discipline.setEnabled(false);
                    btnAnswer1_Discipline.setEnabled(false);
                    btnAnswer2_Discipline.setEnabled(false);
                    confirmClicked_Discipline++;
                    quizCount_Discipline++;
                    if (quizCount_Discipline == QUIZ_COUNT && confirmClicked_Discipline != 0){
                        //Show Result
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), ResultsDiscipline.class);
                                intent.putExtra("RIGHT_ANSWER_COUNT_Discipline", rightAnswerCount_Discipline);
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
                else if (!btnText.equals(rightAnswer_Discipline) && !btnText.equals(wrongAnswer_Discipline)){
                    prompt_Discipline.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Discipline.setText("");
                        }
                    },3000);
                }
            }
        });

        background_Discipline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!btnText.equals(btnAnswer1_Discipline.getText().toString()) && !btnText.equals(btnAnswer2_Discipline.getText().toString())){
                    //Check if user selected an answer
                    prompt_Discipline.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Discipline.setText("");
                        }
                    },3000);
                }
                else if(confirmClicked_Discipline == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Discipline.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Discipline.setText("");
                        }
                    },3000);
                }
            }
        });
    }

    public void assessmenttitle(){
        background_Discipline.setBackgroundResource(R.drawable.disciplinetitle);
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