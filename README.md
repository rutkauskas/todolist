# Todo List web application
This application consists of React frontend and Springboot backend.

###### To build and run backend locally using docker
Navigate to /backend and use following command to build image:
```
docker -t todobackend .
```
To run container use:
```
docker run -p 8080:8080 --name todobackend-container todobackend
```
Backend is now accessible on port http://localhost:8080

###### To build and run front using docker
Navigate to /front and use following command to build image:
```
docker -t todofrontend .
```
To run container use:
```
docker run -p 5000:5000 --name todobackend-container todobackend
```
Frontend is now accessible on port http://localhost:5000

###### To build and run backend locally
You will need Java 11 and Gradle 5.2.1
Navigate to /backend and use:
```
gradle build
```
To run jar file use:
```
java -jar ./build/libs/toDoBackend-0.0.1-SNAPSHOT.jar
```
Backend is now accessible on port http://localhost:8080

###### To build and run frontend locally
You will need Gradle 5.2.1
Navigate to /front and use:
```
gradle clean build
```
To run frontend use:
```
serve -s build
```
Frontend is now accessible on port http://localhost:5000