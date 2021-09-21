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

public class QuizCountingNumbers extends AppCompatActivity {
    private TextView countLabel_Counting;
    private TextView questionLabel_Counting;
    private TextView prompt_Counting;
    private ImageView imgQuestion_Counting;
    private LinearLayout quizLayout_Counting;

    MediaPlayer voiceover;
    MediaPlayer choice1;
    MediaPlayer choice2;

    Button btnAnswer1_Counting;
    Button btnAnswer2_Counting;
    Button btnConfirm_Counting;

    private String rightAnswer_Counting;
    private String wrongAnswer_Counting;
    private int rightAnswerCount_Counting = 0;
    private int quizCount_Counting = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Counting = 0;


    ArrayList<ArrayList<String>> quizArray_Counting = new ArrayList<>();

    String quizData_Counting[][] = {
            //{"Question", "Image", "Question Voiceover", "Right Answer", "Wrong Answer", "Choice 1 Voice Over", "Choice 2 Voice Over"}
            {"How many boxes of crayons are there?", String.valueOf(R.drawable.countingnumbersquestion1), String.valueOf(R.raw.ctq1), "5 boxes of crayons", "6 boxes of crayons", String.valueOf(R.raw.ctq1c1), String.valueOf(R.raw.ctq1c2) },
            { "How many apples and bananas are there?", String.valueOf(R.drawable.countingnumbersquestion2), String.valueOf(R.raw.ctq2), "4 Bananas and 3 apples", "1 Banana and 2 Apples", String.valueOf(R.raw.ctq2c1), String.valueOf(R.raw.ctq2c2)},
            {"How many  boxes of chocolates are there?", String.valueOf(R.drawable.countingnumbersquestion3), String.valueOf(R.raw.ctq3), "10 Boxes of Chocolates", "15 Boxes of Chocolates", String.valueOf(R.raw.ctq3c1), String.valueOf(R.raw.ctq3c2)},
            {"How many bumblebees and cups are there?", String.valueOf(R.drawable.countingnumbersquestion4), String.valueOf(R.raw.ctq4), "7 Bumblebees and 8 Cups", "9 Bumblebees and 13 Cups", String.valueOf(R.raw.ctq4c1), String.valueOf(R.raw.ctq4c2)},
            {"How many balloons are there?", String.valueOf(R.drawable.countingnumbersquestion5), String.valueOf(R.raw.ctq5), "18 Balloons", "14 Balloons", String.valueOf(R.raw.ctq5c1), String.valueOf(R.raw.ctq5c2)}

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_countingnumbers);


        quizLayout_Counting = (LinearLayout)findViewById(R.id.quizLayout_Counting);
        imgQuestion_Counting =  (ImageView)findViewById(R.id.imgQuestion_Counting);
        countLabel_Counting = (TextView)findViewById(R.id.countLabel_Counting);
        questionLabel_Counting = (TextView)findViewById(R.id.questionLabel_Counting);
        prompt_Counting = (TextView)findViewById(R.id.prompt_Counting);
        btnAnswer1_Counting = (Button)findViewById(R.id.btnAnswer1_Counting);
        btnAnswer2_Counting = (Button)findViewById(R.id.btnAnswer2_Counting);
        btnConfirm_Counting = (Button)findViewById(R.id.btnConfirm_Counting);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Counting.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Counting[i][0]); //Question
            tmpArray.add(quizData_Counting[i][1]); //Image
            tmpArray.add(quizData_Counting[i][2]); //Voice Over
            tmpArray.add(quizData_Counting[i][3]); //Right Answer
            tmpArray.add(quizData_Counting[i][4]); //Wrong Answer
            tmpArray.add(quizData_Counting[i][5]); //Choice 1 Voice Over
            tmpArray.add(quizData_Counting[i][6]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_Counting.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Counting.setText("Question #" + quizCount_Counting);
        confirmClicked_Counting = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Counting.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Counting.get(randomNum);

        //Set Question and Right Answer
        questionLabel_Counting.setText(quiz.get(0));
        imgQuestion_Counting.setImageResource(Integer.parseInt(quiz.get(1)));
        voiceover = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        voiceover.start();
        rightAnswer_Counting = quiz.get(3);
        wrongAnswer_Counting = quiz.get(4);
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
        btnAnswer1_Counting.setText(quiz.get(0));
        btnAnswer2_Counting.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Counting.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Counting){
            btnAnswer1_Counting.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Counting.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Counting){
            btnAnswer2_Counting.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Counting.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_Counting)){
            voiceover.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_Counting) && answerBtn != btnConfirm_Counting){
            voiceover.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_Counting) && !btnText.equals(wrongAnswer_Counting)){
            prompt_Counting.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prompt_Counting.setText("");
                }
            },3000);

        }

        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Counting)){
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
                    rightAnswerCount_Counting++;
                    btnConfirm_Counting.setEnabled(false);
                    btnAnswer1_Counting.setEnabled(false);
                    btnAnswer2_Counting.setEnabled(false);
                    confirmClicked_Counting++;
                }
                else if (btnText.equals(wrongAnswer_Counting) && answerBtn != btnConfirm_Counting) {
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
                    btnConfirm_Counting.setEnabled(false);
                    btnAnswer1_Counting.setEnabled(false);
                    btnAnswer2_Counting.setEnabled(false);
                    confirmClicked_Counting++;
                }
                else if (!btnText.equals(rightAnswer_Counting) && !btnText.equals(wrongAnswer_Counting)){
                    prompt_Counting.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Counting.setText("");
                        }
                    },3000);
                }
            }
        });

        quizLayout_Counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizCount_Counting == QUIZ_COUNT && confirmClicked_Counting != 0){
                    //Show Result
                    Intent intent = new Intent(getApplicationContext(), ResultsCountingNumbers.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT_Counting", rightAnswerCount_Counting);
                    startActivity(intent);
                }
                else if (!btnText.equals(btnAnswer1_Counting.getText().toString()) && !btnText.equals(btnAnswer2_Counting.getText().toString())){
                    //Check if user selected an answer
                    prompt_Counting.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Counting.setText("");
                        }
                    },3000);

                }
                else if(confirmClicked_Counting == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Counting.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Counting.setText("");
                        }
                    },3000);
                }
                else{
                    quizCount_Counting++;
                    btnAnswer1_Counting.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Counting.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer1_Counting.setEnabled(true);
                    btnAnswer2_Counting.setEnabled(true);
                    btnConfirm_Counting.setEnabled(true);
                    voiceover.release();
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