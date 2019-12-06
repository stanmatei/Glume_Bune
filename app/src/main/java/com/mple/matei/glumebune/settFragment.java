package com.mple.matei.glumebune;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class settFragment extends Fragment {

    public settFragment() {

    }
    private Button extra,clasic,log;
    private View mMainView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


              mMainView =  inflater.inflate(R.layout.fragment_sett, container, false);
              extra=(Button)mMainView.findViewById(R.id.sett_btn_extra);
              clasic=(Button)mMainView.findViewById(R.id.ett_btn_clasic);
              log=(Button)mMainView.findViewById(R.id.sett_btn_log);


              log.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      FirebaseAuth.getInstance().signOut();
                      Intent startIntent = new Intent(getContext(),StartActivity.class);
                      startActivity(startIntent);

                  }
              });
              clasic.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      Intent startIntent = new Intent(getContext(),meniu.class);
                      startActivity(startIntent);
                  }
              });
              extra.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      Intent startIntent = new Intent(getContext(),extra.class);
                      startActivity(startIntent);
                  }
              });










              return mMainView;
    }


}
