# Monday

## Spring Framework - Intro to Spring

The Spring Framework is an inversion of control container that provides flexible infrastructural support to create loosely coupled Java applications by utilizing dependency injection.

### References
* [Spring Framework API - Java Documentation](https://javadoc.io/doc/org.springframework/spring-core/latest/index.html)
* [Overview of Spring Framework - Spring Documentation 4.0.x](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/overview.html)

## What is Spring?
Spring an umbrella term for a family of frameworks which can be utilized to rapidly create loosely coupled Java applications. These spring frameworks provide a comprehensive and configurable model for modern enterprise Java applications, which can be easily migrated to any kind of deployment platform. This ease is due to the core feature of the Spring frameworks, which focuses on [dependency injection](./ioc-dependency-injection) resulting from the framework acting as an [inversion of control](./ioc-dependency-injection) container.

Spring enables developers to build java applications utilizing a POJO design pattern, and applying enterprises services, as needed, non-invasively to those POJOs. This loose coupling allows developers to focus on business logic for applications as Spring handles the infrastructural needs. 

## Frameworks - Overview
The Spring family of frameworks consist of close to 20 modules, each focusing on a particular task or service. These are grouped into the following layers: Core Container, Data Access/Integration, Messaging, Web, AOP, Aspects, Instrumentation and Test.

![Spring Modules](./../images/spring-overview.png)

### Core Container
The Core Container provide the basic framework for the IoC container and dependency injection.
* [Core & Beans](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html#beans-introduction): These modules provide the fundamental framework for springs IoC container, including dependency injection features. Beans specifically feature the BeanFactory, which is a sophisticated implementation of the factory design pattern used to create beans, which are used in dependency injection.
* [Context](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html#context-introduction): This modules builds off from the core and bean modules used for more enterprise functionality. The main feature, ApplicationContext represents the Spring IoC container and is used to instantiate, onfigure and assemble beans.
* [SpEL (Spring Expression Language)](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/expressions.html): A module which provides a powerful expression language which can be used to query and manipulate an object graph at runtime, including setting and getting property values, property assignment, method invocation, accessing array content, collections and indexer and more.

### Data Access/Integration
The Data Access/Integration layer provides support for database management or layers of abstraction for ease of use.
* [JDBC (Java Database Connectivity)](): A module which provides a layer of abstraction for [JDBC](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/jdbc.html#jdbc-introduction)
* [ORM (Object Relational Mapping)](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/orm.html): A module which provides integration layers for ORM APIs, such as JPA, JDO and Hibernate
* [OXM (Object/XML Mapping)](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/oxm.html): A module which provides a layer of abstraction for mapping implementations for JAXB, Castor, XMLBeans, JiBX and XStream
* [JMS (Java Messaging System)](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/jms.html): A module which provides feature to produce and consume messages.
* Transaction: A module which provides programmatic and declarative support for transaction management in classes that implement special interfaces as well as POJOs

### Web
The Web layer provides basic web integration features for an application.
* [Web-Servlet](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/mvc.html): A module which provides an implementation for Spring MVC, a clean separation between model code and web forms, and also integrates with other features of the Spring framework.
* [WebSocket](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/websocket.html): A module which provides a standardized way to esablish a communication channel between a client and server with a single TCP connection.
* [Web-Portlet](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/portlet.html): A module incredibly similar to the servlet workflow, that is marked by two distinct phases, an action phase, which is executed once when any backend changes occur, and a render phase, in which information is displayed to the user.

### [AOP (Aspect Oriented Programming)](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop.html)
The AOP modules provides support for Aspect Oriented Programming, which is different way of thinking about program structure, as opposed to Object Oriented Programming. Aspect Oriented Programming aims to decouple code from functionality that is independent from the core functionality of that code (for example, logging information, and security are generalized functionality that is independent of other, specific business logic, and therefore would be handled by a specific aspect.

### [Aspects](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop.html#aop-ataspectj)
Aspects, particularly AspectJ for Spring, is the module which, when enabled, allows for the use of the AspectJ supported style of declaring and autoproxying beans based on whether the bean is being advised by one or more aspects.

### Instrumentation
A module which provides support for instrumentation (the process of planning, installing, monitoring and maintaining systems) and classloader implementation used in an application server.

### [Test](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/testing.html)
A module which provides support for integration and best practice unit testing, focusing on JUnit or TestNG, as well as mocking information.


## Spring Module - IOC Container and Dependency Injection

The Spring Framework acts as an Inversion of Control (IoC) Container by utilizing Dependency Injection. IoC or Dependency Injection, refers to the process whereby objects define their dependencies, but creation, assembly and injection of those objects is performed by the Spring IoC container.

### References
* [Spring 4.0 - IoC Container](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html)
* [Inversion of Control and Dependency Injection - Martin Fowler](https://martinfowler.com/articles/injection.html)
* [IoC and Depedency Injection - Tutorials Teacher](https://www.tutorialsteacher.com/ioc/inversion-of-control)

## Inversion of Control
Inversion of Control is a design principle in which control over certain parts of object-oriented design is inverted to achieve loose coupling. An simple way to think of this would be to Suppose a user has a car and drives to work each day. Currently, the user is in control of the car. However, if the user schedules an uber instead, the control is inverted from the user to the uber driver, allowing the user to focus on other tasks while still allowing the car to ultimately be driven to work.

In Spring, the IoC Container is responsible for instantiating, configuring and assembling objects known as beans. It does this by getting information from the XML file and assembling the objects accordingly. In Spring there are two types of IoC Containers, the BeanFactory and Application context, which is built out of the Bean factory. More information on BeanFactory, ApplicationContext and Beans can be found in the [configuration lecture notes](./xml-vs-annotation-configuration.md).

The ApplicationContext interface is built on top of the BeanFactory with extra functionality, such as simple integration with Spring AOP, event propagation, message resource handling, and application layer specific context (such as WebApplicationContext for web applications).

## Dependency Injection
Fundamentally, every framework implements at least some level of Inversion of Control. Dependency Injection is a more specific term for what control is inverted with regard to the Spring Framework. As the name suggests, Dependency Injection is a design patters that removes dependencies of a program by providing the configuration in an external source, such as an ML file. This loosely coupled design then makes code easier to test, and implement in a wider variety of environments.

Dependency Injection can occur through the following methods:
* Constructor Injection: Dependency Injection accomplished when the container invokes a constructor with arguments to instantiate a bean in which each argument of said constructor represents a dependency.
* Setter Injection: Dependency Injection accomplished when the container calls setter methods on a bean after invoking a no-argument constructor to instatiate a bean.

### Constructor Injection Examples
__XML Configuration__
```
<beans>
    <bean id = "order" class = "com.revature.models.Order">
        <constructor-arg ref="account"/>
        <constructor-arg ref="item"/>
    </bean>

    <bean id = "account" class = "com.revature.models.Account">
    </bean>

    <bean id = "item" class = "com.revature.models.Item">
    </bean>
</beans>
```


__Annotation Configuration__
```
package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Order {
	private Account account;
	private int id;
        private Item item;

	@Autowired // multiple beans are distinguished by object type
	public Order(Account account, int id, Item item) {
		super();
		this.account = type;
		this.id = id;
		this.item = item;
	}

	...
}
```


__Java Configuration__
```
package com.revature.config;

// import statements
...

@Configuration
@ComponentScan({ "com.revature.repository;com.revature.services" })
public class AppConfig {
	
	...
	
	@Bean(name = "orderService")
	public OrderService getOrderService() {
		OrderServiceImpl oserv = new OrderServiceImpl(getOrderDao()); //<--- consturctor injection
		return oserv;
	}
}
```

### Setter Injection Examples
__XML Configuration__
NOTE: XML Configuration does not directly support setter injection, rather, it is accomplished through properties
```
<beans>

    ...

    <bean id="accountServ" class="com.revature.services.AccountServiceImpl">
        <property name="accountDao" ref="accountDao"/>
    </bean>

    <bean id="orderServ" class="com.revature.services.OrderServiceImpl">
        <property name="orderDao" ref="orderDao"/>
    </bean>

    <bean id="itemServ" class="com.revature.services.ItemServiceImpl">
        <property name="itemDao" ref="itemDao"/>
    </bean>

</beans>
```


__Annotation Configuration__
```
package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Order {
	private Account account;
	private int id;
        private Item item;

	@Autowired
	public void setItem(Item item) {
		this.item = item;
	}

	...
}
```


__Java Configuration__
```
package com.revature.config;

// import statements
...

@Configuration
@ComponentScan({ "com.revature.repository;com.revature.services" })
public class AppConfig {
	
	...
	
	@Bean(name="accountService")
	public AccountService getAccountService() {
		AccountServiceImpl aserv = new AccountServiceImpl();
		as.setAccountDao(getAccountDao()); //<---setter injection
		return aserv;
	}
}
```

### Constructor vs Setter Injection
* Constructor Injection is more secure, since dependencies are required to create an object, you are guaranteed to have each dependency populated
* Consturctor Injection enables the implementation of immutable objects
* Setter Injection allows for partial dependencies since Constructor injection requires all properties to be established upon bean instantiation.
* Setter Injection occurs after constructor injection, essentially putting giving setter injection precedence over constructor injection
* Setter Injection can easily change values, and does not create new bean instances, making it more flexible than constructor injection.
* Setter Injection can resolve circular references (i.e. if Object A and Object B are dependent on each other, setter injection can be used to resolve this, whereas Constructor injection would throw a BeanCurrentlyInCreationException).
