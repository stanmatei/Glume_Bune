package com.mple.matei.glumebune;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class feedFragment extends Fragment {

    private View mMainView;
    private FloatingActionButton mSend,mSearch,mSett,mAdd;
    private int press_state=0;
    private final List<Postache> postaches= new ArrayList<>();
    private LinearLayoutManager mLinearLayout;
    private PostAdapter mAdapter;
    private RecyclerView postList;
    private DatabaseReference postData;
    private Handler mHandler = new Handler();
    AnimationDrawable animationDrawable;
    RelativeLayout relativeLayout;
    public feedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mMainView= inflater.inflate(R.layout.fragment_feed, container, false);
        postList=(RecyclerView)mMainView.findViewById(R.id.post_list);
        mLinearLayout = new LinearLayoutManager(getContext());
        mAdapter = new PostAdapter(postaches,getContext());

        relativeLayout =(RelativeLayout) mMainView.findViewById(R.id.relFut);
        animationDrawable=(AnimationDrawable)relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        postList.setHasFixedSize(true);
        postList.setLayoutManager(mLinearLayout);
        postList.setAdapter(mAdapter);
        postData= FirebaseDatabase.getInstance().getReference().child("Glume");
       mSend=(FloatingActionButton)mMainView.findViewById(R.id.feed_add_btn);
       mSearch=(FloatingActionButton)mMainView.findViewById(R.id.search_fab);
       mSett=(FloatingActionButton)mMainView.findViewById(R.id.sett_fab);
       mAdd=(FloatingActionButton)mMainView.findViewById(R.id.create_fab);
       mSearch.setVisibility(View.INVISIBLE);
       mSearch.setEnabled(false);
       mSett.setVisibility(View.INVISIBLE);
       mSett.setEnabled(false);
       mAdd.setVisibility(View.INVISIBLE);
       mAdd.setEnabled(false);
        AdView adView4 =(AdView)mMainView.findViewById(R.id.adFeed);
        AdRequest adRequest4 = new AdRequest.Builder().build();
        adView4.loadAd(adRequest4);






       mSend.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(press_state == 0){
                   mSearch.setVisibility(View.VISIBLE);
                   mSearch.setEnabled(true);
                   mSett.setVisibility(View.VISIBLE);
                   mSett.setEnabled(true);
                   mAdd.setVisibility(View.VISIBLE);
                   mAdd.setEnabled(true);

                   press_state =1;
                   mSend.setImageResource(R.drawable.ic_clear_black_24dp);

               }
               else if(press_state == 1){
                   mSearch.setVisibility(View.INVISIBLE);
                   mSearch.setEnabled(false);
                   mSett.setVisibility(View.INVISIBLE);
                   mSett.setEnabled(false);
                   mAdd.setVisibility(View.INVISIBLE);
                   mAdd.setEnabled(false);
                   press_state =0;
                   mSend.setImageResource(R.drawable.ic_add_black_24dp);
               }

           }
       });
       mSett.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               CharSequence options[] = new  CharSequence[]{"Cele mai noi", "Cele mai populare"};

               AlertDialog.Builder builder =new AlertDialog.Builder(getContext());
               builder.setTitle("Ordine");
               builder.setItems(options, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {

                       if(i== 0){

                           postaches.clear();
                           postData.orderByChild("timp").addChildEventListener(new ChildEventListener() {
                               @Override
                               public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                                   Postache postache2 = dataSnapshot.getValue(Postache.class);

                                   postaches.add(postache2);
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
                       if(i ==1){
                           postaches.clear();
                           postData.orderByChild("score").addChildEventListener(new ChildEventListener() {
                               @Override
                               public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                                   Postache postache3 = dataSnapshot.getValue(Postache.class);

                                   postaches.add(postache3);
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


                   }
               });
               builder.show();
           }
       });
       mAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                Intent postIntent = new Intent(getContext(),PostActivity.class);
                startActivity(postIntent);

           }
       });
       mSearch.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent posttIntent = new Intent(getContext(),SearchActivity.class);
               startActivity(posttIntent);
           }
       });


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
