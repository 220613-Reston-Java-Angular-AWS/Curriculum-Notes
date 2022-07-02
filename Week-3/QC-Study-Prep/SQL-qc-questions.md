# SQL

### Relations

* Explain what SQL is. What are some SQL databases?
  * Structured Query Language - allows us to interact with and manipulate relational databases like Oracle, Postgres, MySQL

* How is data structured in a SQL database?
  * Data is inserted as records, or rows, in a table. A database can have many tables that are related to each other. Each table has different columns, each with its own data type and possibly constraints. 

* What is an ERD? How is it useful?
  * Entity relationship diagram - used to model and show relationships between different tables in the database

* What are the different multiplicity relationships? How would you create these relations?
  * 1/1 - use a foreign key to relate to the primary key on another table; put UNIQUE constraint on the foreign key column
  * 1/many - foreign key on the many side of the relationship
  * many/many - use a 3rd table, called a junction table, to connect them. the junction table will have 2 foreign keys and will be the many side of both relations

* What kind of relationship would exist between Students and Classes? Students and Textbooks?
  * Students/Classes: many-to-many
  * Students/Textbooks: one-to-many

* Explain the concept of referential integrity
  * Every foreign key in the database points to a valid, existing record
  * If this is broken, we have what is called an "orphan record"

* What is a cascade delete?
  * Setting that allows referenced records to be deleted as well, if record being deleted has a foreign key
  * Ensures referential integrity, prevents orphaned records
    
* List the integrity constraints
  * UNIQUE, NOT NULL, PRIMARY KEY, FOREIGN KEY, DEFAULT, CHECK
    
* Define the word "schema"
  * Refers to the structure of the database - the columns of each table, their data types, and any constraints on them
    
* What is a candidate key? What about a surrogate key?
  * Candidate key is a set of one or more columns that can uniquely identify a record
  * Surrogate key is a column that can uniquely identify a record (can act as Primary Key)
    
* What is normalization? What are the levels?
  * The process of reducing redundancy in a database
  * 1NF: the key (PK must exist; columns must be atomic and granular)
  * 2NF: the whole key (1NF + every column relates to PK)
  * 3NF: nothing but the key (2NF + no transitive dependencies)

### Sublanguages & Queries
    
* What are the 5 sublanguages of SQL? List some commands for each
  * DDL - data definition language - CREATE, ALTER, MODIFY, DROP, TRUNCATE
  * DML - data manipulation language - SELECT, INSERT, UPDATE, DELETE
  * DCL - data control language - GRANT, REVOKE
  * DQL - data query language - SELECT
  * TCL - transaction control language - SAVEPOINT, ROLLBACK, COMMIT
    
* What is the difference between DELETE, DROP, and TRUNCATE commands?
  * DROP removes a table entirely; DELETE will remove specific rows (unless no WHERE clause); TRUNCATE will empty a table of all data but leave the schema intact
  * DROP and DELETE can be rolled back; TRUNCATE cannot
    
* What are some SQL clauses you can use with SELECT statements?
  * WHERE, HAVING, AND, OR, GROUP BY, ORDER BY, LIMIT, LIKE
   
* What is the difference between WHERE and HAVING?
  * WHERE operates on individual records; HAVING is used with GROUP BY and aggregate functions to operate on groups of records

* Explain what the ORDER BY and GROUP BY clauses do
  * ORDER BY sorts the results set on a particular column (ascending or descending)
  * GROUP BY is used with an aggregate function to combine records together

* What is the difference between joins and set operators?
  * Joins combine tables horizontally
  * Set operators combine results sets vertically

* What are the types of joins? Explain the differences.
  * INNER JOIN - only joins records that match based on join predicate
  * OUTER JOIN - joins all records in both tables, will have `null` as value if doesn't exist
  * LEFT JOIN - joins all records in left table, plus any records that match join predicate on right
  * RIGHT JOIN - joins all records in right table, plus any records that match join predicate on left
  * NATURAL JOIN - joins tables based on columns that have the same name in both tables
  * CROSS JOIN - cartesian product of records in both tables, i.e. each record in one table paired with each in another (results in M x N records)
  * SELF JOIN - joins a table with itself, FK points to PK of same table - e.g. employees table has reportsTo column for referencing manager in same table

* Explain the difference between UNION, UNION ALL, and INTERSECT
  * UNION - combines results sets, removes duplicates
  * UNION ALL - like UNION but allows duplicates
  * INTERSECT - returns the records that are in common between the two results sets

### Transactions

* What are the properties a transaction must follow?
  * Atomicity - all or nothing (transaction must fully complete or rollback)
  * Consistency - data remains in a consistent state after the transaction
  * Isolation - transactions do not interfere with one another when running
  * Durability - data will persist even in case of catastrophic failure

* Explain the different isolation levels. What read phenomena do each prevent?
  * READ UNCOMMITTED - fastest, allows dirty reads
  * READ COMMITTED - prevents dirty reads, allows non-repeatable reads
  * REPEATABLE READ - prevents non-repeatable reads, allows phantom reads
  * SERIALIZABLE - slowest, prevents phantom reads

### Other

* What is the purpose of a view? What about an index?
  * View is like a stored/cached query, useful for removing sensitive fields when giving access to a table
  * Index increases performance of queries when done on the column with the index

* What's the difference between a clustered and non-clustered index?
  * Clustered - written to disk, only one allowed per table
  * Non-clustered - uses references in memory, multiple allowed
    
* What is a trigger? Give the syntax for creating a trigger.
  * Trigger is a special type of stored procedure that runs when an event happens in the database
    
* How would you setup a primary key that automatically increments with every INSERT statement?
  * Postgres >10: use the IDENTITY keyword
  * Oracle 11g: use trigger and sequence together so that sequence increments on insert
  * Oracle 12c: IDENTITY keyword now exists

* What is the difference between scalar and aggregate functions? Give examples of each
  * Scalar - operates on a single value, e.g. UPPER, LOWER, TRIM, CONCAT, DATE
  * Aggregate - operates on multiple values, e.g. MIN, MAX, AVG, SUM
    
* What's the difference between implicit and explicit cursors?
  * Implicit cursor created automatically for you when you run a query
  * Cursor initially points to before the first record in a resultset
  * Explicit cursors must be created manually but give more control

### Practicals

Given the following table 'employees'...

| id | firstName | lastName | salary | dept |
| --- | -------- | -------- | ------ | ---- |
| 1  | Michael   | Scott    | 65     | Sales|
| 2  | Dwight    | Schrute  | 75     | Sales|
| 3  | Toby      | Flenderson| 80    | HR  |
| 4  | Jim       | Halpert  | 90     | Sales|
| 5  | Oscar     | Martinez | 90     | Accounting |
| 6  | Angela    | Martin   | 75     | Accounting |
| 7  | Kevin     | Malone   | 70     | Accounting |
| 8  | Holly     | Flax     | 60     | HR |
| 9  | Creed     | Branton  | 70     | Quality Assurance |

* Write a query to find all data in the table
  * `SELECT * FROM employees`
* Write a query to find employees with a salary over 75
  * `SELECT * FROM employees WHERE salary > 75`
* Write a query to find employees whose first name contains an 'e' or whose last name begins with 'S'\
  * `SELECT * FROM employees WHERE firstName LIKE '%e%' OR lastName LIKE 'S%'`
* Write a query to find the first name of all employees who do not work in accounting
  * `SELECT firstName FROM employees WHERE dept != 'Accounting'`
* Write a query to find the average salary of all employees whose last names begin with 'M'
  * `SELECT AVG(salary) FROM employees WHERE lastName LIKE 'M%'`
* Write a query to find the highest paid salesperson
  * `SELECT * FROM employees ORDER BY salary DESC LIMIT 1`
* Write a query to combine the resultsets of any two previous queries
  * `Must use UNION or UNION ALL`
* Remove all members of accounting from the database
  * `DELETE FROM employees WHERE dept = 'Accounting'`

* Construct a table 'department' to normalize this database

| dept_id | name |
| ------- | ---  |
| 1       | Sales |
| 2       | HR   |
| 3       | Accounting |
| 4       | Customer Service |

* Write a query to find the salary of the lowest paid salesperson (HINT: use a join)
  * `SELECT e.salary FROM employees e INNER JOIN department d ON e.dept = d.dept_id WHERE d.name = 'Sales' ORDER BY e.salary ASC LIMIT 1`
* Write a query to find the average salary of each department
  * `SELECT AVG(e.salary) FROM employees e INNER JOIN department d ON e.dept = d.dept_id GROUP BY d.name`
* Write a query to find all possible combinations of employees and departments. How many records do you expect?
  * `SELECT * FROM employees CROSS JOIN department`
* Change the name of department 4 to 'Quality Assurance'
  * `UPDATE department SET name = 'Quality Assurance' WHERE dept_id = 4`
* Remove both tables
  * `DROP employees; DROP department`