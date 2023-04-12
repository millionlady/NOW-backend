package com.now.backend.service;

import com.now.backend.model.StudentList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentListService {
    public List<StudentList> getStudenList() {
        List<StudentList> studentList = new ArrayList<>();
        StudentList students = new StudentList(2, "John Doe", "02.05.2023", "johndoe@email.com", "80%", 25, 70);
        studentList.add(students);

        StudentList students1 = new StudentList(3, "John Doe1", "10.06.2023", "johndoe1@email.com", "60%", 45, 90);
        studentList.add(students1);

        return studentList;
    }
}
