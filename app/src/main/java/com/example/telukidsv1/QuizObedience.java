package com.example.telukidsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

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

public class QuizObedience extends AppCompatActivity {
    private TextView countLabel_Obedience;
    private TextView questionLabel_Obedience;
    private TextView prompt_Obedience;
    private LinearLayout quizLayout_Obedience;
    private ConstraintLayout background_Obedience;

    MediaPlayer voiceover1;
    MediaPlayer voiceover2;
    MediaPlayer choice1;
    MediaPlayer choice2;

    int background_Question;

    Button btnAnswer1_Obedience;
    Button btnAnswer2_Obedience;
    Button btnConfirm_Obedience;

    private String rightAnswer_Obedience;
    private String wrongAnswer_Obedience;
    private int rightAnswerCount_Obedience = 0;
    private int quizCount_Obedience = 1;
    static final private int QUIZ_COUNT = 5;
    private int confirmClicked_Obedience = 0;


    ArrayList<ArrayList<String>> quizArray_Obedience = new ArrayList<>();

    String quizData_Obedience[][] = {
            //{"Question", "Background Image 1", "Question Voice Over 1", "Background Image 2", "Question Voice Over 2" "Right Answer", "Wrong Answer", "Choice 1 Voice Over", "Choice 2 Voice Over"}
            {"What should Joey do?", String.valueOf(R.drawable.o1bg1), String.valueOf(R.raw.oq1_1), String.valueOf(R.drawable.o1bg2), String.valueOf(R.raw.oq1_2), "Do not cross the road and follow the rules", "Cross the road", String.valueOf(R.raw.oq1c1), String.valueOf(R.raw.oq1c2) },
            {"What should Julie do?", String.valueOf(R.drawable.o2bg1), String.valueOf(R.raw.oq2_1), String.valueOf(R.drawable.o2bg2), String.valueOf(R.raw.oq2_2), "Stop and pay respect to the national anthem", "Continue walking and not mind anything", String.valueOf(R.raw.oq2c1), String.valueOf(R.raw.oq2c2) },
            {"What should Max do?", String.valueOf(R.drawable.o3bg1), String.valueOf(R.raw.oq3_1), String.valueOf(R.drawable.o3bg2), String.valueOf(R.raw.oq3_2), "Tell the elderly that she is prioritized", "Ignore the elderly", String.valueOf(R.raw.oq3c1), String.valueOf(R.raw.oq3c2) },
            {"What should Marga do?", String.valueOf(R.drawable.o4bg1), String.valueOf(R.raw.oq4_1), String.valueOf(R.drawable.o4bg2), String.valueOf(R.raw.oq4_2), "Ask the neighbor if they can turn it down a bit", "Let the party go on", String.valueOf(R.raw.oq4c1), String.valueOf(R.raw.oq4c2) },
            {"Should Joey also do the same?", String.valueOf(R.drawable.o5bg1), String.valueOf(R.raw.oq5_1), String.valueOf(R.drawable.o5bg2), String.valueOf(R.raw.oq5_2), "Help other people like his uncle does", "Not care at all", String.valueOf(R.raw.oq5c1), String.valueOf(R.raw.oq5c2) },
            {"What should Julie do?", String.valueOf(R.drawable.o6bg1), String.valueOf(R.raw.oq6_1), String.valueOf(R.drawable.o6bg2), String.valueOf(R.raw.oq6_2), "Look for a trash bin", "Throw it randomly", String.valueOf(R.raw.oq6c1), String.valueOf(R.raw.oq6c2) },
            {"What should Max do?", String.valueOf(R.drawable.o7bg1), String.valueOf(R.raw.oq7_1), String.valueOf(R.drawable.o7bg2), String.valueOf(R.raw.oq7_2), "Make sure everything is prepared and ready for any disaster", "Panic and do not plan anything", String.valueOf(R.raw.oq7c1), String.valueOf(R.raw.oq7c2) }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_obedience);

        background_Obedience = (ConstraintLayout) findViewById(R.id.background_Obedience);
        quizLayout_Obedience = (LinearLayout)findViewById(R.id.quizLayout_Obedience);
        countLabel_Obedience = (TextView)findViewById(R.id.countLabel_Obedience);
        questionLabel_Obedience = (TextView)findViewById(R.id.questionLabel_Obedience);
        btnAnswer1_Obedience = (Button)findViewById(R.id.btnAnswer1_Obedience);
        btnAnswer2_Obedience = (Button)findViewById(R.id.btnAnswer2_Obedience);
        prompt_Obedience = (TextView)findViewById(R.id.prompt_Obedience);
        btnConfirm_Obedience = (Button)findViewById(R.id.btnConfirm_Obedience);


        //Create quizArray from quizData
        for(int i = 0; i < quizData_Obedience.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData_Obedience[i][0]); //Question
            tmpArray.add(quizData_Obedience[i][1]); //Background Image 1
            tmpArray.add(quizData_Obedience[i][2]); //Question Voice Over 1
            tmpArray.add(quizData_Obedience[i][3]); //Background Image 2
            tmpArray.add(quizData_Obedience[i][4]); //Question Voice Over 2
            tmpArray.add(quizData_Obedience[i][5]); //Right Answer
            tmpArray.add(quizData_Obedience[i][6]); //Wrong Answer
            tmpArray.add(quizData_Obedience[i][7]); //Choice 1 Voice Over
            tmpArray.add(quizData_Obedience[i][8]); //Choice 2 Voice Over
            //Add tmpArray to quizArray
            quizArray_Obedience.add(tmpArray);
        }
        showNextQuiz();
    }
    public void showNextQuiz(){
        //Update quizCountLabel
        countLabel_Obedience.setText("Question #" + quizCount_Obedience);
        confirmClicked_Obedience = 0;

        //Generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray_Obedience.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray_Obedience.get(randomNum);

        //Set Question and Right Answer

        //Hide question and choices
        quizLayout_Obedience.setVisibility(View.INVISIBLE);
        countLabel_Obedience.setVisibility(View.INVISIBLE);
        questionLabel_Obedience.setVisibility(View.INVISIBLE);
        btnAnswer1_Obedience.setVisibility(View.INVISIBLE);
        btnAnswer2_Obedience.setVisibility(View.INVISIBLE);
        btnConfirm_Obedience.setVisibility(View.INVISIBLE);

        questionLabel_Obedience.setText(quiz.get(0));
        background_Obedience.setBackgroundResource(Integer.parseInt(quiz.get(1)));
        voiceover1 = MediaPlayer.create(this, Integer.parseInt(quiz.get(2)));
        background_Question = Integer.parseInt(quiz.get(3));
        voiceover2 = MediaPlayer.create(this, Integer.parseInt(quiz.get(4)));
        voiceover1.start();
        voiceover1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                voiceover1.release();
                voiceover2.start();
                background_Obedience.setBackgroundResource(background_Question);
                quizLayout_Obedience.setVisibility(View.VISIBLE);
                countLabel_Obedience.setVisibility(View.VISIBLE);
                questionLabel_Obedience.setVisibility(View.VISIBLE);
                btnAnswer1_Obedience.setVisibility(View.VISIBLE);
                btnAnswer2_Obedience.setVisibility(View.VISIBLE);
                btnConfirm_Obedience.setVisibility(View.VISIBLE);
            }
        });
        rightAnswer_Obedience = quiz.get(5);
        wrongAnswer_Obedience = quiz.get(6);
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
        btnAnswer1_Obedience.setText(quiz.get(0));
        btnAnswer2_Obedience.setText(quiz.get(1));

        //Remove this quiz from array
        quizArray_Obedience.remove(randomNum);
    }

    public void checkAnswer(View view){
        //Get pushed button
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        MediaPlayer correct_sound = MediaPlayer.create(this, R.raw.correctsound);
        MediaPlayer wrong_sound =  MediaPlayer.create(this, R.raw.wrongsound);

        if (answerBtn == btnAnswer1_Obedience){
            btnAnswer1_Obedience.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer2_Obedience.setBackgroundResource(R.drawable.answerbutton);
        }
        else if (answerBtn == btnAnswer2_Obedience){
            btnAnswer2_Obedience.setBackgroundResource(R.drawable.selectedanswerbutton);
            btnAnswer1_Obedience.setBackgroundResource(R.drawable.answerbutton);
        }

        //Play Choice 1 Voice Over
        if (answerBtn.getText().equals(rightAnswer_Obedience)){
            voiceover1.release();
            voiceover2.release();
            choice1.start();
        }
        //Play Choice 2 Voice Over
        else if (answerBtn.getText().equals(wrongAnswer_Obedience) && answerBtn != btnConfirm_Obedience){
            voiceover1.release();
            voiceover2.release();
            choice2.start();
        }
        //Check if user selected an answer
        else if (!btnText.equals(rightAnswer_Obedience) && !btnText.equals(wrongAnswer_Obedience)){
            prompt_Obedience.setText("Please select an answer");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prompt_Obedience.setText("");
                }
            },3000);

        }
        // Confirm Users answer and shows if answer is right or wrong
        btnConfirm_Obedience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnText.equals(rightAnswer_Obedience)){
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
                    rightAnswerCount_Obedience++;
                    btnConfirm_Obedience.setEnabled(false);
                    btnAnswer1_Obedience.setEnabled(false);
                    btnAnswer2_Obedience.setEnabled(false);
                    confirmClicked_Obedience++;
                }
                if (btnText.equals(wrongAnswer_Obedience)) {
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
                    btnConfirm_Obedience.setEnabled(false);
                    btnAnswer1_Obedience.setEnabled(false);
                    btnAnswer2_Obedience.setEnabled(false);
                    confirmClicked_Obedience++;
                }
                else if (!btnText.equals(rightAnswer_Obedience) && !btnText.equals(wrongAnswer_Obedience)){
                    prompt_Obedience.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Obedience.setText("");
                        }
                    },3000);
                }
            }
        });

        background_Obedience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizCount_Obedience == QUIZ_COUNT && confirmClicked_Obedience != 0){
                    //Show Result
                    Intent intent = new Intent(getApplicationContext(), ResultsObedience.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT_Obedience", rightAnswerCount_Obedience);
                    startActivity(intent);
                }
                else if (!btnText.equals(btnAnswer1_Obedience.getText().toString()) && !btnText.equals(btnAnswer2_Obedience.getText().toString())){
                    //Check if user selected an answer
                    prompt_Obedience.setText("Please select an answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Obedience.setText("");
                        }
                    },3000);
                }
                else if(confirmClicked_Obedience == 0){
                    //Check if Confirm Answer Button was clicked
                    prompt_Obedience.setText("Please submit your answer");

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            prompt_Obedience.setText("");
                        }
                    },3000);
                }
                else{
                    quizCount_Obedience++;
                    btnAnswer1_Obedience.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer2_Obedience.setBackgroundResource(R.drawable.answerbutton);
                    btnAnswer1_Obedience.setEnabled(true);
                    btnAnswer2_Obedience.setEnabled(true);
                    btnConfirm_Obedience.setEnabled(true);
                    voiceover1.release();
                    voiceover2.release();
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