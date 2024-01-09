# Spring Boot 環境設定

## 概要

設定ファイルやコマンドライン引数などの設定の作成、読み込み順など  
Spring Bootは設定値をYAMLのプロパティファイルやコマンドラインなど様々な方法で定義できる  
設定した値は@Valueアノテーションでアクセスできる他、各機能に読み込まれる  

## 設定のオーバーライド順

Spring Bootの設定の読み込み順は下記の通り  
後半で読み込む方法に手を加えることで環境に合わせて設定の上書き等が可能  

1. デフォルトのプロパティ（SpringApplication.setDefaultPropertiesの設定）
2. @Configurationクラスの@PropertySourceアノテーションによる設定  
この設定はEnvironmentに読み込まれるタイミングが遅いのでログやspring.main.*など特定のプロパティの設定に向かない
3. 設定ファイル（application.propertiesファイルなど）
4. random.* のみにプロパティを持つ RandomValuePropertySource
5. OSの環境変数
6. Javaシステムプロパティ（System.getProperties()）
7. java:comp/env からの JNDI 属性
8. ServletContext 初期化パラメーター
9. ServletConfig 初期化パラメーター
10. SPRING_APPLICATION_JSON のプロパティ
11. コマンドライン引数
12. テストの properties 属性
13. テスト内の @DynamicPropertySource
14. テストに関する @TestPropertySource
15. devtools がアクティブな場合、$HOME/.config/spring-boot ディレクトリの Devtools グローバル設定プロパティ

環境変数で設定を上書きする場合、.の代わりに_が使える  
例えばspring.config.nameをSPRING_CONFIG_NAMEに読み替えることができる  
コマンドラインで設定値を上書きする場合、実行時のコマンドに--の設定値を追加する  
例えば--server.port=8080のように記載するとserver.portの設定が上書きされる  

## 設定ファイルの読み込み

application.properties(またはapplication.yml)の読み込み順は下記の通り

1. jar内にパッケージ化されたapplication.properties(yml)
2. jar内にパッケージ化されたapplication-{profile}.properties(yml)
3. jarの外に置いたapplication.properties(yml)
4. jarの外に置いたapplication-{profile}.properties(yml)

propertiesファイルとymlファイルが混在する場合propertiesファイルが優先される  
設定ファイルはアプリケーションの起動時に次の場所から自動的にロードする  

* クラスパスのルート
* クラスパス/configパッケージ
* カレントディレクトリ直下
* カレントディレクトリ/configディレクトリ

spring.config.locationプロパティに設定することで読み込み場所を明示することもできる  

### ランダム値の利用

下記のように設定値にランダム値を埋め込める

``` yaml
my:
  secret: "${random.value}"
  number: "${random.int}"
  bignumber: "${random.long}"
  uuid: "${random.uuid}"
  number-less-than-ten: "${random.int(10)}"
  number-in-range: "${random.int[1024,65536]}"
```
