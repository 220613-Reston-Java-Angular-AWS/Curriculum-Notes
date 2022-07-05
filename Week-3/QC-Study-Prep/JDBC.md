Difficulty,Question,Answer
,What is JDBC?,A Java API used to execute queries on various databases. Uses JDBC drivers to connect with the database
,What are the core interfaces / classes in JDBC?,"`DriverManager`, `Connection`, `Statement`, `PreparedStatement`, `CallableStatement`, `ResultsSet`"
,What is a stored procedure and how would you call it in Java?,"A stored procedure is an executable block of code that is written in PL/SQL and stored in the Oracle database. A stored procedure is called from a Java class using a CallableStatement object. When the procedure is called, its name and any relevant parameters are sent over the JDBC connection to the DBMS, which executes the procedure and returns the results (if applicable) via the connection."
,What is the difference between Statement and PreparedStatement?,"PreparedStatements are pre-compiled by the JVM. The database doesn't have to compile the SQL each and every time it is executed. PreparedStatement can be parameterized, which can make the SQL more readable. Furthermore, PreparedStatement will properly escape reserved characters to prevent SQL injection attacks."
,Steps to executing an SQL query using JDBC?,"1. Register the driver using `.forName()` (or let `DriverManager` detect and load automatically from classpath)
2. Create the connection (`DriverManager.getConnection(url,username,password)`)
3. Create a statement for executing the SQL query (`Statement st = conn.createStatement()`);
4. Execute the SQL query (`ResultSet rs = st.executeQuery(String sql)`)
5. Use `ResultSet` to get values returned (`rs.getInt(1)`, etc)
6. Close the connection (`conn.close()`) "
,How to execute stored procedures using JDBC?,Use the `Callable` statement interface
,Which interface is responsible for transaction management?,"The `Connection` interface - can `commit`, `rollback`, etc"