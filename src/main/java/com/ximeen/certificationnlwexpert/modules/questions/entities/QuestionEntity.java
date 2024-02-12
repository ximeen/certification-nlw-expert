package com.ximeen.certificationnlwexpert.modules.questions.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "questions")
public class QuestionEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 50)
    private String technology;
    private String description;
    @OneToMany @JoinColumn(name = "question_id")
    private List<AlternativeEntity> alternatives;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
