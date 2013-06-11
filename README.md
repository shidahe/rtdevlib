RTDevLib
========
the common library for android developers

# how to compile

1) get the icecreamsandwich jar with full source
```
   $ wget http://rarnu.7thgen.info/downloads/icecreamsandwich15.jar
```
2) backup your android.jar in $(ANDROID_SDK)/platforms/android-15/
```
   $ mv $(ANDROID_SDK)/platforms/android-15/android.jar ./backup/
```
3) replace android.jar said above with the downloaded file
```
   $ mv icecreamsandwich15.jar android.jar
   $ cp android.jar $(ANDROID_SDK)/platforms/android-15/
```
4) import and fix rtdevlib
```
   $ android update project -n rtdevlib -p . -t android-15
```
5) build so if needed
```
   $ cd $(PROJECT)
   $ ndk-build clean
   $ ndk-build
```

# build sample

1) import and fix sample under rtdevlib
```
   $ android update project -n sample -p . -t android-15
```
2) build sample
```
   $ cd $(PROJECT)
   $ ant debug
```

# install and start sample
```
   $ adb install -r sample.apk
   $ adb shell am start -n com.rarnu.devlib.demo/.MainActivity
```
