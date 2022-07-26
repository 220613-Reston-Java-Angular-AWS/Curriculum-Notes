# AOP - Aspect Oriented Programming
- Breaking down program logic into "cross-cutting-concerns"
    - Cross-cutting-concerns: functionalities used throughout an application (it "cuts" across different layers, classes, methods, etc.)
    - Examples: logging, security, validation
- Break down these concerns into units known as "Aspects"
    - An `Aspect` is a class that contains different `Advice` (structured as methods)
- We can annotate our class with @Aspect to address a particular concern
    - `@Aspect` is from the AspectJ library, which is a full AOP framework, but Spring AOP can also utilize AspectJ annotations

# AOP Ecosystem
- AspectJ: Fully fledged ORIGINAL AOP framework that provided the ability to write AOP code in an annotation based format
    - More functionality than Spring AOP
    - Harder to Use
- Spring AOP: Spring's implementation of AOP
    - This is what we'll be using
    - To make use of annotations, Spring AOP understands AspectJ annotations
        - We will be utilizing the AspectJ dependency just to gain access to these annotations
    - Less functionality than AspectJ
    - Easier to use
    - Uses "runtime-weaving", which is a process where code is "wrapped" during runtime

# Join Points
- A join point is the location that is "intercepted" by the advice code
- A JoinPoint is represented by method execution
- So when some method is invoked, the advice will intercept it

# PointCut
- A pointcut is a predicate (similar to regular expressions) that indicates WHAT we actually want to intercept
- Used to signify the actual JoinPoint

# Advice
- The actual code that will run during interception of a join point (specified by a pointcut expression)
- Many types of advice:
    - `@Before`
        - Advice that will execute before the JoinPoint is executed
    - `@After`
        - Advice that will execute after the JoinPoint is executed (whether it throws an exception or returns successfully)
    - `@AfterReturning`
        - Advice that will execute after the JoinPoint is executed only when there is a successful return with no exception thrown
    - `@AfterThrowing`
        - Advice that will execute after the JoinPoint is executed only when a particular exception is thrown
    - `@Around`
        - Allows for the intercepting of a method both before and after
        - Can do things like stop the execution of the JoinPoint, or even stop an exception from propagating
            - Ex. a method mapped to an endpoint
                - Using @Around advice, we can actually prevent the endpoint from executing if a condition is not met (ex. current user is not an Admin)
        - MOST POWERFUL type of advice
- Advice are associated with PointCuts and run at matching JoinPoints
- JoinPoint interface
    - gives us access to the target object
    - allows us to gain information such as the method signature, method parameters, etc.
- ProceedingJoinPoint interface
    - Used to handle @Around advice
    - gives access to the .proceed() method, which will actually execute the JoinPoint

# Types of PointCut Expressions
- @annotation
    - This one can be used for any method annotated with the specified annotation
    - `@annotation(com.revature.gradifysb.annotation.Associate)`
- execution
    - Most common, specifies which methods to have as our JoinPoints
    - `execution(access-modifiers-pattern? return-type-pattern declaring-type-pattern?method-name-pattern(param-pattern) throws-pattern?)`
        - modifiers-pattern: public private protected default
        - return-type: void, String, int, boolean, com.revature.gradifysb.model.Assignment
        - declaring-type-pattern: class name that the method belongs to
            - `com.revature.gradifysb.dao.AssignmentDao`: any class in the dao package
        - Example: `execution(public com.revature.gradifysb.model.Assignment com.revature.gradifysb.service.AssignmentService.getAssignmentById(int))`
    - Parameter pattern wildcards
        - (): match a method with no arguments
        - (*): matches a method with 1 argument of any type
        - (..): matches a method with 0 or more arguments of any type
    - Combine pointcuts
        - && (AND)
        - || (OR)
        - ! (NOT)

# Terminology Summary
- Aspect: the class that contains advice methods
- Advice: a method that will execute for a particular Join Point
- Join Point: the actual method being intercepted
- Pointcut expression: an expression that indicates what method(s) should be the Join Point