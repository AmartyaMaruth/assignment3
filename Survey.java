package com.example.survey.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String MiddleName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date surveyDate;

    private String campusPreference;
    private String interestInUniversity;
    private String recommendLikelihood;

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
     public void setMiddleName(String MiddletName) {
        this.MiddleName = MiddleName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(Date surveyDate) {
        this.surveyDate = surveyDate;
    }

    public String getCampusPreference() {
        return campusPreference;
    }

    public void setCampusPreference(String campusPreference) {
        this.campusPreference = campusPreference;
    }

    public String getInterestInUniversity() {
        return interestInUniversity;
    }

    public void setInterestInUniversity(String interestInUniversity) {
        this.interestInUniversity = interestInUniversity;
    }

    public String getRecommendLikelihood() {
        return recommendLikelihood;
    }

    public void setRecommendLikelihood(String recommendLikelihood) {
        this.recommendLikelihood = recommendLikelihood;
    }
}
