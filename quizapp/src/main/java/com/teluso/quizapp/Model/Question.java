package com.teluso.quizapp.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String difficultyLevel;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String questionTitle;
    private String rightAnswer;
}
