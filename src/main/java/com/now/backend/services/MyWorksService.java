package com.now.backend.services;

import com.now.backend.models.MyWorks;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service

public class MyWorksService {

    public List<MyWorks> getMyWorks() {
        List<MyWorks> myWorksList = new ArrayList<>();
        MyWorks studentWorks = new MyWorks("Desing1", "MOP", "03.01.2023",
                50, "APPROVED");
        myWorksList.add(studentWorks);
        MyWorks studentWorks2 = new MyWorks("Desing2", "MOP", "04.01.2023",
                60, "APPROVED");
        myWorksList.add(studentWorks2);
        MyWorks studentWorks3 = new MyWorks("Desing3", "MOP", "05.01.2023",
                55, "APPROVED");
        myWorksList.add(studentWorks3);

        return myWorksList;
    }
}
