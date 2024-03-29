# Spring Boot Module - Spring Boot Actuator

This page details Spring Boot Actuator to monitor and manage web applications

Spring Boot has really become popular as more and more companies create or convert their systems using microservice patterns.

### References

- [Spring Boot Actuator Production Features](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html)
- [Spring Boot Actuator Web API](https://docs.spring.io/spring-boot/docs/current/actuator-api/html/)

## Spring Boot Actuator

`Spring Boot Actuator` is a Spring library that exposes tools for monitoring and gathering metrics about a running application. By using `Spring Boot Actuator` boilerplate operation tools like health, metrics, env, etc.. can be automatically included in an application through either `HTTP` or `JMX` (Java Management Extensions).

## Endpoints

`Spring Boot Actuator` comes with a lot of predefined endpoints to utilize its operational features. Below is a list of some of the more common endpoints. Check the docs for more information.
| Endpoint | Use |
|---|---|
| /health | Shows application health information |
| /beans | Display a list of available Beans in the BeanFactory |
| /env | Return the current application properties or a single property |
| /info | Return general information can be custom data |
| /logfile | Returns content of the logfile |
| /loggers | Show and/or modify logger configurations |
| /mappings | Returns a collated list of all @RequestMappings |
| /metrics | Show metric information for the current application |
| /shutdown | Perform an application shutdown |

### Spring Boot Actuator Usage

To include `Actuator` in your `Spring Boot` project simply add it to the `pom.xml` after the project creation or select it during the project creation process with `Spring Boot Initializr`.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

By Default all endpoints except for `shutdown` are enabled. To enable and endpoint simply set its `management.endpoints.<id>.enabled` property.

```properties
management.endpoints.shutdown.enabled=true
management.endpoints.metrics.enabled=false
```

Endpoints can be configured to be opt-in rather than opt-out by setting the `management.endpoints.enabled-by-default` to false. Then all endpoints will be disabled and you must opt-in to use each endpoint.

```properties
management.endpoints.enabled-by-default=false
management.endpoints.health.enabled=true
management.endpoints.mappings.enabled=true
```

IMPORTANT NOTE!!! Some of these endpoints will show sensitive information or perform dangerous operations. `Actuator` endpoints should be included in your security chain and/or excluded from exposure. Depending on what you're using, `HTTP` or `JMX` some endpoints are exposed by default, see the docs for more information. To include or exclude a(n) endpoint(s), simply set the `include` or `exclude` property of the messaging protocol being used.

```properties
management.endpoints.jmx.exclude=shutdown, loggers
management.endpoints.web.exclude=shutdown, loggers

management.endpoints.jmx.include=info, health
management.endpoints.web.include=info, health
```

Once your endpoints are enabled and exposed you can access the information by sending a request to `/actuator/<endpoint-id>`.

`Acutator` is used to handle many management and monitoring production operations. This document is a very short overview of the use. Please refer to the documentation for more details.