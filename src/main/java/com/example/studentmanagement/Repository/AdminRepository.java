package com.example.studentmanagement.Repository;

import com.example.studentmanagement.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query("SELECT u FROM Admin u WHERE u.mail = ?1")
    Admin findByEmail(String email);
}
