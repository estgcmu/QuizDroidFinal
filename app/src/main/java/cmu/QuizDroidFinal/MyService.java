package cmu.QuizDroidFinal;
import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.ListView;

public class MyService extends Service {
    QuizHelper controller;
    String pergunta, answer, opta, optb, optc, optd;
    @SuppressWarnings("unused")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Obter o extra enviado pelo Intent da Activity
        //String texto = intent.getExtras().getString(MainActivity.INTENT_EXTRA);
        controller = new QuizHelper(this);
        controller.pergunta_widget(pergunta,answer,opta,optb,optc,optd);

        Intent updateWidget = new Intent();
       //updateWidget.setAction(Widget_pergunta.updateAppWidget());
        //updateWidget.putExtra(Widget_pergunta.updateAppWidget(),new int[]{appWidgetId});



        return START_REDELIVER_INTENT;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
}
