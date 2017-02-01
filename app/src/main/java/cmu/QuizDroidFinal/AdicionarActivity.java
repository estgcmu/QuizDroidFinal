package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarActivity extends Activity {

    EditText pergunta_db, opcao1, opcao2, opcao3, opcao4, opcao_correta_db, dif;
    Context context;
    QuizHelper quizHelper;
    SQLiteDatabase sqLiteDatabase;
    QuizHelper controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);


        pergunta_db = (EditText) findViewById(R.id.editText_pergunta);
        opcao1 = (EditText) findViewById(R.id.editText_opcao_1);
        opcao2 = (EditText) findViewById(R.id.editText_opcao_2);
        opcao3 = (EditText) findViewById(R.id.editText_opcao_3);
        opcao4 = (EditText) findViewById(R.id.editText_opcao_4);
        dif = (EditText) findViewById(R.id.editText_dif);
        opcao_correta_db = (EditText) findViewById(R.id.editText_opcao_correta);

        controller = new QuizHelper(this);




    }

    public void inserir_pergunta(View view){

         controller.insert_question_facil(pergunta_db.getText().toString(),
                         opcao_correta_db.getText().toString(),
                 opcao1.getText().toString(),
                opcao2.getText().toString(),
                opcao3.getText().toString(),
                opcao4.getText().toString(),
                dif.getText().toString());

       // String pergunta = pergunta_db.getText().toString();
       // String opcao_1 = opcao1.getText().toString();
        //String opcao_2 = opcao2.getText().toString();
        //String opcao_3 = opcao3.getText().toString();
        //String opcao_4 = opcao4.getText().toString();

        //String opcao_correta = opcao_correta_db.getText().toString();
        //quizHelper = new QuizHelper(context);

       // sqLiteDatabase = quizHelper.getWritableDatabase();
        //quizHelper.adicionar_informacao(pergunta,opcao_1,opcao_2,opcao_3,opcao_4,opcao_correta,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Pergunta Adicionada",Toast.LENGTH_SHORT).show();
        //quizHelper.close();

    }

    }

