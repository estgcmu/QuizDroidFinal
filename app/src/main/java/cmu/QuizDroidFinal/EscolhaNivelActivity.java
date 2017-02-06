package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class EscolhaNivelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_nivel2);}

    public void button_facil(View v) {
        Intent facil = new Intent(this, AdicionarActivity.class);
        startActivity(facil);
    }
    public void button_moderado(View v) {
        Intent moderado = new Intent(this, AdicionarModeradoActivity.class);
        startActivity(moderado);
    }

    public void button_dificil(View v) {
        Intent dificil = new Intent(this, AdicionarDificilActivity.class);
        startActivity(dificil);
    }
    public void button_menu(View v) {
        Intent menu = new Intent(this, AdministracaoActivity.class);
        startActivity(menu);
    }
    }

