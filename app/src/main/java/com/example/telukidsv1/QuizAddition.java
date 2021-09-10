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

public class QuizAddition extends AppCompatActivity {
    private TextView countLabel_Addition;
    private TextView questionLabel_Addition;
    private ImageView imgQuestion_Addition;
    private LinearLayout quizLayout_Addition;

    Button btnAnswer1_Addition;
    Button btnAnswer2_Addition;
    Button btnConfirm_Addition;

    private String rightAnswer_Addition;
    private int rightAnswerCount_Addition = 0;
    private int quizCount_Addition = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Addition = 0;


    ArrayList<ArrayList<String>> quizArray_Addition = new ArrayList<>();

    String quizData_Addition[][] = {
            //{"Question", "Image", "Right Answer", "Wrong Answer"}
            {"If you add 5 stars and 5 stars together, the sum would be?", String.valueOf(R.drawable.additionquestion1), "10 Stars", "5 Stars"},
            { "What is 1 shark plus 1 shark equal to?", String.valueOf(R.drawable.additionquestion2),"2 Sharks", "4 Sharks"},
            {"2 blue sea stars put together with another 1 sea star, how many sea stars are there in all?", String.valueOf(R.drawable.additionquestion3),"3 Blue Sea Stars", "6 Blue Sea Stars"},
            {"If you add 3 carrots and 6 carrots together, how many carrots do you have in all?", String.valueOf(R.drawable.additionquestion4),"9 Carrots", "8 Carrots"},
            {"What is 5 ice creams plus 2 ice creams equal to?", String.valueOf(R.drawable.additionquestion5),"7 Ice Creams", "4 Ice Creams"}

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_addition);



        quizLayout_Addition = (LinearLayout)findViewById(R.id.quizLayout_Addition);
        imgQuestion_Addition =  (ImageView)findViewById(R.id.imgQuestion_Addition);
        countLabel_Addition = (TextView)findViewById(R.id.countLabel_Addition);
        questionLabel_Addition = (TextView)findViewById(R.id.questionLabel_Addition);
        btnAnswer1_Addition = (Button)findViewById(R.id.btnAnswer1_Addition);
        btnAnswer2_Addition = (Button)findViewById(R.id.btnAnswer2_Addition);
        btnConfirm_Addition = (Button)findViewById(R.id.btnConfirm_Addition);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Addition.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Addition[i][0]); //Question
            tmpArray.add(quizData_Addition[i][1]); //Image
            tmpArray.add(quizData_Addition[i][2]); //Right Answer
            tmpArray.add(quizData_Addition[i][3]); //Wrong Answer

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
        rightAnswer_Addition = quiz.get(2);

        //Shuffle Choices
        quiz.remove(0);
        quiz.remove(0);
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

        if (answerBtn == btnAnswer1_Addition){
            btnAnswer1_Addition.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Addition.setBackgroundResource(R.drawable.answerbutton);

        }
        else if (answerBtn == btnAnswer2_Addition){
            btnAnswer2_Addition.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Addition.setBackgroundResource(R.drawable.answerbutton);
        }

        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Addition)){
                    //Correct
                    answerBtn.setBackgroundResource(R.drawable.correctanswerbutton);
                    rightAnswerCount_Addition++;
                    btnConfirm_Addition.setEnabled(false);
                    confirmClicked_Addition++;
                }
                else if (!btnText.equals(rightAnswer_Addition) && answerBtn != btnConfirm_Addition) {
                    if (btnText.equals(btnAnswer1_Addition.getText().toString()) || btnText.equals(btnAnswer2_Addition.getText().toString()) ) {
                        //Wrong
                        answerBtn.setBackgroundResource(R.drawable.wronganswerbutton);
                        btnConfirm_Addition.setEnabled(false);
                        confirmClicked_Addition++;
                    } else{
                        Toast.makeText(getApplicationContext(),"Oops! Please Select an Answer",Toast.LENGTH_SHORT).show();
                    }
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
                    Toast.makeText(getApplicationContext(),"Oops! Please Select an Answer",Toast.LENGTH_LONG).show();

                }
                else if(confirmClicked_Addition == 0){
                    //Check if Confirm Answer Button was clicked
                    Toast.makeText(getApplicationContext(),"Oops! Please Confirm your Answer",Toast.LENGTH_LONG).show();
                }
                else{
                    quizCount_Addition++;
                    btnAnswer1_Addition.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Addition.setBackgroundResource(R.drawable.answerbutton);
                    btnConfirm_Addition.setEnabled(true);
                    showNextQuiz();
                }
            }
        });
    }
}