package ru.kfu.kafkaWebSite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kfu.kafkaWebSite.dto.survey.ExampleSurveyDto;
import ru.kfu.kafkaWebSite.dto.survey.SurveyResponseDto;
import ru.kfu.kafkaWebSite.repository.survey.SurveyResponseRepository;

@Controller
public class SurveyController {

    private final KafkaTemplate<String, SurveyResponseDto> kafkaTemplate;
    private final SurveyResponseRepository surveyResponseRepository;

    @Autowired
    public SurveyController(
            KafkaTemplate<String, SurveyResponseDto> kafkaTemplate,
            SurveyResponseRepository surveyResponseRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.surveyResponseRepository = surveyResponseRepository;
    }

    @GetMapping("/pass-survey")
    public String testSurvey(Model model) {
        model.addAttribute("survey", ExampleSurveyDto.exampleSurveyDto);
        model.addAttribute("surveyResponseDto", new SurveyResponseDto());
        return "survey-passing";
    }

    @PostMapping("/end-survey")
    @ResponseBody
    public String endSurvey(@RequestBody SurveyResponseDto surveyResponseDto) {
        // Работа с дто
        return "success";
    }
}

