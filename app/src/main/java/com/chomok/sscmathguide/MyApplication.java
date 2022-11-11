package com.chomok.sscmathguide;

import android.app.Application;
import com.google.android.gms.ads.MobileAds;
import papaya.in.admobopenads.AppOpenManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        MobileAds.initialize(this);
//        new AppOpenManager(this,getString(R.string.admob_APP_OPEN_ADS_ID));
    }
}
