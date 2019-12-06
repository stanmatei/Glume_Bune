package com.mple.matei.glumebune;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class repertoriuFragment extends Fragment {


    private View mMainView;
    private final List<Postache> postaches= new ArrayList<>();
    private LinearLayoutManager mLinearLayout;
    private FavAdapter mAdapter;
    private RecyclerView postList;
    private DatabaseReference postData;
    private FirebaseAuth mAuth;
    AnimationDrawable animationDrawable;
    RelativeLayout relativeLayout;
    public repertoriuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       mMainView =inflater.inflate(R.layout.fragment_repertoriu, container, false);
        postList=(RecyclerView)mMainView.findViewById(R.id.post_list);
        mLinearLayout = new LinearLayoutManager(getContext());
        mAdapter = new FavAdapter(postaches,getContext());
        relativeLayout =(RelativeLayout) mMainView.findViewById(R.id.futema);
        animationDrawable=(AnimationDrawable)relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        postList=(RecyclerView)mMainView.findViewById(R.id.fav_list) ;
        postList.setHasFixedSize(true);
        postList.setLayoutManager(mLinearLayout);
        postList.setAdapter(mAdapter);
       mAuth = FirebaseAuth.getInstance();
        AdView adView4 =(AdView)mMainView.findViewById(R.id.adRep);
        AdRequest adRequest4 = new AdRequest.Builder().build();
        adView4.loadAd(adRequest4);
       postData= FirebaseDatabase.getInstance().getReference().child("Favorite").child(mAuth.getCurrentUser().getUid());
       postData.keepSynced(true);


        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;

        }
        else
            connected = false;

        if(!connected){
            Toast.makeText(getContext(),"Verificati conexiunea la internet!",Toast.LENGTH_LONG).show();
        }


       return mMainView;
    }
    @Override
    public void onStart() {
        super.onStart();


        postData.orderByChild("timp").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Postache postache = dataSnapshot.getValue(Postache.class);

                postaches.add(postache);
                mAdapter.notifyDataSetChanged();



            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onStop() {
        super.onStop();
        postaches.clear();
    }

}
