package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class VerPerguntasActivity extends Activity {

    //TextView textView;
    public final static String ID_EXTRA="cmu.QuizDroidFinal._ID";
    public final static String PERGUNTA="cmu.QuizDroidFinal._PERGUNTA";

   // QuizHelper controller;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_perguntas);



        ArrayList<String> itens = null;
        QuizHelper quizHelper = new QuizHelper(this);

        itens = quizHelper.getAllItens();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, itens);

        ListView listview = (ListView) findViewById(R.id.listperguntas);

        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener (new AdapterView.OnItemClickListener(){
          @Override
            public  void onItemClick(AdapterView<?> adapterView, View view, int i, long id){

            Intent intent = new Intent(VerPerguntasActivity.this, PerguntaDetalheActivity.class);
            intent.putExtra(ID_EXTRA, String.valueOf(id));
              intent.putExtra(PERGUNTA, String.valueOf("Question"));
            startActivity (intent);


       }


        //listview.setOnItemClickListener(onListClick);

        //listview.setOnItemClickListener(listview);

       // AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener(){

          //  public void onItemClick(AdapterView<?> parent, View view, int position, long id)
           // {

             //   Intent i= new Intent(VerPerguntasActivity.this, PerguntaDetalheActivity.class);
               // i.putExtra(ID_EXTRA, String.valueOf(id));
                //startActivity(i);
            //}

        //};

        //ArrayList<String> perguntas = preencherDados();
        //perguntas = QuizHelper.lis

        //TextView = (TextView) findViewById(R.id.textView);

        //controller = new QuizHelper(this);

        //controller.list_all_facil(textView);
            });
;
    }

}