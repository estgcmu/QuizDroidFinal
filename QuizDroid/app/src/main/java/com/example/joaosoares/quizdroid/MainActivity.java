package com.example.joaosoares.quizdroid;

import android.content.Intent;
//import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, Pergunta_activity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

        //if(v.getId() == R.id.ver_button)
        //{
        //   Intent i = new Intent(MainActivity.this, Ver.class);
        //  startActivity(i);

        //}



        //public void alertaNormal (View view){

        //mostrar caixa de mensagem
        //AlertDialog alertDialog;
        //alertDialog = new AlertDialog.Builder(this).create();
        //alertDialog.setTitle("Funcionou");
        //alertDialog.setMessage("Botão Alerta 1");
        //alertDialog.show();

        //}
        /** Called when the user clicks the Send button */


    }

