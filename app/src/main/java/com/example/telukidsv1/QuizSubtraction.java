package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizSubtraction extends AppCompatActivity {
    private TextView countLabel_Subtraction;
    private TextView questionLabel_Subtraction;
    private TextView prompt_Subtraction;
    private ImageView imgQuestion_Subtraction;
    private LinearLayout quizLayout_Subtraction;

    MediaPlayer voiceover;
    MediaPlayer choice1;
    MediaPlayer choice2;

    Button btnAnswer1_Subtraction;
    Button btnAnswer2_Subtraction;
    Button btnConfirm_Subtraction;

    private String rightAnswer_Subtraction;
    private String wrongAnswer_Subtraction;
    private int rightAnswerCount_Subtraction = 0;
    private int quizCount_Subtraction = 1;
    static final private int QUIZ_COUNT = 6;
    private int confirmClicked_Subtraction = 0;


    ArrayList<ArrayList<String>> quizArray_Subtraction = new ArrayList<>();

    String quizData_Subtraction[][] = {
            //{"Question", "Image", "Question Voice Over" "Right Answer", "Wrong Answer", "Choice 1 Voice Over",  "Choice 2 Voice Over"}
            {"What is 6 boxes of crayons minus 5 boxes of crayons equal to?", String.valueOf(R.drawable.subtractionquestion1), String.valueOf(R.raw.sbq1), "1 Box of Crayons", "2 Boxes of Crayons", String.valueOf(R.raw.sbq1c1), String.valueOf(R.raw.sbq1c2)},
            { "What is 4 pineapples minus 2 pineapples equal to?", String.valueOf(R.drawable.subtractionquestion2), String.valueOf(R.raw.sbq2), "2 Pineapples", "6 Pineapples", String.valueOf(R.raw.sbq2c1), String.valueOf(R.raw.sbq2c2)},
            {"If you have 5 bow ties and you gave away 3 bow ties, how many are left?", String.valueOf(R.drawable.subtractionquestion3), String.valueOf(R.raw.sbq3), "2 Bow Ties", "5 Bow Ties", String.valueOf(R.raw.sbq3c1), String.valueOf(R.raw.sbq3c2)},
            {"If you have 4 pumpkins then someone takes away 1 pumpkin, how many pumpkins are left?", String.valueOf(R.drawable.subtractionquestion4), String.valueOf(R.raw.sbq4), "3 Pumpkins", "5 Pumpkins", String.valueOf(R.raw.sbq4c1), String.valueOf(R.raw.sbq4c2)},
            {"What is 3 frogs minus 2 frogs", String.valueOf(R.drawable.subtractionquestion5), String.valueOf(R.raw.sbq5), "1 Frog", "5 Frogs", String.valueOf(R.raw.sbq5c1), String.valueOf(R.raw.sbq5c2)}

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_subtraction);

        BackgroundSoundService.onPause();


        quizLayout_Subtraction = (LinearLayout)findViewById(R.id.quizLayout_Subtraction);
        imgQuestion_Subtraction =  (ImageView)findViewById(R.id.imgQuestion_Subtraction);
        countLabel_Subtraction = (TextView)findViewById(R.id.countLabel_Subtraction);
        questionLabel_Subtraction = (TextView)findViewById(R.id.questionLabel_Subtraction);
        prompt_Subtraction = (TextView)findViewById(R.id.prompt_Subtraction);
        btnAnswer1_Subtraction = (Button)findViewById(R.id.btnAnswer1_Subtraction);
        btnAnswer2_Subtraction = (Button)findViewById(R.id.btnAnswer2_Subtraction);
        btnConfirm_Subtraction = (Button)findViewById(R.id.btnConfirm_Subtraction);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Subtraction.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Subtraction[i][0]); //Question
            tmpArray.add(quizData_Subtraction[i][1]); //Image
            tmpArray.add(quizData_Subtraction[i][2]); //Voice Over
            tmpArray.add(quizData_Subtraction[i][3]); //Right Answer
            tmpArray.add(quizData_Subtraction[i][4]); //Wrong Answer
            tmpArray.add(quizData_Subtraction[i][5]); //Choice 1 Voice Over
            tmpArray.add(quizData_Subtraction[i][6]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_Subtraction.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
        btnAnswer1_Subtraction.setBackgroundResource(R.drawable.answerbutton);
        btnAnswer2_Subtraction.setBackgroundResource(R.drawable.answerbutton);
        btnAnswer1_Subtraction.setEnabled(true);
        btnAnswer2_Subtraction.setEnabled(true);
        btnConfirm_Subtraction.setEnabled(true);

        //Update quizCountLabel
        countLabel_Subtraction.setText("Question #" + quizCount_Subtraction);
        confirmClicked_Subtraction = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Subtraction.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Subtraction.get(randomNum);

        //Set Question and Right Answer
        questionLabel_Subtraction.setText(quiz.get(0));
        imgQuestion_Subtraction.setImageResource(Integer.parseInt(quiz.get(1)));
        voiceover = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        voiceover.start();
        rightAnswer_Subtraction = quiz.get(3);
        wrongAnswer_Subtraction = quiz.get(4);
        choice1 = MediaPlayer.create(this, Integer.parseInt(quiz.get(5)));
        choice2 = MediaPlayer.create(this, Integer.parseInt(quiz.get(6)));

        //Shuffle Choices
        quiz.remove(0);
        quiz.remove(0);
        quiz.remove(0);
        quiz.remove(2);
        quiz.remove(2);
        Collections.shuffle(quiz);

        //Set Choices
        btnAnswer1_Subtraction.setText(quiz.get(0));
        btnAnswer2_Subtraction.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Subtraction.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Subtraction){
            btnAnswer1_Subtraction.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Subtraction.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Subtraction){
            btnAnswer2_Subtraction.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Subtraction.setBackgroundResource(R.drawable.answerbutton);
        }


        if (answerBtn.getText().equals(rightAnswer_Subtraction)){
            voiceover.release();
            choice1.start();
        }
        else if (answerBtn.getText().equals(wrongAnswer_Subtraction) && answerBtn != btnConfirm_Subtraction){
            voiceover.release();
            choice2.start();
        }
        else if (!btnText.equals(rightAnswer_Subtraction) && !btnText.equals(wrongAnswer_Subtraction)){
            prompt_Subtraction.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prompt_Subtraction.setText("");
                }
            },3000);

        }

        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Subtraction)){
                    //Correct
                    voiceover.release();
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
                    rightAnswerCount_Subtraction++;
                    btnConfirm_Subtraction.setEnabled(false);
                    btnAnswer1_Subtraction.setEnabled(false);
                    btnAnswer2_Subtraction.setEnabled(false);
                    confirmClicked_Subtraction++;
                    quizCount_Subtraction++;
                    if (quizCount_Subtraction == QUIZ_COUNT && confirmClicked_Subtraction != 0){
                        //Show Result
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), ResultsSubtraction.class);
                                intent.putExtra("RIGHT_ANSWER_COUNT_Subtraction", rightAnswerCount_Subtraction);
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
                else if (btnText.equals(wrongAnswer_Subtraction)) {
                    //Wrong
                    voiceover.release();
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
                    btnConfirm_Subtraction.setEnabled(false);
                    btnAnswer1_Subtraction.setEnabled(false);
                    btnAnswer2_Subtraction.setEnabled(false);
                    confirmClicked_Subtraction++;
                    quizCount_Subtraction++;
                    if (quizCount_Subtraction == QUIZ_COUNT && confirmClicked_Subtraction != 0){
                        //Show Result
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), ResultsSubtraction.class);
                                intent.putExtra("RIGHT_ANSWER_COUNT_Subtraction", rightAnswerCount_Subtraction);
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
                else if (!btnText.equals(rightAnswer_Subtraction) && !btnText.equals(wrongAnswer_Subtraction)){
                    prompt_Subtraction.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Subtraction.setText("");
                        }
                    },3000);
                }
            }
        });

        quizLayout_Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!btnText.equals(btnAnswer1_Subtraction.getText().toString()) && !btnText.equals(btnAnswer2_Subtraction.getText().toString())){
                    //Check if user selected an answer
                    //Toast.makeText(getApplicationContext(),"Please Select an Answer",Toast.LENGTH_LONG).show();
                    prompt_Subtraction.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Subtraction.setText("");
                        }
                    },3000);

                }
                else if(confirmClicked_Subtraction == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Subtraction.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Subtraction.setText("");
                        }
                    },3000);
                }
            }

        });

    }
}