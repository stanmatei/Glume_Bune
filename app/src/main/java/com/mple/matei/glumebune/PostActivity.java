package com.mple.matei.glumebune;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PostActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    private FirebaseAuth mAuth;
    private DatabaseReference mUserData;
    private DatabaseReference mPostData;
    private String current_user;
    private String userName;
    private String userImage;
    private TextInputLayout mSport, mTitle, mDesc;
    private Button post_btn;
    private DatabaseReference mCategorii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        mToolBar=(Toolbar) findViewById(R.id.post_toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Posteaza o gluma");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        post_btn = (Button) findViewById(R.id.post_btn);
        mAuth= FirebaseAuth.getInstance();
        current_user = mAuth.getCurrentUser().getUid();
        mSport =(TextInputLayout)findViewById(R.id.sport_input_layout);
        mTitle = (TextInputLayout)findViewById(R.id.title_input_layout);
        mDesc =(TextInputLayout)findViewById(R.id.desc_input_layout);
        InputFilter[] filterArray = new InputFilter[1];
        filterArray[0] = new InputFilter.LengthFilter(280);
        mDesc.getEditText().setFilters(filterArray);
        InputFilter[] filterArray2 = new InputFilter[1];
        filterArray2[0] = new InputFilter.LengthFilter(20);
        mTitle.getEditText().setFilters(filterArray2);
        mUserData= FirebaseDatabase.getInstance().getReference().child("Users").child(current_user);
        mPostData =FirebaseDatabase.getInstance().getReference().child("Glume");
        mCategorii=FirebaseDatabase.getInstance().getReference();
        mUserData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userName=dataSnapshot.child("name").getValue().toString();



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    final String cate = mSport.getEditText().getText().toString();
                    String titlu = mTitle.getEditText().getText().toString();
                    String gluma = mDesc.getEditText().getText().toString();

                    if(!TextUtils.isEmpty(cate) || !TextUtils.isEmpty(titlu)|| !TextUtils.isEmpty(gluma)){
                        if(gluma.contains(" ") && !gluma.contains("pula") &&!gluma.contains("Pula") && !gluma.contains("PULA") && !gluma.contains("pizda") && !gluma.contains("Pizda") &&!gluma.contains("PIZDA") &&( gluma.contains("a") || gluma.contains("o")  || gluma.contains("e") || gluma.contains("i") || gluma.contains("u")) ){
                            DatabaseReference push = mPostData.child(cate).push();
                            String currentDate = DateFormat.getDateTimeInstance().format(new Date());
                            final String push_id = push.getKey();

                            long copa = System.currentTimeMillis();
                            long timp = 1000000000 - copa;
                            final Map map = new HashMap();
                            map.put("titlu", titlu);
                            map.put("gluma", gluma);
                            map.put("name", userName);

                            map.put("date", currentDate);
                            map.put("id", push_id);
                            map.put("categorie", cate);
                            map.put("score", 10000);
                            map.put("timp", timp);
                            map.put("user_id", current_user);
                            map.put("real",0);
                            map.put("spam",0);



                            mPostData.child(push_id).updateChildren(map, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                                    if (databaseError == null) {
                                        Toast.makeText(PostActivity.this, "Gluma a fost postata", Toast.LENGTH_LONG).show();
                                        Intent mainIntent = new Intent(PostActivity.this, futureActivity.class);
                                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(mainIntent);
                                        mCategorii.child("categorii").child(cate).child(push_id).updateChildren(map, new DatabaseReference.CompletionListener() {
                                            @Override
                                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                                            }
                                        });

                                    } else if (databaseError != null) {
                                        Toast.makeText(PostActivity.this, databaseError.toString(), Toast.LENGTH_LONG).show();
                                    }


                                }
                            });
                        }else{
                            Toast.makeText(PostActivity.this, "Introduceti o gluma adevarata!", Toast.LENGTH_LONG).show();
                        }


                }else{
                        Toast.makeText(PostActivity.this, "Completati toate spatiile!", Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
}
