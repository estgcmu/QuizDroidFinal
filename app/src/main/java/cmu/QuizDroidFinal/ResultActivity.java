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

    TextView textScore;
	@Override
	protected void onPause(){

		super.onPause();
		mp.release();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textScore = (TextView) findViewById(R.id.textScore_view);
        //TextView textScore = (TextView) findViewById(R.id.textScore); // Imprime o Score final

        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        textScore.setText(String.format("%d", score));
        mp = MediaPlayer.create(getApplicationContext(), R.raw.perdeu);
        mp.start();
        controller = new QuizHelper(this);
        controller.insertScore(textScore.getText().toString());

    }
	public void playagain(View o) {
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
	}
}