package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		TextView textScore = (TextView) findViewById(R.id.textScore); // Imprime o Score final
		Bundle b = getIntent().getExtras();
		int score = b.getInt("score");
		textScore.setText(score+" €");

	}

	public void playagain(View o) {
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);


	}
}