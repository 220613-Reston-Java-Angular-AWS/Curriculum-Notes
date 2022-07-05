Difficulty,Question,Answer
,What is Maven?,A build automation and dependcy management tool for Java applications
,What is the Maven lifecycle?,"Validate => project is correct and all necessary information is available
Compile => compiles project source code
Test => tests all compiled code
Package => packages all compiled code to WAR/JAR file
Integration => performs all integration tests on WAR/JAR
Verify => runs checks on the results of integration tests
Install => installs WAR/JAR to local repository
Deploy => copies final WAR/JAR to the remote repository"
,Where / when does Maven retrieve dependencies from? Where are they stored locally?,"Maven first looks to see if the dependency is in the local repo under `.m2` directory. If not, it will download the necessary .jar file(s) from the remote central Maven repository into the `.m2` directory"
,What is the POM and what is the pom.xml?,POM stands for project object model and is the model used by Maven to understand project attributes and dependencies. The pom.xml is the xml document which lists those attributes and dependencies