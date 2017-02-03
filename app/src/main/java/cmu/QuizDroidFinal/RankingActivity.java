package cmu.QuizDroidFinal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class RankingActivity extends Activity {
    QuizHelper controller;
    TextView textView, numero_vitorias, numero_jogos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        textView = (TextView) findViewById(R.id.textView);
        numero_jogos = (TextView) findViewById(R.id.numero_jogos);
        numero_vitorias = (TextView) findViewById(R.id.numero_vitorias);
        controller = new QuizHelper(this);
        controller.list_score(textView,numero_jogos);
        controller.numero_vitorias(numero_vitorias);

    }
}
