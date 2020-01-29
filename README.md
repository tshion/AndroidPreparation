# AndroidPreparation
Android 開発で使う下ごしらえ集

## ライブラリ一覧
ライブラリ | レベル | jCenter | maven | 用途
--- | --- | --- | --- | ---
[Baser](./baser/README.md) | templates |  |  | 共通機能の整備
[Debugger](./debugger/README.md) | organisms |  | [maven][maven_debugger] | デバッグ支援モジュール
IntentBuilder | atoms |  | [maven][maven_intentbuilder] | Intent の組み立て
[Views](./views/README.md) | organisms |  |  | UI パーツなどの表示関連
WebViewBuilder | atoms or molecules |  |  | WebView の組み立て、破棄


## ライブラリ構成
![ライブラリ構成](https://tentashion.github.io/AndroidPreparation/uml/%E3%83%A9%E3%82%A4%E3%83%96%E3%83%A9%E3%83%AA%E6%A7%8B%E6%88%90.png)


## 参考文献



[maven_debugger]: https://bintray.com/shion/maven/work.shion.androidpreparation.debugger
[maven_intentbuilder]: https://bintray.com/shion/maven/work.shion.androidpreparation.intentbuilder
