package com.shuni.homework2_mybatis.repository;

import com.shuni.homework2_mybatis.model.dto.request.StudentRequest;
import com.shuni.homework2_mybatis.model.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName",column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id",
                    many = @Many (select = "com.shuni.homework2_mybatis.repository.StudentCourseRepository.findCourseByStudentId")
            )
    })
    @Select("""
            SELECT * FROM students
            """)
    List<Student> findAllStudents();

    @ResultMap("studentMapper")
    @Select("""
            SELECT * FROM students
            WHERE student_id = #{studentId}
            """)
    Student findStudentById(Integer studentId);

//    @ResultMap("studentMapper")
//    @Select("""
//            INSERT INTO students (student_name,email,phone_number)
//            VALUES (#{req.studentName}, #{req.email}, #{req.phoneNumber})
//            RETURNING *;
//            """)
//    Student insertStudentCourse(@Param("id") Integer studentId, @Param("req") StudentRequest studentRequest);

    @ResultMap("studentMapper")
    @Select("""
            UPDATE students
            SET student_name = #{#req.studentName},
            email = #{req.email}, phone_number = #{req.phoneNumber}
            WHERE student_id = #{id}
            RETURNING *;
            """)
    Student updateStudentById(@Param("id") Integer studentId, @Param("req") StudentRequest studentRequest);

    @ResultMap("studentMapper")
    @Select("""
            DELETE * FROM students
            WHERE student_id = #{studentId}
            RETURNING *;
            """)
    Student deleteStudentById(Integer studentId);


}
