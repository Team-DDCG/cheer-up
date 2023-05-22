package com.service.spring.controller;

import com.service.spring.domain.ResumeCommentVO;
import com.service.spring.domain.ResumeVO;
import com.service.spring.service.ResumeCommentService;
import com.service.spring.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping("/")
    public ResponseEntity<String> registerResume(@RequestBody ResumeVO resume) {
        try {
            int result = resumeService.registerResume(resume);
            if (result > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Resume registered successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to register resume");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register resume");
        }
    }

    @DeleteMapping("/{resumeId}")
    public ResponseEntity<String> deleteResume(@PathVariable int resumeId) {
        try {
            int result = resumeService.deleteResume(resumeId);
            if (result > 0) {
                return ResponseEntity.ok("Resume deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete resume");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete resume");
        }
    }

    @PutMapping("/")
    public ResponseEntity<String> updateResume(@RequestBody ResumeVO resume) {
        try {
            int result = resumeService.updateResume(resume);
            if (result > 0) {
                return ResponseEntity.ok("Resume updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update resume");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update resume");
        }
    }

    @GetMapping("/{resumeId}")
    public ResponseEntity<ResumeVO> getResumeByPostCheck(@PathVariable int resumeId) {
        try {
            ResumeVO resume = resumeService.getResumeByPostCheck(resumeId);
            if (resume != null) {
                return ResponseEntity.ok(resume);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<ResumeVO>> getQnAByCompanyId(@PathVariable int companyId) {
        try {
            List<ResumeVO> resumes = resumeService.getQnAByCompanyId(companyId);
            if (!resumes.isEmpty()) {
                return ResponseEntity.ok(resumes);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{resumeId}/comments")
    public ResponseEntity<List<ResumeCommentVO>> getCommentByResume(@PathVariable int resumeId) {
        try {
            List<ResumeCommentVO> comments = resumeService.getCommentByResume(resumeId);
            if (!comments.isEmpty()) {
                return ResponseEntity.ok(comments);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}