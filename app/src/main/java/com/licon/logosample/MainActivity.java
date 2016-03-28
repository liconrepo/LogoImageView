package com.licon.logosample;


import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;

import com.licon.logo.LogoView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogoView logoView = (LogoView) findViewById(R.id.logoview);
        logoView.setGravity(Gravity.LEFT | Gravity.BOTTOM);
    }
}