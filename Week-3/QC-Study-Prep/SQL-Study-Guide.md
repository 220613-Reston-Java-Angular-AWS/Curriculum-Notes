## SQL Study Guide

You should be able to explain and apply the following topics:

### RDBMS Basics
- SQL language and sublanguages
  - DDL (data definition)
  - DML (data manipulation)
  - DQL (data query)
  - DCL (data control)
  - TCL (transaction control)
- RDBMS systems and popular vendors
- Relational vs non-relational databases
- SQL data types
- Database schema
- Column constraints
  - UNIQUE
  - NOT NULL
  - PRIMARY KEY
  - FOREIGN KEY
  - CHECK
  - DEFAULT
- Candidate and composite keys

### Relationships & Normalization
- Multiplicity relationships
  - 1-1
  - 1-Many
  - Many-Many
- Junction tables
- Normalization
  - 1NF ("key")
  - 2NF ("whole key")
  - 3NF ("nothing but the key")

### Queries
- Query Clauses
  - WHERE
  - HAVING
  - ORDER BY
  - GROUP BY
- Aliases
- Joins
  - Inner
  - Outer
  - Left
  - Right
  - Cross
  - Self
  - Equi / non-equi
  - Theta
  - Natural
- Set Operations
  - Union
  - Union All
  - Intersect
  - Minus / Except
- Indexes
- Views
- Aggregate functions
  - MIN
  - MAX
  - AVG
  - COUNT
- Scalar functions
  - LEN
  - UPPER
  - LOWER
  - TRIM
- PL/SQL
  - Sequences
  - Triggers
  - Stored procedures
  - Cursors
 
### Transactions
- Properties of a transaction (ACID)
  - Atomic
  - Consistent
  - Isolated
  - Durable
- Isolation levels
  - Read uncommitted
  - Read committed
  - Repeatable read
  - Serializable

### JDBC
- JDBC classes/interfaces
  - DriverManager
  - Connection
  - DataSource
  - SQLException
  - Statement
  - PreparedStatement
  - CallableStatement
  - ResultSet
- Creating database connection
- Connection string
  - URL
  - Username
  - Password
- JDBC autocommit mode
- Data access object pattern (DAO)