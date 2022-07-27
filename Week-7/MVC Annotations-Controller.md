# Spring Module - MVC Annotations - Controller

This page details the `@Controller` and `@RestController` annotations used in Spring WebMVC to create Spring beans which are used to encapsulate HTTP request hanndler methods

### References

- [Spring 4.3.x Documentation - Web MVC Framework](https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/mvc.html)
- [Spring 4.0.x API Docs (Controller)](https://docs.spring.io/spring-framework/docs/4.3.x/javadoc-api/org/springframework/stereotype/Controller.html)
- [Spring 4.0.x API Docs (Stereotypes)](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/package-summary.html)

## The Spring Annotations for MVC

The annotations used is Spring WebMVC for creating web applications are used to configure Spring beans to handle incoming request, map methods to certain request(s), bind to data in the request/response, and transform data. Below is a list of the most common annotations grouped by their purposes

- Request Handling
  - @Controller
  - @RestController
- Data Binding
  - @RequestBody
  - @PathVariable
  - @RequestParam
  - @ResponseBody
- RequestMapping
  - @RequestMapping
  - @GetMapping
  - @PostMapping
  - @PutMapping
  - @DeleteMapping
- Data Transformation
  - the `consumes` and `produces` attributes of the RequestMapping annotations.

### @Controller

A spring bean responsible for receiving requests and generating a response can be annotated with `@Controller`. Generally speaking a `Controller` is responsible for preparing a map of data that can be resolved to a view by the `InternalViewResolver`. This behavior can be circumvented by using the `@ResponseBody` data binding annotation, which then resolves the returned data directly to the body of the response and skipping the view resolution phase of the request.

`@Controller` is a Spring bean annotation. It is considered a specialized `@Component` and is part of the [Spring stereotypes](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/package-summary.html).

```java
@Target(value=TYPE)
@Retention(value=RUNTIME)
@Documented
@Component
public @interface Controller
```

#### @Controller Usage

```java
@Controller
public class MyController {...}
```

The code above creates a standard controller that will be expected to prepare data for view resolution by the `InternalViewResolver`.

```java
@Controller
@ResponseBody
public class MyController {...}
```

The code above creates a controller in which all mapped methods will be preparing data that will be written directly to the response body.