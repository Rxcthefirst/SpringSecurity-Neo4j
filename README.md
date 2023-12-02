# Spring Security API Template Using Neo4j

This application is meant to server as a template for using Spring Boot 3, Spring Security 6, and Neo4j (Currently version 5.3.0).
User information will be saved into the Neo4j database, and JWT tokens will be used to authenticate and secure endpoints.

### Spring Boot 3

This application uses Spring Boot 3.2 as a dependency. As

### Spring Security 6

In correspondence with the update to the Spring Boot 3 (As of December 2023), the application will be using Spring Security 6,
as it is the version that works with SB3. 
This template is meant to serve as a starting point for building an API that uses a Neo4j server for authentication and user management.
All endpoints that are created will be secured with JWTs. The developer can follow the DemoController to see an example 
of how to configure a secured endpoint. Reference the SecurityConfig module in order to configure the security for 
specific endpoints.

### Neo4j 

The configuration for the Neo4j database connection can be configured in the application.properties file found in the
resources. In order to set this up locally, the user should download and install the latest version of neo4j desktop,
and then create and run a server locally. The 

Other options for running the database layer in Neo4j include using a docker container to run the instance.