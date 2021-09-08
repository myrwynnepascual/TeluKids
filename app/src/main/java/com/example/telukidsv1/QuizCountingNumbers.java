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

public class QuizCountingNumbers extends AppCompatActivity {
    private TextView countLabel_Counting;
    private TextView questionLabel_Counting;
    private ImageView imgQuestion_Counting;
    private LinearLayout quizLayout_Counting;

    Button btnAnswer1_Counting;
    Button btnAnswer2_Counting;
    Button btnConfirm_Counting;

    private String rightAnswer_Counting;
    private int rightAnswerCount_Counting = 0;
    private int quizCount_Counting = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Counting = 0;


    ArrayList<ArrayList<String>> quizArray_Counting = new ArrayList<>();

    String quizData_Counting[][] = {
            //{"Question", "Image", "Right Answer", "Wrong Answer"}
            {"How many boxes of crayons are there?", String.valueOf(R.drawable.countingnumbersquestion1), "5 boxes of crayons", "6 boxes of crayons"},
            { "How many apples and bananas are there?", String.valueOf(R.drawable.countingnumbersquestion2),"4 Bananas and 3 apples", "1 Banana and 2 Apples"},
            {"How many chocolates are there?", String.valueOf(R.drawable.countingnumbersquestion3),"10 Chocolates", "15 Chocolates"},
            {"How many bumblebees and cups are there?", String.valueOf(R.drawable.countingnumbersquestion4),"7 Bumblebees and 8 Cups", "9 Bumblebees and 13 Cups"},
            {"How many balloons are there?", String.valueOf(R.drawable.countingnumbersquestion5),"18 Balloons", "14 Balloons"}

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_countingnumbers);



        quizLayout_Counting = (LinearLayout)findViewById(R.id.quizLayout_Counting);
        imgQuestion_Counting =  (ImageView)findViewById(R.id.imgQuestion_Counting);
        countLabel_Counting = (TextView)findViewById(R.id.countLabel_Counting);
        questionLabel_Counting = (TextView)findViewById(R.id.questionLabel_Counting);
        btnAnswer1_Counting = (Button)findViewById(R.id.btnAnswer1_Counting);
        btnAnswer2_Counting = (Button)findViewById(R.id.btnAnswer2_Counting);
        btnConfirm_Counting = (Button)findViewById(R.id.btnConfirm_Counting);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Counting.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Counting[i][0]); //Question
            tmpArray.add(quizData_Counting[i][1]); //Image
            tmpArray.add(quizData_Counting[i][2]); //Right Answer
            tmpArray.add(quizData_Counting[i][3]); //Wrong Answer

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
        rightAnswer_Counting = quiz.get(2);

        //Shuffle Choices
        quiz.remove(0);
        quiz.remove(0);
        Collections.shuffle(quiz);

        //Set Choices
        btnAnswer1_Counting.setText(quiz.get(0));
        //btnAnswer1_Counting.setTypeface(arial_rounded);
        btnAnswer2_Counting.setText(quiz.get(1));
        //btnAnswer2_Counting.setTypeface(arial_rounded);

        //Remove this quiz from array
        quizArray_Counting.remove(randomNum);
    }
    /*

     */
    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        if (answerBtn == btnAnswer1_Counting){
            btnAnswer1_Counting.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Counting.setBackgroundResource(R.drawable.answerbutton);

        }
        else if (answerBtn == btnAnswer2_Counting){
            btnAnswer2_Counting.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Counting.setBackgroundResource(R.drawable.answerbutton);
        }

        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Counting)){
                    //Correct
                    answerBtn.setBackgroundResource(R.drawable.correctanswerbutton);
                    rightAnswerCount_Counting++;
                    btnConfirm_Counting.setEnabled(false);
                    confirmClicked_Counting++;
                }
                else if (!btnText.equals(rightAnswer_Counting) && answerBtn != btnConfirm_Counting) {
                    if (btnText.equals(btnAnswer1_Counting.getText().toString()) || btnText.equals(btnAnswer2_Counting.getText().toString()) ) {
                        //Wrong
                        answerBtn.setBackgroundResource(R.drawable.wronganswerbutton);
                        btnConfirm_Counting.setEnabled(false);
                        confirmClicked_Counting++;
                    } else{
                        Toast.makeText(getApplicationContext(),"Oops! Please Select an Answer",Toast.LENGTH_SHORT).show();
                    }
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
                    Toast.makeText(getApplicationContext(),"Oops! Please Select an Answer",Toast.LENGTH_LONG).show();

                }
                else if(confirmClicked_Counting == 0){
                    //Check if Confirm Answer Button was clicked
                    Toast.makeText(getApplicationContext(),"Oops! Please Confirm your Answer",Toast.LENGTH_LONG).show();
                }
                else{
                    quizCount_Counting++;
                    btnAnswer1_Counting.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Counting.setBackgroundResource(R.drawable.answerbutton);
                    btnConfirm_Counting.setEnabled(true);
                    showNextQuiz();
                }
            }
        });
    }
}