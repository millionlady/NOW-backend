package com.now.backend.services;

import com.now.backend.models.OpportunityDto;
import com.now.backend.models.StudentListDto;
import com.now.backend.models.entities.Opportunity;
import com.now.backend.models.entities.Student;
import com.now.backend.repositories.OpportunityRepository;
import com.now.backend.repositories.StudentListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentListService {
    private final StudentListRepository studentListRepository;

    public StudentListService(StudentListRepository studentListRepository) {
        this.studentListRepository = studentListRepository;
    }

    public List<StudentListDto> getStudenList() {
        List<StudentListDto> studentList = new ArrayList<>();
        List<Student> students = studentListRepository.findAll();
        for (Student student : students) {
            studentList.add(new StudentListDto(student.getId(),student.getStudent(), student.getJoinedOn(), student.getEmail(), student.getRate(), student.getCompleted(), student.getPoints()));
        }

        return studentList;
    }
}
