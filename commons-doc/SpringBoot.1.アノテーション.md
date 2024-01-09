# Spring Bootアノテーション

## 概要

SpringBoot用のアノテーションとSpring本来のアノテーションとがある  
機能面のアノテーションはだいたいSpring本来のアノテーション

## 全体

* @SpringBootApplication  
@SpringBootConfiguration、@EnableAutoConfiguration、@ComponentScanの混合アノテーション  
@EnableAutoConfigurationはJarの依存関係によってSpringBootの構成を自動で決める（webがあればWebアプリ、等）  
@ComponentScanは対象のクラスが所属するパッケージでコンポーネントスキャンを有効にする  
@SpringBootConfigurationはコンテキスト内の追加のBean登録などを有効にする  

``` java
@SpringBootApplication
     ↓のように分解もできる
@SpringBootConfiguration(proxyBeanMethods = false)
@EnableAutoConfiguration
@Import({ SomeConfiguration.class, AnotherConfiguration.class }) //importなのでコンポーネントスキャンはされない
```

## Web

* @RestController  
REST形式のWebリクエスト受信部分のControllerのマークアノテーション  
クラス単位に設定  

* @RequestMapping  
ルーティング情報を設定するアノテーション  
/homeとかのパスを定義する  
クラス、関数単位に設定  
