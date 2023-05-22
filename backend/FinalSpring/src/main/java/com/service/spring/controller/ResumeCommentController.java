package com.service.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.domain.ResumeCommentVO;
import com.service.spring.service.ResumeCommentService;

@RestController
@RequestMapping("/api/resume-comment")
public class ResumeCommentController {
	  @Autowired
	    private ResumeCommentService resumeCommentService;

	    @PostMapping("/")
	    public ResponseEntity<String> registerResumeComment(@RequestBody ResumeCommentVO vo) {
	        try {
	            int result = resumeCommentService.registerResumeComment(vo);
	            if (result > 0) {
	                return ResponseEntity.status(HttpStatus.CREATED).body("Resume comment registered successfully");
	            } else {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to register resume comment");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register resume comment");
	        }
	    }

	    @PutMapping("/")
	    public ResponseEntity<String> updateResumeComment(@RequestBody ResumeCommentVO vo) {
	        try {
	            int result = resumeCommentService.updateResumeComment(vo);
	            if (result > 0) {
	                return ResponseEntity.ok("Resume comment updated successfully");
	            } else {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update resume comment");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update resume comment");
	        }
	    }

	    @DeleteMapping("/{commentId}")
	    public ResponseEntity<String> deleteResumeComment(@PathVariable int commentId) {
	        try {
	            int result = resumeCommentService.deleteResumeComment(commentId);
	            if (result > 0) {
	                return ResponseEntity.ok("Resume comment deleted successfully");
	            } else {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete resume comment");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete resume comment");
	        }
	    }

}
