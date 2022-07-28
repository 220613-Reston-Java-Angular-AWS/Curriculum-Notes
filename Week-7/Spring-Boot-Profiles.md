# Spring Boot Profiles
In Spring, we can map beans to profiles, allowing us to have different versions of our beans (ex. database connections) for different environments. As you know, it is best practice to have separate working environments for development, testing, and production, and many applications have even more environments that it has to run in with their own configurations.

To map a particular Bean to a profile, we tag  the bean with `@Profile("environmentName")`. You can set the active environment by modifying the `spring.profiles.active` value, usually through `WebApplicationInitializer`, `ConfigurableEnvironment`, or simply by adding the line `spring.profiles.active=dev` to your `bootstrap.properties` file.

If you have properties you wish to set that depend on the active profile, you can set those in your `application.properties` or `application.yml` file. Here is an example of these properties set in an `application.yml`.
```yml
# properties for all profiles
---
spring:
  profiles:
    - dev
  # properties for dev environment
---
spring:
  profiles:
    - prod
  # properties for prod environment
```

When testing, we can make use of our environments by making use of the `@ActiveProfile("environmentName")` annotation. By placing this annotation on our test, we can activate a specific profile for testing.

## Example

In this example, we are going to declare two beans. One bean will be active in our `dev` environment, and the other bean will be active in every other environment.

```Java
@Configuration
public class myDataSourceConfig {
    @Bean
    @Profile("dev")
    public DataSource devDataSource() {
        DataSource ourDataSource = ...
        // configuration for dev data source
        return ourDataSource
    }

    @Bean
    @Profile("!dev")
    public DataSource otherDataSource() {
        DataSource ourDataSource = ...
        // configuration for testing and prod data source
        return ourDataSource
    }
}
```

These beans can be autowired into our services as normal, as only one of them will exist depending on what the active environment is.