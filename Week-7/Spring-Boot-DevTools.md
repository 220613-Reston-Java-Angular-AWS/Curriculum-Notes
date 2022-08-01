# Spring Boot Module - Spring Boot DevTools

This page details the use of Spring Boot DevTools

### References

- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html)

## Spring Boot DevTools

Spring Boot applications can include a set of tools to ease development more. `spring-boot-devtools`. Spring Boot DevTools offer 2 major features that improve development workflow.
- Disabled caching
- Automatic restarts

Spring Boot DevTools are only used during development and are automatically disabled when running a fully packaged application.

## Disabled caching
Some Spring modules use caching to imporve performance. While useful during production deployments, caching can hinder development workflow. Spring Boot DevTools automatically disables caching with these modules.

## Automatic Restarts
Manual restart of an application during development can be cumbersome and frustrating. If making small, frequent changes it can be easy to overlook a restart. DevTools will automatically restart the application when a file on the classpath changes.

Spring Boot DevTools optimizes restarts by using separate ClassLoaders. The first ClassLoader is used for classes that won't change. The second ClassLoader is used for your classes. This approach reduces the number of classes that need to be loaded during startup making automatic restarts faster. There are a number of ways to trigger restarts. Refer to the docs for more information.

## DevTools Usage

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

Simply include `spring-boot-devtools` dependency in your project file. Please refer to the documentation for any special configurations that you may want to change.

It is best practice to flag the dependency as `optional` in Mave or `compileOnly` in Gradle to prevent transitive inclusion in other dependent modules.