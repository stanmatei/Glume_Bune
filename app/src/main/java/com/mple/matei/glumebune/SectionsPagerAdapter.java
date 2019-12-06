package com.mple.matei.glumebune;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Matei on 11/29/2017.
 */

class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                feedFragment feedFragment = new feedFragment();
                return feedFragment;


            case 1:

            vechiFragment vechiFragment = new vechiFragment();
            return vechiFragment;

            case 2:
                repertoriuFragment repertoriuFragment = new repertoriuFragment();
                return repertoriuFragment;



            default:
                return null;


        }




    }

    @Override
    public int getCount() {
        return 3;
    }


    public CharSequence getPageTitle(int position){
        switch(position){
            case 0:
                return "POSTARI";
            case 1:
                return "ALMANAH";
            case 2:
                return "FAVORITE";




            default:
                return null;


        }

    }
}
