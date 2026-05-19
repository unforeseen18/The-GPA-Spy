CREATE DATABASE student_db;
USE student_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    roll_number VARCHAR(50) UNIQUE
);

CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    credits INT
);

CREATE TABLE enrollments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);

CREATE TABLE grades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    enrollment_id INT,
    grade_type VARCHAR(50),
    score DOUBLE,
    max_score DOUBLE,
    FOREIGN KEY (enrollment_id) REFERENCES enrollments(id)
);
