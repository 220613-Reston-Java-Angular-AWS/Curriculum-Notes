# Spring Module - Advice

This page details the concept of Advice with regard to Aspect Oriented Programming and Spring.

### References
* [Spring 4.0.x Documentation - Advice](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop.html#aop-advice)

### Prerequisites
* [AspectJ with Spring](./aspectj.md)
* [Pointcuts and Joinpoints](./pointcut_and_join-points.md)

## Types of Advice
Advice is specific actions taken, defined as a method, at a particular point during the execution of a program. There are five (5) types of advice, which controls at what point the action will take place.

* __Before__ - Advice that will execute before a join point, but does not have the capability to halt the normal execution of the proceeding join point (unless an exception is thrown)
* __After Returning__ - Advice that will execute after a join point completes without throwing an exception
* __After Throwing__ - Advice that will execute if a join point throws an exception.
* __After (finally)__ - Advice that will execute regardless of how the join point completes, whether normal or by throwing an exception.
* __Around__ - Advice that will execute before and after the join point. Around advice is the most general, but also most powerful kind of advice, as it can perform custom behavior before and after method invocation, and can be responsible for choosing whether to proceed to the join point method execution or shortcut the advised method by returning its own value or throwing an exception. In general it is recommended to use the least powerful type of advise for any particular task. For instance, if you only need to update a cache with a value returned from a method, it is best to use the _After Returning_ advice type.

All of these annotations, including the `@Aspect` annotation must be imported from the `org.aspectj.lang.annotation` pacakage.

### Before
_Before_ advice is declared using the `@Before` annotation:
```
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeExample {

    @Before("com.revature.example.dataAccessOperation()")
    public void doAccessCheck() {
        // ...
    }

}
```

### After Returning
_After Returning_ advice is declared using the `@AfterReturning` annotation:
```
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;

@Aspect
public class AfterReturningExample {

    @AfterReturning("com.revature.example.dataAccessOperation()")
    public void doAccessCheck() {
        // ...
    }

}
```

Note that you can also bind `@AfterReturning` a returned value to the advice in order to access information from it (such as storing its value, or printing information specific to the returned data). This binding is declared using the `returning` attribute in the pointcut:
```
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;

@Aspect
public class AfterReturningExample {

    @AfterReturning(
        pointcut="com.revature.example.dataAccessOperation()",
        returning="retVal")
    public void doAccessCheck(Object retVal) {
        // ...
    }
}
```
Here, "retVal" is the name given to the object being returned, and is referenced in the method signature of the `doAccessCheck` method by the same name.


### After Throwing
As you may assume, _After Throwing_ advice is declared with the `@After Throwing` annotation:
```
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class AfterThrowingExample {

    @AfterThrowing("com.revature.example.dataAccessOperation()")
    public void doRecoveryActions() {
        // ...
    }

}
```

Similarly to `@AfterReturning`, you may reference a thrown exception within the advice through the use of the _throwing_ attribute, which allows you to reference the exception within the method signature of the advice by corresponding an argument in the method signature with the name declared with the _throwing_ attribute:
```
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class AfterThrowingExample {

    @AfterThrowing(
        pointcut="com.revature.example.dataAccessOperation()",
        throwing="ex")
    public void doRecoveryActions(DataAccessException ex) {
        // ...
    }

}
```

### After (finally)
_After_ advice is declared using the `@After` annotation. Since it will execute after normal or exceptional completion of a method, you must make sure any `@After` advice is configured to handle both conditions:
```
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;

@Aspect
public class AfterFinallyExample {

    @After("com.revature.example.dataAccessOperation()")
    public void doReleaseLock() {
        // ...
    }

}
```

### Around
```
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundExample {
    private static Logger log = Logger.getLogget(LoggingAspect.class);

    @After("com.revature.example.dataAccessOperation()")
    public void performAroundAdvice() {
        log.info("This is Around Advice");
    }
}
```
