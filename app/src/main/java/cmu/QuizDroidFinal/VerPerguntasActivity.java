package cmu.QuizDroidFinal;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;


public class VerPerguntasActivity extends Activity {
    TextView textView;
    QuizHelper controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_perguntas);
        textView = (TextView) findViewById(R.id.textView);

        controller = new QuizHelper(this);

        controller.list_all_facil(textView);
    }
}
