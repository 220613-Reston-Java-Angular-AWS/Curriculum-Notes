## JDBC Properties Files

## References
- [How to access a properties file - Tutorial](https://www.dev2qa.com/how-to-load-jdbc-configuration-from-properties-file-example/)

## JDBC Connection
When making a JDBC connection to a database you may have noticed the code typically looks like this. 
```java 
 DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
```
But, where are we getting those values? Well up until now you have probably seen them as plain text Strings. As you can imagine this is not secure and requires you to change the code anytime the password etc. is updated. 

To solve this problem developers began to collect all of this information into properties files. A properties file stores information as key value pairs, each on their own line; the file has a .properties extension. For instance you might have, 

```properties
URL=jdbc:postgresql://localhost:5432/PubHub
CONNECTION_USERNAME=user
CONNECTION_PASSWORD=password
```
Then you can use the Properties class and FileInputStream to use these properties in your class.  

```java
FileReader fileReader = new FileReader("path-to-properties-file"); 
Properties properties = new Properties(); 
properties.load(fileReader);
URL = properties.getProperty("URL");	
CONNECTION_PASSWORD = properties.getProperty("CONNECTION_PASSWORD"); 
CONNECTION_USERNAME = properties.getProperty("CONNECTION_USERNAME"); 
```
Great! So this solves some of our problem, but we are still saving our information as plain text. Now it's just in a different kind of file. 

**Aside**: If you are using this method to read in properties for a web application that will be deployed on a server, you may need to use a different approach. When reading in a file, if you use a relative path it will be relative to the working directory. This can be unpredictable when it comes to servers, so instead we can use this method in those instances. 

```java
Properties prop = new Properties();
try {
   InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("database.properties");
   prop.load(dbProps);
} catch (Exception e) {
   LogUtil.logException(e, ConnectionUtil.class);
}
```

So the next step is to include the information as System Environment Variables instead of just plain text.

Unfortunately Java on its own will not parse our System environment variables into the application.properties file. When you begin using certain frameworks like Spring you may be able to change your .properties file to look like this. 

```properties
URL=${URL}
CONNECTION_USERNAME=${CONNECTION_USERNAME}
CONNECTION_PASSWORD=${CONNECTION_PASSWORD}
```
However for now we can simply use our properties to read in values from the System through the System library.

```properties
URL=url
CONNECTION_USERNAME=connectionUsername
CONNECTION_PASSWORD=connectionPassword
```
Then on the system we would need to make sure to create url, connectionUsername, and connectionPassword respectively. You can do this in Eclipse if you don't want to set them system wide. Simply go to Run Configurations and tab over to the Environment tab.
![Eclipse Environment Variables in Run Configuration](EnvironmentVariables.png)

Then in our Java class we'll use our values to read in from the System variables. 
```java
    FileInputStream fileStream = new FileInputStream("pathtopropertiesfile");
    Properties properties = new Properties();
    properties.load(fileStream);
	String url = properties.getProperty("URL");
	String password = properties.getProperty("CONNECTION_PASSWORD");
	String username = properties.getProperty("CONNECTION_USERNAME");
	URL = System.getenv(url);
	CONNECTION_PASSWORD = System.getenv(password);
	CONNECTION_USERNAME = System.getenv(username);
```
And then we should be good to go!


