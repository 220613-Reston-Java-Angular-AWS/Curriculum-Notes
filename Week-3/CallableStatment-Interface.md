## `CallableStatment` Interface

`CallableStatement` interface is used to execute stored procedures. You create an instance of a `CallableStatement` by calling the `prepareCall()` method on a connection object. A `CallableStatement` can return one `ResultSet` object or multiple `ResultSet` objects.

```java
//con is the Connection object
//It calls the procedure 'myprocedure' that receives 2 arguments.
CallableStatement stmt=con.prepareCall("{call myprocedure(?,?)}");  
```
### Example:

In this example, we are going to call the stored procedure `INSERTROWS` that receives `id` and `name` as the parameter and inserts it into the table `STUDENT`.

The `STUDENT` table structure is given below:
```SQL
create table STUDENT(id number(10), name varchar2(200));  
```

And `INSERTROWS` stored procedure looks like:

```sql
create or replace procedure "INSERTROWS"  
(id IN NUMBER,  
name IN VARCHAR2)  
is  
begin  
insert into user420 values(id,name);  
end;  
/     
```

#### Accessing Stored Procedures 

Following code inserts new records into the `STUDENT` table by calling the above created stored procedure `INSERTROWS`, using a callable statement.

```java
public static void main(String[] args) throws Exception{  
  
//Registering the Driver
Class.forName("oracle.jdbc.driver.OracleDriver");  
//Getting the connection
Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  

//Preparing a CallableStateement
CallableStatement stmt=con.prepareCall("{call INSERTROWS(?,?)}");  

stmt.setInt(1,1011);  
stmt.setString(2,"John");  
stmt.execute();  
  
System.out.println("success");  
}  
}  
```

