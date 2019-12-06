package com.mple.matei.glumebune;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
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

import java.util.Random;


public class lungi extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private static TextView glumec;
    private GestureDetectorCompat gestures;
    int[] ara = new int[3000];
    int a1=0;
    Button btnAddData;
    Button btnviewAll;
    DatabaseHelper myDb;

    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lungi);

        glumec=(TextView)findViewById(R.id.lungi);
        gestures= new GestureDetectorCompat(this,this);
        gestures.setOnDoubleTapListener(this);


        myDb = new DatabaseHelper(this);
        btnAddData = (Button)findViewById(R.id.button211);
        btnAddData.setVisibility(View.INVISIBLE);
        btnAddData.setEnabled(false);



        Typeface mytf9 =Typeface.createFromAsset(getAssets(), "TTWPGOTT.ttf");

        glumec.setTypeface(mytf9);




       AdView adViewv =(AdView)findViewById(R.id.adViewv);

        AdRequest adRequestv = new AdRequest.Builder().build();

        adViewv.loadAd(adRequestv);

       // AdView adViewo =(AdView)findViewById(R.id.adViewo);

        //AdRequest adRequesto = new AdRequest.Builder().build();

        //adViewo.loadAd(adRequesto);


        bt=(Button)findViewById(R.id.button212);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = glumec.getText().toString();
                String shareSub = glumec.getText().toString() + " -----> Mai multe glume bune la https://play.google.com/store/apps/details?id=com.mple.matei.glumebune ";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Share using"));


            }
        });







    }











    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


























































    @Override
    public boolean onTouchEvent(MotionEvent event){
        gestures.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {


        if(a1<=0){
            glumec.setText("NEM! da swipe pentru glume!");
            a1++;
        }


        else{
            int numba1 = ara[a1 - 1];
        if (ara[a1 - 1] == 0) {
            glumec.setText("Musafirii, la iesirea din restaurant: \n" +
                    "- Pacat ca nu am ajuns la dv. mai curand!\n" +
                    "- Ne bucuram ca v-a placut!\n" +
                    "- Nu ne-a placut deloc- dar daca ajungeam mai repede, poate ca era carnea proaspata inca...");
        }
        if (ara[a1 - 1] == 1) {
            glumec.setText("O gâscă într-un bar: \n" +
                    "- Aveți mămăligă? întreabă gâsca.\n" +
                    "- Nu, răspunde barmanul.\n" +
                    "- Sigur?\n" +
                    "- Nu, nu avem, n-auzi...?!?\n" +
                    "- Sigur, sigur ?\n" +
                    "- Dacă mai întrebi o dată, iau un cui și un ciocan și-ți prind ciocul de tejghea....!\n" +
                    "- Aveți cuie?\n" +
                    "- Nu....\n" +
                    "- Dar mămăligă...???\n" + "." + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (ara[a1 - 1] == 2) {
            glumec.setText("A intrat o pisicuţă într-o încăpere.\n" +
                    "- Miauuu !\n" +
                    "Toţi şoarecii s-au ascuns .\n" +
                    "După un timp , pisicuţa : \n" +
                    "- Ham , ham !\n" +
                    "Toţi şoarecii au ieşit din ascunzători.\n" +
                    "Morala : \n" +
                    "\"Întotdeauna este bine să stii o limbă străină“" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (ara[a1 - 1] == 3) {
            glumec.setText("– Bunicule ce sunt alea?\n" +
                    "– Cirese negre.\n" +
                    "– Si de ce sunt rosii?\n" +
                    "– Pentru ce sunt inca verzi!");
        }
        if (ara[a1 - 1] == 4) {
            glumec.setText("Excursie la centrala atomica de la Cernavoda.\n" +
                    "In spatele unui geam doi angajati, in costume de protectie, duc cu atentie un tub mic.\n" +
                    "Unul dintre vizitatori intreaba:\n" +
                    "– Ce va fi daca vor scapa acel tub?\n" +
                    "– In principiu nimic….Pe o raza de 200 km!" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (ara[a1 - 1] == 5) {
            glumec.setText("Un tip statea nemiscat intr-un autobuz.\n" +
                    "La un moment dat cineva deranjat ca nu are loc de el:\n" +
                    "– Ce faci domnule?\n" +
                    "– Mimez branza.\n" +
                    "– Cum adica?\n" +
                    "– Stau si put…" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (ara[a1 - 1] == 6) {
            glumec.setText("– Există canibali vegetarieni?\n" +
                    "– Desigur.\n" +
                    "– Şi ce mănîncă ei?\n" +
                    "– Mărul lui Adam…");
        }
        if (ara[a1 - 1] == 7) {
            glumec.setText("Un pictor vestit, aflat intr-o drumetie in munti, intalneste o turma si se adreseaza ciobanului;\n" +
                    "– Bade, imi dai voie sa-ti pictez oile?\n" +
                    "– Esti nebun, omule? Lasa-le asa albe cum sunt…" + ". \n" + ". \n");
        }
        if (ara[a1 - 1] == 8) {
            glumec.setText("- Cum poti sa impiedici o camila sa treaca prin urechile acului?\n" +
                    "- O inozi la coada");
        }
        if (ara[a1 - 1] == 9) {
            glumec.setText("Un om mergea linistit prin desert cand deodata ia o palma. Se uita in dreapta, in stanga, in spate, nimeni. Se uita in sus: senin.\n" +
                    "Mai merge ce merge si iarasi ia o palma. Se uita in dreapta, in stanga, in spate, nimeni. Se uita in sus: senin.\n" +
                    "Merge mai departe. La fel, iarasi ia o palma. Se uita in dreapta, in stanga, in spate, nimeni. Se uita in sus: senin.\n" +
                    "Si uite asa a luat trei palme din senin." + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (ara[a1 - 1] == 10) {
            glumec.setText("- De ce tinea Mihai Viteazu securea in mana stanga?\n" +
                    "- De maner, bineinteles.");
        }
        if (ara[a1 - 1] == 11) {
            glumec.setText("Doua broscute mergeau prin desert si se intalnesc la un moment dat in varful unei dune de nisip:\n" +
                    "- Ciao soro, unde mergi?\n" +
                    "- Aiurea, soro.\n" +
                    "- Hai pe-aici ca-i mai aproape.");
        }
        if (ara[a1 - 1] == 12) {
            glumec.setText("Un om mergea pe strada.\n" +
                    "Dar deodata dispare..\n" +
                    "De ce?\n" +
                    "L-au ros pantofii.");
        }
        if (ara[a1 - 1] == 13) {
            glumec.setText("In timp ce pastea, un cal inghite o lacusta. Aceasta incepe sa se agite in burta calului: \"Heeei, scoateti-ma de aici!\"\n" +
                    "Dar calul plecase..");
        }
        if (ara[a1 - 1] == 14) {
            glumec.setText("La doctor:\n" +
                    "- Domnule doctor, cainele meu nu are nas!\n" +
                    "- Si cum miroase?\n" +
                    "- Ingrozitor..");
        }
        if (ara[a1 - 1] == 15) {
            glumec.setText("De ce cade primul elefant din copac?\n" +
                    "Pentru ca era mort.\n" +
                    "Dar de ce cade al doilea elefant din copac?\n" +
                    "Pentru ca era legat de primul.\n" +
                    "Si de ce cade al treilea elefant din copac?\n" +
                    "Credea ca e un fel de joc si era randul lui." + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (ara[a1 - 1] == 16) {
            glumec.setText("Un om foarte gras statea in fata unei gradinite de copii. La un moment dat vine la el o educatoare si-l intreaba:\n" +
                    "- Nu va suparati, asteptati un copil?\n" +
                    "Ca replica, barbatul gras spune:\n" +
                    "- NU... asa sunt eu mai gras!");
        }
        if (ara[a1 - 1] == 17) {
            glumec.setText("O vaca pastea pe asfalt.\n" +
                    "Un submarin vine si o loveste.\n" +
                    "Ce concluzie se poate trage din acest tragic accident ?\n" +
                    "\"Sa nu mancam fructe nespalate.\"");
        }
        if (ara[a1 - 1] == 18) {
            glumec.setText("Cica, o vrabie statea pe o creanga, la care vine un pasaroi si ii spune:\n" +
                    "- Vezi ca te imping. \n" +
                    "Si a impins-o.");
        }
        if (ara[a1 - 1] == 19) {
            glumec.setText("Ion catre Vasile:\n" +
                    "\"Intreaba-ma daca ma cheama Gheorghe!\"\n" +
                    "\"Te cheama Gheorghe?\"\n" +
                    "\"Nu\"");
        }
        if (numba1 == 20) {
            glumec.setText("Intr-un magazin de carti un copil intreaba pe vanzatoare:\n" +
                    "- Aveti caiete in cerculet?.\n" +
                    "- Nu.\n" +
                    "- Dar lipici pentru clasa intai?\n" +
                    "- Nu.\n" +
                    "Un cumparator ce astepta in rand:\n" +
                    "- Baiete, du-te si nu mai incurca lumea pe aici.\n" +
                    "Baiatul pleaca. Cumparatorul spune:\n" +
                    "- Dati-mi, va rog, globul Romaniei. " + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 21) {
            glumec.setText("Soldat, tu nu ma auzi?\n" +
                    "- Nu, domnule capitan.\n" +
                    "- Cum ma nu ma auzi ca doar eu ma uit la tine. ");
        }
        if (numba1 == 22) {
            glumec.setText("O blonda la volan. La radio se aude:\n" +
                    "-Ascultati Europa FM.\n" +
                    "Blonda:\n" +
                    "-Doamne, de unde stiu astia totul?");
        }
        if (numba1 == 23) {
            glumec.setText("In vestul indepartat, la mijloc de secol XIX, un pistolar beat intra intr-o carciuma, scoate pistoalele, se indreapta spre bar, priveste barmanul si spune:\n" +
                    "– Daca misti, esti mort!\n" +
                    "Barmanul, scarbit de viata, raspunde:\n" +
                    "– Esti idiot, daca misc sunt viu…" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 24) {
            glumec.setText("O planeta trecea pe langa planeta Pamant si o intreaba:\n" +
                    " -Ce mai faci, soro? Nu te-am vazut de mult!\n" +
                    "La care Pamantul zice:\n" +
                    " -Nu prea bine, stii am Homo Sapiens.....\n" +
                    " La care cealalta zice:\n" +
                    "-Nu te ingrijora, o sa treaca...." + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 25) {
            glumec.setText("O doamna si-a pierdut poseta in agitatia de la cumparaturi. A fost gasita de catre un baietel cinstit, care i-a returnat-o. Uitandu-se in poseta, doamna a observat:\n" +
                    "- Hmmm,… cand mi-am pierdut poseta aveam o bancnota de 100 de lei. Acum am 10 bancnote de 10 lei.\n" +
                    "Baietelul a raspuns repede:\n" +
                    "- Aveti dreptate doamna. Ultima data cand am gasit poseta unei doamne, nu avea maruntis pentru rasplata." + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 26) {
            glumec.setText("-Oare de ce piratii aveau carlige in loc de maini ?\n" +
                    "-Pai dadeau mana cu alti pirati si le smulgeau mainile \n" +
                    "-Dar de ce le lipsea un ochi la fiecare pirat ?\n" +
                    "-Se frecau cu carligul la ochi ! ");
        }
        if (numba1 == 27) {
            glumec.setText("Mama lui Bula ii verifica adesea temele lui Bula.\n" +
                    "Dar intr-o zi la matematica gasi o pagina libera.\n" +
                    "– Dar, n-ai scris nimic pe aceasta pagina!\n" +
                    "– Mama, aceasta pagina este de calcul cu mintea!");
        }
        if (numba1 == 28) {
            glumec.setText("Doi betivi se intalnesc pe strada la care unul intreaba:\n" +
                    "– Nu te supara, acolo pe cer este soarele sau luna?\n" +
                    "– Nu stiu ca nu sunt din cartierul asta.");
        }
        if (numba1 == 29) {
            glumec.setText("Intr-un bar, la o ora inaintata, un tip marcat de numarul de pahare scoate un ragait gospodaresc.\n" +
                    "O doamna de langa el ii replica jignita:\n" +
                    "– Nu ti-e rusine sa ragai asa in fata unei doamne?\n" +
                    "– Ma scuzati, n-am stiut ca era randul dumneavoastra!" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 30) {
            glumec.setText("Cele 7 \"minuni\" din Caracal:\n" +
                    "-s-a construit un bloc si s-a uitat macaraua in interior\n" +
                    "-a luat foc sediul pompierilor\n" +
                    "-s-a furat usa politiei\n" +
                    "-brutaria e construita pe strada foametei\n" +
                    "-cimitirul e pe strada reinvierii\n" +
                    "-exista o singura scoala si se numeste Scoala nr. 2\n" +
                    "-puscaria e pe strada Libertatii;" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 31) {
            glumec.setText("O conversaţie intre doi psihiatri:\n" +
                    "- Cum crezi, colega, daca vorbesti cu pisica - aceasta este paranoia sau nu?\n" +
                    "- Nu, nu e paranoia. Paranoia este atunci, cand, discutand cu pisica, ti-e frica sa nu spui ceva in plus.");
        }
        if (numba1 == 32) {
            glumec.setText("Doi politisti la o cofetarie, se aseaza in fata unei oglinzi.\n" +
                    "Unul din ei zice:\n" +
                    "– Uite, ba, doi colegi de-ai nostri!\n" +
                    "Hai sa-i salutam.\n" +
                    "– Bine, zice celalalt, ridicandu-se in picioare.\n" +
                    "La care celalalt face:\n" +
                    "– Ba, desteptule, tu nu vezi ca si ei vor sa vina la noi!!" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 33) {
            glumec.setText("– George, pe unde ai umblat?\n" +
                    "– Am fost într-o clinică unde îți taie cheful de fumat.\n" +
                    "– Păi eu văd că fumezi!\n" +
                    "– Da, dar fără chef.");
        }
        if (numba1 == 34) {
            glumec.setText(" John, adu-mi te rog pianul!\n" +
                    "- Doriti sa cantati, Sir?\n" +
                    "- Nu, dar mi-am uitat telefonul pe pian si nu vreau sa te deranjez pentru un fleac!");
        }
        if (numba1 == 35) {
            glumec.setText("La psihiatru:\n" +
                    "– Am fost săptămâna trecută la dumneavoastră…\n" +
                    "– Da, îmi amintesc, spuneaţi că vedeţi multe muşte, aşa, ca prin ceaţă.\n" +
                    "– Da, da! Şi mi-aţi dat nişte pilule!\n" +
                    "– Ei, au avut efect?\n" +
                    "– Da, săru-mâna, dom’ doctor, acum le văd clar de tot, fiecare piciorus!" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 36) {
            glumec.setText("Politistul catre sofer:\n" +
                    "- Va rog, sa coborati din masina !\n" +
                    "- Sunt prea beat, urca tu !");
        }
        if (numba1 == 37) {
            glumec.setText("Un baietel plangea in fata unei porti.\n" +
                    "Un trecator isi face mila de el si il intreaba:\n" +
                    "– De ce plangi copile??\n" +
                    "– Plang ca sunt prea mic … si nu ajung la sonerie…\n" +
                    "Omul foarte amabil ia copilul in brate, iar acesta suna la usa.\n" +
                    "In momentul in care il pune jos , baietelul spune razand…:\n" +
                    "– Merci … si acum sa fugiiiiiiim…" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 38) {
            glumec.setText("Intr-un spital de nebuni, doctorul face o vizita. Toti se agitau, doar unul era linistit. Doctorul se duce si-l intreba:\n" +
                    "– Ce faci?\n" +
                    "– Scriu o scrisoare.\n" +
                    "– Cui?\n" +
                    "– Mie.\n" +
                    "– Cum, tie?!\n" +
                    "– Da, mie.\n" +
                    "– Si ce scrie in ea?\n" +
                    "– Nu stiu, ca abia maine o primesc." + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 39) {
            glumec.setText("Un politist se intalneste cu un betiv care statea intins pe jos.\n" +
                    "- Bai omule, de ce nu te duci acasa?\n" +
                    "- Nu pot sa ma misc de aici. Pe sticla de vin pe care am luat-o scria: \"A se pastra culcat\".");
        }
        if (numba1 == 40) {
            glumec.setText("Intra un tip intr-un magazin si intreaba tare pe vanzatoare:\n" +
                    "- Chibrituri aveti?\n" +
                    "Vanzatoarea:\n" +
                    "- Aud, aud, nu strigati asa! Cu filtru sau fara?");
        }
        if (numba1 == 41) {
            glumec.setText("Pe un santier, vine o comisie în inspectie. Seful de santier le spune lucratorilor:\n" +
                    "- Orice s-ar întâmpla, reactionati în asa fel de parca asa trebuia sa fie.\n" +
                    "Vine comisia, priveste. Deodata, cade un perete.\n" +
                    "Un lucrator, bucuros, se uita la ceas:\n" +
                    "- Zece si treizeci. Exact dupa grafic!" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 42) {
            glumec.setText("Trei candidati dau examenul de conducere la scoala de soferi.\n" +
                    "Instructorul care ii examineaza ii intreaba:\n" +
                    "-Fiecare sa-si imagineze ca este la munte si ruleaza pe un drum ingust cu 80 km/h. In stanga e muntele, in dreapta e prapastia. Deodata apar in fata o tanara si o batranica. Ce calcati?\n" +
                    "-Baba, ca e pacat de pustoaica, raspunde primul\n" +
                    "-Fata, ca mai are sanse desupravietuire dupa accident, raspunde al doilea\n" +
                    "-Pe amandoua, ca orice viraj e periculos in aceste conditii, zice si al treilea.\n" +
                    "-Sunteti picati toti,tipa instructorul exasperat, FRANA trebuie calcata! " + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 43) {
            glumec.setText("Plutonierul:\n" +
                    "– Ostaş, poţi să înoţi?\n" +
                    "Ostaşul:\n" +
                    "– Pot, să trăiţi!\n" +
                    "Plutonierul:\n" +
                    "– Şi unde ai învăţat să înoţi?\n" +
                    "Ostaşul:\n" +
                    "– În apă, dom’ plutonier!" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 44) {
            glumec.setText("Intr-o seara, un taran se plimba prin cimitir. Nefiind atent, cade intr-o groapa.\n" +
                    "Omul incepe sa strige:\n" +
                    "- Ajutor!!!, Ajutooor!, Imi este frig!\n" +
                    "La care, apare un betiv si acoperind groapa spune:\n" +
                    "- Pai daca te-ai dezvelit!" + ". \n" + ". \n");
        }
        if (numba1 == 45) {
            glumec.setText("Clasa de maghiari la ora de limba romana.\n" +
                    "- Gyury, spune, te rog, o propozitie!\n" +
                    "- Duminica me duc la pedure.\n" +
                    "- Gyury draga, da nu-i bine.\n" +
                    "- Atunci nu me duc.");
        }
        if (numba1 == 46) {
            glumec.setText("La doctor pacientul întreabă:\n" +
                    "– Doctore, s-a mai vindecat vreodată cineva de Alzheimer?\n" +
                    "– Nu, niciodată!\n" +
                    "După câteva secunde, pacientul continuă:\n" +
                    "– Dar de Alzheimer?" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 47) {
            glumec.setText("Un nebun se hotărăște să sară de pe bloc. Cade într-un copac, după care, plin de sânge , aterizează pe ciment. Imediat se strânge lumea. Întreabă unul:\n" +
                    "– Ce s-a întâmplat? La care nebunul, cu ultimele puteri, zice: – Nu știu, că abia am sosit și eu.");
        }
        if (numba1 == 48) {
            glumec.setText("Incendiu în hotel. Toţi ies pe hol şi strigă: \"Apă!, Apă!, Apă! Urgent!\"\n" +
                    "În timpul ăsta, iese un rus beat:\n" +
                    "- Şi în camera 30, o vodkă VĂ ROG!");
        }
        if (numba1 == 49) {
            glumec.setText("La pshiatru: \n" +
                    "- Stiti, vad in viitor.\n" +
                    "- De cand?\n" +
                    "- De joia de peste trei saptamani.");
        }
        if (numba1 == 50) {
            glumec.setText("I-am spus psihiatrului meu că sunt trist, întrucât pe mine toată lumea mă detestă. Mi-a răspuns să nu fiu penibil, deoarece nici nu m-am întâlnit încă cu toată lumea...");
        }
        if (numba1 == 51) {
            glumec.setText("La spitalul de nebuni sunt interzise telefoanele mobile.\n" +
                    "De fapt, nici nu vad la ce le-ar putea folosi... Toti au cate un fix.");
        }
        if (numba1 == 52) {
            glumec.setText("Intr-un ospiciu de nebuni se vopsesc pereti in rosu.\n" +
                    "A doua zi toti pereti jupiti.\n" +
                    "Ziua urmatoare doctorii vopsesc peretii in galben, povestea se repeta , peretii jupiti.\n" +
                    "Se decid doctarii si vopsesc pereti in verde. Trece o saptamana si nimic, peretii intacti.\n" +
                    "Doctorii curiosi intreaba un nebun de ce nu au mai jupit pereti, la care nebunu raspunde \n" +
                    "- Asteptam sa se coaca !" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 53) {
            glumec.setText("Un nebun se uita la tv la un show politic si zice : \n" +
                    "- Noroc ca m-am nascut nebun ca altfel o luam razna!");
        }
        if (numba1 == 54) {
            glumec.setText("Un nebun la brutarie: \n" +
                    "- Domnule, a iesit painea din cuptor? \n" +
                    "- Da. \n" +
                    "- Si la ce ora se intoarce?");
        }
        if (numba1 == 55) {
            glumec.setText("Directorul unui ospiciu a observat că unul din pacienţii săi avea în fiecare dimineaţă zgârâieturi proaspete pe faţa şi îi cere explicaţii. \n" +
                    "- Am facut pariu cu prietenul meu că pot trece pe sub linia trasă cu creta pe podea. \n" +
                    "Incerc asta de câteva zile şi încă nu am reuşit." + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 56) {
            glumec.setText("Un elefant si un soricel vor sa faca patinaj pe un lac. Zice soricelul: \n" +
                    "- Ma duc eu inainte, sa vad daca tine gheata!");
        }
        if (numba1 == 57) {
            glumec.setText("- Ajutor, prindeti-l !! striga femeia cangur. Mi-a furat copilasul!\n" +
                    "- Cine? Cine?... strigara in cor celelalte animale.\n" +
                    "- Un hot de buzunare, fireste!");
        }
        if (numba1 == 58) {
            glumec.setText("Eu: Câine, ce-i lipseşte acestui cal?\n" +
                    "Câinele: Ham!");
        }
        if (numba1 == 59) {
            glumec.setText("Cica era o familie de râme: mama-râma, baietelul-râma, fetita-râma. Si se pregatesc ei de cina, pun masa etc. si când sa se apuce de mâncat, fatita-râma o intreaba pe ma-sa: \n" +
                    "- Da' taticu unde e ?\n" +
                    "La care ma-sa: \n" +
                    "- La pescuit !" + ". \n" + ". \n");
        }
        if (numba1 == 60) {
            glumec.setText("– Ce îi spune găina cocoșului când acesta face omletă?\n" +
                    "– Nenorocitule, iar bați copiii?");
        }
        if (numba1 == 61) {
            glumec.setText("Puiul de camila discuta cu mama lui.\n" +
                    "- Mama, de ce avem noi cocoase?\n" +
                    "- Sa ne facem provizii de apa, cand traversam desertul.\n" +
                    "- Mami, de ce avem noi picioare asa de lungi?\n" +
                    "- Ca sa nu ne scufundam in nisip.\n" +
                    "- Mami, de ce avem noi gene asa de lungi?\n" +
                    "- Ca sa nu ne intre nisipul in ochi, cand e furtuna de nisip.\n" +
                    "- Mami, atunci de ce mai locuim la zoo?" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 62) {
            glumec.setText("Doi carnivori, tatal si fiul\n" +
                    "Fiul il intreaba p tata: \n" +
                    "- tata uite un avoin, putem sa. l mancam?\n" +
                    "tatal: \n" +
                    "- Nu fiule, doar miezul la avion");
        }
        if (numba1 == 63) {
            glumec.setText("Un tip speriat intră într-un restaurant: \n" +
                    "- Al cui este pitbull-ul de la intrare?\n" +
                    "Un tip îi răspunde plictisit: \n" +
                    "- Este al meu, care-i problema?\n" +
                    "- Sunt dezolat, dar caniche-ul meu tocmai l-a ucis pe al dv.\n" +
                    "- Imposibil, cainele meu să fie omorat de un caniche... Mă faceţi să rad. Cum se poate ca o javră prăpădită să-i facă asta fiarei mele?\n" +
                    "- Cred că pitbull-ul dv. s-a înecat în timp ce îmi manca caniche-ul." + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 64) {
            glumec.setText("Cainele care latra, nu musca\"... ar zice romanul.\n" +
                    "Da, dar nici gust n-are... ar zice chinezul.");
        }
        if (numba1 == 65) {
            glumec.setText("Azi-dimineata m-am trezit ca tipa un politist la mine : \n" +
                    "- Bai ! Tu câte clase ai ?!\n" +
                    "- Două clase ...\n" +
                    "- Băi , dar prost mai esti ! N-ai fost in stare sa faci nici măcar patru clase ca mine ! Ha ! Ha ! Ha ! Ha ! Ha ! \n" +
                    "- Așa e , nenea polițist , dar eu nu am decât opt anișori !" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 66) {
            glumec.setText("-Buna seara, agent Popescu! Am observat ca ati condus haotic. Ati consumat bauturi alcoolice?\n" +
                    "- Nuuuu... nu... nu.\n" +
                    "- Numele dumneavoastra?\n" +
                    "- Petrica!\n" +
                    "- Prezentati-mi actele domnule Petrica!\n" +
                    "- Stati ca nu mai stiu unde le-am pus... Tineti berea asta pana le caut prin masina..." + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 67) {
            glumec.setText("Politistul: \n" +
                    "- Camionul Dv. este supraincarcat. Sunt nevoit sa va iau permisul de conducere.\n" +
                    "-Cum asa?? Permisul cantareste sub 50 de grame!");
        }
        if (numba1 == 68) {
            glumec.setText("Intr-un trib de canibali: \n" +
                    "- Sefu', il punem la gratar? intreba un canibal, tinand de gat un tip pricajit, legat fedeles si care tremura ca varga. \n" +
                    "- Pune-l, pune-l! raspunse sefu'. Dar mai intai jupoaie-l, continua el. Stii ca nu-mi place pielea de gaina..." + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 69) {
            glumec.setText("Gigel era canibal. Familia sa il duse la doctor. Vin acasa. Mama il intreaba: \n" +
                    "Gigel, cum ti sa parut doctorul ? \n" +
                    "Gigel spune: Delicioooos!" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 70) {
            glumec.setText("Un englez, un francez si un țigan capturați pe insula canibalilor.Șeful de trib le dă fiecăruia câte o șansă să se salveze dacă îi spun un cuvânt în engleză pe care el să nu-l știe. \n" +
                    "Englezul: Chair. \n" +
                    "- Scaun, la oala cu el ! \n" +
                    "Francezul: French fries ! \n" +
                    "- Cartofi prajiți, la oala si cu ăsta ! \n" +
                    "Vine și țiganu: Burterflyli ! \n" +
                    "Stă șefu de trib o oră, două, își ia un dicționar, dar tot nimic.Într-un final îi spune țiganului că e liber sa plece, dar să-i traduca si lui ce a spus. \n" +
                    "La care țiganu: fluturili șefu, fluturili" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 71) {
            glumec.setText("Bulă este prins de un trib de canibali. Este legat şi este pregătit pentru cină. \n" +
                    "Disperat, Bulă începe să se roage în gând. \n" +
                    "- Sunt în mare pericol. Doamne, ajută-mă! \n" +
                    "Pe când se ruga, aude o voce care-i spune: \n" +
                    "- Stai liniştit, că nu eşti în mare pericol. Când vine şeful de trib, loveşte-l între picioare câţi poţi de tare. \n" +
                    "Vine şeful de trib. Bulă îl loveşte cu toată puterea între picioare. Şeful de trib cade lat, la care se aude din nou vocea: \n" +
                    "- Abia acum eşti în mare pericol" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 72) {
            glumec.setText("Un tip merge la banca. Tanti de la ghiseu il intreaba:\n" +
                    "- Cum va numiti?\n" +
                    "- Po-po-popa Ma-ma-marin.\n" +
                    "- Sunteti balbait?\n" +
                    "- Nu, tata a fost iar functionarul era un dobitoc.");
        }
        if (numba1 == 73) {
            glumec.setText("Pe un trotuar, un tip isi taraie cu greu piciorul… De la coltul strazii apare brusc un alt tip, care isi taraie si el piciorul… Cand ajung unul in dreptul celuilalt, primul intreaba:\n" +
                    "- Vietnam?\n" +
                    "Atunci, celalalt raspunde:\n" +
                    "- Nu!… Niste rahat de caine, de pe strada cealalta!…");
        }
        if (numba1 == 74) {
            glumec.setText("-Chelner, mi-ai servit o gaina batrana.\n" +
                    "-De unde stiti ca era batrana?\n" +
                    "-Dupa dinti!\n" +
                    "-Dar gaina nu are dinti!\n" +
                    "-Ea nu, dar eu aveam!");
        }
        if (numba1 == 75) {
            glumec.setText("Care-i cel mai lung autoturism din lume ?\n" +
                    "* Trabantul , are 3 m lungime si 4 m fumul .\n" +
                    "\n" +
                    "Ce se intampla cu un Trabant cand proprietarul ii face plinul ?\n" +
                    "* Isi dubleaza valoarea . \n" +
                    "\n" +
                    "Cand atinge Trabantul viteza maxima ?\n" +
                    "* In cadere libera ; in cazul in care nu penduleaza ca o frunza" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 76) {
            glumec.setText("Se aude ca undeva in Romania se afla un lac in care daca intra un handicapat, pe\n" +
                    "partea cealalta iese vindecat.\n" +
                    "Apare un orb:\n" +
                    "– Unde-i lacul? Unde-i lacul ?\n" +
                    "Intra in el… iese pe partea cealalta:\n" +
                    "– Dumnezeule vad !!! Vad !!!\n" +
                    "Apare si un surd:\n" +
                    "– Unde-i lacul? Unde-i lacul ?\n" +
                    "Intra si el… iese pe partea cealalta:\n" +
                    "– Dumnezeule aud !!! Aud !!!\n" +
                    "Apare si un olog in carucior cu rotile:\n" +
                    "– Unde-i lacul ? Unde-i lacul ?\n" +
                    "Intra si el…iese pe partea cealalta:\n" +
                    "– Dumnezeule… am cauciucuri noi !!! Am cauciucuri noi !!!" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 77) {
            glumec.setText("In curtea spitalului toti nebunii se urcau pe un stalp.\n" +
                    "Cand coborau toti ziceau:\n" +
                    "– „ASA E”.\n" +
                    "Doi doctori vazandu-i ii intreaba ce au.\n" +
                    "Nebunii:\n" +
                    "– Nimic.\n" +
                    "Se suie si un doctor, se da jos si zice „ASA E”.\n" +
                    "Doctorul celalalt il intreaba ce e?\n" +
                    "La care doctorul ii zice:\n" +
                    "– Stii ce scrie ba in varf?\n" +
                    "– „AICI SE TERMINA STALPU”!" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 78) {
            glumec.setText("Mistreţul neprietenos se plimba cu bicicleta. Iepuraşul alerga pe lângă el:\n" +
                    "– O să cazi, o să cazi!\n" +
                    "Deodată, mistreţul cade într-o groapă. Iepuraşul îi strigă:\n" +
                    "– Ai văzut, ai văzut?\n" +
                    "Din groapă se aude o voce răguşită:\n" +
                    "– Parchez unde vreau eu, da?" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 79) {
            glumec.setText("Cica un irlandez, un mexican si un blond erau muncitori pe un santier, undeva la etajul 20, si vine pauza de masa.\n" +
                    "Irlandezul isi deschide punga cu mancare si zice: „Din nou varza si carne de vaca! M-am saturat!\n" +
                    "Daca si maine tot asta gasesc in punga, ma arunc!”.\n" +
                    "Mexicanul deschide punga si zice: „Din nou tacos! M-am saturat de tacos! Daca maine gasesc tot tacos, ma arunc!”\n" +
                    "Blondul: „Din nou lasagna! M-am saturat! Daca maine e la fel, ma arunc”.\n" +
                    "A 2-a zi, irlandezul are exact aceeasi mancare, se arunca si moare, mexicanul se arunca si moare si el, blondul idem, se arunca si moare.\n" +
                    "La inmormantare: nevasta irlandezului: „Daca stiam ca nu-i place, i-as fi gatit altceva!”, nevasta mexicanului: „As fi putut sa-i dau tortillas,\n" +
                    "chilli peppers sau altceva! Daca as fi stiut!”.\n" +
                    "Acum toata lumease uita la nevasta blondului…si se uita…si se uita… la care nevasta blondului\n" +
                    "zice: „De ce va uitati ma la mine?! El isi face singur pachetul!”" + ". \n" + ". \n" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 80) {
            glumec.setText("Trei nebuni faceau galagie intr-un avion. Pilotul ii spune copilotului: -Du-te sa vezi ce e cu ei. Copilotul vorbeste cu nebunii si se intoarce in carlinga. Pilotul il intreaba: -Ce ai facut de i-ai linistit? -Ne-am jucat de-a scoala si i-am trimis sa-si faca temele. Dupa cinci minute, nebunii incep din nou sa faca galagie si pilotul ii spune copilotului: -Du-te sa vezi ce mai vor de data asta. Copilotul se duce la ei si cand se intoarce pilotul il intreaba: -Ce ai facut? -Le-am corectat temele si deoarece le facusera bine, le-am deschis usa si au iesit toti in pauza!");
        }
        if (numba1 == 81) {
            glumec.setText("O coada lunga la un magazin in padure. De zile intregi magazinul nu a fost deschis. Iepurasul, bine dispus, imbracat la costum, cu un diplosat in mana, se indreapta spre magazin. Ajunge pe la sfarsitul cozii, il vede vulpea, care era acolo, ca se baga in fata si-l prinde:\n" +
                    "– Stai si tu la coada, asa cum facem toti, nu te mai baga in fata.\n" +
                    "Apoi il tranteste de un copac. Saracul iepuras se scutura, isi revine si apoi porneste mai departe. Ajunge langa lup, care era pe la mijlocul cozii. Si acesta il prinde, il scutura, apoi il tranteste de un copac. Cu greu se reculege iepurasul. Revine cumva si merge mai departe. Ajunge langa urs, care era chiar in fata. Il injura ursul de nu se poate, il mai si bate bine. Cu un ultim efort, se scola iepurasul si foarte nervos striga:\n" +
                    "– No, bine. Daca nu vreti voi, nici astazi nu deschid." + ". \n" + ". \n");
        }
        if (numba1 == 82) {
            glumec.setText("Doi francezi, aflati in Anglia, nu avusesera ocazia sa vada deloc soarele in doua saptamani. Ca sa se dumireasca, l-au intrebat pe receptionerul de la hotel:\n" +
                    "– Pe aici ploua des?\n" +
                    "– Cam de doua ori pe an, domnule.\n" +
                    "– Si cat tine?\n" +
                    "– Cam sase luni…");
        }
        if (numba1 == 83) {
            glumec.setText("Dupa decolare capitanul avionului se adreseaza pasagerilor:\n" +
                    "– Doamnelor si domnilor, va vorbeste capitanul. Am ajuns la inaltimea corespunzatoare, timpul este favorabil, viteza… O, la dracu!\n" +
                    "Pasagerii incremeniti stau pe locurile lor. Dupa câteva momente capitanul se adreseaza iar pasagerilor:\n" +
                    "– Va rog sa ma iertati, din greseala am varsat cafeaua pe mine. Ar trebui sa vedeti cum arata pantalonul in fata.\n" +
                    "La care un pasager:\n" +
                    "– Iar al meu in spate!" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if (numba1 == 84) {
            glumec.setText("– Sunt de zece zile in Tulcea si regret ca nu am venit din prima zi in restaurantul dumneavoastra.\n" +
                    "– Multumim, domnule, ne maguliti.\n" +
                    "– Nu, vreau sa spun ca as fi preferat sa mananc stiuca asta acum zece zile.");
        }
        if (numba1 == 85) {
            glumec.setText("O pisica hipioata trecea strada. O batranica o vede si striga dupa ea:\n" +
                    "– Pis, pis, pis…\n" +
                    "La care pisica raspunde, ridicand doua degete:\n" +
                    "– Peace, maica, peace!");
        }
        if (numba1 == 86) {
            glumec.setText("– Buna ziua!\n" +
                    "– Buna ziua, domnule politist!\n" +
                    "– Dumneata, tinere domn, pe gheata asta conduci cu 80 km pe ora? Vrei sa ajungi la spital?\n" +
                    "– Da!\n" +
                    "– Bravo, frumos raspuns! Esti smecher?\n" +
                    "– Nu! Sunt doctor!");
        }
        if (numba1 == 87) {
            glumec.setText("Pasagerul unui avion marturiseste:\n" +
                    "– Imi vine asa sa vomit!\n" +
                    "La care stewardesa prompta:\n" +
                    "– Va aduc intr-o secunda o punga!\n" +
                    "– Dar de ce? Credeti ca vreau sa iau chestia asta acasa?");
        }
        if (numba1 == 88) {
            glumec.setText("Doi ciobani merg la un restaurant mediteranean. Dupa ce citesc meniul il intreaba pe chelner:\n" +
                    "– Dom’le draga, ce is acelea fructe de mare?\n" +
                    "– Caracatita, calamar, rac, creveti, raspunde chelnerul.\n" +
                    "– Apoi bag de seama, zice unul dintre ciobani, dupa cum zici dumneata, vulpea, ursul si lupu’ is fructe de padure!\n" +
                    " ");
        }
        if (numba1 == 89) {
            glumec.setText("a FBI se fac angajari. La interviu se prezinta trei tipi. Interviul are loc in biroul sefului FBI. Intra primul – sa zicem John. Seful FBI ii da un pistol si ii spune:\n" +
                    "– In biroul de alaturi se afla sotia ta. Intra si impusc-o.\n" +
                    "– Nici nu ma gandesc, zice tipul si pleaca.\n" +
                    "Intra al doilea candidat – Jim. Istoria se repeta: seful FBI ii da pistolul si-l invita sa-si impuste nevasta. Dupa 10 minute, tipul se hotaraste ca nevasta-sa e mai importanta decat job-ul la FBI si pleaca.\n" +
                    "Intra ultimul – Tom. Acesta ia pistolul si este de acord sa-si impuste nevasta. Intra in birou iar seful FBI aude 6 impuscaturi, bubuituri si strigate. Tom iese afara dupa o vreme, plin de sange si spune:\n" +
                    "– Nu stiu ce idiot a pus gloante oarbe in pistol… A trebuit s-o omor cu scaunul.\n" +
                    " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + ". \n" + ". \n");
        }
        if (numba1 == 90) {
            glumec.setText("Trecatorii privesc cu nedumerire la un individ care sta nemiscat, cu urechea lipita de asfalt. Un cetatean mai curios nu se poate abtine si pune, de asemenea, urechea la pamant, asculta concentrat cateva secunde bune, apoi remarca:\n" +
                    "– Nu se aude absolut nimic!\n" +
                    "Celalalt ridică ochii, il priveste si-i raspunde:\n" +
                    "– Da, si partea nasoala este ca o tine asa de azi dimineata!");
        }
        if (numba1 == 91) {
            glumec.setText("Doctorul stomatolog ii spune, revoltat, pacientului:\n" +
                    "– Hei, aceste bancnote sunt false!\n" +
                    "La care pacientul ii raspunde calm:\n" +
                    "– Dar dintii pe care mi i-ati pus sunt adevarati?");
        }
        if (numba1 == 92) {
            glumec.setText("Cioc ! Cioc!\n" +
                    "– Cine e ?\n" +
                    "– Zana cea buna!!!\n" +
                    "– Si de ce ai un topor??\n" +
                    "– Nu sunt bine dispusa azi.\n" +
                    " ");
        }
        if (numba1 == 93) {
            glumec.setText("Un tanar cu tatal lui se urca intr-un tramvai foarte aglomerat. Tanarul ii zice tatalui:\n" +
                    "– Mai, tata, mai bine luam un taxi, nu vezi ce aglomerat este tramvaiul asta?\n" +
                    "– Mai lasa-ma in pace, daca erai la discoteca ziceai ca este atmosfera.");
        }
        if (numba1 == 94) {
            glumec.setText("Pe Transfagarasan urca o masina in marsarier. Un politist ii intreaba:\n" +
                    "– De ce urcati pe traseul asta atat de periculos cu spatele?\n" +
                    "– Ne-am gandit ca daca sus nu gasim loc de intors, vom putea veni la coborare cu fata.\n" +
                    "Dupa un timp, masina coboara Transfagarasanul tot in marsarier.\n" +
                    "– Si acum de ce coborati Transfagarasanul cu spatele?\n" +
                    "– Am gasit loc de intors…");
        }
        if (numba1 == 95) {
            glumec.setText("– Melcule, unde fugi asa repede? intreaba ursul\n" +
                    "– Ma cauta DNA sa ma aresteze.\n" +
                    "– De ce?\n" +
                    "– Eu am casa, mama casa, tata casa, fratele meu are casa…\n" +
                    "Ursul incepe sa fuga si el dupa ce s-a gandit un pic la ce a spus melcul. Pe drum se intalneste cu cocostarcul.\n" +
                    "– Ursule, de ce fugi?\n" +
                    "– Ma cauta DNA sa ma aresteze. Eu am blana, mama are blana, tata are si el blana…\n" +
                    "Se gandeste cocostarcul si se pune si el pe fuga. Se intalneste cu maimuta care il intreaba:\n" +
                    "– Cocostarcule, ce-ai patit de fugi asa de tare?\n" +
                    "– Fug sa nu ma aresteze DNA-ul. Eu traiesc pe picior mare, mama traieste pe picior mare, tata la fel…\n" +
                    "Fara sa gandeasca, maimuta se pune si ea pe fuga. Cand oboseste se opreste si-si spune:\n" +
                    "– Eu de ce fug? Eu sunt in fundul gol, mama e in fundul gol, tata e in fundul gol, bunicii la fel" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! . \n" + ". \n");
        }
        if (numba1 == 96) {
            glumec.setText("La psihiatru venea un pacient care-i povestea ingrozit ca in fiecare seara iese de sub patul lui un crocodil care vrea sa-l manance. Medicul i-a dat medicamente din ce in ce mai puternice, pana cand omul n-a mai aparut. Curios, i-a luat adresa din registru si s-a dus sa-l viziteze. A sunat insa degeaba la usa, pana a iesit un vecin.\n" +
                    "– Stiti ceva despre Ionescu? a intrebat psihiatrul.\n" +
                    "– O, da, o tragedie… L-a mancat un crocodil!");
        }
        if (numba1 == 97) {
            glumec.setText("Condamnatul este adus in camera de executie. Priveste scaunul electric de care sunt legate tot felul de fire si intreba:\n" +
                    "– Cum se cheama dracovenia asta?\n" +
                    "Directorul inchisorii ii raspunde:\n" +
                    "– Nu-ti bate capul cu intrebari, o sa te punem imediat la curent.");
        }
        if (numba1 == 98) {
            glumec.setText("– Ieri eram putin cherchelit si-am bagat cheia masinii in broasca usii de la bloc.\n" +
                    "– Si atunci?\n" +
                    "– Atunci blocul s-a pus in miscare.");
        }
        if (numba1 == 99) {
            glumec.setText("Doi batrani discuta. Zice unul:\n" +
                    "– Si am fost aseara la un resturant superb. Mancarea a fost deosebit de gustoasa, muzica buna, servirea exceptionala…\n" +
                    "– Care-i numele restaurantului? intreaba celalalt.\n" +
                    "– Vai ce-mi scapa, zi un nume de floare… Poate…\n" +
                    "– Liliac!\n" +
                    "– Nu…\n" +
                    "– Viorele!\n" +
                    "– Nu, nu…\n" +
                    "– Rose!\n" +
                    "– Asta e. Roza! Care-i numele restaurantului la care am fost aseara?" + ". \n" + ". \n");
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
        int numba1 = rodrigo.nextInt(100);

        a1++;
        ara[a1]=numba1;
        if(a1>=5) {

            while (numba1 == ara[a1 - 2] || numba1 == ara[a1 - 3] ) {
                if (numba1 == 0) {
                    numba1++;
                } else
                    numba1 = numba1 - 1;

            }
        }

        if(numba1==0){
            glumec.setText("Musafirii, la iesirea din restaurant: \n" +
                    "- Pacat ca nu am ajuns la dv. mai curand!\n" +
                    "- Ne bucuram ca v-a placut!\n" +
                    "- Nu ne-a placut deloc- dar daca ajungeam mai repede, poate ca era carnea proaspata inca...") ;
        }
        if(numba1==1){
            glumec.setText("O gâscă într-un bar: \n" +
                    "- Aveți mămăligă? întreabă gâsca.\n" +
                    "- Nu, răspunde barmanul.\n" +
                    "- Sigur?\n" +
                    "- Nu, nu avem, n-auzi...?!?\n" +
                    "- Sigur, sigur ?\n" +
                    "- Dacă mai întrebi o dată, iau un cui și un ciocan și-ți prind ciocul de tejghea....!\n" +
                    "- Aveți cuie?\n" +
                    "- Nu....\n" +
                    "- Dar mămăligă...???"+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!") ;
        }
        if(numba1==2){
            glumec.setText("A intrat o pisicuţă într-o încăpere.\n" +
                    "- Miauuu !\n" +
                    "Toţi şoarecii s-au ascuns .\n" +
                    "După un timp , pisicuţa : \n" +
                    "- Ham , ham !\n" +
                    "Toţi şoarecii au ieşit din ascunzători.\n" +
                    "Morala : \n" +
                    "\"Întotdeauna este bine să stii o limbă străină“") ;
        }
        if(numba1==3){
            glumec.setText("– Bunicule ce sunt alea?\n" +
                    "– Cirese negre.\n" +
                    "– Si de ce sunt rosii?\n" +
                    "– Pentru ce sunt inca verzi!") ;
        }
        if(numba1==4){
            glumec.setText("Excursie la centrala atomica de la Cernavoda.\n" +
                    "In spatele unui geam doi angajati, in costume de protectie, duc cu atentie un tub mic.\n" +
                    "Unul dintre vizitatori intreaba:\n" +
                    "– Ce va fi daca vor scapa acel tub?\n" +
                    "– In principiu nimic….Pe o raza de 200 km!") ;
        }
        if(numba1==5){
            glumec.setText("Un tip statea nemiscat intr-un autobuz.\n" +
                    "La un moment dat cineva deranjat ca nu are loc de el:\n" +
                    "– Ce faci domnule?\n" +
                    "– Mimez branza.\n" +
                    "– Cum adica?\n" +
                    "– Stau si put…") ;
        }
        if(numba1==6){
            glumec.setText("– Există canibali vegetarieni?\n" +
                    "– Desigur.\n" +
                    "– Şi ce mănîncă ei?\n" +
                    "– Mărul lui Adam…") ;
        }
        if(numba1==7){
            glumec.setText("Un pictor vestit, aflat intr-o drumetie in munti, intalneste o turma si se adreseaza ciobanului;\n" +
                    "– Bade, imi dai voie sa-ti pictez oile?\n" +
                    "– Esti nebun, omule? Lasa-le asa albe cum sunt…") ;
        }
        if(numba1==8){
            glumec.setText("- Cum poti sa impiedici o camila sa treaca prin urechile acului?\n" +
                    "- O inozi la coada") ;
        }
        if(numba1==9){
            glumec.setText("Un om mergea linistit prin desert cand deodata ia o palma. Se uita in dreapta, in stanga, in spate, nimeni. Se uita in sus: senin.\n" +
                    "Mai merge ce merge si iarasi ia o palma. Se uita in dreapta, in stanga, in spate, nimeni. Se uita in sus: senin.\n" +
                    "Merge mai departe. La fel, iarasi ia o palma. Se uita in dreapta, in stanga, in spate, nimeni. Se uita in sus: senin.\n" +
                    "Si uite asa a luat trei palme din senin."+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!") ;
        }
        if(numba1==10){
            glumec.setText("- De ce tinea Mihai Viteazu securea in mana stanga?\n" +
                    "- De maner, bineinteles.") ;
        }
        if(numba1==11){
            glumec.setText("Doua broscute mergeau prin desert si se intalnesc la un moment dat in varful unei dune de nisip:\n" +
                    "- Ciao soro, unde mergi?\n" +
                    "- Aiurea, soro.\n" +
                    "- Hai pe-aici ca-i mai aproape.") ;
        }
        if(numba1==12){
            glumec.setText("Un om mergea pe strada.\n" +
                    "Dar deodata dispare..\n" +
                    "De ce?\n" +
                    "L-au ros pantofii.") ;
        }
        if(numba1==13){
            glumec.setText("In timp ce pastea, un cal inghite o lacusta. Aceasta incepe sa se agite in burta calului: \"Heeei, scoateti-ma de aici!\"\n" +
                    "Dar calul plecase..") ;
        }
        if(numba1==14){
            glumec.setText("La doctor:\n" +
                    "- Domnule doctor, cainele meu nu are nas!\n" +
                    "- Si cum miroase?\n" +
                    "- Ingrozitor..") ;
        }
        if(numba1==15){
            glumec.setText("De ce cade primul elefant din copac?\n" +
                    "Pentru ca era mort.\n" +
                    "Dar de ce cade al doilea elefant din copac?\n" +
                    "Pentru ca era legat de primul.\n" +
                    "Si de ce cade al treilea elefant din copac?\n" +
                    "Credea ca e un fel de joc si era randul lui.") ;
        }
        if(numba1==16){
            glumec.setText("Un om foarte gras statea in fata unei gradinite de copii. La un moment dat vine la el o educatoare si-l intreaba:\n" +
                    "- Nu va suparati, asteptati un copil?\n" +
                    "Ca replica, barbatul gras spune:\n" +
                    "- NU... asa sunt eu mai gras!") ;
        }
        if(numba1==17){
            glumec.setText("O vaca pastea pe asfalt.\n" +
                    "Un submarin vine si o loveste.\n" +
                    "Ce concluzie se poate trage din acest tragic accident ?\n" +
                    "\"Sa nu mancam fructe nespalate.\"") ;
        }
        if(numba1==18){
            glumec.setText("Cica, o vrabie statea pe o creanga, la care vine un pasaroi si ii spune:\n" +
                    "- Vezi ca te imping. \n" +
                    "Si a impins-o.") ;
        }
        if(numba1==19){
            glumec.setText("Ion catre Vasile:\n" +
                    "\"Intreaba-ma daca ma cheama Gheorghe!\"\n" +
                    "\"Te cheama Gheorghe?\"\n" +
                    "\"Nu\"") ;
        }
        if(numba1 ==20 ){
            glumec.setText("Intr-un magazin de carti un copil intreaba pe vanzatoare:\n" +
                    "- Aveti caiete in cerculet?.\n" +
                    "- Nu.\n" +
                    "- Dar lipici pentru clasa intai?\n" +
                    "- Nu.\n" +
                    "Un cumparator ce astepta in rand:\n" +
                    "- Baiete, du-te si nu mai incurca lumea pe aici.\n" +
                    "Baiatul pleaca. Cumparatorul spune:\n" +
                    "- Dati-mi, va rog, globul Romaniei. "+  "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
        }
        if(numba1 ==21 ){
            glumec.setText("Soldat, tu nu ma auzi?\n" +
                    "- Nu, domnule capitan.\n" +
                    "- Cum ma nu ma auzi ca doar eu ma uit la tine. ");
        }
        if(numba1 ==22 ){
            glumec.setText("O blonda la volan. La radio se aude:\n" +
                    "-Ascultati Europa FM.\n" +
                    "Blonda:\n" +
                    "-Doamne, de unde stiu astia totul?");
        }
        if(numba1 ==23 ){
            glumec.setText("In vestul indepartat, la mijloc de secol XIX, un pistolar beat intra intr-o carciuma, scoate pistoalele, se indreapta spre bar, priveste barmanul si spune:\n" +
                    "– Daca misti, esti mort!\n" +
                    "Barmanul, scarbit de viata, raspunde:\n" +
                    "– Esti idiot, daca misc sunt viu…");
        }
        if(numba1 ==24){
            glumec.setText("O planeta trecea pe langa planeta Pamant si o intreaba:\n" +
                    " -Ce mai faci, soro? Nu te-am vazut de mult!\n" +
                    "La care Pamantul zice:\n" +
                    " -Nu prea bine, stii am Homo Sapiens.....\n" +
                    " La care cealalta zice:\n" +
                    "-Nu te ingrijora, o sa treaca...."+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 25){
            glumec.setText("O doamna si-a pierdut poseta in agitatia de la cumparaturi. A fost gasita de catre un baietel cinstit, care i-a returnat-o. Uitandu-se in poseta, doamna a observat:\n" +
                    "- Hmmm,… cand mi-am pierdut poseta aveam o bancnota de 100 de lei. Acum am 10 bancnote de 10 lei.\n" +
                    "Baietelul a raspuns repede:\n" +
                    "- Aveti dreptate doamna. Ultima data cand am gasit poseta unei doamne, nu avea maruntis pentru rasplata."+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==26 ){
            glumec.setText("-Oare de ce piratii aveau carlige in loc de maini ?\n" +
                    "-Pai dadeau mana cu alti pirati si le smulgeau mainile \n" +
                    "-Dar de ce le lipsea un ochi la fiecare pirat ?\n" +
                    "-Se frecau cu carligul la ochi ! "+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==27 ){
            glumec.setText("Mama lui Bula ii verifica adesea temele lui Bula.\n" +
                    "Dar intr-o zi la matematica gasi o pagina libera.\n" +
                    "– Dar, n-ai scris nimic pe aceasta pagina!\n" +
                    "– Mama, aceasta pagina este de calcul cu mintea!");
        }
        if(numba1 ==28 ){
            glumec.setText("Doi betivi se intalnesc pe strada la care unul intreaba:\n" +
                    "– Nu te supara, acolo pe cer este soarele sau luna?\n" +
                    "– Nu stiu ca nu sunt din cartierul asta.");
        }
        if(numba1 ==29 ){
            glumec.setText("Intr-un bar, la o ora inaintata, un tip marcat de numarul de pahare scoate un ragait gospodaresc.\n" +
                    "O doamna de langa el ii replica jignita:\n" +
                    "– Nu ti-e rusine sa ragai asa in fata unei doamne?\n" +
                    "– Ma scuzati, n-am stiut ca era randul dumneavoastra!");
        }
        if(numba1 == 30){
            glumec.setText("Cele 7 \"minuni\" din Caracal:\n" +
                    "-s-a construit un bloc si s-a uitat macaraua in interior\n" +
                    "-a luat foc sediul pompierilor\n" +
                    "-s-a furat usa politiei\n" +
                    "-brutaria e construita pe strada foametei\n" +
                    "-cimitirul e pe strada reinvierii\n" +
                    "-exista o singura scoala si se numeste Scoala nr. 2\n" +
                    "-puscaria e pe strada Libertatii;"+  "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
        }
        if(numba1 == 31){
            glumec.setText("O conversaţie intre doi psihiatri:\n" +
                    "- Cum crezi, colega, daca vorbesti cu pisica - aceasta este paranoia sau nu?\n" +
                    "- Nu, nu e paranoia. Paranoia este atunci, cand, discutand cu pisica, ti-e frica sa nu spui ceva in plus.");
        }
        if(numba1 ==32 ){
            glumec.setText("Doi politisti la o cofetarie, se aseaza in fata unei oglinzi.\n" +
                    "Unul din ei zice:\n" +
                    "– Uite, ba, doi colegi de-ai nostri!\n" +
                    "Hai sa-i salutam.\n" +
                    "– Bine, zice celalalt, ridicandu-se in picioare.\n" +
                    "La care celalalt face:\n" +
                    "– Ba, desteptule, tu nu vezi ca si ei vor sa vina la noi!!"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 33){
            glumec.setText("– George, pe unde ai umblat?\n" +
                    "– Am fost într-o clinică unde îți taie cheful de fumat.\n" +
                    "– Păi eu văd că fumezi!\n" +
                    "– Da, dar fără chef.");
        }
        if(numba1 == 34){
            glumec.setText(" John, adu-mi te rog pianul!\n" +
                    "- Doriti sa cantati, Sir?\n" +
                    "- Nu, dar mi-am uitat telefonul pe pian si nu vreau sa te deranjez pentru un fleac!");
        }
        if(numba1 == 35){
            glumec.setText("La psihiatru:\n" +
                    "– Am fost săptămâna trecută la dumneavoastră…\n" +
                    "– Da, îmi amintesc, spuneaţi că vedeţi multe muşte, aşa, ca prin ceaţă.\n" +
                    "– Da, da! Şi mi-aţi dat nişte pilule!\n" +
                    "– Ei, au avut efect?\n" +
                    "– Da, săru-mâna, dom’ doctor, acum le văd clar de tot, fiecare piciorus!"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==36 ){
            glumec.setText("Politistul catre sofer:\n" +
                    "- Va rog, sa coborati din masina !\n" +
                    "- Sunt prea beat, urca tu !");
        }
        if(numba1 == 37){
            glumec.setText("Un baietel plangea in fata unei porti.\n" +
                    "Un trecator isi face mila de el si il intreaba:\n" +
                    "– De ce plangi copile??\n" +
                    "– Plang ca sunt prea mic … si nu ajung la sonerie…\n" +
                    "Omul foarte amabil ia copilul in brate, iar acesta suna la usa.\n" +
                    "In momentul in care il pune jos , baietelul spune razand…:\n" +
                    "– Merci … si acum sa fugiiiiiiim…"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 38){
            glumec.setText("Intr-un spital de nebuni, doctorul face o vizita. Toti se agitau, doar unul era linistit. Doctorul se duce si-l intreba:\n" +
                    "– Ce faci?\n" +
                    "– Scriu o scrisoare.\n" +
                    "– Cui?\n" +
                    "– Mie.\n" +
                    "– Cum, tie?!\n" +
                    "– Da, mie.\n" +
                    "– Si ce scrie in ea?\n" +
                    "– Nu stiu, ca abia maine o primesc.");
        }
        if(numba1 == 39){
            glumec.setText("Un politist se intalneste cu un betiv care statea intins pe jos.\n" +
                    "- Bai omule, de ce nu te duci acasa?\n" +
                    "- Nu pot sa ma misc de aici. Pe sticla de vin pe care am luat-o scria: \"A se pastra culcat\".");
        }
        if(numba1 == 40 ){
            glumec.setText("Intra un tip intr-un magazin si intreaba tare pe vanzatoare:\n" +
                    "- Chibrituri aveti?\n" +
                    "Vanzatoarea:\n" +
                    "- Aud, aud, nu strigati asa! Cu filtru sau fara?");
        }
        if(numba1 ==41 ){
            glumec.setText("Pe un santier, vine o comisie în inspectie. Seful de santier le spune lucratorilor:\n" +
                    "- Orice s-ar întâmpla, reactionati în asa fel de parca asa trebuia sa fie.\n" +
                    "Vine comisia, priveste. Deodata, cade un perete.\n" +
                    "Un lucrator, bucuros, se uita la ceas:\n" +
                    "- Zece si treizeci. Exact dupa grafic!");
        }
        if(numba1 == 42){
            glumec.setText("Trei candidati dau examenul de conducere la scoala de soferi.\n" +
                    "Instructorul care ii examineaza ii intreaba:\n" +
                    "-Fiecare sa-si imagineze ca este la munte si ruleaza pe un drum ingust cu 80 km/h. In stanga e muntele, in dreapta e prapastia. Deodata apar in fata o tanara si o batranica. Ce calcati?\n" +
                    "-Baba, ca e pacat de pustoaica, raspunde primul\n" +
                    "-Fata, ca mai are sanse desupravietuire dupa accident, raspunde al doilea\n" +
                    "-Pe amandoua, ca orice viraj e periculos in aceste conditii, zice si al treilea.\n" +
                    "-Sunteti picati toti,tipa instructorul exasperat, FRANA trebuie calcata!"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 43){
            glumec.setText("Plutonierul:\n" +
                    "– Ostaş, poţi să înoţi?\n" +
                    "Ostaşul:\n" +
                    "– Pot, să trăiţi!\n" +
                    "Plutonierul:\n" +
                    "– Şi unde ai învăţat să înoţi?\n" +
                    "Ostaşul:\n" +
                    "– În apă, dom’ plutonier!");
        }
        if(numba1 == 44){
            glumec.setText("Intr-o seara, un taran se plimba prin cimitir. Nefiind atent, cade intr-o groapa.\n" +
                    "Omul incepe sa strige:\n" +
                    "- Ajutor!!!, Ajutooor!, Imi este frig!\n" +
                    "La care, apare un betiv si acoperind groapa spune:\n" +
                    "- Pai daca te-ai dezvelit!"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==45 ){
            glumec.setText("Clasa de maghiari la ora de limba romana.\n" +
                    "- Gyury, spune, te rog, o propozitie!\n" +
                    "- Duminica me duc la pedure.\n" +
                    "- Gyury draga, da nu-i bine.\n" +
                    "- Atunci nu me duc.");
        }
        if(numba1 == 46){
            glumec.setText("La doctor pacientul întreabă:\n" +
                    "– Doctore, s-a mai vindecat vreodată cineva de Alzheimer?\n" +
                    "– Nu, niciodată!\n" +
                    "După câteva secunde, pacientul continuă:\n" +
                    "– Dar de Alzheimer?");
        }
        if(numba1 == 47){
            glumec.setText("Un nebun se hotărăște să sară de pe bloc. Cade într-un copac, după care, plin de sânge , aterizează pe ciment. Imediat se strânge lumea. Întreabă unul:\n" +
                    "– Ce s-a întâmplat? La care nebunul, cu ultimele puteri, zice: – Nu știu, că abia am sosit și eu."+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==48 ){
            glumec.setText("Incendiu în hotel. Toţi ies pe hol şi strigă: \"Apă!, Apă!, Apă! Urgent!\"\n" +
                    "În timpul ăsta, iese un rus beat:\n" +
                    "- Şi în camera 30, o vodkă VĂ ROG!");
        }
        if(numba1 == 49){
            glumec.setText("La pshiatru: \n" +
                    "- Stiti, vad in viitor.\n" +
                    "- De cand?\n" +
                    "- De joia de peste trei saptamani.");
        }
        if(numba1 == 50){
            glumec.setText("I-am spus psihiatrului meu că sunt trist, întrucât pe mine toată lumea mă detestă. Mi-a răspuns să nu fiu penibil, deoarece nici nu m-am întâlnit încă cu toată lumea...");
        }
        if(numba1 == 51){
            glumec.setText("La spitalul de nebuni sunt interzise telefoanele mobile.\n" +
                    "De fapt, nici nu vad la ce le-ar putea folosi... Toti au cate un fix.");
        }
        if(numba1 == 52){
            glumec.setText("Intr-un ospiciu de nebuni se vopsesc pereti in rosu.\n" +
                    "A doua zi toti pereti jupiti.\n" +
                    "Ziua urmatoare doctorii vopsesc peretii in galben, povestea se repeta , peretii jupiti.\n" +
                    "Se decid doctarii si vopsesc pereti in verde. Trece o saptamana si nimic, peretii intacti.\n" +
                    "Doctorii curiosi intreaba un nebun de ce nu au mai jupit pereti, la care nebunu raspunde \n" +
                    "- Asteptam sa se coaca !"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 53){
            glumec.setText("Un nebun se uita la tv la un show politic si zice : \n" +
                    "- Noroc ca m-am nascut nebun ca altfel o luam razna!");
        }
        if(numba1 == 54){
            glumec.setText("Un nebun la brutarie: \n" +
                    "- Domnule, a iesit painea din cuptor? \n" +
                    "- Da. \n" +
                    "- Si la ce ora se intoarce?");
        }
        if(numba1 == 55){
            glumec.setText("Directorul unui ospiciu a observat că unul din pacienţii săi avea în fiecare dimineaţă zgârâieturi proaspete pe faţa şi îi cere explicaţii. \n" +
                    "- Am facut pariu cu prietenul meu că pot trece pe sub linia trasă cu creta pe podea. \n" +
                    "Incerc asta de câteva zile şi încă nu am reuşit."+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==56 ){
            glumec.setText("Un elefant si un soricel vor sa faca patinaj pe un lac. Zice soricelul: \n" +
                    "- Ma duc eu inainte, sa vad daca tine gheata!");
        }
        if(numba1 == 57){
            glumec.setText("- Ajutor, prindeti-l !! striga femeia cangur. Mi-a furat copilasul!\n" +
                    "- Cine? Cine?... strigara in cor celelalte animale.\n" +
                    "- Un hot de buzunare, fireste!");
        }
        if(numba1 ==58 ){
            glumec.setText("Eu: Câine, ce-i lipseşte acestui cal?\n" +
                    "Câinele: Ham!");
        }
        if(numba1 == 59){
            glumec.setText("Cica era o familie de râme: mama-râma, baietelul-râma, fetita-râma. Si se pregatesc ei de cina, pun masa etc. si când sa se apuce de mâncat, fatita-râma o intreaba pe ma-sa: \n" +
                    "- Da' taticu unde e ?\n" +
                    "La care ma-sa: \n" +
                    "- La pescuit !"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 60){
            glumec.setText("– Ce îi spune găina cocoșului când acesta face omletă?\n" +
                    "– Nenorocitule, iar bați copiii?");
        }
        if(numba1 == 61){
            glumec.setText("Puiul de camila discuta cu mama lui.\n" +
                    "- Mama, de ce avem noi cocoase?\n" +
                    "- Sa ne facem provizii de apa, cand traversam desertul.\n" +
                    "- Mami, de ce avem noi picioare asa de lungi?\n" +
                    "- Ca sa nu ne scufundam in nisip.\n" +
                    "- Mami, de ce avem noi gene asa de lungi?\n" +
                    "- Ca sa nu ne intre nisipul in ochi, cand e furtuna de nisip.\n" +
                    "- Mami, atunci de ce mai locuim la zoo?"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 62){
            glumec.setText("Doi carnivori, tatal si fiul\n" +
                    "Fiul il intreaba p tata: \n" +
                    "- tata uite un avoin, putem sa. l mancam?\n" +
                    "tatal: \n" +
                    "- Nu fiule, doar miezul la avion");
        }
        if(numba1 ==63 ){
            glumec.setText("Un tip speriat intră într-un restaurant: \n" +
                    "- Al cui este pitbull-ul de la intrare?\n" +
                    "Un tip îi răspunde plictisit: \n" +
                    "- Este al meu, care-i problema?\n" +
                    "- Sunt dezolat, dar caniche-ul meu tocmai l-a ucis pe al dv.\n" +
                    "- Imposibil, cainele meu să fie omorat de un caniche... Mă faceţi să rad. Cum se poate ca o javră prăpădită să-i facă asta fiarei mele?\n" +
                    "- Cred că pitbull-ul dv. s-a înecat în timp ce îmi manca caniche-ul."+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 64){
            glumec.setText("Cainele care latra, nu musca\"... ar zice romanul.\n" +
                    "Da, dar nici gust n-are... ar zice chinezul.");
        }
        if(numba1 == 65){
            glumec.setText("Azi-dimineata m-am trezit ca tipa un politist la mine : \n" +
                    "- Bai ! Tu câte clase ai ?!\n" +
                    "- Două clase ...\n" +
                    "- Băi , dar prost mai esti ! N-ai fost in stare sa faci nici măcar patru clase ca mine ! Ha ! Ha ! Ha ! Ha ! Ha ! \n" +
                    "- Așa e , nenea polițist , dar eu nu am decât opt anișori !");
        }
        if(numba1 == 66){
            glumec.setText("-Buna seara, agent Popescu! Am observat ca ati condus haotic. Ati consumat bauturi alcoolice?\n" +
                    "- Nuuuu... nu... nu.\n" +
                    "- Numele dumneavoastra?\n" +
                    "- Petrica!\n" +
                    "- Prezentati-mi actele domnule Petrica!\n" +
                    "- Stati ca nu mai stiu unde le-am pus... Tineti berea asta pana le caut prin masina...");
        }
        if(numba1 ==67 ){
            glumec.setText("Politistul: \n" +
                    "- Camionul Dv. este supraincarcat. Sunt nevoit sa va iau permisul de conducere.\n" +
                    "-Cum asa?? Permisul cantareste sub 50 de grame!");
        }
        if(numba1 == 68){
            glumec.setText("Intr-un trib de canibali: \n" +
                    "- Sefu', il punem la gratar? intreba un canibal, tinand de gat un tip pricajit, legat fedeles si care tremura ca varga. \n" +
                    "- Pune-l, pune-l! raspunse sefu'. Dar mai intai jupoaie-l, continua el. Stii ca nu-mi place pielea de gaina..."+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==69 ){
            glumec.setText("Gigel era canibal. Familia sa il duse la doctor. Vin acasa. Mama il intreaba: \n" +
                    "Gigel, cum ti sa parut doctorul ? \n" +
                    "Gigel spune: Delicioooos!");
        }
        if(numba1 ==70 ){
            glumec.setText("Un englez, un francez si un țigan capturați pe insula canibalilor.Șeful de trib le dă fiecăruia câte o șansă să se salveze dacă îi spun un cuvânt în engleză pe care el să nu-l știe. \n" +
                    "Englezul: Chair. \n" +
                    "- Scaun, la oala cu el ! \n" +
                    "Francezul: French fries ! \n" +
                    "- Cartofi prajiți, la oala si cu ăsta ! \n" +
                    "Vine și țiganu: Burterflyli ! \n" +
                    "Stă șefu de trib o oră, două, își ia un dicționar, dar tot nimic.Într-un final îi spune țiganului că e liber sa plece, dar să-i traduca si lui ce a spus. \n" +
                    "La care țiganu: fluturili șefu, fluturili"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 71){
            glumec.setText("Bulă este prins de un trib de canibali. Este legat şi este pregătit pentru cină. \n" +
                    "Disperat, Bulă începe să se roage în gând. \n" +
                    "- Sunt în mare pericol. Doamne, ajută-mă! \n" +
                    "Pe când se ruga, aude o voce care-i spune: \n" +
                    "- Stai liniştit, că nu eşti în mare pericol. Când vine şeful de trib, loveşte-l între picioare câţi poţi de tare. \n" +
                    "Vine şeful de trib. Bulă îl loveşte cu toată puterea între picioare. Şeful de trib cade lat, la care se aude din nou vocea: \n" +
                    "- Abia acum eşti în mare pericol"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==72 ){
            glumec.setText("Un tip merge la banca. Tanti de la ghiseu il intreaba:\n" +
                    "- Cum va numiti?\n" +
                    "- Po-po-popa Ma-ma-marin.\n" +
                    "- Sunteti balbait?\n" +
                    "- Nu, tata a fost iar functionarul era un dobitoc.");
        }
        if(numba1 ==73 ){
            glumec.setText("Pe un trotuar, un tip isi taraie cu greu piciorul… De la coltul strazii apare brusc un alt tip, care isi taraie si el piciorul… Cand ajung unul in dreptul celuilalt, primul intreaba:\n" +
                    "- Vietnam?\n" +
                    "Atunci, celalalt raspunde:\n" +
                    "- Nu!… Niste rahat de caine, de pe strada cealalta!…");
        }
        if(numba1 ==74 ){
            glumec.setText("-Chelner, mi-ai servit o gaina batrana.\n" +
                    "-De unde stiti ca era batrana?\n" +
                    "-Dupa dinti!\n" +
                    "-Dar gaina nu are dinti!\n" +
                    "-Ea nu, dar eu aveam!"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==75 ){
            glumec.setText("Care-i cel mai lung autoturism din lume ?\n" +
                    "* Trabantul , are 3 m lungime si 4 m fumul .\n" +
                    "\n" +
                    "Ce se intampla cu un Trabant cand proprietarul ii face plinul ?\n" +
                    "* Isi dubleaza valoarea . \n" +
                    "\n" +
                    "Cand atinge Trabantul viteza maxima ?\n" +
                    "* In cadere libera ; in cazul in care nu penduleaza ca o frunza"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 76){
            glumec.setText("Se aude ca undeva in Romania se afla un lac in care daca intra un handicapat, pe\n" +
                    "partea cealalta iese vindecat.\n" +
                    "Apare un orb:\n" +
                    "– Unde-i lacul? Unde-i lacul ?\n" +
                    "Intra in el… iese pe partea cealalta:\n" +
                    "– Dumnezeule vad !!! Vad !!!\n" +
                    "Apare si un surd:\n" +
                    "– Unde-i lacul? Unde-i lacul ?\n" +
                    "Intra si el… iese pe partea cealalta:\n" +
                    "– Dumnezeule aud !!! Aud !!!\n" +
                    "Apare si un olog in carucior cu rotile:\n" +
                    "– Unde-i lacul ? Unde-i lacul ?\n" +
                    "Intra si el…iese pe partea cealalta:\n" +
                    "– Dumnezeule… am cauciucuri noi !!! Am cauciucuri noi !!!"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==77 ){
            glumec.setText("In curtea spitalului toti nebunii se urcau pe un stalp.\n" +
                    "Cand coborau toti ziceau:\n" +
                    "– „ASA E”.\n" +
                    "Doi doctori vazandu-i ii intreaba ce au.\n" +
                    "Nebunii:\n" +
                    "– Nimic.\n" +
                    "Se suie si un doctor, se da jos si zice „ASA E”.\n" +
                    "Doctorul celalalt il intreaba ce e?\n" +
                    "La care doctorul ii zice:\n" +
                    "– Stii ce scrie ba in varf?\n" +
                    "– „AICI SE TERMINA STALPU”!"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==78 ){
            glumec.setText("Mistreţul neprietenos se plimba cu bicicleta. Iepuraşul alerga pe lângă el:\n" +
                    "– O să cazi, o să cazi!\n" +
                    "Deodată, mistreţul cade într-o groapă. Iepuraşul îi strigă:\n" +
                    "– Ai văzut, ai văzut?\n" +
                    "Din groapă se aude o voce răguşită:\n" +
                    "– Parchez unde vreau eu, da?"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==79 ){
            glumec.setText("Cica un irlandez, un mexican si un blond erau muncitori pe un santier, undeva la etajul 20, si vine pauza de masa.\n" +
                    "Irlandezul isi deschide punga cu mancare si zice: „Din nou varza si carne de vaca! M-am saturat!\n" +
                    "Daca si maine tot asta gasesc in punga, ma arunc!”.\n" +
                    "Mexicanul deschide punga si zice: „Din nou tacos! M-am saturat de tacos! Daca maine gasesc tot tacos, ma arunc!”\n" +
                    "Blondul: „Din nou lasagna! M-am saturat! Daca maine e la fel, ma arunc”.\n" +
                    "A 2-a zi, irlandezul are exact aceeasi mancare, se arunca si moare, mexicanul se arunca si moare si el, blondul idem, se arunca si moare.\n" +
                    "La inmormantare: nevasta irlandezului: „Daca stiam ca nu-i place, i-as fi gatit altceva!”, nevasta mexicanului: „As fi putut sa-i dau tortillas,\n" +
                    "chilli peppers sau altceva! Daca as fi stiut!”.\n" +
                    "Acum toata lumease uita la nevasta blondului…si se uita…si se uita… la care nevasta blondului\n" +
                    "zice: „De ce va uitati ma la mine?! El isi face singur pachetul!”"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 80){
            glumec.setText("Trei nebuni faceau galagie intr-un avion. Pilotul ii spune copilotului: -Du-te sa vezi ce e cu ei. Copilotul vorbeste cu nebunii si se intoarce in carlinga. Pilotul il intreaba: -Ce ai facut de i-ai linistit? -Ne-am jucat de-a scoala si i-am trimis sa-si faca temele. Dupa cinci minute, nebunii incep din nou sa faca galagie si pilotul ii spune copilotului: -Du-te sa vezi ce mai vor de data asta. Copilotul se duce la ei si cand se intoarce pilotul il intreaba: -Ce ai facut? -Le-am corectat temele si deoarece le facusera bine, le-am deschis usa si au iesit toti in pauza!"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 81){
            glumec.setText("O coada lunga la un magazin in padure. De zile intregi magazinul nu a fost deschis. Iepurasul, bine dispus, imbracat la costum, cu un diplosat in mana, se indreapta spre magazin. Ajunge pe la sfarsitul cozii, il vede vulpea, care era acolo, ca se baga in fata si-l prinde:\n" +
                    "– Stai si tu la coada, asa cum facem toti, nu te mai baga in fata.\n" +
                    "Apoi il tranteste de un copac. Saracul iepuras se scutura, isi revine si apoi porneste mai departe. Ajunge langa lup, care era pe la mijlocul cozii. Si acesta il prinde, il scutura, apoi il tranteste de un copac. Cu greu se reculege iepurasul. Revine cumva si merge mai departe. Ajunge langa urs, care era chiar in fata. Il injura ursul de nu se poate, il mai si bate bine. Cu un ultim efort, se scola iepurasul si foarte nervos striga:\n" +
                    "– No, bine. Daca nu vreti voi, nici astazi nu deschid."+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 82){
            glumec.setText("Doi francezi, aflati in Anglia, nu avusesera ocazia sa vada deloc soarele in doua saptamani. Ca sa se dumireasca, l-au intrebat pe receptionerul de la hotel:\n" +
                    "– Pe aici ploua des?\n" +
                    "– Cam de doua ori pe an, domnule.\n" +
                    "– Si cat tine?\n" +
                    "– Cam sase luni…"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==83 ){
            glumec.setText("Dupa decolare capitanul avionului se adreseaza pasagerilor:\n" +
                    "– Doamnelor si domnilor, va vorbeste capitanul. Am ajuns la inaltimea corespunzatoare, timpul este favorabil, viteza… O, la dracu!\n" +
                    "Pasagerii incremeniti stau pe locurile lor. Dupa câteva momente capitanul se adreseaza iar pasagerilor:\n" +
                    "– Va rog sa ma iertati, din greseala am varsat cafeaua pe mine. Ar trebui sa vedeti cum arata pantalonul in fata.\n" +
                    "La care un pasager:\n" +
                    "– Iar al meu in spate!"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 84){
            glumec.setText("– Sunt de zece zile in Tulcea si regret ca nu am venit din prima zi in restaurantul dumneavoastra.\n" +
                    "– Multumim, domnule, ne maguliti.\n" +
                    "– Nu, vreau sa spun ca as fi preferat sa mananc stiuca asta acum zece zile.");
        }
        if(numba1 == 85){
            glumec.setText("O pisica hipioata trecea strada. O batranica o vede si striga dupa ea:\n" +
                    "– Pis, pis, pis…\n" +
                    "La care pisica raspunde, ridicand doua degete:\n" +
                    "– Peace, maica, peace!");
        }
        if(numba1 == 86){
            glumec.setText("– Buna ziua!\n" +
                    "– Buna ziua, domnule politist!\n" +
                    "– Dumneata, tinere domn, pe gheata asta conduci cu 80 km pe ora? Vrei sa ajungi la spital?\n" +
                    "– Da!\n" +
                    "– Bravo, frumos raspuns! Esti smecher?\n" +
                    "– Nu! Sunt doctor!");
        }
        if(numba1 ==87 ){
            glumec.setText("Pasagerul unui avion marturiseste:\n" +
                    "– Imi vine asa sa vomit!\n" +
                    "La care stewardesa prompta:\n" +
                    "– Va aduc intr-o secunda o punga!\n" +
                    "– Dar de ce? Credeti ca vreau sa iau chestia asta acasa?");
        }
        if(numba1 ==88 ){
            glumec.setText("Doi ciobani merg la un restaurant mediteranean. Dupa ce citesc meniul il intreaba pe chelner:\n" +
                    "– Dom’le draga, ce is acelea fructe de mare?\n" +
                    "– Caracatita, calamar, rac, creveti, raspunde chelnerul.\n" +
                    "– Apoi bag de seama, zice unul dintre ciobani, dupa cum zici dumneata, vulpea, ursul si lupu’ is fructe de padure!\n" +
                    " ");
        }
        if(numba1 == 89){
            glumec.setText("a FBI se fac angajari. La interviu se prezinta trei tipi. Interviul are loc in biroul sefului FBI. Intra primul – sa zicem John. Seful FBI ii da un pistol si ii spune:\n" +
                    "– In biroul de alaturi se afla sotia ta. Intra si impusc-o.\n" +
                    "– Nici nu ma gandesc, zice tipul si pleaca.\n" +
                    "Intra al doilea candidat – Jim. Istoria se repeta: seful FBI ii da pistolul si-l invita sa-si impuste nevasta. Dupa 10 minute, tipul se hotaraste ca nevasta-sa e mai importanta decat job-ul la FBI si pleaca.\n" +
                    "Intra ultimul – Tom. Acesta ia pistolul si este de acord sa-si impuste nevasta. Intra in birou iar seful FBI aude 6 impuscaturi, bubuituri si strigate. Tom iese afara dupa o vreme, plin de sange si spune:\n" +
                    "– Nu stiu ce idiot a pus gloante oarbe in pistol… A trebuit s-o omor cu scaunul.\n" +
                    " "+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 90){
            glumec.setText("Trecatorii privesc cu nedumerire la un individ care sta nemiscat, cu urechea lipita de asfalt. Un cetatean mai curios nu se poate abtine si pune, de asemenea, urechea la pamant, asculta concentrat cateva secunde bune, apoi remarca:\n" +
                    "– Nu se aude absolut nimic!\n" +
                    "Celalalt ridică ochii, il priveste si-i raspunde:\n" +
                    "– Da, si partea nasoala este ca o tine asa de azi dimineata!"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==91 ){
            glumec.setText("Doctorul stomatolog ii spune, revoltat, pacientului:\n" +
                    "– Hei, aceste bancnote sunt false!\n" +
                    "La care pacientul ii raspunde calm:\n" +
                    "– Dar dintii pe care mi i-ati pus sunt adevarati?");
        }
        if(numba1 == 92){
            glumec.setText("Cioc ! Cioc!\n" +
                    "– Cine e ?\n" +
                    "– Zana cea buna!!!\n" +
                    "– Si de ce ai un topor??\n" +
                    "– Nu sunt bine dispusa azi.\n" +
                    " ");
        }
        if(numba1 == 93){
            glumec.setText("Un tanar cu tatal lui se urca intr-un tramvai foarte aglomerat. Tanarul ii zice tatalui:\n" +
                    "– Mai, tata, mai bine luam un taxi, nu vezi ce aglomerat este tramvaiul asta?\n" +
                    "– Mai lasa-ma in pace, daca erai la discoteca ziceai ca este atmosfera."+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 ==94 ){
            glumec.setText("Pe Transfagarasan urca o masina in marsarier. Un politist ii intreaba:\n" +
                    "– De ce urcati pe traseul asta atat de periculos cu spatele?\n" +
                    "– Ne-am gandit ca daca sus nu gasim loc de intors, vom putea veni la coborare cu fata.\n" +
                    "Dupa un timp, masina coboara Transfagarasanul tot in marsarier.\n" +
                    "– Si acum de ce coborati Transfagarasanul cu spatele?\n" +
                    "– Am gasit loc de intors…"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 95){
            glumec.setText("– Melcule, unde fugi asa repede? intreaba ursul\n" +
                    "– Ma cauta DNA sa ma aresteze.\n" +
                    "– De ce?\n" +
                    "– Eu am casa, mama casa, tata casa, fratele meu are casa…\n" +
                    "Ursul incepe sa fuga si el dupa ce s-a gandit un pic la ce a spus melcul. Pe drum se intalneste cu cocostarcul.\n" +
                    "– Ursule, de ce fugi?\n" +
                    "– Ma cauta DNA sa ma aresteze. Eu am blana, mama are blana, tata are si el blana…\n" +
                    "Se gandeste cocostarcul si se pune si el pe fuga. Se intalneste cu maimuta care il intreaba:\n" +
                    "– Cocostarcule, ce-ai patit de fugi asa de tare?\n" +
                    "– Fug sa nu ma aresteze DNA-ul. Eu traiesc pe picior mare, mama traieste pe picior mare, tata la fel…\n" +
                    "Fara sa gandeasca, maimuta se pune si ea pe fuga. Cand oboseste se opreste si-si spune:\n" +
                    "– Eu de ce fug? Eu sunt in fundul gol, mama e in fundul gol, tata e in fundul gol, bunicii la fel"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 96){
            glumec.setText("La psihiatru venea un pacient care-i povestea ingrozit ca in fiecare seara iese de sub patul lui un crocodil care vrea sa-l manance. Medicul i-a dat medicamente din ce in ce mai puternice, pana cand omul n-a mai aparut. Curios, i-a luat adresa din registru si s-a dus sa-l viziteze. A sunat insa degeaba la usa, pana a iesit un vecin.\n" +
                    "– Stiti ceva despre Ionescu? a intrebat psihiatrul.\n" +
                    "– O, da, o tragedie… L-a mancat un crocodil!"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }
        if(numba1 == 97){
            glumec.setText("Condamnatul este adus in camera de executie. Priveste scaunul electric de care sunt legate tot felul de fire si intreba:\n" +
                    "– Cum se cheama dracovenia asta?\n" +
                    "Directorul inchisorii ii raspunde:\n" +
                    "– Nu-ti bate capul cu intrebari, o sa te punem imediat la curent.");
        }
        if(numba1 == 98){
            glumec.setText("– Ieri eram putin cherchelit si-am bagat cheia masinii in broasca usii de la bloc.\n" +
                    "– Si atunci?\n" +
                    "– Atunci blocul s-a pus in miscare.");
        }
        if(numba1 ==99 ){
            glumec.setText("Doi batrani discuta. Zice unul:\n" +
                    "– Si am fost aseara la un resturant superb. Mancarea a fost deosebit de gustoasa, muzica buna, servirea exceptionala…\n" +
                    "– Care-i numele restaurantului? intreaba celalalt.\n" +
                    "– Vai ce-mi scapa, zi un nume de floare… Poate…\n" +
                    "– Liliac!\n" +
                    "– Nu…\n" +
                    "– Viorele!\n" +
                    "– Nu, nu…\n" +
                    "– Rose!\n" +
                    "– Asta e. Roza! Care-i numele restaurantului la care am fost aseara?"+  ". \n" +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" + ". \n");
        }




        return true;
    }
}
