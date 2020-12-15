# prime-printer (StdOut)

This is a simple application print prime numbers in standard out, paging records depending on configuration properties  

## Project Structure
This project follow clean code directives and is aligned by clean Architecture definitions.
```
.
|-- gradle
|-- src
|   |-- main
|       |--java
|           |--base package
|               |--adapter (inbound and outbound adapters (controllers, repositories))
|               |--assembler (configurations, bean definitions)
|               |--kernel (Object for business logic, (Domian modles, Business excetions)) 
|               |--usercase (Business logic, (Services for business logic))
|               |--util (Utilities)
|       |--resources (application config file)
|   |-- test (All Unit Test)
|       |--java
|-- Dockerfile
|-- docker-compose.yml
|-- README.md
|-- (gradle files)

```

## Libraries and technologies integrated

#### For programming
   * Java JDK 8
   * Spring Starter (2.4.0)
   * lombok (1.18.8)
#### For Test
   * JUnit
  
## Requirements

For building and running the application you need:

* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* [Gradle 4+](http://www.gradle.org/downloads)


## Running with Gradle

There are several ways to run a Spring Boot application on your local machine. One way is to execute the following command in root folder.

```
$ gradle build && java -jar build/libs/prime-printer-0.0.1-SNAPSHOT.jar

```

## Running with Docker

### Prerequisites

#### Docker

Docker and Docker Compose are used to build and deploy this application.

Installation instructions for Docker can be found on its [Get Started](https://docs.docker.com/get-started/) page.

If your installation of Docker did not come with Docker Compose, you can follow its
[install instructions](https://docs.docker.com/compose/install/).

### Running

To start this application run the following command over root folder:

```
$ docker-compose up
```

If you apply any change over code run the following commands to refresh image and container:

```
$ docker-compose build
$ docker-compose up
```
