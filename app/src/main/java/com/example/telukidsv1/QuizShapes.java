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

public class QuizShapes extends AppCompatActivity {
    private TextView countLabel_Shapes;
    private TextView questionLabel_Shapes;
    private ImageView imgQuestion_Shapes;
    private LinearLayout quizLayout_Shapes;

    Button btnAnswer1_Shapes;
    Button btnAnswer2_Shapes;
    Button btnConfirm_Shapes;
    Typeface arial_rounded;
    Typeface league_spartan_bold;

    private String rightAnswer_Shapes;
    private int rightAnswerCount_Shapes = 0;
    private int quizCount_Shapes = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Shapes = 0;


    ArrayList<ArrayList<String>> quizArray_Shapes = new ArrayList<>();

    String quizData_Shapes[][] = {
            //{"Question", "Image", "Right Answer", "Wrong Answer"}
            {"What is the shape of the following?", String.valueOf(R.drawable.shapesquestion1), "Square", "Triangle"},
            { "Which of the following has a different shape and what is its shape?", String.valueOf(R.drawable.shapesquestion2),"Wall Clock, Circle", "Boat Sail, Triangle"},
            {"What is the shape of the following?", String.valueOf(R.drawable.shapesquestion3),"Diamond", "Triangle"},
            {"Which of the following has a different shape and what is its shape?", String.valueOf(R.drawable.shapesquestion4),"Heart shaped lollipop, Heart", "Star shaped flower, Star"},
            {"What is the shape of the following?", String.valueOf(R.drawable.shapesquestion5),"Rectangle", "Triangle"}

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_shapes);


        //arial_rounded = Typeface.createFromAsset(getAssets(), "font/arialroundedmt.ttf");
        //league_spartan_bold = Typeface.createFromAsset(getAssets(), "font/leaguespartanbold.otf");

        quizLayout_Shapes = (LinearLayout)findViewById(R.id.quizLayout_Shapes);
        imgQuestion_Shapes =  (ImageView)findViewById(R.id.imgQuestion_Shapes);
        countLabel_Shapes = (TextView)findViewById(R.id.countLabel_Shapes);
        questionLabel_Shapes = (TextView)findViewById(R.id.questionLabel_Shapes);
        btnAnswer1_Shapes = (Button)findViewById(R.id.btnAnswer1_Shapes);
        btnAnswer2_Shapes = (Button)findViewById(R.id.btnAnswer2_Shapes);
        btnConfirm_Shapes = (Button)findViewById(R.id.btnConfirm_Shapes);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Shapes.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Shapes[i][0]); //Question
            tmpArray.add(quizData_Shapes[i][1]); //Image
            tmpArray.add(quizData_Shapes[i][2]); //Right Answer
            tmpArray.add(quizData_Shapes[i][3]); //Wrong Answer

            //Add tmpArray to quizArray
            quizArray_Shapes.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Shapes.setText("Question #" + quizCount_Shapes);
        confirmClicked_Shapes = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Shapes.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Shapes.get(randomNum);

        //Set Question and Right Answer
        questionLabel_Shapes.setText(quiz.get(0));
        imgQuestion_Shapes.setImageResource(Integer.parseInt(quiz.get(1)));
        rightAnswer_Shapes = quiz.get(2);

        //Shuffle Choices
        quiz.remove(0);
        quiz.remove(0);
        Collections.shuffle(quiz);

        //Set Choices
        btnAnswer1_Shapes.setText(quiz.get(0));
        //btnAnswer1_Shapes.setTypeface(arial_rounded);
        btnAnswer2_Shapes.setText(quiz.get(1));
        //btnAnswer2_Shapes.setTypeface(arial_rounded);

        //Remove this quiz from array
        quizArray_Shapes.remove(randomNum);
    }
    /*

     */
    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        if (answerBtn == btnAnswer1_Shapes){
            btnAnswer1_Shapes.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Shapes.setBackgroundResource(R.drawable.answerbutton);

        }
        else if (answerBtn == btnAnswer2_Shapes){
            btnAnswer2_Shapes.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Shapes.setBackgroundResource(R.drawable.answerbutton);
        }

        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Shapes)){
                    //Correct
                    answerBtn.setBackgroundResource(R.drawable.correctanswerbutton);
                    rightAnswerCount_Shapes++;
                    btnConfirm_Shapes.setEnabled(false);
                    confirmClicked_Shapes++;
                }
                else if (!btnText.equals(rightAnswer_Shapes) && answerBtn != btnConfirm_Shapes) {
                    if (btnText.equals(btnAnswer1_Shapes.getText().toString()) || btnText.equals(btnAnswer2_Shapes.getText().toString()) ) {
                        //Wrong
                        answerBtn.setBackgroundResource(R.drawable.wronganswerbutton);
                        btnConfirm_Shapes.setEnabled(false);
                        confirmClicked_Shapes++;
                    } else{
                        Toast.makeText(getApplicationContext(),"Oops! Please Select an Answer",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        quizLayout_Shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizCount_Shapes == QUIZ_COUNT && confirmClicked_Shapes != 0){
                    //Show Result
                    Intent intent = new Intent(getApplicationContext(), ResultsShapes.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT_Shapes", rightAnswerCount_Shapes);
                    startActivity(intent);
                }
                else if (!btnText.equals(btnAnswer1_Shapes.getText().toString()) && !btnText.equals(btnAnswer2_Shapes.getText().toString())){
                    //Check if user selected an answer
                    Toast.makeText(getApplicationContext(),"Oops! Please Select an Answer",Toast.LENGTH_LONG).show();

                }
                else if(confirmClicked_Shapes == 0){
                    //Check if Confirm Answer Button was clicked
                    Toast.makeText(getApplicationContext(),"Oops! Please Confirm your Answer",Toast.LENGTH_LONG).show();
                }
                else{
                    quizCount_Shapes++;
                    btnAnswer1_Shapes.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Shapes.setBackgroundResource(R.drawable.answerbutton);
                    btnConfirm_Shapes.setEnabled(true);
                    showNextQuiz();
                }
            }
        });
    }
}