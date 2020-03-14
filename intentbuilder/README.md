# AndroidPreparation.IntentBuilder
Helper for implicit intent.

## Quick Start
### How to get
You write like this at build.gradle of a module.

``` gradle
dependencies {
    ......
    implementation "work.shion.androidpreparation:intentbuilder:x.x.x"
}
```

If you want to get a beta-release, please add like this at build.gradle of a project.

``` gradle
repositories {
    ......
    maven {
        url 'https://dl.bintray.com/shion/maven'
    }
}
```

If you want to know a library version, please check [Bintray site][maven_intentbuilder].

※Be careful, I publish a beta-release by Maven, a product-release by jCenter.

### How to use
Please create a builder you want, and then call ```start()```.
For example, to open browser, like this.

``` kotlin
OpenBrowserIntentBuilder().apply {
    trySetUri("https://mokumokulog.netlify.com/")
}.build()?.start(from)
 ```

Note: ```from``` is an activity or a fragment instance.



## Features
Want to do | Class Name
--- | ---
Call directly | [CallPhoneIntentBuilder](https://github.com/TentaShion/AndroidPreparation/blob/master/intentbuilder/src/main/java/work/shion/androidpreparation/intentbuilder/CallPhoneIntentBuilder.kt)
Call voice mail directly | [CallVoiceMailIntentBuilder](https://github.com/TentaShion/AndroidPreparation/blob/master/intentbuilder/src/main/java/work/shion/androidpreparation/intentbuilder/CallVoiceMailIntentBuilder.kt)
Launch a mail app | [OpenMailerIntentBuilder](https://github.com/TentaShion/AndroidPreparation/blob/master/intentbuilder/src/main/java/work/shion/androidpreparation/intentbuilder/OpenMailerIntentBuilder.kt)
Launch a map app | [OpenMapIntentBuilder](https://github.com/TentaShion/AndroidPreparation/blob/master/intentbuilder/src/main/java/work/shion/androidpreparation/intentbuilder/OpenMapIntentBuilder.kt)
Launch a phone app | [LaunchPhoneIntentBuilder](https://github.com/TentaShion/AndroidPreparation/blob/master/intentbuilder/src/main/java/work/shion/androidpreparation/intentbuilder/LaunchPhoneIntentBuilder.kt)
Launch a phone app and show voice mail | [OpenVoiceMailIntentBuilder](https://github.com/TentaShion/AndroidPreparation/blob/master/intentbuilder/src/main/java/work/shion/androidpreparation/intentbuilder/OpenVoiceMailIntentBuilder.kt)
To initiate a web search | [SearchWebIntentBuilder](https://github.com/TentaShion/AndroidPreparation/blob/master/intentbuilder/src/main/java/work/shion/androidpreparation/intentbuilder/SearchWebIntentBuilder.kt)
To open a web page | [OpenBrowserIntentBuilder](https://github.com/TentaShion/AndroidPreparation/blob/master/intentbuilder/src/main/java/work/shion/androidpreparation/intentbuilder/OpenBrowserIntentBuilder.kt)



## Links
### Products
* [GitHub][gh_intentbuilder]
* [Maven][maven_intentbuilder]

### References
* [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common)



[gh_intentbuilder]: https://github.com/TentaShion/AndroidPreparation/blob/master/intentbuilder
[maven_intentbuilder]: https://bintray.com/shion/maven/work.shion.androidpreparation.intentbuilder
