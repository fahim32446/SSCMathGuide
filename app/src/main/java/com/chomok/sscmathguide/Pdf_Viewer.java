package com.chomok.sscmathguide;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;


import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;



public class Pdf_Viewer extends AppCompatActivity {

    private String bdata;
    PDFView pdfView;
    LottieAnimationView animationView;
    public static String assetName = "";
    private AdView mAdView;
    private String TAG ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });




        loadBannerAd();





        //-----------------------------------------------------------//


        pdfView = findViewById(R.id.pdfView);
        animationView = findViewById(R.id.animationView);

        pdfView.setVisibility(View.INVISIBLE);
        animationView.setVisibility(View.VISIBLE);

        pdfView.fromAsset(assetName)
                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {
                        pdfView.setVisibility(View.VISIBLE);
                        animationView.setVisibility(View.GONE);
                    }
                })
                .load();

    }




    //        <----------------bAnner ADS IMPLEMENTION------------>

    private void loadBannerAd() {
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                loadBannerAd();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {

            }

        });
    }


 }

