package com.now.backend.services;

import com.now.backend.models.MyWorksDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service

public class MyWorksService {

    public List<MyWorksDto> getMyWorks() {
        List<MyWorksDto> myWorksDtoList = new ArrayList<>();
        MyWorksDto studentWorks = new MyWorksDto("Desing1", "MOP", "03.01.2023",
                50, "APPROVED");
        myWorksDtoList.add(studentWorks);
        MyWorksDto studentWorks2 = new MyWorksDto("Desing2", "MOP", "04.01.2023",
                60, "APPROVED");
        myWorksDtoList.add(studentWorks2);
        MyWorksDto studentWorks3 = new MyWorksDto("Desing3", "MOP", "05.01.2023",
                55, "APPROVED");
        myWorksDtoList.add(studentWorks3);

        return myWorksDtoList;
    }
}
