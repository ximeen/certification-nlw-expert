package com.ximeen.certificationnlwexpert.modules.questions.controller;

import com.ximeen.certificationnlwexpert.modules.questions.dto.AlternativeResultDTO;
import com.ximeen.certificationnlwexpert.modules.questions.dto.QuestionResultDTO;
import com.ximeen.certificationnlwexpert.modules.questions.entities.AlternativeEntity;
import com.ximeen.certificationnlwexpert.modules.questions.entities.QuestionEntity;
import com.ximeen.certificationnlwexpert.modules.questions.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){
        var result = this.questionRepository.findByTechnology(technology);
        return result.stream().map(QuestionController::mapQuestionToDTO).collect(Collectors.toList());
    }

    static QuestionResultDTO mapQuestionToDTO(QuestionEntity question){
       var questionResultDTO = QuestionResultDTO.builder()
               .id(question.getId())
               .technology(question.getTechnology())
               .description(question.getDescription()).build();
       List<AlternativeResultDTO> alternativeResultDTOS = question
               .getAlternatives().stream().map(QuestionController::mapAlternativeDTO).toList();
       questionResultDTO.setAlternatives(alternativeResultDTOS);
       return questionResultDTO;
    }
    static AlternativeResultDTO mapAlternativeDTO(AlternativeEntity alternativeResultDTO){
        return AlternativeResultDTO.builder()
                .id(alternativeResultDTO.getId())
                .description(alternativeResultDTO.getDescription()).build();
    }
}
