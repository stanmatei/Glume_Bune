package com.mple.matei.glumebune;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;

/**
 * Created by Matei on 9/1/2017.
 */
public class NotifyService extends Service{

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){

        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationManager mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(this.getApplicationContext(), meniu.class);
        PendingIntent pIntent= PendingIntent.getActivity(this,0,intent1,0);


        Notification mNotify = new Notification.Builder(this)
                .setContentTitle(" Citeste niste glume bune!")
                .setContentText("Ia-ti doza zilnica de glume bune!")
                .setSmallIcon(R.drawable.pic13)
                .setSound(sound)
                .addAction(0,"citeste glume",pIntent)
                .build();


        mNM.notify(1,mNotify);



    }















}
