package ru.kfu.kafkaWebSite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kfu.kafkaWebSite.dto.survey.SurveyDto;
import ru.kfu.kafkaWebSite.dto.survey.SurveyResponseDto;
import ru.kfu.kafkaWebSite.dto.survey.SurveyStatDto;
import ru.kfu.kafkaWebSite.security.details.UserDetailsImpl;
import ru.kfu.kafkaWebSite.service.SurveyService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Controller
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public String index(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        Optional.ofNullable(userDetails).ifPresent(ud -> model.addAttribute("user", ud.getUser()));
        return "index";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create-survey")
    public String createSurveyForm() {
        return "create-survey";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create-survey")
    public ResponseEntity<?> createSurvey(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                          @RequestBody SurveyDto surveyDto) {
        surveyService.createSurvey(surveyDto, userDetails.getUser());
        return ResponseEntity.ok("success");
    }

    @GetMapping("/surveys/{id}")
    public String passSurvey(@PathVariable(name = "id") Long surveyId, Model model) {
        try {
            SurveyDto surveyDto = surveyService.getSurveyDtoById(surveyId);
            model.addAttribute("survey", surveyDto);
            model.addAttribute("surveyResponseDto", new SurveyResponseDto());
            return "pass-survey";
        } catch (EntityNotFoundException e) {
            return "redirect:/";
        }
    }

    @PostMapping("/surveys/{id}")
    public ResponseEntity<?> endSurvey(@PathVariable(name = "id") Long surveyId,
                                       @RequestBody SurveyResponseDto surveyResponseDto) {
        System.out.println(surveyResponseDto);
        surveyService.saveSurveyResponse(surveyResponseDto);
        return ResponseEntity.ok("success");
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/surveys")
    public String browseSurveys(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        List<SurveyDto> surveys = surveyService.getSurveysByAuthorId(userDetails.getId());
        model.addAttribute("surveys", surveys);
        return "browse-surveys";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/surveys/{id}/stat")
    public String renderSurveyStat(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                   @PathVariable(name = "id") Long surveyId,
                                   Model model) {
        SurveyStatDto statDto = surveyService.getSurveyStatDto(surveyId, userDetails.getId());
        model.addAttribute("statDto", statDto);
        return "stat-survey";
    }
}

