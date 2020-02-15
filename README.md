# AndroidPreparation
A boilerplate of android development.
It's too complex to handle all in one library, so I divide partially.

Module Level(※1) | Library | Beta(※2) | Product(※3) | note
:---: | --- | --- | --- | ---
atoms | [IntentBuilder](./intentbuilder/README.md) | [Maven][maven_intentbuilder] |  | Helper for implicit intent
atoms | WebViewBuilder |  |  | Helper for handling webview
organisms | [Debugger](./debugger/README.md) | [Maven][maven_debugger] |  | Assemble tools for debug
organisms | [Views](./views/README.md) | [Maven][maven_views] |  | UI parts
templates | [Baser](./baser/README.md) | [Maven][maven_baser] |  | (Now thinking)

※1: I judge module level by rule like atomic design.<br />
※2: I publish a prerelease library to maven by bintray.<br />
※3: I publish a release library to jCenter by bintray.<br />


![ライブラリ構成](./docs/uml/%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA%E6%A7%8B%E6%88%90.png)


## Links
### Use Services
* [Bintray](https://bintray.com)



[maven_baser]: https://bintray.com/shion/maven/work.shion.androidpreparation.baser
[maven_debugger]: https://bintray.com/shion/maven/work.shion.androidpreparation.debugger
[maven_intentbuilder]: https://bintray.com/shion/maven/work.shion.androidpreparation.intentbuilder
[maven_views]: https://bintray.com/shion/maven/work.shion.androidpreparation.views
