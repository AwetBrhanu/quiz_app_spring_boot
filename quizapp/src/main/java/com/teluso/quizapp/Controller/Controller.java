package com.teluso.quizapp.Controller;

import com.teluso.quizapp.Model.Question;
import com.teluso.quizapp.Model.Response;
import com.teluso.quizapp.Service.QuestionService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Question")
public class Controller {

    @Autowired
  QuestionService questionService;

    @GetMapping("adminQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory (@PathVariable String category){

        return questionService.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @DeleteMapping(path = "{id}")
    public void deleteQuestion(@PathVariable("id") Integer id){
        questionService.deleteQuestion(id);
    }


}
