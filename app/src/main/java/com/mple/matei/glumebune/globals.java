package com.mple.matei.glumebune;

import android.app.Application;

/**
 * Created by Matei on 9/5/2017.
 */
public class globals extends Application {

    private static String[] test= {"1","2","3","4"};



    public String getTest1(int a) {
        return globals.test[a];
    }



}