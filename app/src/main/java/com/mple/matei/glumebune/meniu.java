package com.mple.matei.glumebune;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Calendar;

public class meniu extends AppCompatActivity {
private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_meniu);
        ImageButton porc = (ImageButton)findViewById(R.id.b1);
        porc.getBackground().setAlpha(0);
        ImageButton porc1= (ImageButton)findViewById(R.id.b2);
        porc1.getBackground().setAlpha(0);
        ImageButton porc2 = (ImageButton)findViewById(R.id.show_ad_button);
        porc2.getBackground().setAlpha(0);
        ImageButton porc3 = (ImageButton)findViewById(R.id.button2);
        porc3.getBackground().setAlpha(0);
        ImageButton porc4 = (ImageButton)findViewById(R.id.button3);
        porc4.getBackground().setAlpha(0);
        ImageButton porc5 = (ImageButton)findViewById(R.id.imagini);
        porc5.getBackground().setAlpha(0);
        ImageButton porc6 = (ImageButton)findViewById(R.id.game);
        porc6.getBackground().setAlpha(0);







        AdView adViewp =(AdView)findViewById(R.id.adViewp);

        AdRequest adRequestp = new AdRequest.Builder().build();

        adViewp.loadAd(adRequestp);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        int i = preferences.getInt("numberoflaunches", 1);

        if(i < 2){
            alarmMethod();
            i++;
            editor.putInt("numberoflaunches",i);
            editor.commit();
        }

























    }



    private void alarmMethod(){
        Intent myIntent = new Intent(this,NotifyService.class);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        pendingIntent = PendingIntent.getService(this,0,myIntent,0);


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.AM_PM, Calendar.AM);
        calendar.add(Calendar.DAY_OF_MONTH, 1);



        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent);

        Toast.makeText(meniu.this, "YAAAS", Toast.LENGTH_LONG).show();

    }









































    public void game(View view) {
        Intent intent9 = new Intent(this, glumaz.class);

        startActivity(intent9);

    }

    public void img(View view) {
        Intent intenti = new Intent(this, multe.class);
        startActivity(intenti);


    }
    public void original(View view) {
        Intent intent3 = new Intent(this, original.class);
        startActivity(intent3);


    }
    public void perle(View view) {
        Intent intentp = new Intent(this, qwerty.class);

        startActivity(intentp);

    }
    public void clasic(View view) {
        Intent intent4 = new Intent(this, clasic.class);

        startActivity(intent4);

    }
    public void lungi(View view) {
        Intent intentl = new Intent(this, lungi.class);

        startActivity(intentl);

    }
    public void extra(View view) {
        Intent intent5 = new Intent(this, extra.class);

        startActivity(intent5);

    }
}
