## Spring Data with Neo4j
Example on how to use Spring Data with Neo4j

### Steps
* Install Neo4j (Tested with community 2.3.2) and set up a username + password
* Add your credentials to:
```
AppConfiguration.java
```
* Run Neo4j
* Run the application

### See output
* To see the state of the database, run Neo4j in console mode using:
```
./neo4j-community-2.3.2/bin/neo4j console
```
* Comment out deletion code to leave nodes in the database
* You should observe:

![image](users.png?raw=true "image")


