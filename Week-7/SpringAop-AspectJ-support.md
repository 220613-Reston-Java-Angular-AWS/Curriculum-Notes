# Spring Module - @AspectJ support

This page details AspectJ support in Spring and how to configure Spring to utilize AspectJ with Spring.

### References
* [Spring 4.0.x Documentation - AspectJ](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop.html#aop-ataspectj)
* [AspectJ Project](https://www.eclipse.org/aspectj/)
* [AspectJ API Documentation - lang package](https://www.eclipse.org/aspectj/doc/released/runtime-api/index.html)
* [AspectJ API Documentation - annotations](https://www.eclipse.org/aspectj/doc/released/aspectj5rt-api/index.html)

## `@AspectJ`
`@AspectJ` refers to a style of declaring aspects through the use of regular Java classes with annotations. `@AspectJ` style was introduced in the AspectJ 5 release of the AspectJ Project. Note that Spring interprets the same annotations as AspectJ 5, using a library supplied by AspjectJ, however Spring's AOP runtime is not dependent on the AspectJ compiler or weaver.

## Enabling `@AspectJ`
To utilize `@AspectJ` aspects in a Spring configuration, you need to enable support for configuring the Spring AOP based on `@AspectJ` aspects and _autoproxying_ beans which are advised by those aspects. Autoproxying means that Spring will automatically generate a proxy to intercept method invocations when a bean is advised by one or more aspects to ensure that advice is executed as needed.

`@AspectJ` configurations can be enabled using either XML or Java-based Spring configuration. In either case, you will need to make sure that the AspectJ _aspectweaver.jar_ is on your application's classpath (version 1.6.8 or later is required for Spring 4.0.x). 

This can be done by adding the following dependency within your Maven Pom file:
```
<dependency>
	<groupId>org.aspectj</groupId>
	<artifactId>aspectjweaver</artifactId>
	<version>1.6.8</version>  <!-- or a later version... -->
</dependency>

```

For XML based configurations you must use the `aop:aspectj-autoproxy` element:
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">
	
	<!-- This element enables AspectJ autoproxy -->
	<aop:aspectj-autoproxy></aop:aspectj-autoproxy>

	<!-- other configurations below... -->
</beans>
```

For Java based configurations, AspectJ is supported through the use of the `@EnableAspectJAutoProxy` annotation within your `@Configuration` annotated class:
```
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

}
```
