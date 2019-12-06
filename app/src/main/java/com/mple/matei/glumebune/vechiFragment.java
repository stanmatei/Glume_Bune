package com.mple.matei.glumebune;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class vechiFragment extends Fragment {

    private View mMainView;
    String[] cat = {"Originale","Lungi","Scurte","Diverse","Perle","Imagini","7","Legende"," "};
    String[] descc={"Glume originale, nu le gasesti in alta parte!","Glume lungi culese cu atentie","Glume scurte gasite in alte locuri","Tot felu' de bancuri","Viata-i frumoasa, dar merita traita!","Niste imagini amuzante","Un fel de joc","Legende ale umorului"," "};
    public vechiFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mMainView= inflater.inflate(R.layout.fragment_vechi, container, false);

        ListView listView = (ListView)mMainView.findViewById(R.id.listView);

        CustomAdpter customAdpter = new CustomAdpter();
        listView.setAdapter(customAdpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent1 = new Intent(getContext(),original.class);
                    startActivity(intent1);
                }
                if(i==1){
                    Intent intent1 = new Intent(getContext(),lungi.class);
                    startActivity(intent1);
                }
                if(i==2){
                    Intent intent1 = new Intent(getContext(),clasic.class);
                    startActivity(intent1);
                }
                if(i==3){
                    Intent intent1 = new Intent(getContext(),multe.class);
                    startActivity(intent1);
                }
                if(i==4){
                    Intent intent1 = new Intent(getContext(),perle.class);
                    startActivity(intent1);
                }
                if(i==5){
                    Intent intent1 = new Intent(getContext(),imagini.class);
                    startActivity(intent1);
                }
                if(i==6){
                    Intent intent1 = new Intent(getContext(),Game.class);
                    startActivity(intent1);
                }
                if(i==7){
                    Intent intent1 = new Intent(getContext(),master.class);
                    startActivity(intent1);
                }

            }
        });

        AdView adView4 =(AdView)mMainView.findViewById(R.id.adVechi);
        AdRequest adRequest4 = new AdRequest.Builder().build();
        adView4.loadAd(adRequest4);

        return mMainView;
    }


    class CustomAdpter extends BaseAdapter {

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
