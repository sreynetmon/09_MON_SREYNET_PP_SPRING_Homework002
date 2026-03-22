INSERT INTO students (student_name, email, phone_number)
VALUES ('John Doe', 'john@example.com', '012345678'),
       ('Jane Smith', 'jane@example.com', '098765432'),
       ('Michael Lee', 'michael@example.com', '011223344'),
       ('Sok Dara', 'dara@gmail.com', '077889900'),
       ('Chantha Vann', 'chantha@gmail.com', '066778899');

INSERT INTO instructors (instructor_name, email)
VALUES 	('Dr. Brown', 'brown@gmail.com'),
          ('Prof. Green', 'green@gmail.com'),
          ('Mr. Sok', 'sok@gmail.com');
          ('Ms. Chan', 'chan@gmail.com'),
          ('Dr. Lee', 'lee@gmail.com'),
          ('Prof. Kim', 'kim@gmail.com'),
          ('Mr. Dara', 'dara@gmail.com'),
          ('Ms. Phalla', 'phalla@gmail.com'),
          ('Dr. Smith', 'smith@gmail.com'),
          ('Prof. Johnson', 'johnson@gmail.com');

INSERT INTO courses (course_name, description, instructor_id)
VALUES	('Database Systems', 'Learn SQL and database design', 1),
          ('Web Development', 'HTML, CSS, JavaScript basics', 2),
          ('Java Programming', 'OOP with Java', 3),
          ('Networking', 'Computer network fundamentals', 3);


UPDATE instructors
SET instructor_name = 'Meyneang', email = 'neang@gmail.com'
WHERE instructor_id = 15;

SELECT * FROM instructors;
SELECT * FROM courses;
SELECT * FROM courses WHERE course_id = 9;
INSERT INTO courses (course_name, description, instructor_id)
VALUES ('Spring boot', 'is a open-source framework',9 )
    RETURNING *;