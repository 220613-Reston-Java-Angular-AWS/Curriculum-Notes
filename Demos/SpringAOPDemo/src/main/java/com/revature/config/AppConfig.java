package com.revature.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.revature.repos","com.revature.services","com.revature.aspects"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

    //The way that we ar configuring the beans in the project
    //Is that we are using Java Configuration
    //the @Configuration annotation means that the configuring of beans is handled
    //by @Configuration
    //@ComponentScan- Spring annotation which specifies the path location
    // for defined beans to be used for potential injection
}
