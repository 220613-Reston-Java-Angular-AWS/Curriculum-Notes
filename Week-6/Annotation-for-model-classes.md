## XML vs Annotation configuration in Hibernate 

Hibernate classically uses an XML mapping file for the transformation of data from POJO Classes to database tables, and vice versa. An XML file gives the ability to change the configuration without rebuilding the whole project.

In especially large projects though, this can leave you with hundreds of XML files floating around. **Hibernate annotations** provide another way to define mappings directly in your POJO classes, without the use of an XML file. 


## Hibernate Annotations

Hibernate Annotations are used to provide metadata configuration inside the POJO class, so we can understand the table structure and POJO class simultaneously.

Hibernate Annotations are based on the JPA 2 specification. All the JPA annotations are defined in the **javax.persistence** package. Some of the annotation used for table and column mappings are listed below:

Consider the following **Students table** to store the Persistent objects.
```sql
create table students (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   email  VARCHAR(30) default NULL,
   PRIMARY KEY (id)
);
```

Let us create a **Student** persistent class that is mapped to a student table.

```java
package com.revature.hibernate;
import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column
    private String email;
    
    public student(){
    }
   
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
```
Hibernate annotations used in the above class are listed below:


* **`@Entity`** - Used to mark a class as a Mapped class/Persistence class. This class **must** have a no-arg constructor with package visibility so that hibernate can create an instance of the Persistent class by the `newInstance()` method.


* **`@Table`** - Used to specify the table details that used to persist the entity in the database. If the name of the database table differs from the name of the class, the name attribute should be used.

* **`@Id`** - Used to mark the field as a primary key column. Annotating multiple fields with @Id will make them composite keys

* **`@GeneratedValue`** - Used to instruct the database to generate a value for the field automatically, and to provide a strategy for doing so.

* **`@Column`** - Maps the field to the table column. The `@Column` annotation has attributes listed below:

    * **`name`** - used to specify the name of the column. By default, it's assumed the column name and variable name match. This attribute is required if that is not the case.
    * **`length`** - used to specify the size of the String value
    * **`nullable`** - used to mark the column as NOT NULL when the schema is generated.
    * **`unique`** -  used to mark the column as UNIQUE to contain unique values.

## References

* [Hibernate Annotations](https://docs.jboss.org/hibernate/stable/annotations/reference/en/html_single/)
* [Domain Model](https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#domain-model)
