package com.now.backend.services;

import com.now.backend.models.MyWorksDto;
import com.now.backend.models.entities.MyWorks;
import com.now.backend.repositories.MyWorksRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class MyWorksService {
    private final MyWorksRepository myWorksRepository;

    public MyWorksService(MyWorksRepository myWorksRepository) {
        this.myWorksRepository = myWorksRepository;
    }

    public List<MyWorksDto> getMyWorks() {
        List<MyWorksDto> MyWorksList = new ArrayList<>();
        List<MyWorks> works = myWorksRepository.findAll();
        for (MyWorks work : works) {
            MyWorksList.add(new MyWorksDto(
                    work.getOpportunity(),
                    work.getOrganization(),
                    work.getDateCreated(),
                    work.getPts(),
                    work.getStatus()));
        }

        return MyWorksList;
    }
}

