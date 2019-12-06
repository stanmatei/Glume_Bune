package com.mple.matei.glumebune;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class qwerty extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_qwerty);




        AdView adView223 =(AdView)findViewById(R.id.adView223);

        AdRequest adRequest223 = new AdRequest.Builder().build();

        adView223.loadAd(adRequest223);



    }
    public void pol(View view) {
        Intent intent9 = new Intent(this,master.class);

        startActivity(intent9);

    }
    public void w(View view) {
        Intent intent9 = new Intent(this,imagini.class);

        startActivity(intent9);

    }

    public void t(View view) {
        Intent intenti = new Intent(this, Game.class);
        startActivity(intenti);


    }
    public void u(View view) {
        Intent intent3 = new Intent(this, perle.class);
        startActivity(intent3);


    }



    }








