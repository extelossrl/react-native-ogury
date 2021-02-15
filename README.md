
# react-native-ogury

## Getting started

`$ npm install react-native-ogury --save`

### Mostly automatic installation

`$ react-native link react-native-ogury`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-ogury` and add `RNReactNativeOgury.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeOgury.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibraryogury.RNReactNativeOguryPackage;` to the imports at the top of the file
  - Add `new RNReactNativeOguryPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-ogury'
  	project(':react-native-ogury').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-ogury/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-ogury')
  	```

## Usage
```javascript
import RNReactNativeOgury from 'react-native-ogury';

// TODO: What to do with the module?
RNReactNativeOgury;
```
  