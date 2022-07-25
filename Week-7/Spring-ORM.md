# Spring Module - Object Relational Mapping

This page details the Spring Object Relation Mapping Module.

### References
* [Spring 4.0.x - ORM](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/orm.html)
* [Classic ORM Templates](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/classic-spring.html#classic-spring-orm)
* [What is ORM?](https://www.js-data.io/docs/what-is-an-orm)


## Object Relational Mapping
Object Relational Mapping (ORM) is a technique in which data is converted between incompatible type systems using object-oriented programming languages.

Relational databases store scaler values, such as integers or strings, within tables; however, objects and tasks in object-oriented programming languages commonly use non-scalar values, particularly references to other related objects. As such, object-oriented representations of data is often incompatible wiht how data is stored within many databases. For example, if you have an ordering system that stores user account information, order information and user profile information, there are a number of relationships that are established. Though it is possible to write your own transactional code to translate these relationships to your database, you would need to do this for every project you create with a similar structure. ORM tools and libraries bridge this gap by not only providing the logic for your current configuration, but establishes a data layer that is loosely coupled, allowing for you to modularly control the input object data and output persistence data.

The Spring framework supports Hibernate, Java Data Objects (JDO) integration, and Java Persistance API (JPA) which handles resource management, data access object (DAO) implementations and transaction strategies.

### Benefits of Spring and ORM
* _Easier Testing_ : Spring IoC makes it easier to swap implementation and configuration location for objects, data, sessiong and transaction managers. This modularity allows each component to be tested in isolation, allowing for more rapid and easier tests.
* _Data Access Exceptions Wrapping_ : Spring allows you to wrap proprietary exceptions from the configured ORM tool into a common runtime DataAccessException heirarchy, allowing you to handle most non-recoverable exceptions within the appropriate persistence layer.
* _Resource Management_ : Configuration of Hibernate `SessionFactory`, JPA `EntityManagerFactory`, JDBC `DataSource` instances as well as dependent and related resources can by handled by Spring Application Context, offering easier management and better security against changes to a working environment.
* _Integration Transaction Management_ : Spring allows you to wrap ORM code with declarative, aspect-oriented programming method intercepting using the @Transactional annotation [(More in data module)](../d-data/README.md) or through explicit configuration through AOP advice in an EXML Configuration file. 

## Spring ORM with Hibernate, JPA and JDO
The primary goal for Spring ORM integration is to provide clear layering for data access and transaction technology in an application, allowing for loose coupling of application objects. Although these data access features are usable on their own, they can all integrate with Spring's application context concept easily to provide XML-based configuration and cross-referencing of plain JavaBean instances as well as Spring-aware Beans. 

Whether you use Hibernate, JPA, or JDO in a DAO, you must decide how to handle the technology's native exception classes. The DAO can throw subclass exceptions for each technology, `HibernateException`, `PersistenceException` or `JDOException`, depending on the chosen technology. These exceptions are all run-time exceptions, and do not have to be declared or caught. As such you may encounter `IllegalArgumentException` or `IllegalStateException`, which means that the caller can only treat exceptions as generally fatal, unless you adhere to the particular persistence technology's own exception structure. This means that catching specific causes is not possible unless you tie the caller to the implementation strategy. Fortunately, Spring enables exception translation to be applied transparently when using the `@Repository` annotation:

```
@Repository
public class ProductDaoImpl implements ProductDao {

    // class body here...

}
```
```
<beans>

    <!-- Exception translation bean post processor -->
    <bean class="org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor"/>

    <bean id="myProductDao" class="product.ProductDaoImpl"/>

</beans>
```
Here, the bean postprocessor would automatically look for all exception translators (the `PersistenceExceptionTranslator` interface), and advice all beans marked with the `@Repository` annotation so that the translator can intercept and apply the appropriate exception translation to any thrown exception.

### Hibernate
The following details basic configuration and implementation for DAOs, and will be discussed in greater details in the [Hibernate Integration Notes](https://gitlab.com/revature_training/spring-team/-/tree/master/modules/d-data/hibernate-integration.md).

As of Spring 4.0, Spring requires Hibernate 3.6 or later. As a best practice to avoid hard-coded lookups resources such as JDBC `DataSource` or Hibernate `SessionFactory` beans should be defined in an XML application context:
```
<beans>

    <bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="org.hsqldb.jdbcDriver"/>
        <property name="url" value="jdbc:hsqldb:hsql://localhost:9001"/>
        <property name="username" value="sa"/>
        <property name="password" value=""/>
    </bean>

    <bean id="mySessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
        <property name="dataSource" ref="myDataSource"/>
        <property name="mappingResources">
            <list>
                <value>product.hbm.xml</value>
            </list>
        </property>
        <property name="hibernateProperties">
            <value>
                hibernate.dialect=org.hibernate.dialect.HSQLDialect
            </value>
        </property>
    </bean>

</beans>
```

Hibernate utilizes a feature called contextual sessions, wherein Hibernate manages one `Session` for each transaction. Roughly speaking, this is equivalent to Spring's synchronization of one Hibernate `Session` per transaction.

The following demonstrates a DAO implmentation:
```
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection loadProductsByCategory(String category) {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from test.Product product where product.category=?")
                .setParameter(0, category)
                .list();
    }
}
```
This example follows the dependency injection pattern. You can also establish a DAO as a plain Java object and call a `setSessionFactory(..)` method with the desired reference, which can be provided as a bean definition:
```
<beans>

    <bean id="myProductDao" class="product.ProductDaoImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>

</beans>
```

### JDO
Spring supports the JDO 2.0 and 2.1 standard APIs which follows a similar style as the Hibernate support. The integretation classes for which come from the `org.springframework.orm.jdo` package.

To do you, you can define a local JDO `PersistenceManagerFactory` bean in your application context based on Spring's `LocalPersistenceManagerFactoryBean` class:
```
<beans>

    <bean id="myPmf" class="org.springframework.orm.jdo.LocalPersistenceManagerFactoryBean">
        <property name="configLocation" value="classpath:kodo.properties"/>
    </bean>

</beans>
```

Similarly to Hibernate, DAOs can be writen directly against plain JDO API without Spring dependencies:
```
public class ProductDaoImpl implements ProductDao {

    private PersistenceManagerFactory persistenceManagerFactory;

    public void setPersistenceManagerFactory(PersistenceManagerFactory pmf) {
        this.persistenceManagerFactory = pmf;
    }

    public Collection loadProductsByCategory(String category) {
        PersistenceManager pm = this.persistenceManagerFactory.getPersistenceManager();
        try {
            Query query = pm.newQuery(Product.class, "category = pCategory");
            query.declareParameters("String pCategory");
            return query.execute(category);
        }
        finally {
            pm.close();
        }
    }
}
```
Again, the above example follows a dependency injection pattern and can integrate into a Spring contatiner simply:
```
<beans>

    <bean id="myProductDao" class="product.ProductDaoImpl">
        <property name="persistenceManagerFactory" ref="myPmf"/>
    </bean>

</beans>
```
A problem with DAO implementations such as this, however, is that they always get a new `PersistenceManager` from the factory. To access a Spring-managed transactional persistence manager, you should define a proxy in front of the `PersistenceManagerFactory`:
```
<beans>

    <bean id="myPmfProxy"
            class="org.springframework.orm.jdo.TransactionAwarePersistenceManagerFactoryProxy">
        <property name="targetPersistenceManagerFactory" ref="myPmf"/>
    </bean>

    <bean id="myProductDao" class="product.ProductDaoImpl">
        <property name="persistenceManagerFactory" ref="myPmfProxy"/>
    </bean>

</beans>
```

If your data access code will always run with an active transaction, you can provide an additional `allowCreate` flag on the `TransactionAwarePersistenceManagerFactoryProxy`, as well as omite the `PersistenceManager.close()` method invocation (and subsequently the entire `finally` block), which may keep your code more concise:

```
public class ProductDaoImpl implements ProductDao {

    private PersistenceManagerFactory persistenceManagerFactory;

    public void setPersistenceManagerFactory(PersistenceManagerFactory pmf) {
        this.persistenceManagerFactory = pmf;
    }

    public Collection loadProductsByCategory(String category) {
        PersistenceManager pm = this.persistenceManagerFactory.getPersistenceManager();
        Query query = pm.newQuery(Product.class, "category = pCategory");
        query.declareParameters("String pCategory");
        return query.execute(category);
    }
}
```

```
<beans>

    <bean id="myPmfProxy"
            class="org.springframework.orm.jdo.TransactionAwarePersistenceManagerFactoryProxy">
        <property name="targetPersistenceManagerFactory" ref="myPmf"/>
        <property name="allowCreate" value="false"/>
    </bean>

    <bean id="myProductDao" class="product.ProductDaoImpl">
        <property name="persistenceManagerFactory" ref="myPmfProxy"/>
    </bean>

</beans>
```

### JPA
Spring JPA support resides in the `org.springframework.orm.jpa` package and offers comprehensive support for the Java Persistence API in a mannger similar to the Hibernate as well as JDO integrations. Spring offers three ways to set up the JPA `EntityManagerFactory`.

__LocalEntityManagerBean__:
```
<beans>
    <bean id="myEmf" class="org.springframework.orm.jpa.LocalEntityManagerFactoryBean">
        <property name="persistenceUnitName" value="myPersistenceUnit"/>
    </bean>
</beans>
```
Here, the `LocalEntityManagerFactoryBean` creates an `EntityManagerFactory` which is suitable for simple deployment environments where only JPA is used for data access within the application. This factory bean uses the JPA `PersistenceProvider` autodetection mechanism and generally only requires the persistence name to be specified. Note that this option should only be used in a simple deployment environment, such as stand-alone applications or integration tests.

__EntityManagerFactory From JNDI__:
```
<beans>
    <jee:jndi-lookup id="myEmf" jndi-name="persistence/myPersistenceUnit"/>
</beans>
```
This option should only be used when deploying to a Java EE 5 server, and is imply a matter of changing the XML configuration, as such we will not go into more detail.

__LocalContainerEntityManagerFactoryBean__:
Utilizing the `LocalContainerEntityManagerFactoryBean` gives you full JPA capabilities and control over the `EntityManagerFactory` configuration. This setup should be used in Spring environments when fine-grained customization is required. The `LocalContainerEntityManagerFactoryBean` creates a `PersistenceUnitInfo` object based on a `persistence.xml` file, a `dataSourceLookup` strategy, and a specified `LoadTimeWeaver`:
```
<beans>
    <bean id="myEmf" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
        <property name="dataSource" ref="someDataSource"/>
        <property name="loadTimeWeaver">
            <bean class="org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver"/>
        </property>
    </bean>
</beans>
```

Basic `persistence.xml` file:
```
<persistence xmlns="http://java.sun.com/xml/ns/persistence" version="1.0">
    <persistence-unit name="myUnit" transaction-type="RESOURCE_LOCAL">
        <mapping-file>META-INF/orm.xml</mapping-file>
        <exclude-unlisted-classes/>
    </persistence-unit>
</persistence>
```
Note, the `<exclude-unlisted-classes/>` (it may also be supplied as: `<exclude-unlisted-classes>true</exclude-unlisted-classes/>`) shortcut indicates that _no_ scanning should occur for annotated entity classes. If ommited (or supplied as: `<exclude-unlisted-classes>false</exclude-unlisted-classes/>`) a scan will trigger.

The `LoadTimeWeaver` interface is a Spring class that allows JPA [`ClassTransformer`](https://docs.oracle.com/javaee/7/api/javax/persistence/spi/ClassTransformer.html) (a persistence provide that supplies a ClassLoader, className, and provides an instance of this interface to the `PersistenceUnitInfo.addTransformer` method) instances to be applied in a specific manner based on whether the environment is a web container or application server.