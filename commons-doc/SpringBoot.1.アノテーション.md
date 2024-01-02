# Spring Bootアノテーション

## 概要

SpringBoot用のアノテーションとSpring本来のアノテーションとがある  
機能面のアノテーションはだいたいSpring本来のアノテーション

## 全体

* @SpringBootApplication

## Web

* @RestController  
REST形式のWebリクエスト受信部分のControllerのマークアノテーション  
クラス単位に設定  

* @RequestMapping  
ルーティング情報を設定するアノテーション  
/homeとかのパスを定義する  
関数単位に設定  

