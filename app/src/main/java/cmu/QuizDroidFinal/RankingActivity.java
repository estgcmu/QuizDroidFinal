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

import static cmu.QuizDroidFinal.R.id.textView;

public class RankingActivity extends Activity {
    QuizHelper controller;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        textView = (TextView) findViewById(R.id.textView);
        textView = (TextView) findViewById(R.id.textView);
        controller = new QuizHelper(this);
        controller.list_score(textView);

        //controller.list_score(textView,textView_id);


       // ArrayList<String> itens_score = null;
       // QuizHelper quizHelper = new QuizHelper(this);

//        itens_score = quizHelper.getAllScores();

  //      ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, itens_score);

    //    ListView listview = (ListView) findViewById(R.id.listperguntas);

      //  listview.setAdapter(arrayAdapter);



        //int sum=0;

  //      for (int i = 0; i < itens_score.getCount(); i++) {
    //        View v = listview.getChildAt(i);
      //      TextView myView = (TextView) v.findViewById(R.id.textView);
        //    sum = sum + Integer.parseInt( myView.getText().toString() );
        //}
        //return sum;










    }
}
