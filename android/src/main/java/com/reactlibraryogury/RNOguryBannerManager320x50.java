package com.reactlibraryogury;

import android.util.Log;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.ogury.core.OguryError;
import com.ogury.ed.OguryBannerAdListener;
import com.ogury.ed.OguryBannerAdSize;
import com.ogury.ed.OguryBannerAdView;
import com.facebook.react.uimanager.SimpleViewManager;

import javax.annotation.Nonnull;

public class RNOguryBannerManager320x50 extends SimpleViewManager<OguryBannerAdView> {
    private static final String REACT_CLASS = "RNOguryBanner320x50";
    private static String TAG = "Banner";

    @Nonnull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Nonnull
    @Override
    protected OguryBannerAdView createViewInstance(@Nonnull ThemedReactContext reactContext) {
        OguryBannerAdView banner;
        banner = new OguryBannerAdView(reactContext);
        banner.setAdSize(OguryBannerAdSize.SMALL_BANNER_320x50);
        banner.setListener(new OguryBannerAdListener() {
            @Override
            public void onAdLoaded() {

            }

            @Override
            public void onAdDisplayed() {

            }

            @Override
            public void onAdClicked() {

            }

            @Override
            public void onAdClosed() {

            }

            @Override
            public void onAdError(OguryError oguryError) {
                Log.d(TAG, "ogurry error " + oguryError);
            }
        });
        return banner;
    }

    @ReactProp(name="adUnitId")
    public void setAdUnitId(OguryBannerAdView view, String adUnitId) {
        view.setAdUnit(adUnitId);
        view.loadAd();
    }
}
