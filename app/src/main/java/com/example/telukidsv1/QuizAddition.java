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

public class QuizAddition extends AppCompatActivity {
    private TextView countLabel_Addition;
    private TextView questionLabel_Addition;
    private TextView prompt_Addition;
    private ImageView imgQuestion_Addition;
    private LinearLayout quizLayout_Addition;

    MediaPlayer voiceover;
    MediaPlayer choice1;
    MediaPlayer choice2;

    Button btnAnswer1_Addition;
    Button btnAnswer2_Addition;
    Button btnConfirm_Addition;

    private String rightAnswer_Addition;
    private String wrongAnswer_Addition;
    private int rightAnswerCount_Addition = 0;
    private int quizCount_Addition = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Addition = 0;


    ArrayList<ArrayList<String>> quizArray_Addition = new ArrayList<>();

    String quizData_Addition[][] = {
            //{"Question", "Image", "Question Voice Over", "Right Answer", "Wrong Answer", "Choice 1 Voice Over, "Choice 2 Voice Over"}
            {"If you add 5 stars and 5 stars together, the sum would be?", String.valueOf(R.drawable.additionquestion1), String.valueOf(R.raw.aq1), "10 Stars", "5 Stars", String.valueOf(R.raw.aq1c1), String.valueOf(R.raw.aq1c2)},
            { "What is 1 shark plus 1 shark equal to?", String.valueOf(R.drawable.additionquestion2), String.valueOf(R.raw.aq2), "2 Sharks", "4 Sharks", String.valueOf(R.raw.aq2c1), String.valueOf(R.raw.aq2c2)},
            {"2 blue sea stars put together with another 1 sea star, how many sea stars are there in all?", String.valueOf(R.drawable.additionquestion3), String.valueOf(R.raw.aq3), "3 Blue Sea Stars", "6 Blue Sea Stars", String.valueOf(R.raw.aq3c1), String.valueOf(R.raw.aq3c2)},
            {"If you add 3 carrots and 6 carrots together, how many carrots do you have in all?", String.valueOf(R.drawable.additionquestion4), String.valueOf(R.raw.aq4), "9 Carrots", "8 Carrots", String.valueOf(R.raw.aq4c1), String.valueOf(R.raw.aq4c2)},
            {"What is 5 ice creams plus 2 ice creams equal to?", String.valueOf(R.drawable.additionquestion5), String.valueOf(R.raw.aq5), "7 Ice Creams", "4 Ice Creams", String.valueOf(R.raw.aq5c1), String.valueOf(R.raw.aq5c2)}

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_addition);


        quizLayout_Addition = (LinearLayout)findViewById(R.id.quizLayout_Addition);
        imgQuestion_Addition =  (ImageView)findViewById(R.id.imgQuestion_Addition);
        countLabel_Addition = (TextView)findViewById(R.id.countLabel_Addition);
        questionLabel_Addition = (TextView)findViewById(R.id.questionLabel_Addition);
        prompt_Addition = (TextView)findViewById(R.id.prompt_Addition);
        btnAnswer1_Addition = (Button)findViewById(R.id.btnAnswer1_Addition);
        btnAnswer2_Addition = (Button)findViewById(R.id.btnAnswer2_Addition);
        btnConfirm_Addition = (Button)findViewById(R.id.btnConfirm_Addition);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Addition.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Addition[i][0]); //Question
            tmpArray.add(quizData_Addition[i][1]); //Image
            tmpArray.add(quizData_Addition[i][2]); //Voice Over
            tmpArray.add(quizData_Addition[i][3]); //Right Answer
            tmpArray.add(quizData_Addition[i][4]); //Wrong Answer
            tmpArray.add(quizData_Addition[i][5]); //Choice 1 Voice Over
            tmpArray.add(quizData_Addition[i][6]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_Addition.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Addition.setText("Question #" + quizCount_Addition);
        confirmClicked_Addition = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Addition.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Addition.get(randomNum);

        //Set Question and Right Answer
        questionLabel_Addition.setText(quiz.get(0));
        imgQuestion_Addition.setImageResource(Integer.parseInt(quiz.get(1)));
        voiceover = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        voiceover.start();
        rightAnswer_Addition = quiz.get(3);
        wrongAnswer_Addition = quiz.get(4);
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
        btnAnswer1_Addition.setText(quiz.get(0));
        btnAnswer2_Addition.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Addition.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Addition){
            btnAnswer1_Addition.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Addition.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Addition){
            btnAnswer2_Addition.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Addition.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_Addition)){
            voiceover.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_Addition) && answerBtn != btnConfirm_Addition){
            voiceover.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_Addition) && !btnText.equals(wrongAnswer_Addition)){
            prompt_Addition.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    prompt_Addition.setText("");
                }
            },3000);

        }

        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Addition)){
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
                    rightAnswerCount_Addition++;
                    btnConfirm_Addition.setEnabled(false);
                    btnAnswer1_Addition.setEnabled(false);
                    btnAnswer2_Addition.setEnabled(false);
                    confirmClicked_Addition++;
                }
                else if (btnText.equals(wrongAnswer_Addition)) {
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
                    btnConfirm_Addition.setEnabled(false);
                    btnAnswer1_Addition.setEnabled(false);
                    btnAnswer2_Addition.setEnabled(false);
                    confirmClicked_Addition++;
                }
                else if (!btnText.equals(rightAnswer_Addition) && !btnText.equals(wrongAnswer_Addition)){
                    prompt_Addition.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            prompt_Addition.setText("");
                        }
                    },3000);
                }
            }
        });

        quizLayout_Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizCount_Addition == QUIZ_COUNT && confirmClicked_Addition != 0){
                    //Show Result
                    Intent intent = new Intent(getApplicationContext(), ResultsAddition.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT_Addition", rightAnswerCount_Addition);
                    startActivity(intent);
                }
                else if (!btnText.equals(btnAnswer1_Addition.getText().toString()) && !btnText.equals(btnAnswer2_Addition.getText().toString())){
                    //Check if user selected an answer
                    prompt_Addition.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            prompt_Addition.setText("");
                        }
                    },3000);

                }
                else if(confirmClicked_Addition == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Addition.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            prompt_Addition.setText("");
                        }
                    },3000);
                }
                else{
                    quizCount_Addition++;
                    btnAnswer1_Addition.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Addition.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer1_Addition.setEnabled(true);
                    btnAnswer2_Addition.setEnabled(true);
                    btnConfirm_Addition.setEnabled(true);
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