package com.ximeen.certificationnlwexpert.modules.students.useCases;

import com.ximeen.certificationnlwexpert.modules.students.dto.VerifyHasCertificationDTO;
import com.ximeen.certificationnlwexpert.modules.students.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {
        @Autowired
        private CertificationStudentRepository certificationStudentRepository;
    public boolean execute(VerifyHasCertificationDTO dto){
        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        return !result.isEmpty();
    }
}
