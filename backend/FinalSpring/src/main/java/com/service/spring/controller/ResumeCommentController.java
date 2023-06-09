package com.service.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.domain.ResumeCommentVO;
import com.service.spring.service.ResumeCommentService;

import java.util.List;

@RestController
@RequestMapping("/api/resume-comment")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
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
	    
	    @GetMapping("/{resumeId}")
	    public ResponseEntity<List<ResumeCommentVO>> getResumeComment(@PathVariable int resumeId) {
	        try {
	            List<ResumeCommentVO> resumeComment = resumeCommentService.getResumeComment(resumeId);
	            if (resumeComment != null) {
	                return ResponseEntity.ok(resumeComment);
	            } else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	    
	    @PutMapping("/comments/rate/{commentId}")
	    public ResponseEntity<Void> setRate(@PathVariable int commentId) {
	        try {
	            int result = resumeCommentService.setRate(commentId);
	            if (result == 1) {
	                return new ResponseEntity<>(HttpStatus.OK);
	            }
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}
