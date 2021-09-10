package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizColors extends AppCompatActivity {
    private TextView countLabel_Colors;
    private TextView questionLabel_Colors;
    private ImageView imgQuestion_Colors;
    private LinearLayout quizLayout_Colors;

    Button btnAnswer1_Colors;
    Button btnAnswer2_Colors;
    Button btnConfirm_Colors;

    private String rightAnswer_Colors;
    private int rightAnswerCount_Colors = 0;
    private int quizCount_Colors = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Colors = 0;


    ArrayList<ArrayList<String>> quizArray_Colors = new ArrayList<>();

    String quizData_Colors[][] = {
            //{"Question", "Image", "Right Answer", "Wrong Answer"}
            {"What is the color of the frog, leaf, and alligator?", String.valueOf(R.drawable.colorsquestion1), "Green", "Red"},
            { "Which of the following has a different color and what is its color: water, bus, and pumpkin?", String.valueOf(R.drawable.colorsquestion2),"Pumpkin, Orange", "Bus, Blue"},
            {"What is the color of the cup, curtain, and balloon?", String.valueOf(R.drawable.colorsquestion3),"Purple", "Red"},
            {"Which of the following has a different color and what is its color: pineapple, crate, and peacock?", String.valueOf(R.drawable.colorsquestion4),"Peacock, Blue", "Crate, Yellow"},
            {"What is the color of the cheese, bumblebee, and star lantern?", String.valueOf(R.drawable.colorsquestion5),"Yellow", "Green"}

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_colors);



        quizLayout_Colors = (LinearLayout)findViewById(R.id.quizLayout_Colors);
        imgQuestion_Colors =  (ImageView)findViewById(R.id.imgQuestion_Colors);
        countLabel_Colors = (TextView)findViewById(R.id.countLabel_Colors);
        questionLabel_Colors = (TextView)findViewById(R.id.questionLabel_Colors);
        btnAnswer1_Colors = (Button)findViewById(R.id.btnAnswer1_Colors);
        btnAnswer2_Colors = (Button)findViewById(R.id.btnAnswer2_Colors);
        btnConfirm_Colors = (Button)findViewById(R.id.btnConfirm_Colors);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Colors.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Colors[i][0]); //Question
            tmpArray.add(quizData_Colors[i][1]); //Image
            tmpArray.add(quizData_Colors[i][2]); //Right Answer
            tmpArray.add(quizData_Colors[i][3]); //Wrong Answer

            //Add tmpArray to quizArray
            quizArray_Colors.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Colors.setText("Question #" + quizCount_Colors);
        confirmClicked_Colors = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Colors.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Colors.get(randomNum);

        //Set Question and Right Answer
        questionLabel_Colors.setText(quiz.get(0));
        imgQuestion_Colors.setImageResource(Integer.parseInt(quiz.get(1)));
        rightAnswer_Colors = quiz.get(2);

        //Shuffle Choices
        quiz.remove(0);
        quiz.remove(0);
        Collections.shuffle(quiz);

        //Set Choices
        btnAnswer1_Colors.setText(quiz.get(0));
        btnAnswer2_Colors.setText(quiz.get(1));


        //Remove this quiz from array
        quizArray_Colors.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        if (answerBtn == btnAnswer1_Colors){
            btnAnswer1_Colors.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Colors.setBackgroundResource(R.drawable.answerbutton);

        }
        else if (answerBtn == btnAnswer2_Colors){
            btnAnswer2_Colors.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Colors.setBackgroundResource(R.drawable.answerbutton);
        }

        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Colors)){
                    //Correct
                    answerBtn.setBackgroundResource(R.drawable.correctanswerbutton);
                    rightAnswerCount_Colors++;
                    btnConfirm_Colors.setEnabled(false);
                    confirmClicked_Colors++;
                }
                else if (!btnText.equals(rightAnswer_Colors) && answerBtn != btnConfirm_Colors) {
                    if (btnText.equals(btnAnswer1_Colors.getText().toString()) || btnText.equals(btnAnswer2_Colors.getText().toString()) ) {
                        //Wrong
                        answerBtn.setBackgroundResource(R.drawable.wronganswerbutton);
                        btnConfirm_Colors.setEnabled(false);
                        confirmClicked_Colors++;
                    } else{
                        Toast.makeText(getApplicationContext(),"Oops! Please Select an Answer",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        quizLayout_Colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizCount_Colors == QUIZ_COUNT && confirmClicked_Colors != 0){
                    //Show Result
                    Intent intent = new Intent(getApplicationContext(), ResultsColors.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT_Colors", rightAnswerCount_Colors);
                    startActivity(intent);
                }
                else if (!btnText.equals(btnAnswer1_Colors.getText().toString()) && !btnText.equals(btnAnswer2_Colors.getText().toString())){
                    //Check if user selected an answer
                    Toast.makeText(getApplicationContext(),"Oops! Please Select an Answer",Toast.LENGTH_LONG).show();

                }
                else if(confirmClicked_Colors == 0){
                    //Check if Confirm Answer Button was clicked
                    Toast.makeText(getApplicationContext(),"Oops! Please Confirm your Answer",Toast.LENGTH_LONG).show();
                }
                else{
                    quizCount_Colors++;
                    btnAnswer1_Colors.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Colors.setBackgroundResource(R.drawable.answerbutton);
                    btnConfirm_Colors.setEnabled(true);
                    showNextQuiz();
                }
            }
        });
    }
}