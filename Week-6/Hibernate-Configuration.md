# Hibernate Configuration

The Hibernate configuration file contains the database mapping information that tells Hibernate how it should communicate with the database, and where the mapping for individual classes/tables can be found. These configurations are provided either in an XML file (which must be named `hibernate.cfg.xml`) or properties file (`hibernate.properties`).

## hibernate.cfg.xml file

The *hibernate.cfg.xml* file contains the database and session related configuration. Database configuration includes the JDBC connection URL, Database user credentials, driver class, and hibernate dialect.  

This file will get loaded through the **Configuration** class. In the configuration class, we have a `configure()` method, which loads the *hibernate.cfg.xml* file and returns **SessionFactory** reference. The Session Factory reference used to get a **session** object.

**Example of hibernate.cfg.xml for a MySQL Database:**
```xml
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
	<session-factory>
		<!-- SQL Dialect -->
		<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
		
		<!-- Database Connection Settings -->
		<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/test_db?useSSL=false</property>
		<property name="hibernate.connection.username">root</property>
		<property name="hibernate.connection.password">root</property>
	 
		<!-- Connection Pool Size (built-in) -->
		<property name="hibernate.connection.pool.size">1</property>
	 
		<!-- show all generate SQL query -->
		<property name="show_sql">true</property>
	 
		<!-- Drop the existing tables and create new one --> 
		<property name="hbm2ddl.auto">create</property>
	 
		<!-- Mention here all the model classes along with their package name --> 
		<mapping class="com.revature.hibernate.Student"/>
	</session-factory> 
</hibernate-configuration>
```

The hibernate.cfg.xml file has the `<hibernate-configuration>` element as a root element, which has a `<session-factory>` element as its child.  The `<session-factory>` element contains a database and mapping information. 

The `<mapping>` element lists a single java classe that is mapped to a table in the database. If a class is mapped using hibernate annotations, then the `<mapping>` element should use the `class` attribute; if the class is mapped using an XML file, the `resource` attribute should be used instead. You should use one `<mapping>` element for each mapped class. The Hibernate properties used in hibernate.cfg.xml file are listed below:

* **hibernate.dialect** - specifies the type of database used in hibernate so that hibernate generates the appropriate type of SQL statements. The [org.hibernate.dialect](https://docs.jboss.org/hibernate/orm/5.4/javadocs/org/hibernate/dialect/package-summary.html) package contains the SQL dialect for the databases.
* **hibernate.connection.driver_class** - used to register or load the JDBC driver class. The name should be fully qualified class name like `oracle.jdbc.driver.OracleDriver` for oracle , `com.mysql.jdbc.Driver` for MySQL, etc. 
* **hibernate.connection.url** -  used to mention the JDBC URL to the database instance.
* **hibernate.connection.username** - username used to connect to the database.
* **hibernate.connection.password** - password for the username being used to connect to the database.
* **hibernate.connection.pool.size** - used to limit the number of connections waiting in the Hibernate database connection pool.
* **show_sql** - If this property value is *true* then it enables the logging of all hibernate-generated SQL statements to the console.
* **format_sql** - If this property value is *true* then it formats the generated SQL statement to make it more readable.  
* **use_sql_comments** - If this property value is *true* then it insert comments inside all generated SQL statements.
* **hibernate.hbm2ddl.auto** - used to create, update or validate the database schema DDL when the SessionFactory Object created. The four possible values for this property are,
    *   **create** - creates new database tables based on your class mappings.  If a table already exists, then it will drop the existing table and create a new table.
    *   **update** – Updates the existing database tables to match the class mappings. If a table doesn't exist, then it creates a new table.
    *   **validate** - validates the existing tables against the provided mappings, and doesn't make any changes to the database. If the validation fails, the application will not work properly.
    *   **create-drop** - as create, but explicitly drops all existing tables when the SessionFactory is closed (which of course loses all the data in those tables). 


## hibernate.properties file

We can use a *hibernate.properties* file to configure Hibernate instead. 

Hibernate searches for the *hibernate.cfg.xml* file or the *hibernate.properties* file at startup to find the configuration in our classpath. If both are present, then hibernate gives priority to a *hibernate.cfg.xml* file over a *hibernate.properties* file.

A *hibernate.properties* file equivalent to the above *hibernate.cfg.xml* file is given below:
```properties
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.connection.driver_class=com.mysql.jdbc.Driver
hibernate.connection.url=jdbc:mysql://localhost:3306/test_db?useSSL=false
hibernate.connection.username=root
hibernate.connection.password=root
show_sql=true
hbm2ddl.auto=create
```

The difference between a *hibernate.cfg.xml* and *hibernate.properties* file is that in an XML file we can directly map classes using the `<mapping>` element, but there is no way to configure this in a properties file. So, we map the classes using programmatic configuration.

We can specify the mapped class using Configuration object:
```java
Configuration configuration = new Configuration();
configuration.configure().addAnnotatedClass(Student.class);
```

## References

* [Hibernate Configuration](https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#configurations)

