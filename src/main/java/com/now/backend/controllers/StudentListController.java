package com.now.backend.controllers;

import com.now.backend.models.UserDto;
import com.now.backend.services.StudentListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/students")
@RestController
public class StudentListController {
   private final StudentListService studentListService;

   public StudentListController(StudentListService studentListService) {
       this.studentListService = studentListService;
   }
   @GetMapping(value = "/studentList")
   public List<UserDto> getStudentList() {

       return studentListService.getStudenList();
   }
}
