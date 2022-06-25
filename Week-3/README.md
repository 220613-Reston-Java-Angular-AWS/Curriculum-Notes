# Monday

## AWS (Amazon Web Services) 

### What is Cloud Computing?

Cloud computing is the on-demand delivery of compute power, database storage, applications and other IT resources through a cloud services platform via the Internet with pay-as-you-go pricing.

Cloud computing provides a simple way to access servers, storage, databases and a broad set of application services over the Internet.  

### 6 Advantages of Cloud Computing

1. Trade capital expense for variable expense.
2. Benefit from massive economies of scale.
3. Stop guessing about capacity.
4. Increase speed and agility.
5. Eliminate overhead cost of maintaining data centers
6. Go global in minutes.

### Trade capital expense for variable expense
Instead of having to invest heavily in data centers and servers before you know how you’re going to use them, you can pay only when you consume computing resources, and pay only for how much you consume.

### Benefit from massive economies of scale
By using cloud computing, you can achieve a lower variable cost than you can get on your own. Because usage from hundreds of thousands of customers is aggregated in the cloud, providers such as AWS can achieve higher economies of scale, which translates into lower pay as-you-go price.

### Stop guessing about capacity
Eliminate guessing on your infrastructure capacity needs. When you make a capacity decision prior to deploying an application, you often end up either sitting on expensive idle resources or dealing with limited capacity.

### Increase speed and agility
In a cloud computing environment, new IT resources are only a click away, which means that you reduce the time to make those resources available to your developers from weeks to just minutes.

### Eliminate overhead cost of maintaining data centers
Cloud computing lets you focus on your own customers, rather than on the heavy lifting of racking, stacking, and powering servers (infrastructure).

### Go global in minutes
Easily deploy your application in multiple regions around the world with just a few clicks. This means you can provide lower latency and a better experience for your customers at minimal cost.


## Paying for Cloud Services

AWS offers you a **pay-as-you-go** approach for pricing for over 160 cloud services.  With AWS you pay only for the individual services you need, for as long as you use them, and without requiring long-term contracts or complex licensing. 

* You can also use [AWS Billing and Cost Management](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/billing-what-is.html)

## 3 Models of Cloud Computing

### Infrastructure as a Service (IaaS)
Infrastructure as a Service (IaaS) is a self-service model for managing remote data center infrastructures.
AWS offers IaaS in the form of data centers.

### Platform as a Service (PaaS)
Platform as a Service (PaaS) allows organizations to build, run and manage applications without the IT infrastructure. This makes it easier and faster to develop, test and deploy applications. 

### Software as a Service (SaaS)
Software as a service (SaaS) replaces the traditional on-device software with software that is licensed on a subscription basis. It is centrally hosted in the cloud. A good example is Salesforce.com.


#### Other Major Cloud Providers
* [Microsoft Azure](https://azure.microsoft.com/en-us/)
* [Google Cloud Platform (GCP)](https://cloud.google.com/gcp/?utm_source=google&utm_medium=cpc&utm_campaign=na-US-all-en-dr-bkws-all-all-trial-e-dr-1009135&utm_content=text-ad-lpsitelinkCCexp2-any-DEV_c-CRE_113120492887-ADGP_Hybrid+%7C+AW+SEM+%7C+BKWS+%7C+US+%7C+en+%7C+EXA+~+Google+Cloud+Platform-KWID_43700009942847400-kwd-26415313501&utm_term=KW_google%20cloud%20platform-ST_google+cloud+platform&&gclid=Cj0KCQjwoJX8BRCZARIsAEWBFMIKqoP4b6G-3OlpQkCrVvMoAvss3kNL_2joyIs7N42TL-2WZRBCUaoaApspEALw_wcB)

#### 

[Create an AWS account](https://signin.aws.amazon.com/signin?redirect_uri=https%3A%2F%2Fconsole.aws.amazon.com%2Fconsole%2Fhome%3FhashArgs%3D%2523%26isauthcode%3Dtrue%26nc2%3Dh_ct%26src%3Dheader-signin%26state%3DhashArgsFromTB_us-east-2_6ab127f851343d99&client_id=arn%3Aaws%3Asignin%3A%3A%3Aconsole%2Fcanvas&forceMobileApp=0&code_challenge=sbE0GRA6ykegMHK6J031bx9vreZDd2PdMHRZGZyv6JU&code_challenge_method=SHA-256)

**I suggest setting up MFA - Multi factor authentication**


##  RDS Overview
The following overview will cover:  
* What is Amazon RDS?
* Why use RDS?
* Regions & Availability Zones
* Security
* How to interact with Amazon RDS
* Using AWS RDS vs. Installing a database on an AWS EC2 Instance

### What Is Amazon Relational Database Service (Amazon RDS)?
Amazon Relational Database Service (Amazon RDS) is a web service that makes it easier to set up, operate, and scale a relational database in the AWS Cloud. It provides cost-efficient, resizable capacity for an industry-standard relational database and manages common database administration tasks.
<br />
<br />
![](./../images/amazon-RDS.png)
<br />

* RDS **automates** expensive and time consuming tasks such as managing backups, software patching, automatic failure detection, and recovery.  

* You can help control who can access your RDS databases by using **AWS Identity and Access Management (IAM)** to define users and permissions.  

* RDS is available on several **database instance types**.  **Instance types** comprise varying combinations of CPU, memory, storage, and networking capacity and give you the flexibility to choose the appropriate mix of resources for your database.
    * Examples of instance types include `T3`, `T2`, `M6g`, `M5`, etc...You can read more about instance types [here](https://aws.amazon.com/rds/instance-types/).  
<br />

* RDS is **free to try** and you will be charged based on how much computational power you use per month (pay-as-you-go).  

* RDS provides you with six familiar database engines to choose from, including Amazon Aurora, PostgreSQL, MySQL, MariaDB, Oracle Database, and SQL Server. 
   ![](./../images/database-vendors.png)


### Why Use RDS?
It's important to distinguish AWS RDS from *other database solutions offered through AWS*.

* AWS offers 15 database engines including *relational, key-value, document, in-memory, graph, time series, and ledger databases*.  

* With **RDS**, you don’t need to worry about database management tasks such as server provisioning, patching, setup, configuration, backups, or recovery. The RDS manages this for you.  

* **RDS** is a **relational** database service, therefore it organizes data within tables in rows and columns.  Compare this to non-relational or NoSQL databases which use different mechanisms to store and retrieve data through key-value pairs, document models, etc.  
<br />


See the image below to see how AWS RDS differs from other databases available in AWS.

![](./../images/rds-vs-otherDBs.png)
<br />
<br />

### Regions & Availability Zones
* An **AWS Region** is a highly available data center that houses Amazon cloud computing resources in different areas of the world (for example, North America, Europe, or Asia).  

* Each AWS Region contains multiple distinct locations called **Availability Zones**, or AZs.  

* Each Availability Zone is engineered to be isolated from failures in other Availability Zones. Each is engineered to provide inexpensive, low-latency network connectivity to other Availability Zones in the same AWS Region. 

* By launching instances in separate Availability Zones, you can protect your applications from the failure of a single location.  This makes AWS fault-tolerant.
    * **Fault-tolerance** defines the ability for a system to remain in operation even if some of the components used to build the system fail.
<br />

 ![](./../images/time-zones.png)

### Security
* A **security group** controls the access to a DB instance. It does so by allowing access to IP address ranges or Amazon EC2 instances that you specify.

* You can set security groups when configuring your RDS instance.  


### How to Interact with Amazon RDS
There are several ways that you can interact with Amazon RDS.

#### 1. AWS Management Console
You can manage your DB instances from the console with no programming required. To access the Amazon RDS console, sign in to the AWS Management Console and open the Amazon RDS console at <a href="https://signin.aws.amazon.com/signin?redirect_uri=https%3A%2F%2Fconsole.aws.amazon.com%2Frds%2F%3Fstate%3DhashArgs%2523%26isauthcode%3Dtrue&client_id=arn%3Aaws%3Aiam%3A%3A015428540659%3Auser%2Frds&forceMobileApp=0">https://console.aws.amazon.com/rds/</a>

#### 2. Command Line Interface
You can use the AWS Command Line Interface (AWS CLI) to access the Amazon RDS API interactively.  Install the AWS CLI [here](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html).  To begin using the AWS CLI with RDS, view the [AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/rds/index.html).

#### 3. Programatically Accessing Amazon RDS
While developing an application, developers may use the *AWS Software Development Kits (SDKs)* and utilize the [RDS Application Programming Interface (API)](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/ProgrammingGuide.html) to automate tasks for managing DB instances and other objects in Amazon RDS.

### Using AWS RDS vs. Installing a database on an AWS EC2 Instance
DB services (like RDS) are *managed* services, meaning that you have limited control over the actual database. (i.e you can't install particular software you may need).

* **EC2 (Elastic Cloud Compute)**, on the otherhand, gives you maximum control over the software stack, database, and operating system.
* **EC2** allows you compute capacity and `SUPER` priveleges, increasing flexibility.

* **RDS** is more cost-effective and is automated, but limits your control over the database.
* **RDS** takes care of your database from end-to-end by managing, maintaining, and securing it, eliminating overhead costs and the role of a DBA (Database Administrator).  


> For a full comparison of AWS RDS vs. EC2 see [this article](https://medium.com/awesome-cloud/aws-amazon-rds-vs-amazon-ec2-relational-databases-comparison-b28eb0802355#:~:text=Whereas%2C%20for%20more%20control%20and,from%20end%2Dto%2Dend.&text=maintaining%2C%20and%20securing.-,Whereas%2C%20for%20more%20control%20and%20flexibility%2C%20EC2%20will%20be,better%20for%20your%20relational%20database.).  
> Find the EC2 overview module [here](https://gitlab.com/revature_training/aws-core-team/-/tree/master/modules/ec2).  


### References
* [Databases on AWS](https://aws.amazon.com/products/databases/?nc=sn&loc=0)
* [RDS Instance Types](https://aws.amazon.com/rds/instance-types/)

<br>

## Intro to DBMS
DBMS stands for DataBase Management System. A database is a collection of data, and the management system is a set of programs to store and access that data in a quick and effective manner. Database systems are developed to handle large amounts of data. There are many features to modern database management systems and we will only be touching on a little of the subject matter. When we talk about persisting data in a database, what we technically mean is allowing a DBMS to persist that data in an instance of a database. 

 ![](./../images/dbms.png)

Relational databases are often contrasted with another category of databases - non-relational databases. We won't go into the details of non-relational databases here, but you should be aware that there are major differences. Nonrelational databases do not store data within tables that relate to each other, and thus do not use SQL to interact with the databse.

RDBMS systems are one of the key components of any enterprise application or system. Why is this the case? Think about it - data by itself doesn’t mean a lot or even have intrinsic value. A lot of data thrown in a bucket would it mean be meaningless unless some kind of processing and analysis was done on it. Related data is what provides meaning and organizes the structure of data. For example, “an employee is in one or more departments”. We might have one table to store employees and another to store departments, and then define some relationship between them.

Normally, relational databases are used in an OLTP (OnLine Transaction Processing) environment, which means that the idea of having related data is preferable in a very transactional system, and that are normally row-based.

For non-transactional environments, the counter part is OLAP (OnLine Analytic Processing) systems, which are normally columnar-based, which is faster for reading but slower for manipulation.

[More info on DBMS](https://www.techtarget.com/searchdatamanagement/definition/database-management-system#:~:text=A%20database%20management%20system%20(DBMS,delete%20data%20in%20a%20database.)

<br>
<br>

# Tuesday

## SQL
SQL, or Structured Query Language, is a scripting language used to manipulate relational databases, commonly referred to as SQL databases. In the strictest sense SQL instructs a relational database management system in a similar way to how Java instructs the compiler and JS instructs the interpreter.
  
*SQL is often referred to as "sequel". Be cool, say sequel.*
  
## SQL Flavors
SQL is a standard described originally by Sun Microsystems, which is now owned by Oracle. The main SQL standard is implemented slightly differently by a number of different groups including Oracle, and Microsoft to name a few. These flavors of SQL are each a superset of the SQL standard with added features and slight syntactical differences. Once we know one it isn't difficult to transition to another. The flavor we will be working with in this training is PostreSQL.

### SQL Sublanguages
The types of SQL commands used to query and manipulate data within a database can be categorized into 5 sub-languages (or dialects). We will be primarily interested in the first 3 seen below, DDL, DML, and DQL. 

1. **DDL Data Definition Language:** Statements used to create tables and databases as well as defined properties.
    * `CREATE`, `ALTER`, `DROP`, `TRUNCATE`
2. **DML (Data Manipulation Language):** Statements used to insert or remove data from tables.
    * `INSERT`, `UPDATE`, `DELETE`
3. **DQL (Data Query Language):** Statements used to query data from a table.
    * `SELECT`
4. **DCL (Data Control Language):** Statements used to control who can access data.
    * `GRANT`, `REVOKE`
5. **TCL (Transaction Control Language):** Statements used to commit and restore data through transaction.  Transactions group a set of tasks into a single execution unit.
    * `COMMIT`, `ROLLBACK`, `SAVEPOINT`

### Data Types

When defining the properties of an entity in the database (i.e. the columns), you must specify the data type to store. Common SQL datatypes include:

#### Numeric
- INT
- TINYINT
- BIGINT
- DECIMAL
- NUMERIC
- FLOAT
- REAL

#### Date/Time
- DATE
- TIMESTAMP
- DATETIME
- TIME
- YEAR

#### Character/String
- CHAR
- NCHAR
- VARCHAR
- NVARCHAR
- NTEXT

#### Binary
- BINARY
- VARBINARY
- IMAGE

#### Miscellaneous
- CLOB
- BLOB
- XML
- JSON

Each database vendor may support their own data types, or not support some of the ones listed above. Refer to the specific vendor documentation for more information.

### Conventions

SQL is a case-insensitive language, but the convention is to use UPPERCASE to refer to SQL keywords and lowercase for non-SQL specific entities (like table or column names). This helps distinguish between SQL keywords and other words. Also, for readability purposes we should split long commands or queries into multiple lines.

For example, this:

```sql
SELECT * FROM table1
LEFT JOIN table2 ON table1.a = table2.b
WHERE table1.x < 5
AND table2.y > 8
ORDER BY table1.a DESC
```

is much more readable than:

```sql
SELECT * FROM table1 LEFT JOIN table2 ON table1.a = table2.b WHERE table1.x < 5 AND table2.y > 8 ORDER BY table1.a DESC
```
