RTDevLib
========

how to compile the library:

1) build so if needed
```
   $ cd $(PATH)
   $ ndk-build clean
   $ ndk-build
```
2) use eclipse for importing the rtdevlib and sample


3) make sure the min-sdk value is 8 and no target-sdk field
```
   <uses-sdk android:minSdkVersion="8" />
```
4) clean all and run sample
