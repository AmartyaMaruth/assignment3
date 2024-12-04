package com.example.survey.service;

import com.example.survey.model.Survey;
import com.example.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public Survey getSurveyById(Long id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        return survey.orElseThrow(() -> new RuntimeException("Survey not found"));
    }

    public Survey updateSurvey(Long id, Survey surveyDetails) {
        Survey survey = getSurveyById(id);
        survey.setFirstName(surveyDetails.getFirstName());
        survey.setLastName(surveyDetails.getLastName());
        survey.setAddress(surveyDetails.getAddress());
        survey.setCity(surveyDetails.getCity());
        survey.setState(surveyDetails.getState());
        survey.setZip(surveyDetails.getZip());
        survey.setPhone(surveyDetails.getPhone());
        survey.setEmail(surveyDetails.getEmail());
        survey.setSurveyDate(surveyDetails.getSurveyDate());
        survey.setCampusPreference(surveyDetails.getCampusPreference());
        survey.setInterestInUniversity(surveyDetails.getInterestInUniversity());
        survey.setRecommendLikelihood(surveyDetails.getRecommendLikelihood());
        return surveyRepository.save(survey);
    }

    public void deleteSurvey(Long id) {
        Survey survey = getSurveyById(id);
        surveyRepository.delete(survey);
    }
}
