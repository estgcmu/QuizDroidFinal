package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarDificilActivity extends Activity {

    EditText pergunta_db, opcao1, opcao2, opcao3, opcao4, opcao_correta_db;
    String dif;
    QuizHelper controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_dificil);

        pergunta_db = (EditText) findViewById(R.id.editText_pergunta);
        opcao1 = (EditText) findViewById(R.id.editText_opcao_1);
        opcao2 = (EditText) findViewById(R.id.editText_opcao_2);
        opcao3 = (EditText) findViewById(R.id.editText_opcao_3);
        opcao4 = (EditText) findViewById(R.id.editText_opcao_4);
        dif="DIFICIL";
        opcao_correta_db = (EditText) findViewById(R.id.editText_opcao_correta);

        controller = new QuizHelper(this);

    }

    public void insert_question_dificil(View view){

        controller.insert_question(pergunta_db.getText().toString(),
                opcao_correta_db.getText().toString(), opcao1.getText().toString(),
                opcao2.getText().toString(),
                opcao3.getText().toString(),
                opcao4.getText().toString(),
                dif.toString());
        Toast.makeText(getBaseContext(),"Pergunta Adicionada",Toast.LENGTH_SHORT).show();
        Intent administracao = new Intent (AdicionarDificilActivity.this, AdministracaoActivity.class);
        startActivity(administracao);

    }
    }
