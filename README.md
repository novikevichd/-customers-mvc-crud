# springboot-mvc-crud
Spring Boot MVC CRUD demonstrate simple CRUD operations with ***Customer*** entity.

This project based on the Spring Boot project and uses this Dependencies:
* Maven
* Spring Core
* Spring Data(Hibernate & MySQL)
* Spring MVC
* Hibernate Validator
* Thymeleaf

![1](https://i.ibb.co/mv37zst/1.png)
![2](https://i.ibb.co/1rLc0FP/2.png)

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
