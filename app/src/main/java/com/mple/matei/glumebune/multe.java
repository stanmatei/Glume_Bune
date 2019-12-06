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

public class multe extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    private static  TextView glumecc;
    private DatabaseReference mFav;
    private FirebaseAuth mAuth;
    private String current_user;
    private FirebaseAuth.AuthStateListener mAuthListener;
    int[] arai = new int[30000];
    private GestureDetectorCompat gesture;
    Button btnAddData;
    Button btnviewAll;
    DatabaseHelper myDb;

    Button bt;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_multe);



        AdView adView99 =(AdView)findViewById(R.id.adView55);

        AdRequest adRequest99 = new AdRequest.Builder().build();

        adView99.loadAd(adRequest99);
        AdView adView55 =(AdView)findViewById(R.id.adView99);

        AdRequest adRequest55 = new AdRequest.Builder().build();

        adView55.loadAd(adRequest55);

        glumecc=(TextView)findViewById(R.id.muc);
        gesture= new GestureDetectorCompat(this,this);
        gesture.setOnDoubleTapListener(this);


        myDb = new DatabaseHelper(this);
        btnAddData = (Button)findViewById(R.id.button411);




        Typeface mytf6 =Typeface.createFromAsset(getAssets(), "TTWPGOTT.ttf");

        glumecc.setTypeface(mytf6);


        bt=(Button)findViewById(R.id.button412);
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
                            map.put("titlu", "O Gluma Buna");
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
                                        Toast.makeText(multe.this, "Gluma a fost adaugata la favorite", Toast.LENGTH_LONG).show();


                                    } else if (databaseError != null) {
                                        Toast.makeText(multe.this, databaseError.toString(), Toast.LENGTH_LONG).show();
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


        if (a <= 0) {
            glumecc.setText("NEM! da swipe pentru glume!");
            a++;
        }
        else{
            int numba = arai[a - 1];
        if (numba == 0) {
            glumecc.setText("De frica sa nu fie date afara de la ore din cauza fustei, elevele de la Jean Monnet vin la scoala numai in bikini");
        }
        if (numba == 1) {
            glumecc.setText("\n" +
                    "-Stii de ce nu mananca elefantii mamaliga ?\n" +
                    "-?????\n" +
                    "-Pentru ca nu le da nimeni !");
        }
        if (numba == 2) {
            glumecc.setText("Nevasta-mea a fost concediata, dupa doar o zi ca model nud pentru studentii de la Arte.\n" +
                    "Toti desenasera un jeleu...");
        }
        if (numba == 3) {
            glumecc.setText("Exista acel \"ceva\" intre mine si nevasta-mea, care cred ca nu se va sfarsi niciodata.\n" +
                    "Ba mai mult, creste pe zi ce trece.\n" +
                    "Burta ei.");
        }
        if (numba == 4) {
            glumecc.setText("Cele mai multe neveste sunt prea umaniste ca să înțeleagă, dar, tehnic vorbind, băutura este o soluție!");
        }
        if (numba == 5) {
            glumecc.setText("DIETA\n" +
                    "Ziua 1\n" +
                    "Am scapat de toata mancarea nesanatoasa din casa...\n" +
                    "A fost delicioasa...");
        }
        if (numba == 6) {
            glumecc.setText("- Noi doi nu avem aceleasi pareri. Este imposibil sa ma inteleg cu tine- striga soacra. Macar de nu te-as mai vedea niciodata!\n" +
                    "- Vezi, ca avem aceleasi gusturi? Si eu imi doresc exact acelasi lucru.");
        }
        if (numba == 7) {
            glumecc.setText("Nevasta-mea m-a provocat aseara la o partida de tenis de masa.\n" +
                    "Bineinteles c-am batut-o.\n" +
                    ".\n" +
                    ".\n" +
                    "Si tot a castigat!");
        }
        if (numba == 8) {
            glumecc.setText("S-a dovedit stiintific: trufele pot preveni ciroza, cancerul si obezitatea.\n" +
                    "Dacă cumperi un kilogram de trufe, nu mai ai bani de alcool, de tigari sau de mancare.");
        }
        if (numba == 9) {
            glumecc.setText("La crasma. \n" +
                    "- Ce zici, Ioane, a fi acuma razboi? \n" +
                    "- Da cat ii ceasul? \n" +
                    "- Doua noaptea. \n" +
                    "- Atunci a fi. \n" +
                    "- Da de ce, ma? \n" +
                    "- Ca-i la noi soacra-mea.");
        }
        if (numba == 10) {
            glumecc.setText("Noul magazin de bumeranguri anunță cu mândrie că toate produsele lor sunt returnabile.");
        }
        if (numba == 11) {
            glumecc.setText("Dintii catre limba: \n" +
                    "- Daca te presam mai tare te putem taia!\n" +
                    "- O singura injuratura daca rostesc zburati toti.");
        }
        if (numba == 12) {
            glumecc.setText("Sotul: Draga mea, ce avem astazi la masa? \n" +
                    "Sotia: Nimic.\n" +
                    "Sotul: Pai si ieri a fost „nimic”.\n" +
                    "Sotia: Dragule, am gatit pentru doua zile!!!");
        }
        if (numba == 13) {
            glumecc.setText("- Ce-si pierde capul dimineata si il primeste inapoi seara ?\n" +
                    "- Perna !");
        }
        if (numba == 14) {
            glumecc.setText("I-am oferit un buchet de flori de Nu-Mă-Uita.\n" +
                    "Ea mi-a dat un buchet de flori Dar-Tu-Cine-Naiba-Eşti?");
        }
        if (numba == 15) {
            glumecc.setText("- Iubitule am o veste buna si una proasta , sa stii ca vreau sa ne despartim ! \n" +
                    "\n" +
                    "- Ok , si aia proasta ?");
        }
        if (numba == 16) {
            glumecc.setText("- Ba Ioane am auzit ca azi vor fi 42 de grade la umbra !\n" +
                    "- Si ce ? Crezi ca is prost sa stau la umbra ?");
        }
        if (numba == 17) {
            glumecc.setText("DNA nu redeacteaza subiecte de BAC pentru ca in final nu s-ar lasa cu diploma ci cu mandat");
        }
        if (numba == 18) {
            glumecc.setText("Invatatoarea si clasa la gara: \n" +
                    "- Copii, ne urcam unde scrie \"clasa a 2-a\", chiar daca noi suntem a patra!\"");
        }
        if (numba == 19) {
            glumecc.setText("Tot mai mulți români returnează cardurile de sănătate la Minister pentru că nu au niciun ban pe ele.");
        }
        if (numba == 20) {
            glumecc.setText("- Domnule redacor, ati citit nuvela mea, pe care v-am trimis-o prin posta?\n" +
                    "- Da, am citit-o. Am citit-o cu mult inainte de nasterea ta.");
        }
        if (numba == 21) {
            glumecc.setText("- Ce zice un vampir cand este eclipsa de soare?\n" +
                    "??\n" +
                    "- \"In sfarsit, mananc de pranz!\"");
        }
        if (numba == 22) {
            glumecc.setText("Musafirii, la iesirea din restaurant: \n" +
                    "- Pacat ca nu am ajuns la dv. mai curand!\n" +
                    "- Ne bucuram ca v-a placut!\n" +
                    "- Nu ne-a placut deloc- dar daca ajungeam mai repede, poate ca era carnea proaspata inca...");
        }
        if (numba == 23) {
            glumecc.setText("Ala e comerciant , care vinde nisip in Sahara si gheata in Antartica !!!!!");
        }
        if (numba == 24) {
            glumecc.setText("Propunere șocantă ANAF: cerșetorii vor fi obligați să emită bon fiscal pentru banii primiți.");
        }
        if (numba == 25) {
            glumecc.setText("- Acum citesc o carte manageriala , economic financiara...\n" +
                    "- Si cum se numeste?\n" +
                    "- Punguta cu 3 iezi.\n");
        }
        if (numba == 26) {
            glumecc.setText("Doi liceeni: \n" +
                    "- Exista o femeie care ma zapaceste, ma lasa fara cuvinte , pur si simplu cand sunt in fata ei nu stiu ce sa spun ...\n" +
                    "- Cine ? \n" +
                    "- Profa de franceza .");
        }
        if (numba == 27) {
            glumecc.setText("- De ce dai gainilor sa bea cacao?, intreaba contrariata, bunica.\n" +
                    "- Cum altfel sa faca oua de ciocolata?!?");
        }
        if (numba == 28) {
            glumecc.setText("Discurs motivational pentru o armată de vegetarieni: \"La luptă oștenii mei, sunt câtă frunză, câtă iarbă!\"");
        }
        if (numba == 29) {
            glumecc.setText("I: Daca astazi e UNU MAI, maine ce e?\n" +
                    "R: Maine e unu si mai...!");
        }
        if (numba == 30) {
            glumecc.setText("Cercetătorii români au descoperit că, dacă îți întorci chiloții pe dos, se creează o situație în care, de fapt, tot Universul poartă chiloții tăi... în afară de tine.");
        }
        if (numba == 31) {
            glumecc.setText("- Ionele de ce pleci la scoala fara sa bei ceai ?\n" +
                    "- Am baut fa , ce-ai ? Dar n-am baut ceai , ce-ai ? Ca mie nu-mi place ceai!");
        }
        if (numba == 32) {
            glumecc.setText("- Gigel sa stii ca vine vara !\n" +
                    "- Cum asa ca deabia e toamna. Poate vine iarna vrei sa spui ?\n" +
                    "- Nu , vine vara ta de la tara !");
        }
        if (numba == 33) {
            glumecc.setText("Judecatorul: \n" +
                    "- Iarasi dumneata aici? Am crezut ca ti-a folosit sederea la inchisoare...\n" +
                    "- Sigur ca mi-a folosit: de aceea am mai vrut una.");
        }
        if (numba == 34) {
            glumecc.setText("-Mai Georgica , am impresia ca de cand cu Facebook-ul asta parca s-a alterat comunicarea dintre oameni.\n" +
                    "- Like !");
        }
        if (numba == 35) {
            glumecc.setText("- Mama maine nu merg la scoala !\n" +
                    "- Pai cum Gigele ? De ce ? Esti bolnav ?\n" +
                    "- Nu . Maine e duminica !");
        }
        if (numba == 36) {
            glumecc.setText("Când Chuck Norris a plecat de acasă i-a spus tatălui său : \"Tu ești bărbatul casei de acum încolo\".");
        }
        if (numba == 37) {
            glumecc.setText("Toti barbatii sunt porci! Corect, Pentru ca femininul speciei se numeste scroafa");
        }
        if (numba == 38) {
            glumecc.setText("-hai sa mergem la teatru\n" +
                    "- ce sa facem acolo ?\n" +
                    "- sa ne uitam la un film");
        }
        if (numba == 39) {
            glumecc.setText("- Maine incep scoala !\n" +
                    "- Acum la 50 de ani ? Nu e cam tarziu ?\n" +
                    "- Nu mai . Incep sa o zugravesc.");
        }
        if (numba == 40) {
            glumecc.setText("Atunci când ai de studiat, pereții devin deodată foarte interesanți. De aceea mulți își aleg o carieră în construcții.");
        }
        if (numba == 41) {
            glumecc.setText("Femeile din Vaslui dezamagite de flmul Fifty Shades of Grey : \" Barbatii nostri ne bat mult mai bine \"");
        }
        if (numba == 42) {
            glumecc.setText("-Hei , tinere ! Nu ai voie sa intri in pielea goala in piscina ! \n" +
                    "- Dar nu imi place sa fac pipi in chiloti !");
        }
        if (numba == 43) {
            glumecc.setText("Unui tanar i s-a injumatatit IQ-ul dupa ce s-a uitat la Romanii Au Talent pana la capat .");
        }
        if (numba == 44) {
            glumecc.setText("Cât rezist în pat?\n" +
                    "Depinde... dacă nu pun alarma... uneori şi până la prânz");
        }
        if (numba == 45) {
            glumecc.setText("Premiera medicala ! Un taximetrist si-a implantat un claxon in palma pentru a-l folosi si ca pieton .");
        }
        if (numba == 46) {
            glumecc.setText("SUA si-a dotat armata cu rachete inteligente, care zboara pana la rusi, ii dojenesc si se intorc inapoi.");
        }
        if (numba == 47) {
            glumecc.setText("Un tanar din Caracal a sunat la 112 dupa ce s-a ratacit pe internet .");
        }
        if (numba == 48) {
            glumecc.setText("Premieră medicală: Un tomograf super performant va putea scana creierul minuscul al cocalarilor!");
        }
        if (numba == 49) {
            glumecc.setText("Ziua Internationala a Femeii a fost anulata!\n" +
                    "Motivul a fost... pentru ca.");
        }
        if (numba == 50) {
            glumecc.setText("Ingrijitorul se uita foarte atent in gura crocodilului.\n" +
                    "- Ce are? intreaba un vizitator?\n" +
                    "- Inca nu stiu. Medicul veterinar n-a mai iesit de acolo, de vreo jumatate de ora...");
        }
        if (numba == 51) {
            glumecc.setText("Când un obicei incepe sa coste bani este numit un hobby.");
        }
        if (numba == 52) {
            glumecc.setText("Am vazut recent pe Net o manea al carui titlu m-a amuzat: \"Florin Salam- Am sa scriu intr-o carte\"!!");
        }
        if (numba == 53) {
            glumecc.setText("Nu inteleg agentiile astea de caritate... Cheltuie milioane de euro in campania de publicitate, pentru a strange cate 2 euro amarati de ici, de colo");
        }
        if (numba == 54) {
            glumecc.setText("Astazi am fost la un interviu pentru angajare.\n" +
                    "- Pe C. V.-ul tau vad ca scrie ca esti un om misterios... imi zise intervievatorul. Ce vrei sa spui cu asta, mai exact?\n" +
                    "- Eee...!");
        }
        if (numba == 55) {
            glumecc.setText(" Ce faci când doctorul îţi interzice să te apropii de\n" +
                    "vodcă?\n" +
                    "– O beau de la distanţă… cu paiul.");
        }
        if (numba == 56) {
            glumecc.setText("Ieri am vazut un OZN.\n" +
                    "Asa ca am luat repede cea mai proasta camera pe care o am ca sa-l filmez.");
        }
        if (numba == 57) {
            glumecc.setText("Legea respiratiei: Inainte ma inspirai, acuma... te-ai expirat!");
        }
        if (numba == 58) {
            glumecc.setText("- Nu mai poti sa ai incredere in posta...\n" +
                    "- Cum asa?\n" +
                    "- Pai barbatu-meu e plecat la tratament la Olanesti, dar scrisoarea de la el are stampila de la Paris!.");
        }
        if (numba == 59) {
            glumecc.setText("Nu ca ma laud, dar am rezolvat cubul Rubik cu picioarele!...\n" +
                    "\n" +
                    "I-am tras un sut de a aterizat in galeata cu vopsea.");
        }
        if (numba == 60) {
            glumecc.setText("In preajma alegerilor, un ziarist intevieveaza un om al strazii: \n" +
                    "- Pentru un trai decent, ce asteptati de la viitoarea guvernare?\n" +
                    "- Mai multe pubele.");
        }
        if (numba == 61) {
            glumecc.setText("Stiu pe unul care e atat de zgarcit ca si mancarea si-o cumpara de la second-hand !");
        }
        if (numba == 62) {
            glumecc.setText("Scrisoarea unui copil de mafiot catre Mos Craciun lasata pe noptiera tatalui: \"Draga Mosule, daca nu-mi aduci anul asta un Ferrari, tata o sa te-mpuste, iar daca totusi nu te-mpusca , o sa va-mpusc eu pe amandoi!");
        }
        if (numba == 63) {
            glumecc.setText("WiFi-ul telefonului mobil a căzut în timp ce scriam ceva pe Facebook. Mi-am dat seama imediat că vecinul nu şi-a plătit factura la Net. Ce nemernc!!");
        }
        if (numba == 64) {
            glumecc.setText("Zilele trecute am fost la un interviu pentru un job la o companie multinationala.\n" +
                    "- Unde te vezi peste cinci ani?\n" +
                    "- Asculta amice, imi zise tipul din fata mea, tolanit intr-un fotoliu, eu sunt cel care pune intrebarile aici!!!");
        }
        if (numba == 65) {
            glumecc.setText("Acum cateva seri sor-mea a fost cu doi barbati. Dupa, saraca de ea, abia mai putea sa mearga. Pai va dati seama, doua cine la restaurant una dupa alta?!?");
        }
        if (numba == 66) {
            glumecc.setText("FIUL: Tata , ce inseamna idiot?\n" +
                    "\n" +
                    "TATA: Un prost care nu stie sa explice ideile cum nimeni nu le intelege.\n" +
                    "\n" +
                    "Ai inteles?\n" +
                    "\n" +
                    "FIUL: Nu.");
        }
        if (numba == 67) {
            glumecc.setText("Daca simti un gol imens in stomac.. mananca, este posibil sa fie doar foamea!");
        }
        if (numba == 68) {
            glumecc.setText("O femeie din Rusia s-a sinucis la 105 ani! \"Asemenea cazuri nu s-ar intampla daca moartea si-ar face treaba\", a declarat un politist rus.");
        }
        if (numba == 69) {
            glumecc.setText("- Noaptea de revelion imi lasa amintiri de neșters, spuse el visator, tolanit pe canapea.\n" +
                    "- Si mie de șters, spuse ea ștergand de zor la o farfurie.");
        }
        if (numba == 70) {
            glumecc.setText("În ziua de azi copiii se nasc mai inteligenţi , pentru că în cele nouă luni mamele lor încă mai merg la școală");
        }
        if (numba == 71) {
            glumecc.setText("I; Cum se numeste un negru care piloteaza un avion?\n" +
                    "R: - Pilot! ");
        }
        if (numba == 72) {
            glumecc.setText("Am o nelamurire in legatura cu mancarea vegetariana.\n" +
                    "Este adevarat ca buruienile fac oamenii mai intelepti?");
        }
        if (numba == 73) {
            glumecc.setText("Puiul: Tata, mama face o ciorbă oribilă.\n" +
                    "Cocoșul: Ai răbdare. E încă tânără.");
        }
        if (numba == 74) {
            glumecc.setText("Romania, tara in care daca o vanzatoare iti recomanda sa cumperi ceva e clar ca e vechi .");
        }
        if (numba == 75) {
            glumecc.setText("oi prieteni, la un pahar.\n" +
                    "- Noi am fost acasa trei frati, dintre care doi destepti foc si unul foarte greu de cap.\n" +
                    "- I-auzi, eu nu i-am cunoscut pe celalti doi.");
        }
        if (numba == 76) {
            glumecc.setText("Daca parintii tai nu reactioneaza cand le povestesti disperat ca toti copiii din cartier te injura de mama si de tata, e clar: Ai fost adoptat.");
        }
        if (numba == 77) {
            glumecc.setText("- Draga, nu te supara, dar sotul tau e cumva coșar?\n" +
                    "- Nu, de ce?\n" +
                    "- Tot timpul il vad afumat.");
        }
        if (numba == 78) {
            glumecc.setText("Mi-a sosit cardul de sănătate, unde găsesc şi eu un ATM cu sănătate?");
        }
        if (numba == 79) {
            glumecc.setText("Cica noi romanii suntem experti in tranzitiile de orice fel, asa ca noi o sa avem o perioada de tranzitie de la Leu la Euro si o sa folosim moneda Leuro.");
        }
        if (numba == 80) {
            glumecc.setText("- De ce nu-ti vezi de treaba mai baiatule? De ce nu muncesti?\n" +
                    "- Pentru ca pentru mine, munca este o placere.... Si eu n-am timp de placeri.");
        }
        if (numba == 81) {
            glumecc.setText("- De ce nu poti sa te joci v-ati ascunselea cu soacra?\n" +
                    "- Ca nimeni nu vrea sa mai fie gasita!");
        }
        if (numba == 82) {
            glumecc.setText("Pentru femeile care spuneti ca toti barbatii sunt la fel cine v-a pus sa-i incercati pe toti??");
        }
        if (numba == 83) {
            glumecc.setText("Doua mame stau de vorba despre viitorul copiilor lor.\n" +
                    "- Al meu va fi avocat, spune una. \n" +
                    "- De ce crezi asta?\n" +
                    "- Tot timpul se baga in treburile altora, se cearta cu toti si se crede cel mai destept!");
        }
        if (numba == 84) {
            glumecc.setText("- Copii, dati exemplu de o planta care se schimba in functie de vreme... zise profesoara de biologie.\n" +
                    "- Busuioc! raspunse Gigel.");
        }
        if (numba == 85) {
            glumecc.setText("- Anul asta, nu-l mai faci pe Moș Craciun la televiziune?\n" +
                    "- Nuuu, mi-au spus ca sunt prea batran.");
        }
        if (numba == 86) {
            glumecc.setText("- Ce impertinent s-a uitat controlorul la tine, de parca nu ai fi platit....\n" +
                    "- Așa e. Dar n-ai vazut cum m-am uitat eu fix in ochii lui, ca si cum aș fi platit?");
        }
        if (numba == 87) {
            glumecc.setText("Ion si Vasile stau de vorba. La un moment dat Ion spune: \n" +
                    "- Eu m-am saturat de viata asta, toata ziua stam doar pe Facebook. Am si eu o viata pana la urma.\n" +
                    "La care Vasile zice: \n" +
                    "- Si nu mi-o trimiti mie pe Candy Crush?");
        }
        if (numba == 88) {
            glumecc.setText("Ionel isi face tema la gramatica : \n" +
                    "- Mamicoooo ! \"Coadă\" este substantiv sau verb ?\n" +
                    "- Verb , dragă .... pentru că se mișcă !");
        }
        if (numba == 89) {
            glumecc.setText("Dupa ultimele statistici, numarul oamenilor care se hulesc intre ei a crescut la 85%.\n" +
                    "Hooo, ca nu-i adevarat!!");
        }
        if (numba == 90) {
            glumecc.setText("Azi i-am zis lui fiu-miu ca eu cand eram de varsta lui nu aveam internet : \n" +
                    "- Hai tată , lasă vraja ! Nici măcar pe telefonul mobil ?");
        }
        if (numba == 91) {
            glumecc.setText("Cum pacalesti lumea ca esti superdotat? te tragi de nas toata ziua!");
        }
        if (numba == 92) {
            glumecc.setText("-Izabela a afirmat ca de ziua ei si-ar dori drept cadou o masina a timpului.\n" +
                    "- De ce ?\n" +
                    "- Pentru ca acum a invatat sa foloseasca Facebook-ul !!");
        }
        if (numba == 93) {
            glumecc.setText("PremieraDIVERSE- Ai fost la premiera piesei mele. Cum ti se pare? Nu-i asa ca are ceva nou si bun in ea?\n" +
                    "- Asa este, insa ceea ce-i bun nu e si nou, iar ceea ce-i nou, nu este si bun.");
        }
        if (numba == 94) {
            glumecc.setText("-Tată , de ce iarna e mai frig ca vara ?\n" +
                    "- Există o explicație fiule : iarna temperatura e mai scăzută !");
        }
        if (numba == 95) {
            glumecc.setText("Dacă aș fi primit câte un leu de fiecare dată când o fată m-a considerat neatragător, acum aș fi fost considerat atrăgător");
        }
        if (numba == 96) {
            glumecc.setText("Clienta catre taximetrist: \n" +
                    "- Sunteti liber?\n" +
                    "- Nu, sunt insurat.");
        }
        if (numba == 97) {
            glumecc.setText(" Ce-ai facut draga? ai ars friptura....\n" +
                    "- Iubitule, doctorul mi-a recomandat sa mai ard din calorii...");
        }
        if (numba == 98) {
            glumecc.setText("Reporterul: \n" +
                    "- Domnule, ce obiceiuri traditionale aveti in aceasta zona, de anul nou?\n" +
                    "- Colica biliara, coma alcoolica, intoxicatia.....");
        }
        if (numba == 99) {
            glumecc.setText("La scoala de muzică : \n" +
                    "- Domnule profesor , ce spuneti , are voce fetița noastră ?\n" +
                    "- Are ... eu stiu ce sa zic .... de ce nu o dati la balet ?");
        }
        if (numba == 100) {
            glumecc.setText("Pamflet : \n" +
                    "\n" +
                    "\"Un urs şi-a pierdut toţi banii la păcănele. El acuză că a fost păcănit de vulpe. \"");
        }
        if (numba == 101) {
            glumecc.setText("Anul nou arata ca nu gandim si nu ne comportam la fel: \n" +
                    "barbatii cu uratul, femeile cu urlatul.");
        }
        if (numba == 102) {
            glumecc.setText("- Tata, am construit o chitara!\n" +
                    "- Bravo, fiule. Si de unde ai avut corzi?\n" +
                    "- Le-am luat de la pianul din sufragerie.");
        }
        if (numba == 103) {
            glumecc.setText("Daca vrei sa decimezi Romania, nu ai nevoie de un atac frontal, e de ajuns sa opresti ambulantele si sectiile de urgente dupa Craciun.");
        }
        if (numba == 104) {
            glumecc.setText("Ati vrut zapada ca-n povesti? Acum dezapeziti ca-n basme! ...");
        }
        if (numba == 105) {
            glumecc.setText("Super tare! Se lansează Google Ulițe View , serviciul pentru explorarea cătunelor si satelor din România");
        }
        if (numba == 106) {
            glumecc.setText("In 1492, Columb nu stia incotro mergea, era insotit de un echipaj razvratit si toti bani sai erau imprumutati. Astazi ar fi un candidat politic!");
        }
        if (numba == 107) {
            glumecc.setText("De ce are Rudolf nasul roșu? \n" +
                    "Pentru că trece în fiecare an prin Vaslui.");
        }
        if (numba == 108) {
            glumecc.setText("\" Tati , ce inseamna sarcasm ? \" ma intreaba fiul meu de 6 ani \n" +
                    "- Fiule sarcasmul este atunci cand mama ta imi zice ca am dreptate .");
        }
        if (numba == 109) {
            glumecc.setText("Infractorul acuză dureri DIICOT");
        }
        if (numba == 110) {
            glumecc.setText("- Va rog doua bilete.\n" +
                    "- Pentru Hobbit?\n" +
                    "- Nu, pentru mine si prietena mea.");
        }
        if (numba == 111) {
            glumecc.setText("I: – Bula, de ce a creat Dumnezeu mai intii barbatul?\n" +
                    "R: – Ca macar odata in viata sa poata si el sa vorbeasca liber");
        }
        if (numba == 112) {
            glumecc.setText("– Bulă, am auzit c-a murit soacră-ta, ce-a avut?\n" +
                    "– A trecut pe verde.\n" +
                    "– Adică a călcat-o cu mașina pe trecere?\n" +
                    "– Nu mă, era bolnavă de amigdalită și s-a săturat de albastru de metil, așa că a trecut pe verde de Paris!");
        }
        if (numba == 113) {
            glumecc.setText("– Cum spun chinezii la scaieți?\n" +
                    "– Ciu lin.");
        }
        if (numba == 114) {
            glumecc.setText("– De ce au mașinile mici luneta incalzită electric?\n" +
                    "– Să nu le îngheţe mâinile pasagerilor când o imping, iarna!");
        }
        if (numba == 115) {
            glumecc.setText("– De ce la un banc se râde de trei ori?\n" +
                    "– Prima dată când il auzi, a doua oară când îl spui mai departe și a treia oară, când îl înțelegi.");
        }
        if (numba == 116) {
            glumecc.setText("Întrebare la Radio Erevan:\n" +
                    "– De ce se țin leii în cușcă?\n" +
                    "– Pentru că dacă i-am ține în acvariu s-ar îneca.");
        }
        if (numba == 117) {
            glumecc.setText("– Știți de ce caii au nările așa de mari?\n" +
                    "– Încercați să băgați copitele in nas!");
        }
        if (numba == 118) {
            glumecc.setText("Întrebarea zilei: “Ce faci dacă vezi un omuleț verde?”\n" +
                    "60% au\tzis că se lasă de băut.\n" +
                    "30% se apucă de băut.\n" +
                    "9% merg la doctor.\n" +
                    "1% traversează.");
        }
        if (numba == 119) {
            glumecc.setText("– Ştii când se ciocnesc două maşini?\n" +
                    "– Nu…\n" +
                    "– Când cei doi şoferi urmăresc acelaşi pieton.");
        }
        if (numba == 120) {
            glumecc.setText("– De ce poartă medicii chirurgi din România mănuși?\n" +
                    "– Ca să nu lase urme!");
        }
        if (numba == 121) {
            glumecc.setText("– Ce este scris pe ultima pagină a instrucțiunilor pentru autoturismul Dacia Logan?\n" +
                    "– Orarul autobuzelor.");
        }
        if (numba == 122) {
            glumecc.setText("– Cine-i mai mulțumit, un bărbat care are cinci copii sau unul care are cinci milioane de dolari?\n" +
                    "– Cel cu cinci copii, pentru că el e cel care nu mai vrea încă unul!");
        }
        if (numba == 123) {
            glumecc.setText("– Dintre doi polițiști care urinează, cine este cel care își proiectează jetul cel mai departe?\n" +
                    "– Cel care-și deschide șlițul!");
        }
        if (numba == 124) {
            glumecc.setText("– Ce primește un miner la moarte?\n" +
                    "– Trei zile libere, apoi înapoi in pământ.");
        }
        if (numba == 125) {
            glumecc.setText("– Ce are un om care a fost mușcat de două ori de un câine?\n" +
                    "– O remușcare");
        }
        if (numba == 126) {
            glumecc.setText("– Care e diferența dintre o nuntă rusească și o înmormântare rusească?\n" +
                    "– La înmormântare, e cu un bețiv mai puțin.");
        }
        if (numba == 127) {
            glumecc.setText("– De ce poartă polițiștii apă în portbagaj!?\n" +
                    "– Ca să nu le moară sirena!");
        }
        if (numba == 128) {
            glumecc.setText("– Gogoşile sunt sanatoase?\n" +
                    "– Păi n-am văzut până acum vreuna bolnavă!");
        }
        if (numba == 129) {
            glumecc.setText("– Cu ce se duce Super Glue-ul de pe mâini?\n" +
                    "– Cu piele!");
        }
        if (numba == 130) {
            glumecc.setText("– Care este primul lucru pe care îl faci când vezi că fasolea nu fierbe?\n" +
                    "– Aprinzi focul.");
        }
        if (numba == 131) {
            glumecc.setText("– Cum definesc românii munca?\n" +
                    "– Pauza dintre țigări.");
        }
        if (numba == 132) {
            glumecc.setText("– Cum se numeşte un ţigan care îşi dă aere?\n" +
                    "– Romgaz!");
        }
        if (numba == 133) {
            glumecc.setText("– De ce în Sicilia nu se găsesc Martorii lui Jehova?\n" +
                    "– Pentru că sicilienilor nu le plac martorii.");
        }
        if (numba == 134) {
            glumecc.setText("– De ce are un somalez un bob de orez lângă el?\n" +
                    "– A vomat toată noaptea.");
        }
        if (numba == 135) {
            glumecc.setText("– Cum îţi dai seama că este frig afară?\n" +
                    "– În loc să calci într-un rahat, te împiedici de el.");
        }
        if (numba == 136) {
            glumecc.setText("– Ce face vaca când stă la soare?\n" +
                    "– Umbră.");
        }
        if (numba == 137) {
            glumecc.setText("– De ce ambalajul prezervativului se desface aşa de greu?\n" +
                    "– Ca să mai ai timp să te răzgândeşti.");
        }
        if (numba == 138) {
            glumecc.setText("– Ai nişte degete lungi şi frumoase, cânţi la pian?\n" +
                    "– Nu, spăl eprubete.");
        }
        if (numba == 139) {
            glumecc.setText("– Ce face un cal într-un lan de canabis?\n" +
                    "– Paşte fericit!");
        }
        if (numba == 140) {
            glumecc.setText("– Ce are un câine care miaună?\n" +
                    "– Tulburare de personalitate.");
        }
        if (numba == 141) {
            glumecc.setText("– De câţi francezi ai nevoie pentru a apăra Parisul?\n" +
                    "– Cine ştie, ce credeţi, a încercat vreodată cineva?!");
        }
        if (numba == 142) {
            glumecc.setText("– Cum se termină o piesă de teatru în Ferentari?\n" +
                    "– Până la urmă eroul se îndrăgosteşte de heroină.");
        }
        if (numba == 143) {
            glumecc.setText("– De ce aruncă un poliţist ceasul pe geam?\n" +
                    "– Ca să vadă cum zboară timpul.");
        }
        if (numba == 144) {
            glumecc.setText("– De nu mai primesc poliţiştii pantofi cu găurele?\n" +
                    "– Pentru că nu le ajungea şiretul!");
        }
        if (numba == 145) {
            glumecc.setText("– Ce mănâncă un canibal când e la dietă?\n" +
                    "– Un pitic.");
        }
        if (numba == 146) {
            glumecc.setText("– Cum ați devenit inginer pentru deviere râuri?\n" +
                    "– Am făcut două-trei cursuri.");
        }
        if (numba == 147) {
            glumecc.setText("– De ce are girafa gâtul lung?\n" +
                    "– Pentru ca să ajungă la cap.");
        }
        if (numba == 148) {
            glumecc.setText("– Se spune că blondele au cu un neuron în plus faţă de găini. Cu ce le ajută surplusul?\n" +
                    "– Să nu facă pe ele prin curte precum găinile.");
        }
        if (numba == 149) {
            glumecc.setText("– Cum ţii o blondă ocupată toată ziua?\n" +
                    "– O pui să stea la colţ într-o cameră rotundă.");
        }
        if (numba == 150) {
            glumecc.setText("– Ce sunt meridianele?\n" +
                    "– Meridianele: bretelele globului pământesc,… ca să nu-i cadă ecuatorul în vine.");
        }
        if (numba == 151) {
            glumecc.setText("– Ce se întâmplă dacă Usain Bolt pierde autobuzul?\n" +
                    "– Îl aşteaptă la următoarea staţie.");
        }
        if (numba == 152) {
            glumecc.setText("– Cum se cheamă atunci când îți merge totul bine?\n" +
                    "– Halucinații…");
        }
        if (numba == 153) {
            glumecc.setText("– Ce parfum foloseşte Ştefan Hruşcă?\n" +
                    "– Eau du Ler.\n");
        }
        if (numba == 154) {
            glumecc.setText("– De ce nu a participat aviaţia somaleză la Războiul din Golf?\n" +
                    "– Era bolnav pilotul.");
        }
        if (numba == 155) {
            glumecc.setText("– Cum emigrează somalezii în America?\n" +
                    "– Prin fax!");
        }
        if (numba == 156) {
            glumecc.setText("– Dacă joacă şah Bin Laden cu Bush, cine câştigă?\n" +
                    "– Bin Laden cu siguranţă, Bush nu mai are două turnuri");
        }
        if (numba == 157) {
            glumecc.setText("– De ce vampirii nu se fac electricieni?\n" +
                    "– La naiba, cum să folosească şurubelniţa în cruce!");
        }
        if (numba == 158) {
            glumecc.setText("– Ce fac cinci emo într-o cameră?\n" +
                    "– Patru dintre ei stau în câte un colţ şi fiecare se taie singur cu lama şi al cincelea stă în mijlocul camerei şi plânge că nu are şi el colţ.");
        }
        if (numba == 159) {
            glumecc.setText("– Ce fel de salam mănâncă arabii?\n" +
                    "– Salam “Alecu”.");
        }
        if (numba == 160) {
            glumecc.setText("– Poţi rezista dacă îţi dă Chuck Norris un pumn?\n" +
                    "– Da. Dacă este de seminţe.");
        }
        if (numba == 161) {
            glumecc.setText("– Cum se cheamă oraşul San Francisco în Japoneză?\n" +
                    "– Francisco San!");
        }
        if (numba == 162) {
            glumecc.setText("– De ce ai renunțat la ultimul loc de muncă?\n" +
                    "– Compania s-a relocat și nu mi s-a spus unde…");
        }
        if (numba == 163) {
            glumecc.setText("– Bunicu-meu a ştiut dinainte data şi ora morţii lui.\n" +
                    "– Baliverne. Nimeni nu poate şti asta.\n" +
                    "– Ba el a ştiut fiindcă i-a spus judecătorul.");
        }
        if (numba == 164) {
            glumecc.setText("Plasatorul intră îngrozit în biroul directorului de teatru:\n" +
                    "– Domnule director, un spectator a căzut de la balcon. Ce facem ?\n" +
                    "– Îl pui să plătească diferenţa de preţ!");
        }
        if (numba == 165) {
            glumecc.setText("Bulă face poze pe malul lacului, când nevastă-sa îl strigă disperată:\n" +
                    "− Bulă! Repede, se îneacă mama!\n" +
                    "− Degeaba, nu mai am spațiu pe telefon.");
        }
        if (numba == 166) {
            glumecc.setText("– Alo, urgențe, 112?\n" +
                    "– Da! Spuneți!\n" +
                    "– Soția mea gătea, și a căzut!\n" +
                    "– Și care e urgența?\n" +
                    "– Știi cât trebuie să las orezul ca să nu se lipească?");
        }
        if (numba == 167) {
            glumecc.setText("Tipul care locuieşte în apartamentul de deasupra mea tocmai a reusit sa parcurga 100 de metri in 3.2 secunde.\n" +
                    "Fie-i ţărâna uşoară.");
        }
        if (numba == 168) {
            glumecc.setText("S-a stins din viață proprietarul cinematografului orășenesc. Funeraliile vor avea loc mâine, la orele 10:20, 12:45, 15:30 și 18:45!");
        }
        if (numba == 169) {
            glumecc.setText("– Mă iubește, nu mă iubește, mă iubește, nu mă iubește….\n" +
                    "– Doctore, lăsați-mi dinții în pace.");
        }
        if (numba == 170) {
            glumecc.setText("Am fost implicat într-un accident nasol mai devreme dar am reuşit să ies dintre fiarele contorsionate cu un picior rupt. Nu sunt sigur al cui era, dar ştiţi cum e, dacă l-am găsit e al meu!");
        }
        if (numba == 171) {
            glumecc.setText("Funeraliile soţiei unui bun prieten:\n" +
                    "– Trebuie să fie foarte greu să pierzi o soţie…\n" +
                    "– Aproape imposibil.");
        }
        if (numba == 172) {
            glumecc.setText("Directorul unui cimitir sună la reprezentanţa unei firme de motociclete:\n" +
                    "– Câte motociclete aţi vândut în ultima săptămână?\n" +
                    "– Cinci bucăţi.\n" +
                    "– Aaa, înseamnă că unul încă se mai plimbă…");
        }
        if (numba == 173) {
            glumecc.setText("Anunţ în cimitir: “Furatul florilor se permite numai de pe mormintele proprii!”");
        }
        if (numba == 174) {
            glumecc.setText("Pe Titanic, vine căpitanul şi le spune călătorilor: – Am o veste bună şi una rea.\n" +
                    "Pasagerii: – Începe cu aia rea!\n" +
                    "Căpitanul:- În două minute o să ne lovim de un iceberg!\n" +
                    "Pasagerii:- Şi aia bună?\n" +
                    "Căpitanul: -Vom lua 11 OSCAR-uri pentru asta.");
        }
        if (numba == 175) {
            glumecc.setText("O mătuşică rătăcită prin oraş îl întreabă pe un tip un pic cherchelit:\n" +
                    "– Ce trebuie să iau ca să ajung la cimitir?\n" +
                    "– Otravă, mătuşă…");
        }
        if (numba == 176) {
            glumecc.setText("Nu atingeţi! Pericol de electrocutare!” trebuie să fie foarte interesant de citit în Braille.");
        }
        if (numba == 177) {
            glumecc.setText("Omul rănit cărat pe o targă bâguie către infirmieri:\n" +
                    "– Unde mă duceţi ?\n" +
                    "– La morgă..\n" +
                    "– Dar, încă n-am murit.\n" +
                    "– Păi, încă n-am ajuns");
        }
        if (numba == 178) {
            glumecc.setText("– Poţi citi numărul de înmatriculare al maşinii aceleia de aici? mă întreba instructorul meu.\n" +
                    "– Da! normal! i-am răspuns. Acum te rog, deschide paraşuta aia odată!");
        }
        if (numba == 179) {
            glumecc.setText("– Cum, ţi-a fost un prieten atât de bun şi nu te duci la înmormântarea lui?\n" +
                    "– Dar ce, el o să vină la a mea?!");
        }
        if (numba == 180) {
            glumecc.setText("Alinuţa îşi scrie ultimele dorinţe:\n" +
                    "– Înainte să mor, vreau să înghit o pungă de boabe de porumb. Să vezi apoi distracţie la crematoriu.");
        }
        if (numba == 181) {
            glumecc.setText("Mergea un psihopat prin pădure şi târa o fetiţă după el. La un moment dat fetiţa spune:\n" +
                    "– Mi-e frică!…\n" +
                    "La care psihopatu‘ :\n" +
                    "– Dar eu, că o să mă întorc singur!");
        }
        if (numba == 182) {
            glumecc.setText("– Cum se cheamă un câine surd?\n" +
                    "– Cum vrei tu, că oricum l-ai striga, nu te aude !");
        }
        if (numba == 183) {
            glumecc.setText("– De ce ţi-a murit câinele?\n" +
                    "– De foame, săracul.\n" +
                    "– Păi cum aşa, cu nevastă aşa dolofană?\n" +
                    "– Cât am fost în Spania, nevastă-mea l-a hrănit întotdeauna cu resturile de mâncare rămase de la ea.");
        }
        if (numba == 184) {
            glumecc.setText("Pilotul unui avion către turnul de control:\n" +
                    "– Mi s-a terminat combustibilul, cred că o să cad.\n" +
                    "Turnul:\n" +
                    "– Ok, mulţumesc, te ştergem din listă.");
        }
        if (numba == 185) {
            glumecc.setText("În Vaslui de Sfântul Valentin se oferă buchete de toporaşi.");
        }
        if (numba == 186) {
            glumecc.setText("Dupa ce a vorbit cu Poliţia la telefon, nevastă-mea a început să plângă şi mi-a spus:\n" +
                    "– Tocmai am aflat că mama a murit într-un accident de maşină… Nici nu-mi pot imagina prin ce a trecut, săraca!\n" +
                    "– Probabil prin parbriz…");
        }
        if (numba == 187) {
            glumecc.setText("Era odată un tip atât de leneş, că atunci când a murit, prietenii săi i-au pus următoarea inscripţie pe mormânt: “Aici continuă să se odihnească…”");
        }
        if (numba == 188) {
            glumecc.setText("În timp ce călăul pregătea toporul, îl intreb:\n" +
                    "– Era vorba că voi fi spânzurat. Acum îmi tăiați capul?!\n" +
                    "– Nu, picioarele. Este funia prea lungă!");
        }
        if (numba == 189) {
            glumecc.setText("– Care e partea bună a schizofreniei?\n" +
                    "– Că niciodată nu eşti singur.");
        }
        if (numba == 190) {
            glumecc.setText("Vreau să mor liniştit în timp ce dorm, la fel ca văr-meu Andreas şi nu ţipând de groază… ca pasagerii lui!");
        }
        if (numba == 191) {
            glumecc.setText("– Unde găseşti un câine fără picioare?\n" +
                    "– Acolo unde l-ai lăsat.");
        }
        if (numba == 192) {
            glumecc.setText("– Cum se numeşte înmormântarea unui electrician?\n" +
                    "– Împământare.");
        }
        if (numba == 193) {
            glumecc.setText("Un tânăr ziarist îi ia un interviu unui călău:\n" +
                    "– Domnule, nu vă este greu… cu meseria aceasta?\n" +
                    "– Ce vreţi, toată lumea trebuie să trăiască…");
        }
        if (numba == 194) {
            glumecc.setText("Ştirea zilei: accident aviatic în Caracal. Un avion utilitar s-a prăbuşit deasupra unui cimitir. Poliţia locală a descoperit peste o mie de morţi.");
        }
        if (numba == 195) {
            glumecc.setText("Un condamnat la moarte întreabă în timp ce era dus spre execuţie:\n" +
                    "– Cum funcţionează scaunul electric?\n" +
                    "– Vei fi pus imediat la curent.");
        }
        if (numba == 196) {
            glumecc.setText("Mai devreme mă spălam pe mâini în toaletă la bărbați și mă gândeam:\n" +
                    "”De ce naiba nu mă spăl eu în chiuvetă?”");
        }
        if (numba == 197) {
            glumecc.setText("– De ce înmormântările se plătesc în valută?\n" +
                    "– Pentru că se consideră plecări definitive din ţară.");
        }
        if (numba == 198) {
            glumecc.setText("Pe o corabie ce se scufunda, unul din pasageri îl întreabă pe căpitan:\n" +
                    "– Suntem departe de pământ?\n" +
                    "– Nu-i departe, un kilometru.\n" +
                    "– Dar în ce direcţie?\n" +
                    "– În jos…");
        }
        if (numba == 199) {
            glumecc.setText("Am citit că puiul poate să stea și trei zile în frigider fără să se strice.\n" +
                    "Am încercat, a murit după două minute.");
        }
        if (numba == 200) {
            glumecc.setText("Un condamnat este dus la spânzurătoare. La un moment dat acesta întreabă călăul:\n" +
                    "– Ce zi este astăzi?\n" +
                    "Călăul:\n" +
                    "– Luni.\n" +
                    "Condamnatul:\n" +
                    "– Să-mi bag piciorul, ce început de săptămână…");
        }
        if (numba == 201) {
            glumecc.setText("Am făcut un puşti de 5 ani să plângă.\n" +
                    "L-am pus să numere din 2 în 2 până la 7.");
        }
        if (numba == 202) {
            glumecc.setText("Oare ce făceau părinții noștri acu’ 30 de ani, când nu exista internet, ca să nu se plictisească?\n" +
                    "I-am întrebat pe cei unsprezece frați ai mei și niciunul n-a știut…");
        }
        if (numba == 203) {
            glumecc.setText("Nu folosesc semnalizarea că nu trebuie să ştie toată lumea încotro mă duc eu.");
        }
        if (numba == 204) {
            glumecc.setText("Slogan pentru o spălătorie auto: “Frumuseţea vine din interior exterior”.");
        }
        if (numba == 205) {
            glumecc.setText("Nepotul Patriarhului Daniel a fost reţinut pentru trafic de heroină.\n" +
                    "El s-a apărat spunând că doar ajută oamenii să se simtă dumnezeieşte.");
        }
        if (numba == 206) {
            glumecc.setText("Am auzit imnul României într-un magazin chinezesc. Mi s-a făcut pielea imitație de piele de găină.");
        }
        if (numba == 207) {
            glumecc.setText("Azi am găsit un portofel cu 500 de lei. Ca un bun creștin ce sunt, m-am gândit: “ce-ar face Isus în locul meu?”…și-atunci i-am transformat în vin.");
        }
        if (numba == 208) {
            glumecc.setText("\n" +
                    "Sunt praf. În două ore am băut 3 sticle de vodcă. Cred că plec cu ambulanța… Dar nu vă faceți griji, nu e prima dată când conduc beat.");
        }
        if (numba == 209) {
            glumecc.setText("Am fost la Disneyland pentru că băiatul meu adoră desenele cu Mickey Mouse. A fost foarte bucuros când am venit acasă și i-am povestit cum a fost ");
        }
        if (numba == 210) {
            glumecc.setText("I-am cerut şefului un avans. Mi-a spus că sunt drăguţ şi că ar vrea să mă scoată la cină într-o seară.");
        }
        if (numba == 211) {
            glumecc.setText("Am citit undeva că urșii panda sunt pe cale de dispariție încă din 1984. Ce rahat, cel mai încet truc de magie pe care l-am văzut");
        }
        if (numba == 212) {
            glumecc.setText("Când un prieten gay îți cere ajutorul, nu-i întoarce niciodată spatele.");
        }
        if (numba == 213) {
            glumecc.setText("Nu că vreau să mă dau important dar când am fost adineauri la supermarket ușile s-au deschis și s-au închis singure…");
        }
        if (numba == 214) {
            glumecc.setText("Durata unui minut variază în funcţie de care parte a uşii de la baie te afli…");
        }
        if (numba == 215) {
            glumecc.setText("– Domnule doctor, dați-mi vă rog o pastilă împotriva lăcomiei, dar să fie mai mare!");
        }
        if (numba == 216) {
            glumecc.setText("Doi funcționari se întâlnesc pe hol, pe la ora 11:\n" +
                    "– Și dumneata ai insomnie?");
        }
        if (numba == 217) {
            glumecc.setText("Sunt atât de sărac încât când mi-am plătit întreținerea la timp, a doua zi mi-a bătut poliţia la uşă să mă întrebe de unde am banii.");
        }
        if (numba == 218) {
            glumecc.setText("Am aflat că vecinul care pune manele la ora trei dimineaţa are câine.\n" +
                    "Acum, la ora patru, pun eu ultrasunete.");
        }
        if (numba == 219) {
            glumecc.setText("– Cum îi scoală Alba ca Zăpada pe cei șapte pitici?\n" +
                    "– Seven up.");
        }
        if (numba == 220) {
            glumecc.setText("Ştii că eşti bogat dacă mergi să scoţi bani de la bancă iar casiera te întreabă: “Doriţi sacoşă?”");
        }
        if (numba == 221) {
            glumecc.setText("Ieri, în autobuz, am cedat locul meu unui bătrânel orb.\n" +
                    "Azi, am fost concediat din funcția de șofer RATB…");
        }
        if (numba == 222) {
            glumecc.setText("Am văzut un afiș astăzi, care m-a făcut să mă scap pe mine! Scria “toalete închise”.");
        }
        if (numba == 223) {
            glumecc.setText("Până acum eram sărac dar mi-am cumpărat un dicționar de sinonime și acum sunt nevoiaș, sărman, oropsit și necăjit…");
        }
        if (numba == 224) {
            glumecc.setText("Am ieșit mai devreme din cinematograf și toată lumea zicea:\n" +
                    "– Film pentru proști, film pentru proști…\n" +
                    "Aiurea, nu știu ce vorbesc, mie mi-a plăcut!");
        }
        if (numba == 225) {
            glumecc.setText("– Daţi-mi, vă rog, de zece lei cireşe!\n" +
                    "– O doriţi feliată sau v-o împachetez direct?");
        }
        if (numba == 226) {
            glumecc.setText("Proverb din Vaslui: “bărbații sunt ca pantofii, dacă nu îi iei cum trebuie, te bat”.");
        }
        if (numba == 227) {
            glumecc.setText("Dacă aveţi de gând să mergeţi în cazino, îmbrăcaţi cei mai frumoşi chiloţi. S-ar putea să vă întoarceţi acasă numai în ei!");
        }
        if (numba == 228) {
            glumecc.setText("– Cucuriguuu, cântă găina.\n" +
                    "Uimit, cocoșul făcu un ou.");
        }
        if (numba == 229) {
            glumecc.setText("Am văzut la televizor că vremea va fi închisă. Totuși cred că de data asta DNA-ul a exagerat.");
        }
        if (numba == 230) {
            glumecc.setText("Nu pot să dorm liniștit atunci când știu că mâncării îi e frig în frigider…");
        }
        if (numba == 231) {
            glumecc.setText("Un avion face o rotire neașteptată și zboară cu ”trenul de aterizare în sus”.\n" +
                    "Stewardesa:\n" +
                    "– Dragi pasageri, vă rog să vă păstrați calmul. Pilotul își toarnă niște picături în nas, după care vom reveni la zborul obișnuit.");
        }
        if (numba == 232) {
            glumecc.setText("O vecină voia să se facă dansatoare de tango, dar a dat-o în bară.");
        }
        if (numba == 233) {
            glumecc.setText("Maxima zilei:\n" +
                    "23:59:59");
        }
        if (numba == 234) {
            glumecc.setText("Comandă la bar în club:\n" +
                    "– Două cuburi de gheață, vă rog. Și un pic de whisky, să nu le beau goale…");
        }
        if (numba == 235) {
            glumecc.setText("Prea multe dulcegării în jur, trebuie să-mi iau doza de insultină");
        }
        if (numba == 236) {
            glumecc.setText("Când eram mic, eram aşa obraznic încât, până la vârsta de cinci ani, am crezut că numele meu este “Doamne Dumnezeule!”");
        }
        if (numba == 237) {
            glumecc.setText("Frizerul il intreaba pe client : \n" +
                    "- Cum sa va tund ca sa fiti multumit ? \n" +
                    "- Gratis !");
        }
        if (numba == 238) {
            glumecc.setText("Asa pisica tii cainele ocupat peste 20 soareci de lup secunde canar un arici idiot. Acum citeste fara animale!");
        }
        if (numba == 239) {
            glumecc.setText("Mă tem că într-o zi o să rămân fără inspiraţie şi o să mă sufoc.");
        }
        if (numba == 240) {
            glumecc.setText("– Ce înseamnă codul de bare de pe un produs la somalezi?\n" +
                    "– Poza cu angajaţii fabricii.");
        }
        if (numba == 241) {
            glumecc.setText("– Cine a fost primul om pe Lună?\n" +
                    "– Un somalez care s-a jucat cu elasticul de la chiloţi.");
        }
        if (numba == 242) {
            glumecc.setText("\n" +
                    "Î:De ce umbla un somalez cu capul într-o parte pe strada?\n" +
                    "R:Are o masea plombata.");
        }
        if (numba == 243) {
            glumecc.setText("Î:De ce cade un somalez din copac ca o sageata?\n" +
                    "R:Are maselele plombate.");
        }
        if (numba == 244) {
            glumecc.setText("Î:Cum cade un somalez din copac?\n" +
                    "R:Ca o frunza.");
        }
        if (numba == 245) {
            glumecc.setText("\n" +
                    "Î:Cum deosebesti un somalez de o minge de tenis de câmp?\n" +
                    "R:Mingea cântareste 200 de grame mai mult.");
        }
        if (numba == 246) {
            glumecc.setText("Î:Ce e un somalez cu piciorul în ghips?\n" +
                    "R:Crosa de hochei.");
        }
        if (numba == 247) {
            glumecc.setText("Î:Cum se numeste un somalez cu strungareata?\n" +
                    "R:Grebla…");
        }
        if (numba == 248) {
            glumecc.setText("Î:Ce sunt doi somalezi în sacul de dormit:\n" +
                    "R:Twix!");
        }
        if (numba == 249) {
            glumecc.setText("Î:Cum a cazut guvernul din Somalia?\n" +
                    "R:Au taiat copacul…");
        }
        if (numba == 250) {
            glumecc.setText("Î:Câti somalezi încap într-un autobuz?\n" +
                    "R:Toti.");
        }
        if (numba == 251) {
            glumecc.setText("Î:Ce folosesc somalezii, de preferinta, ca sac de dormit?\n" +
                    "R:Un pai.");
        }
        if (numba == 252) {
            glumecc.setText("\n" +
                    "Î:Cum se saluta somalezii ?\n" +
                    "R:Ce vânt te aduce p’aici, frate ?");
        }
        if (numba == 253) {
            glumecc.setText("\n" +
                    "O echipă de zugravi a primit sarcina să zugrăvească spitalul de nebuni. Unul dintre ei se duce la director şi-i spune:\n" +
                    "– Daţi-mi doi nebuni, mai puţin nebuni, ca să ne ţină scările.\n" +
                    "Primesc ajutoare şi apoi se pun la treabă. Când zugravii erau sus, unul dintre nebuni zice:\n" +
                    "– Ţine-te de bidinea, că eu iau scara să zugrăvesc!");
        }
        if (numba == 254) {
            glumecc.setText("\n" +
                    "Doi nebuni planuiau sa fuga de la balamuc:\n" +
                    "– Daca zidul e scund, sarim, daca e inalt, sapam o groapa. Ai inteles?\n" +
                    "– Da.\n" +
                    "Trece ceva timp, se intoarce nebunul.\n" +
                    "– Nu putem scapa!\n" +
                    "– De ce?\n" +
                    "– Nu exista zid!");
        }
        if (numba == 255) {
            glumecc.setText("- Doctore, soţul meu se crede avion.\n" +
                    "– Aduceţi-l mâine la mine.\n" +
                    "– Dar pistă de aterizare aveţi?");
        }
        if (numba == 256) {
            glumecc.setText("Doi nebuni se întâlnesc în deşert. Unul avea o căciulă de blană pe cap, iar celălalt ţinea o portieră. Cel cu portiera îl întreabă pe cel cu căciula:\n" +
                    "– Se vede că eşti nebun! Ce faci cu căciula în deşert?\n" +
                    "– Băăăi, nebun eşti tu! Când mi-e cald, îmi scot căciula, dar tu ce faci cu portiera?\n" +
                    "– Eu deschid geamul!");
        }
        if (numba == 257) {
            glumecc.setText("Doi nebuni mergeau prin pădure, bucurându-se de răcoarea pe care le-o oferă aceasta. La un moment dat, unul vede o puşcă. O ridică şi, mirat, îl întreabă pe celălalt:\n" +
                    "– Măi, ce-o fi asta?\n" +
                    "Şi se uită pe ţevi. Al doilea se apucă şi mângâie arma întrebându-se ce-o fi şi îi spune primului:\n" +
                    "– Uite, am găsit aici ceva şi se mişcă.\n" +
                    "Apasă pe trăgaci. Cel care se uita pe ţevi cade desfigurat, La care al doilea îl întreabă:\n" +
                    "– No’ amu’ de ce faci faţa asta, că şi eu m-am speriat.");
        }
        if (numba == 258) {
            glumecc.setText("La un bijutier, soţia unui evreu probează o brăţară masivă din aur, apoi îşi întreabă soţul, dacă îi place. Soţul verifică preţul în catalog apoi îi spune:\n" +
                    "– Nu, dragă! Brăţara asta te îngraşă!");
        }
        if (numba == 259) {
            glumecc.setText("\n" +
                    "Î:Care e diferenta dintre un evreu si o minge de baschet ?\n" +
                    "R:În minge nu se da cu piciorul.");
        }
        if (numba == 260) {
            glumecc.setText("Evreu care şi-a pierdut braţul stâng, caut evreu care şi-a pierdut braţul drept, pentru a împărţi împreună costul unei perechi de manuşi.");
        }
        if (numba == 261) {
            glumecc.setText("– De unde avea Ştefan cel Mare cizmele?\n" +
                    "– De la genunchi în jos.");
        }
        if (numba == 262) {
            glumecc.setText("Cică Napoleon stătea pe cal, la Waterloo. La un moment dat, vede ceva în zare şi strigă:\n" +
                    "– Soldat, adu-mi luneta!\n" +
                    "La care soldatul:\n" +
                    "– Mon Dieu, vous parlez en Roumain!?");
        }
        if (numba == 263) {
            glumecc.setText("Am descoperit punctul slab al lui Chuck Norris: Analiza matematică.\n" +
                    "El practic nu cunoaşte limitele.");
        }
        if (numba == 264) {
            glumecc.setText("-Jon,cate grade sunt inauntru?\n" +
                    "-26,Sir\n" +
                    "-Si cate grade sunt afara?\n" +
                    "-6\n" +
                    "-deschide geamul sa intre si gradele de afara");
        }
        if (numba == 265) {
            glumecc.setText("- John, unde e palaria mea?\n" +
                    "- O aveti pe cap, sir.\n" +
                    "- Bine, o gasesc eu mai tarziu.");
        }
        if (numba == 266) {
            glumecc.setText("Sir si John erau naufargiati pe o insula. Dupa multe luni John vine la Sir tipand:\n" +
                    "- Sir, Sir, se vede un vapor la orizont!!!\n" +
                    "La care Sir ii spune cu un calm tipic englezesc:\n" +
                    "- Linisteste-te John, ce n-ai mai vazut vapoare?");
        }
        if (numba == 267) {
            glumecc.setText("Intra un cowboy in salon si vede o femeie frumoasa. Nu stie cum sa intre\n" +
                    "in vorba cu ea. Scoate pistoalele si ii impusca pe toti, dupa care o intreaba: \n" +
                    "-Si ce faci tu aici...singurica?");
        }
        if (numba == 268) {
            glumecc.setText("La un interviu:\n" +
                    "- Si acum, daca aveti cumva vreo intrebare despre firma noastra..\n" +
                    "- Pai... m-ar interesa sa stiu cam cati oameni lucreaza in firma\n" +
                    "dumneavoastra.\n" +
                    "- In general, cam un sfert...");
        }
        if (numba == 269) {
            glumecc.setText("Un pitic intra intr-o farmacie si cere o aspirina. Farmacista il intreaba:\n" +
                    "- Sa v-o impachetez?\n" +
                    "- Nu, multumesc. O s-o rostogolesc...");
        }
        if (numba == 270) {
            glumecc.setText("Usa se deschide brusc si baiatul intra in casa:\n" +
                    "-Buna ziua, tata!\n" +
                    "Tatal, fara sa-si ia ochii de la monitor:\n" +
                    "-Pe unde ai umblat?\n" +
                    "-Am fost in armata!");
        }
        if (numba == 271) {
            glumecc.setText("Un tip irascibil la magazin:\n" +
                    "- Doamna, nervi aveti?\n" +
                    "- Nu!\n" +
                    "- Nu-i nimic, va fac eu...");
        }
        if (numba == 272) {
            glumecc.setText("-Ce film se ruleaza in America ?\n" +
                    "- `Om sarac om bogat`.\n" +
                    "-Ce film se ruleaza in Rusia ?\n" +
                    "-`Om sarac, om sarac `.\n" +
                    "-Ce film se ruleaza in Romania ?\n" +
                    "- `Om` trai si om` vedea `.");
        }
        if (numba == 273) {
            glumecc.setText("- Ce-ai vanat azi, Ioane?\n" +
                    "- Cativa pliznoti...\n" +
                    "- ?!?!\n" +
                    "- Cand indreptam arma spre ei strigau: `Pliz not! Pliz not!`");
        }
        if (numba == 274) {
            glumecc.setText("- Care este momentul cel mai potrivit pentru culegerea fructelor?\n" +
                    "- Momentul in care lipseste paznicul.");
        }
        if (numba == 275) {
            glumecc.setText("- Cati oameni lucreaza aici?\n" +
                    "- Cu seful, 10.\n" +
                    "- Dar fara sef?\n" +
                    "- Fara sef, in general, nu lucreaza nimeni.");
        }
        if (numba == 276) {
            glumecc.setText("Unui om de stiinta renumit ii vin niste oaspeti in vizita. Cand intra in camera, ei observa ca deasupra patului omul nostru are o potcoava.\n" +
                    "- Cum se poate asa ceva? Doar nu sunteti superstitios?\n" +
                    "- Nicidecum, dar mi-a zis cineva ca ii ajuta si pe cei care nu cred in superstitii.");
        }
        if (numba == 277) {
            glumecc.setText("Un copil plangea pe holul scolii. Invatatoarea il intreaba:\n" +
                    "- De ce plangi?\n" +
                    "- Un copil mi-a dat jos placinta!\n" +
                    "- Dar a fost cu intentie?\n" +
                    "- Nu, a fost cu branza.");
        }
        if (numba == 278) {
            glumecc.setText("- Cand va incepe Foamea Mondiala?\n" +
                    "- Cand vor incepe chinezii sa manance cu lingura.");
        }
        if (numba == 279) {
            glumecc.setText("- Chelner!\n" +
                    "- Da, domnule.\n" +
                    "- Te rog sa imi mai prajesti putin puiul... imi mananca toata salata!");
        }
        if (numba == 280) {
            glumecc.setText("In tramvai:\n" +
                    "- E cineva fara bilet acolo, in fund?\n" +
                    "- Eu, dar mi-l bag imediat!");
        }
        if (numba == 281) {
            glumecc.setText("În spatele unei porţi pe care scria `Câine rău`, se vede un căţel mic şi pufos. Un om trece pe langă poartă şi zice : \n" +
                    "- Cum de eşti tu, mă, câine rău?\n" +
                    "La care câinele:\n" +
                    "-Sunt rău ca nu pap tot laptele.");
        }
        if (numba == 282) {
            glumecc.setText("-ioane...iti bate lantu\n" +
                    "-ce ma?\n" +
                    "-ioane iti bate lantu\n" +
                    "-ce ma?nu te-aud k-mi bate lantu");
        }
        if (numba == 283) {
            glumecc.setText("Nu beau, nu fumez, ma scol la 6 in fiecare zi, ma culc la 10, nu-mi insel nevasta. \n" +
                    "Dar si cand oi iesi din puscarie...");
        }
        if (numba == 284) {
            glumecc.setText("2 mosi stau pe o banca in parc si vb:\n" +
                    "1 mos: auzi ma, o vezi tu pe roscata aia buna de acolo?\n" +
                    "al 2-lea mos: da ma o vad...ce-i cu ea?\n" +
                    "1 mos: moare dupa mine! sunt sigur!\n" +
                    "al 2-lea mos: de unde stii ma?\n" +
                    "1 mos: pai doar nu o murii inaintea mea!");
        }
        if (numba == 285) {
            glumecc.setText("Dupa ce loveste un pieton, o masina isi continua drumul inca vreo 10 metri...\n" +
                    "Soferul scoate capul pe fereastra si tipa:\n" +
                    "- Fii ba atent! \n" +
                    "Pietonul se ridica repede, speriat, impleticindu-se si intreaba:\n" +
                    "- De ce ba?, dai inapoi ?");
        }
        if (numba == 286) {
            glumecc.setText("- Alo, buna ziua, Casa Poporului?\n" +
                    "- Da.\n" +
                    "- Cu poporul, va rog!");
        }
        if (numba == 287) {
            glumecc.setText("Exista trei tipuri de oameni: unii care stiu sa numere si altii care nu stiu...");
        }
        if (numba == 288) {
            glumecc.setText("Se intalnesc doi tipi in desert. Zice unu`:\n" +
                    "- Hei tu!\n" +
                    "- Cine, eu?...");
        }
        if (numba == 289) {
            glumecc.setText("Stiti care e morala?\n" +
                    "Nu da cu piatra-n geam ca nu e bicicleta ta...");
        }
        if (numba == 290) {
            glumecc.setText("Un marinar sta in portul Marsiliei si bea de nu se mai tine pe picioare. Un trecator intra in vorba:\n" +
                    "- Stiti ca anual mor peste 10 000 de francezi din cauza bauturii?\n" +
                    "- Nu ma intereseaza! Eu sunt rus...");
        }
        if (numba == 291) {
            glumecc.setText("Cum se numeste un lepros in apa termala?\n" +
                    "Supa...");
        }
        if (numba == 292) {
            glumecc.setText("Ce-i zice leprosul la magazin?\n" +
                    "Pastreaza restul...");
        }
        if (numba == 293) {
            glumecc.setText("- Prin ce se deosebeste omul de masina?\n" +
                    "- Inca nu a fost inventata o masina care sa nu faca nimic...");
        }
        if (numba == 294) {
            glumecc.setText("Culmea celor lenţi: Să li se strice mâncarea in timp ce o mănâncă.");
        }
        if (numba == 295) {
            glumecc.setText("culmea rasului: sa gadili becul si sa rada electricianul");
        }
        if (numba == 296) {
            glumecc.setText("Culmea suspansului: iti spun maine");
        }
        if (numba == 297) {
            glumecc.setText("Culmea matematicii:sa pui tabla inmultiri pe acoperis.");
        }
        if (numba == 298) {
            glumecc.setText("Culmea fotbalului:sa dai gol in penalti si sa ratezi in reluare.");
        }
        if (numba == 299) {
            glumecc.setText("Culmea ceasului desteptator: sa sune ocupat…");
        }
        if (numba == 300) {
            glumecc.setText("Cumea fizicii: sa pui un cal putere sa pasca pe un cîmp magnetic.");
        }
        if (numba == 301) {
            glumecc.setText("Culmea zgîrceniei: în testament sa-ti lasi toata averea tie însuti.");
        }
        if (numba == 302) {
            glumecc.setText("Culmea geneticii: sa împerechezi o capra de taiat lemne cu un tap de bere.");
        }
        if (numba == 303) {
            glumecc.setText("Culmea cutremurului: sa urci cu liftul si sa cobori cu apartamentul.");
        }
        if (numba == 304) {
            glumecc.setText("Culmea sarituri: Sa sari de pe un bloc de desesn si sa te prinzi cu dintii de bordura");
        }
        if (numba == 305) {
            glumecc.setText("culmea culmii: ar fi si culmea so sti si pe asta");
        }
        if (numba == 306) {
            glumecc.setText("culmea hotiei: sa furi curent cu galeata.");
        }
        if (numba == 307) {
            glumecc.setText("DOi Vulturi stateau pe o craca al treilea statea sa cada");
        }
        if (numba == 308) {
            glumecc.setText("I:Unde se gasesc maimutzele cu 3 \n" +
                    "ochi,multicolore si fara coada?\n" +
                    "R:La magazinul de maimutze cu 3 ochi,multicolore si fara coada..");
        }
        if (numba == 309) {
            glumecc.setText("Doua baloane zburau si unul zice:\n" +
                    "-Ba,mai poti?\n" +
                    "Iar celalalt raspunde:\n" +
                    "-Mai poc.");
        }
        if (numba == 310) {
            glumecc.setText("La miezul noptii, in lumina orbitoare a soarelui, se aud trei impuscaturi de cutit.Victima avea frunte lata si pantaloni de aceeasi culoare.");
        }
        if (numba == 311) {
            glumecc.setText("Erau peo banca trei copii.pe unul il chema Rares pe altul andrei iar pe ultimul masa in casa.");
        }
        if (numba == 312) {
            glumecc.setText("- Ce-i trece unei muste prin cap cand se loveste de parbrizul unei masini care merge cu 120 km la ora?\n" +
                    "- ????\n" +
                    "- Fundu`!");
        }
        if (numba == 313) {
            glumecc.setText("- Tata ce este un travestit?\n" +
                    "- Intreaba pe mama, el stie...");
        }
        if (numba == 314) {
            glumecc.setText("De cati psihologi e nevoie ca sa schimbe un bec?!\n" +
                    "- ?!?\n" +
                    "- De unul singur....cu conditia ca becul sa vrea!");
        }
        if (numba == 315) {
            glumecc.setText("- Cum trece un american strada?\n" +
                    "- Se uita in stanga, in dreapta...in sus si apoi traverseaza.");
        }
        if (numba == 316) {
            glumecc.setText("- Un om mergea pe cal si dintr-o data a cazut. De ce?\n" +
                    "- S-a terminat calul.");
        }
        if (numba == 317) {
            glumecc.setText("-Ce i-a spus cafeaua zaharului?\n" +
                    "-Fara tine, viata mea ar fi amara.");
        }
        if (numba == 318) {
            glumecc.setText("Merge un tip la o covrigarie:\n" +
                    "- Buna ziua!\n" +
                    "- Mdea (sictirita...)\n" +
                    "- Aveti covrigi mici si tari?\n" +
                    "- Mdea...\n" +
                    "- Si cine dreacu` vi-i cumpara?");
        }
        if (numba == 319) {
            glumecc.setText("Jos pe fundul baltii\n" +
                    "Patru ochi vegheste,\n" +
                    "Ce sa este oare?\n" +
                    "Consider ca este doua peste");
        }
        if (numba == 320) {
            glumecc.setText("Doi surzi se intalnesc pe strada:\n" +
                    "1: Te duci la pescuit?\n" +
                    "2: Nu. Ma duc la pescuit.\n" +
                    "1: A... Si eu care credeam ca te duci la pescuit.");
        }
        if (numba == 321) {
            glumecc.setText("Era odata un pescar cam ghinionist. Un trecator cam curios il intreaba:\n" +
                    "- Are balta peste?\n" +
                    "- Are... (oftand)... da-i acoperit de apa!");
        }
        if (numba == 322) {
            glumecc.setText("Care-i asemanarea dintre un divort in Kentucky si o tornada? \n" +
                    "... \n" +
                    "In ambele cazuri cineva pierde o rulota. ");
        }
        if (numba == 323) {
            glumecc.setText("De ce bagi un bebelus intr-un blender cu picioarele intai? \n" +
                    "... \n" +
                    "Pentru expresii faciale. ");
        }
        if (numba == 324) {
            glumecc.setText("ce zice tarzan cand vede o mie de elefanti venind spre el?\n" +
                    "ia ute frate,o mie de elefanti venind spre mine!!");
        }
        if (numba == 325) {
            glumecc.setText("-Nu va suparati, caut strada Libertatii!\n" +
                    "-Nu ma supar! Cautati-o!");
        }
        if (numba == 326) {
            glumecc.setText("Un om era pe moarte...da' s-a dat jos!");
        }
        if (numba == 327) {
            glumecc.setText("ce este albastru si umbla pe sub pamant?raspuns:o rama in trening");
        }
        if (numba == 328) {
            glumecc.setText("\n" +
                    "Un tip cade de la etajul 7. Dupa vreo 5 minute îi cade si parul: vjjjupp!\n" +
                    "Folosise o lotiune care întîrzia caderea parului !");
        }
        if (numba == 329) {
            glumecc.setText("Doi delfini taiau benzina pe fundu' marii. Vine un rechin:\n" +
                    "- Ce faceti acilea?\n" +
                    "- Taiem benzina!\n" +
                    "- Aveti grija sa nu faceti firmituri!");
        }
        if (numba == 330) {
            glumecc.setText("Un om mergea pe strada.\n" +
                    "Si a disparut!\n" +
                    "De ce???\n" +
                    "Il manca nasul!");
        }
        if (numba == 331) {
            glumecc.setText("\n" +
                    "De ce are elefantul ochii rosii?\n" +
                    "(raspuns)Ca sa poata sa se ascunda in cires");
        }
        if (numba == 332) {
            glumecc.setText("Ati vadut vreodata elefanti in cires?\n" +
                    "Daca nu, inseamna ca s-au ascuns bine!");
        }
        if (numba == 333) {
            glumecc.setText("2 soareci se uita printr-o teava.Unul de la un capat , celalalt de la alt capat.\n" +
                    "Intrebare:De ce nu se vad?\n" +
                    "Ras:Pentru ca unul se uita marti si celalalt miercuri.");
        }
        if (numba == 334) {
            glumecc.setText("Purcelushul super`agresiv, la restaurant, catre chelner:\"Aici se primesc comenzi?\"\n" +
                    "\"Da!\"\n" +
                    "\"SEZI!\"");
        }
        if (numba == 335) {
            glumecc.setText("cum face un cal cand merge in linie dreapta?tropa tropa.dar cum face cand merge in linie stramba?tropa tropa sin de alfa.\n");
        }
        if (numba == 336) {
            glumecc.setText("Ce este perfect rotund si din sticla?\n" +
                    "Un cub de lemn.");
        }
        if (numba == 337) {
            glumecc.setText("Doi crocodili zburau deasupra oceanului Pacific.La un moment dat cel din mijloc spune:\n" +
                    "-Bai,zburam de o saptamana si tot vineri e!");
        }
        if (numba == 338) {
            glumecc.setText("-John?!\n" +
                    "-Yes Sir!\n" +
                    "-Lamâia are pene?\n" +
                    "-Nu Sir!\n" +
                    "-La naiba, iar am stors papagalul! ");
        }
        if (numba == 339) {
            glumecc.setText("John: Sir, avem un hot în biblioteca...\n" +
                    "Sir: Si ce citeste, John ?");
        }
        if (numba == 340) {
            glumecc.setText("-John, ce-a fost zgomotul acela puternic?\n" +
                    "-Sir, un automobilst a vrut sa intre pe o strada laterala.\n" +
                    "-Si?\n" +
                    "-Si, sir, strada nu se afla în locul unde a virat automobilistul.");
        }
        if (numba == 341) {
            glumecc.setText("Un om soseste în graba la Sir:\n" +
                    "-Sir, John a sarit cu parasuta si nu s-a deschis.\n" +
                    "-Iar?!");
        }
        if (numba == 342) {
            glumecc.setText("-John, spune Sir, care citea ziarul, pe acoperis circula tramvaie?\n" +
                    "-Nu, Sir?! Dar de ce întrebati?\n" +
                    "-Uite, aici scrie ca un tramvai a calcat un hornar...");
        }
        if (numba == 343) {
            glumecc.setText("Sir se urca pe cal invers, cu spatele în fata...\n" +
                    "-Sir, spune John, dar nu asa se urca pe cal!\n" +
                    "-Taci, ma, de unde stii tu încotro vreau sa merg...");
        }
        if (numba == 344) {
            glumecc.setText("Cele mai importante lucruri in viata sunt lucrurile ");
        }
        if (numba == 345) {
            glumecc.setText("Sotia ta unde e?\n" +
                    "- In gradina.\n" +
                    "- Dar nu o vad.\n" +
                    "- Trebuie sa sapi putin.");
        }
        if (numba == 346) {
            glumecc.setText("Vad un olog pe strada si ii spun: Daca iti dau un picior, mergi sau zbori ?");
        }
        if (numba == 347) {
            glumecc.setText("Sloganul unui restaurant canibal : \"Primul venit , primul servit \"");
        }
        if (numba == 348) {
            glumecc.setText("-Mami! Tata iar s-a imbatat!\n" +
                    "-De unde stii?\n" +
                    "-Barbiereste oglinda din baie.");
        }
        if (numba == 349) {
            glumecc.setText("-Stii bancul ala cu iepurele in baie?\n" +
                    "-Nu!\n" +
                    "-Nici eu, ca usa era inchisa.");
        }
        if (numba == 350) {
            glumecc.setText("Stilpul se apropia cu viteza, am incercat sa il evit dar...... a intrat in mine!");
        }
        if (numba == 351) {
            glumecc.setText("Erau odata doua baloane prin desert, un balon ii spune celuilalt: \"Uite un cactusssssssss\"...");
        }
        if (numba == 352) {
            glumecc.setText("- Stii bancul cu iarna? \n" +
                    "- Iar n-am bani in buzunar");
        }
        if (numba == 353) {
            glumecc.setText("Cel mai micinos animal: ursul, zice \"mor, mor\" si nu moare....");
        }
        if (numba == 354) {
            glumecc.setText("Ce e o linie alba in desert?\n" +
                    "...o ata alba\n" +
                    "Ce e o linie neagra in desert?\n" +
                    "...umbra atei");
        }
        if (numba == 355) {
            glumecc.setText("- Cel mai scurt si mai sec banc:\n" +
                    "- DOP !");
        }
        if (numba == 356) {
            glumecc.setText("- Ce intra pe o ureche si iese pe cealalta si ramane si in cap?\n" +
                    "- Tarnacopu' !");
        }
        if (numba == 357) {
            glumecc.setText("Ce e galben si merge pe sub pamant?\n" +
                    "Un vietnamez care cauta o bomba.\n" +
                    "Ce e galben si zboara?\n" +
                    "UN vietnamez care a gasit-o.");
        }
        if (numba == 358) {
            glumecc.setText("Merg 2 orbi la cinematograf. Incepe filmu la care 1 dintre ei zice \"ma, tu vezi ceva ?\", nu, raspunde asta. Atunci hai sa mergem mai in fata.");
        }
        if (numba == 359) {
            glumecc.setText("Mutu ii spune lui Surdu ca Chiorul a vazut un Schiop alergand dupa un Chel sa il traga de par .");
        }
        if (numba == 360) {
            glumecc.setText("- Sitzi cum se uita o rata in beci?\n" +
                    "- Iei rata, o duci in beci si o uiti acolo...");
        }
        if (numba == 361) {
            glumecc.setText("-Ce trebuie sa ii faci unui hipopotam care are diaree?\n" +
                    "-Loc!!!");
        }
        if (numba == 362) {
            glumecc.setText("-Ce e verde si alerga prin padure?\n" +
                    "-O haita de castraveti!");
        }
        if (numba == 363) {
            glumecc.setText("De ce nu alearga melcul? Sa nu-si fluture ochii...");
        }
        if (numba == 364) {
            glumecc.setText("Doi scheleti se trag de piele!!!");
        }
        if (numba == 365) {
            glumecc.setText("Cine rade la urma, gandeste mai incet.");
        }
        if (numba == 366) {
            glumecc.setText("- Cum afli sexul lebedelor de pe lac?\n" +
                    "- Arunci o bucata de paine:..daca vine ea....e lebada;.....daca vine el ...e lebadoiu...");
        }
        if (numba == 367) {
            glumecc.setText("- V-am povestit vreodata despre mine?\n" +
                    "- Minele sunt niste gauri din care ies minerii !!!");
        }
        if (numba == 368) {
            glumecc.setText("Cica un lup dadea tircoale la o stina.La un momentdat s-a oprit.De ce?\n" +
                    "R:Pentru ca nu mai avea tircoale...");
        }
        if (numba == 369) {
            glumecc.setText("Un mut ii spune unui surd:\n" +
                    "- Ne urmareste un orb!");
        }
        if (numba == 370) {
            glumecc.setText("La coltul unei case rotunde se auzi o impuscatura de cutit. Mortul cazu spanzurat.");
        }
        if (numba == 371) {
            glumecc.setText("Era un submarin deasupra desertului. La un moment dat se opreste ,se ridica periscopul si un matelot se uita prin el. \n" +
                    "Comandantul: -Cati? \n" +
                    "Matelotul: -15 \n" +
                    "Comandantul: -Ce 15? \n" +
                    "Matelotul: -Ce cati? ");
        }
        if (numba == 372) {
            glumecc.setText("O rosie statea in mijlocul unei autostrazi!Alta ii spune:\n" +
                    "-Ai grija!Vine un camion!\n" +
                    "La care ea raspunde:\n" +
                    "-Ete....fleoshc");
        }
        if (numba == 373) {
            glumecc.setText("Faza pe bune la un semafor: unu' nervos e injurat:\n" +
                    "- Zambi-mi-ai de sub tramvai!");
        }
        if (numba == 374) {
            glumecc.setText("Doi tantari erau pe o motocicleta Harley Davidson. Unu' zice: \"Opreste ma, ca mi-a intrat o musca-n ochi\" !");
        }
        if (numba == 375) {
            glumecc.setText("Un copil intreaba pe tata-sau: \n" +
                    "-De ce sunt rosiile astea asa de galbene?\n" +
                    "-Pentru ca sunt verzi...");
        }
        if (numba == 376) {
            glumecc.setText("-Ce se intampla daca incalci una din cele zece porunci?\n" +
                    "-RAMAN NOUA!!!");
        }
        if (numba == 377) {
            glumecc.setText("I:Ce e mic ,verde si se urca pe pereti? \n" +
                    "R:Un castravete ambitios");
        }
        if (numba == 378) {
            glumecc.setText("- STITI DE CE II ZICE BILEI -\"BILA\"?\n" +
                    "- PT. CA FACE PLEOSC-PLEOSC CAND CADE; DACA FACEA PLEOSC-PLEOSC-PLEOSC, II ZICEA TRILA!");
        }
        if (numba == 379) {
            glumecc.setText("Cum se vaneaza un iepure?\n" +
                    "Vanatorul se ascunde intr-un tufis si face ca varza.");
        }
        if (numba == 380) {
            glumecc.setText("-ALO, GRESEALA?\n" +
                    "-NU.");
        }
        if (numba == 381) {
            glumecc.setText("Porcusorul isteric statea peste 7 mari si 7 tari. Intr-o dimineata se trezeste, se uita pe geam si zice:\n" +
                    "- Ba, ce departe stau!");
        }
        if (numba == 382) {
            glumecc.setText("O bila se rostogoleste pana la capat, acolo se rastoarna ...");
        }
        if (numba == 383) {
            glumecc.setText("Ce-i mic negru cu doua puncte albe?\n" +
                    "un purice cu vata in urechi");
        }
        if (numba == 384) {
            glumecc.setText("Pe o linie ferata mergea mama rosie, tatal rosie si copilul. Juniorul ramanea in urma. Se intoarce tatal ii dau un punm in cap si il face sos de tomate, dupa care zice: \n" +
                    "- Floscaitule !");
        }
        if (numba == 385) {
            glumecc.setText("Doua clatite merg! La un moment dat una se impiedica si ii sare gemu ");
        }
        if (numba == 386) {
            glumecc.setText("Elefantii zboara cu ajutorul urechilor.\n" +
                    "Ati vazut vreun elfant zburand?\n" +
                    "Deci zboara foarte repede.\n");
        }
        if (numba == 387) {
            glumecc.setText("- Ce sta in copac,e galbena si miauna?\n" +
                    "- O banana!");
        }
        if (numba == 388) {
            glumecc.setText("Cate baterii are un ceas mecanic?\n" +
                    "Raspuns: era intrebare capcana, ceasu` mecanic n-are decat 3 baterii");
        }
        if (numba == 389) {
            glumecc.setText("la usa:\n" +
                    "\"cioc, cioc\"\n" +
                    "dinauntru:\"cine e?\"\n" +
                    "raspuns:\"eu\"\n" +
                    "intrebare:\"EU???????\"");
        }
        if (numba == 390) {
            glumecc.setText("Doi magari stateau la coada, la coada altui magar");
        }
        if (numba == 391) {
            glumecc.setText("In anul 1854 este gasit un negru mort cu 18 gloante in spate. Seriful face constatarea si zice :\n" +
                    "-MMAAAAMAAAA ,asa sinucidere n-am mai intalnit.");
        }
        if (numba == 392) {
            glumecc.setText("Un tren opreste in gara Caracal.. Un calator da geamul in jos si intreaba un trecator: \n" +
                    "-Nu va suparati, gara Caracal?! \n" +
                    "-Bine ca esti tu destep t...");
        }
        if (numba == 393) {
            glumecc.setText("I: - Ce reprezinta un punct alb in desert?\n" +
                    "R: - O aspirina.");
        }
        if (numba == 394) {
            glumecc.setText("Un pitic pica intr-o prapastie, se chinuie saracu' sa iasa de acolo dar in zadar. Vine un urias, il ia in palma si-l intreaba:\n" +
                    "- Catzi? \n" +
                    "- 5 \n" +
                    "Uriasul nedumerit:\n" +
                    "- Ce 5 ? \n" +
                    "Dar piticul:\n" +
                    "- Ce catzi ?");
        }
        if (numba == 395) {
            glumecc.setText("-DE CE ARE ELEFANTUL TROMPA ASA DE LUNGA \n" +
                    "-CA SA NU INCEAPA ATAT DE BRUSC");
        }
        if (numba == 396) {
            glumecc.setText("ce este mare, are 4 picioare, coama, copite si incepe cu litera \"V\" ?\n" +
                    "- un cal pe nume Vasile......");
        }
        if (numba == 397) {
            glumecc.setText("Doarme unul.... de doarme se trezeste dimineata si vrea sa imbrace. Cand colo, ce sa vezi ? Nu-l mai incapeau hainele... De ce?\n" +
                    "SE UMFLASE DE SOMN !!!");
        }
        if (numba == 398) {
            glumecc.setText("- Am auzit voci!\n" +
                    "- Calmeaza-te, sunt vocile noastre, cand dialogam, ele se aud!");
        }
        if (numba == 399) {
            glumecc.setText("Erau 3 Ferrari pe o autostrada.\n" +
                    "Se intreceau la viteza maxima, la un moment dat unu o ia la dreapta...");
        }
        if (numba == 400) {
            glumecc.setText("-Ce culoare are culoarea rosie?\n" +
                    "-Verde!");
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

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Random rodrigo =new Random();
        int numba = rodrigo.nextInt(500);

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
        if(numba == 0){
            glumecc.setText("De frica sa nu fie date afara de la ore din cauza fustei, elevele de la Jean Monnet vin la scoala numai in bikini");
        }
        if(numba == 1){
            glumecc.setText("\n" +
                    "-Stii de ce nu mananca elefantii mamaliga ?\n" +
                    "-?????\n" +
                    "-Pentru ca nu le da nimeni !");
        }
        if(numba == 2){
            glumecc.setText("Nevasta-mea a fost concediata, dupa doar o zi ca model nud pentru studentii de la Arte.\n" +
                    "Toti desenasera un jeleu...");
        }
        if(numba == 3){
            glumecc.setText("Exista acel \"ceva\" intre mine si nevasta-mea, care cred ca nu se va sfarsi niciodata.\n" +
                    "Ba mai mult, creste pe zi ce trece.\n" +
                    "Burta ei.");
        }
        if(numba == 4){
            glumecc.setText("Cele mai multe neveste sunt prea umaniste ca să înțeleagă, dar, tehnic vorbind, băutura este o soluție!");
        }
        if(numba == 5){
            glumecc.setText("DIETA\n" +
                    "Ziua 1\n" +
                    "Am scapat de toata mancarea nesanatoasa din casa...\n" +
                    "A fost delicioasa...");
        }
        if(numba == 6){
            glumecc.setText("- Noi doi nu avem aceleasi pareri. Este imposibil sa ma inteleg cu tine- striga soacra. Macar de nu te-as mai vedea niciodata!\n" +
                    "- Vezi, ca avem aceleasi gusturi? Si eu imi doresc exact acelasi lucru.");
        }
        if(numba == 7){
            glumecc.setText("Nevasta-mea m-a provocat aseara la o partida de tenis de masa.\n" +
                    "Bineinteles c-am batut-o.\n" +
                    ".\n" +
                    ".\n" +
                    "Si tot a castigat!");
        }
        if(numba ==8 ){
            glumecc.setText("S-a dovedit stiintific: trufele pot preveni ciroza, cancerul si obezitatea.\n" +
                    "Dacă cumperi un kilogram de trufe, nu mai ai bani de alcool, de tigari sau de mancare.");
        }
        if(numba ==9 ){
            glumecc.setText("La crasma. \n" +
                    "- Ce zici, Ioane, a fi acuma razboi? \n" +
                    "- Da cat ii ceasul? \n" +
                    "- Doua noaptea. \n" +
                    "- Atunci a fi. \n" +
                    "- Da de ce, ma? \n" +
                    "- Ca-i la noi soacra-mea.");
        }
        if(numba ==10 ){
            glumecc.setText("Noul magazin de bumeranguri anunță cu mândrie că toate produsele lor sunt returnabile.");
        }
        if(numba == 11){
            glumecc.setText("Dintii catre limba: \n" +
                    "- Daca te presam mai tare te putem taia!\n" +
                    "- O singura injuratura daca rostesc zburati toti.");
        }
        if(numba == 12){
            glumecc.setText("Sotul: Draga mea, ce avem astazi la masa? \n" +
                    "Sotia: Nimic.\n" +
                    "Sotul: Pai si ieri a fost „nimic”.\n" +
                    "Sotia: Dragule, am gatit pentru doua zile!!!");
        }
        if(numba ==13 ){
            glumecc.setText("- Ce-si pierde capul dimineata si il primeste inapoi seara ?\n" +
                    "- Perna !");
        }
        if(numba ==14 ){
            glumecc.setText("I-am oferit un buchet de flori de Nu-Mă-Uita.\n" +
                    "Ea mi-a dat un buchet de flori Dar-Tu-Cine-Naiba-Eşti?");
        }
        if(numba ==15 ){
            glumecc.setText("- Iubitule am o veste buna si una proasta , sa stii ca vreau sa ne despartim ! \n" +
                    "\n" +
                    "- Ok , si aia proasta ?");
        }
        if(numba == 16){
            glumecc.setText("- Ba Ioane am auzit ca azi vor fi 42 de grade la umbra !\n" +
                    "- Si ce ? Crezi ca is prost sa stau la umbra ?");
        }
        if(numba == 17){
            glumecc.setText("DNA nu redeacteaza subiecte de BAC pentru ca in final nu s-ar lasa cu diploma ci cu mandat");
        }
        if(numba == 18){
            glumecc.setText("Invatatoarea si clasa la gara: \n" +
                    "- Copii, ne urcam unde scrie \"clasa a 2-a\", chiar daca noi suntem a patra!\"");
        }
        if(numba == 19){
            glumecc.setText("Tot mai mulți români returnează cardurile de sănătate la Minister pentru că nu au niciun ban pe ele.");
        }
        if(numba ==20 ){
            glumecc.setText("- Domnule redacor, ati citit nuvela mea, pe care v-am trimis-o prin posta?\n" +
                    "- Da, am citit-o. Am citit-o cu mult inainte de nasterea ta.");
        }
        if(numba ==21 ){
            glumecc.setText("- Ce zice un vampir cand este eclipsa de soare?\n" +
                    "??\n" +
                    "- \"In sfarsit, mananc de pranz!\"");
        }
        if(numba ==22 ){
            glumecc.setText("Musafirii, la iesirea din restaurant: \n" +
                    "- Pacat ca nu am ajuns la dv. mai curand!\n" +
                    "- Ne bucuram ca v-a placut!\n" +
                    "- Nu ne-a placut deloc- dar daca ajungeam mai repede, poate ca era carnea proaspata inca...");
        }
        if(numba ==23 ){
            glumecc.setText("Ala e comerciant , care vinde nisip in Sahara si gheata in Antartica !!!!!");
        }
        if(numba == 24){
            glumecc.setText("Propunere șocantă ANAF: cerșetorii vor fi obligați să emită bon fiscal pentru banii primiți.");
        }
        if(numba ==25 ){
            glumecc.setText("- Acum citesc o carte manageriala , economic financiara...\n" +
                    "- Si cum se numeste?\n" +
                    "- Punguta cu 3 iezi.\n");
        }
        if(numba ==26 ){
            glumecc.setText("Doi liceeni: \n" +
                    "- Exista o femeie care ma zapaceste, ma lasa fara cuvinte , pur si simplu cand sunt in fata ei nu stiu ce sa spun ...\n" +
                    "- Cine ? \n" +
                    "- Profa de franceza .");
        }
        if(numba ==27 ){
            glumecc.setText("- De ce dai gainilor sa bea cacao?, intreaba contrariata, bunica.\n" +
                    "- Cum altfel sa faca oua de ciocolata?!?");
        }
        if(numba == 28){
            glumecc.setText("Discurs motivational pentru o armată de vegetarieni: \"La luptă oștenii mei, sunt câtă frunză, câtă iarbă!\"");
        }
        if(numba == 29){
            glumecc.setText("I: Daca astazi e UNU MAI, maine ce e?\n" +
                    "R: Maine e unu si mai...!");
        }
        if(numba == 30){
            glumecc.setText("Cercetătorii români au descoperit că, dacă îți întorci chiloții pe dos, se creează o situație în care, de fapt, tot Universul poartă chiloții tăi... în afară de tine.");
        }
        if(numba ==31 ){
            glumecc.setText("- Ionele de ce pleci la scoala fara sa bei ceai ?\n" +
                    "- Am baut fa , ce-ai ? Dar n-am baut ceai , ce-ai ? Ca mie nu-mi place ceai!");
        }
        if(numba == 32){
            glumecc.setText("- Gigel sa stii ca vine vara !\n" +
                    "- Cum asa ca deabia e toamna. Poate vine iarna vrei sa spui ?\n" +
                    "- Nu , vine vara ta de la tara !");
        }
        if(numba ==33 ){
            glumecc.setText("Judecatorul: \n" +
                    "- Iarasi dumneata aici? Am crezut ca ti-a folosit sederea la inchisoare...\n" +
                    "- Sigur ca mi-a folosit: de aceea am mai vrut una.");
        }
        if(numba == 34){
            glumecc.setText("-Mai Georgica , am impresia ca de cand cu Facebook-ul asta parca s-a alterat comunicarea dintre oameni.\n" +
                    "- Like !");
        }
        if(numba == 35){
            glumecc.setText("- Mama maine nu merg la scoala !\n" +
                    "- Pai cum Gigele ? De ce ? Esti bolnav ?\n" +
                    "- Nu . Maine e duminica !");
        }
        if(numba == 36){
            glumecc.setText("Când Chuck Norris a plecat de acasă i-a spus tatălui său : \"Tu ești bărbatul casei de acum încolo\".");
        }
        if(numba ==37 ){
            glumecc.setText("Toti barbatii sunt porci! Corect, Pentru ca femininul speciei se numeste scroafa");
        }
        if(numba ==38 ){
            glumecc.setText("-hai sa mergem la teatru\n" +
                    "- ce sa facem acolo ?\n" +
                    "- sa ne uitam la un film");
        }
        if(numba == 39){
            glumecc.setText("- Maine incep scoala !\n" +
                    "- Acum la 50 de ani ? Nu e cam tarziu ?\n" +
                    "- Nu mai . Incep sa o zugravesc.");
        }
        if(numba == 40){
            glumecc.setText("Atunci când ai de studiat, pereții devin deodată foarte interesanți. De aceea mulți își aleg o carieră în construcții.");
        }
        if(numba ==41 ){
            glumecc.setText("Femeile din Vaslui dezamagite de flmul Fifty Shades of Grey : \" Barbatii nostri ne bat mult mai bine \"");
        }
        if(numba ==42 ){
            glumecc.setText("-Hei , tinere ! Nu ai voie sa intri in pielea goala in piscina ! \n" +
                    "- Dar nu imi place sa fac pipi in chiloti !");
        }
        if(numba == 43){
            glumecc.setText("Unui tanar i s-a injumatatit IQ-ul dupa ce s-a uitat la Romanii Au Talent pana la capat .");
        }
        if(numba ==44 ){
            glumecc.setText("Cât rezist în pat?\n" +
                    "Depinde... dacă nu pun alarma... uneori şi până la prânz");
        }
        if(numba ==45 ){
            glumecc.setText("Premiera medicala ! Un taximetrist si-a implantat un claxon in palma pentru a-l folosi si ca pieton .");
        }
        if(numba ==46 ){
            glumecc.setText("SUA si-a dotat armata cu rachete inteligente, care zboara pana la rusi, ii dojenesc si se intorc inapoi.");
        }
        if(numba == 47){
            glumecc.setText("Un tanar din Caracal a sunat la 112 dupa ce s-a ratacit pe internet .");
        }
        if(numba == 48){
            glumecc.setText("Premieră medicală: Un tomograf super performant va putea scana creierul minuscul al cocalarilor!");
        }
        if(numba ==49 ){
            glumecc.setText("Ziua Internationala a Femeii a fost anulata!\n" +
                    "Motivul a fost... pentru ca.");
        }
        if(numba == 50){
            glumecc.setText("Ingrijitorul se uita foarte atent in gura crocodilului.\n" +
                    "- Ce are? intreaba un vizitator?\n" +
                    "- Inca nu stiu. Medicul veterinar n-a mai iesit de acolo, de vreo jumatate de ora...");
        }
        if(numba == 51 ){
            glumecc.setText("Când un obicei incepe sa coste bani este numit un hobby.");
        }
        if(numba ==52 ){
            glumecc.setText("Am vazut recent pe Net o manea al carui titlu m-a amuzat: \"Florin Salam- Am sa scriu intr-o carte\"!!");
        }
        if(numba == 53){
            glumecc.setText("Nu inteleg agentiile astea de caritate... Cheltuie milioane de euro in campania de publicitate, pentru a strange cate 2 euro amarati de ici, de colo");
        }
        if(numba == 54){
            glumecc.setText("Astazi am fost la un interviu pentru angajare.\n" +
                    "- Pe C. V.-ul tau vad ca scrie ca esti un om misterios... imi zise intervievatorul. Ce vrei sa spui cu asta, mai exact?\n" +
                    "- Eee...!");
        }
        if(numba == 55){
            glumecc.setText(" Ce faci când doctorul îţi interzice să te apropii de\n" +
                    "vodcă?\n" +
                    "– O beau de la distanţă… cu paiul.");
        }
        if(numba == 56){
            glumecc.setText("Ieri am vazut un OZN.\n" +
                    "Asa ca am luat repede cea mai proasta camera pe care o am ca sa-l filmez.");
        }
        if(numba == 57){
            glumecc.setText("Legea respiratiei: Inainte ma inspirai, acuma... te-ai expirat!");
        }
        if(numba == 58){
            glumecc.setText("- Nu mai poti sa ai incredere in posta...\n" +
                    "- Cum asa?\n" +
                    "- Pai barbatu-meu e plecat la tratament la Olanesti, dar scrisoarea de la el are stampila de la Paris!.");
        }
        if(numba == 59){
            glumecc.setText("Nu ca ma laud, dar am rezolvat cubul Rubik cu picioarele!...\n" +
                    "\n" +
                    "I-am tras un sut de a aterizat in galeata cu vopsea.");
        }
        if(numba ==60 ){
            glumecc.setText("In preajma alegerilor, un ziarist intevieveaza un om al strazii: \n" +
                    "- Pentru un trai decent, ce asteptati de la viitoarea guvernare?\n" +
                    "- Mai multe pubele.");
        }
        if(numba == 61){
            glumecc.setText("Stiu pe unul care e atat de zgarcit ca si mancarea si-o cumpara de la second-hand !");
        }
        if(numba == 62){
            glumecc.setText("Scrisoarea unui copil de mafiot catre Mos Craciun lasata pe noptiera tatalui: \"Draga Mosule, daca nu-mi aduci anul asta un Ferrari, tata o sa te-mpuste, iar daca totusi nu te-mpusca , o sa va-mpusc eu pe amandoi!");
        }
        if(numba ==63 ){
            glumecc.setText("WiFi-ul telefonului mobil a căzut în timp ce scriam ceva pe Facebook. Mi-am dat seama imediat că vecinul nu şi-a plătit factura la Net. Ce nemernc!!");
        }
        if(numba == 64){
            glumecc.setText("Zilele trecute am fost la un interviu pentru un job la o companie multinationala.\n" +
                    "- Unde te vezi peste cinci ani?\n" +
                    "- Asculta amice, imi zise tipul din fata mea, tolanit intr-un fotoliu, eu sunt cel care pune intrebarile aici!!!");
        }
        if(numba == 65){
            glumecc.setText("Acum cateva seri sor-mea a fost cu doi barbati. Dupa, saraca de ea, abia mai putea sa mearga. Pai va dati seama, doua cine la restaurant una dupa alta?!?");
        }
        if(numba == 66){
            glumecc.setText("FIUL: Tata , ce inseamna idiot?\n" +
                    "\n" +
                    "TATA: Un prost care nu stie sa explice ideile cum nimeni nu le intelege.\n" +
                    "\n" +
                    "Ai inteles?\n" +
                    "\n" +
                    "FIUL: Nu.");
        }
        if(numba == 67){
            glumecc.setText("Daca simti un gol imens in stomac.. mananca, este posibil sa fie doar foamea!");
        }
        if(numba ==68 ){
            glumecc.setText("O femeie din Rusia s-a sinucis la 105 ani! \"Asemenea cazuri nu s-ar intampla daca moartea si-ar face treaba\", a declarat un politist rus.");
        }
        if(numba == 69){
            glumecc.setText("- Noaptea de revelion imi lasa amintiri de neșters, spuse el visator, tolanit pe canapea.\n" +
                    "- Si mie de șters, spuse ea ștergand de zor la o farfurie.");
        }
        if(numba == 70){
            glumecc.setText("În ziua de azi copiii se nasc mai inteligenţi , pentru că în cele nouă luni mamele lor încă mai merg la școală");
        }
        if(numba == 71){
            glumecc.setText("I; Cum se numeste un negru care piloteaza un avion?\n" +
                    "R: - Pilot! ");
        }
        if(numba == 72){
            glumecc.setText("Am o nelamurire in legatura cu mancarea vegetariana.\n" +
                    "Este adevarat ca buruienile fac oamenii mai intelepti?");
        }
        if(numba == 73){
            glumecc.setText("Puiul: Tata, mama face o ciorbă oribilă.\n" +
                    "Cocoșul: Ai răbdare. E încă tânără.");
        }
        if(numba == 74){
            glumecc.setText("Romania, tara in care daca o vanzatoare iti recomanda sa cumperi ceva e clar ca e vechi .");
        }
        if(numba == 75){
            glumecc.setText("oi prieteni, la un pahar.\n" +
                    "- Noi am fost acasa trei frati, dintre care doi destepti foc si unul foarte greu de cap.\n" +
                    "- I-auzi, eu nu i-am cunoscut pe celalti doi.");
        }
        if(numba == 76){
            glumecc.setText("Daca parintii tai nu reactioneaza cand le povestesti disperat ca toti copiii din cartier te injura de mama si de tata, e clar: Ai fost adoptat.");
        }
        if(numba ==77 ){
            glumecc.setText("- Draga, nu te supara, dar sotul tau e cumva coșar?\n" +
                    "- Nu, de ce?\n" +
                    "- Tot timpul il vad afumat.");
        }
        if(numba ==78 ){
            glumecc.setText("Mi-a sosit cardul de sănătate, unde găsesc şi eu un ATM cu sănătate?");
        }
        if(numba == 79){
            glumecc.setText("Cica noi romanii suntem experti in tranzitiile de orice fel, asa ca noi o sa avem o perioada de tranzitie de la Leu la Euro si o sa folosim moneda Leuro.");
        }
        if(numba == 80){
            glumecc.setText("- De ce nu-ti vezi de treaba mai baiatule? De ce nu muncesti?\n" +
                    "- Pentru ca pentru mine, munca este o placere.... Si eu n-am timp de placeri.");
        }
        if(numba ==81 ){
            glumecc.setText("- De ce nu poti sa te joci v-ati ascunselea cu soacra?\n" +
                    "- Ca nimeni nu vrea sa mai fie gasita!");
        }
        if(numba == 82){
            glumecc.setText("Pentru femeile care spuneti ca toti barbatii sunt la fel cine v-a pus sa-i incercati pe toti??");
        }
        if(numba == 83){
            glumecc.setText("Doua mame stau de vorba despre viitorul copiilor lor.\n" +
                    "- Al meu va fi avocat, spune una. \n" +
                    "- De ce crezi asta?\n" +
                    "- Tot timpul se baga in treburile altora, se cearta cu toti si se crede cel mai destept!");
        }
        if(numba ==84 ){
            glumecc.setText("- Copii, dati exemplu de o planta care se schimba in functie de vreme... zise profesoara de biologie.\n" +
                    "- Busuioc! raspunse Gigel.");
        }
        if(numba == 85){
            glumecc.setText("- Anul asta, nu-l mai faci pe Moș Craciun la televiziune?\n" +
                    "- Nuuu, mi-au spus ca sunt prea batran.");
        }
        if(numba == 86){
            glumecc.setText("- Ce impertinent s-a uitat controlorul la tine, de parca nu ai fi platit....\n" +
                    "- Așa e. Dar n-ai vazut cum m-am uitat eu fix in ochii lui, ca si cum aș fi platit?");
        }
        if(numba == 87){
            glumecc.setText("Ion si Vasile stau de vorba. La un moment dat Ion spune: \n" +
                    "- Eu m-am saturat de viata asta, toata ziua stam doar pe Facebook. Am si eu o viata pana la urma.\n" +
                    "La care Vasile zice: \n" +
                    "- Si nu mi-o trimiti mie pe Candy Crush?");
        }
        if(numba == 88){
            glumecc.setText("Ionel isi face tema la gramatica : \n" +
                    "- Mamicoooo ! \"Coadă\" este substantiv sau verb ?\n" +
                    "- Verb , dragă .... pentru că se mișcă !");
        }
        if(numba == 89){
            glumecc.setText("Dupa ultimele statistici, numarul oamenilor care se hulesc intre ei a crescut la 85%.\n" +
                    "Hooo, ca nu-i adevarat!!");
        }
        if(numba == 90){
            glumecc.setText("Azi i-am zis lui fiu-miu ca eu cand eram de varsta lui nu aveam internet : \n" +
                    "- Hai tată , lasă vraja ! Nici măcar pe telefonul mobil ?");
        }
        if(numba == 91){
            glumecc.setText("Cum pacalesti lumea ca esti superdotat? te tragi de nas toata ziua!");
        }
        if(numba == 92){
            glumecc.setText("-Izabela a afirmat ca de ziua ei si-ar dori drept cadou o masina a timpului.\n" +
                    "- De ce ?\n" +
                    "- Pentru ca acum a invatat sa foloseasca Facebook-ul !!");
        }
        if(numba == 93){
            glumecc.setText("PremieraDIVERSE- Ai fost la premiera piesei mele. Cum ti se pare? Nu-i asa ca are ceva nou si bun in ea?\n" +
                    "- Asa este, insa ceea ce-i bun nu e si nou, iar ceea ce-i nou, nu este si bun.");
        }
        if(numba == 94){
            glumecc.setText("-Tată , de ce iarna e mai frig ca vara ?\n" +
                    "- Există o explicație fiule : iarna temperatura e mai scăzută !");
        }
        if(numba == 95){
            glumecc.setText("Dacă aș fi primit câte un leu de fiecare dată când o fată m-a considerat neatragător, acum aș fi fost considerat atrăgător");
        }
        if(numba == 96){
            glumecc.setText("Clienta catre taximetrist: \n" +
                    "- Sunteti liber?\n" +
                    "- Nu, sunt insurat.");
        }
        if(numba == 97){
            glumecc.setText(" Ce-ai facut draga? ai ars friptura....\n" +
                    "- Iubitule, doctorul mi-a recomandat sa mai ard din calorii...");
        }
        if(numba == 98){
            glumecc.setText("Reporterul: \n" +
                    "- Domnule, ce obiceiuri traditionale aveti in aceasta zona, de anul nou?\n" +
                    "- Colica biliara, coma alcoolica, intoxicatia.....");
        }
        if(numba == 99){
            glumecc.setText("La scoala de muzică : \n" +
                    "- Domnule profesor , ce spuneti , are voce fetița noastră ?\n" +
                    "- Are ... eu stiu ce sa zic .... de ce nu o dati la balet ?");
        }
        if(numba == 100){
            glumecc.setText("Pamflet : \n" +
                    "\n" +
                    "\"Un urs şi-a pierdut toţi banii la păcănele. El acuză că a fost păcănit de vulpe. \"");
        }
        if(numba ==101 ){
            glumecc.setText("Anul nou arata ca nu gandim si nu ne comportam la fel: \n" +
                    "barbatii cu uratul, femeile cu urlatul.");
        }
        if(numba == 102){
            glumecc.setText("- Tata, am construit o chitara!\n" +
                    "- Bravo, fiule. Si de unde ai avut corzi?\n" +
                    "- Le-am luat de la pianul din sufragerie.");
        }
        if(numba ==103 ){
            glumecc.setText("Daca vrei sa decimezi Romania, nu ai nevoie de un atac frontal, e de ajuns sa opresti ambulantele si sectiile de urgente dupa Craciun.");
        }
        if(numba ==104 ){
            glumecc.setText("Ati vrut zapada ca-n povesti? Acum dezapeziti ca-n basme! ...");
        }
        if(numba == 105){
            glumecc.setText("Super tare! Se lansează Google Ulițe View , serviciul pentru explorarea cătunelor si satelor din România");
        }
        if(numba == 106){
            glumecc.setText("In 1492, Columb nu stia incotro mergea, era insotit de un echipaj razvratit si toti bani sai erau imprumutati. Astazi ar fi un candidat politic!");
        }
        if(numba ==107 ){
            glumecc.setText("De ce are Rudolf nasul roșu? \n" +
                    "Pentru că trece în fiecare an prin Vaslui.");
        }
        if(numba ==108 ){
            glumecc.setText("\" Tati , ce inseamna sarcasm ? \" ma intreaba fiul meu de 6 ani \n" +
                    "- Fiule sarcasmul este atunci cand mama ta imi zice ca am dreptate .");
        }
        if(numba == 109){
            glumecc.setText("Infractorul acuză dureri DIICOT");
        }
        if(numba ==110 ){
            glumecc.setText("- Va rog doua bilete.\n" +
                    "- Pentru Hobbit?\n" +
                    "- Nu, pentru mine si prietena mea.");
        }
        if(numba == 111){
            glumecc.setText("I: – Bula, de ce a creat Dumnezeu mai intii barbatul?\n" +
                    "R: – Ca macar odata in viata sa poata si el sa vorbeasca liber");
        }
        if(numba ==112 ){
            glumecc.setText("– Bulă, am auzit c-a murit soacră-ta, ce-a avut?\n" +
                    "– A trecut pe verde.\n" +
                    "– Adică a călcat-o cu mașina pe trecere?\n" +
                    "– Nu mă, era bolnavă de amigdalită și s-a săturat de albastru de metil, așa că a trecut pe verde de Paris!");
        }
        if(numba == 113){
            glumecc.setText("– Cum spun chinezii la scaieți?\n" +
                    "– Ciu lin.");
        }
        if(numba == 114){
            glumecc.setText("– De ce au mașinile mici luneta incalzită electric?\n" +
                    "– Să nu le îngheţe mâinile pasagerilor când o imping, iarna!");
        }
        if(numba == 115){
            glumecc.setText("– De ce la un banc se râde de trei ori?\n" +
                    "– Prima dată când il auzi, a doua oară când îl spui mai departe și a treia oară, când îl înțelegi.");
        }
        if(numba == 116){
            glumecc.setText("Întrebare la Radio Erevan:\n" +
                    "– De ce se țin leii în cușcă?\n" +
                    "– Pentru că dacă i-am ține în acvariu s-ar îneca.");
        }
        if(numba == 117){
            glumecc.setText("– Știți de ce caii au nările așa de mari?\n" +
                    "– Încercați să băgați copitele in nas!");
        }
        if(numba == 118){
            glumecc.setText("Întrebarea zilei: “Ce faci dacă vezi un omuleț verde?”\n" +
                    "60% au\tzis că se lasă de băut.\n" +
                    "30% se apucă de băut.\n" +
                    "9% merg la doctor.\n" +
                    "1% traversează.");
        }
        if(numba == 119){
            glumecc.setText("– Ştii când se ciocnesc două maşini?\n" +
                    "– Nu…\n" +
                    "– Când cei doi şoferi urmăresc acelaşi pieton.");
        }
        if(numba ==120 ){
            glumecc.setText("– De ce poartă medicii chirurgi din România mănuși?\n" +
                    "– Ca să nu lase urme!");
        }
        if(numba == 121){
            glumecc.setText("– Ce este scris pe ultima pagină a instrucțiunilor pentru autoturismul Dacia Logan?\n" +
                    "– Orarul autobuzelor.");
        }
        if(numba == 122){
            glumecc.setText("– Cine-i mai mulțumit, un bărbat care are cinci copii sau unul care are cinci milioane de dolari?\n" +
                    "– Cel cu cinci copii, pentru că el e cel care nu mai vrea încă unul!");
        }
        if(numba == 123){
            glumecc.setText("– Dintre doi polițiști care urinează, cine este cel care își proiectează jetul cel mai departe?\n" +
                    "– Cel care-și deschide șlițul!");
        }
        if(numba == 124) {
            glumecc.setText("– Ce primește un miner la moarte?\n" +
                    "– Trei zile libere, apoi înapoi in pământ.");
        }
        if(numba == 125){
            glumecc.setText("– Ce are un om care a fost mușcat de două ori de un câine?\n" +
                    "– O remușcare");
        }
        if(numba == 126){
            glumecc.setText("– Care e diferența dintre o nuntă rusească și o înmormântare rusească?\n" +
                    "– La înmormântare, e cu un bețiv mai puțin.");
        }
        if(numba == 127){
            glumecc.setText("– De ce poartă polițiștii apă în portbagaj!?\n" +
                    "– Ca să nu le moară sirena!");
        }
        if(numba ==128 ){
            glumecc.setText("– Gogoşile sunt sanatoase?\n" +
                    "– Păi n-am văzut până acum vreuna bolnavă!");
        }
        if(numba == 129){
            glumecc.setText("– Cu ce se duce Super Glue-ul de pe mâini?\n" +
                    "– Cu piele!");
        }
        if(numba == 130){
            glumecc.setText("– Care este primul lucru pe care îl faci când vezi că fasolea nu fierbe?\n" +
                    "– Aprinzi focul.");
        }
        if(numba ==131 ){
            glumecc.setText("– Cum definesc românii munca?\n" +
                    "– Pauza dintre țigări.");
        }
        if(numba == 132){
            glumecc.setText("– Cum se numeşte un ţigan care îşi dă aere?\n" +
                    "– Romgaz!");
        }
        if(numba == 133){
            glumecc.setText("– De ce în Sicilia nu se găsesc Martorii lui Jehova?\n" +
                    "– Pentru că sicilienilor nu le plac martorii.");
        }
        if(numba == 134){
            glumecc.setText("– De ce are un somalez un bob de orez lângă el?\n" +
                    "– A vomat toată noaptea.");
        }
        if(numba ==135 ){
            glumecc.setText("– Cum îţi dai seama că este frig afară?\n" +
                    "– În loc să calci într-un rahat, te împiedici de el.");
        }
        if(numba ==136 ){
            glumecc.setText("– Ce face vaca când stă la soare?\n" +
                    "– Umbră.");
        }
        if(numba == 137){
            glumecc.setText("– De ce ambalajul prezervativului se desface aşa de greu?\n" +
                    "– Ca să mai ai timp să te răzgândeşti.");
        }
        if(numba == 138){
            glumecc.setText("– Ai nişte degete lungi şi frumoase, cânţi la pian?\n" +
                    "– Nu, spăl eprubete.");
        }
        if(numba == 139){
            glumecc.setText("– Ce face un cal într-un lan de canabis?\n" +
                    "– Paşte fericit!");
        }
        if(numba == 140){
            glumecc.setText("– Ce are un câine care miaună?\n" +
                    "– Tulburare de personalitate.");
        }
        if(numba == 141){
            glumecc.setText("– De câţi francezi ai nevoie pentru a apăra Parisul?\n" +
                    "– Cine ştie, ce credeţi, a încercat vreodată cineva?!");
        }
        if(numba == 142){
            glumecc.setText("– Cum se termină o piesă de teatru în Ferentari?\n" +
                    "– Până la urmă eroul se îndrăgosteşte de heroină.");
        }
        if(numba == 143){
            glumecc.setText("– De ce aruncă un poliţist ceasul pe geam?\n" +
                    "– Ca să vadă cum zboară timpul.");
        }
        if(numba == 144){
            glumecc.setText("– De nu mai primesc poliţiştii pantofi cu găurele?\n" +
                    "– Pentru că nu le ajungea şiretul!");
        }
        if(numba == 145){
            glumecc.setText("– Ce mănâncă un canibal când e la dietă?\n" +
                    "– Un pitic.");
        }
        if(numba == 146){
            glumecc.setText("– Cum ați devenit inginer pentru deviere râuri?\n" +
                    "– Am făcut două-trei cursuri.");
        }
        if(numba == 147){
            glumecc.setText("– De ce are girafa gâtul lung?\n" +
                    "– Pentru ca să ajungă la cap.");
        }
        if(numba == 148){
            glumecc.setText("– Se spune că blondele au cu un neuron în plus faţă de găini. Cu ce le ajută surplusul?\n" +
                    "– Să nu facă pe ele prin curte precum găinile.");
        }
        if(numba ==149 ){
            glumecc.setText("– Cum ţii o blondă ocupată toată ziua?\n" +
                    "– O pui să stea la colţ într-o cameră rotundă.");
        }
        if(numba == 150){
            glumecc.setText("– Ce sunt meridianele?\n" +
                    "– Meridianele: bretelele globului pământesc,… ca să nu-i cadă ecuatorul în vine.");
        }
        if(numba == 151){
            glumecc.setText("– Ce se întâmplă dacă Usain Bolt pierde autobuzul?\n" +
                    "– Îl aşteaptă la următoarea staţie.");
        }
        if(numba == 152){
            glumecc.setText("– Cum se cheamă atunci când îți merge totul bine?\n" +
                    "– Halucinații…");
        }
        if(numba == 153){
            glumecc.setText("– Ce parfum foloseşte Ştefan Hruşcă?\n" +
                    "– Eau du Ler.\n");
        }
        if(numba == 154){
            glumecc.setText("– De ce nu a participat aviaţia somaleză la Războiul din Golf?\n" +
                    "– Era bolnav pilotul.");
        }
        if(numba == 155){
            glumecc.setText("– Cum emigrează somalezii în America?\n" +
                    "– Prin fax!");
        }
        if(numba == 156){
            glumecc.setText("– Dacă joacă şah Bin Laden cu Bush, cine câştigă?\n" +
                    "– Bin Laden cu siguranţă, Bush nu mai are două turnuri");
        }
        if(numba == 157){
            glumecc.setText("– De ce vampirii nu se fac electricieni?\n" +
                    "– La naiba, cum să folosească şurubelniţa în cruce!");
        }
        if(numba == 158){
            glumecc.setText("– Ce fac cinci emo într-o cameră?\n" +
                    "– Patru dintre ei stau în câte un colţ şi fiecare se taie singur cu lama şi al cincelea stă în mijlocul camerei şi plânge că nu are şi el colţ.");
        }
        if(numba == 159){
            glumecc.setText("– Ce fel de salam mănâncă arabii?\n" +
                    "– Salam “Alecu”.");
        }
        if(numba == 160){
            glumecc.setText("– Poţi rezista dacă îţi dă Chuck Norris un pumn?\n" +
                    "– Da. Dacă este de seminţe.");
        }
        if(numba ==161 ){
            glumecc.setText("– Cum se cheamă oraşul San Francisco în Japoneză?\n" +
                    "– Francisco San!");
        }
        if(numba == 162){
            glumecc.setText("– De ce ai renunțat la ultimul loc de muncă?\n" +
                    "– Compania s-a relocat și nu mi s-a spus unde…");
        }
        if(numba == 163){
            glumecc.setText("– Bunicu-meu a ştiut dinainte data şi ora morţii lui.\n" +
                    "– Baliverne. Nimeni nu poate şti asta.\n" +
                    "– Ba el a ştiut fiindcă i-a spus judecătorul.");
        }
        if(numba == 164){
            glumecc.setText("Plasatorul intră îngrozit în biroul directorului de teatru:\n" +
                    "– Domnule director, un spectator a căzut de la balcon. Ce facem ?\n" +
                    "– Îl pui să plătească diferenţa de preţ!");
        }
        if(numba == 165){
            glumecc.setText("Bulă face poze pe malul lacului, când nevastă-sa îl strigă disperată:\n" +
                    "− Bulă! Repede, se îneacă mama!\n" +
                    "− Degeaba, nu mai am spațiu pe telefon.");
        }
        if(numba == 166){
            glumecc.setText("– Alo, urgențe, 112?\n" +
                    "– Da! Spuneți!\n" +
                    "– Soția mea gătea, și a căzut!\n" +
                    "– Și care e urgența?\n" +
                    "– Știi cât trebuie să las orezul ca să nu se lipească?");
        }
        if(numba == 167){
            glumecc.setText("Tipul care locuieşte în apartamentul de deasupra mea tocmai a reusit sa parcurga 100 de metri in 3.2 secunde.\n" +
                    "Fie-i ţărâna uşoară.");
        }
        if(numba == 168){
            glumecc.setText("S-a stins din viață proprietarul cinematografului orășenesc. Funeraliile vor avea loc mâine, la orele 10:20, 12:45, 15:30 și 18:45!");
        }
        if(numba == 169){
            glumecc.setText("– Mă iubește, nu mă iubește, mă iubește, nu mă iubește….\n" +
                    "– Doctore, lăsați-mi dinții în pace.");
        }
        if(numba == 170){
            glumecc.setText("Am fost implicat într-un accident nasol mai devreme dar am reuşit să ies dintre fiarele contorsionate cu un picior rupt. Nu sunt sigur al cui era, dar ştiţi cum e, dacă l-am găsit e al meu!");
        }
        if(numba == 171){
            glumecc.setText("Funeraliile soţiei unui bun prieten:\n" +
                    "– Trebuie să fie foarte greu să pierzi o soţie…\n" +
                    "– Aproape imposibil.");
        }
        if(numba == 172){
            glumecc.setText("Directorul unui cimitir sună la reprezentanţa unei firme de motociclete:\n" +
                    "– Câte motociclete aţi vândut în ultima săptămână?\n" +
                    "– Cinci bucăţi.\n" +
                    "– Aaa, înseamnă că unul încă se mai plimbă…");
        }
        if(numba == 173){
            glumecc.setText("Anunţ în cimitir: “Furatul florilor se permite numai de pe mormintele proprii!”");
        }
        if(numba == 174){
            glumecc.setText("Pe Titanic, vine căpitanul şi le spune călătorilor: – Am o veste bună şi una rea.\n" +
                    "Pasagerii: – Începe cu aia rea!\n" +
                    "Căpitanul:- În două minute o să ne lovim de un iceberg!\n" +
                    "Pasagerii:- Şi aia bună?\n" +
                    "Căpitanul: -Vom lua 11 OSCAR-uri pentru asta.");
        }
        if(numba == 175){
            glumecc.setText("O mătuşică rătăcită prin oraş îl întreabă pe un tip un pic cherchelit:\n" +
                    "– Ce trebuie să iau ca să ajung la cimitir?\n" +
                    "– Otravă, mătuşă…");
        }
        if(numba == 176){
            glumecc.setText("Nu atingeţi! Pericol de electrocutare!” trebuie să fie foarte interesant de citit în Braille.");
        }
        if(numba == 177 ){
            glumecc.setText("Omul rănit cărat pe o targă bâguie către infirmieri:\n" +
                    "– Unde mă duceţi ?\n" +
                    "– La morgă..\n" +
                    "– Dar, încă n-am murit.\n" +
                    "– Păi, încă n-am ajuns");
        }
        if(numba == 178){
            glumecc.setText("– Poţi citi numărul de înmatriculare al maşinii aceleia de aici? mă întreba instructorul meu.\n" +
                    "– Da! normal! i-am răspuns. Acum te rog, deschide paraşuta aia odată!");
        }
        if(numba == 179){
            glumecc.setText("– Cum, ţi-a fost un prieten atât de bun şi nu te duci la înmormântarea lui?\n" +
                    "– Dar ce, el o să vină la a mea?!");
        }
        if(numba == 180){
            glumecc.setText("Alinuţa îşi scrie ultimele dorinţe:\n" +
                    "– Înainte să mor, vreau să înghit o pungă de boabe de porumb. Să vezi apoi distracţie la crematoriu.");
        }
        if(numba == 181){
            glumecc.setText("Mergea un psihopat prin pădure şi târa o fetiţă după el. La un moment dat fetiţa spune:\n" +
                    "– Mi-e frică!…\n" +
                    "La care psihopatu‘ :\n" +
                    "– Dar eu, că o să mă întorc singur!");
        }
        if(numba == 182){
            glumecc.setText("– Cum se cheamă un câine surd?\n" +
                    "– Cum vrei tu, că oricum l-ai striga, nu te aude !");
        }
        if(numba == 183){
            glumecc.setText("– De ce ţi-a murit câinele?\n" +
                    "– De foame, săracul.\n" +
                    "– Păi cum aşa, cu nevastă aşa dolofană?\n" +
                    "– Cât am fost în Spania, nevastă-mea l-a hrănit întotdeauna cu resturile de mâncare rămase de la ea.");
        }
        if(numba ==184 ){
            glumecc.setText("Pilotul unui avion către turnul de control:\n" +
                    "– Mi s-a terminat combustibilul, cred că o să cad.\n" +
                    "Turnul:\n" +
                    "– Ok, mulţumesc, te ştergem din listă.");
        }
        if(numba ==185 ){
            glumecc.setText("În Vaslui de Sfântul Valentin se oferă buchete de toporaşi.");
        }
        if(numba == 186){
            glumecc.setText("Dupa ce a vorbit cu Poliţia la telefon, nevastă-mea a început să plângă şi mi-a spus:\n" +
                    "– Tocmai am aflat că mama a murit într-un accident de maşină… Nici nu-mi pot imagina prin ce a trecut, săraca!\n" +
                    "– Probabil prin parbriz…");
        }
        if(numba == 187){
            glumecc.setText("Era odată un tip atât de leneş, că atunci când a murit, prietenii săi i-au pus următoarea inscripţie pe mormânt: “Aici continuă să se odihnească…”");
        }
        if(numba == 188){
            glumecc.setText("În timp ce călăul pregătea toporul, îl intreb:\n" +
                    "– Era vorba că voi fi spânzurat. Acum îmi tăiați capul?!\n" +
                    "– Nu, picioarele. Este funia prea lungă!");
        }
        if(numba ==189 ){
            glumecc.setText("– Care e partea bună a schizofreniei?\n" +
                    "– Că niciodată nu eşti singur.");
        }
        if(numba == 190){
            glumecc.setText("Vreau să mor liniştit în timp ce dorm, la fel ca văr-meu Andreas şi nu ţipând de groază… ca pasagerii lui!");
        }
        if(numba == 191){
            glumecc.setText("– Unde găseşti un câine fără picioare?\n" +
                    "– Acolo unde l-ai lăsat.");
        }
        if(numba == 192){
            glumecc.setText("– Cum se numeşte înmormântarea unui electrician?\n" +
                    "– Împământare.");
        }
        if(numba == 193){
            glumecc.setText("Un tânăr ziarist îi ia un interviu unui călău:\n" +
                    "– Domnule, nu vă este greu… cu meseria aceasta?\n" +
                    "– Ce vreţi, toată lumea trebuie să trăiască…");
        }
        if(numba == 194){
            glumecc.setText("Ştirea zilei: accident aviatic în Caracal. Un avion utilitar s-a prăbuşit deasupra unui cimitir. Poliţia locală a descoperit peste o mie de morţi.");
        }
        if(numba == 195){
            glumecc.setText("Un condamnat la moarte întreabă în timp ce era dus spre execuţie:\n" +
                    "– Cum funcţionează scaunul electric?\n" +
                    "– Vei fi pus imediat la curent.");
        }
        if(numba == 196){
            glumecc.setText("Mai devreme mă spălam pe mâini în toaletă la bărbați și mă gândeam:\n" +
                    "”De ce naiba nu mă spăl eu în chiuvetă?”");
        }
        if(numba ==197 ){
            glumecc.setText("– De ce înmormântările se plătesc în valută?\n" +
                    "– Pentru că se consideră plecări definitive din ţară.");
        }
        if(numba == 198){
            glumecc.setText("Pe o corabie ce se scufunda, unul din pasageri îl întreabă pe căpitan:\n" +
                    "– Suntem departe de pământ?\n" +
                    "– Nu-i departe, un kilometru.\n" +
                    "– Dar în ce direcţie?\n" +
                    "– În jos…");
        }
        if(numba ==199 ){
            glumecc.setText("Am citit că puiul poate să stea și trei zile în frigider fără să se strice.\n" +
                    "Am încercat, a murit după două minute.");
        }
        if(numba == 200){
            glumecc.setText("Un condamnat este dus la spânzurătoare. La un moment dat acesta întreabă călăul:\n" +
                    "– Ce zi este astăzi?\n" +
                    "Călăul:\n" +
                    "– Luni.\n" +
                    "Condamnatul:\n" +
                    "– Să-mi bag piciorul, ce început de săptămână…");
        }
        if(numba == 201){
            glumecc.setText("Am făcut un puşti de 5 ani să plângă.\n" +
                    "L-am pus să numere din 2 în 2 până la 7.");
        }
        if(numba == 202){
            glumecc.setText("Oare ce făceau părinții noștri acu’ 30 de ani, când nu exista internet, ca să nu se plictisească?\n" +
                    "I-am întrebat pe cei unsprezece frați ai mei și niciunul n-a știut…");
        }
        if(numba ==203 ){
            glumecc.setText("Nu folosesc semnalizarea că nu trebuie să ştie toată lumea încotro mă duc eu.");
        }
        if(numba == 204){
            glumecc.setText("Slogan pentru o spălătorie auto: “Frumuseţea vine din interior exterior”.");
        }
        if(numba ==205 ){
            glumecc.setText("Nepotul Patriarhului Daniel a fost reţinut pentru trafic de heroină.\n" +
                    "El s-a apărat spunând că doar ajută oamenii să se simtă dumnezeieşte.");
        }
        if(numba ==206 ){
            glumecc.setText("Am auzit imnul României într-un magazin chinezesc. Mi s-a făcut pielea imitație de piele de găină.");
        }
        if(numba == 207){
            glumecc.setText("Azi am găsit un portofel cu 500 de lei. Ca un bun creștin ce sunt, m-am gândit: “ce-ar face Isus în locul meu?”…și-atunci i-am transformat în vin.");
        }
        if(numba == 208){
            glumecc.setText("\n" +
                    "Sunt praf. În două ore am băut 3 sticle de vodcă. Cred că plec cu ambulanța… Dar nu vă faceți griji, nu e prima dată când conduc beat.");
        }
        if(numba == 209){
            glumecc.setText("Am fost la Disneyland pentru că băiatul meu adoră desenele cu Mickey Mouse. A fost foarte bucuros când am venit acasă și i-am povestit cum a fost ");
        }
        if(numba == 210){
            glumecc.setText("I-am cerut şefului un avans. Mi-a spus că sunt drăguţ şi că ar vrea să mă scoată la cină într-o seară.");
        }
        if(numba == 211){
            glumecc.setText("Am citit undeva că urșii panda sunt pe cale de dispariție încă din 1984. Ce rahat, cel mai încet truc de magie pe care l-am văzut");
        }
        if(numba == 212){
            glumecc.setText("Când un prieten gay îți cere ajutorul, nu-i întoarce niciodată spatele.");
        }
        if(numba == 213){
            glumecc.setText("Nu că vreau să mă dau important dar când am fost adineauri la supermarket ușile s-au deschis și s-au închis singure…");
        }
        if(numba == 214){
            glumecc.setText("Durata unui minut variază în funcţie de care parte a uşii de la baie te afli…");
        }
        if(numba ==215 ){
            glumecc.setText("– Domnule doctor, dați-mi vă rog o pastilă împotriva lăcomiei, dar să fie mai mare!");
        }
        if(numba == 216){
            glumecc.setText("Doi funcționari se întâlnesc pe hol, pe la ora 11:\n" +
                    "– Și dumneata ai insomnie?");
        }
        if(numba == 217){
            glumecc.setText("Sunt atât de sărac încât când mi-am plătit întreținerea la timp, a doua zi mi-a bătut poliţia la uşă să mă întrebe de unde am banii.");
        }
        if(numba ==218 ){
            glumecc.setText("Am aflat că vecinul care pune manele la ora trei dimineaţa are câine.\n" +
                    "Acum, la ora patru, pun eu ultrasunete.");
        }
        if(numba ==219 ){
            glumecc.setText("– Cum îi scoală Alba ca Zăpada pe cei șapte pitici?\n" +
                    "– Seven up.");
        }
        if(numba == 220){
            glumecc.setText("Ştii că eşti bogat dacă mergi să scoţi bani de la bancă iar casiera te întreabă: “Doriţi sacoşă?”");
        }
        if(numba ==221 ){
            glumecc.setText("Ieri, în autobuz, am cedat locul meu unui bătrânel orb.\n" +
                    "Azi, am fost concediat din funcția de șofer RATB…");
        }
        if(numba == 222){
            glumecc.setText("Am văzut un afiș astăzi, care m-a făcut să mă scap pe mine! Scria “toalete închise”.");
        }
        if(numba == 223){
            glumecc.setText("Până acum eram sărac dar mi-am cumpărat un dicționar de sinonime și acum sunt nevoiaș, sărman, oropsit și necăjit…");
        }
        if(numba == 224){
            glumecc.setText("Am ieșit mai devreme din cinematograf și toată lumea zicea:\n" +
                    "– Film pentru proști, film pentru proști…\n" +
                    "Aiurea, nu știu ce vorbesc, mie mi-a plăcut!");
        }
        if(numba == 225){
            glumecc.setText("– Daţi-mi, vă rog, de zece lei cireşe!\n" +
                    "– O doriţi feliată sau v-o împachetez direct?");
        }
        if(numba == 226){
            glumecc.setText("Proverb din Vaslui: “bărbații sunt ca pantofii, dacă nu îi iei cum trebuie, te bat”.");
        }
        if(numba ==227 ){
            glumecc.setText("Dacă aveţi de gând să mergeţi în cazino, îmbrăcaţi cei mai frumoşi chiloţi. S-ar putea să vă întoarceţi acasă numai în ei!");
        }
        if(numba == 228){
            glumecc.setText("– Cucuriguuu, cântă găina.\n" +
                    "Uimit, cocoșul făcu un ou.");
        }
        if(numba ==229 ){
            glumecc.setText("Am văzut la televizor că vremea va fi închisă. Totuși cred că de data asta DNA-ul a exagerat.");
        }
        if(numba == 230){
            glumecc.setText("Nu pot să dorm liniștit atunci când știu că mâncării îi e frig în frigider…");
        }
        if(numba == 231){
            glumecc.setText("Un avion face o rotire neașteptată și zboară cu ”trenul de aterizare în sus”.\n" +
                    "Stewardesa:\n" +
                    "– Dragi pasageri, vă rog să vă păstrați calmul. Pilotul își toarnă niște picături în nas, după care vom reveni la zborul obișnuit.");
        }
        if(numba == 232){
            glumecc.setText("O vecină voia să se facă dansatoare de tango, dar a dat-o în bară.");
        }
        if(numba == 233){
            glumecc.setText("Maxima zilei:\n" +
                    "23:59:59");
        }
        if(numba ==234 ){
            glumecc.setText("Comandă la bar în club:\n" +
                    "– Două cuburi de gheață, vă rog. Și un pic de whisky, să nu le beau goale…");
        }
        if(numba == 235){
            glumecc.setText("Prea multe dulcegării în jur, trebuie să-mi iau doza de insultină");
        }
        if(numba ==236 ){
            glumecc.setText("Când eram mic, eram aşa obraznic încât, până la vârsta de cinci ani, am crezut că numele meu este “Doamne Dumnezeule!”");
        }
        if(numba ==237 ){
            glumecc.setText("Frizerul il intreaba pe client : \n" +
                    "- Cum sa va tund ca sa fiti multumit ? \n" +
                    "- Gratis !");
        }
        if(numba == 238){
            glumecc.setText("Asa pisica tii cainele ocupat peste 20 soareci de lup secunde canar un arici idiot. Acum citeste fara animale!");
        }
        if(numba == 239){
            glumecc.setText("Mă tem că într-o zi o să rămân fără inspiraţie şi o să mă sufoc.");
        }
        if(numba == 240){
            glumecc.setText("– Ce înseamnă codul de bare de pe un produs la somalezi?\n" +
                    "– Poza cu angajaţii fabricii.");
        }
        if(numba == 241){
            glumecc.setText("– Cine a fost primul om pe Lună?\n" +
                    "– Un somalez care s-a jucat cu elasticul de la chiloţi.");
        }
        if(numba == 242){
            glumecc.setText("\n" +
                    "Î:De ce umbla un somalez cu capul într-o parte pe strada?\n" +
                    "R:Are o masea plombata.");
        }
        if(numba == 243){
            glumecc.setText("Î:De ce cade un somalez din copac ca o sageata?\n" +
                    "R:Are maselele plombate.");
        }
        if(numba == 244){
            glumecc.setText("Î:Cum cade un somalez din copac?\n" +
                    "R:Ca o frunza.");
        }
        if(numba == 245){
            glumecc.setText("\n" +
                    "Î:Cum deosebesti un somalez de o minge de tenis de câmp?\n" +
                    "R:Mingea cântareste 200 de grame mai mult.");
        }
        if(numba == 246){
            glumecc.setText("Î:Ce e un somalez cu piciorul în ghips?\n" +
                    "R:Crosa de hochei.");
        }
        if(numba ==247 ){
            glumecc.setText("Î:Cum se numeste un somalez cu strungareata?\n" +
                    "R:Grebla…");
        }
        if(numba ==248 ){
            glumecc.setText("Î:Ce sunt doi somalezi în sacul de dormit:\n" +
                    "R:Twix!");
        }
        if(numba == 249){
            glumecc.setText("Î:Cum a cazut guvernul din Somalia?\n" +
                    "R:Au taiat copacul…");
        }
        if(numba == 250){
            glumecc.setText("Î:Câti somalezi încap într-un autobuz?\n" +
                    "R:Toti.");
        }
        if(numba == 251){
            glumecc.setText("Î:Ce folosesc somalezii, de preferinta, ca sac de dormit?\n" +
                    "R:Un pai.");
        }
        if(numba == 252){
            glumecc.setText("\n" +
                    "Î:Cum se saluta somalezii ?\n" +
                    "R:Ce vânt te aduce p’aici, frate ?");
        }
        if(numba == 253){
            glumecc.setText("\n" +
                    "O echipă de zugravi a primit sarcina să zugrăvească spitalul de nebuni. Unul dintre ei se duce la director şi-i spune:\n" +
                    "– Daţi-mi doi nebuni, mai puţin nebuni, ca să ne ţină scările.\n" +
                    "Primesc ajutoare şi apoi se pun la treabă. Când zugravii erau sus, unul dintre nebuni zice:\n" +
                    "– Ţine-te de bidinea, că eu iau scara să zugrăvesc!");
        }
        if(numba == 254){
            glumecc.setText("\n" +
                    "Doi nebuni planuiau sa fuga de la balamuc:\n" +
                    "– Daca zidul e scund, sarim, daca e inalt, sapam o groapa. Ai inteles?\n" +
                    "– Da.\n" +
                    "Trece ceva timp, se intoarce nebunul.\n" +
                    "– Nu putem scapa!\n" +
                    "– De ce?\n" +
                    "– Nu exista zid!");
        }
        if(numba == 255){
            glumecc.setText("- Doctore, soţul meu se crede avion.\n" +
                    "– Aduceţi-l mâine la mine.\n" +
                    "– Dar pistă de aterizare aveţi?");
        }
        if(numba == 256){
            glumecc.setText("Doi nebuni se întâlnesc în deşert. Unul avea o căciulă de blană pe cap, iar celălalt ţinea o portieră. Cel cu portiera îl întreabă pe cel cu căciula:\n" +
                    "– Se vede că eşti nebun! Ce faci cu căciula în deşert?\n" +
                    "– Băăăi, nebun eşti tu! Când mi-e cald, îmi scot căciula, dar tu ce faci cu portiera?\n" +
                    "– Eu deschid geamul!");
        }
        if(numba == 257){
            glumecc.setText("Doi nebuni mergeau prin pădure, bucurându-se de răcoarea pe care le-o oferă aceasta. La un moment dat, unul vede o puşcă. O ridică şi, mirat, îl întreabă pe celălalt:\n" +
                    "– Măi, ce-o fi asta?\n" +
                    "Şi se uită pe ţevi. Al doilea se apucă şi mângâie arma întrebându-se ce-o fi şi îi spune primului:\n" +
                    "– Uite, am găsit aici ceva şi se mişcă.\n" +
                    "Apasă pe trăgaci. Cel care se uita pe ţevi cade desfigurat, La care al doilea îl întreabă:\n" +
                    "– No’ amu’ de ce faci faţa asta, că şi eu m-am speriat.");
        }
        if(numba ==258 ){
            glumecc.setText("La un bijutier, soţia unui evreu probează o brăţară masivă din aur, apoi îşi întreabă soţul, dacă îi place. Soţul verifică preţul în catalog apoi îi spune:\n" +
                    "– Nu, dragă! Brăţara asta te îngraşă!");
        }
        if(numba == 259){
            glumecc.setText("\n" +
                    "Î:Care e diferenta dintre un evreu si o minge de baschet ?\n" +
                    "R:În minge nu se da cu piciorul.");
        }
        if(numba == 260){
            glumecc.setText("Evreu care şi-a pierdut braţul stâng, caut evreu care şi-a pierdut braţul drept, pentru a împărţi împreună costul unei perechi de manuşi.");
        }
        if(numba ==261 ){
            glumecc.setText("– De unde avea Ştefan cel Mare cizmele?\n" +
                    "– De la genunchi în jos.");
        }
        if(numba == 262){
            glumecc.setText("Cică Napoleon stătea pe cal, la Waterloo. La un moment dat, vede ceva în zare şi strigă:\n" +
                    "– Soldat, adu-mi luneta!\n" +
                    "La care soldatul:\n" +
                    "– Mon Dieu, vous parlez en Roumain!?");
        }
        if(numba == 263){
            glumecc.setText("Am descoperit punctul slab al lui Chuck Norris: Analiza matematică.\n" +
                    "El practic nu cunoaşte limitele.");
        }
        if(numba ==264 ){
            glumecc.setText("-Jon,cate grade sunt inauntru?\n" +
                    "-26,Sir\n" +
                    "-Si cate grade sunt afara?\n" +
                    "-6\n" +
                    "-deschide geamul sa intre si gradele de afara");
        }
        if(numba == 265){
            glumecc.setText("- John, unde e palaria mea?\n" +
                    "- O aveti pe cap, sir.\n" +
                    "- Bine, o gasesc eu mai tarziu.");
        }
        if(numba == 266){
            glumecc.setText("Sir si John erau naufargiati pe o insula. Dupa multe luni John vine la Sir tipand:\n" +
                    "- Sir, Sir, se vede un vapor la orizont!!!\n" +
                    "La care Sir ii spune cu un calm tipic englezesc:\n" +
                    "- Linisteste-te John, ce n-ai mai vazut vapoare?");
        }
        if(numba == 267){
            glumecc.setText("Intra un cowboy in salon si vede o femeie frumoasa. Nu stie cum sa intre\n" +
                    "in vorba cu ea. Scoate pistoalele si ii impusca pe toti, dupa care o intreaba: \n" +
                    "-Si ce faci tu aici...singurica?");
        }
        if(numba == 268){
            glumecc.setText("La un interviu:\n" +
                    "- Si acum, daca aveti cumva vreo intrebare despre firma noastra..\n" +
                    "- Pai... m-ar interesa sa stiu cam cati oameni lucreaza in firma\n" +
                    "dumneavoastra.\n" +
                    "- In general, cam un sfert...");
        }
        if(numba == 269){
            glumecc.setText("Un pitic intra intr-o farmacie si cere o aspirina. Farmacista il intreaba:\n" +
                    "- Sa v-o impachetez?\n" +
                    "- Nu, multumesc. O s-o rostogolesc...");
        }
        if(numba == 270){
            glumecc.setText("Usa se deschide brusc si baiatul intra in casa:\n" +
                    "-Buna ziua, tata!\n" +
                    "Tatal, fara sa-si ia ochii de la monitor:\n" +
                    "-Pe unde ai umblat?\n" +
                    "-Am fost in armata!");
        }
        if(numba == 271){
            glumecc.setText("Un tip irascibil la magazin:\n" +
                    "- Doamna, nervi aveti?\n" +
                    "- Nu!\n" +
                    "- Nu-i nimic, va fac eu...");
        }
        if(numba == 272){
            glumecc.setText("-Ce film se ruleaza in America ?\n" +
                    "- `Om sarac om bogat`.\n" +
                    "-Ce film se ruleaza in Rusia ?\n" +
                    "-`Om sarac, om sarac `.\n" +
                    "-Ce film se ruleaza in Romania ?\n" +
                    "- `Om` trai si om` vedea `.");
        }
        if(numba == 273){
            glumecc.setText("- Ce-ai vanat azi, Ioane?\n" +
                    "- Cativa pliznoti...\n" +
                    "- ?!?!\n" +
                    "- Cand indreptam arma spre ei strigau: `Pliz not! Pliz not!`");
        }
        if(numba == 274){
            glumecc.setText("- Care este momentul cel mai potrivit pentru culegerea fructelor?\n" +
                    "- Momentul in care lipseste paznicul.");
        }
        if(numba == 275){
            glumecc.setText("- Cati oameni lucreaza aici?\n" +
                    "- Cu seful, 10.\n" +
                    "- Dar fara sef?\n" +
                    "- Fara sef, in general, nu lucreaza nimeni.");
        }
        if(numba ==276 ){
            glumecc.setText("Unui om de stiinta renumit ii vin niste oaspeti in vizita. Cand intra in camera, ei observa ca deasupra patului omul nostru are o potcoava.\n" +
                    "- Cum se poate asa ceva? Doar nu sunteti superstitios?\n" +
                    "- Nicidecum, dar mi-a zis cineva ca ii ajuta si pe cei care nu cred in superstitii.");
        }
        if(numba ==277 ){
            glumecc.setText("Un copil plangea pe holul scolii. Invatatoarea il intreaba:\n" +
                    "- De ce plangi?\n" +
                    "- Un copil mi-a dat jos placinta!\n" +
                    "- Dar a fost cu intentie?\n" +
                    "- Nu, a fost cu branza.");
        }
        if(numba ==278 ){
            glumecc.setText("- Cand va incepe Foamea Mondiala?\n" +
                    "- Cand vor incepe chinezii sa manance cu lingura.");
        }
        if(numba == 279){
            glumecc.setText("- Chelner!\n" +
                    "- Da, domnule.\n" +
                    "- Te rog sa imi mai prajesti putin puiul... imi mananca toata salata!");
        }
        if(numba == 280){
            glumecc.setText("In tramvai:\n" +
                    "- E cineva fara bilet acolo, in fund?\n" +
                    "- Eu, dar mi-l bag imediat!");
        }
        if(numba ==281 ){
            glumecc.setText("În spatele unei porţi pe care scria `Câine rău`, se vede un căţel mic şi pufos. Un om trece pe langă poartă şi zice : \n" +
                    "- Cum de eşti tu, mă, câine rău?\n" +
                    "La care câinele:\n" +
                    "-Sunt rău ca nu pap tot laptele.");
        }
        if(numba == 282){
            glumecc.setText("-ioane...iti bate lantu\n" +
                    "-ce ma?\n" +
                    "-ioane iti bate lantu\n" +
                    "-ce ma?nu te-aud k-mi bate lantu");
        }
        if(numba == 283){
            glumecc.setText("Nu beau, nu fumez, ma scol la 6 in fiecare zi, ma culc la 10, nu-mi insel nevasta. \n" +
                    "Dar si cand oi iesi din puscarie...");
        }
        if(numba ==284 ){
            glumecc.setText("2 mosi stau pe o banca in parc si vb:\n" +
                    "1 mos: auzi ma, o vezi tu pe roscata aia buna de acolo?\n" +
                    "al 2-lea mos: da ma o vad...ce-i cu ea?\n" +
                    "1 mos: moare dupa mine! sunt sigur!\n" +
                    "al 2-lea mos: de unde stii ma?\n" +
                    "1 mos: pai doar nu o murii inaintea mea!");
        }
        if(numba ==285 ){
            glumecc.setText("Dupa ce loveste un pieton, o masina isi continua drumul inca vreo 10 metri...\n" +
                    "Soferul scoate capul pe fereastra si tipa:\n" +
                    "- Fii ba atent! \n" +
                    "Pietonul se ridica repede, speriat, impleticindu-se si intreaba:\n" +
                    "- De ce ba?, dai inapoi ?");
        }
        if(numba == 286){
            glumecc.setText("- Alo, buna ziua, Casa Poporului?\n" +
                    "- Da.\n" +
                    "- Cu poporul, va rog!");
        }
        if(numba ==287 ){
            glumecc.setText("Exista trei tipuri de oameni: unii care stiu sa numere si altii care nu stiu...");
        }
        if(numba == 288){
            glumecc.setText("Se intalnesc doi tipi in desert. Zice unu`:\n" +
                    "- Hei tu!\n" +
                    "- Cine, eu?...");
        }
        if(numba == 289){
            glumecc.setText("Stiti care e morala?\n" +
                    "Nu da cu piatra-n geam ca nu e bicicleta ta...");
        }
        if(numba == 290){
            glumecc.setText("Un marinar sta in portul Marsiliei si bea de nu se mai tine pe picioare. Un trecator intra in vorba:\n" +
                    "- Stiti ca anual mor peste 10 000 de francezi din cauza bauturii?\n" +
                    "- Nu ma intereseaza! Eu sunt rus...");
        }
        if(numba == 291){
            glumecc.setText("Cum se numeste un lepros in apa termala?\n" +
                    "Supa...");
        }
        if(numba == 292){
            glumecc.setText("Ce-i zice leprosul la magazin?\n" +
                    "Pastreaza restul...");
        }
        if(numba == 293){
            glumecc.setText("- Prin ce se deosebeste omul de masina?\n" +
                    "- Inca nu a fost inventata o masina care sa nu faca nimic...");
        }
        if(numba == 294){
            glumecc.setText("Culmea celor lenţi: Să li se strice mâncarea in timp ce o mănâncă.");
        }
        if(numba ==295 ){
            glumecc.setText("culmea rasului: sa gadili becul si sa rada electricianul");
        }
        if(numba ==296 ){
            glumecc.setText("Culmea suspansului: iti spun maine");
        }
        if(numba ==297 ){
            glumecc.setText("Culmea matematicii:sa pui tabla inmultiri pe acoperis.");
        }
        if(numba ==298 ){
            glumecc.setText("Culmea fotbalului:sa dai gol in penalti si sa ratezi in reluare.");
        }
        if(numba == 299){
            glumecc.setText("Culmea ceasului desteptator: sa sune ocupat…");
        }
        if(numba == 300){
            glumecc.setText("Cumea fizicii: sa pui un cal putere sa pasca pe un cîmp magnetic.");
        }
        if(numba == 301){
            glumecc.setText("Culmea zgîrceniei: în testament sa-ti lasi toata averea tie însuti.");
        }
        if(numba == 302){
            glumecc.setText("Culmea geneticii: sa împerechezi o capra de taiat lemne cu un tap de bere.");
        }
        if(numba == 303){
            glumecc.setText("Culmea cutremurului: sa urci cu liftul si sa cobori cu apartamentul.");
        }
        if(numba == 304){
            glumecc.setText("Culmea sarituri: Sa sari de pe un bloc de desesn si sa te prinzi cu dintii de bordura");
        }
        if(numba == 305){
            glumecc.setText("culmea culmii: ar fi si culmea so sti si pe asta");
        }
        if(numba ==306 ){
            glumecc.setText("culmea hotiei: sa furi curent cu galeata.");
        }
        if(numba == 307){
            glumecc.setText("DOi Vulturi stateau pe o craca al treilea statea sa cada");
        }
        if(numba == 308){
            glumecc.setText("I:Unde se gasesc maimutzele cu 3 \n" +
                    "ochi,multicolore si fara coada?\n" +
                    "R:La magazinul de maimutze cu 3 ochi,multicolore si fara coada..");
        }
        if(numba == 309){
            glumecc.setText("Doua baloane zburau si unul zice:\n" +
                    "-Ba,mai poti?\n" +
                    "Iar celalalt raspunde:\n" +
                    "-Mai poc.");
        }
        if(numba == 310){
            glumecc.setText("La miezul noptii, in lumina orbitoare a soarelui, se aud trei impuscaturi de cutit.Victima avea frunte lata si pantaloni de aceeasi culoare.");
        }
        if(numba == 311){
            glumecc.setText("Erau peo banca trei copii.pe unul il chema Rares pe altul andrei iar pe ultimul masa in casa.");
        }
        if(numba ==312 ){
            glumecc.setText("- Ce-i trece unei muste prin cap cand se loveste de parbrizul unei masini care merge cu 120 km la ora?\n" +
                    "- ????\n" +
                    "- Fundu`!");
        }
        if(numba ==313 ){
            glumecc.setText("- Tata ce este un travestit?\n" +
                    "- Intreaba pe mama, el stie...");
        }
        if(numba == 314){
            glumecc.setText("De cati psihologi e nevoie ca sa schimbe un bec?!\n" +
                    "- ?!?\n" +
                    "- De unul singur....cu conditia ca becul sa vrea!");
        }
        if(numba == 315){
            glumecc.setText("- Cum trece un american strada?\n" +
                    "- Se uita in stanga, in dreapta...in sus si apoi traverseaza.");
        }
        if(numba == 316){
            glumecc.setText("- Un om mergea pe cal si dintr-o data a cazut. De ce?\n" +
                    "- S-a terminat calul.");
        }
        if(numba == 317){
            glumecc.setText("-Ce i-a spus cafeaua zaharului?\n" +
                    "-Fara tine, viata mea ar fi amara.");
        }
        if(numba == 318){
            glumecc.setText("Merge un tip la o covrigarie:\n" +
                    "- Buna ziua!\n" +
                    "- Mdea (sictirita...)\n" +
                    "- Aveti covrigi mici si tari?\n" +
                    "- Mdea...\n" +
                    "- Si cine dreacu` vi-i cumpara?");
        }
        if(numba == 319){
            glumecc.setText("Jos pe fundul baltii\n" +
                    "Patru ochi vegheste,\n" +
                    "Ce sa este oare?\n" +
                    "Consider ca este doua peste");
        }
        if(numba == 320){
            glumecc.setText("Doi surzi se intalnesc pe strada:\n" +
                    "1: Te duci la pescuit?\n" +
                    "2: Nu. Ma duc la pescuit.\n" +
                    "1: A... Si eu care credeam ca te duci la pescuit.");
        }
        if(numba == 321){
            glumecc.setText("Era odata un pescar cam ghinionist. Un trecator cam curios il intreaba:\n" +
                    "- Are balta peste?\n" +
                    "- Are... (oftand)... da-i acoperit de apa!");
        }
        if(numba == 322){
            glumecc.setText("Care-i asemanarea dintre un divort in Kentucky si o tornada? \n" +
                    "... \n" +
                    "In ambele cazuri cineva pierde o rulota. ");
        }
        if(numba == 323){
            glumecc.setText("De ce bagi un bebelus intr-un blender cu picioarele intai? \n" +
                    "... \n" +
                    "Pentru expresii faciale. ");
        }
        if(numba == 324){
            glumecc.setText("ce zice tarzan cand vede o mie de elefanti venind spre el?\n" +
                    "ia ute frate,o mie de elefanti venind spre mine!!");
        }
        if(numba == 325){
            glumecc.setText("-Nu va suparati, caut strada Libertatii!\n" +
                    "-Nu ma supar! Cautati-o!");
        }
        if(numba == 326){
            glumecc.setText("Un om era pe moarte...da' s-a dat jos!");
        }
        if(numba == 327){
            glumecc.setText("ce este albastru si umbla pe sub pamant?raspuns:o rama in trening");
        }
        if(numba == 328){
            glumecc.setText("\n" +
                    "Un tip cade de la etajul 7. Dupa vreo 5 minute îi cade si parul: vjjjupp!\n" +
                    "Folosise o lotiune care întîrzia caderea parului !");
        }
        if(numba == 329){
            glumecc.setText("Doi delfini taiau benzina pe fundu' marii. Vine un rechin:\n" +
                    "- Ce faceti acilea?\n" +
                    "- Taiem benzina!\n" +
                    "- Aveti grija sa nu faceti firmituri!");
        }
        if(numba == 330){
            glumecc.setText("Un om mergea pe strada.\n" +
                    "Si a disparut!\n" +
                    "De ce???\n" +
                    "Il manca nasul!");
        }
        if(numba == 331){
            glumecc.setText("\n" +
                    "De ce are elefantul ochii rosii?\n" +
                    "(raspuns)Ca sa poata sa se ascunda in cires");
        }
        if(numba == 332){
            glumecc.setText("Ati vadut vreodata elefanti in cires?\n" +
                    "Daca nu, inseamna ca s-au ascuns bine!");
        }
        if(numba ==333 ){
            glumecc.setText("2 soareci se uita printr-o teava.Unul de la un capat , celalalt de la alt capat.\n" +
                    "Intrebare:De ce nu se vad?\n" +
                    "Ras:Pentru ca unul se uita marti si celalalt miercuri.");
        }
        if(numba ==334 ){
            glumecc.setText("Purcelushul super`agresiv, la restaurant, catre chelner:\"Aici se primesc comenzi?\"\n" +
                    "\"Da!\"\n" +
                    "\"SEZI!\"");
        }
        if(numba == 335){
            glumecc.setText("cum face un cal cand merge in linie dreapta?tropa tropa.dar cum face cand merge in linie stramba?tropa tropa sin de alfa.\n");
        }
        if(numba == 336){
            glumecc.setText("Ce este perfect rotund si din sticla?\n" +
                    "Un cub de lemn.");
        }
        if(numba == 337){
            glumecc.setText("Doi crocodili zburau deasupra oceanului Pacific.La un moment dat cel din mijloc spune:\n" +
                    "-Bai,zburam de o saptamana si tot vineri e!");
        }
        if(numba == 338){
            glumecc.setText("-John?!\n" +
                    "-Yes Sir!\n" +
                    "-Lamâia are pene?\n" +
                    "-Nu Sir!\n" +
                    "-La naiba, iar am stors papagalul! ");
        }
        if(numba == 339){
            glumecc.setText("John: Sir, avem un hot în biblioteca...\n" +
                    "Sir: Si ce citeste, John ?");
        }
        if(numba == 340){
            glumecc.setText("-John, ce-a fost zgomotul acela puternic?\n" +
                    "-Sir, un automobilst a vrut sa intre pe o strada laterala.\n" +
                    "-Si?\n" +
                    "-Si, sir, strada nu se afla în locul unde a virat automobilistul.");
        }
        if(numba == 341){
            glumecc.setText("Un om soseste în graba la Sir:\n" +
                    "-Sir, John a sarit cu parasuta si nu s-a deschis.\n" +
                    "-Iar?!");
        }
        if(numba == 342){
            glumecc.setText("-John, spune Sir, care citea ziarul, pe acoperis circula tramvaie?\n" +
                    "-Nu, Sir?! Dar de ce întrebati?\n" +
                    "-Uite, aici scrie ca un tramvai a calcat un hornar...");
        }
        if(numba == 343){
            glumecc.setText("Sir se urca pe cal invers, cu spatele în fata...\n" +
                    "-Sir, spune John, dar nu asa se urca pe cal!\n" +
                    "-Taci, ma, de unde stii tu încotro vreau sa merg...");
        }
        if(numba == 344){
            glumecc.setText("Cele mai importante lucruri in viata sunt lucrurile ");
        }
        if(numba == 345){
            glumecc.setText("Sotia ta unde e?\n" +
                    "- In gradina.\n" +
                    "- Dar nu o vad.\n" +
                    "- Trebuie sa sapi putin.");
        }
        if(numba == 346){
            glumecc.setText("Vad un olog pe strada si ii spun: Daca iti dau un picior, mergi sau zbori ?");
        }
        if(numba == 347){
            glumecc.setText("Sloganul unui restaurant canibal : \"Primul venit , primul servit \"");
        }
        if(numba == 348){
            glumecc.setText("-Mami! Tata iar s-a imbatat!\n" +
                    "-De unde stii?\n" +
                    "-Barbiereste oglinda din baie.");
        }
        if(numba == 349){
            glumecc.setText("-Stii bancul ala cu iepurele in baie?\n" +
                    "-Nu!\n" +
                    "-Nici eu, ca usa era inchisa.");
        }
        if(numba ==350 ){
            glumecc.setText("Stilpul se apropia cu viteza, am incercat sa il evit dar...... a intrat in mine!");
        }
        if(numba == 351){
            glumecc.setText("Erau odata doua baloane prin desert, un balon ii spune celuilalt: \"Uite un cactusssssssss\"...");
        }
        if(numba == 352){
            glumecc.setText("- Stii bancul cu iarna? \n" +
                    "- Iar n-am bani in buzunar");
        }
        if(numba == 353){
            glumecc.setText("Cel mai micinos animal: ursul, zice \"mor, mor\" si nu moare....");
        }
        if(numba == 354){
            glumecc.setText("Ce e o linie alba in desert?\n" +
                    "...o ata alba\n" +
                    "Ce e o linie neagra in desert?\n" +
                    "...umbra atei");
        }
        if(numba ==355 ){
            glumecc.setText("- Cel mai scurt si mai sec banc:\n" +
                    "- DOP !");
        }
        if(numba ==356 ){
            glumecc.setText("- Ce intra pe o ureche si iese pe cealalta si ramane si in cap?\n" +
                    "- Tarnacopu' !");
        }
        if(numba ==357 ){
            glumecc.setText("Ce e galben si merge pe sub pamant?\n" +
                    "Un vietnamez care cauta o bomba.\n" +
                    "Ce e galben si zboara?\n" +
                    "UN vietnamez care a gasit-o.");
        }
        if(numba ==358 ){
            glumecc.setText("Merg 2 orbi la cinematograf. Incepe filmu la care 1 dintre ei zice \"ma, tu vezi ceva ?\", nu, raspunde asta. Atunci hai sa mergem mai in fata.");
        }
        if(numba == 359){
            glumecc.setText("Mutu ii spune lui Surdu ca Chiorul a vazut un Schiop alergand dupa un Chel sa il traga de par .");
        }
        if(numba == 360){
            glumecc.setText("- Sitzi cum se uita o rata in beci?\n" +
                    "- Iei rata, o duci in beci si o uiti acolo...");
        }
        if(numba == 361){
            glumecc.setText("-Ce trebuie sa ii faci unui hipopotam care are diaree?\n" +
                    "-Loc!!!");
        }
        if(numba == 362){
            glumecc.setText("-Ce e verde si alerga prin padure?\n" +
                    "-O haita de castraveti!");
        }
        if(numba == 363){
            glumecc.setText("De ce nu alearga melcul? Sa nu-si fluture ochii...");
        }
        if(numba == 364){
            glumecc.setText("Doi scheleti se trag de piele!!!");
        }
        if(numba == 365){
            glumecc.setText("Cine rade la urma, gandeste mai incet.");
        }
        if(numba == 366){
            glumecc.setText("- Cum afli sexul lebedelor de pe lac?\n" +
                    "- Arunci o bucata de paine:..daca vine ea....e lebada;.....daca vine el ...e lebadoiu...");
        }
        if(numba == 367){
            glumecc.setText("- V-am povestit vreodata despre mine?\n" +
                    "- Minele sunt niste gauri din care ies minerii !!!");
        }
        if(numba == 368){
            glumecc.setText("Cica un lup dadea tircoale la o stina.La un momentdat s-a oprit.De ce?\n" +
                    "R:Pentru ca nu mai avea tircoale...");
        }
        if(numba == 369){
            glumecc.setText("Un mut ii spune unui surd:\n" +
                    "- Ne urmareste un orb!");
        }
        if(numba == 370){
            glumecc.setText("La coltul unei case rotunde se auzi o impuscatura de cutit. Mortul cazu spanzurat.");
        }
        if(numba ==371 ){
            glumecc.setText("Era un submarin deasupra desertului. La un moment dat se opreste ,se ridica periscopul si un matelot se uita prin el. \n" +
                    "Comandantul: -Cati? \n" +
                    "Matelotul: -15 \n" +
                    "Comandantul: -Ce 15? \n" +
                    "Matelotul: -Ce cati? ");
        }
        if(numba == 372){
            glumecc.setText("O rosie statea in mijlocul unei autostrazi!Alta ii spune:\n" +
                    "-Ai grija!Vine un camion!\n" +
                    "La care ea raspunde:\n" +
                    "-Ete....fleoshc");
        }
        if(numba == 373){
            glumecc.setText("Faza pe bune la un semafor: unu' nervos e injurat:\n" +
                    "- Zambi-mi-ai de sub tramvai!");
        }
        if(numba ==374 ){
            glumecc.setText("Doi tantari erau pe o motocicleta Harley Davidson. Unu' zice: \"Opreste ma, ca mi-a intrat o musca-n ochi\" !");
        }
        if(numba == 375){
            glumecc.setText("Un copil intreaba pe tata-sau: \n" +
                    "-De ce sunt rosiile astea asa de galbene?\n" +
                    "-Pentru ca sunt verzi...");
        }
        if(numba == 376){
            glumecc.setText("-Ce se intampla daca incalci una din cele zece porunci?\n" +
                    "-RAMAN NOUA!!!");
        }
        if(numba == 377){
            glumecc.setText("I:Ce e mic ,verde si se urca pe pereti? \n" +
                    "R:Un castravete ambitios");
        }
        if(numba == 378){
            glumecc.setText("- STITI DE CE II ZICE BILEI -\"BILA\"?\n" +
                    "- PT. CA FACE PLEOSC-PLEOSC CAND CADE; DACA FACEA PLEOSC-PLEOSC-PLEOSC, II ZICEA TRILA!");
        }
        if(numba == 379){
            glumecc.setText("Cum se vaneaza un iepure?\n" +
                    "Vanatorul se ascunde intr-un tufis si face ca varza.");
        }
        if(numba == 380){
            glumecc.setText("-ALO, GRESEALA?\n" +
                    "-NU.");
        }
        if(numba == 381){
            glumecc.setText("Porcusorul isteric statea peste 7 mari si 7 tari. Intr-o dimineata se trezeste, se uita pe geam si zice:\n" +
                    "- Ba, ce departe stau!");
        }
        if(numba == 382){
            glumecc.setText("O bila se rostogoleste pana la capat, acolo se rastoarna ...");
        }
        if(numba == 383){
            glumecc.setText("Ce-i mic negru cu doua puncte albe?\n" +
                    "un purice cu vata in urechi");
        }
        if(numba == 384){
            glumecc.setText("Pe o linie ferata mergea mama rosie, tatal rosie si copilul. Juniorul ramanea in urma. Se intoarce tatal ii dau un punm in cap si il face sos de tomate, dupa care zice: \n" +
                    "- Floscaitule !");
        }
        if(numba == 385){
            glumecc.setText("Doua clatite merg! La un moment dat una se impiedica si ii sare gemu ");
        }
        if(numba == 386){
            glumecc.setText("Elefantii zboara cu ajutorul urechilor.\n" +
                    "Ati vazut vreun elfant zburand?\n" +
                    "Deci zboara foarte repede.\n");
        }
        if(numba == 387){
            glumecc.setText("- Ce sta in copac,e galbena si miauna?\n" +
                    "- O banana!");
        }
        if(numba == 388){
            glumecc.setText("Cate baterii are un ceas mecanic?\n" +
                    "Raspuns: era intrebare capcana, ceasu` mecanic n-are decat 3 baterii");
        }
        if(numba == 389){
            glumecc.setText("la usa:\n" +
                    "\"cioc, cioc\"\n" +
                    "dinauntru:\"cine e?\"\n" +
                    "raspuns:\"eu\"\n" +
                    "intrebare:\"EU???????\"");
        }
        if(numba == 390){
            glumecc.setText("Doi magari stateau la coada, la coada altui magar");
        }
        if(numba == 391){
            glumecc.setText("In anul 1854 este gasit un negru mort cu 18 gloante in spate. Seriful face constatarea si zice :\n" +
                    "-MMAAAAMAAAA ,asa sinucidere n-am mai intalnit.");
        }
        if(numba == 392){
            glumecc.setText("Un tren opreste in gara Caracal.. Un calator da geamul in jos si intreaba un trecator: \n" +
                    "-Nu va suparati, gara Caracal?! \n" +
                    "-Bine ca esti tu destep t...");
        }
        if(numba == 393 ){
            glumecc.setText("I: - Ce reprezinta un punct alb in desert?\n" +
                    "R: - O aspirina.");
        }
        if(numba == 394 ){
            glumecc.setText("Un pitic pica intr-o prapastie, se chinuie saracu' sa iasa de acolo dar in zadar. Vine un urias, il ia in palma si-l intreaba:\n" +
                    "- Catzi? \n" +
                    "- 5 \n" +
                    "Uriasul nedumerit:\n" +
                    "- Ce 5 ? \n" +
                    "Dar piticul:\n" +
                    "- Ce catzi ?");
        }
        if(numba == 395){
            glumecc.setText("-DE CE ARE ELEFANTUL TROMPA ASA DE LUNGA \n" +
                    "-CA SA NU INCEAPA ATAT DE BRUSC");
        }
        if(numba == 396){
            glumecc.setText("ce este mare, are 4 picioare, coama, copite si incepe cu litera \"V\" ?\n" +
                    "- un cal pe nume Vasile......");
        }
        if(numba == 397){
            glumecc.setText("Doarme unul.... de doarme se trezeste dimineata si vrea sa imbrace. Cand colo, ce sa vezi ? Nu-l mai incapeau hainele... De ce?\n" +
                    "SE UMFLASE DE SOMN !!!");
        }
        if(numba == 398){
            glumecc.setText("- Am auzit voci!\n" +
                    "- Calmeaza-te, sunt vocile noastre, cand dialogam, ele se aud!");
        }
        if(numba == 399){
            glumecc.setText("Erau 3 Ferrari pe o autostrada.\n" +
                    "Se intreceau la viteza maxima, la un moment dat unu o ia la dreapta...");
        }
        if(numba ==400 ){
            glumecc.setText("-Ce culoare are culoarea rosie?\n" +
                    "-Verde!");
        }
        /*if(numba == 401){
            glumecc.setText("");
        }
        if(numba == 402){
            glumecc.setText("");
        }
        if(numba == 403){
            glumecc.setText("");
        }
        if(numba == 404){
            glumecc.setText("");
        }
        if(numba == 405){
            glumecc.setText("");
        }
        if(numba == 406){
            glumecc.setText("");
        }
        if(numba ==407 ){
            glumecc.setText("");
        }
        if(numba == 408){
            glumecc.setText("");
        }
        if(numba == 409){
            glumecc.setText("");
        }
        if(numba == 410){
            glumecc.setText("");
        }
        if(numba == 411){
            glumecc.setText("");
        }
        if(numba == 412){
            glumecc.setText("");
        }
        if(numba == 413){
            glumecc.setText("");
        }
        if(numba == 414){
            glumecc.setText("");
        }
        if(numba == 415){
            glumecc.setText("");
        }
        if(numba == 416){
            glumecc.setText("");
        }
        if(numba == 417){
            glumecc.setText("");
        }
        if(numba == 418){
            glumecc.setText("");
        }
        if(numba ==419 ){
            glumecc.setText("");
        }
        if(numba ==420 ){
            glumecc.setText("");
        }
        if(numba == 421){
            glumecc.setText("");
        }
        if(numba ==422 ){
            glumecc.setText("");
        }
        if(numba == 423){
            glumecc.setText("");
        }
        if(numba == 424){
            glumecc.setText("");
        }
        if(numba ==425 ){
            glumecc.setText("");
        }
        if(numba ==426 ){
            glumecc.setText("");
        }
        if(numba == 427){
            glumecc.setText("");
        }
        if(numba == 428){
            glumecc.setText("");
        }
        if(numba == 429){
            glumecc.setText("");
        }
        if(numba == 430){
            glumecc.setText("");
        }
        if(numba == 431){
            glumecc.setText("");
        }
        if(numba == 432){
            glumecc.setText("");
        }
        if(numba == 433){
            glumecc.setText("");
        }
        if(numba == 434){
            glumecc.setText("");
        }
        if(numba == 435){
            glumecc.setText("");
        }
        if(numba == 436){
            glumecc.setText("");
        }
        if(numba ==437 ){
            glumecc.setText("");
        }
        if(numba == 438){
            glumecc.setText("");
        }
        if(numba == 439){
            glumecc.setText("");
        }
        if(numba == 440){
            glumecc.setText("");
        }
        if(numba == 441){
            glumecc.setText("");
        }
        if(numba ==442 ){
            glumecc.setText("");
        }
        if(numba == 443){
            glumecc.setText("");
        }
        if(numba == 444){
            glumecc.setText("");
        }
        if(numba == 445){
            glumecc.setText("");
        }
        if(numba ==446 ){
            glumecc.setText("");
        }
        if(numba ==447 ){
            glumecc.setText("");
        }
        if(numba ==448 ){
            glumecc.setText("");
        }
        if(numba == 449){
            glumecc.setText("");
        }
        if(numba == 450){
            glumecc.setText("");
        }
        if(numba ==451 ){
            glumecc.setText("");
        }
        if(numba == 452){
            glumecc.setText("");
        }
        if(numba ==453 ){
            glumecc.setText("");
        }
        if(numba == 454){
            glumecc.setText("");
        }
        if(numba == 455){
            glumecc.setText("");
        }
        if(numba ==456 ){
            glumecc.setText("");
        }
        if(numba == 457){
            glumecc.setText("");
        }
        if(numba == 458){
            glumecc.setText("");
        }
        if(numba == 459){
            glumecc.setText("");
        }
        if(numba ==460 ){
            glumecc.setText("");
        }
        if(numba == 461){
            glumecc.setText("");
        }
        if(numba ==462){
            glumecc.setText("");
        }
        if(numba ==463 ){
            glumecc.setText("");
        }
        if(numba == 464){
            glumecc.setText("");
        }
        if(numba ==465 ){
            glumecc.setText("");
        }
        if(numba ==466 ){
            glumecc.setText("");
        }
        if(numba == 467){
            glumecc.setText("");
        }
        if(numba ==468 ){
            glumecc.setText("");
        }
        if(numba == 469){
            glumecc.setText("");
        }
        if(numba == 470){
            glumecc.setText("");
        }
        if(numba == 471){
            glumecc.setText("");
        }
        if(numba == 472){
            glumecc.setText("");
        }
        if(numba ==473 ){
            glumecc.setText("");
        }
        if(numba ==474 ){
            glumecc.setText("");
        }
        if(numba == 475){
            glumecc.setText("");
        }
        if(numba ==476 ){
            glumecc.setText("");
        }
        if(numba ==477 ){
            glumecc.setText("");
        }
        if(numba == 478){
            glumecc.setText("");
        }
        if(numba == 479){
            glumecc.setText("");
        }
        if(numba == 480){
            glumecc.setText("");
        }
        if(numba ==481 ){
            glumecc.setText("");
        }
        if(numba == 482){
            glumecc.setText("");
        }
        if(numba ==483 ){
            glumecc.setText("");
        }
        if(numba ==484 ){
            glumecc.setText("");
        }
        if(numba == 485){
            glumecc.setText("");
        }
        if(numba == 486){
            glumecc.setText("");
        }
        if(numba == 487){
            glumecc.setText("");
        }
        if(numba == 488){
            glumecc.setText("");
        }
        if(numba == 489){
            glumecc.setText("");
        }
        if(numba == 490){
            glumecc.setText("");
        }
        if(numba == 491){
            glumecc.setText("");
        }
        if(numba == 492){
            glumecc.setText("");
        }
        if(numba ==483 ){
            glumecc.setText("");
        }
        if(numba == 484){
            glumecc.setText("");
        }
        if(numba == 485){
            glumecc.setText("");
        }
        if(numba == 486){
            glumecc.setText("");
        }
        if(numba ==487 ){
            glumecc.setText("");
        }
        if(numba == 488){
            glumecc.setText("");
        }
        if(numba == 489){
            glumecc.setText("");
        }
        if(numba == 490){
            glumecc.setText("");
        }
        if(numba == 491){
            glumecc.setText("");
        }
        if(numba ==492 ){
            glumecc.setText("");
        }
        if(numba == 493){
            glumecc.setText("");
        }
        if(numba == 494){
            glumecc.setText("");
        }
        if(numba ==495 ){
            glumecc.setText("");
        }
        if(numba == 496){
            glumecc.setText("");
        }
        if(numba == 497){
            glumecc.setText("");
        }
        if(numba ==498 ){
            glumecc.setText("");
        }
        if(numba == 499){
            glumecc.setText("");
        }
        if(numba == 500){
            glumecc.setText("");
        }
        /* if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }
        if(numba == ){
            glumecc.setText("");
        }













*/

        return true;
    }
}
