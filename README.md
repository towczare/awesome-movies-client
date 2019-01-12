# Awesome Movies - Client

[![CodeFactor](https://www.codefactor.io/repository/github/towczare/awesome-movies-client/badge)](https://www.codefactor.io/repository/github/towczare/awesome-movies-client)

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

1. Create account on [The Movie DB](https://www.themoviedb.org) to get access to open movie API.
2. Add new environment variable `THE_MOVIE_DB_API_KEY` representing `api_key` example:
```
THE_MOVIE_DB_API_KEY=mysecretapikey12345
```
3. All configurations are stored in common file located:
`awesome-movies-client\src\main\resources\application.properties`
4. To run application use following command:
```
java -jar target/awesome-movies-client-0.0.1-SNAPSHOT.jar
```
### Run dev version
To run application with `dev` profile:
```
java -jar target/awesome-movies-client-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```

### Accessing babun terminal via IntelliJ
1. Edit/Create following file `embed.bat` located `C:\Users\tomic\.babun`
```
@echo off

c:
chdir C:\Users\tomic\.babun\cygwin\bin

bash --login -i
```
2. Set terminal to call embed.bat file

![GitHub Logo](/images/babun3.png)
