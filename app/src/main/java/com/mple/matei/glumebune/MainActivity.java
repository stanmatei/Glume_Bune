package com.mple.matei.glumebune;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitial;
    private static int splash = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(MainActivity.this, futureActivity.class);
                startActivity(home);
                finish();
            }
        },splash);




















        /* AdView adView =(AdView)findViewById(R.id.adView4);

        AdRequest adRequest = new AdRequest.Builder().build();

        adView.loadAd(adRequest); */
        /* AdView adView2 =(AdView)findViewById(R.id.adView2);

        AdRequest adRequest2 = new AdRequest.Builder().build();

        adView2.loadAd(adRequest2); */

      /*  Button showAdButton =(Button)findViewById(R.id.show_ad_button);
        showAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mInterstitial.isLoaded()){
                    mInterstitial.show();

                }
            }
        });





        mInterstitial= new InterstitialAd(this);
        mInterstitial.setAdUnitId("ca-app-pub-2952778989892676/6492586270");
        AdRequest request = new AdRequest.Builder().build();
        mInterstitial.loadAd(request); */






    }
    public void meniu(View view) {
        Intent intentm = new Intent(this, meniu.class);

        startActivity(intentm);

    }












}
