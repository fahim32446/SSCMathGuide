package com.chomok.sscmathguide;


import static com.google.android.play.core.install.model.AppUpdateType.IMMEDIATE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.Task;

import java.util.Random;


public class Dashboard extends AppCompatActivity {

    private String TAG;
    private String getUnit, bdata;
    MaterialCardView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private long Timeback;

    private static int UPDATE_CODE = 1000;
    private int retry = 0;
    AppUpdateManager appUpdateManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


//        appUpdateManager = AppUpdateManagerFactory.create(this);
//        InAppUpdate.setImmediateUpdate(appUpdateManager, this);



//        AdMob Ads
        loadBannerAd();
        inAppUpdate();


        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        c10 = findViewById(R.id.c10);
        c11 = findViewById(R.id.c11);
        c12 = findViewById(R.id.c12);
        c13 = findViewById(R.id.c13);
        c14 = findViewById(R.id.c14);
        c15 = findViewById(R.id.c15);
        c16 = findViewById(R.id.c16);
        c17 = findViewById(R.id.c17);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPdf("1.pdf");

//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        interAds();
//                    }
//                }, 5000);
//
//
//
//                Pdf_Viewer.assetName= "1.pdf";
//                Intent myIntent = new Intent(Dashboard.this, Pdf_Viewer.class);
//                startActivity(myIntent);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("2.pdf");

            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("3.pdf");
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("4.pdf");
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("5.pdf");
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("6.pdf");
            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("7.pdf");
            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("8.pdf");
            }
        });

        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("9.pdf");
            }
        });

        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("10.pdf");
            }
        });

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("11.pdf");
            }
        });

        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("12.pdf");
            }
        });

        c13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("13.pdf");
            }
        });

        c14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("14.pdf");
            }
        });

        c15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("15.pdf");
            }
        });

        c16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("16.pdf");
            }
        });

        c17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf("17.pdf");

            }
        });

        loadFullscreenAd();
    }

    public void onBackPressed() {
        if (System.currentTimeMillis() - Timeback > 1000) {
            Timeback = System.currentTimeMillis();
            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
            return;
        }
        super.onBackPressed();
    }

    private void inAppUpdate(){

        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(this);

        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
        appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    && appUpdateInfo.isUpdateTypeAllowed(IMMEDIATE)) {

                try {
                    appUpdateManager.startUpdateFlowForResult( appUpdateInfo, IMMEDIATE,
                            Dashboard.this,UPDATE_CODE);
                } catch (IntentSender.SendIntentException e) {
                    e.printStackTrace();
                }
            }
        });
        appUpdateManager.registerListener(listener);
    }

    InstallStateUpdatedListener listener = state -> {
        if (state.installStatus() == InstallStatus.DOWNLOADED) {
            popupSnackbarForCompleteUpdate();
        }
    };

    private void popupSnackbarForCompleteUpdate() {
        Snackbar snackbar =
                Snackbar.make(
                        findViewById(R.id.content),
                        "An update has just been downloaded.",
                        Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("RESTART", view -> appUpdateManager.completeUpdate());
        snackbar.setActionTextColor(
                getResources().getColor(R.color.purple_700));
        snackbar.show();
    }



//    @Override
//    protected void onResume() {
//        super.onResume();
//        InAppUpdate.setImmediateUpdateOnResume(appUpdateManager, this);
//    }


//        <----------------bAnner ADS IMPLEMENTION------------>

    private void loadBannerAd() {
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                loadBannerAd();
            }
        });
    }


//        <----------------Inter ADS IMPLEMENTION------------>


    public void loadFullscreenAd() {


        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, getString(R.string.admob_INTERSTITIAL_UNIT_ID),
                adRequest,
                new InterstitialAdLoadCallback() {

                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });


        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        } else {

        }
    }





//        <----------------Open PDF and ADS after 5 sec ------------>

    public void openPdf(String p) {

        Pdf_Viewer.assetName = p;
        Intent myIntent = new Intent(Dashboard.this, Pdf_Viewer.class);
        startActivity(myIntent);



        Random random = new Random();
        int myCount= random.nextInt(100-5)+5;
        if(myCount%2 ==0){
            loadFullscreenAd();
        }

    }


//        <----------------Define InterAds ------------>


}