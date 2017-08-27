package ir.adad.sampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.json.JSONObject;

import ir.adad.client.AdListener;
import ir.adad.client.AdView;
import ir.adad.client.Adad;
import ir.adad.client.InterstitialAdListener;
import ir.adad.client.VideoAdListener;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //***** Adad initialize should get called before setContent if you have bannerAd in this activity.
        Adad.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        ((AdView) findViewById(R.id.banner_ad_view)).setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

            }

            @Override
            public void onAdFailedToLoad() {
                Toast.makeText(MainActivity.this, "Banner ad failed to load", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMessageReceive(JSONObject message) {

            }

            @Override
            public void onRemoveAdsRequested() {
                Toast.makeText(MainActivity.this, "User requested to remove Banner ads from app", Toast.LENGTH_SHORT).show();
                //Move your user to shopping center of your app
            }
        });

        findViewById(R.id.Prepare_interstitial_ad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Adad.prepareInterstitialAd(new InterstitialAdListener() {
                    @Override
                    public void onInterstitialAdDisplayed() {

                    }

                    @Override
                    public void onInterstitialClosed() {

                    }

                    @Override
                    public void onAdLoaded() {
                        Toast.makeText(MainActivity.this, "interstitial Ad loaded", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdFailedToLoad() {
                        Toast.makeText(MainActivity.this, "interstitial Ad failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onMessageReceive(JSONObject message) {

                    }

                    @Override
                    public void onRemoveAdsRequested() {
                        Toast.makeText(MainActivity.this, "User requested to remove interstitial ads from app", Toast.LENGTH_SHORT).show();
                        //Move your user to shopping center of your app

                    }
                });
            }
        });

        findViewById(R.id.show_interstitial_ad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Adad.showInterstitialAd(MainActivity.this);
            }
        });

        findViewById(R.id.load_video_ad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Adad.prepareVideoAd(new VideoAdListener() {
                    @Override
                    public void onVideoAdFinishedPlaying() {
                        Toast.makeText(MainActivity.this,"Video Finished",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onVideoAdInvalidated() {

                    }

                    @Override
                    public void onVideoAdOpened() {

                    }

                    @Override
                    public void onVideoSkipped() {

                    }

                    @Override
                    public void onAdLoaded() {
                        Toast.makeText(MainActivity.this, "Video Ad loaded", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAdFailedToLoad() {

                    }

                    @Override
                    public void onMessageReceive(JSONObject message) {

                    }

                    @Override
                    public void onRemoveAdsRequested() {

                    }
                });
            }
        });

        findViewById(R.id.show_video_ad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Adad.showVideoAd(MainActivity.this);
            }
        });



    }
}
