# Gradleの共通設定

## Gradle全般

Gradle全般の方針としてGroovyベースからKotlinベースに移行する流れ  
build.gradle.ktsのようにKotlin版は.ktsがつく  
ただKotlin版だとeclipseでうまく扱えないから当面Gradleを使う方針

## plugins

* io.spring.dependency-management  
GradleでMavenのようにBOMを扱うためのプラグイン

### テスト

* testImplementation  "org.junit.jupiter:junit-jupiter-api:${version_junit}"
* testImplementation  "org.junit.jupiter:junit-jupiter-params:${version_junit}"
* testImplementation  "org.junit.platform:junit-platform-launcher:${version_junit_platform}"
* testRuntimeOnly     "org.junit.jupiter:junit-jupiter-engine:${version_junit}"  
JUnit5の根幹部分の依存プラグイン  
APIで基礎部分とparamsでパラメータplatformランチャーで実行環境  
エンジンが実行時のJUnitエンジン  

* testImplementation  "org.springframework.boot:spring-boot-starter-test:${version_spring_boot}"  
Spring Bootのテスト連携用のプラグイン  
