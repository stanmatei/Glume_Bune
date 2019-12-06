package com.mple.matei.glumebune;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class extra extends AppCompatActivity {
    /* private InterstitialAd mInterstitial3;
    private InterstitialAd mInterstitial4;
    private InterstitialAd mInterstitial5;
    private InterstitialAd mInterstitial6;
    private InterstitialAd mInterstitial7;
    private InterstitialAd mInterstitial8;
    private InterstitialAd mInterstitial9;
    private InterstitialAd mInterstitial10;
    private InterstitialAd mInterstitial11;
    private InterstitialAd mInterstitial12;
    private InterstitialAd mInterstitial13;
    private InterstitialAd mInterstitial14;
    private InterstitialAd mInterstitial15;
    private InterstitialAd mInterstitial16;
    private InterstitialAd mInterstitial17;
    private InterstitialAd mInterstitial18;
    private InterstitialAd mInterstitial20; */
private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_extra);

        but=(Button)findViewById(R.id.butExt);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f = new Intent(extra.this,meniu.class);
                startActivity(f);
            }
        });





   /**     Button showAdButton1 =(Button)findViewById(R.id.z1);
        showAdButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial20.isLoaded()) {
                    mInterstitial20.show();

                }
            }
        });
        mInterstitial20 = new InterstitialAd(this);
        mInterstitial20.setAdUnitId("ca-app-pub-2952778989892676/5454836777");
        AdRequest request1 = new AdRequest.Builder().build();
        mInterstitial20.loadAd(request1);













        Button showAdButton2 =(Button)findViewById(R.id.z2);
        showAdButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial3.isLoaded()) {
                    mInterstitial3.show();

                }
            }
        });
        mInterstitial3= new InterstitialAd(this);
        mInterstitial3.setAdUnitId("ca-app-pub-2952778989892676/5847564925");
        AdRequest request2 = new AdRequest.Builder().build();
        mInterstitial3.loadAd(request2);











        Button showAdButton3 =(Button)findViewById(R.id.z3);
        showAdButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial4.isLoaded()) {
                    mInterstitial4.show();

                }
            }
        });
        mInterstitial4= new InterstitialAd(this);
        mInterstitial4.setAdUnitId("ca-app-pub-2952778989892676/4109965519");
        AdRequest request3 = new AdRequest.Builder().build();
        mInterstitial4.loadAd(request3);












        Button showAdButton4 =(Button)findViewById(R.id.z4);
        showAdButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial18.isLoaded()) {
                    mInterstitial18.show();

                }
            }
        });
        mInterstitial18= new InterstitialAd(this);
        mInterstitial18.setAdUnitId("ca-app-pub-2952778989892676/5655993232");
        AdRequest request4 = new AdRequest.Builder().build();
        mInterstitial18.loadAd(request4);















        Button showAdButton5 =(Button)findViewById(R.id.z5);
        showAdButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial5.isLoaded()) {
                    mInterstitial5.show();

                }
            }
        });
        mInterstitial5= new InterstitialAd(this);
        mInterstitial5.setAdUnitId("ca-app-pub-2952778989892676/9212094862");
        AdRequest request5 = new AdRequest.Builder().build();
        mInterstitial5.loadAd(request5);














        Button showAdButton6 =(Button)findViewById(R.id.z6);
        showAdButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial17.isLoaded()) {
                    mInterstitial17.show();

                }
            }
        });
        mInterstitial17= new InterstitialAd(this);
        mInterstitial17.setAdUnitId("ca-app-pub-2952778989892676/2361769570");
        AdRequest request6 = new AdRequest.Builder().build();
        mInterstitial17.loadAd(request6);



















        Button showAdButton7 =(Button)findViewById(R.id.z7);
        showAdButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial6.isLoaded()) {
                    mInterstitial6.show();

                }
            }
        });
        mInterstitial6= new InterstitialAd(this);
        mInterstitial6.setAdUnitId("ca-app-pub-2952778989892676/4796361220");
        AdRequest request7 = new AdRequest.Builder().build();
        mInterstitial6.loadAd(request7);














        Button showAdButton8 =(Button)findViewById(R.id.z8);
        showAdButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial16.isLoaded()) {
                    mInterstitial16.show();

                }
            }
        });
        mInterstitial16= new InterstitialAd(this);
        mInterstitial16.setAdUnitId("ca-app-pub-2952778989892676/8352462850");
        AdRequest request8 = new AdRequest.Builder().build();
        mInterstitial16.loadAd(request8);



















        Button showAdButton10 =(Button)findViewById(R.id.z9);
        showAdButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial7.isLoaded()) {
                    mInterstitial7.show();

                }
            }
        });
        mInterstitial7= new InterstitialAd(this);
        mInterstitial7.setAdUnitId("ca-app-pub-2952778989892676/9717515412");
        AdRequest request9 = new AdRequest.Builder().build();
        mInterstitial7.loadAd(request9);















        Button showAdButton11 =(Button)findViewById(R.id.z10);
        showAdButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial8.isLoaded()) {
                    mInterstitial8.show();

                }
            }
        });
        mInterstitial8= new InterstitialAd(this);
        mInterstitial8.setAdUnitId("ca-app-pub-2952778989892676/6193203373");
        AdRequest request10 = new AdRequest.Builder().build();
        mInterstitial8.loadAd(request10);
















        Button showAdButton12 =(Button)findViewById(R.id.z11);
        showAdButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial15.isLoaded()) {
                    mInterstitial15.show();

                }
            }
        });
        mInterstitial15= new InterstitialAd(this);
        mInterstitial15.setAdUnitId("ca-app-pub-2952778989892676/2151862494");
        AdRequest request11 = new AdRequest.Builder().build();
        mInterstitial15.loadAd(request11);


















        Button showAdButton13 =(Button)findViewById(R.id.z12);
        showAdButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial9.isLoaded()) {
                    mInterstitial9.show();

                }
            }
        });
        mInterstitial9= new InterstitialAd(this);
        mInterstitial9.setAdUnitId("ca-app-pub-2952778989892676/3025960462");
        AdRequest request12 = new AdRequest.Builder().build();
        mInterstitial9.loadAd(request12);

















        Button showAdButton14 =(Button)findViewById(R.id.z13);
        showAdButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial14.isLoaded()) {
                    mInterstitial14.show();

                }
            }
        });
        mInterstitial14= new InterstitialAd(this);
        mInterstitial14.setAdUnitId("ca-app-pub-2952778989892676/1329735418");
        AdRequest request13 = new AdRequest.Builder().build();
        mInterstitial14.loadAd(request13);















        Button showAdButton15 =(Button)findViewById(R.id.z14);
        showAdButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial10.isLoaded()) {
                    mInterstitial10.show();

                }
            }
        });
        mInterstitial10= new InterstitialAd(this);
        mInterstitial10.setAdUnitId("ca-app-pub-2952778989892676/7512000384");
        AdRequest request14 = new AdRequest.Builder().build();
        mInterstitial10.loadAd(request14);


















        Button showAdButton17 =(Button)findViewById(R.id.z15);
        showAdButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial11.isLoaded()) {
                    mInterstitial11.show();

                }
            }
        });
        mInterstitial11= new InterstitialAd(this);
        mInterstitial11.setAdUnitId("ca-app-pub-2952778989892676/8348593424");
        AdRequest request15 = new AdRequest.Builder().build();
        mInterstitial11.loadAd(request15);
















        Button showAdButton18 =(Button)findViewById(R.id.z16);
        showAdButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial12.isLoaded()) {
                    mInterstitial12.show();

                }
            }
        });
        mInterstitial12= new InterstitialAd(this);
        mInterstitial12.setAdUnitId("ca-app-pub-2952778989892676/9470103406");
        AdRequest request16 = new AdRequest.Builder().build();
        mInterstitial12.loadAd(request16);















        Button showAdButton19 =(Button)findViewById(R.id.z17);
        showAdButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitial13.isLoaded()) {
                    mInterstitial13.show();

                }
            }
        });
        mInterstitial13= new InterstitialAd(this);
        mInterstitial13.setAdUnitId("ca-app-pub-2952778989892676/1400041695");
        AdRequest request17 = new AdRequest.Builder().build();
        mInterstitial13.loadAd(request17); **/












































    }





}
