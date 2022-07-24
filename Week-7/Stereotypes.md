# Spring Module - Stereotype Annotations

This page details Stereotype Annotations and their importance in Spring Bean Configurations.

### References
* [Spring Stereotype Annotation Documentation](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html#beans-stereotype-annotations)
* [Spring Stereotype API Docs](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/package-summary.html)

## Stereotype Annotations Overview
Stereotypes are a number of built in annotations which are used as markers to declare obects as a bean, define their name and clarify to a developer what the bean will be used for.

### `@Component`
The `@Component` annotation is a generic stereotype used to declare an objects as a bean, which will be nijected into other classes/beans at some point in time. Spring also provides more specific use cases for `@Component` beans when the class serves a specific purpose, such as the persistance of data, a service or presentation. These annotations are `@Repository`, `@Service` and `@Controller` respectively.

```
@Component("account");
public class Account {
    private int id;

    @Override
    public class toString() {
        return "Account [id=" + id +"]";
    }

    public Account() {
        super();
    }

    public Account (int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
```


### `@Repository`
The `@Repository` annotation marks a class to be used as a for use with storing data within a repository or database. Specifically, the `@Repository` annotation provides benefits for objects that would otherwise be utilized as a Data Access Object (DAO).

```
@Repository("accountRepository")
public class AccountRepositoryImpl implments AccountRepository {
    Connection connection = null;
    PreparedStatement stmt = null;

    @Override
    public List<Account> getAllAccounts() {

        List<Account> accounts = new ArrayList<Account>();
        try {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT * FROM accounts";
            stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Account account = new account(rs.getInt("id"));
                accounts.add(account);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    
        return accounts;
    }
}
```

### `@Service`
The `@Service` annotation marks a class as a Service for an application

```
@Service("accountService");
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.getAllAcounts();
    }
}


```

### `@Controller`
The `@Controller` annotation marks a class as a [Spring MVC Controller](../b-mvc/README.md) which allow the use of handlder mapping annotations. Classes annotated with `@Controller` are autodeteced through classpath scanning, and when used in comination with `@RequestMapping`, allows for quick configurations of a web application controller. More detail on `@RequestMapping` as well as @ResponseBody can be found in the [MVC lecture notes](../b-mvc/README.md).

```
@Controller("accountController")
public class accountControllerImpl {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/accounts/all")
    public @ResponseBody List<Account> getAllAccounts() {
        Return accountService.findAll();
    }
}

```

In addition to readability, use of these stereotypes makes classes more suited for other processing tools, such as [aspects](../c-aop/aop-and-ccc-overview.md) or marking targets for [pointcuts](../c-aop/pointcut.md).