package com.ximeen.certificationnlwexpert.modules.students.controllers;

import com.ximeen.certificationnlwexpert.modules.students.dto.VerifyHasCertificationDTO;
import com.ximeen.certificationnlwexpert.modules.students.useCases.VerifyIfHasCertificationUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody @Valid VerifyHasCertificationDTO verifyHasCertificationDTO){
        var result = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);
        if(result){
            return "Usuário já fez a prova!";
        }
        return "Usuario pode fazer a prova";
    }
}
