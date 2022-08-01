package com.revature.aspects;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static Logger log = Logger.getLogger(LoggingAspect.class);

    //execute - used to match a method execution join point. This is the primary designator used

    @Before(value = "execution(* com.revature.*.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before advice for: " + joinPoint.getTarget().getClass() + ": " + joinPoint.getSignature().getName());

    }

        @After(value = "execution(* com.revature.*.*.*(..))")
        public void logAfter(JoinPoint joinPoint) {
        log.info("After advice for: " + joinPoint.getTarget().getClass() + ": " + joinPoint.getSignature().getName());
        }

      @Around(value = "execution(* com.revature.services.*.*(..))")
    public Object logDuring(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around advice for: " + joinPoint.getTarget().getClass() + ": " + joinPoint.getSignature().getName());

        Object[] args = joinPoint.getArgs();

        //proceed the join
          Object result = joinPoint.proceed(args);
          System.out.println("Result of this logDuring()  method invoking: " + result);

          log.info("End of All Advice");
          return result;
      }




}
