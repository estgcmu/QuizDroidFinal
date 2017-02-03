package cmu.QuizDroidFinal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        List<Question> quesList;
        int score = 0;
        int qid = 0;
        int publico = 0;
        int telefone_controlo = 0;
        int cinquenta_controlo = 0;
        int change_controlo = 0;
        Question currentQ;
        TextView txtQuestion, scored, nivel;
        Button button1, button2, button3, button4;


        return super.onStartCommand(intent, flags, startId);
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
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
