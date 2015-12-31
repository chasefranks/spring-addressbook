# Spring Addressbook

## Description
This is a simple address book written in the Spring framework, with MongoDB as the backend database.

## Prerequisites

* Java 8
* maven
* [MongoDB](https://www.mongodb.org/downloads#production)

Install MongoDB with the defaults to try this app out. Start up Mongo after installation by typing

```
mongod
```

or you can isolate the data and log files for your mongod instance by starting it with a configuration file

```
mongod --config mongod.conf
```

where mongod.conf looks like

```
systemLog:
  destination: file
  path: log/mongodb/mongo.log
  logAppend: true
storage:
  dbPath: data/db 
net:
  bindIp: 127.0.0.1
```

## Building and running

This is a Spring Boot application. Spring Boot is a set of tools built for the Spring framework to ease development and deployment of Spring applications. To learn about Spring boot, anything you could want to know is in the reference docs

[Spring Boot](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

To get up and running, simply clone this project to your desktop, cd into the project directory and type

```
mvn spring-boot:run
```

to build and run the app inside of an embedded Tomcat instance. You should be able to see the app by visiting

http://localhost:8080/

in a web browser.

## Features

* Spring MVC/Freemarker Templates
* MongoDB