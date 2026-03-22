package com.shuni.homework2_mybatis.repository;

import com.shuni.homework2_mybatis.model.dto.request.InstructorRequest;
import com.shuni.homework2_mybatis.model.entity.Instructor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Results(id = "instructorMapper",  value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "email", column = "email")
    })

    //get all instructor
    @Select("""
            SELECT * FROM instructors
            """)
    List<Instructor> findAllInstructors();

    //get by id
    @ResultMap("instructorMapper")
    @Select("""
            SELECT * FROM instructors
            WHERE instructor_id = #{id}
            """)
    Instructor findInstructorById(@Param("id") Integer instructorId);

    //create
    @ResultMap("instructorMapper")
    @Select("""
            INSERT INTO instructors (instructor_name, email)
            VALUES (#{req.instructorName}, #{req.email})
            RETURNING *;
            """)
    Instructor saveInstructor(@Param("req") InstructorRequest instructorRequest);

    //update by id
    @ResultMap("instructorMapper")
    @Select("""
            UPDATE instructors
            SET instructor_name = #{req.instructorName}, email = #{req.email}
            WHERE instructor_id = #{instructorId}
            RETURNING *;
            """)
    Instructor updateInstructorById(Integer instructorId, @Param("req") InstructorRequest instructorRequest);

    //delete by id
//    @ResultMap("instructorMapper")
    @Select("""
            DELETE FROM instructors
            WHERE instructor_id = #{instructorId}
            RETURNING *;
            """)
    Instructor deleteInstructorById(Integer instructorId);
}
