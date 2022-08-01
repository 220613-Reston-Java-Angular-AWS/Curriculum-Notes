# Spring Study Guide

## Spring Framework
- Spring Framework Modules
  - Core
  - Beans
  - Context
  - AOP
  - JDBC
  - ORM
  - Web MVC
- Spring Projects
  - Spring Boot
  - Spring Cloud
  - Spring Data
  - Spring Security
  - Spring HATEOAS
- Inversion of Control 
  - BeanFactory
  - ApplicationContext
  - Dependency injection
- Spring Bean lifecycle
  - Instantiation
  - Populate properties
  - BeanNameAware's setBeanName()
  - BeanFactoryAware's setBeanFactory()
  - Pre-initialization BeanPostProcessors
  - afterPropertiesSet()
  - Custom init() method
  - Post-initialization BeanPostProcessors
  - Bean ready to use
  - IOC container is shutdown
  - DisposableBean's destroy() method
  - Custom destroy() method
- Dependency injection support
  - Setter injection
  - Constructor injection
  - Field injection
  - Wiring and autowiring
- Autowiring modes
  - no
  - byName
  - byType
  - constructor
  - autodetect
- Spring Bean scopes
  - singleton
  - prototype
  - request
  - session
  - global session
- Component scanning
- Configuration
  - Annotations
    - @Configuration
    - @ComponentScan
    - @Bean
  - XML
- Spring Expression Language

## Web MVC

- MVC architecture
  - DispatcherServlet
  - ViewResolver
  - HandlerMapping
- Stereotype annotations
  - @Component
  - @Controller
  - @Service
  - @Repository
- Controller annotations
  - @ResponseBody
  - @RestController
  - @RequestMapping
  - @GetMapping
  - @PostMapping
  - @PutMapping
  - @DeleteMapping
  - @PathVariable
  - @RequestBody
  - @QueryParam
- JSR 303 validation
  - @Valid
  - @NotNull
  - @NotBlank
  - @Email
  - @Min
  - @Max
- Setting status codes
  - @ResponseStatus
  - returning ResponseEntity object
- Consuming external web services
  - RestTemplate

## AOP

- Aspects
- Cross-cutting concerns
- Join point and pointcut
- Advice
  - @Before
  - @After
  - @Around
  - @AfterReturning
  - @AfterThrowing
- ProceedingJoinPoint
- Pointcut expression syntax
- @ControllerAdvice

## Data Access

- Transactions
  - Declarative transaction management
    - @Transactional
    - @EnableTransactionManagement
  - Programmatic transaction management
    - TransactionTemplate
    - PlatformTransactionManager
  - Transaction propagation settings
    - Required
    - Requires_new
    - Nested
  - Physical vs logical transactions
- JDBCTemplate
- @Repository exception translation
- Spring ORM configuration
  - Configuring Hibernate SessionFactory
  - Configuring JPA EntityManagerFactory via LocalEntityManagerFactoryBean

## JPA

- Interface hierarchy
  - Repository
  - CrudRepository
  - PagingAndSortingRepository
  - JpaRepository
- Extending JPA repository interfaces
  - Method naming standards
- Configuration
  - @EnableJpaRepositories

## Spring Boot

- Advantages of Spring Boot over normal Spring project
  - Opinionated
  - Convention over configuration
  - Autoconfiguration
  - Embedded Tomcat packaged in JAR
- Parent POM
- Spring Boot Maven plugin
- Spring Boot starters
- Configuration
  - bootstrap.yml
  - application.yml
  - @SpringBootApplication
- Spring Boot Devtools
- Profiles
  - local, dev, prod
  - @Profile
  - spring.profiles.active property
- Actuator endoints and info