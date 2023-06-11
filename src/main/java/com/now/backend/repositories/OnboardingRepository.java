package com.now.backend.repositories;

import com.now.backend.models.entities.Onboarding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OnboardingRepository extends JpaRepository<Onboarding, Integer> {
    @Query("SELECT DISTINCT o.universityYear FROM Onboarding o")
    List<Integer> findDistinctUniversityYears();

    Optional<Onboarding> findOneByUserId(Long userId);

    @Query("SELECT DISTINCT o.universityName FROM Onboarding o")
    List<String> findDistinctOrganizations();
}
