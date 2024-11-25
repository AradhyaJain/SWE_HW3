package com.example.backend_645.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zip;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "survey_date")
    private LocalDate surveyDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "liked_most") // Maps to the database column
    private LikedMost likedMost;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "interest_source") // Maps to the database column
    private InterestSource interestSource;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "recommendation_likelihood") // Maps to the database column
    private RecommendationLikelihood recommendationLikelihood;

    // Default constructor (required by JPA)
    public Survey() {
    }

    // Parameterized constructor
    public Survey(String firstName, String lastName, String address, String city, String state,
                  String zip, String telephone, String email, LocalDate surveyDate,
                  LikedMost likedMost, InterestSource interestSource, RecommendationLikelihood recommendationLikelihood) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.telephone = telephone;
        this.email = email;
        this.surveyDate = surveyDate;
        this.likedMost = likedMost;
        this.interestSource = interestSource;
        this.recommendationLikelihood = recommendationLikelihood;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(LocalDate surveyDate) {
        this.surveyDate = surveyDate;
    }

    public LikedMost getLikedMost() {
        return likedMost;
    }

    public void setLikedMost(LikedMost likedMost) {
        this.likedMost = likedMost;
    }

    public InterestSource getInterestSource() {
        return interestSource;
    }

    public void setInterestSource(InterestSource interestSource) {
        this.interestSource = interestSource;
    }

    public RecommendationLikelihood getRecommendationLikelihood() {
        return recommendationLikelihood;
    }

    public void setRecommendationLikelihood(RecommendationLikelihood recommendationLikelihood) {
        this.recommendationLikelihood = recommendationLikelihood;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", surveyDate=" + surveyDate +
                ", likedMost=" + likedMost +
                ", interestSource=" + interestSource +
                ", recommendationLikelihood=" + recommendationLikelihood +
                '}';
    }

    public Object getTelephoneNumber() {
        return null;
    }

    public String getStreetAddress() {
        return "";
    }

    public void setTelephoneNumber(Object telephoneNumber) {
    }

    // Enums for dropdown options
    public enum LikedMost {
        STUDENTS, LOCATION, CAMPUS, ATMOSPHERE, DORM_ROOMS, SPORTS
    }

    public enum InterestSource {
        FRIENDS, TELEVISION, INTERNET, OTHER
    }

    public enum RecommendationLikelihood {
        VERY_LIKELY, LIKELY, UNLIKELY
    }
}
