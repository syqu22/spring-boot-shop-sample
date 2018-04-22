# Spring Boot - Shop Sample
[![Build Status](https://travis-ci.org/syqu22/spring-shop-demo.svg?branch=master)](https://travis-ci.org/syqu22/spring-shop-demo)

![](src/main/resources/static/images/brand.png) 

## Description

This is my first project using Spring. I wanted to do e-commerce web application to learn Spring. I have used **Spring Boot**, **Spring Security**, **Spring Data JPA** with **H2 database**, for views i have used **Thymeleaf** template. This project is still in progress and im adding new features regularly.

## Installation

You can clone this repository and use it localy:
```sh
$ git clone https://github.com/syqu22/spring-boot-shop-sample.git
```
After that you should do clean install using Maven command:
```sh
$ mvnw clean install
```

## Logins

Initially there are 2 users in memory:

Login: ```admin``` Password: ```admin``` with **ADMIN** role.

Login: ```user``` Password: ```user``` with **USER** role.

## Roles

**ADMIN** can add, edit and delete products.

**USER** can add products to shopping cart and buy them.
