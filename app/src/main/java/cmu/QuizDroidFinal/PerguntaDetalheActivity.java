package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.R.attr.button;

public class PerguntaDetalheActivity extends Activity {

    List<Question> quesList;
    QuizHelper controller;
    Question currentQ;
    TextView  txt_opcao_2, txt_opcao_3, txt_opcao_4, txt_opcao_correta, txt_opcao_dif;
    //Button button1, button2, button3, button4;
    TextView txt_opcao_1,txt_question;


    String passedVar=null;
    String pergunta=null;

    private TextView passedView=null;
    private TextView perguntatexto=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta_detalhe);

        //quizHelper = new QuizHelper(this,"",null,1);


        passedVar=getIntent().getStringExtra(VerPerguntasActivity.ID_EXTRA); //variavel id
        int qid = Integer.parseInt(passedVar); //converte para int
        //int qid = 2;


        QuizHelper db = new QuizHelper(this);  // my question bank class
        quesList = db.getAllQuestions_edita();  // this will fetch all quetions

        //quesList_2 = db.getAllQuestions_MODERADO();

        currentQ = quesList.get(qid); // the current question
        //currentQ = quesList_2.get(qid_2);

        // the textview in which the question will be displayed
        //txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txt_question=(TextView) findViewById(R.id.txt_question);
        txt_opcao_1=(TextView) findViewById(R.id.txt_opcao_1);
        txt_opcao_2=(TextView) findViewById(R.id.txt_opcao_2);
        txt_opcao_3=(TextView) findViewById(R.id.txt_opcao_3);
        txt_opcao_4=(TextView) findViewById(R.id.txt_opcao_4);
        txt_opcao_correta=(TextView) findViewById(R.id.txt_opcao_correta);
        txt_opcao_dif=(TextView) findViewById(R.id.txt_opcao_dif);
        setQuestionView();
    }

    private void setQuestionView() {
        txt_question.setText(currentQ.getQUESTION());
        txt_opcao_1.setText(currentQ.getOPTA());
        txt_opcao_2.setText(currentQ.getOPTB());
        txt_opcao_3.setText(currentQ.getOPTC());
        txt_opcao_4.setText(currentQ.getOPTD());
        txt_opcao_correta.setText(currentQ.getANSWER());
        txt_opcao_dif.setText(currentQ.getODIF());
    }

    public void eliminar_pergunta(View view){
        controller = new QuizHelper(this);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Tem a certeza que pretende eliminar esta pergunta?");
                alertDialogBuilder.setPositiveButton("Sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                                controller.delete_question_facil(txt_question.getText().toString());
                                Toast.makeText(PerguntaDetalheActivity.this,"Pergunta eliminada com sucesso!", Toast.LENGTH_LONG).show();

                                Intent ver_perguntas = new Intent (PerguntaDetalheActivity.this, AdministracaoActivity.class);
                                startActivity(ver_perguntas);
                            }
                        });

        alertDialogBuilder.setNegativeButton("Não",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void update_pergunta(View view){
        controller = new QuizHelper(this);

        AlertDialog.Builder dialog = new AlertDialog.Builder(PerguntaDetalheActivity.this);
        dialog.setTitle("Editar pergunta");

        Context context = txt_question.getContext();
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText new_question = new EditText(context);
        new_question.setText(txt_question.getText());
        layout.addView(new_question);

        Context context_txt_opcao_1 = txt_opcao_1.getContext();
        final EditText new_txt_opcao_1 = new EditText(context_txt_opcao_1);
        new_txt_opcao_1.setText(txt_opcao_1.getText());
        layout.addView(new_txt_opcao_1);

        Context context_txt_opcao_2 = txt_opcao_2.getContext();
        final EditText new_txt_opcao_2 = new EditText(context_txt_opcao_2);
        new_txt_opcao_2.setText(txt_opcao_2.getText());
        layout.addView(new_txt_opcao_2);

        Context context_txt_opcao_3 = txt_opcao_3.getContext();
        final EditText new_txt_opcao_3 = new EditText(context_txt_opcao_3);
        new_txt_opcao_3.setText(txt_opcao_3.getText());
        layout.addView(new_txt_opcao_3);

        Context context_txt_opcao_4 = txt_opcao_4.getContext();
        final EditText new_txt_opcao_4 = new EditText(context_txt_opcao_4);
        new_txt_opcao_4.setText(txt_opcao_4.getText());
        layout.addView(new_txt_opcao_4);

        Context context_txt_opcao_correta = txt_opcao_correta.getContext();
        final EditText new_txt_opcao_correta = new EditText(context_txt_opcao_correta);
        new_txt_opcao_correta.setText(txt_opcao_correta.getText());
        layout.addView(new_txt_opcao_correta);

        Context context_txt_opcao_dif = txt_opcao_dif.getContext();
        final EditText new_txt_opcao_dif = new EditText(context_txt_opcao_dif);
        new_txt_opcao_dif.setText(txt_opcao_dif.getText());
        layout.addView(new_txt_opcao_dif);


        dialog.setView(layout);


        dialog.setPositiveButton("Guardar", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                controller.update_question_facil(txt_question.getText().toString(),
                        new_question.getText().toString(),new_txt_opcao_1.getText().toString(),new_txt_opcao_2.getText().toString()
                        ,new_txt_opcao_3.getText().toString()
                        ,new_txt_opcao_4.getText().toString(),new_txt_opcao_correta.getText().toString(),new_txt_opcao_dif.getText().toString()  );
                Intent ver_perguntas = new Intent (PerguntaDetalheActivity.this, VerPerguntasActivity.class);
                startActivity(ver_perguntas);
            }
        });


        dialog.setNegativeButton("Cancelar",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });



        dialog.show();
    }






    }


