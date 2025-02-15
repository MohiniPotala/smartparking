package com.dominicsilveira.parkingsystem.utils.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.dominicsilveira.parkingsystem.NormalUser.GPSMapActivity;
import com.dominicsilveira.parkingsystem.NormalUser.NearByAreaActivity;
import com.dominicsilveira.parkingsystem.NormalUser.UserHistoryActivity;
import com.dominicsilveira.parkingsystem.OwnerUser.AreaHistoryActivity;
import com.dominicsilveira.parkingsystem.OwnerUser.MainOwnerActivity;
import com.dominicsilveira.parkingsystem.R;
import com.dominicsilveira.parkingsystem.RegisterLogin.SplashScreen;
import com.dominicsilveira.parkingsystem.ui.dashboard.owner.DashboardOwnerFragment;
import com.dominicsilveira.parkingsystem.ui.scan.ScanFragment;

/**
 * Implementation of App Widget functionality.
 */
public class ParkingOwnerUserWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.parking_owner_user_widget);

        Intent dashboardIntent=new Intent(context, SplashScreen.class);
        dashboardIntent.putExtra("ACTIVITY_NO", 21);
        PendingIntent dashboardPendingIntent = PendingIntent.getActivity(context, 1003, dashboardIntent, PendingIntent.FLAG_IMMUTABLE);

        Intent historyIntent=new Intent(context, SplashScreen.class);
        historyIntent.putExtra("ACTIVITY_NO", 22);
        PendingIntent historyPendingIntent = PendingIntent.getActivity(context, 1004, historyIntent, PendingIntent.FLAG_IMMUTABLE);

        views.setOnClickPendingIntent(R.id.dashboardBtn, dashboardPendingIntent);
        views.setOnClickPendingIntent(R.id.historyBtn, historyPendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
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

