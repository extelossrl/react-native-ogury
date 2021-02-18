package com.reactlibraryogury;

import android.content.Context;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeMap;
import com.ogury.core.OguryError;
import com.ogury.ed.OguryBannerAdListener;
import com.ogury.ed.OguryBannerAdSize;
import com.ogury.ed.OguryBannerAdView;
import com.ogury.sdk.OguryConfiguration;
import com.ogury.sdk.Ogury;
import com.ogury.cm.OguryChoiceManagerExternal;
import com.ogury.cm.OguryChoiceManager;
import com.ogury.cm.OguryConsentListener;

public class RNReactNativeOguryModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private static final String TAG = "RNReactNativeOguryModul";


  public RNReactNativeOguryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod
  public void init(final String appKey, final Callback errorCallback, final Callback successCallback) {

    Log.e("Ogury", "Initialisation Ogury");
    OguryConfiguration.Builder oguryConfigurationBuilder;
    oguryConfigurationBuilder = new OguryConfiguration.Builder(this.reactContext, appKey);
    Ogury.start(oguryConfigurationBuilder.build());
    // Without choice manager
    //Integer[] nonIabVendorsAccepted = new Integer[0];
    //OguryChoiceManagerExternal.TcfV2.setConsent(this.reactContext, appKey, iabString, nonIabVendorsAccepted);
    // With choice manager

    OguryConsentListener oguryConsentListener = new OguryConsentListener() {

      @Override public void onComplete(OguryChoiceManager.Answer answer) {

        // transmit consent to other vendors' SDKs
        Log.e("Ogury", "oguryConsentListener");
        String consentAnswer = String.valueOf(answer);
        Log.e("Ogury consent answer", consentAnswer);
        String iabString = OguryChoiceManager.TcfV2.getIabString();
        Log.e("Ogury IAB", iabString);
        boolean gdprApplies = OguryChoiceManager.gdprApplies();
        boolean ccpaApplies = OguryChoiceManager.ccpaApplies();


        Log.e("Ogury gdprApplies", String.valueOf(gdprApplies));

        WritableNativeMap map = new WritableNativeMap();
        map.putString("consentAnswer", consentAnswer);
        map.putString("iabString", iabString);
        map.putBoolean("gdprApplies", gdprApplies);
        map.putBoolean("ccpaApplies", ccpaApplies);
        successCallback.invoke(map);
      }
      @Override public void onError(OguryError error) {
        // handle error
        Log.e("Ogury", "transmit consent error");
        errorCallback.invoke();
      }
    };
    OguryChoiceManager.ask(getCurrentActivity(), oguryConsentListener);
    //OguryChoiceManager.edit(getCurrentActivity(), oguryConsentListener);
  }

  @Override
  public String getName() {
    return "RNReactNativeOgury";
  }
}