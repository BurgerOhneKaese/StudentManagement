package com.example.studentmanagement.Repository;

import com.example.studentmanagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT m FROM Student m WHERE m.firstName = ?1")
    List<Student> findByFirstName(String firstName);
    // public Student findByFirstName(@Param("name")String name);

    @Query("SELECT DISTINCT m.email FROM Student m WHERE m.email NOT IN ?1")
    List<Student> findDistinctByEmail(String mail);
}
