package ru.kfu.kafkaWebSite.controller;

// SurveyController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kfu.kafkaWebSite.model.SurveyResponse;
import ru.kfu.kafkaWebSite.repository.SurveyResponseRepository;
import ru.kfu.kafkaWebSite.repository.entity.SurveyResponseEntity;

@Controller
public class SurveyController {

    private final KafkaTemplate<String, SurveyResponse> kafkaTemplate;
    private final SurveyResponseRepository surveyResponseRepository;

    @Autowired
    public SurveyController(
            KafkaTemplate<String, SurveyResponse> kafkaTemplate,
            SurveyResponseRepository surveyResponseRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.surveyResponseRepository = surveyResponseRepository;
    }

    @GetMapping("/survey")
    public String surveyForm(Model model) {
        model.addAttribute("surveyResponse", new SurveyResponse());
        return "survey";
    }

    @PostMapping("/submitSurvey")
    public String submitSurvey(@ModelAttribute SurveyResponse surveyResponse) {
        // Save survey response to the database
        SurveyResponseEntity entity = new SurveyResponseEntity();
        entity.setRespondentName(surveyResponse.getRespondentName());
        entity.setSurveyQuestion(surveyResponse.getSurveyQuestion());
        entity.setAnswer(surveyResponse.getAnswer());
        surveyResponseRepository.save(entity);

        // Publish survey response to Kafka topic
        kafkaTemplate.send("surveyResponses", surveyResponse);

        return "redirect:/survey";
    }
}

