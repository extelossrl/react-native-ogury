
import { NativeModules, requireNativeComponent } from 'react-native';

const { RNReactNativeOgury } = NativeModules;

const RNOguryBanner320x50 = requireNativeComponent('RNOguryBanner320x50');
const RNOguryBannerMPU = requireNativeComponent('RNOguryBannerMPU');

async function RNReactNativeOguryInit(appKey) {
  const result = await new Promise((resolve, reject) => {
    RNReactNativeOgury.init(appKey, reject, resolve);
  });

  return result;
}



module.exports = {
  RNReactNativeOgury: RNReactNativeOgury,
  RNOguryBanner320x50: RNOguryBanner320x50,
  RNOguryBannerMPU: RNOguryBannerMPU,
  RNReactNativeOguryInit: RNReactNativeOguryInit
  
  
}
