package cmu.QuizDroidFinal;

import java.util.List;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static cmu.QuizDroidFinal.R.layout.activity_game;


public class QuestionActivityFacil extends Activity{
    List<Question> quesList;

    //List<Question> quest2List;


    int score = 0;
    int qid = 0;
    //int qid_2 = 0;
    //int number_quest = 0;


    Question currentQ;
    TextView txtQuestion, scored, nivel;
    Button button1, button2, button3, button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_game);

        QuizHelper db = new QuizHelper(this);  // my question bank class
        quesList = db.getAllQuestions();  // this will fetch all quetions

        //quesList_2 = db.getAllQuestions_MODERADO();

        currentQ = quesList.get(qid); // the current question
        //currentQ = quesList_2.get(qid_2);

        // the textview in which the question will be displayed
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);


        // the three buttons,
        // the idea is to set the text of three buttons with the options from question bank
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);


        // the textview in which score will be displayed
        scored = (TextView) findViewById(R.id.score);
        nivel = (TextView) findViewById(R.id.nivel);

        setQuestionView();

        // button click listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // passing the button text to other method
                // to check whether the anser is correct or not
                // same for all three buttons
                getAnswer(button1.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button4.getText().toString());
            }
        });




    }

    //Verifica resposta
    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString)) {

            // if conditions matches increase the int (score) by 1
            // and set the text of the score view
            score = score + 10000;
            scored.setText(score + " €");
            Toast.makeText(getApplicationContext(),"A sua resposta está correta!", Toast.LENGTH_SHORT).show();
        } else {

            // if unlucky start activity and finish the game

            Intent intent = new Intent(QuestionActivityFacil.this, ResultActivity.class);

            // passing the int value
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();

        }
        // if (qid < 6) {
        if (score < 100000) {

            // if questions are not over then do this
            currentQ = quesList.get(qid);
            //currentQ = quesList_2.get(qid_2);
            setQuestionView();
        } else {

            // if over do this
            Intent intent = new Intent(QuestionActivityFacil.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next

            String texto = "OLA";
            Bundle c = new Bundle();
            c.putString("texto", texto); // Your score
            intent.putExtras(c); // Put your score to your next


            startActivity(intent);
            finish();
        }


    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")


    private void setQuestionView() {

        // the method which will put all things together
        txtQuestion.setText(currentQ.getQUESTION());
        nivel.setText(currentQ.getODIF());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());
        button4.setText(currentQ.getOPTD());
        qid++;
        //qid_2++;
    }

}


