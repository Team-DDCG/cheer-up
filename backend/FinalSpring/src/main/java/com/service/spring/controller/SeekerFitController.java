package com.service.spring.controller;

import com.service.spring.domain.SeekerFitVO;
import com.service.spring.service.SeekerFitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seeker-fit")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class SeekerFitController {

    @Autowired
    private SeekerFitService seekerFitService;


    @PostMapping("/")
    public ResponseEntity<String> registerSeekerFit(@RequestBody SeekerFitVO seekerFit) {
        try {
            int result = seekerFitService.registerSeekerFit(seekerFit);
            if (result > 0) {
                return ResponseEntity.ok("SeekerFit registered successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register SeekerFit.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{fitId}")
    public ResponseEntity<String> deleteSeekerFit(@PathVariable int fitId) {
        try {
            int result = seekerFitService.deleteSeekerFit(fitId);
            if (result > 0) {
                return ResponseEntity.ok("SeekerFit deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SeekerFit not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/")
    public ResponseEntity<String> updateSeekerFit(@RequestBody SeekerFitVO seekerFit) {
        try {
            int result = seekerFitService.updateSeekerFit(seekerFit);
            if (result > 0) {
                return ResponseEntity.ok("SeekerFit updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update SeekerFit.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeekerFitVO> getSeekerFit(@PathVariable int id) {
        try {
            SeekerFitVO seekerFit = seekerFitService.getSeekerFit(id);
            if (seekerFit != null) {
                return ResponseEntity.ok(seekerFit);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}