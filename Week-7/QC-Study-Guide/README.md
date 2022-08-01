# Spring

### Spring Core

1.  What are Spring Projects and Spring Modules?
    
2.  What is IOC and what does the IOC Container do?
    
3.  What is dependency injection and what are some of the benefits of using dependency injection?
    
4.  What types of dependency injection does Spring support?
    
5.  What are some differences between BeanFactory and ApplicationContext? Which one eagerly instantiates your beans?
    
6.  What is the Spring Bean lifecycle?
    
7.  What is bean wiring? What about autowiring?
    
8.  What are the different ways that Spring can wire beans?
    
9.  What are the scopes of Spring beans? Which is default?
    
10.  What is the concept of component scanning and how would you set it up?
    
11.  What are the benefits and limitations of Java configuration?
    
12.  What does the @Configuration and @Bean annotations do?
    
13.  What is @Value used for?
    
14.  What is Spring Expression Language? What can you reference using SpEL? What is the difference between $ and # in @value expressions?
    

### Spring MVC

15.  Explain the MVC architecture and how HTTP requests are processed in the architecture
    
16.  What is the role of the DispatcherServlet? What about the ViewResolver?
    
17.  List some stereotype annotations. What are the differences between these?
    
18.  How would you declare which HTTP requests you’d like a controller to process?
    
19.  What is the difference between @RequestMapping and @GetMapping?
    
20.  How to declare the data format your controller expects from requests or will create in responses?
    
21.  What annotation would you use to bypass the ViewResolver?
    
22.  How would you extract query and path parameters from a request URL in your controller?
    
23.  What concerns is the controller layer supposed to handle vs the service layer?
    
24.  How would you specify HTTP status codes to return from your controller?
    
25.  How do you handle exceptions thrown in your code from your controller? What happens if you don’t set up any exception handling?
    
26.  How would you consume an external web service using Spring?
    
27.  What are the advantages of using RestTemplate?
    

### Spring AOP

28.  What is “aspect-oriented programming”? Define an aspect.
    
29.  Give an example of a cross-cutting concern you could use AOP to address
    
30.  Define the following:
    

*  Join point
    
*  Pointcut
    
*  Advice
    

31.  What are the different types of advice? What is special about the @Around advice? How is the ProceedingJoinPoint used?
    
33.  Explain the pointcut expression syntax
    
34.  What visibility must Spring bean methods have to be proxied using Spring AOP?
    

### Spring Data

34.  What is Spring ORM and Spring Data?
    
35.  What is the Template design pattern and what is the JDBC template?
    
36.  What does @Transactional do? What is the PlatformTransactionManager?
    
37.  What is a PersistenceContext?
    
38.  Explain how to integrate Spring and Hibernate using ContextualSession
    
39.  What interfaces are available in Spring Data JPA?
    
40.  What is the difference between JPARepository and CrudRepository?
    
41.  What is the naming conventions for methods in Spring Data repositories?
    
42.  How are Spring repositories implemented by Spring at runtime?
    
43.  What is @Query used for?
    

### Spring Boot

44.  How is Spring Boot different from legacy Spring applications? What does it mean that it is “opinionated”?
    
45.  What does “convention over configuration” mean?
    
46.  What annotation would you use for Spring Boot apps? What does it do behind the scenes?
    
47.  How does Boot’s autoconfiguration work?
    
48.  What is the advantage of having an embedded Tomcat server?
    
49.  What is the significance of the Spring Boot starter POM?
    
50.  What is the Spring Boot actuator? What information can it give you?
    
51.  What files would you use to configure Spring Boot applications?
    
52.  What is the benefit of using Spring Boot profiles?
