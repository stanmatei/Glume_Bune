package com.mple.matei.glumebune;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class offlineActivity extends AppCompatActivity {

    String[] cat = {"Originale","Lungi","Scurte","Diverse","Perle","Imagini","7","Legende",""};
    String[] descc={"Glume originale,nu le gasesti in alta parte!","Glume lungi culese cu atentie","Glume scurte gasite in alte locuri","Tot felu' de bancuri","Viata-i frumoasa, dar merita traita!","Niste imagini amuzante","Un fel de joc","Legende ale umorului",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        AdView adView4 =(AdView)findViewById(R.id.adff);
        AdRequest adRequest4 = new AdRequest.Builder().build();
        adView4.loadAd(adRequest4);

        ListView listView = (ListView)findViewById(R.id.listView2);

       offlineActivity.CustomAdpterr customAdpterr = new offlineActivity.CustomAdpterr();
        listView.setAdapter(customAdpterr);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent1 = new Intent(offlineActivity.this,original.class);
                    startActivity(intent1);
                }
                if(i==1){
                    Intent intent1 = new Intent(offlineActivity.this,lungi.class);
                    startActivity(intent1);
                }
                if(i==2){
                    Intent intent1 = new Intent(offlineActivity.this,clasic.class);
                    startActivity(intent1);
                }
                if(i==3){
                    Intent intent1 = new Intent(offlineActivity.this,multe.class);
                    startActivity(intent1);
                }
                if(i==4){
                    Intent intent1 = new Intent(offlineActivity.this,perle.class);
                    startActivity(intent1);
                }
                if(i==5){
                    Intent intent1 = new Intent(offlineActivity.this,imagini.class);
                    startActivity(intent1);
                }
                if(i==6){
                    Intent intent1 = new Intent(offlineActivity.this,Game.class);
                    startActivity(intent1);
                }
                if(i==7){
                    Intent intent1 = new Intent(offlineActivity.this,master.class);
                    startActivity(intent1);
                }

            }
        });




    }

    class CustomAdpterr extends BaseAdapter {

        @Override
        public int getCount() {
            return cat.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_list_layout,null);
            TextView titlu =(TextView)view.findViewById(R.id.vechi_titlu);
            TextView desc = (TextView)view.findViewById(R.id.vechi_desc);
            titlu.setText(cat[i]);
            desc.setText(descc[i]);
            return view;
        }


    }




}
