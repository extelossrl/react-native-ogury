
package com.reactlibraryogury;

import android.content.Context;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.ogury.core.OguryError;
import com.ogury.ed.OguryBannerAdListener;
import com.ogury.ed.OguryBannerAdSize;
import com.ogury.ed.OguryBannerAdView;
import com.ogury.sdk.OguryConfiguration;
import com.ogury.sdk.Ogury;

public class RNReactNativeOguryModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private static final String TAG = "RNReactNativeOguryModule";

  public RNReactNativeOguryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod
  public void init(String appKey) {
    Log.e("Ogury", "Initialisation Ogury");
    OguryConfiguration.Builder oguryConfigurationBuilder;
    oguryConfigurationBuilder = new OguryConfiguration.Builder(this.reactContext, appKey);
    Ogury.start(oguryConfigurationBuilder.build());


  }
  @Override
  public String getName() {
    return "RNReactNativeOgury";
  }
}