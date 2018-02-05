# springJSF-CRUD
Spring and jsf integration CRUD example (Primefaces)


### Docker Side : 
For run the entire stack with docker level you need to know some tricks.
I've changed the pom.xml file for the wildfly configuration.

Before you clone the last version of project : 

```sh 
  /dockerize_jsf/project/clone.sh ## for clone the last version of project . (from master branch.)

```

```xml
<configuration>
  <jbossHome>/usr/local/wildfly-8.0.0.Final</jbossHome>
  <hostname>wildfly</hostname>
  <username>admin</username>
  <password>devops#abcder123</password>
</configuration>
 
 ```
 Copy and paste to the configuration block at above to the project/springJSF-CRUD/pom.xml file.
 
 End of the all .
 
```sh
  docker-compose build 
  docker-compose up 
  
  ```
  
