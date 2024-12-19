CREATE DATABASE StudentDB;

USE StudentDB;

CREATE TABLE Students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

INSERT INTO Students (name, age, email) VALUES
('John Doe', 20, 'john.doe@example.com'),
('Jane Smith', 22, 'jane.smith@example.com'),
('Alice Johnson', 19, 'alice.johnson@example.com');