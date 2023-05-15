package com.now.backend.repositories;

import com.now.backend.models.MyWorksDto;
import com.now.backend.models.entities.MyWorks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyWorksRepository extends JpaRepository<MyWorks, Long> {
     List<MyWorks> findAllByWorks (String work);
}
