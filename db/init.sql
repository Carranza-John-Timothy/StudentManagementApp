-- Create the database
CREATE DATABASE IF NOT EXISTS StudentDB;
USE StudentDB;

-- Create Students table
CREATE TABLE IF NOT EXISTS Students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- Create Courses table
CREATE TABLE IF NOT EXISTS Courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    course_code VARCHAR(10) NOT NULL UNIQUE,
    credits INT NOT NULL
);

-- Create Enrollments table
CREATE TABLE IF NOT EXISTS Enrollments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES Students(id),
    FOREIGN KEY (course_id) REFERENCES Courses(id)
);

-- Create Grades table
CREATE TABLE IF NOT EXISTS Grades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    enrollment_id INT NOT NULL,
    grade DOUBLE NOT NULL,
    FOREIGN KEY (enrollment_id) REFERENCES Enrollments(id)
);

-- Insert initial data into Students table
INSERT INTO Students (name, age, email) VALUES
('John Doe', 20, 'john.doe@example.com'),
('Jane Smith', 22, 'jane.smith@example.com');

-- Insert initial data into Courses table
INSERT INTO Courses (course_name, course_code, credits) VALUES
('Database Systems', 'CS101', 3),
('Software Engineering', 'CS102', 4);

-- Insert initial data into Enrollments table
INSERT INTO Enrollments (student_id, course_id) VALUES
(1, 1), -- John Doe enrolled in Database Systems
(2, 2); -- Jane Smith enrolled in Software Engineering

-- Insert initial data into Grades table
INSERT INTO Grades (enrollment_id, grade) VALUES
(1, 85.5), -- Grade for John Doe in Database Systems
(2, 90.0); -- Grade for Jane Smith in Software Engineering