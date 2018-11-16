# Apache Camel Fun

## Introduction

Java project demonstrating using CXF, Apache Camel and Springboot.
This app is more or less and play app to research new technologies or 
to play with various integration points.

Since I am a diver the obvious choice was to use an app themed around that.

Currently the app loads data from data.sql to a h2 database, you can use the 
h2 console to view and manipulate data.

Also included is HawtIO
## Docker

Build
```$console
mvn clean install dockerfile:build
```

Run
```text
docker run -p 8080:8080 mcarr/apache-camel-fun
```

## Links

* WSDL http://localhost:8080/service/DiveDetailsPort?wsdl
* Hawtio http://localhost:8080/actuator/hawtio

* H2 Console
    ```aidl
    JDBC URL: jdbc:h2:mem:testdb
    User Name: sa
    Pasword: <leave this empty>
    ```
    
    