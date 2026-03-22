CREATE DATABASE homework2_mybatis_db

CREATE TABLE students(
                         student_id SERIAL PRIMARY KEY,
                         student_name VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL,
                         phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE instructors(
                            instructor_id SERIAL PRIMARY KEY,
                            instructor_name VARCHAR(100) NOT NULL,
                            email VARCHAR(100) NOT NULL
);

CREATE TABLE courses(
                        course_id SERIAL PRIMARY KEY,
                        course_name VARCHAR(100) NOT NULL,
                        description VARCHAR(255),
                        instructor_id INT NOT NULL
                            REFERENCES instructors(instructor_id)
                                ON DELETE CASCADE
                                ON UPDATE CASCADE

);

CREATE TABLE student_course(
                               student_id INT
                                   REFERENCES students(student_id)
                                       ON DELETE CASCADE
                                       ON UPDATE CASCADE,
                               course_id INT
                                   REFERENCES courses(course_id)
                                       ON DELETE CASCADE
                                       ON UPDATE CASCADE
);