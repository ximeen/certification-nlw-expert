package com.ximeen.certificationnlwexpert.modules.students.repositories;

import com.ximeen.certificationnlwexpert.modules.students.entities.CertificationStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CertificationStudentRepository extends JpaRepository<CertificationStudentEntity, UUID> {
    @Query("SELECT c FROM certifications c INNER JOIN c.studentEntity std WHERE std.email = :email AND c.technology = :technology")
    List<CertificationStudentEntity> findByStudentEmailAndTechnology(String email, String technology);
}
