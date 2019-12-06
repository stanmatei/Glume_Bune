package com.mple.matei.glumebune;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class imagini extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    ImageView gica;
    private GestureDetectorCompat gesturec;
    int[] araic = new int[300000];


    int ac=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_imagini);


        gica =(ImageView)findViewById(R.id.gica);
        gesturec= new GestureDetectorCompat(this,this);
        gesturec.setOnDoubleTapListener(this);


        AdView adViewb =(AdView)findViewById(R.id.adView12);

        AdRequest adRequestb = new AdRequest.Builder().build();

        adViewb.loadAd(adRequestb);



    }
    public boolean onTouchEvent(MotionEvent event){
        gesturec.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {




        if(ac<=0){
            gica.setImageResource(R.drawable.pec);
            ac++;
        }


        else
        if (araic[ac - 1] == 0) {
            gica.setImageResource(R.drawable.pic0);
        }
        if (araic[ac - 1] == 1) {
            gica.setImageResource(R.drawable.pic1);
        }
        if (araic[ac - 1] == 2) {
            gica.setImageResource(R.drawable.pic2);
        }
        if (araic[ac - 1] == 3) {
            gica.setImageResource(R.drawable.pic3);
        }
        if (araic[ac - 1] == 4) {
            gica.setImageResource(R.drawable.pic4);
        }
        if (araic[ac - 1] == 5) {
            gica.setImageResource(R.drawable.pic5);
        }
        if (araic[ac - 1] == 6) {
            gica.setImageResource(R.drawable.pic6);
        }
        if (araic[ac - 1] == 7) {
            gica.setImageResource(R.drawable.pic7);
        }
        if (araic[ac - 1] == 8) {
            gica.setImageResource(R.drawable.pic8);
        }
        if (araic[ac - 1] == 9) {
            gica.setImageResource(R.drawable.pic9);
        }
        if (araic[ac - 1] == 10) {
            gica.setImageResource(R.drawable.pic10);
        }
        if (araic[ac - 1] == 11) {
            gica.setImageResource(R.drawable.pic11);
        }
        if (araic[ac - 1] == 12) {
            gica.setImageResource(R.drawable.pic12);
        }
        if (araic[ac - 1] == 13) {
            gica.setImageResource(R.drawable.pic13);
        }
        if (araic[ac - 1] == 14) {
            gica.setImageResource(R.drawable.pic14);
        }
        if (araic[ac - 1] == 15) {
            gica.setImageResource(R.drawable.pic15);
        }
        if (araic[ac - 1] == 16) {
            gica.setImageResource(R.drawable.pic16);
        }
        if (araic[ac - 1] == 17) {
            gica.setImageResource(R.drawable.pic17);
        }
        if (araic[ac - 1] == 18) {
            gica.setImageResource(R.drawable.pic18);
        }
        if (araic[ac - 1] == 19) {
            gica.setImageResource(R.drawable.pic19);
        }
        if (araic[ac - 1] == 20) {
            gica.setImageResource(R.drawable.pic20);
        }
        if (araic[ac - 1] == 21) {
            gica.setImageResource(R.drawable.pic21);
        }
        if (araic[ac - 1] == 22) {
            gica.setImageResource(R.drawable.pic22);
        }
        if (araic[ac - 1] == 23) {
            gica.setImageResource(R.drawable.pic23);
        }
        if (araic[ac-1] == 24) {
            gica.setImageResource(R.drawable.bebe);
        }

        ac = ac - 1;





        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Random rodrigo =new Random();
        int numba = rodrigo.nextInt(25);

        ac++;
        araic[ac]=numba;
        if(ac>=5) {

            while (numba == araic[ac - 2] || numba == araic[ac - 3] ) {
                if (numba == 0) {
                    numba++;
                } else
                    numba = numba - 1;

            }
        }









            if (numba == 0) {
                gica.setImageResource(R.drawable.pic0);
            }
            if (numba == 1) {
                gica.setImageResource(R.drawable.pic1);
            }
            if (numba == 2) {
                gica.setImageResource(R.drawable.pic2);
            }
            if (numba == 3) {
                gica.setImageResource(R.drawable.pic3);
            }
            if (numba == 4) {
                gica.setImageResource(R.drawable.pic4);
            }
            if (numba == 5) {
                gica.setImageResource(R.drawable.pic5);
            }
            if (numba == 6) {
                gica.setImageResource(R.drawable.pic6);
            }
            if (numba == 7) {
                gica.setImageResource(R.drawable.pic7);
            }
            if (numba == 8) {
                gica.setImageResource(R.drawable.pic8);
            }
            if (numba == 9) {
                gica.setImageResource(R.drawable.pic9);
            }
            if (numba == 10) {
                gica.setImageResource(R.drawable.pic10);

            }
            if (numba == 11) {
                gica.setImageResource(R.drawable.pic11);
            }
            if (numba == 12) {
                gica.setImageResource(R.drawable.pic12);
            }
            if (numba == 13) {
                gica.setImageResource(R.drawable.pic13);
            }
            if (numba == 14) {
                gica.setImageResource(R.drawable.pic14);
            }
            if (numba == 15) {
                gica.setImageResource(R.drawable.pic15);
            }
            if (numba == 16) {
                gica.setImageResource(R.drawable.pic16);
            }
            if (numba == 17) {
                gica.setImageResource(R.drawable.pic17);
            }
            if (numba == 18) {
                gica.setImageResource(R.drawable.pic18);
            }
            if (numba == 19) {
                gica.setImageResource(R.drawable.pic19);
            }
            if (numba == 20) {
                gica.setImageResource(R.drawable.pic20);
            }
            if (numba == 21) {
                gica.setImageResource(R.drawable.pic21);
            }
        if (numba == 22) {
            gica.setImageResource(R.drawable.pic22);
        }
        if (numba == 23) {
            gica.setImageResource(R.drawable.pic23);
        }
        if (numba == 24) {
            gica.setImageResource(R.drawable.bebe);
        }




        return true;
    }
}
