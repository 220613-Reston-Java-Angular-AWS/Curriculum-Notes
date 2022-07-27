# Spring Module - MVC Annotations - Path Variable and Request Mapping

This page details the `@PathVariable` and `@RequestParam` annotations used in Spring WebMVC to bind data to Java objects for request handling

### References

- [Spring 4.3.x Documentation - Web MVC Framework](https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/mvc.html)
- [Spring 4.3.x API Docs (PathVariable)](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PathVariable.html)
- [Spring 4.3.x API Docs (RequestParam)](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html)

## @PathVariable

REST endpoints can be bound to particular REST resources. Generally speaking the URL is used to refer to a uniquely addressable object. `@PathVariable` can be used to build dynamic routes to uniquely identified REST resources. Using `@PathVariable` is a two step process. First the variable path segment must be identified in the url path of the handler request mapping, then the segment is bound to a parameter in the handler's parameter list using `@PathVariable` Following is the list of `@PathVariable` attributes

- name - name of the path segment to bind to
- required - boolean to flag the variable as required
- value - alias for name

Path matching is done with regular expresions. It is possible to have simple expressions like `{id}`, `{user_name}` or something more elegant like `{id : [0-9]{3}-[0-9]{2}-[0-9]{2}-[0-9]{3}}`. The first example (`{id}`) will match any value in the segement, but the second example will only match that specific pattern (xxx-xx-xx-xxx where 'x' is a digit 0-9).

### @PathVariable usage

```java
@Controller
@RequestMapping("my_controller")
@ResponseBody
public class MyController {
  @GetMapping(path="my_data/{id}") // {id} is the path variable
  public ResponseEntity getDataById(@PathVariable Integer id){...}
}
```

The code above creates a controller and a handler. The handler method includes a path with a variable segment identified by `{id}`. The handler method's parameter list includes a parameter name `id` that is bound to the `{id}` segment of the url. Spring will automatically bind variables and segments that have the same name. It is possible to have a url segment and a binding variable with different names, if this is the case `@PathVariable` can be configured to use the correct segment.

```java
@Controller
@RequestMapping("my_controller")
@ResponseBody
public class MyController {
  @GetMapping(path="my_data/{id}") // {id} is the path variable
  public ResponseEntity getDataById(@PathVariable("id") Integer dataId){...}
}
```

The above code is very similar to the previous example, but this time the segment and binding variable have different names. `@PathVariable` is configured to bind to the correct url segment with either the `value` attribute or `name` attribute.

```java
@Controller
@RequestMapping("my_controller")
@ResponseBody
public class MyController {
  @GetMapping(path="my_data/{id}") // {id} is the path variable
  public ResponseEntity getDataById(@PathVariable(name="id", required=false) Integer dataId){
    if(dataId != null) {
      // path if id was included
    } else {
      // path if id was not included
    }
  }
}
```

The above code shows how handler methods can be written to react to optional path variables. This is useful if you have common logic that run regardless of the presence of the optional variable. IMPORTANT NOTE!!! By default all path variables are required. If a required path variable is not present the `DefaultHandlerMapping` will still map to this method [(REST Precendence Rules)](https://www.oreilly.com/library/view/restful-java-with/9781449361433/ch04.html#precedence_rules), but Spring WebMVC will return a `400` status for the bad request.

## @RequestParam

Query string data in an HTTP request is used to further configure and filter the request and data coming in the response. For example a request like `/vehicles?make=Chevrolet&model=Silverado&color=blue` is a request for a list of vehicles, but the query string further configures the request to only get vehicles with a matching `make`, `model`, and `color`. `@RequestParam` bindings are similar to `@PathVarialbe` binding, however the query string mapping is not included in the handler mapping path attribute. The bindings are included in the parameter list much like `@PathVariable`. Below is a list of `@RequestParam` attributes.

- defaultValue - fallback value if the is not provided or present.
- name - the name of the parameter to bind to
- required - boolean to flag the variable as required
- value - alias for name

### @RequestParam Usage

```java
@Controller
@RequestMapping("my_controller")
@ResponseBody
public class MyController {
  @GetMapping(path="my_data") // query parameters aren't included in the mapping
  public ResponseEntity getData(@RequestParam LocalDateTime createdOn){...}
}
```

The code above creates a controller and a handler. The handler method mapping doesn't include the query parameter declarations. The parameter list however, does include the bindings with `@RequestParam`. Spring will automatically bind handler parameters to query parameters with the same name, but binding names can be qualified just like `@PathVariable` (`@RequestParam("make") String manufacturer`).

```java
@Controller
@RequestMapping("my_controller")
@ResponseBody
public class MyController {
  @GetMapping(path="my_data")
  public ResponseEntity getData(@RequestParam("created") LocalDateTime dateCreatedOn){...}
}
```

The above code is very similar to the previous example, but this time we assume the query parameter and handler parameter have different names. The binding names are qualified with the `name` or `value` attribute of `@RequestParam`

```java
@Controller
@RequestMapping("my_controller")
@ResponseBody
public class MyController {
  @GetMapping(path="my_data")
  public ResponseEntity getDataById(@RequestParam(name="create", required=false, defaultValue=LocalDateTime.now()) LocalDateTime dateCreatedOn){
    ...
  }
}
```

The above code makes the `create` query parameter optional and assigns a default value if it isn't present in the request. This is useful to ensure proper filtering can take place, to reduce the number of query manipulations, or reduce the number of validation checks. IMPORTANT NOTE!!! By default all bound request parameter variables are required. If a required request variable is not present the `DefaultHandlerMapping` will still map to this method, but Spring WebMVC will return a `400` status for the bad request unless a defaultValue is provided.