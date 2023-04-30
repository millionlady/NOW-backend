package com.now.backend.repositories;

import com.now.backend.models.entities.Onboarding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OnboardingRepository extends JpaRepository<Onboarding, Integer> {
  /*  List<Onboarding> findAllById(Integer id);
    List<Onboarding> findAllByIdIn(List<Integer> id);*/
}
