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

If you want to get by maven, please add like this at build.gradle of a project.

``` gradle
repositories {
    ......
    maven {
        url 'https://dl.bintray.com/shion/maven'
    }
}
```

If you want to know a library version, please check [Bintray site][maven_intentbuilder].

### How to use
Please create a builder you want, and then call ```start()```.
For example, to open browser, like this.

``` kotlin
OpenMailerIntentBuilder()
    .appendAttachmentUris(uri)
    .appendBcc("test2@example.test")
    .appendCc("test3@example.test")
    .appendTo("test1@example.test")
    .subject("subject")
    .text("mail body text")
    .build()
    .start(from)
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
### Blogs
* [IntentBuilder 1.0.x のリリースノート](https://mokumokulog.netlify.com/tech/20200314120638)

### Products
* [GitHub][gh_intentbuilder]
* [Maven][maven_intentbuilder]

### References
* [Common Intents | Android Developers](https://developer.android.com/guide/components/intents-common)



[gh_intentbuilder]: https://github.com/TentaShion/AndroidPreparation/blob/master/intentbuilder
[maven_intentbuilder]: https://bintray.com/shion/maven/work.shion.androidpreparation.intentbuilder
