package com.shuni.homework2_mybatis.repository;

import com.shuni.homework2_mybatis.model.dto.request.CourseRequest;
import com.shuni.homework2_mybatis.model.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description" ,column = "description"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "com.shuni.homework2_mybatis.repository.InstructorRepository.findInstructorById")
            ),
            @Result(property = "student", column = "student_id",
                    many = @Many(select = "com.shuni.homework2_mybatis.repository.StudentCourseRepository.findCourseByStudentId")
            )

    })
    //get all
    @Select("""
            SELECT * FROM courses
            """)
    List<Course> findAllCourses();

    //get by id
    @ResultMap("courseMapper")
    @Select("""
            SELECT * FROM courses
            WHERE course_id = #{courseId};
            """)
    Course findCourseById(Integer courseId);

    @Results(id = "courseInsertMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description" ,column = "description"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "com.shuni.homework2_mybatis.repository.InstructorRepository.findInstructorById")
            )
    })
    @Select("""
            INSERT INTO courses (course_name , description, instructor_id)
            VALUES (#{req.courseName},#{req.description}, #{req.instructorId} )
            RETURNING *;
            """)
    Course saveNewCourse(@Param("req") CourseRequest courseRequest);


    //update by id
    @ResultMap("courseMapper")
    @Select("""
            UPDATE courses
            SET course_name = #{req.courseName}, description = #{req.description}, instructor_id = #{req.instructorId}
            WHERE  course_id = #{courseId}
            RETURNING *;
            """)
    Course updateCourseById(@Param("courseId") Integer courseId,@Param("req") CourseRequest courseRequest);

    @Select("""
            DELETE FROM courses
            WHERE course_id = #{courseId}
            RETURNING *;
            """)
    Course deleteCourseById(Integer courseId);
}
