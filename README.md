# Sort Service Technical Assessment (StormTech)

## Introduction

Sort service is a server application that receives a receives a web clients requests, which send a list of books through a xml file containing some attributes such as Title, Author and Edition Year.
This in turn sorts the books following some criterias such as Priorite Order of Attributes, Ascending and Descending. Then the result it is shown to the user through the Web Page of Sort Service.

## Requirements

* Linux Ubuntu 14.04 or Other Operational System that supports Java Runtime Enviroment 8
* Java Runtime Environment (JRE)  - Download http://www.oracle.com/technetwork/pt/java/javase/downloads/jre8-downloads-2133155.html
* Apache Tomcat 7 - Download http://tomcat.apache.org/download-70.cgi

## Setup Instructions

### 1. Java Runtime Environment 8 (JRE 8)

Add webupd8team Java PPA repository in your system and install Oracle Java 8 using following set of commands.

```
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt-get update
$ sudo apt-get install oracle-java8-installer
```
After successfully installing oracle Java using above step verify installed version using following command.

```
$ java -version
```

A similar message as the bellow will be showed.

```
java version "1.8.0_101"
Java(TM) SE Runtime Environment (build 1.8.0_101-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.101-b13, mixed mode)
```

Using apt-get, you can set up automaticaly the Java 8 environment variables simply by installing the following package.

```
$ sudo apt-get install oracle-java8-set-default
```

### 2. Apache Tomcat

Using the apt-get like package manager, open the shell and type this commands

```sh
$ sudo apt-get update
$ sudo apt-get install tomcat7
```

By default Tomcat runs a HTTP connector on port 8080 and an AJP connector on port 8009. You might want to change those default ports to avoid conflict with another application on the system. This is done by changing the following lines in /etc/tomcat7/server.xml:

Open the tomcat file configuration

```sh
$ sudo nano /etc/tomcat7/server.xml
```

Go to the item "Connector port" and type your port preference to running the tomcat.

```sh
<Connector port="8080" protocol="HTTP/1.1" 
               connectionTimeout="20000" 
               redirectPort="8443" />
...
<Connector port="8009" protocol="AJP/1.3" redirectPort="8443" />
```

Go to the line "Host" Property and check if autoDeploy and unpackWars option is enabled.

```
<Host name="localhost" appBase="webapps" unpackWars="true" autoDeploy="true" startStopThreads="-1">
```


Save your changes and exit.

Restart Tomcat service.

```
$ sudo service tomcat7 restart
```

**In order to upload an application, permissions for the webapps directory have to be modified to allow tomcat user to upload files to that directory. The recommended setup is to add change group ownership of installdir/apache-tomcat/webapps directory to tomcat and change permissions to allow write access to group. We do it automatically for each new launched server. If you still get permissions errors, please execute the following commands:**

```
$ chgrp tomcat installdir/apache-tomcat
$ chmod 0775 installdir/apache-tomcat
```

**Done Your environment is ready to deploy the sort service books.**

## Deploy Sort Service

This section describes the necessary steps to deploy a sort service book in a tomcat server.

Clone the sort service repository (Can you download into the [Github Page] or clone with a git command)

> Enter your preferred directory and type the following command...

```
$ git clone https://github.com/erk360/SortService.git

```

Copy and past the war file to the tomcat web application directory.

```
$ sudo cp [pathToWar] /var/lib/tomcat7/webapps
```

Restart tomcat Service

```
$ sudo service tomcat7 restart
```

After restart Tomcat, check if the sort service is running.

```
$ curl -Is http://localhost:[tomcat port]/SortService/index.jsp | head -n 1
```

>`Example: curl -Is http://localhost:8080/SortService/index.jsp | head -n 1`

The response should be something like...

```
HTTP/1.1 200 OK
```

Done, Sort Service is running correctly.

## **Subimission**

## Client Test

Go to the Sort Service repository (downloaded previously) and copy the Books.xml to the user main directory.

>`Example: /home/user/downloads/SortService/Test/Books.xml`

Open your preferred web browser and type the url...

```
http://[IP Address]:[Tomcat Port]/SortService/index.jsp
```

>`Example: http://localhost:8080/SortService/index.jsp`


Configure the Sort Rules.


> 1. Choose a sort attribute (Title, Author or Edition Year)
> 2. Check the sort criteria (Ascending or Descending) for each sort attribute selected.
> 3. Choose a priorite order (1,2 or 3) for each attibute selected.
> 4. Browse and Upload (Select XML Book File) a Data Book File [Books.xml] copied previously.

#### Check the "Sorting result" Field with the result sort of books.

### By Erick Rafael
 
[//]: # (Links References used in the body MarkDown)
[Github Page]: <https://github.com/erk360/SortService>
