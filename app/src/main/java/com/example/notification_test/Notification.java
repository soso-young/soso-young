package com.example.notification_test;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class Notification extends ContextWrapper {

    public static final String channelId = "channel1Id";
    public static final String channel1name = "channel1";

    private NotificationManager manager;


    public Notification(Context base) {
        super(base);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            creatChannels();

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void creatChannels(){

        NotificationChannel channel1 = new NotificationChannel(channelId, channel1name, NotificationManager.IMPORTANCE_DEFAULT);
        channel1.enableLights(true);
        channel1.enableVibration(true);
        channel1.setLightColor(com.google.android.material.R.color.design_default_color_primary);
        channel1.setLockscreenVisibility(android.app.Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channel1);

    }

    public NotificationManager getManager(){
        if(manager == null){
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;

    }

    public NotificationCompat.Builder getChannel1Notification(String title, String message){

        return new NotificationCompat.Builder(getApplicationContext(), channelId)
                .setContentText(message)
                .setContentText(message)//message 띄우기
                .setOngoing(true)   //알림 상당바에 계속 고정하기
                .setSmallIcon(R.drawable.ic_launcher_background);

    }
}
