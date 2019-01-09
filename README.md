Spring Boot REST - API Documentation With Swagger 2
==========================

This is application based on SPRING BOOT and using Swagger makes documenting your RESTful services easy.
 
# Requirements

  This application is build with maven 3, Java 8.

# Dependency

   Swagger 2 is an open-source project used to describe and document RESTful APIs.	
   We need the following dependency declaration in our Maven POM:
   
   
		<dependency>
		    <groupId>io.springfox</groupId>
		    <artifactId>springfox-swagger2</artifactId>
		    <version>2.6.1</version>
		    <scope>compile</scope>
		</dependency>
		
		<dependency>
		    <groupId>io.springfox</groupId>
		    <artifactId>springfox-swagger-ui</artifactId>
		    <version>2.6.1</version>
		    <scope>compile</scope>
		</dependency>
	
 
# Generate Library

   mvn clean install -Dmaven.test.skip=true -Dfindbugs.skip=true -Dpmd.skip=true

# Running

   Just start the application with the Spring Boot maven plugin (mvn spring-boot:run) o execute class AppHospitalApplication.	
   The application is running at http://localhost:9080
   
   On pointing your browser to: 
   http://localhost:9080/swagger-ui.html#!
   
   
   You will see the generated documentation rendered by Swagger UI:
   
   ![Screenshot from running application](images/swagger.png?raw=true "Screenshot Swagger")
   
# Docker


   

