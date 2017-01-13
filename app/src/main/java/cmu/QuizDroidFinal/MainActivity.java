package cmu.QuizDroidFinal;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_niveis(View v){
        Intent niveis_activity = new Intent (this, NiveisActivity.class);
        startActivity(niveis_activity);

    }

    public void button_ranking(View v){
        Intent ranking_activity = new Intent (this, RankingActivity.class);
        startActivity(ranking_activity);
    }
//teste
    public void button_perfil(View v){
        Intent perfil_activity = new Intent (this, PerfilActivity.class);
        startActivity(perfil_activity);
    }

    public void button_administracao(View v){
        Intent administracao_activity = new Intent (this, AdministracaoActivity.class);
        startActivity(administracao_activity);
    }





}




























