package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultWinActvity extends Activity{
    TextView textScore;
    QuizHelper controller;
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
        textScore = (TextView) findViewById(R.id.textScore_view);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        textScore.setText(String.format("%d", score));
        mp = MediaPlayer.create(getApplicationContext(), R.raw.vitoria);
        mp.start();
        controller = new QuizHelper(this);
        controller.insertScore(textScore.getText().toString());
    }
    public void playagain(View o) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
