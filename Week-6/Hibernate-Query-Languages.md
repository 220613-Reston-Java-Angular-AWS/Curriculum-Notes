# HQL

**H**ibernate **Q**uery **L**anguage is the object-oriented query language of the Hibernate Framework. HQL is very similar to SQL except that we query against **persistent objects** instead of tables and columns. 

Hibernate then **translates** the HQL queries to SQL queries and performs the action on the database. In hibernate, we can directly write SQL statements using Native SQL, but using HQL or JPQL is recommended. From the developer's perspective, this separates the application layer from the persistence layer and abstracts away the actual database interaction, promoting flexibility and reusability.

HQL is **case-sensitive for properties** like table and column names and not for keywords like SELECT, FROM, and was, etc.

**Advantages of HQL:** 
- It supports OOP concepts like polymorphism, inheritance, and abstraction.
- It is database-independent and easy to learn.

### HQL Examples

* HQL **Select** Query example to retrieve a student details whose id is 101.

```java
TypedQuery<Student> query = session.createQuery("FROM Student WHERE id = '101' ", Student.class);
List<Student> students = query.getResultList();
```

* HQL **Update** Query example to update the name to "John" whose id is 105.

```java
Query query = session.createQuery("UPDATE Student SET name = :stud_name WHERE id = :stud_id");
query.setParameter("stud_name", "John");
query.setParameter("stud_id", "105");
int result = query.executeUpdate();
```

Please note that HQL should only be used to batch-update records. If you are updating a single record, it's preferable to update the actual Java object's properties, and then persist that object and its changes back to the database with session.update(object) or session.flush()

* HQL **Delete** Query example to delete a student whose id is 108.

```java
Query query = session.createQuery("DELETE Student WHERE id = :stud_id");
query.setParameter("stud_id", "108");
int result = query.executeUpdate();
```

Similarly to updates, HQL should only be used to batch-delete records. If you are deleting a single record, it's preferable to use session.delete(object).

* HQL **Insert** statement cannot insert values directly in to a table. It is only  used to insert rows from another table. It supports only INSERT INTO … SELECT … . 

```java
Query query = session.createQuery("INSERT INTO Student(id, name) SELECT s_id, s_name FROM NewStudent");
int result = query.executeUpdate();
```

## References

* [ HQL: The Hibernate Query Language](https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#hql)



# Hibernate NativeSQL

Hibernate provides the option to execute native SQL queries through the use of the **SQLQuery** object. The `Session.createNativeQuery(String query)` method is used to create the [NativeQuery](https://docs.jboss.org/hibernate/orm/5.4/javadocs/org/hibernate/query/NativeQuery.html) object and execute it. 

**Example:**
```java        
Query query = session.createNativeQuery("SELECT id, name, age FROM student");
// Get All Students
List<Object[]> rows = query.getResultList();

for(Object[] row : rows){
	Student stud = new Student();
	stud.setId(Long.parseLong(row[0].toString()));
	stud.setName(row[1].toString());
	stud.setAge(Long.parseLong(row[2].toString()));
	System.out.println(stud);
}
```

The `getResultList()` method returns a List of Object arrays, which we need to explicitly parse to double, long etc. Hibernate will use **ResultSetMetadata** to deduce the actual order and types of the returned scalar values.

To avoid the overhead of using `ResultSetMetadata`, or simply to be more explicit in what is returned, one can use `addScalar()`:

```java
session.createNativeQuery("SELECT * FROM student")
 .addScalar("id", LongType.INSTANCE)
 .addScalar("name", StringType.INSTANCE)
 .addScalar("age", LongType.INSTANCE);
```

The `addEntity()` method used to get entity objects from a Native SQL query.

```java
Query<Student> studentSQLQuery = session.createNativeQuery("SELECT id, name, age FROM student").addEntity(Student.class);
```

Alternatively, this can be provided as an argument to the overloaded method:

```java
Query<Student> studentSQLQuery = session.createNativeQuery("SELECT id, name, age FROM student", Student.class);
```

The `addJoin()` method used to fetch the data from associated table using tables join.

```java
Query<Student> query = session.createNativeQuery("SELECT s.id, s.name, a.* FROM student s JOIN address a ON s.id = a.stud_id")
		.addEntity("e", Student.class)
		.addJoin("a", "student.address"); 
```

## References

* [Native SQL](https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#sql)


# Criteria API

Hibernate [Criteria API](https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#criteria) provides an object oriented approach for querying a database and getting results. In hibernate, we can pull the data from the database using session methods; **HQL**, **JPQL**, **Native SQL**, or the **Criteria API**.

Hibernate Criteria are a programmatic and typesafe way to fetch data from the relational database. In other words, criteria use explicit methods and return types to fetch data, rather than requiring you to write queries as Strings that might contain typos, and can't be easilly parsed to determine what the resulting type of data will be. 

The `javax.persistence.criteria.CriteriaQuery` interface provides many methods to specify criteria and the object obtained by calling the `createCriteria(Class<T>)` method of a `javax.persistence.criteria.CriteriaBuilder`. To create a Criteria object, we pass the persistent class or its entity name to the `createCriteria(Class<T>)` method, which in turn returns the instances of the persistent class.

```java
// creating the criteria object. sessionFactory must be built already.
Session session = sessionFactory.getCurrentSession();

CriteriaBuilder builder = session.getCriteriaBuilder();
// The class passed into createQuery() indicates that the results of this CriteriaQuery will be Student objects
CriteriaQuery<Student> query = builder.createQuery(Student.class);
```

The `CriteriaQuery` interface makes it easy to selectively fetch the data based on conditions in the select query. The JPA `CriteriaBuilder` class provides several methods that return **Expression** objects, which can used as conditions.

```java
// The root type indicates that the query is selecting from the tables mapped by the Student class. In this case the type matches the CriteriaQuery type, but that is not always the case.
Root<Student> root = query.from(Student.class);
query.select(root)
		.where(builder.equal( root.get("name"), "Adam") );
		// .where(builder.equal( root.get(Student_.name), "Adam") ); is also acceptable, using the metamodel syntax introduced in JPA 2.0
List<Student> studentsNamedAdam = session.createQuery(query).getResultList();
```

The CriteriaQuery interface provides the **orderBy** method to sort the result set in either ascending or descending order, accordings to expressions generated by the CriteriaBuilder.

```java
// result sorted by "name" in ascending order.
query.orderBy(builder.asc( root.get("name") ));

// result sorted by "name" in descending order.
query.orderBy(builder.desc( root.get("name") ));
```

The Criteria API supports **pagination**.s

```java
TypedQuery<Student> typedQuery = session.createQuery(query);
//5th row is the first row in the result set 
typedQuery.setFirstResult(5);
//Starting from the 5th record, and retrieve the next 10 records 
typedQuery.setMaxResults(10);

List<Student> nextTenStudents = typedQuery.getResultList();
```

## References

* [Criteria Queries](https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#criteria)