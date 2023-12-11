package ru.kfu.kafkaWebSite.controller;

// SurveyController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kfu.kafkaWebSite.dto.survey.SurveyResponseDto;
import ru.kfu.kafkaWebSite.repository.survey.SurveyResponseRepository;
import ru.kfu.kafkaWebSite.model.survey.SurveyResponse;

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

    @GetMapping("/survey")
    public String surveyForm(Model model) {
        model.addAttribute("surveyResponse", new SurveyResponseDto());
        return "survey";
    }

    @PostMapping("/submitSurvey")
    public String submitSurvey(@ModelAttribute SurveyResponseDto surveyResponseDto) {
        // Save survey response to the database
        SurveyResponse entity = new SurveyResponse();
        entity.setRespondentName(surveyResponseDto.getRespondentName());
        entity.setSurveyQuestion(surveyResponseDto.getSurveyQuestion());
        entity.setAnswer(surveyResponseDto.getAnswer());
        surveyResponseRepository.save(entity);

        // Publish survey response to Kafka topic
        kafkaTemplate.send("surveyResponses", surveyResponseDto);

        return "redirect:/survey";
    }
}

