package com.service.spring.controller;

import com.service.spring.domain.QuestionVO;
import com.service.spring.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<Integer> registerQuestion(@RequestBody QuestionVO vo) {
        try {
            int result = questionService.registerQuestion(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateQuestion(@RequestBody QuestionVO vo) {
        try {
            int result = questionService.updateQuestion(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<Integer> deleteQuestion(@PathVariable int questionId) {
        try {
            int result = questionService.deleteQuestion(questionId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/{companyId}")
    public ResponseEntity<List<QuestionVO>> getQuestion(@PathVariable int companyId) {
        try {
            List<QuestionVO> questions = questionService.getQuestion(companyId);
            return ResponseEntity.ok(questions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}