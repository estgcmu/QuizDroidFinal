package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultWinActvity extends Activity{
    MediaPlayer mp;
    @Override
    protected void onPause(){

        super.onPause();
        mp.release();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_win_actvity);

        TextView textScore = (TextView) findViewById(R.id.textScore); // Imprime o Score final

        Bundle b = getIntent().getExtras();

        int score = b.getInt("score");

        textScore.setText(score+" €");

        mp = MediaPlayer.create(getApplicationContext(), R.raw.vitoria);
        mp.start();
    }
    public void playagain(View o) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
