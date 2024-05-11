# tpi-hometest
## Table of Contents
- [Introduction](#introduction)
  - [What is Onion Architecture?](#whatisonion)
  - [Overview of the Home Test Project](#overview)
  - [How to Navigate the Project](#navigate)
- [Features](#features)
  - [Question 1](#question1)
  - [Question 2](#question2)
  - [Question 3](#question3)
  - [Question 4](#question4)
- [Installation](#installation)
- [Usage](#usage)

## Introduction
Welcome to the TPI Home Test Project! This project serves as a demonstration of my understanding and implementation of Onion Architecture, a software architectural pattern that promotes modularity and maintainability by organizing code into layers based on their purpose and level of abstraction.

### What is Onion Architecture?
Onion Architecture is a variation of layered architecture that emphasizes separation of concerns and dependency inversion. The core idea is to organize the application into concentric layers, each representing a different level of abstraction and responsibility. The innermost layer, the domain model, contains the core business logic and entities. Surrounding it are layers for application services, interfaces, and infrastructure, each layer depending only on the inner layers and abstracting away implementation details.

### Overview of the TPI Home Test Project
In this home test project, I've implemented a simple application following the principles of Onion Architecture. The project includes the following components:

- App Layer: contains main method as Spring Boot Application and Configuration class for Bean. It also include application.properties file and liquibase file
- API Layer: Contains controllers to handle the RestAPI request
- Core Layer: it serve of process business logic of the application. I will expose a method for API Layer call to. It also call to a method of Infra Layer if it need to connect to DB or call to 3rd party. 
- Infra Layer: Serve of connect to DB or 3rd Party

### How to Navigate the Project
To explore the project, you can start by examining the codebase and the structure of each layer. Pay attention to the dependencies between layers and how they adhere to the principles of Onion Architecture. Additionally, feel free to run the project, execute tests, and explore its behavior to gain a deeper understanding of its design and implementation.

## Features
### Question 1
For define Entity and its Repository, I put it at Infra Layer. Because this layer will communicate to DB.
I added liquibase file on App Layer inside the resources folder
#### CURL
```
curl --location 'http://localhost:8080/api/tpi-hometest/v1/test-controllers/question-1'
```
### Question 2
For define AOP logic at API Layer inside the aop package. And the specific exception was defined on package common.exception inside Core Layer
#### CURL
```
curl --location 'http://localhost:8080/api/tpi-hometest/v1/test-controllers/question-2'
```
### Question 3
For define Zoo/Animal/Panda/Giraffe class, It was put inside the dto package of Core Layer and I named it as question3 package. I made Animal bean as a Prototype to create multiple instance for the same bean.
```
curl --location 'http://localhost:8080/api/tpi-hometest/v1/test-controllers/question-3'
```
### Question 4
I defined Calculation class inside package question4 of Infra Layer because I want to reuse the ExecutionRecordDAO.
I implemented Bill Pugh Singleton pattern to create a unique instance for Calculation (Singleton)
```
curl --location 'http://localhost:8080/api/tpi-hometest/v1/test-controllers/question-4'
```

## Installation
- Install java 21
- Install gradle
- Install any IDE [prefer IntelliJ Community]
- Install Docker Desktop

## Usage
- Open folder docker at root folder (tpi-hometest) to start postgresql from docker-compose file
```
cd docker
docker-compose up -d
```

- Open project from IDE
- Start the main class TPISoftwareApplication
- Run curl or review code like instruction of `[Features Section](#features)`