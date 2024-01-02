# Spring Boot

## 概要

SpringBootの3.2.1が最新バージョン  
3.2.1はJavaの17以上が必要、21までは対応している  
デフォルトのビルドツールはGradle(Gradle 7.5以上)  
サーブレットコンテナはデフォルトでTomcat（Tomcat 10.1　サーブレットバージョン 6.0）  
GraalVMのネイティブイメージ化に対応している（Javaをネイティブコードに出力して高速化する機能）  

### インストール

SpringBootのインストールは特別なインストールは必要なく、spring-boot-*.jarのjarファイルをクラスパスに含めれば使える  
ただし基本的にGradleとかのビルドツールを使ってバージョン管理などを行う  
SpringCLIを使えばEclipseとかのIDEを使わなくてもある程度開発を支援できる  
インストールは公式のbinファイルをダウンロードして環境変数に含める  

### 基本的な開発

基礎的なGradleの構成は下記  
```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.1'
}

apply plugin: 'io.spring.dependency-management'

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

repositories {
    mavenCentral()
}

dependencies {
}
```
apply plugin: 'io.spring.dependency-management'を入れていると依存関係の管理ができる  
具体的にはSpringBoot関係の依存関係のversionを省略でき、  
またgradle dependenciesでプロジェクトのBOMを管理できる  
