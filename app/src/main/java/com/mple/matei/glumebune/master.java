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

public class master extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    private static  TextView glumecc;
    public static String[] alibaba= new String[102];
    public static String[] mures= new String[102];

    private DatabaseReference mFav;
    private FirebaseAuth mAuth;
    private String current_user;
    private FirebaseAuth.AuthStateListener mAuthListener;

    int[] arai = new int[30000];
    private GestureDetectorCompat gesture;


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
        setContentView(R.layout.activity_master);



        glumecc=(TextView)findViewById(R.id.chuck);
        gesture= new GestureDetectorCompat(this,this);
        gesture.setOnDoubleTapListener(this);
        alibaba[0]="Chuck Norris ţine minte orice, inclusiv viitorul.";
        alibaba[1]="A fi sau a nu fi? Răspunsul este Chuck Norris";
        alibaba[2]="În loc de picături de ochi, Chuck Norris foloseşte sos picant";
        alibaba[3]="Chuck Norris a lovit odată un cal în barbă. Descendenţii acelui cal se numesc acum girafe";
        alibaba[4]="Chuck Norris donează regulat sânge la Crucea Roşie, dar niciodată pe al lui";
        alibaba[5]="Chuck Norris era pe moarte. Iar moartea i-a zis să se dea jos";
        alibaba[6]="Chuck Norris nu poartă ceas. El decide cât e ceasul";
        alibaba[7]="Chuck Norris nu va face niciodată infarct. Inima nu e atât de tâmpită să-l atace";
        alibaba[8]="Tu trăieşti pentru că Chuck Norris te-a lăsat în viaţă";
        alibaba[9]="Chuck Norris strănută cu ochii deschişi";
        alibaba[10]="Chuck Norris a înecat un peşte sub apă";
        alibaba[11]="Chuck Norris este atât de rapid încât lumina nu îl poate găsi";
        alibaba[12]="Chuck Norris îţi omoară prietenii imaginari";
        alibaba[13]="Chuck Norris poate auzi limbajul mimico-gestual";
        alibaba[14]="Atunci când Alexander Bell a inventat telefonul avea trei apeluri nepreluate de la Chuck Norris";
        alibaba[15]="Chuck Norris a fost deja pe Marte. De aceea nu este nicio urmă de viaţă acolo";
        alibaba[16]="Chuck Norris şi Superman s-au luptat cândva. Iar cel care a pierdut a trebuit să poarte chiloţii deasupra pantalonilor";
        alibaba[17]="Unii magicieni pot merge pe apă, Chuck Norris înoată pe pământ";
        alibaba[18]="Chuck Norris a numărat până la infinit, de două ori";
        alibaba[19]="Chuck Norris poate să trântească o uşă rotativă";
        alibaba[20]="Chuck Norris a fost muşcat o dată de un şarpe cu clopoţei. După trei zile de durere şi agonie, şarpele a murit";
        alibaba[21]="Chuck Norris face focul cu două cuburi de gheaţă";
        alibaba[22]="Mâna lui Chuck Norris este singura mână care poate bate o chintă roială";
        alibaba[23]="Unii poartă pijamale cu Superman. Superman poartă pijamale cu Chuck Norris";
        alibaba[24]="Chuck Norris a distrus tabelul lui Mendeleev pentru că Chuck Norris recunoaşte doar elementul surpriză";
        alibaba[25]="Chuck Norris mănâncă supă cu furculiţa";
        alibaba[26]="Chuck Norris nu doarme, el aşteaptă";
        alibaba[27]="A călători prin timp este posibil, dar mai întâi trebuie să treci de Chuck Norris";
        alibaba[28]="Chuck Norris a escaladat Everestul în 15 minute, din care 14 i-au luat doar să facă un om de zăpadă la baza muntelui";
        alibaba[29]="Chuck Norris are cuţit cu lunetă şi grenadă cu infraroşu";
        alibaba[30]="Chuck Norris s-a uitat o dată la soare timp de zece ore. Şi soarele a clipit primul";
        alibaba[31]="Chuck Norris a aruncat odată un bumerang care nu s-a mai întors";
        alibaba[32]="Lacrimile lui Chuck Norris pot vindeca chiar şi cancerul... păcat că nu a plâns niciodată";
        alibaba[33]="De ce în calendarul lui Chuck Norris se trece direct de la 31 martie la 2 aprilie? Nimeni nu îl păcăleşte de Chuck Norris";
        alibaba[34]="De ce doarme Chuck Norris cu lumina aprinsă? Nu pentru ca îi e teamă de întuneric, ci pentru că întunericului îi e frică de el";
        alibaba[35]="Chuck Norris joacă ruleta rusească cu pistolul plin. Şi câştigă mereu";
        alibaba[36]="Când Chuck Norris taie ceapă, nu plânge el, ci ceapa";
        alibaba[37]="Chuck Norris nu are frunte. Ăla e doar al treilea său pumn";
        alibaba[38]="Chuck Norris nu poate să iubească, el poate doar să nu ucidă";
        alibaba[39]="Chuck Norris poate să aplaude cu o singură mână";
        alibaba[40]="Chuck Norris poate să dea foc la furnici cu lupa. Noaptea!";
        alibaba[41]="Chuck Norris s-a născut într-o cabană construită de el";
        alibaba[42]="Chuck Norris a înghiţit odată un borcan de somnifere. L-au făcut să clipească";
        alibaba[43]="Chuck Norris a ars odată o pădure când făcea experimente cu apă";
        alibaba[44]="Când Chuck Norris face flotări, nu se ridică pe el, el împinge pământul în jos";
        alibaba[45]="Chuck Norris e cunoscut pentru modestia lui, dar recunoaşte că este a 8-a minune a lumii";
        alibaba[46]="Chuck Norris nu se îmbată niciodată. Nimic nu îndrăzneşte să-l ameţească pe Chuck Norris";
        alibaba[47]="Există două tipuri de infractori: care trăiesc şi cei care l-au întâlnit pe Chuck Norris";
        alibaba[48]="Nu există bombă atomică. E doar Chuck Norris când se aruncă din avion şi loveşte pământul cu pumnii";
        alibaba[49]="Chuck Norris a luat zece pe linie la examene doar pentru că a răspuns „Chuck Norris“ la toate întrebările";
        alibaba[50]="Dimineaţa, soarele îi bate în geam lui Chuck Norris ca să ceară voie să răsară";
        alibaba[51]="De ce a fost eclipsă de soare în 1999? Pentru că vroia Chuck Norris să se uite la cinema în aer liber";
        alibaba[52]="Mai mare decat Chuck Norris este doar umbra lui.";
        alibaba[53]="Noaptea, in jurul focului, fantomele spun povesti cu Chuck Norris.";
        alibaba[54]="Cand cade Chuck Norris stelele isi pun in gand cate o dorinta.";
        alibaba[55]="Chuck Norris a lasat-o stirba pe Zana Maseluta.";
        alibaba[56]="Cand Chuck Norris are chef de puzzle isi cumpara o punga de faina si reface boabele de grau.";
        alibaba[57]="Daca ar veni sfarsitul lumii, Chuck Norris ar fi vesnic singur.";
        alibaba[58]="O singura data politia rutiera l-a oprit pe Chuck Norris. Politistul a scapat doar cu amenda ca nu purta centura.";
        alibaba[59]="Cand un urs se intalneste cu Chuck Norris, ursul face pe mortul.";
        alibaba[60]="Titanicul s-a lovit de Chuck Norris care facea linistit pluta";
        alibaba[61]="Chuck Norris rade doar la bancurile cu Chuck Norris.";
        alibaba[62]="Chuck Norris a lasat-o pe Mona Lisa sa zambeasca.";
        alibaba[63]="Chuck Norris nu inghite cand mananca.";
        alibaba[64]="Chuck Norris se divide cu 0.";
        alibaba[65]="Chuck Norris si-a donat inima unui spital . De doua ori !";
        alibaba[66]="Facebook ii da Like lui Chuck Norris.";
        alibaba[67]="Chuck Norris a fost nascut de matusa lui. Pentru ca nimeni nu are voie sa se atinga de mama lui.";
        alibaba[68]="Chuck Norris si-a luat extraoptiunea 1500 minute in retea si le-a vorbit intr-o singura ora.";
        alibaba[69]="Chuck Norris poate apasa Ctrl - Alt - Delete cu un singur deget.";
        alibaba[70]="Chuck Norris si-a citit singur testamentul la inmormantare.";
        alibaba[71]="Chuck Norris si-a botezat parintii.";
        alibaba[72]="Chuck Norris l-a vazut pe omul invizibil.";
        alibaba[73]="Cand era mic, Mos Craciun primea cadouri de la Chuck Norris.";
        alibaba[74]="Chuck Norris poate sa-si dea un cap in gura.";
        alibaba[75]="Chuck Norris are cinci maini la un deget.";
        alibaba[76]="Chuck Norris a castigat un miliard la \"Vrei sa fii milionar?\"";
        alibaba[77]="Chuck Norris s-a nascut cu barba.";
        alibaba[78]="Chuck Norris mananca mai intai portocala , apoi o cojeste.";
        alibaba[79]="Chuck Norris a luat examenele inainte sa le dea.";
        alibaba[80]="Chuck Norris nu foloseste masina sau avionul sa ajunga undeva. El e deja acolo.";
        alibaba[81]="Cand a ajuns Armstrong pe luna, Chuck Norris l-a intampinat.";
        alibaba[82]="Chuck Norris nu tine cu nicio echipa. Echipele tin cu Chuck Norris";
        alibaba[83]="Chuck Norris doarme cu perna sub pistol.";
        alibaba[84]="Chuck Norris poate sa clipeasca cu ochii deschisi.";
        alibaba[85]="Hruşcă l-a învăţat pe Chuck Norris să colinde!";
        alibaba[86]="Iisus canta colinde in Rai despre nasterea lui Hrusca.";
        alibaba[87]="Manelele cantate de Hrusca ar putea vindeca cancerul, dar Hrusca nu canta manele";
        alibaba[88]="Cand Hrusca e racit, se amana Craciunul";
        alibaba[89]="Mos Craciun este al doilea producator de ler, dupa Hrusca";
        alibaba[90]="Iisus s-a nascut ca Hrusca sa poata colinda";
        alibaba[91]="Hrusca este singurul care il colinda pe Chuck Norris, este singurul capabil sa produca indeajuns ler";
        alibaba[92]="In cinstea lui Hrusca, de Craciun Chuck Norris isi denumeste pumnii “Lin” si “Catilin”; cand loveste cu ei, vindeca";
        alibaba[93]="Hrusca a fost al 4-lea mag, care i-a daruit pruncului prima coloana sonora";
        alibaba[94]="Primul cuvant zis de Hrusca n-a fost “mama” ci “ler”";
        alibaba[95]="Hrusca poate sa-l stinga pe Fuego";
        alibaba[96]="Pisica lui Hrusca se joaca cu un ghem de ler";
        alibaba[97]="Gigi Becali va canta anul acesta in duet cu Stefan Hrusca un colind inedit: \"Hahaleru-i hahaler!\"";
        alibaba[98]="Cand Hrusca se culca, vine primavara";
        alibaba[99]=" Cand primeste un apel, telefonul lui Hrusca suna lin";
        alibaba[100]=" Lui Hrusca nu-i sare mustaru, ii sare leru";
        alibaba[101]="- Alinuta, vezi sa nu cada caciulita surorii tale!\n" +
                "− Nu cade, i-am batut-o in cuie!!";




        myDb = new DatabaseHelper(this);
        btnAddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button);

        Typeface mytf =Typeface.createFromAsset(getAssets(), "TTWPGOTT.ttf");

        glumecc.setTypeface(mytf);








        bt=(Button)findViewById(R.id.gica);
        bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody=glumecc.getText().toString();
                String shareSub =glumecc.getText().toString() + " -----> Mai multe glume bune la https://play.google.com/store/apps/details?id=com.mple.matei.glumebune ";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareSub);
                startActivity(Intent.createChooser(myIntent,"Share using"));






            }
        });



        AdView adView99 =(AdView)findViewById(R.id.adView255);

        AdRequest adRequest99 = new AdRequest.Builder().build();

        adView99.loadAd(adRequest99);
        AdView adView55 =(AdView)findViewById(R.id.adView299);

        AdRequest adRequest55 = new AdRequest.Builder().build();

        adView55.loadAd(adRequest55);


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
                            map.put("titlu", "Legenda");
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
                                        Toast.makeText(master.this, "Gluma a fost adaugata la favorite", Toast.LENGTH_LONG).show();


                                    } else if (databaseError != null) {
                                        Toast.makeText(master.this, databaseError.toString(), Toast.LENGTH_LONG).show();
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
            a++;
            glumecc.setText("nem!");
        }
        else
        glumecc.setText(mures[a-1]);
        a--;


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
        int numba = rodrigo.nextInt(102);
        mures[a]=alibaba[numba];
        glumecc.setText(alibaba[numba]);
        a++;






        return true;
    }
}
