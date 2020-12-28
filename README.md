# springboot-mvc-crud
Spring Boot MVC CRUD demonstrate simple CRUD operations with ***Customer*** entity.

This project based on the Spring Boot project and uses this Dependencies:
* Maven
* Spring Core
* Spring Data(Hibernate & MySQL)
* Spring MVC
* Hibernate Validator
* Thymeleaf


# Installation:
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

# Database configuration
Open file ***create_db_&_table_sql_script.sql*** in your MySQL Workbench to create database and table that uses in this project.
Change username and password in ***application.properties*** file to connect to your datasource. The defaults are:
```
spring.datasource.username=root
spring.datasource.password=pass
```
# Usage
Run the project in your IDE and open http://localhost:8080 in your browser.
