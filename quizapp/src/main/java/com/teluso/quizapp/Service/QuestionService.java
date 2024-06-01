package com.teluso.quizapp.Service;
import com.teluso.quizapp.DAO.QuestionDAO;
import com.teluso.quizapp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;


    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDAO.findByCategory(category),HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDAO.save(question);
            return new ResponseEntity<>("Question added Successfully",HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Question added Successfully",HttpStatus.CREATED);
    }

    public void deleteQuestion(Integer id) {

        boolean exist = questionDAO.existsById(id);
        if (!exist) {
            throw new IllegalStateException("question with id "+id+" does not exist");
        }
            questionDAO.deleteById(id);
    }

}