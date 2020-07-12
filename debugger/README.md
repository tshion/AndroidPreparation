# AndroidPreparation.Debugger
Assemble tools for debugging.

## Quick Start
### How to get
You write like this at build.gradle of a module.

``` gradle
dependencies {
    ......
    implementation "work.shion.androidpreparation:debugger:x.x.x"
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

If you want to know a library version, please check [Bintray site][maven_debugger] or [CHANGELOG](./CHANGELOG.md).

### How to use
Please add like this to a custom application class for debugging.
**Do not use in production.**

``` kotlin
class DebugApplication : Application(), IDebugger {
     override fun onCreate() {
         super.onCreate()
         setup(applicationContext)
     }
}
```



## Features
### OSS
* [Hyperion]
→ Please shake a device or tap a notification, and then you will see hyperion menu.
* [LeakCanary]
→ Please check LeakCanary app installed together.
* [Stetho]
→ Please open PC's "Chrome Remote Devices", and then check "inspect".

### Others
* Deeplink tester(Hyperion Extension)
* StrictMode
* WebView debugging



## Links
### Blogs
* [Debugger 1.0.x のリリースノート](https://mokumokulog.netlify.com/tech/20200418061320)

### Products
* [GitHub][gh_debugger]
* [Maven][maven_debugger]

### References
* [LeakCanary]
* [Stetho]
* [StrictMode | Android Developers](https://developer.android.com/reference/android/os/StrictMode.html)
* [WebView | Android Developers](https://developer.android.com/reference/android/webkit/WebView)
* [willowtreeapps/Hyperion-Android][Hyperion]



[gh_debugger]: https://github.com/TentaShion/AndroidPreparation/blob/master/debugger
[Hyperion]: https://github.com/willowtreeapps/Hyperion-Android
[LeakCanary]: https://square.github.io/leakcanary/
[maven_debugger]: https://bintray.com/shion/maven/work.shion.androidpreparation.debugger
[Stetho]: https://facebook.github.io/stetho/
