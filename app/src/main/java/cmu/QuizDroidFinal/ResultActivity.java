package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ResultActivity extends Activity {
    MediaPlayer mp;
    QuizHelper controller;
	@Override
	protected void onPause(){

		super.onPause();
		mp.release();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.perdeu);

        mp.start();

        Bundle b = getIntent().getExtras();

        int score = b.getInt("score");

        TextView textScore = (TextView) findViewById(R.id.textScore); // Imprime o Score final


       //textScore.setText(score);
        //String score=b.score;

        textScore.setText(score + " €");


        // String pergunta = pergunta_db.getText().toString();
        // String opcao_1 = opcao1.getText().toString();
        //String opcao_2 = opcao2.getText().toString();
        //String opcao_3 = opcao3.getText().toString();
        //String opcao_4 = opcao4.getText().toString();

        //String opcao_correta = opcao_correta_db.getText().toString();
        //quizHelper = new QuizHelper(context);

        // sqLiteDatabase = quizHelper.getWritableDatabase();
        //quizHelper.adicionar_informacao(pergunta,opcao_1,opcao_2,opcao_3,opcao_4,opcao_correta,sqLiteDatabase);
        //Toast.makeText(getBaseContext(),"Pergunta Adicionada",Toast.LENGTH_SHORT).show();
        //quizHelper.close();

            // String textSore_db = String.valueOf(b.getInt("score"));

        //score_string = Integer.parseInt(textScore.getText().toString());

        //String score_string = Integer.toString(score);
        controller = new QuizHelper(this);
        controller.insertScore(textScore.getText().toString());

        //pergunta_db = (EditText) findViewById(R.id.editText_pergunta);


        //controller.insert_question_facil(pergunta_db.getText().toString()

    }


	public void playagain(View o) {
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
	}
}