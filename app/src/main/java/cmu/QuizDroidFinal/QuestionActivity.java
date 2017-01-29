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


public class QuestionActivity extends Activity {
    List<Question> quesList;


    int score = 0;
    int qid = 0;



    Question currentQ;
    TextView txtQuestion, scored, nivel;
    Button button1, button2, button3, button4 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        QuizHelper db = new QuizHelper(this);  // Acesso a pergunta
        quesList = db.getAllQuestions();  // Carrega Perguntas
        currentQ = quesList.get(qid); // Pergunta atual

        // Mostra pergunta na respetiva textView
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        // Botões
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        // TextView Score
        scored = (TextView) findViewById(R.id.score);
        // TextView Nivel
        nivel = (TextView) findViewById(R.id.nivel);
        setQuestionView();


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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

            //caso se verifique adiciona pontuação
            score = score + 10000;
            scored.setText(score + " €");

            Toast.makeText(getApplicationContext(),"A sua resposta está correta!", Toast.LENGTH_SHORT).show();

        } else {

            // Recomeça o jogo

            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);


            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();

        }

        if (score < 100000) {
            currentQ = quesList.get(qid);
            setQuestionView();

        } else {


            Intent intent = new Intent(QuestionActivity.this,ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }


    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")



    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        nivel.setText(currentQ.getODIF());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());
        button4.setText(currentQ.getOPTD());
        qid++;
    }


}
