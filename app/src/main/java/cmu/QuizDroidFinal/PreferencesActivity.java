package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class PreferencesActivity extends Activity {
    public static final String DEFAULT="";
    EditText userName;
    EditText tempoE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        userName= (EditText) findViewById(R.id.userName);
        tempoE= (EditText) findViewById(R.id.tempoE);

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name",DEFAULT);
        String tempo = sharedPreferences.getString("tempo",DEFAULT);
        userName.setText (name);
        tempoE.setText(tempo);
    }

    public void save (View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",userName.getText().toString());
        editor.putString("tempo", tempoE.getText().toString());
        editor.commit();

        Toast.makeText(this,"Informação guardada com sucesso", Toast.LENGTH_LONG).show();
    }

    }
