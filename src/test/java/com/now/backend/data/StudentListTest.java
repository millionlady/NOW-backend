package com.now.backend.data;

import com.now.backend.models.OpportunityDto;
import com.now.backend.models.StudentListDto;
import com.now.backend.models.entities.Opportunity;
import com.now.backend.models.entities.Student;

public class StudentListTest {
    private static Long id1 = 1L;
    private static String student1 = "John Doe";
    private static String joinedOn1 = "02.04.2023";
    private static String email1 = "johndoe@email.com";
    private static String rate1 = "80%";
    private static Integer completed1 = 78;
    private static Integer points1 = 65;

    public static Student student() {
        Student student = new Student();
        student.setId(id1);
        student.setStudent(student1);
        student.setJoinedOn(joinedOn1);
        student.setEmail(email1);
        student.setRate(rate1);
        student.setCompleted(completed1);
        student.setPoints(points1);

        return student;
    }

    public static StudentListDto studentListDto() {
        return new StudentListDto(id1, student1, joinedOn1, email1, rate1, completed1, points1);
    }

    public static StudentListDto studentListDto2() {
        return new StudentListDto(3L, "John Doe1", "10.05.2023", "johndoe1@email.com", "60%", 56, 89);
    }
}
