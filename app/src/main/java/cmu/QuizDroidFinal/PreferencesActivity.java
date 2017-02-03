package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class PreferencesActivity extends Activity {
    public static final String DEFAULT="Sem perfil";
    public static final String DEFAULT_TEMPO="60";
    EditText userName;
    EditText tempoE;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        userName= (EditText) findViewById(R.id.userName);
        tempoE= (EditText) findViewById(R.id.tempoE);

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name",DEFAULT);
        String tempo = sharedPreferences.getString("tempo",DEFAULT_TEMPO);
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
    public void mute_(View view) {
        AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        am.setStreamMute(AudioManager.STREAM_MUSIC, true);
        Toast.makeText(this,"AUDIO DESATIVADO", Toast.LENGTH_LONG).show();
    }
    public void unmute(View view) {
        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        am.setStreamMute(AudioManager.STREAM_MUSIC, false);
        Toast.makeText(this,"AUDIO ATIVADO", Toast.LENGTH_LONG).show();
    }
    public void next(View v){
        Intent main = new Intent (this, MainActivity.class);
        startActivity(main);

    }
    }
