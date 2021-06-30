package com.surveypro.survey.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SurveyController {

    @GetMapping("/survey/write")
    public String writeSurvey(){
        return "surveyForm";
    }

    @GetMapping("/survey/visit")
    public String viewSurvey(){
        return "showcategory";
    }
}
