# Simple Java Spring-Boot Application
 
This application is a web-based platform built using Java and Spring Boot that allows employees to enroll in various training batches. The application provides an admin interface to manage and view enrolled employees, training batches, and enrollment details.
 
### Getting Started
 
#### Requirements:

    Java: Version 21
    Spring Boot: Version 3.3.2
    Spring Data JPA: For database operations.
    Spring Security: For securing the application.
    Thymeleaf: Used for front-end templating.
    Tailwind CSS: For modern UI styling.
    Azure DevOps: For CI/CD and deployment.
    Azure MySQL Database: For production database hosting.
    
#### Setup and Installation process
 
    - Java 21 need to installed in the system
    - It will connect to the Asure database automatically we you will run the application.
 
#### Command to run the app

    mvn spring-boot:run
 
#### Command to build the app
    
    mvn clean install

#### Usage
#### Access the Application
    User Interface:
      Employees: Can access the enrollment form, select training batches, and submit their enrollments.
      Admins: Can log in to access the admin dashboard to manage batches and view enrollments with the given Credentials.

    API Endpoints:
      Public Endpoints:
          /: Accessible to all users.
          /enrollmentform: Form for employees to enroll in training.
            
      Admin Endpoints:
          /admin/dashboard: Admin dashboard to view and manage enrollments.
          (Access is restricted to admin users only.)

#### Database Schema
    The application uses the following tables:
      batches: Stores information about training batches.
      enrollments: Stores enrollment records linking users to batches.

#### Configuration

    Batch Constraints: The application enforces constraints on the number of employees that can enroll in certain batches.


#### The application will be accessible at (http://localhost:8080/)
