package com.now.backend.repositories;

import com.now.backend.models.entities.Opportunity;
import com.now.backend.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentListRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByStudent(String student);
}
