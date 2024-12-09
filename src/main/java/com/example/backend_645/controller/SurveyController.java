// Developer: Aradhya Jain (G01462086)
// Developer: Gayatri Ramchandra Vaidya (G01460522)
// Developer: Sanath Kumar Parimi (G01442785)
// Developer: Saksham Nayyar (G01462522)


package com.example.backend_645.controller;

import com.example.backend_645.model.Survey;
import com.example.backend_645.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8080")  // Allow requests from the Vue frontend running locally
@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    // Fetch all surveys
    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveys = surveyService.getAllSurveys();
        return ResponseEntity.ok(surveys); // Return 200 OK with the list of surveys
    }

    // Fetch a specific survey by ID
    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        Optional<Survey> survey = surveyService.getSurveyById(id);
        return survey.map(ResponseEntity::ok) // Return 200 OK if found
                .orElseGet(() -> ResponseEntity.notFound().build()); // Return 404 Not Found if not found
    }

    // Add a new survey
    @PostMapping("/post")
    public ResponseEntity<Survey> addSurvey(@RequestBody Survey survey) {
        Survey createdSurvey = surveyService.addSurvey(survey);
        return ResponseEntity.status(201).body(createdSurvey); // Return 201 Created with the created survey
    }

    // Update an existing survey
    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Long id, @RequestBody Survey surveyDetails) {
        Optional<Survey> updatedSurvey = surveyService.updateSurvey(id, surveyDetails);
        return updatedSurvey.map(ResponseEntity::ok) // Return 200 OK if updated
                .orElseGet(() -> ResponseEntity.notFound().build()); // Return 404 Not Found if not found
    }

    // Delete a survey
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSurvey(@PathVariable Long id) {
        boolean isDeleted = surveyService.deleteSurvey(id);
        if (isDeleted) {
            return new ResponseEntity<>("deleted", HttpStatus.OK); // Return 204 No Content if deleted
        } else {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND); // Return 404 Not Found if not found
        }
    }
}
