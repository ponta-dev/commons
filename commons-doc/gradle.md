# Gradleの共通設定

## Gradle全般

Gradle全般の方針としてGroovyベースからKotlinベースに移行する流れ  
build.gradle.ktsのようにKotlin版は.ktsがつく  
ただKotlin版だとeclipseでうまく扱えないから当面Gradleを使う方針

## plugins

* io.spring.dependency-management  
GradleでMavenのようにBOMを扱うためのプラグイン
