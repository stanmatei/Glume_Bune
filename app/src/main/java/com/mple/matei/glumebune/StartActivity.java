package com.mple.matei.glumebune;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class StartActivity extends AppCompatActivity {

    private Button mLoginBtn,mRegistBtn,mOfflineBtn;
    ConstraintLayout relativeLayout;
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mLoginBtn=(Button)findViewById(R.id.login_btn);
        mRegistBtn=(Button)findViewById(R.id.regist_btn);
        mOfflineBtn=(Button)findViewById(R.id.offline_btn);

        relativeLayout =(ConstraintLayout) findViewById(R.id.relativ);

        animationDrawable=(AnimationDrawable)relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent loginIntent = new Intent(StartActivity.this,LoginActivity.class);
                startActivity(loginIntent);



            }
        });
        mRegistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registIntent = new Intent(StartActivity.this,RegisterActivity.class);
                startActivity(registIntent);
            }
        });
        mOfflineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent offIntent = new Intent(StartActivity.this,meniu.class);
                startActivity(offIntent);
            }
        });






    }




}
