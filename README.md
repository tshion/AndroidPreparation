# AndroidPreparation
A boilerplate of android development.
It's too complex to handle all in one library, so I divide partially.

Module Level(※1) | Library | Distributor | Note
:---: | --- | --- | ---
atoms | [IntentBuilder](./intentbuilder) | [Bintray][maven_intentbuilder] | Helper for implicit intent
atoms | [WebViewBuilder](./webviewbuilder/) | [Bintray][maven_webviewbuilder] | Helper for setting parameters of webview
organisms | [Debugger](./debugger) | [Bintray][maven_debugger] | Assemble tools for debug
organisms | [Views](./views) | [Bintray][maven_views] | UI parts

※1: I judge module level by rule like atomic design.<br />


![ライブラリ構成](./docs/uml/%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA%E6%A7%8B%E6%88%90.png)


## Links
### Use Services
* [Bintray](https://bintray.com)


[maven_debugger]: https://bintray.com/shion/maven/work.shion.androidpreparation.debugger
[maven_intentbuilder]: https://bintray.com/shion/maven/work.shion.androidpreparation.intentbuilder
[maven_views]: https://bintray.com/shion/maven/work.shion.androidpreparation.views
[maven_webviewbuilder]: https://bintray.com/shion/maven/work.shion.androidpreparation.webviewbuilder
