package com.example.telukidsv1;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
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

public class QuizShapes extends AppCompatActivity {
    private TextView countLabel_Shapes;
    private TextView questionLabel_Shapes;
    private TextView prompt_Shapes;
    private ImageView imgQuestion_Shapes;
    private LinearLayout quizLayout_Shapes;

    MediaPlayer voiceover;
    MediaPlayer choice1;
    MediaPlayer choice2;

    Button btnAnswer1_Shapes;
    Button btnAnswer2_Shapes;
    Button btnConfirm_Shapes;

    private String rightAnswer_Shapes;
    private String wrongAnswer_Shapes;
    private int rightAnswerCount_Shapes = 0;
    private int quizCount_Shapes = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Shapes = 0;


    ArrayList<ArrayList<String>> quizArray_Shapes = new ArrayList<>();

    String quizData_Shapes[][] = {
            //{"Question", "Image", "Question Voice Over", "Right Answer", "Wrong Answer", "Choice 1 Voice Over", "Choice 2 Voice Over"}
            {"What is the shape of the following?", String.valueOf(R.drawable.shapesquestion1), String.valueOf(R.raw.sq1), "Square", "Rectangle", String.valueOf(R.raw.sq1c1), String.valueOf(R.raw.sq1c2) },
            { "Which of the following has a different shape and what is its shape?", String.valueOf(R.drawable.shapesquestion2), String.valueOf(R.raw.sq2), "Wall Clock, Circle", "Boat Sail, Triangle", String.valueOf(R.raw.sq2c1), String.valueOf(R.raw.sq2c2)},
            {"What is the shape of the following?", String.valueOf(R.drawable.shapesquestion3), String.valueOf(R.raw.sq3), "Diamond", "Triangle", String.valueOf(R.raw.sq3c1), String.valueOf(R.raw.sq3c2)},
            {"Which of the following has a different shape and what is its shape?", String.valueOf(R.drawable.shapesquestion4), String.valueOf(R.raw.sq4), "Heart shaped lollipop, Heart", "Balloon flower, Star", String.valueOf(R.raw.sq4c1), String.valueOf(R.raw.sq4c2)},
            {"What is the shape of the following?", String.valueOf(R.drawable.shapesquestion5), String.valueOf(R.raw.sq5), "Rectangle", "Triangle", String.valueOf(R.raw.sq5c1), String.valueOf(R.raw.sq5c2)}

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_shapes);


        quizLayout_Shapes = (LinearLayout)findViewById(R.id.quizLayout_Shapes);
        imgQuestion_Shapes =  (ImageView)findViewById(R.id.imgQuestion_Shapes);
        countLabel_Shapes = (TextView)findViewById(R.id.countLabel_Shapes);
        questionLabel_Shapes = (TextView)findViewById(R.id.questionLabel_Shapes);
        prompt_Shapes = (TextView)findViewById(R.id.prompt_Shapes);
        btnAnswer1_Shapes = (Button)findViewById(R.id.btnAnswer1_Shapes);
        btnAnswer2_Shapes = (Button)findViewById(R.id.btnAnswer2_Shapes);
        btnConfirm_Shapes = (Button)findViewById(R.id.btnConfirm_Shapes);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Shapes.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Shapes[i][0]); //Question
            tmpArray.add(quizData_Shapes[i][1]); //Image
            tmpArray.add(quizData_Shapes[i][2]); //Voice Over
            tmpArray.add(quizData_Shapes[i][3]); //Right Answer
            tmpArray.add(quizData_Shapes[i][4]); //Wrong Answer
            tmpArray.add(quizData_Shapes[i][5]); //Choice 1 Voice Over
            tmpArray.add(quizData_Shapes[i][6]); //Choice 2 Voice Over
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
        voiceover = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        voiceover.start();
        rightAnswer_Shapes = quiz.get(3);
        wrongAnswer_Shapes = quiz.get(4);
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
        btnAnswer1_Shapes.setText(quiz.get(0));
        btnAnswer2_Shapes.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Shapes.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Shapes){
            btnAnswer1_Shapes.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Shapes.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Shapes){
            btnAnswer2_Shapes.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Shapes.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_Shapes)){
            voiceover.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_Shapes) && answerBtn != btnConfirm_Shapes){
            voiceover.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_Shapes) && !btnText.equals(wrongAnswer_Shapes)){
            prompt_Shapes.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    prompt_Shapes.setText("");
                }
            },3000);

        }

        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Shapes)){
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
                    rightAnswerCount_Shapes++;
                    btnConfirm_Shapes.setEnabled(false);
                    btnAnswer1_Shapes.setEnabled(false);
                    btnAnswer2_Shapes.setEnabled(false);
                    confirmClicked_Shapes++;
                }
                if (btnText.equals(wrongAnswer_Shapes)) {
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
                    btnConfirm_Shapes.setEnabled(false);
                    btnAnswer1_Shapes.setEnabled(false);
                    btnAnswer2_Shapes.setEnabled(false);
                    confirmClicked_Shapes++;
                }
                else if (!btnText.equals(rightAnswer_Shapes) && !btnText.equals(wrongAnswer_Shapes)){
                    prompt_Shapes.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            prompt_Shapes.setText("");
                        }
                    },3000);
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
                    prompt_Shapes.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Shapes.setText("");
                        }
                    },3000);

                }
                else if(confirmClicked_Shapes == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Shapes.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Shapes.setText("");
                        }
                    },3000);
                }
                else{
                    quizCount_Shapes++;
                    btnAnswer1_Shapes.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Shapes.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer1_Shapes.setEnabled(true);
                    btnAnswer2_Shapes.setEnabled(true);
                    btnConfirm_Shapes.setEnabled(true);
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