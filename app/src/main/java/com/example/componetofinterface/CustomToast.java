package com.example.componetofinterface;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Toast;

public class CustomToast extends Toast {
    int mDuration;
    boolean mShowing;
    String text;
    public CustomToast (Context context,String text){
        super(context);
        this.text=text;
        mDuration=2;
    }
    @Override
    public void setDuration(int seconds) {
        super.setDuration(LENGTH_SHORT);
        if(seconds < 2) seconds = 2; //Minimum
        mDuration = seconds;
    }

    /**
     * Show the toast for the given time
     */
    @Override
    public void show() {
        super.show();

        if(mShowing) return;

        mShowing = true;
        final Toast thisToast = this;
        new CountDownTimer((mDuration-2)*1000, 1000)
        {
            public void onTick(long millisUntilFinished) {thisToast.show();}
            public void onFinish() {thisToast.show(); mShowing = false;}

        }.start();
    }
}
