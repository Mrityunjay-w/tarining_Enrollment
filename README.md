# Java Spring Boot Application

#### Usage
This application is a web-based platform built using Java and Spring Boot that allows employees to enroll in various training batches. The application provides an admin interface to manage and view enrolled employees, training batches, and enrollment details.
 
#### Features

    User Enrollment: Employees can enroll in available training batches.
    Admin Dashboard: Admin can view all enrolled employees and manage training batches.
    Batch Constraints: Certain batches have limited enrollment capacity (e.g., 30 or 20 employees per batch).
 
#### Technologies Used

    Java: Version 21
    Spring Boot: Version 3.3.2
    Spring Data JPA: For database operations.
    Spring Security: For securing the application.
    Thymeleaf: Used for front-end templating.
    Tailwind CSS: For modern UI styling.
    Azure DevOps: For CI/CD and deployment.
    Azure MySQL Database: For production database hosting.
    
#### Setup and Installation Process
 
    Java 21 needs to be installed in the system, and its environment variables should be configured.
    It will connect to the Asure database automatically when you run the application.
 
#### Command to run the app

    mvn spring-boot:run
 
#### Command to build the app
    
    mvn clean install

#### Access the Application
    User Interface:
      Employees: Users can access the enrollment form, select training batches, and submit their enrollments..
      Admins: Can log in to access the admin dashboard to manage batches and view enrollments with the given credentials.

    API Endpoints:
      Public Endpoints:
          /: Accessible to all users.
          /enrollmentform: Form for employees to enroll in training.
            
      Admin Endpoints:
          /admin/dashboard: Admin dashboard to view and manage enrollments.
          (Access is restricted to admin users only.)

#### Database Schema
    The application uses the following tables:
      Batches: Stores information about training batches.
      Enrollments: Stores enrollment records linking users to batches.

#### Configuration

    Batch Constraints: The application enforces constraints on the number of employees that can enroll in certain batches.


#### The application will be accessible at (http://localhost:8080/)
