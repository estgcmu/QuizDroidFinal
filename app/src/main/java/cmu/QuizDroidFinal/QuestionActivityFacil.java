package cmu.QuizDroidFinal;

import java.util.List;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static cmu.QuizDroidFinal.R.layout.activity_game;
public class QuestionActivityFacil extends Activity{

    List<Question> quesList;
    int score = 0;
    int qid = 0;
    int publico = 0;
    int telefone_controlo = 0;
    int cinquenta_controlo = 0;
    int change_controlo = 0;
    Question currentQ;
    TextView txtQuestion, scored, nivel;
    Button button1, button2, button3, button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_game);
        QuizHelper db = new QuizHelper(this);
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        scored = (TextView) findViewById(R.id.score);
        nivel = (TextView) findViewById(R.id.nivel);
        setQuestionView();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Passa texto para o metodo
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
            score = score + 10000;
            scored.setText(score + " €");
            Toast.makeText(getApplicationContext(),"A sua resposta está correta!", Toast.LENGTH_SHORT).show();
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.correct_answser);
            mp.start();
        } else {

            Intent intent = new Intent(QuestionActivityFacil.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();

        }
       //caso pontuação inferior a 10000 continua o jogo
        if (score < 100000) {
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {

            Intent intent = new Intent(QuestionActivityFacil.this, ResultWinActvity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }

    public void change(View v){

        if (change_controlo==0){

            change_controlo=1;

            currentQ = quesList.get(qid);
            setQuestionView();

        }else {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Já utilizou esta ajuda.");
            alertDialogBuilder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }

    }
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        nivel.setText(currentQ.getODIF());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());
        button4.setText(currentQ.getOPTD());
        qid++;
    }
    public void publico(View v){

        if (publico==0){

            publico = 1;
        if (currentQ.getANSWER().equals(currentQ.getOPTA())){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Opinião do publico\n"
                    +"- "+currentQ.getOPTA()+" - 34%\n"
                    +"- "+currentQ.getOPTB()+" - 25%\n"
                    +"- "+currentQ.getOPTC()+" - 30%\n"
                    +"- "+currentQ.getOPTD()+" - 11%");
            alertDialogBuilder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        if (currentQ.getANSWER().equals(currentQ.getOPTB())){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
           alertDialogBuilder.setMessage("Opinião do publico\n"
                   +"- "+currentQ.getOPTA()+" - 25%\n"
                   +"- "+currentQ.getOPTB()+" - 34%\n"
                   +"- "+currentQ.getOPTC()+" - 30%\n"
                   +"- "+currentQ.getOPTD()+" - 11%");
            alertDialogBuilder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        if (currentQ.getANSWER().equals(currentQ.getOPTC())){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Opinião do publico\n"
                    +"- "+currentQ.getOPTA()+" - 25%\n"
                    +"- "+currentQ.getOPTB()+" - 30%\n"
                    +"- "+currentQ.getOPTC()+" - 34%\n"
                    +"- "+currentQ.getOPTD()+" - 11%");
            alertDialogBuilder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        if (currentQ.getANSWER().equals(currentQ.getOPTD())){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Opinião do publico\n"
                    +"- "+currentQ.getOPTA()+" - 25%\n"
                    +"- "+currentQ.getOPTB()+" - 30%\n"
                    +"- "+currentQ.getOPTC()+" - 11%\n"
                    +"- "+currentQ.getOPTD()+" - 34%");
            alertDialogBuilder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });

             AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        }else {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Já utilizou esta ajuda");
            alertDialogBuilder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });
             AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }

    public void telefone (View v){

        if (telefone_controlo==0){
            telefone_controlo=1;
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Acho que a resposta correta é\n- "+currentQ.getANSWER());
            alertDialogBuilder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }else {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Já utilizou a ajuda Telefonica");
            alertDialogBuilder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }

    }

    public void cinquenta(View v){
        if (cinquenta_controlo==0){

            cinquenta_controlo = 1;
            if (currentQ.getANSWER().equals(currentQ.getOPTA())){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Uma das opções é a correta\n"
                        +"- "+currentQ.getOPTA()+"\n"
                        +"- "+currentQ.getOPTB());
                alertDialogBuilder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
            if (currentQ.getANSWER().equals(currentQ.getOPTB())){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Uma das opções é a correta\n"
                        +"- "+currentQ.getOPTA()+"\n"
                        +"- "+currentQ.getOPTB());
                alertDialogBuilder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
            if (currentQ.getANSWER().equals(currentQ.getOPTC())){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Uma das opções é a correta\n"
                        +"- "+currentQ.getOPTC()+"\n"
                        +"- "+currentQ.getOPTD());
                alertDialogBuilder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
            if (currentQ.getANSWER().equals(currentQ.getOPTD())){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Uma das opções é a correta\n"
                        +"- "+currentQ.getOPTA()+"\n"
                        +"- "+currentQ.getOPTD());
                alertDialogBuilder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        }else {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Já utilizou a ajuda 50/50");
            alertDialogBuilder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }


}


