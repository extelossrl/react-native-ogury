
package com.reactlibraryogury;

import android.content.Context;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.ogury.sdk.OguryConfiguration;
import com.ogury.sdk.Ogury;

public class RNReactNativeOguryModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNReactNativeOguryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod
  public void init(String appKey) {
    Log.e("Ogury", "Initialisation Ogury");
    Context context = reactContext.getCurrentActivity();
    OguryConfiguration.Builder oguryConfigurationBuilder;
    oguryConfigurationBuilder = new OguryConfiguration.Builder(context, appKey);
    Ogury.start(oguryConfigurationBuilder.build());
  }
  @Override
  public String getName() {
    return "RNReactNativeOgury";
  }
}