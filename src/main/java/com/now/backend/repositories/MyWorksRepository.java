package com.now.backend.repositories;

import com.now.backend.models.entities.MyWorks;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MyWorksRepository extends JpaRepository<MyWorks, Long> {
}
