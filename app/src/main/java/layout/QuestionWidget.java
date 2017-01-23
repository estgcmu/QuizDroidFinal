package layout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.util.List;

import cmu.QuizDroidFinal.MainActivity;
import cmu.QuizDroidFinal.Question;
import cmu.QuizDroidFinal.QuestionActivity;
import cmu.QuizDroidFinal.QuizHelper;
import cmu.QuizDroidFinal.R;
import cmu.QuizDroidFinal.ResultActivity;

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link QuestionWidgetConfigureActivity QuestionWidgetConfigureActivity}
 */
public class QuestionWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = QuestionWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.question_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        for (int i= 0; i< appWidgetIds.length; i++){

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.question_widget);

            String text = "Nova Pergunta Disponivel";
            views.setTextViewText(R.id.txtQuestionWidget,text);

            Intent openApp = new Intent(context, QuestionWidget.class);
            PendingIntent pIntent = PendingIntent.getActivity(context, 0, openApp, 0);
            views.setOnClickPendingIntent(R.id.buttonWidget, pIntent);


            //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            //PendingIntent myPending = PendingIntent.getActivity(context, 1, intent, 0);

            //views.setOnClickPendingIntent(R.id.button2Widget, myPending);

            appWidgetManager.updateAppWidget(appWidgetIds[i], views);

        }

    }


    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            QuestionWidgetConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
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

