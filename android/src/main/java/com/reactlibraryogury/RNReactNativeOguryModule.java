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
import com.ogury.cm.OguryChoiceManagerExternal;
import com.ogury.cm.OguryChoiceManager;
import com.ogury.cm.OguryConsentListener;

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
    // Without choice manager
    //Integer[] nonIabVendorsAccepted = new Integer[0];
    //OguryChoiceManagerExternal.TcfV2.setConsent(this.reactContext, appKey, iabString, nonIabVendorsAccepted);
    // With choice manager
    OguryChoiceManager.ask(getCurrentActivity(), oguryConsentListener);
    //OguryChoiceManager.edit(getCurrentActivity(), oguryConsentListener);
  }

  private final OguryConsentListener oguryConsentListener = new OguryConsentListener() {
    @Override public void onComplete(OguryChoiceManager.Answer answer) {
      // transmit consent to other vendors' SDKs
      Log.e("Ogury", "oguryConsentListener");
      String consentAnswer = String.valueOf(answer);
      Log.e("Ogury consent answer", consentAnswer);
      String iabString = OguryChoiceManager.TcfV2.getIabString();
      Log.e("Ogury IAB", iabString);
      boolean gdprAccepted = OguryChoiceManager.gdprApplies();
      Log.e("Ogury gdprApplies", String.valueOf(gdprAccepted));
    }
    @Override public void onError(OguryError error) {
      // handle error
      Log.e("Ogury", "transmit consent error");
    }
  };
  @Override
  public String getName() {
    return "RNReactNativeOgury";
  }
}