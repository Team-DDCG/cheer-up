package com.service.spring.controller;

import com.service.spring.domain.UserLanguageVO;
import com.service.spring.service.UserLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-languages")
public class UserLanguageController {

    private final UserLanguageService userLanguageService;

    @Autowired
    public UserLanguageController(UserLanguageService userLanguageService) {
        this.userLanguageService = userLanguageService;
    }

    @PostMapping
    public ResponseEntity<Integer> registerUserLanguage(@RequestBody UserLanguageVO vo) {
        try {
            int result = userLanguageService.registerUserLanguage(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateUserLanguage(@RequestBody UserLanguageVO vo) {
        try {
            int result = userLanguageService.updateUserLanguage(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{languageId}")
    public ResponseEntity<Integer> deleteUserLanguage(@PathVariable int languageId) {
        try {
            int result = userLanguageService.deleteUserLanguage(languageId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserLanguageVO> getUserLanguage(@PathVariable int id) {
        try {
            UserLanguageVO result = userLanguageService.getUserLanguage(id);
            if (result != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}