package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class AdministracaoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administracao);
    }
    public void button_adicionar(View v) {
        Intent adicionar_activity = new Intent(this, AdicionarActivity.class);
        startActivity(adicionar_activity);
    }
}

