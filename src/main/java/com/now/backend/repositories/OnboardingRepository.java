package com.now.backend.repositories;

import com.now.backend.models.entities.Onboarding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OnboardingRepository extends JpaRepository<Onboarding, Integer> {
    @Query("SELECT DISTINCT o.universityYear FROM Onboarding o")
    List<Integer> findDistinctUniversityYears();

    @Query("SELECT DISTINCT o.organization FROM Onboarding o")
    List<String> findDistinctOrganizations();
}
