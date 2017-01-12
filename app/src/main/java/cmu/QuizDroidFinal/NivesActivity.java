package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class NivesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nives);
}


    public void button_novo_jogo_facil(View v){
        Intent novo_jogo_facil_activity = new Intent (this, QuestionActivity.class);
        startActivity(novo_jogo_facil_activity);
    }

    public void button_novo_jogo_moderado(View v){
        Intent novo_jogo_moderado_activity = new Intent (this, QuestionActivity.class);
        startActivity(novo_jogo_moderado_activity);
    }
    public void button_novo_jogo_dificil(View v){
        Intent novo_jogo_dificil_activity = new Intent (this, QuestionActivity.class);
        startActivity(novo_jogo_dificil_activity);
    }


}
