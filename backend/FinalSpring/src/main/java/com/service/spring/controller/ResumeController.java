package com.service.spring.controller;

import com.service.spring.DTO.ResumeCommentDTO;
import com.service.spring.DTO.ResumeDTO;
import com.service.spring.DTO.ResumeQnADTO;
import com.service.spring.domain.ResumeVO;
import com.service.spring.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
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
    
    @GetMapping("/get/{resumeId}")
    public ResponseEntity<ResumeDTO> getResumeWithCompanyInfoById(@PathVariable int resumeId) {
        ResumeDTO resume = resumeService.getResumeWithCompanyInfoById(resumeId);
        if (resume != null) {
            return ResponseEntity.ok(resume);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/qna/{companyId}")
    public ResponseEntity<List<ResumeQnADTO>> getQnAByCompanyId(@PathVariable int companyId) {
        List<ResumeQnADTO> qnaList = resumeService.getQnAByCompanyId(companyId);
        return ResponseEntity.ok(qnaList);
    }

    @GetMapping("/comment/{resumeId}")
    public ResponseEntity<List<ResumeCommentDTO>> getCommentByResume(@PathVariable int resumeId) {
        List<ResumeCommentDTO> commentList = resumeService.getCommentByResume(resumeId);
        return ResponseEntity.ok(commentList);
    }

}