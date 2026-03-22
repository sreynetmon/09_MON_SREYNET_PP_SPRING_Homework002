package com.shuni.homework2_mybatis.repository;

import com.shuni.homework2_mybatis.model.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentCourseRepository {
    @Results(id = "studentCourseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "com.shuni.homework2_mybatis.repository.InstructorRepository.findInstructorById"))
    })
    @Select("""
            SELECT c.course_id, c.course_name, c.description, c.instructor_id
            FROM courses c
            INNER JOIN student_course sc ON c.course_id = sc.course_id
            WHERE sc.student_id = #{studentId}
            """)
    List<Course> findCourseByStudentId(Integer studentId);
}
