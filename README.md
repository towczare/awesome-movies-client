# Awesome Movies - Client

Client for Awesome Movies project. No sexy js framework but, hey this is Java bootcamp!

[Live demo](https://awesome-movies-client.herokuapp.com/)

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
* Java 1.8

### Installing
```
./mvnw clean install 
```
### Run local version
Configuration is stored in common file located:
`awesome-movies-client\src\main\resources\application.properties`
to run application use following command:
```
java -jar target/awesome-movies-client-0.0.1-SNAPSHOT.jar
```
### Run dev version
To run application with `dev` profile:
```
java -jar target/awesome-movies-client-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```

### Acessing babun terminal via InteliJ
1. Edit/Create following file `embed.bat` located `C:\Users\tomic\.babun`
```
@echo off

c:
chdir C:\Users\tomic\.babun\cygwin\bin

bash --login -i
```
2. Set terminal to call embed.bat file
![GitHub Logo](/images/babun3.png)
