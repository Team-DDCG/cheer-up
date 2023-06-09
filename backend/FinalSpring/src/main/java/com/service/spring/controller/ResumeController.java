package com.service.spring.controller;

import com.service.spring.DTO.PositionDTO;
import com.service.spring.DTO.ResultDTO;
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
    
    @GetMapping("/{resumeId}")
    public ResponseEntity<?> getResume(@PathVariable int resumeId) {
        ResumeVO resume = resumeService.getResume(resumeId);
        if (resume != null) {
            return ResponseEntity.ok(resume);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resume not found.");
        }
    }
    
    @GetMapping("/all/{seekerId}")
    public ResponseEntity<List<ResumeDTO>> getAllResumeBySeekerId(@PathVariable int seekerId) {
        List<ResumeDTO> resumes = resumeService.getAllResumeBySeekerId(seekerId);
        if (!resumes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(resumes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PatchMapping("/{position}")
    public ResponseEntity<String> togglePostCheck(@PathVariable("position") String position) {
        int result = resumeService.togglePostCheck(position);
        if (result == 1) {
            return ResponseEntity.ok("Post check toggled successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resume not found." + " " + position);
        }
    }
    
    @GetMapping("/questions/{resumeId}")
    public ResponseEntity<List<ResumeVO>> getAllQuestionByResumeId(@PathVariable int resumeId) {
        List<ResumeVO> questions = resumeService.getAllQuestionByResumeId(resumeId);
        if (!questions.isEmpty()) {
            return new ResponseEntity<>(questions, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/resumes")
    public ResponseEntity<List<ResumeVO>> getAllResumeByPosition(@RequestBody PositionDTO dto) {
        // Assuming you have a service or repository class to fetch resumes based on position
        List<ResumeVO> resumes = resumeService.getAllResumeByPosition(dto);

        if (resumes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(resumes, HttpStatus.OK);
    }
    
    @GetMapping("/data/{position}")
    public ResponseEntity<List<ResultDTO>> getAllDataByPosition(@PathVariable String position) {
        List<ResultDTO> result = resumeService.getAllDataByPosition(position);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}