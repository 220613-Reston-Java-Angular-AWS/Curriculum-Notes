# Week 7

## Spring Framework - Intro to Spring

### What is Spring?
-Umbrella term for family of frameworks which can be utilized to quickly create loosely coupled Java apps. They provide a comprehensive and configurable model for modern enterprise Java apps, which can be easily moved to any kind of deployment platform. This is because of the core feature, which focuses on dependency injection, which stems from the framework acting as an IoC (inversion of control) container.
-Allows for devs to build Java apps with plain old Java objects (POJOs) and apply enterprise services as needed to the those POJOs. Loose coupling allows for devs to focus on the business logic, as Spring handles the infrastructure.

### Framework
The framework consists of almost 20 modules, each with a particular task / service, grouped via the following layers: Core Container, Data Access/Integration, Messaging, Web, AOP, Aspects, Instrumentation and Test.

#### Core Container
This is the basic framework for the IoC container and dependency injection.

- Core + Beans: Provide the fundamental framework for Spring's IoC container, including dependency injection features.  Beans specifically feature the BeanFactory, which is a sophisticated implementation of the factory design pattern used to create beans, used in dependency injection.
- Context: Builds from the core and bean modules, for more enterprise functionality. Main feature, ApplicationContext, represents the Spring IoC container and is used to instantiate, onfigure and assemble beans.
- SpEL (Spring Expression Language): Provides a powerful expression language which can be used to query and manipulate an object graph at runtime, including setting and getting property values, assignment, method invocation, accessing array content, collections, indexers, etc.

#### Data Access/Integration
Provides support for DB management or layers of abstraction for ease of use.

- JDBC (Java Database Connectivity): Provides a layer of abstraction for JDBC
- ORM (Object Relational Mapping): Provides integrational layers for ORM APIs, such as JPA, JDO, and Hibernate
- JMS (Java Messaging System): Provides features to produce and consume messages
- Transaction: Provides programmatic and declarative support for transaction management in classes that implement special interfaces as well as POJOs

#### Web
Provides basic web integration features for an app.

- Web-Servlet: Provides an implementation for Spring MVC, a clean separation between model code and web forms, and also integrates with other features of the Spring framework
- WebSocket: Provides a standardized way to establish a communication channel between a client and server with a single TCP connection
- Web-Portlet: Similar to the servlet workflow, it is marked by two distinct phases: action, which is executed once when any backend changes occur, and render, where information is displayed to the user

#### AOP (Aspect Oriented Programming)
Provide support for AOP, which is a different thought process of program structure, opposed to OOP (Object Oriented Programming). The goal is to remove code from functionality that is independent of that core functionality. (Example: Logging information and security are generalized functionalities that are independent of each other and therefore, would be handled by their own specific aspects.)

#### Aspects
Allow for the use of declaring and autoproxying beans based on whether the bean is being advised by one or more aspects. (Particularly for AspectJ for Spring)

#### Instrumentation
Provides support for the process of planning, installing, monitoring, and maintaining systems (instrumentation) and classloader implementation used in the app server.

#### Test
Provides support for integration and best practice unit testing, focusing on JUnit or TestNG, as well as mocking information.