
import { NativeModules } from 'react-native';

const { RNReactNativeOgury } = NativeModules;

const RNOguryBanner320x50 = requireNativeComponent('RNOguryBanner320x50');
const RNOguryBannerMPU = requireNativeComponent('RNOguryBannerMPU');


module.exports = {
  RNReactNativeOgury: RNReactNativeOgury,
  RNOguryBanner320x50: RNOguryBanner320x50,
  RNOguryBannerMPU: RNOguryBannerMPU
  
  
}
