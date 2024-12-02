package com.example.survey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Student Survey Application.
 */
@SpringBootApplication
public class SurveyApplication {

    /**
     * The main method to launch the Spring Boot application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Starts the Spring Boot application
        SpringApplication.run(SurveyApplication.class, args);
    }
}
