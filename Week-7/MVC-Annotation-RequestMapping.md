### References

- [Spring 4.3.x Documentation - Web MVC Framework](https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/mvc.html)
- [Spring 4.3.x API Docs (RequestMapping)](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html)

## @RequestMapping

Methods and classes can be annotated with `@RequestMapping` to bind the class and/or method(s) to certain url paths of an incoming request. `@RequestMapping` also provides metadata to the `DefaultHandlerMapping`, which is used during the request handshake to determine with mapped method will handle the current request. The most common attributes used with `@RequestMapping` are:

- path - the url path(s) to which the mapped class/method will be bound
- method - the http request method(s) the class/method will be bound
- consumes - the incoming data format(s) the class/method will expect
- produces - the outgoing data format(s) the class/method can return
- headers - headers which are expected to be on the request
- params - parameters which are expected to be on the request

The `@RequestMapping` annotation is extended by the following semantic annotations which should be used for mapping methods rather than the general `@RequestMapping`.

- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping

The semantic annotations are configured with an `@RequestMapping` with the appropriate `method` for the request.

```java
@Target(value=METHOD)
@Retention(value=RUNTIME)
@Documented
@RequestMapping(method=GET)
public @interface GetMapping
```

### @RequestMapping usage

```java
@Controller
@RequestMapping("my_controller")
public class MyController {...}
```

The above code creates a standard spring controller bound to the url path `/my_controller`. In order to connect to this controller a request must be made to `http://<domain>/<dispatcher_mapping>/my_controller`.

```java
@Controller
@RequestMapping("my_controller")
public class MyController {
  @RequestMapping(path="my_data", method=HttpMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity getMyData() {
    ...
  }
}
```

The above code creates a controller bound to the `/my_controller` url path with a handler method bound to the `/my_data` url path. In order to connect to this method a request must be made to `http://<domain>/<dispatcher_mapping>/my_controller/my_data`.

General practice is to add @RequestMapping to the controller class for mapping relative to a REST resource for example `/users`, `/books`, `/employees`. For the methods it is generally better to use the extended mapping annotations `@GetMapping`, `@PostMapping`, `@PutMapping`, and/or `@DeleteMapping`

```java
@Controller
@RequestMapping("my_controller")
public class MyController {
  @GetMapping(path="my_data", produces=MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity getMyData() {
    ...
  }
}
```

The above code is similar to the last example, but uses the `@GetMapping` annotation to map this method to HTTP get requests. Multiple extended request mappings can be used on a single method.