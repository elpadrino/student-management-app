package com.elpadriiino.studentmanagementapp.repository;

import com.elpadriiino.studentmanagementapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
