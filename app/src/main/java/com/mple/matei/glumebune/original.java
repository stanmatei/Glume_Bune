package com.mple.matei.glumebune;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class original extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{
int a=0;
    private GestureDetectorCompat gesture;
    int[] arai = new int[30000];
    private static  TextView number;
    Button btnAddData;
    Button btnviewAll;
    DatabaseHelper myDb;
    private DatabaseReference mFav;
    private FirebaseAuth mAuth;
    private String current_user;
    private FirebaseAuth.AuthStateListener mAuthListener;

    Button bt;

    int a1=0;
    //private InterstitialAd mInterstitial2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_original);

        AdView adView3 =(AdView)findViewById(R.id.adView3);

        AdRequest adRequest3 = new AdRequest.Builder().build();

        adView3.loadAd(adRequest3);
        AdView adView4 =(AdView)findViewById(R.id.adView4);
        AdRequest adRequest4 = new AdRequest.Builder().build();
        adView4.loadAd(adRequest4);



         number = (TextView) findViewById(R.id.pisi);




        gesture= new GestureDetectorCompat(this,this);
        gesture.setOnDoubleTapListener(this);

        myDb = new DatabaseHelper(this);
        btnAddData = (Button)findViewById(R.id.button311);




                    btnAddData.setVisibility(View.INVISIBLE);
                    btnAddData.setEnabled(false);
                    mAuth=FirebaseAuth.getInstance();
                    mAuthListener = new FirebaseAuth.AuthStateListener() {
                        @Override
                        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                            if(firebaseAuth.getCurrentUser() != null){
                                btnAddData.setVisibility(View.VISIBLE);
                                btnAddData.setEnabled(true);
                    btnAddData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mFav= FirebaseDatabase.getInstance().getReference().child("Favorite").child(mAuth.getCurrentUser().getUid());
                            DatabaseReference push = mFav.child("Favorite").child(mAuth.getCurrentUser().getUid()).push();
                            String currentDate = DateFormat.getDateTimeInstance().format(new Date());
                            final String push_id = push.getKey();

                            long copa = System.currentTimeMillis();
                            long timp = 1000000000 - copa;
                            final Map map = new HashMap();
                            map.put("titlu", "Originala");
                            map.put("gluma", number.getText().toString());
                            map.put("name", "Almanah");
                            map.put("date", currentDate);
                            map.put("id", push_id);
                            map.put("categorie", "Almanah");
                            map.put("score", 10000);
                            map.put("timp", timp);
                            map.put("user_id", current_user);
                            map.put("real",0);
                            map.put("spam",0);



                            mFav.child(push_id).updateChildren(map, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                                    if (databaseError == null) {
                                        Toast.makeText(original.this, "Gluma a fost adaugata la favorite", Toast.LENGTH_LONG).show();


                                    } else if (databaseError != null) {
                                        Toast.makeText(original.this, databaseError.toString(), Toast.LENGTH_LONG).show();
                                    }


                                }
                            });
                        }
                    });
                }
            }
        };

        Typeface mytf1 =Typeface.createFromAsset(getAssets(), "TTWPGOTT.ttf");

        number.setTypeface(mytf1);

        bt=(Button)findViewById(R.id.button312);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = number.getText().toString();
                String shareSub = number.getText().toString() + " -----> Mai multe glume bune la https://play.google.com/store/apps/details?id=com.mple.matei.glumebune ";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Share using"));


            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        gesture.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void high(View view){
        SharedPreferences sharedPref = getSharedPreferences("highscore", Context.MODE_PRIVATE);
        String name = sharedPref.getString("high", "");

        TextView pisi = (TextView) findViewById(R.id.highsoce);
        pisi.setText(name);

    }




    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {


        if(a1<=0){
            number.setText("NEM! da swipe pentru glume!");
            a1++;
        }
        else {


            if (arai[a1 - 1] == 0) {
                number.setText("nu-mi plac astia de la electricitate, sunt foarte enel-vanti");
            }
            if (arai[a1 - 1] == 1) {
                number.setText("pe ce consola se joaca muschii?\n" +
                        "pe nintendon");
            }
            if (arai[a1 - 1] == 2) {
                number.setText("de ce intra personajele din povesti la puscarie?\n" +
                        "ca incalca LEGE-nda si dau MITa");
            }
            if (arai[a1 - 1] == 3) {
                number.setText("cum numesti o capra decapitata?\n" +
                        "o CORP-ra");
            }
            if (arai[a1 - 1] == 4) {
                number.setText("cum se misca o iapa? CAL-ca");
            }
            if (arai[a1 - 1] == 5) {
                number.setText("cu ce repari usa?\n" +
                        "cu un cioc-ciocan");
            }
            if (arai[a1 - 1] == 6) {
                number.setText("daca benzina ar fi magica, s-ar numi benzâna?");
            }
            if (arai[a1 - 1] == 7) {
                number.setText("cred ca sub ocean este apa-sator");
            }
            if (arai[a1 - 1] == 8) {
                number.setText("daca wapp-ul ar fi limbaj de programare s-ar numi seen++");
            }
            if (arai[a1 - 1] == 9) {
                number.setText("unde creste ata?\n" +
                        "in cop-AC");
            }
            if (arai[a1 - 1] == 10) {
                number.setText("nu inteleg somonii, sunt peşte nivelul meu");
            }
            if (arai[a1 - 1] == 11) {
                number.setText("ce zic furnicile cand raman blocate pe camp?\n" +
                        "iar ba?");
            }
            if (arai[a1 - 1] == 12) {
                number.setText("ce fac fructele cand le bati?\n" +
                        "GEM de durere");
            }
            if (arai[a1 - 1] == 13) {
                number.setText("daca te certi cu un copac s-ar putea sa-ti dea un pomn");
            }
            if (arai[a1 - 1] == 14) {
                number.setText("cum se numea fiul lui Traian?\n" +
                        "TraiLUNA?");
            }
            if (arai[a1 - 1] == 15) {
                number.setText("unde face baie Niagara?\n" +
                        "in cas-cada");
            }
            if (arai[a1 - 1] == 16) {
                number.setText("daca atunci cand e insorit este soare, atunci cand e innorat este sorn-are?");
            }
            if (arai[a1 - 1] == 17) {
                number.setText("ce metal gasesti in fund?\n" +
                        "mer-cur");
            }
            if (arai[a1 - 1] == 18) {
                number.setText("de ce s-au rupt pantofii?\n" +
                        "n-au tinut pasul");
            }
            if (arai[a1 - 1] == 19) {
                number.setText("de ce s-a spart oglinda? \n" +
                        "n-a facut fata");
            }
            if (arai[a1 - 1] == 20) {
                number.setText("cum se formeaza norii?\n" +
                        "in mod NOR-mal");
            }
            if (arai[a1 - 1] == 21) {
                number.setText("daca un om este chel se poate spune ca e păr-ăsit");
            }
            if (arai[a1 - 1] == 22) {
                number.setText("De ce apa gazoasa ar trebui sa fie gratis? \n" + "Prentru ca nu e plata.");
            }
            if (arai[a1 - 1] == 23) {
                number.setText("De ce nu poate un caine sa danseze? \n" +
                        "Pentru ca are doua picioare stangi");
            }
            if (arai[a1 - 1] == 24) {
                number.setText("De ce nu sunt de incredere aviatorii? \n" +
                        "Sunt mereu cu capul in nori!");
            }
            a1 = a1 - 1;
        }


















        return true;














    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        Random rodrigo =new Random();
        int numba = rodrigo.nextInt(25);



        a1++;
        arai[a1]=numba;
        if(a1>=5) {

            while (numba == arai[a1 - 2] || numba == arai[a1 - 3] ) {
                if (numba == 0) {
                    numba++;
                } else
                    numba = numba - 1;

            }
        }















        if(numba==0){
            number.setText("nu-mi plac astia de la electricitate, sunt foarte enel-vanti");
        }
        if(numba==1){
            number.setText("pe ce consola se joaca muschii?\n" +
                    "pe nintendon");
        }
        if(numba==2){
            number.setText("de ce intra personajele din povesti la puscarie?\n" +
                    "ca incalca LEGE-nda si dau MITa");
        }
        if(numba==3){
            number.setText("cum numesti o capra decapitata?\n" +
                    "o CORP-ra");
        }
        if(numba==4){
            number.setText("cum se misca o iapa? CAL-ca");
        }
        if(numba==5){
            number.setText("cu ce repari usa?\n" +
                    "cu un cioc-ciocan");
        }
        if(numba==6){
            number.setText("daca benzina ar fi magica, s-ar numi benzâna?");
        }
        if(numba==7){
            number.setText("cred ca sub ocean este apa-sator");
        }
        if(numba==8){
            number.setText("daca wapp-ul ar fi limbaj de programare s-ar numi seen++");
        }
        if(numba==9){
            number.setText("unde creste ata?\n" +
                    "in cop-AC");
        }
        if(numba==10){
            number.setText("nu inteleg somonii, sunt peşte nivelul meu");
        }
        if(numba==11){
            number.setText("ce zic furnicile cand raman blocate pe camp?\n" +
                    "iar ba?");
        }
        if(numba==12){
            number.setText("ce fac fructele cand le bati?\n" +
                    "gem de durere");
        }if(numba==13){
            number.setText("daca te certi cu un copac s-ar putea sa-ti dea un pomn");
        }
        if(numba==14){
            number.setText("cum se numea fiul lui Traian?\n" +
                    "TraiLUNA?");
        }
        if(numba==15){
            number.setText("unde face baie Niagara?\n" +
                    "in cas-cada");
        }
        if(numba==16){
            number.setText("daca atunci cand e insorit este soare, atunci cand e innorat este sorn-are?");
        }
        if(numba==17){
            number.setText("ce metal gasesti in fund?\n" +
                    "mer-cur");
        }
        if(numba==18){
            number.setText("de ce s-au rupt pantofii?\n" +
                    "n-au tinut pasul");
        }if(numba==19){
            number.setText("de ce s-a spart oglinda? \n" +
                    "n-a facut fata");
        }
        if(numba==20){
            number.setText("cum se formeaza norii?\n" +
                    "in mod NOR-mal");
        }
        if(numba==21){
            number.setText("daca un om este chel se poate spune ca e păr-ăsit");
        }
        if(numba==22){
            number.setText("De ce apa gazoasa ar trebui sa fie gratis? \n"+"Prentru ca nu e plata.");
        }
        if(numba==23){
            number.setText("De ce nu poate un caine sa danseze? \n" +
                    "Pentru ca are doua picioare stangi");
        }
        if(numba==24){
            number.setText("De ce nu sunt de incredere aviatorii? \n" +
                    "Sunt mereu cu capul in nori!");
        }
        a++;
        SharedPreferences sharedPref = getSharedPreferences("highscore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPref.edit();
        editor.putString("high", String.valueOf(a));
        editor.apply();














        return true;
    }
}
