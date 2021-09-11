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

public class QuizSubtraction extends AppCompatActivity {
    private TextView countLabel_Subtraction;
    private TextView questionLabel_Subtraction;
    private ImageView imgQuestion_Subtraction;
    private LinearLayout quizLayout_Subtraction;

    Button btnAnswer1_Subtraction;
    Button btnAnswer2_Subtraction;
    Button btnConfirm_Subtraction;

    private String rightAnswer_Subtraction;
    private int rightAnswerCount_Subtraction = 0;
    private int quizCount_Subtraction = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Subtraction = 0;


    ArrayList<ArrayList<String>> quizArray_Subtraction = new ArrayList<>();

    String quizData_Subtraction[][] = {
            //{"Question", "Image", "Right Answer", "Wrong Answer"}
            {"What is 6 boxes of crayons minus 5 boxes of crayons equal to?", String.valueOf(R.drawable.subtractionquestion1), "1 Box of Crayons", "2 Boxes of Crayons"},
            { "What is 4 pineapples minus 2 pineapples equal to?", String.valueOf(R.drawable.subtractionquestion2),"2 Pineapples", "6 Pineapples"},
            {"If you have 5 bow ties and you gave away 3 bow ties, how many are left?", String.valueOf(R.drawable.subtractionquestion3),"2 Bow Ties", "5 Bow Ties"},
            {"If you have 4 pumpkins then someone takes away 1 pumpkin, how many pumpkins are left?", String.valueOf(R.drawable.subtractionquestion4),"3 Pumpkins", "5 Pumpkins"},
            {"What is 3 frogs minus 2 frogs", String.valueOf(R.drawable.subtractionquestion5),"1 Frog", "5 Frogs"}

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_subtraction);



        quizLayout_Subtraction = (LinearLayout)findViewById(R.id.quizLayout_Subtraction);
        imgQuestion_Subtraction =  (ImageView)findViewById(R.id.imgQuestion_Subtraction);
        countLabel_Subtraction = (TextView)findViewById(R.id.countLabel_Subtraction);
        questionLabel_Subtraction = (TextView)findViewById(R.id.questionLabel_Subtraction);
        btnAnswer1_Subtraction = (Button)findViewById(R.id.btnAnswer1_Subtraction);
        btnAnswer2_Subtraction = (Button)findViewById(R.id.btnAnswer2_Subtraction);
        btnConfirm_Subtraction = (Button)findViewById(R.id.btnConfirm_Subtraction);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Subtraction.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Subtraction[i][0]); //Question
            tmpArray.add(quizData_Subtraction[i][1]); //Image
            tmpArray.add(quizData_Subtraction[i][2]); //Right Answer
            tmpArray.add(quizData_Subtraction[i][3]); //Wrong Answer

            //Add tmpArray to quizArray
            quizArray_Subtraction.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
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
        rightAnswer_Subtraction = quiz.get(2);

        //Shuffle Choices
        quiz.remove(0);
        quiz.remove(0);
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

        if (answerBtn == btnAnswer1_Subtraction){
            btnAnswer1_Subtraction.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Subtraction.setBackgroundResource(R.drawable.answerbutton);

        }
        else if (answerBtn == btnAnswer2_Subtraction){
            btnAnswer2_Subtraction.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Subtraction.setBackgroundResource(R.drawable.answerbutton);
        }

        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Subtraction)){
                    //Correct
                    answerBtn.setBackgroundResource(R.drawable.correctanswerbutton);
                    rightAnswerCount_Subtraction++;
                    btnConfirm_Subtraction.setEnabled(false);
                    confirmClicked_Subtraction++;
                }
                else if (!btnText.equals(rightAnswer_Subtraction) && answerBtn != btnConfirm_Subtraction) {
                    if (btnText.equals(btnAnswer1_Subtraction.getText().toString()) || btnText.equals(btnAnswer2_Subtraction.getText().toString()) ) {
                        //Wrong
                        answerBtn.setBackgroundResource(R.drawable.wronganswerbutton);
                        btnConfirm_Subtraction.setEnabled(false);
                        confirmClicked_Subtraction++;
                    } else{
                        Toast.makeText(getApplicationContext(),"Oops! Please Select an Answer",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        quizLayout_Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizCount_Subtraction == QUIZ_COUNT && confirmClicked_Subtraction != 0){
                    //Show Result
                    Intent intent = new Intent(getApplicationContext(), ResultsSubtraction.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT_Subtraction", rightAnswerCount_Subtraction);
                    startActivity(intent);
                }
                else if (!btnText.equals(btnAnswer1_Subtraction.getText().toString()) && !btnText.equals(btnAnswer2_Subtraction.getText().toString())){
                    //Check if user selected an answer
                    Toast.makeText(getApplicationContext(),"Oops! Please Select an Answer",Toast.LENGTH_LONG).show();

                }
                else if(confirmClicked_Subtraction == 0){
                    //Check if Confirm Answer Button was clicked
                    Toast.makeText(getApplicationContext(),"Oops! Please Confirm your Answer",Toast.LENGTH_LONG).show();
                }
                else{
                    quizCount_Subtraction++;
                    btnAnswer1_Subtraction.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Subtraction.setBackgroundResource(R.drawable.answerbutton);
                    btnConfirm_Subtraction.setEnabled(true);
                    showNextQuiz();
                }
            }
        });
    }
}