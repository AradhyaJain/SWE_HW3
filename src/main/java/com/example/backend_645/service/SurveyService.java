
// Developer: Aradhya Jain (G01462086)
// Developer: Gayatri Ramchandra Vaidya (G01460522)
// Developer: Sanath Kumar Parimi (G01442785)
// Developer: Saksham Nayyar (G01462522)

package com.example.backend_645.service;

import com.example.backend_645.model.Survey;
import com.example.backend_645.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    // Get all surveys
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    // Add a new survey
    public Survey addSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    // Delete a survey by ID
    public boolean deleteSurvey(Long id) {
        if (surveyRepository.existsById(id)) {
            surveyRepository.deleteById(id);
            return true;
        } else {
            return false; // Survey with the given ID does not exist
        }
    }

    // Get a survey by ID
    public Optional<Survey> getSurveyById(Long id) {
        return surveyRepository.findById(id);
    }

    // Update a survey by ID
    public Optional<Survey> updateSurvey(Long id, Survey surveyDetails) {
        return surveyRepository.findById(id).map(existingSurvey -> {
            existingSurvey.setFirstName(surveyDetails.getFirstName());
            existingSurvey.setLastName(surveyDetails.getLastName());
            // existingSurvey.setAddress(surveyDetails.getStreetAddress());
            existingSurvey.setAddress(surveyDetails.getAddress());
            existingSurvey.setCity(surveyDetails.getCity());
            existingSurvey.setState(surveyDetails.getState());
            existingSurvey.setZip(surveyDetails.getZip());
            existingSurvey.setTelephoneNumber(surveyDetails.getTelephoneNumber());
            existingSurvey.setEmail(surveyDetails.getEmail());
            existingSurvey.setSurveyDate(surveyDetails.getSurveyDate());
            existingSurvey.setLikedMost(surveyDetails.getLikedMost());
            existingSurvey.setInterestSource(surveyDetails.getInterestSource());
            existingSurvey.setRecommendationLikelihood(surveyDetails.getRecommendationLikelihood());
            return surveyRepository.save(existingSurvey);
        });
    }

    // Get surveys by email
    public List<Survey> getSurveysByEmail(String email) {
        return surveyRepository.findByEmail(email);
    }

    // Get surveys by city
    public List<Survey> getSurveysByCity(String city) {
        return surveyRepository.findByCity(city);
    }

    // Get surveys by state
    public List<Survey> getSurveysByState(String state) {
        return surveyRepository.findByState(state);
    }

    // Get surveys by recommendation likelihood
    public List<Survey> getSurveysByRecommendationLikelihood(String likelihood) {
        return surveyRepository.findByRecommendationLikelihood(likelihood);
    }
}
