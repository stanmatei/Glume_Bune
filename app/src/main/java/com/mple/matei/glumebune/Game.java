package com.mple.matei.glumebune;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class Game extends AppCompatActivity {
int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);



        AdView adView5 =(AdView)findViewById(R.id.adView5);

        AdRequest adRequest4 = new AdRequest.Builder().build();

        adView5.loadAd(adRequest4);


        AdView adView6 =(AdView)findViewById(R.id.adView6);

        AdRequest adRequest6 = new AdRequest.Builder().build();

        adView6.loadAd(adRequest6);






    }

    public void generate(View view) {
        a = a + 1;
        Random rodrigo = new Random();
        int numba = rodrigo.nextInt(40);
        TextView number = (TextView) findViewById(R.id.taco);
        String numBer = String.valueOf(numba);
        number.setText(numBer);


        if (numba == 7) {

            number.setText("L-ai gasit pe 7 in " + a + " incercari!");
            Toast.makeText(this, "L-ai gasit pe 7 din " + a +" incercari", Toast.LENGTH_LONG).show();

        }


    }



}
