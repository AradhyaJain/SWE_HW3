// Developer: Aradhya Jain (G01462086)
// Developer: Gayatri Ramchandra Vaidya (G01460522)
// Developer: Sanath Kumar Parimi (G01442785)
// Developer: Saksham Nayyar (G01462522)


package com.example.backend_645.repository;

import com.example.backend_645.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    // Find surveys by email
    List<Survey> findByEmail(String email);

    // Find surveys by city
    List<Survey> findByCity(String city);

    // Find surveys by state
    List<Survey> findByState(String state);

    // Custom JPQL query to find surveys based on recommendation likelihood
    @Query("SELECT s FROM Survey s WHERE s.recommendationLikelihood = :likelihood")
    List<Survey> findByRecommendationLikelihood(String likelihood);

    // Custom query to search surveys by name (firstName or lastName)
    @Query("SELECT s FROM Survey s WHERE s.firstName LIKE %:name% OR s.lastName LIKE %:name%")
    List<Survey> findByNameContaining(String name);
}
