package cmu.QuizDroidFinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class PerfilActivity extends Activity {
    public static final String DEFAULT="N/A";

    TextView userNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        userNameTextView = (TextView) findViewById(R.id.txtEditUsername);


    //}
    //public void load (View view){

    SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);

    String name = sharedPreferences.getString("name",DEFAULT);


        if (name.equals(DEFAULT)){

            Toast.makeText(this,"Nenhuma informação foi encontrada",Toast.LENGTH_LONG).show();


        }else
        {
            Toast.makeText(this,"Informação carregada com sucesso",Toast.LENGTH_SHORT).show();
            userNameTextView.setText (name);

        }



    }
    public void menu(View view){

        //Toast.makeText(this,"Previous", Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,AdministracaoActivity.class);
        startActivity(intent);


    }
}






















