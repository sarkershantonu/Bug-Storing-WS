# Bug web service 
This is a small webservice for storing bug in a table. 
The main idea is to store bug in HSQLDB and use this webservice to practice REST webservice testing using tools/framework.  


# Useful Maven commands 

- mvn clean test

- mvn clean release 

- mvn spring-boot:run

# Docker Deployment (todo)

# JIB Deployment (to do) 
- https://github.com/GoogleContainerTools/jib

# Deploy and run from JAR
mvn clean package

=> this will generate a Jar file in target folder. The name of the jar file will be "spring-boot-webservice-1.0.SNAPSHOT.jar" 
so, you need to copy that and put in any folder you like. This is standalone runner (jetty server built in) . Now, from commandline 

java -jar generated_jar_file_name

# URL config 
Host : localhost

Port :9100

URL/Paths : 

1. To see all bugs : GET : /table/bugs
2. To save a bug: POST : /table/bugs
3. To see a bug : GET : /table/bugs/{id}
4. To Update a Bug: PUT : /table/bugs/{id}
5. To Delete a Bug : DELETE : /table/bugs/{id}


# Authentication 
No auth for 1.0

Basic auth for 2.0 (see credentials in application . properties) 

# Properties 
See , resources/config folder for configuration. 

# HSQL DB 
see resources/data folder


# Sample data : 

   {
     "id": 1,
     "title": "this is a bug",
     "summary": "Sample Bug" ,
     "exceptions": "Exception Is not present",
     "comments": "Comments ",
     "foundDateTime":"1st december",
     "tags": "New, On production",
     "priority": "High",
     "servility": "Blocker",
     "attachmentPath": "http://",
     "description": "Sampel Data "
   }
 
 
# Test tools 
1. postman or other browser plugins : Functional Testing
2. Jmeter  : performance Testing
3. soapui etc
4. IDE Plugins
5. Rest Assured 
 
 etc
 

# Version 
 - 1.0 will be no auth 
 
 - 2.0 will be basic auth
 
 - 3.0 with basic auth & unit tests

 - 4.0 with HTTPs support over 3.0 
 - 5.0 documentation integration : https://github.com/swagger-api/swagger-core/wiki/annotations
 # Update  : jmeter tests are in a folder
 
 # todo
 - Integration with OAuth 2.0 (google host)
 - Provider :  google, github, Microsoft
 - Update spring boot => done 
 - Swagger
 - Docker deploy
 
 # Unite testing
- Unit Testing is being tracked in seperate branch

# Installation Scripts 
- ENV
- TEST
- Jenkins
- Docker
