package com.mple.matei.glumebune;

import android.app.AlertDialog;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.transition.TransitionManager;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class perle extends AppCompatActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener{
    ImageView carnat;
    DatabaseHelper myDb;

    Button btnAddData;
    Button btnviewAll;
    private DatabaseReference mFav;
    private FirebaseAuth mAuth;
    private String current_user;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static  TextView glumecc;

    int avvv;
    int[] arai = new int[30000];
    private GestureDetectorCompat gesture;


    int a=0;

    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_perle);

        avvv=0;

        AdView adViewh =(AdView)findViewById(R.id.adViewh);

        AdRequest adRequesth = new AdRequest.Builder().build();

        adViewh.loadAd(adRequesth);
        AdView adViewb =(AdView)findViewById(R.id.adViewb);

        AdRequest adRequestb = new AdRequest.Builder().build();

        adViewb.loadAd(adRequestb);



        glumecc=(TextView)findViewById(R.id.mamamataii);
        gesture= new GestureDetectorCompat(this,this);
        gesture.setOnDoubleTapListener(this);
        carnat=(ImageView)findViewById(R.id.carnat);

        Typeface mytf5 =Typeface.createFromAsset(getAssets(), "TTWPGOTT.ttf");

        glumecc.setTypeface(mytf5);

        myDb = new DatabaseHelper(this);
        btnAddData = (Button)findViewById(R.id.button4);




        bt=(Button)findViewById(R.id.button9);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = glumecc.getText().toString();
                String shareSub = glumecc.getText().toString() + " -----> Mai multe glume bune la https://play.google.com/store/apps/details?id=com.mple.matei.glumebune ";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Share using"));
                a++;


            }
        });




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
                            map.put("titlu", "Perla");
                            map.put("gluma", glumecc.getText().toString());
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
                                        Toast.makeText(perle.this, "Gluma a fost adaugata la favorite", Toast.LENGTH_LONG).show();


                                    } else if (databaseError != null) {
                                        Toast.makeText(perle.this, databaseError.toString(), Toast.LENGTH_LONG).show();
                                    }


                                }
                            });
                        }
                    });
                }
            }
        };















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


    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if(a<=0){
            glumecc.setText("NEM! da swipe pentru glume!");
            a++;
        }
        else {
            if (arai[a - 1] == 0) {
                glumecc.setText(" Daca esti prea deschis la minte s-ar putea sa-ti cada creierul... ");
            }
            if (arai[a - 1] == 1) {
                glumecc.setText("Batranetea este un pret prea mare pt. maturizare. ");
            }
            if (arai[a - 1] == 2) {
                glumecc.setText(" Daca trebuie sa alegi intre doua rele, alege-l pe cel pe care nu l-ai mai incercat niciodata. ");
            }
            if (arai[a - 1] == 3) {
                glumecc.setText("E mai usor sa obtii iertarea decat permisiunea. ");
            }
            if (arai[a - 1] == 4) {
                glumecc.setText(" Daca chiar arati ca poza din pasaport cu siguranta ai nevoie sa pleci in excursie. ");
            }
            if (arai[a - 1] == 5) {
                glumecc.setText("Mananca sanatos, fii in forma, mori oricum. ");
            }
            if (arai[a - 1] == 6) {
                glumecc.setText("O dieta echilibrata inseamna cate un biscuit in fiecare mana. ");
            }
            if (arai[a - 1] == 7) {
                glumecc.setText("Experienta e un lucru minunat. Te ajuta sa recunosti o greseala cand o faci din nou. ");
            }
            if (arai[a - 1] == 8) {
                glumecc.setText("O mana criminala a dat cu piciorul in chiuveta.");
            }
            if (arai[a - 1] == 9) {
                glumecc.setText("Dati-mi o bara metalica din lemn.");
            }
            if (arai[a - 1] == 10) {
                glumecc.setText("Am sa va tin cu ochii in soare pana la 12 noaptea.");
            }
            if (arai[a - 1] == 11) {
                glumecc.setText("Fa-mi o lista cu el.\n");
            }
            if (arai[a - 1] == 12) {
                glumecc.setText("Cand plecati acasa sa nu uitati vreo bricheta aprinsa in dulapuri");
            }
            if (arai[a - 1] == 13) {
                glumecc.setText("Sa nu va dati jos din mersul trenurilor.");
            }
            if (arai[a - 1] == 14) {
                glumecc.setText("Va doare mana sa bateti 3 pasi de defilare ?");
            }
            if (arai[a - 1] == 15) {
                glumecc.setText("Impartiti suprafata in 3 jumatati egale.");
            }
            if (arai[a - 1] == 16) {
                glumecc.setText("Lipeste calcaiele pe langa corp");
            }
            if (arai[a - 1] == 17) {
                glumecc.setText("De ce sa merg la inmormantarea lui .... ca el nu o sa vina la a mea");
            }
            if (arai[a - 1] == 18) {
                glumecc.setText("De urata nu-i frumoasa, dar e harnica putoarea");
            }
            if (arai[a - 1] == 19) {
                glumecc.setText("Porcul domestic nu se aseamana cu porcul comestibil.");
            }
            if (arai[a - 1] == 20) {
                glumecc.setText("E aici o beznuiala de nu vad nimic");
            }
            if (arai[a - 1] == 21) {
                glumecc.setText("Este adevarat, doctore, ca atunci cand cineva moare in somn, nu stie nimic pana a doua zi?");
            }
            if (arai[a - 1] == 22) {
                glumecc.setText("Fiul cel mare, cel de douazeci de ani, ca varsta are?");
            }
            if (arai[a - 1] == 23) {
                glumecc.setText("Este prea suspect ca sa bata la ochi");
            }
            if (arai[a - 1] == 24) {
                glumecc.setText("Cineva cu picioarele transpirate a pus mainile pe volan.");
            }
            if (arai[a - 1] == 25) {
                glumecc.setText("a straduieste-te si incearca");
            }
            if (arai[a - 1] == 26) {
                glumecc.setText("De joi pana joi e o saptamana si inca 2 zile.");
            }
            if (arai[a - 1] == 27) {
                glumecc.setText("Un arab scutura un covor de la etajul 4.\n" +
                        "Un trecator il intreaba: \n" +
                        "- Ce are? Nu porneste?");
            }
            if (arai[a - 1] == 28) {
                glumecc.setText("Nu testa niciodata adancimea apei cu ambele picioare");
            }
            if (arai[a - 1] == 29) {
                glumecc.setText("Pestele care lupta impotriva curentului… moare electrocutat.");
            }
            if (arai[a - 1] == 30) {
                glumecc.setText("Daca intr-o zi simti un gol mare in stomac… mananca, caci sigur ti-e foame!");
            }
            a = a - 1;
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
        glumecc.setText("Bravo");
        carnat.setImageResource(R.drawable.originale);

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Random rodrigo =new Random();
        int numba = rodrigo.nextInt(51);

        a++;
        arai[a]=numba;
        if(a>=5) {

            while (numba == arai[a - 2] || numba == arai[a - 3] ) {
                if (numba == 0) {
                    numba++;
                } else
                    numba = numba - 1;

            }
        }

         if(numba==0){
            glumecc.setText(" Daca esti prea deschis la minte s-ar putea sa-ti cada creierul... ") ;
        }
        if(numba==1){
            glumecc.setText("Batranetea este un pret prea mare pt. maturizare. ") ;
        }
        if(numba==2){
            glumecc.setText(" Daca trebuie sa alegi intre doua rele, alege-l pe cel pe care nu l-ai mai incercat niciodata. ") ;
        }
        if(numba==3){
            glumecc.setText("E mai usor sa obtii iertarea decat permisiunea. ") ;
        }
        if(numba==4){
            glumecc.setText(" Daca chiar arati ca poza din pasaport cu siguranta ai nevoie sa pleci in excursie. ") ;
        }
        if(numba==5){
            glumecc.setText("Mananca sanatos, fii in forma, mori oricum. ") ;
        }
        if(numba==6){
            glumecc.setText("O dieta echilibrata inseamna cate un biscuit in fiecare mana. ") ;
        }
        if(numba==7){
            glumecc.setText("Experienta e un lucru minunat. Te ajuta sa recunosti o greseala cand o faci din nou. ") ;
        }
        if(numba==8){
            glumecc.setText("O mana criminala a dat cu piciorul in chiuveta.") ;
        }
        if(numba==9){
            glumecc.setText("Dati-mi o bara metalica din lemn.") ;
        }
        if(numba==10){
            glumecc.setText("Am sa va tin cu ochii in soare pana la 12 noaptea.") ;
        }
        if(numba==11){
            glumecc.setText("Fa-mi o lista cu el.\n") ;
        }
        if(numba==12){
            glumecc.setText("Cand plecati acasa sa nu uitati vreo bricheta aprinsa in dulapuri") ;
        }
        if(numba==13){
            glumecc.setText("Sa nu va dati jos din mersul trenurilor.") ;
        }
        if(numba==14){
            glumecc.setText("Va doare mana sa bateti 3 pasi de defilare ?") ;
        }
        if(numba==15){
            glumecc.setText("Impartiti suprafata in 3 jumatati egale.") ;
        }
        if(numba==16){
            glumecc.setText("Lipeste calcaiele pe langa corp") ;
        }
        if(numba==17){
            glumecc.setText("De ce sa merg la inmormantarea lui .... ca el nu o sa vina la a mea") ;
        }
        if(numba==18){
            glumecc.setText("De urata nu-i frumoasa, dar e harnica putoarea") ;
        }
        if(numba==19){
            glumecc.setText("Porcul domestic nu se aseamana cu porcul comestibil.") ;
        }
        if(numba==20){
            glumecc.setText("E aici o beznuiala de nu vad nimic") ;
        }
        if(numba==21){
            glumecc.setText("Este adevarat, doctore, ca atunci cand cineva moare in somn, nu stie nimic pana a doua zi?") ;
        }
        if(numba==22){
            glumecc.setText("Fiul cel mare, cel de douazeci de ani, ca varsta are?") ;
        }
        if(numba==23){
            glumecc.setText("Este prea suspect ca sa bata la ochi") ;
        }
        if(numba==24){
            glumecc.setText("Cineva cu picioarele transpirate a pus mainile pe volan.") ;
        }
        if(numba==25){
            glumecc.setText("a straduieste-te si incearca") ;
        }
        if(numba==26){
            glumecc.setText("De joi pana joi e o saptamana si inca 2 zile.") ;
        }
        if(numba==27){
            glumecc.setText("Un arab scutura un covor de la etajul 4.\n" +
                    "Un trecator il intreaba: \n" +
                    "- Ce are? Nu porneste?") ;
        }
        if(numba==28){
            glumecc.setText("Nu testa niciodata adancimea apei cu ambele picioare") ;
        }
        if(numba==29){
            glumecc.setText("Pestele care lupta impotriva curentului… moare electrocutat.") ;
        }
        if(numba==30){
            glumecc.setText("Daca intr-o zi simti un gol mare in stomac… mananca, caci sigur ti-e foame!") ;
        }
        if(numba==31){
            glumecc.setText("Sunt înconjurat de animale. (Noe)");
        }
        if(numba==32){
            glumecc.setText("Viaţa este în continuă mişcare. (Parkinson)");
        }
        if(numba==33){
            glumecc.setText("Nu e nimic aşa de important ca să nu pot uita. (Alzheimer)");
        }
        if(numba==34){
            glumecc.setText("Viaţa mea e plină de aspiraţii. (un astmatic)");
        }if(numba==35){
            glumecc.setText("Eu am început rozându-mi unghiile. (Venus din Milo)");
        }
        if(numba==36){
            glumecc.setText("Niciodată n-am studiat drept. (Cocoşatul de la Notre Dame)");
        }
        if(numba==37){
            glumecc.setText("Cred în reîncarnare. (unghia)");
        }
        if(numba==38){
            glumecc.setText("Îmi place umanitatea. (un canibal)");
        }
        if(numba==39){
            glumecc.setText("Eşti singura femeie din viaţa mea. (Adam)");
        }
        if(numba==40){
            glumecc.setText("Mai bine să dai decât să primeşti. (un boxer)");
        }
        if(numba==41){
            glumecc.setText("Nu poţi muşca apa.");
        }
        if(numba==42){
            glumecc.setText(" Minciuna presupune studii superioare adevărului.");
        }
        if(numba==43){
            glumecc.setText("Dacă vreodată te simţi cumva prost, nu te duce la medic, oricum el nu are ce-ţi face.");
        }
        if(numba==44){
            glumecc.setText("Daca ajungi sa crezi ca esti prea mic pentru a putea sa te faci auzit, dormi o noapte cu un tantar! (Dalai Lama)");
        }
        if(numba==45){
            glumecc.setText("Vrei să ai o carieră?\n" +
                    "Fă-te miner!");
        }
        if(numba==46){
            glumecc.setText("Daca te-a muscat un caine rau, nu-fi face griji. Candva te va musca si unul bun.");
        }
        if(numba==47){
            glumecc.setText("Cine se scoala de dimineata inseamna ca are insomnie !");
        }
        if(numba==48){
            glumecc.setText("Voi sunteti 29 de cretini,eu sunt unul singur ! ");
        }
        if(numba==49){
            glumecc.setText("BA, VA CALC IN PICIOARE CU MANA MEA!");
        }
        if(numba==50){
            glumecc.setText("Pune mana si gandeste!");
        }

        









        return true;
    }
}
