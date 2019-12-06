package com.mple.matei.glumebune;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    private ImageButton searchBtn;
    private RecyclerView postList;
    private DatabaseReference postData;
    private final List<Postache> postaches= new ArrayList<>();
    private LinearLayoutManager mLinearLayout;
    private PostAdapter mAdapter;
    private EditText sportText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mToolBar=(Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Cauta o categorie de glume!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        searchBtn=(ImageButton)findViewById(R.id.feed_search_btn);
        sportText=(EditText)findViewById(R.id.post_sport_text);
        mAdapter = new PostAdapter(postaches,SearchActivity.this);
        postList=(RecyclerView)findViewById(R.id.cat_list);
        mLinearLayout = new LinearLayoutManager(SearchActivity.this);
        postList.setHasFixedSize(true);
        postList.setLayoutManager(mLinearLayout);
        postList.setAdapter(mAdapter);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPosts();
            }
        });
    }


    private void loadPosts() {

        postaches.clear();
        String sport = sportText.getText().toString();
        postData= FirebaseDatabase.getInstance().getReference().child("categorii").child(sport);

        postData.orderByChild("score").addChildEventListener(new ChildEventListener() {
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



}
