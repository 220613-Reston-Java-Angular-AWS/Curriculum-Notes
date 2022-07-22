## Named Queries

In Hibernate, a [Named Query](https://docs.jboss.org/hibernate/jpa/2.1/api/javax/persistence/NamedQuery.html) is a SQL expression with a predefined unchangeable query string. We can define a named query either in the **hibernate mapping file** or in an **entity class**.

**Annotations used in an entity class:**

* `@NamedQueries` - used to define the multiple HQL expressions.
* `@NamedQuery` - used to define the single HQL expression.
* `@NamedNativeQueries` - used to define the multiple native SQL expressions.
* `@NamedNativeQuery` - used to define the single native SQL expression.

`@NamedQuery` has two attributes:
* **name**  - used to specify a name by which a session object can locate the query.
* **query** -  used to specify the HQL statments.

**Example:**
```java
@Entity
@Table(name = "student")
@NamedQueries({  

	@NamedQuery(name = "viewAllStudents", query = "FROM Student s") 
	@NamedQuery(name = "findStudentByID", query = "FROM Student s WHERE s.id = :id")
	@NamedQuery(name = "findStudentByName", query = "FROM Student s WHERE s.name = :name")
 
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    public student(){
    }
   
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    //getters and setters
}
```

The `session.getNamedQuery(String query_name)` method used to run the specified named query defined at the entity class.

```java
public class Application {

 public static void main(String[] args) 
 {
  StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
  SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
  Session session = sessionFactory.openSession();
  session.beginTransaction();
  
  Query query = session.getNamedQuery("findStudentByID").setParameter("id", 32);
  
  List students = query.getResultList();
  for(Student student : students)
  {
   System.out.println(student);
  }
  session.getTransaction().commit();
  session.close();
 }
}
```

## References

* [Named Queries](https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#jpql-api-named-query-example)