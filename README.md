# StudentManagementApp
 ## Overview
The Student Management Application is a Java-based application that allows users to manage student records, courses, enrollments, and grades. It integrates with a MySQL database to store and manage data efficiently.

## Features
- View, add, update, and delete student records.
- Manage courses and enrollments.
- Record and manage student grades.
- User-friendly console interface.

## Technologies Used
- Java 17
- MySQL
- JDBC (Java Database Connectivity)

## Database Setup
To set up the MySQL database for this application, follow these steps:

1. **Create the Database**: Use the provided `init.sql` file to create the database schema and insert initial data.
   - Run the following command in your MySQL client:
     SOURCE path/to/init.sql;

2. **Database Connection**: Update the `DatabaseConnection.java` file with your MySQL database credentials if they differ from the defaults:
   
   private static final String URL = "jdbc:mysql://localhost:3306/StudentDB";
   private static final String USER = "root";
   private static final String PASSWORD = "your_password";

## Running the Application
1. Clone the repository:
```
git clone https://github.com/yourusername/StudentManagementApp.git
cd StudentManagementApp
```
2. Compile and run the application:
```
mvn clean install
mvn exec:java -Dexec.mainClass="org.example.Main"
```
## For any inquiries, please contact:

John Timothy S. Carranza - carranza.timothy12@gmail.com
GitHub: Carranza-John-Timothy
