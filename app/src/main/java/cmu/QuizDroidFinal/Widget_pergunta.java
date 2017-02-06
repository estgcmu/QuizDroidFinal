package cmu.QuizDroidFinal;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static cmu.QuizDroidFinal.R.layout.activity_game;
import static cmu.QuizDroidFinal.R.layout.widget_pergunta;

/**
 * Implementation of App Widget functionality.
 */


public class Widget_pergunta extends AppWidgetProvider {



    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,int appWidgetId) {

        //String com texto CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_pergunta);

        //declara as textview
       // views.setTextViewText(R.id.txtQuestion, widgetText);


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);

   }


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them


    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

