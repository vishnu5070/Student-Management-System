-- Create Database
CREATE DATABASE IF NOT EXISTS studentdb;

-- Use Database
USE studentdb;

-- Create Students Table
CREATE TABLE IF NOT EXISTS students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15)
);

-- Sample Data (Optional – for testing)
INSERT INTO students (student_id, name, department, email, phone)
VALUES
(101, 'Vishnu Vardhan', 'AI & DS', 'vishnu@gmail.com', '9876543210'),
(102, 'Rahul Kumar', 'CSE', 'rahul@gmail.com', '9123456780');

-- View Data
SELECT * FROM students;
