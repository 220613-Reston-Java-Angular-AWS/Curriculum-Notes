## Caching in Hibernate

Hibernate performs caching to **optimize the performance** of an application. It's used to reduce the number of database hits by storing data locally in a cache.


![caching](./../images/cache.jpg)


### First-Level Cache / L1 cache

The first-level cache is the first place that Hibernate checks for cached data. L1 caching in hibernate is enabled by default, and we can't disable it. It is a mandatory cache through which all requests must pass. 

* This type of cache is associated with the **Session object**. Each Session object caches data independently, so there is *no sharing of cached data across sessions*, and the cached data is deleted when the session closes.
* An L1 cache is internal to a Session object and not accessible to any other session object in an application. 
* This type of cache is only useful for repeated queries in the same session.
* When we query an entity first time, it retrieves the data from the database and stores it in the L1 cache associated with the session. If we query again with the same session object, then it loads the data from the L1 cache.

### Second-Level Cache/ L2 Cache

L2 cache is responsible for caching objects and sharing data across sessions. The L2 cache is associated with the **SessionFactory object** and is shared among all sessions created using the same session factory. 

If the requested query results are not in the first-level cache, then the second-level cache is checked. Any technology that supports out-of-the-box integration with Hibernate can be plugged in to act as a second-level cache.

The L2 cache is disabled by default but we can enable it through configuration. If L2 caching is enabled for an entity, the following workflow is used:

*  If an instance is already present in the L1 cache, then it is returned from there.  
*  If an instance is not found in the L1 cache, the L2 cache is searched, and if found the data is fetched and returned from there.
*  If the data is not cached in the L2 cache, then the necessary data is loaded from the database and an instance is assembled and returned.

We can enable the L2 cache by adding the following properties to the **hibernate configuration file**.

```xml
<!-- Enable the second-level cache -->  
<property name="cache.use_second_level_cache">true</property>
<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
``` 

To make an **entity** eligible for L2 caching, we annotate it `@Cache` annotation and specify a **cache concurrency strategy**. It's a best practice to annotate the entity class with `@Cacheable` annotation, although not required by Hibernate. So the entity class looks like:

```java
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name="student")
public class Student
{
  //code goes here...
}
```

A concurrency strategy it instructs hibernate on how to store objects in the cache and retrieve them, in an environment where multiple sessions might be trying to manipulate the same object simultaneously. If we enable an L2 cache, then we decide the cache concurrency strategy for each persistent class and collection.  The cache concurrency strategies are:

* **READ_ONLY** - Use this strategy only for entities where we never change any data and use data as a reference.
* **NONSTRICT_READ_WRITE** - Doesn't guarantee the consistency between the cache and the database. Use this strategy only for entities where we change data rarely.
* **READ_WRITE** - Use this strategy only for entities where we read and update data. 
* **TRANSACTIONAL** - Use this strategy to cache the full transactions made on the entity.


## References

* [Caching](https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#caching)
* [Further Tutorials on Caching](https://www.tutorialspoint.com/hibernate/hibernate_caching.htm)
