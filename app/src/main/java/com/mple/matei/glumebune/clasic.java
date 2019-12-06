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

public class clasic extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{
    TextView number;
    int[] arai = new int[30000];
    private GestureDetectorCompat gesture;
    private DatabaseReference mFav;
    private FirebaseAuth mAuth;
    private String current_user;
    private FirebaseAuth.AuthStateListener mAuthListener;
    int a=0;

    DatabaseHelper myDb;

    Button btnAddData;
    Button btnviewAll;

    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_clasic);
        AdView adViewk =(AdView)findViewById(R.id.adViewk);

        AdRequest adRequestk = new AdRequest.Builder().build();

        adViewk.loadAd(adRequestk);
        AdView adViewl =(AdView)findViewById(R.id.adViewl);

        AdRequest adRequestl = new AdRequest.Builder().build();

        adViewl.loadAd(adRequestl);


        myDb = new DatabaseHelper(this);
        btnAddData = (Button)findViewById(R.id.button111);






        number = (TextView) findViewById(R.id.textView5);
        gesture= new GestureDetectorCompat(this,this);
        gesture.setOnDoubleTapListener(this);
        Typeface mytf3 =Typeface.createFromAsset(getAssets(), "TTWPGOTT.ttf");

        number.setTypeface(mytf3);



        bt=(Button)findViewById(R.id.button112);
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
                            map.put("titlu", "Scurta");
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
                                        Toast.makeText(clasic.this, "Gluma a fost adaugata la favorite", Toast.LENGTH_LONG).show();


                                    } else if (databaseError != null) {
                                        Toast.makeText(clasic.this, databaseError.toString(), Toast.LENGTH_LONG).show();
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
            number.setText("NEM! da swipe pentru glume!");
            a++;
        }

           else{
            int numba = arai[a - 1];

        if (arai[a - 1] == 0) {
            number.setText("Niciodată să nu ai incredere intr-un frizer chel : n-are respect pentru păr ");
        }
        if (arai[a - 1] == 1) {
            number.setText("Cioc, cioc...\n" +
                    "- Cine e?\n" +
                    "- ANA.\n" +
                    "- Ana și mai cum?\n" +
                    "- ANAF.");
        }
        if (arai[a - 1] == 2) {
            number.setText("Sunt atat de multilateral, incat am ajuns aproape sferic!");
        }
        if (arai[a - 1] == 3) {
            number.setText("Cele mai multe atentate sunt în Mall-uri pentru că multe magazine anunță că vor arunca prețurile în aer.");
        }
        if (arai[a - 1] == 4) {
            number.setText("Legile sunt precum cârnaţii. E mai bine să nu te uiţi cum se fac.");
        }
        if (arai[a - 1] == 5) {
            number.setText("Daca oamenii te vorbesc pe la spate, inseamna ca esti inaintea lor.");
        }
        if (arai[a - 1] == 6) {
            number.setText("Ieri am fost la vânătoare, după 66 de împușcături, cerbul a murit de râs.");
        }
        if (arai[a - 1] == 7) {
            number.setText("Dacă ciorapii mei ar scrie o poezie, ar fi cu rimă desperecheată.");
        }
        if (arai[a - 1] == 8) {
            number.setText("Voiam sa va zic de poligamie dar m-am luat cu altele");
        }
        if (arai[a - 1] == 9) {
            number.setText("Am avut mari emoții anul trecut când mi-am construit casa. Partea bună e că au fost emoții constructive.");
        }
        if (arai[a - 1] == 10) {
            number.setText("Intre doi tantari: \n" +
                    "- Tu crezi in Dracula?\n" +
                    "- Nu, sunt ateu!");
        }
        if (arai[a - 1] == 11) {
            number.setText("- Domnule Doctor, mi-am rupt piciorul in 2 locuri\n" +
                    "- Pai atunci nu te mai duce in acele 2 locuri");
        }
        if (arai[a - 1] == 12) {
            number.setText("Omul e ca zugravul----Traieste si moare!");
        }
        if (arai[a - 1] == 13) {
            number.setText("Ce toamna frumoasa avem primavara asta !");
        }
        if (arai[a - 1] == 14) {
            number.setText("- Da, as putea sa incerc sa nu mai fiu atat de egoist, doar ca nu stiu cu ce m-as alege din treaba asta...?!");
        }
        if (arai[a - 1] == 15) {
            number.setText("In caz de incendiu, nu folositi liftul! Folositi apa!");
        }
        if (arai[a - 1] == 16) {
            number.setText("DOI COPII NUMARAU O BILA");
        }
        if (arai[a - 1] == 17) {
            number.setText("Ultimele studii ale oamenilor de stiinta au aratat ca nasterea creste dramatic sansele de a muri.");
        }
        if (arai[a - 1] == 18) {
            number.setText("Jocul preferat al zugravilor: Mortar Kombat.");
        }
        if (arai[a - 1] == 19) {
            number.setText("Puterea leului nu este de cumparare, este de intimidare....");
        }
        if (arai[a - 1] == 20) {
            number.setText("Ministrul Mediului : din cauza caniculei, de mâine vom trece la ora de iarnă.");
        }
        if (arai[a - 1] == 21) {
            number.setText("De ce nu se îneacă somalezii? Pentru că nu au cu ce.");
        }
        if (arai[a - 1] == 22) {
            number.setText("Astăzi am fost răpus la pat de o forță nevăzută: gravitația.");
        }
        if (arai[a - 1] == 23) {
            number.setText("-Ai auzit , se mărită CFR ?\n" +
                    "- Marfă !!");
        }
        if (arai[a - 1] == 24) {
            number.setText("- Aveti paine la 2lei? \n" +
                    "- Da. \n" +
                    "- Şi cat costa?");
        }
        if (numba == 25) {
            number.setText("Doi poliţişti discută:\n" +
                            "- De ce îţi pui copilul să doarmă pe dulap?\n" +
                            "- Data trecută a căzut din pat şi n-am auzit.\n"
            );
        }
        if (numba == 26) {
            number.setText("In faţa grătarului cu mici romanul încearcă un sentiment de măreţie istorică.\n"
            );
        }
        if (numba == 27) {
            number.setText("- Tăticule, tu ai o bună memorie vizuală ?\n" +
                    "- Sigur că da, am ...\n" +
                    "- Ei bine, atunci să ştii că tocmai am spart oglinda în care te bărbiereai\n");
        }
        if (numba == 28) {
            number.setText("I:De ce nu le intra capul in borcan?\n" +
                    "R:Din cauza cozorocului.\n");
        }
        if (numba == 29) {
            number.setText("Giorgică se prezintă la spital cu corpul făcut ,,franjuri “.\n" +
                    "-\tCe s-a întâmplat ?\n" +
                    "-\tAm călcat pe o petardă rămasă neexploadată , de la Revelionul din 1943 !!!\n");
        }
        if (numba == 30) {
            number.setText("Ca sa iti dai seama ca esti prost, trebuie sa fii destept.Iar daca nu iti dai seama ca esti destept, inseamna ca esti prost\n");
        }
        if (numba == 31) {
            number.setText("-Gigele,ai un deget ìn nas!\n" +
                    "-Stiu doamna ìnvatatoare, este al meu!!\n");
        }
        if (numba == 32) {
            number.setText(": Cum spun chinezii la scaieti?!\n" +
                    "R: CIU LIN.\n");
        }
        if (numba == 33) {
            number.setText("Bula la psiholog:\n" +
                    "-Si... spune-mi Bula, cand ai observat ca esti cal?\n" +
                    "-ehe... inca de pe vremea cand eram manz.\n");
        }
        if (numba == 34) {
            number.setText("Culmea Yoga:\n" +
                    "- Sa-ti tragi un cap în gura!!!\n");
        }
        if (numba == 35) {
            number.setText("Ediția actuala de Master Chef, va fi câștigată de DNA, cu un souffle de mazăre.\n");
        }
        if (numba == 36) {
            number.setText("\"Ce bomba am fost si ce petarda am ajuns!...\" gandea o pocnitoare.\n");
        }
        if (numba == 37) {
            number.setText("La mare:\n" +
                    "-Mamico ,plange Bulisor , nenea ala din apa a strigat la mine\n" +
                    "-Si ce-a strigat\n" +
                    "-Ajutor!\n");
        }
        if (numba == 38) {
            number.setText("cum ii treaba cu ciupercile?\n" +
                    "I: - Toate ciupercile sunt comestibile?\n" +
                    "R: - Da, dar unele o singure data ......\n");
        }
        if (numba == 39) {
            number.setText("Schimba-ti viata: Stai pe televizor si uita-te la fotoliu!\n");
        }
        if (numba == 40) {
            number.setText("-Domnule doctor, dati-mi va rog o pastila impotriva lacomiei, dar sa fie mai mare.\n");
        }
        if (numba == 41) {
            number.setText("Ai ceva de băut ?\n" +
                    "Apă.\n" +
                    "Dar ceva mai tare ?\n" +
                    "Gheaţă!");
        }
        if (numba == 42) {
            number.setText("I: Este adevarat ca extraterestrii sunt anti-Basescu?\n" +
                    "R: Cei cu antene, da.");
        }
        if (numba == 43) {
            number.setText("- V-am povestit vreodata despre mine? Minele sunt niste gauri din care ies minerii!");
        }
        if (numba == 44) {
            number.setText("El si cu ea stau pe marginea prapastiei. Ei i se facu cald. El ii facu vant.");
        }
        if (numba == 45) {
            number.setText("Era odata o gasca de gaini. Si toate aveau geci de piele..");
        }
        if (numba == 46) {
            number.setText("Cine rade la urma, gandeste mai incet.");
        }
        if (numba == 47) {
            number.setText("Un snur se uita in oglinda si zambind pe sub mustati, spune:\n" +
                    "- Mamaaa, ce siret sunt!");
        }
        if (numba == 48) {
            number.setText("Merge Bula la posta si ii spune postasului\n" +
                    "- Nu va suparati, astept o scrisoare!\n" +
                    "- Nu ma supar, asteptati!");
        }
        if (numba == 49) {
            number.setText("- Ce este galben cu doua dungi negre?\n" +
                    "- O lamaie cu bretele!");
        }
        if (numba == 50) {
            number.setText("Ce ii spune un semafor altuia? - Nu te uita la mine, ca ma inrosesc!");
        }
        if (numba == 51) {
            number.setText("Discutie intre doua cirese:\n" +
                    "- Am un vierme uite-asa de mare!!\n" +
                    "- Stricato!");
        }
        if (numba == 52) {
            number.setText("Care este cel mai sec banc?\n" +
                    "Nu mai este apa!");
        }
        if (numba == 53) {
            number.setText("- Domnisoara, sunteti pesimista ?\n" +
                    "- Nu, croitoreasa.");
        }
        if (numba == 54) {
            number.setText("Un tip merge la psiholog:\n" +
                    "- Doctore, sunt confuz.. sau poate nu..");
        }
        if (numba == 55) {
            number.setText("Stiti cu ce seamana o jumatate de portocala? Cu cealalta jumatate.");
        }
        if (numba == 56) {
            number.setText("Un om statea pe ganduri, dar cand sa-i vina ideea, a alunecat.");
        }
        if (numba == 57) {
            number.setText("Doua bomboane stau pe acoperis. Care sare prima?\n" +
                    "Aia de menta.");
        }
        if (numba == 58) {
            number.setText("Intrebare de baraj:\n" +
                    "- Ce inaltime avea barajul?");
        }
        if (numba == 59) {
            number.setText("- Cine l-a batut prima data pe Stefan cel Mare ?\n" +
                    "- Maica-sa.");
        }
        if (numba == 60) {
            number.setText("Discutie intre 2 pereti:\n" +
                    "- Ne intalnim la colt ?");
        }
        if (numba == 61) {
            number.setText("- In ce luna se nasc cei mai multi copii ?\n" +
                    "- In luna a noua ..");
        }
        if (numba == 62) {
            number.setText("- O pizza, va rog !\n" +
                    "- Taiata in 6 sau in 12 ?\n" +
                    "- In 6, ca 12 bucati nu pot sa mananc...");
        }
        if (numba == 63) {
            number.setText("Portofelul celor neatenti coboara cu o statie inaintea lor.");
        }
        if (numba == 64) {
            number.setText("Postasul bate la usa:\n" +
                    "- Cine e ?\n" +
                    "- Posta !\n" +
                    "- Si cati sunteti ?");
        }
        if (numba == 65) {
            number.setText("Oferta promotionala:\n" +
                    "- Daca cumparati un pantof, primiti unul gratis ! Cadou !");
        }
        if (numba == 66) {
            number.setText("- Mamico, cine face un copil din flori ?\n" +
                    "- O vaza.");
        }
        if (numba == 67) {
            number.setText("Culmea sovaielii: sa ezit, sa nu ezit..");
        }
        if (numba == 68) {
            number.setText("Culmea melancoliei: sa cazi pe ganduri si sa-ti rupi mana.");
        }
        if (numba == 69) {
            number.setText("Culmea zborului: sa zbori pe cerul gurii.");
        }
        if (numba == 70) {
            number.setText("Culmea strabismului: un ciclop sasiu.");
        }
        if (numba == 71) {
            number.setText("Singurul lucru care poate opri caderea parului este podeaua.");
        }
        if (numba == 72) {
            number.setText("Nu conteaza daca esti sarac sau bogat. Conteaza sa ai bani!");
        }
        if (arai[a - 1] == 73) {
            number.setText("Un canibal merge la vraciul tribului:\n" +
                    "- Am arsuri la stomac, ce sa fac ?\n" +
                    "- Mananca un pompier.");
        }
        if (arai[a - 1] == 74) {
            number.setText("- Cum ai ajuns sa te angajezi la circ pe post de Om-ghiulea?\n" +
                    "- Patronul mi-a spus ca are nevoie de un om de calibrul meu.");
        }
        if (arai[a - 1] == 75) {
            number.setText("De ce are rinocerul corn? Pentru că nu a găsit chiflă.\n");
        }
        if (arai[a - 1] == 76) {
            number.setText("Cum se uită o raţă în beci? - Iei raţa, o duci în beci şi o uiţi acolo...\n");
        }
        if (arai[a - 1] == 77) {
            number.setText("Ce au în comun un elefant şi o zebră?                                                                                                 - Amândoi au trompe, cu excepţia zebrei.\n");
        }
        if (arai[a - 1] == 78) {
            number.setText("Mihai Viteazu mergea pe cal şi dintr-o dată cade. De ce?                                                                  - S-a terminat calul!\n");
        }
        if (arai[a - 1] == 79) {
            number.setText("De ce are veveriţa coadă în spate?                                                                                                 – Pentru că nu o are în faţă...\n");
        }
        if (arai[a - 1] == 80) {
            number.setText("UN OM AVEA UN CAL, IAR CALUL NU AVEA NIMIC IMPOTRIVA!");
        }
        if (arai[a - 1] == 81) {
            number.setText("q:Care e diferentza intre o gaina? \n" +
                    "a:Are picioarele paralele. dar mai mult stangul!");
        }
        if (arai[a - 1] == 82) {
            number.setText("Q: Care e diferenta intre o cartita si un vultur?\n" +
                    "A: Amandoi merg pe sub pamant cu exceptia vulturului.");
        }
        if (arai[a - 1] == 83) {
            number.setText("Erau doi cai:Unu era alb si unu a luat-o la dreapta.");
        }
        if (arai[a - 1] == 84) {
            number.setText("- Cand sta barza intr-un picior?\n" +
                    "- Cand si-l ridica pe celalalt!");
        }
        if (arai[a - 1] == 85) {
            number.setText("Ce ar fi facut printesa Diana daca ar fi fost vie?\n" +
                    "STRUGURI!");
        }
        if (arai[a - 1] == 86) {
            number.setText("- Cum se sinucide un melc?\n" +
                    "- Se uita in priza!");
        }
        if (arai[a - 1] == 87) {
            number.setText("- V-am povestit vreodata despre mine?\n" +
                    "- Minele sunt niste gauri din care ies minerii!");
        }
        if (numba == 88) {
            number.setText("bula mergea la socala. la un moment dat a ajuns");
        }
        if (arai[a - 1] == 89) {
            number.setText("ce umbla pe sub pamant si incepe cu litera \"d\"?\n" +
                    "R: doua rame");
        }
        if (arai[a - 1] == 90) {
            number.setText("Baba se duce la doctor. \n " + "Domnule doctor aud voci.\n" + "Si ce spun vocile?\n" + " Nu stiu sa sunt surda");
        }
        if (arai[a - 1] == 91) {
            number.setText("Un caine merge prin desert si spune: Daca nu gasesc un pom, fac pe mine!");
        }
        if (arai[a - 1] == 92) {
            number.setText("Cum se obtine lumina cu ajutorul apei?\n" +
                    "Spaland geamurile.");
        }
        if (arai[a - 1] == 93) {
            number.setText("\"Pe o scara de la 1 la 10 cat...\"\n" +
                    "\"10!\"\n" +
                    "\"... de nerabdator esti?\"");
        }
        if (arai[a - 1] == 94) {
            number.setText("Viata este ca si o scrumiera , plina de indoieli mici !");
        }
        if (arai[a - 1] == 95) {
            number.setText("Dă-mi Doamne răbdare .\n" +
                    "Dar imediat !!!");
        }
        if (arai[a - 1] == 96) {
            number.setText("Eu sunt ceea ce sunt și nu ma schimb!\" \n" +
                    "Nu te schimba, și ai să mirosi perfect după un timp!");
        }
        if (arai[a - 1] == 97) {
            number.setText("- Arati bine cu ochelarii astia noi.\n" +
                    "- Dar nu am ochelari noi...\n" +
                    "- Eu am!");
        }
        if (arai[a - 1] == 98) {
            number.setText("Nu repar prizele din casă pentru că nu-mi stă-n fire.");
        }
        if (arai[a - 1] == 99) {
            number.setText("Ori devii nemuritor, ori mori încercând!");
        }
        if (arai[a - 1] == 100) {
            number.setText("Mă durea sufletul, am început tratamentul. Acum mă dor rinichii și ficatul.");
        }
        if (arai[a - 1] == 101) {
            number.setText("Heliu intră într-un bar. Barmanul spune: Îmi pare rău, nu servim gaze nobile! Heliu nu reacționează.");
        }
        if (arai[a - 1] == 102) {
            number.setText("I: De ce ai vrea sa lingi o priza?\n" +
                    "R: Pentru ca are gust de alb");
        }
        if (arai[a - 1] == 103) {
            number.setText("Ce asemanare este intre un caine? Deoarece are si coada.");
        }
        if (arai[a - 1] == 104) {
            number.setText("\"Astazi mi-am gasit perechea\" \n" +
                    "- scrise o soseta in jurnal..");
        }
        if (arai[a - 1] == 105) {
            number.setText("- De ce iarna nu-i ca vara ?\n" +
                    "- Pentru ca vara nu-i ca iarna !");
        }
        if (arai[a - 1] == 106) {
            number.setText("- Cum a murit Mihai Viteazul ?\n" +
                    "- A suferit un atac de cort.");
        }
        if (arai[a - 1] == 107) {
            number.setText("Amintește-ți întotdeauna că ești unic, la fel ca toată lumea.");
        }
        if (arai[a - 1] == 108) {
            number.setText("Dacă părinții tăi nu au avut niciodată copii, sunt șanse mari ca nici tu să nu ai.");
        }
        if (arai[a - 1] == 109) {
            number.setText("- Domnisoara, sunteti insarcinata. Veti avea un copil.\n" +
                    "- Domnule doctor, dar sunteti sigur ca e al meu ?");
        }
        if (arai[a - 1] == 110) {
            number.setText("Astazi, viata mea s-a schimbat radical.\n" +
                    "\n" +
                    "Dimineata aveam 16 lei si acum mai am doar 4.");
        }
        if (arai[a - 1] == 111) {
            number.setText("- Stii bancul cu pamantul?\n" +
                    "- Nu.\n" +
                    "- Pai vezi?... Esti aerian!");
        }
        if (arai[a - 1] == 112) {
            number.setText(" Chelner! am o musca in unt!\n" +
                    "- Domnule, nu e musca, ci molie si nu e unt, ci margarina!");
        }
        if (arai[a - 1] == 113) {
            number.setText("Dupa ce am vazut pentru prima data o telecomanda universala, m-am gandit: \n" +
                    "Ei bine, acest lucru va schimba totul.");
        }
        if (arai[a - 1] == 114) {
            number.setText("De Crăciun am primit o tabletă. Partea ciudată e că nici măcar n-am știut că sunt bolnav.");
        }
        if (arai[a - 1] == 115) {
            number.setText("- Acuzat, eşti condamnat la 30 de ani de închisoare.\n" +
                    "- Dar, domnule judecător, nu cred că mai trăiesc atăt!\n" +
                    "- Fă şi tu cât poţi...");
        }
        if (arai[a - 1] == 116) {
            number.setText("Degeaba a avansat tehnologia. Dalmatianul meu tot alb-negru iese in poze.");
        }
        if (arai[a - 1] == 117) {
            number.setText("Patronul brutariei de la colt mi-a explicat ca nu prea are incredere in brutar, simte ca mereu ii coace ceva.");
        }
        if (arai[a - 1] == 118) {
            number.setText("I: Care dintre neuronii unei blonde este mai putin dezvoltat?\n" +
                    "R: Celalalt.");
        }
        if (arai[a - 1] == 119) {
            number.setText("Ce face un emo cand se taie cu lama?\n" +
                    "R: Emoragie");
        }
        if (arai[a - 1] == 120) {
            number.setText("După ce-am fost înjunghiat de vreo 2 ori, mi-am dat seama că sunt alergic la cuţit.");
        }
        if (arai[a - 1] == 121) {
            number.setText("- Mama nu ma lasa sa tin caine in casa...\n" +
                    "- Dar tatal tau?\n" +
                    "- Pe el il lasa.");
        }
        if (arai[a - 1] == 122) {
            number.setText("Oxigenul și Magneziul și-au dat întâlnire. OMg!");
        }
        if (arai[a - 1] == 123) {
            number.setText("Am facut multe lucruri rele anul asta. Dar le-am facut foarte bine..");
        }
        if (arai[a - 1] == 124) {
            number.setText("Nu spun ca am ghinion, dar cand mi-am cumparat o saltea din aia cu memorie, am nimerit una care avea Alzheimer!");
        }
        if (arai[a - 1] == 125) {
            number.setText("Eu oricand as putea sa devin campion mondial la sah. Trebuie doar sa vreau si sa pot");
        }
        if (arai[a - 1] == 126) {
            number.setText("Azi m-am dus la piata sa cumpar paine dar taranii mi-au spus ca anul acesta n-au plantat paine in gradina.");
        }
        if (arai[a - 1] == 127) {
            number.setText("- Bunico, vreau paine cu unt.\n" +
                    "- Iti dau cu bucurie, draga mea\n" +
                    "- Dar eu vreau cu unt, nu cu bucurie!");
        }
        if (arai[a - 1] == 128) {
            number.setText("Pe o pasune erau trei cai. Unul alb, unul maro si unul mai incolo.");
        }
        if (arai[a - 1] == 129) {
            number.setText("Doi crocodili croshetau apa minerala intr-un subsol la etajul 7. Unul dintre ei il intreaba pe celalalt: \n" +
                    "- Nu stii dragul meu, mai e mult pana departe ?");
        }
            a=a-1;
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

        Random rodrigo = new Random();
        int numba = rodrigo.nextInt(130);

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

        if (numba == 0) {
            number.setText("Niciodată să nu ai incredere intr-un frizer chel : n-are respect pentru păr ");
        }
        if (numba == 1) {
            number.setText("Cioc, cioc...\n" +
                    "- Cine e?\n" +
                    "- ANA.\n" +
                    "- Ana și mai cum?\n" +
                    "- ANAF.");
        }
        if (numba == 2) {
            number.setText("Sunt atat de multilateral, incat am ajuns aproape sferic!");
        }
        if (numba == 3) {
            number.setText("Cele mai multe atentate sunt în Mall-uri pentru că multe magazine anunță că vor arunca prețurile în aer.");
        }
        if (numba == 4) {
            number.setText("Legile sunt precum cârnaţii. E mai bine să nu te uiţi cum se fac.");
        }
        if (numba == 5) {
            number.setText("Daca oamenii te vorbesc pe la spate, inseamna ca esti inaintea lor.");
        }
        if (numba == 6) {
            number.setText("Ieri am fost la vânătoare, după 66 de împușcături, cerbul a murit de râs.");
        }
        if (numba == 7) {
            number.setText("Dacă ciorapii mei ar scrie o poezie, ar fi cu rimă desperecheată.");
        }
        if (numba == 8) {
            number.setText("Voiam sa va zic de poligamie dar m-am luat cu altele");
        }
        if (numba == 9) {
            number.setText("Am avut mari emoții anul trecut când mi-am construit casa. Partea bună e că au fost emoții constructive.");
        }
        if (numba == 10) {
            number.setText("Intre doi tantari: \n" +
                    "- Tu crezi in Dracula?\n" +
                    "- Nu, sunt ateu!");
        }
        if (numba == 11) {
            number.setText("- Domnule Doctor, mi-am rupt piciorul in 2 locuri\n" +
                    "- Pai atunci nu te mai duce in acele 2 locuri");
        }
        if (numba == 12) {
            number.setText("Omul e ca zugravul----Traieste si moare!");
        }
        if (numba == 13) {
            number.setText("Ce toamna frumoasa avem primavara asta !");
        }
        if (numba == 14) {
            number.setText("- Da, as putea sa incerc sa nu mai fiu atat de egoist, doar ca nu stiu cu ce m-as alege din treaba asta...?!");
        }
        if (numba == 15) {
            number.setText("In caz de incendiu, nu folositi liftul! Folositi apa!");
        }
        if (numba == 16) {
            number.setText("DOI COPII NUMARAU O BILA");
        }
        if (numba == 17) {
            number.setText("Ultimele studii ale oamenilor de stiinta au aratat ca nasterea creste dramatic sansele de a muri.");
        }
        if (numba == 18) {
            number.setText("Jocul preferat al zugravilor: Mortar Kombat.");
        }
        if (numba == 19) {
            number.setText("Puterea leului nu este de cumparare, este de intimidare....");
        }
        if (numba == 20) {
            number.setText("Ministrul Mediului : din cauza caniculei, de mâine vom trece la ora de iarnă.");
        }
        if (numba == 21) {
            number.setText("De ce nu se îneacă somalezii? Pentru că nu au cu ce.");
        }
        if (numba == 22) {
            number.setText("Astăzi am fost răpus la pat de o forță nevăzută: gravitația.");
        }
        if (numba == 23) {
            number.setText("-Ai auzit , se mărită CFR ?\n" +
                    "- Marfă !!");
        }
        if (numba == 24) {
            number.setText("- Aveti paine la 2lei? \n" +
                    "- Da. \n" +
                    "- Şi cat costa?");
        }
        if (numba ==25) {
            number.setText("Doi poliţişti discută:\n" +
                    "- De ce îţi pui copilul să doarmă pe dulap?\n" +
                    "- Data trecută a căzut din pat şi n-am auzit.\n"
                    );
        }
        if (numba ==26 ) {
            number.setText("In faţa grătarului cu mici romanul încearcă un sentiment de măreţie istorică.\n"
                    );
        }
        if (numba ==27 ) {
            number.setText("- Tăticule, tu ai o bună memorie vizuală ?\n" +
                    "- Sigur că da, am ...\n" +
                    "- Ei bine, atunci să ştii că tocmai am spart oglinda în care te bărbiereai\n");
        }
        if (numba ==28 ) {
            number.setText("I:De ce nu le intra capul in borcan?\n" +
                    "R:Din cauza cozorocului.\n");
        }
        if (numba ==29 ) {
            number.setText("Giorgică se prezintă la spital cu corpul făcut ,,franjuri “.\n" +
                    "-\tCe s-a întâmplat ?\n" +
                    "-\tAm călcat pe o petardă rămasă neexploadată , de la Revelionul din 1943 !!!\n");
        }
        if (numba ==30 ) {
            number.setText("Ca sa iti dai seama ca esti prost, trebuie sa fii destept.Iar daca nu iti dai seama ca esti destept, inseamna ca esti prost\n" );
        }
        if (numba ==31 ) {
            number.setText("-Gigele,ai un deget ìn nas!\n" +
                    "-Stiu doamna ìnvatatoare, este al meu!!\n");
        }
        if (numba ==32 ) {
            number.setText(": Cum spun chinezii la scaieti?!\n" +
                    "R: CIU LIN.\n");
        }
        if (numba ==33 ) {
            number.setText("Bula la psiholog:\n" +
                    "-Si... spune-mi Bula, cand ai observat ca esti cal?\n" +
                    "-ehe... inca de pe vremea cand eram manz.\n");
        }
        if (numba ==34 ) {
            number.setText("Culmea Yoga:\n" +
                    "- Sa-ti tragi un cap în gura!!!\n" );
        }
        if (numba == 35) {
            number.setText("Ediția actuala de Master Chef, va fi câștigată de DNA, cu un souffle de mazăre.\n" );
        }
        if (numba ==36 ) {
            number.setText("\"Ce bomba am fost si ce petarda am ajuns!...\" gandea o pocnitoare.\n");
        }
        if (numba ==37 ) {
            number.setText("La mare:\n" +
                    "-Mamico ,plange Bulisor , nenea ala din apa a strigat la mine\n" +
                    "-Si ce-a strigat\n" +
                    "-Ajutor!\n");
        }
        if (numba ==38 ) {
            number.setText("cum ii treaba cu ciupercile?\n" +
                    "I: - Toate ciupercile sunt comestibile?\n" +
                    "R: - Da, dar unele o singure data ......\n");
        }
        if (numba ==39 ) {
            number.setText("Schimba-ti viata: Stai pe televizor si uita-te la fotoliu!\n" );
        }
        if (numba ==40 ) {
            number.setText("-Domnule doctor, dati-mi va rog o pastila impotriva lacomiei, dar sa fie mai mare.\n" );
        }
        if (numba ==41 ) {
            number.setText("Ai ceva de băut ?\n" +
                    "Apă.\n" +
                    "Dar ceva mai tare ?\n" +
                    "Gheaţă!");
        }
        if (numba == 42) {
            number.setText("I: Este adevarat ca extraterestrii sunt anti-Basescu?\n" +
                    "R: Cei cu antene, da.");
        }
        if (numba == 43) {
            number.setText("- V-am povestit vreodata despre mine? Minele sunt niste gauri din care ies minerii!");
        }
        if (numba ==44 ) {
            number.setText("El si cu ea stau pe marginea prapastiei. Ei i se facu cald. El ii facu vant.");
        }
        if (numba == 45) {
            number.setText("Era odata o gasca de gaini. Si toate aveau geci de piele..");
        }
        if (numba == 46) {
            number.setText("Cine rade la urma, gandeste mai incet.");
        }
        if (numba == 47) {
            number.setText("Un snur se uita in oglinda si zambind pe sub mustati, spune:\n" +
                    "- Mamaaa, ce siret sunt!");
        }
        if (numba == 48) {
            number.setText("Merge Bula la posta si ii spune postasului\n" +
                    "- Nu va suparati, astept o scrisoare!\n" +
                    "- Nu ma supar, asteptati!");
        }
        if (numba == 49) {
            number.setText("- Ce este galben cu doua dungi negre?\n" +
                    "- O lamaie cu bretele!");
        }
        if (numba == 50) {
            number.setText("Ce ii spune un semafor altuia? - Nu te uita la mine, ca ma inrosesc!");
        }
        if (numba ==51 ) {
            number.setText("Discutie intre doua cirese:\n" +
                    "- Am un vierme uite-asa de mare!!\n" +
                    "- Stricato!");
        }
        if (numba == 52) {
            number.setText("Care este cel mai sec banc?\n" +
                    "Nu mai este apa!");
        }
        if (numba ==53 ) {
            number.setText("- Domnisoara, sunteti pesimista ?\n" +
                    "- Nu, croitoreasa.");
        }
        if (numba ==54 ) {
            number.setText("Un tip merge la psiholog:\n" +
                    "- Doctore, sunt confuz.. sau poate nu..");
        }
        if (numba == 55) {
            number.setText("Stiti cu ce seamana o jumatate de portocala? Cu cealalta jumatate.");
        }
        if (numba == 56) {
            number.setText("Un om statea pe ganduri, dar cand sa-i vina ideea, a alunecat.");
        }
        if (numba == 57) {
            number.setText("Doua bomboane stau pe acoperis. Care sare prima?\n" +
                    "Aia de menta.");
        }
        if (numba == 58) {
            number.setText("Intrebare de baraj:\n" +
                    "- Ce inaltime avea barajul?");
        }
        if (numba ==59 ) {
            number.setText("- Cine l-a batut prima data pe Stefan cel Mare ?\n" +
                    "- Maica-sa.");
        }
        if (numba ==60 ) {
            number.setText("Discutie intre 2 pereti:\n" +
                    "- Ne intalnim la colt ?");
        }
        if (numba == 61) {
            number.setText("- In ce luna se nasc cei mai multi copii ?\n" +
                    "- In luna a noua ..");
        }
        if (numba == 62) {
            number.setText("- O pizza, va rog !\n" +
                    "- Taiata in 6 sau in 12 ?\n" +
                    "- In 6, ca 12 bucati nu pot sa mananc...");
        }
        if (numba ==63 ) {
            number.setText("Portofelul celor neatenti coboara cu o statie inaintea lor.");
        }
        if (numba ==64 ) {
            number.setText("Postasul bate la usa:\n" +
                    "- Cine e ?\n" +
                    "- Posta !\n" +
                    "- Si cati sunteti ?");
        }
        if (numba ==65 ) {
            number.setText("Oferta promotionala:\n" +
                    "- Daca cumparati un pantof, primiti unul gratis ! Cadou !");
        }
        if (numba ==66 ) {
            number.setText("- Mamico, cine face un copil din flori ?\n" +
                    "- O vaza.");
        }
        if (numba == 67) {
            number.setText("Culmea sovaielii: sa ezit, sa nu ezit..");
        }
        if (numba == 68) {
            number.setText("Culmea melancoliei: sa cazi pe ganduri si sa-ti rupi mana.");
        }
        if (numba ==69 ) {
            number.setText("Culmea zborului: sa zbori pe cerul gurii.");
        }
        if (numba ==70 ) {
            number.setText("Culmea strabismului: un ciclop sasiu.");
        }
        if (numba == 71) {
            number.setText("Singurul lucru care poate opri caderea parului este podeaua.");
        }
        if (numba ==72 ) {
            number.setText("Nu conteaza daca esti sarac sau bogat. Conteaza sa ai bani!");
        }
        if (numba ==73 ) {
            number.setText("Un canibal merge la vraciul tribului:\n" +
                    "- Am arsuri la stomac, ce sa fac ?\n" +
                    "- Mananca un pompier.");
        }
        if (numba ==74 ) {
            number.setText("- Cum ai ajuns sa te angajezi la circ pe post de Om-ghiulea?\n" +
                    "- Patronul mi-a spus ca are nevoie de un om de calibrul meu.");
        }
        if (numba == 75) {
            number.setText("De ce are rinocerul corn? Pentru că nu a găsit chiflă.\n" );
        }
        if (numba == 76) {
            number.setText("Cum se uită o raţă în beci? - Iei raţa, o duci în beci şi o uiţi acolo...\n" );
        }
        if (numba == 77) {
            number.setText("Ce au în comun un elefant şi o zebră?                                                                                                 - Amândoi au trompe, cu excepţia zebrei.\n" );
        }
        if (numba == 78) {
            number.setText("Mihai Viteazu mergea pe cal şi dintr-o dată cade. De ce?                                                                  - S-a terminat calul!\n" );
        }
        if (numba == 79) {
            number.setText("De ce are veveriţa coadă în spate?                                                                                                 – Pentru că nu o are în faţă...\n" );
        }
        if (numba == 80) {
            number.setText("UN OM AVEA UN CAL, IAR CALUL NU AVEA NIMIC IMPOTRIVA!");
        }
        if (numba == 81) {
            number.setText("q:Care e diferentza intre o gaina? \n" +
                    "a:Are picioarele paralele. dar mai mult stangul!");
        }
        if (numba == 82 ) {
            number.setText("Q: Care e diferenta intre o cartita si un vultur?\n" +
                    "A: Amandoi merg pe sub pamant cu exceptia vulturului.");
        }
        if (numba == 83) {
            number.setText("Erau doi cai:Unu era alb si unu a luat-o la dreapta.");
        }
        if (numba ==84 ) {
            number.setText("- Cand sta barza intr-un picior?\n" +
                    "- Cand si-l ridica pe celalalt!");
        }
        if (numba == 85) {
            number.setText("Ce ar fi facut printesa Diana daca ar fi fost vie?\n" +
                    "STRUGURI!");
        }
        if (numba == 86) {
            number.setText("- Cum se sinucide un melc?\n" +
                    "- Se uita in priza!");
        }
        if (numba == 87) {
            number.setText("- V-am povestit vreodata despre mine?\n" +
                    "- Minele sunt niste gauri din care ies minerii!");
        }
        if (numba ==88 ) {
            number.setText("bula mergea la socala. la un moment dat a ajuns");
        }
        if (numba ==89 ) {
            number.setText("ce umbla pe sub pamant si incepe cu litera \"d\"?\n" +
                    "R: doua rame");
        }
        if (numba == 90) {
            number.setText("Baba se duce la doctor. \n " + "Domnule doctor aud voci.\n"+"Si ce spun vocile?\n"+" Nu stiu sa sunt surda");
        }
        if (numba ==91 ) {
            number.setText("Un caine merge prin desert si spune: Daca nu gasesc un pom, fac pe mine!");
        }
        if (numba ==92 ) {
            number.setText("Cum se obtine lumina cu ajutorul apei?\n" +
                    "Spaland geamurile.");
        }
        if (numba ==93 ) {
            number.setText("\"Pe o scara de la 1 la 10 cat...\"\n" +
                    "\"10!\"\n" +
                    "\"... de nerabdator esti?\"");
        }
        if (numba == 94) {
            number.setText("Viata este ca si o scrumiera , plina de indoieli mici !");
        }
        if (numba == 95) {
            number.setText("Dă-mi Doamne răbdare .\n" +
                    "Dar imediat !!!");
        }
        if (numba == 96) {
            number.setText("Eu sunt ceea ce sunt și nu ma schimb!\" \n" +
                    "Nu te schimba, și ai să mirosi perfect după un timp!");
        }
        if (numba == 97) {
            number.setText("- Arati bine cu ochelarii astia noi.\n" +
                    "- Dar nu am ochelari noi...\n" +
                    "- Eu am!");
        }
        if (numba == 98) {
            number.setText("Nu repar prizele din casă pentru că nu-mi stă-n fire.");
        }
        if (numba ==99 ) {
            number.setText("Ori devii nemuritor, ori mori încercând!");
        }
        if (numba == 100) {
            number.setText("Mă durea sufletul, am început tratamentul. Acum mă dor rinichii și ficatul.");
        }
        if (numba == 101) {
            number.setText("Heliu intră într-un bar. Barmanul spune: Îmi pare rău, nu servim gaze nobile! Heliu nu reacționează.");
        }
        if (numba ==102 ) {
            number.setText("I: De ce ai vrea sa lingi o priza?\n" +
                    "R: Pentru ca are gust de alb");
        }
        if (numba ==103 ) {
            number.setText("Ce asemanare este intre un caine? Deoarece are si coada.");
        }
        if (numba ==104 ) {
            number.setText("\"Astazi mi-am gasit perechea\" \n" +
                    "- scrise o soseta in jurnal..");
        }
        if (numba ==105 ) {
            number.setText("- De ce iarna nu-i ca vara ?\n" +
                    "- Pentru ca vara nu-i ca iarna !");
        }
        if (numba == 106) {
            number.setText("- Cum a murit Mihai Viteazul ?\n" +
                    "- A suferit un atac de cort.");
        }
        if (numba == 107) {
            number.setText("Amintește-ți întotdeauna că ești unic, la fel ca toată lumea.");
        }
        if (numba == 108) {
            number.setText("Dacă părinții tăi nu au avut niciodată copii, sunt șanse mari ca nici tu să nu ai.");
        }
        if (numba == 109) {
            number.setText("- Domnisoara, sunteti insarcinata. Veti avea un copil.\n" +
                    "- Domnule doctor, dar sunteti sigur ca e al meu ?");
        }
        if (numba ==110 ) {
            number.setText("Astazi, viata mea s-a schimbat radical.\n" +
                    "\n" +
                    "Dimineata aveam 16 lei si acum mai am doar 4.");
        }
        if (numba == 111) {
            number.setText("- Stii bancul cu pamantul?\n" +
                    "- Nu.\n" +
                    "- Pai vezi?... Esti aerian!");
        }
        if (numba == 112) {
            number.setText(" Chelner! am o musca in unt!\n" +
                    "- Domnule, nu e musca, ci molie si nu e unt, ci margarina!");
        }
        if (numba == 113) {
            number.setText("Dupa ce am vazut pentru prima data o telecomanda universala, m-am gandit: \n" +
                    "Ei bine, acest lucru va schimba totul.");
        }
        if (numba == 114) {
            number.setText("De Crăciun am primit o tabletă. Partea ciudată e că nici măcar n-am știut că sunt bolnav.");
        }
        if (numba ==115 ) {
            number.setText("- Acuzat, eşti condamnat la 30 de ani de închisoare.\n" +
                    "- Dar, domnule judecător, nu cred că mai trăiesc atăt!\n" +
                    "- Fă şi tu cât poţi...");
        }
        if (numba == 116) {
            number.setText("Degeaba a avansat tehnologia. Dalmatianul meu tot alb-negru iese in poze.");
        }
        if (numba ==117 ) {
            number.setText("Patronul brutariei de la colt mi-a explicat ca nu prea are incredere in brutar, simte ca mereu ii coace ceva.");
        }
        if (numba ==118 ) {
            number.setText("I: Care dintre neuronii unei blonde este mai putin dezvoltat?\n" +
                    "R: Celalalt.");
        }
        if (numba == 119) {
            number.setText("Ce face un emo cand se taie cu lama?\n" +
                    "R: Emoragie");
        }
        if (numba == 120) {
            number.setText("După ce-am fost înjunghiat de vreo 2 ori, mi-am dat seama că sunt alergic la cuţit.");
        }
        if(numba ==121){
            number.setText("- Mama nu ma lasa sa tin caine in casa...\n" +
                    "- Dar tatal tau?\n" +
                    "- Pe el il lasa.");
        }
        if(numba ==122){
            number.setText("Oxigenul și Magneziul și-au dat întâlnire. OMg!");
        }
        if(numba ==123){
            number.setText("Am facut multe lucruri rele anul asta. Dar le-am facut foarte bine..");
        }
        if(numba ==124){
            number.setText("Nu spun ca am ghinion, dar cand mi-am cumparat o saltea din aia cu memorie, am nimerit una care avea Alzheimer!");
        }
        if(numba ==125){
            number.setText("Eu oricand as putea sa devin campion mondial la sah. Trebuie doar sa vreau si sa pot");
        }
        if(numba ==126){
            number.setText("Azi m-am dus la piata sa cumpar paine dar taranii mi-au spus ca anul acesta n-au plantat paine in gradina.");
        }
        if(numba ==127){
            number.setText("- Bunico, vreau paine cu unt.\n" +
                    "- Iti dau cu bucurie, draga mea\n" +
                    "- Dar eu vreau cu unt, nu cu bucurie!");
        }
        if(numba ==128){
            number.setText("Pe o pasune erau trei cai. Unul alb, unul maro si unul mai incolo.");
        }
        if(numba ==129){
            number.setText("Doi crocodili croshetau apa minerala intr-un subsol la etajul 7. Unul dintre ei il intreaba pe celalalt: \n" +
                    "- Nu stii dragul meu, mai e mult pana departe ?");
        }


        return true;
    }
}
