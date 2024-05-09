package com.elpadriiiino.studentmanagementapp.repository;

import com.elpadriiiino.studentmanagementapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
