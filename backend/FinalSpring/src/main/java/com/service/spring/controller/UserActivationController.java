package com.service.spring.controller;

import java.util.List;

import com.service.spring.domain.UserActivationVO;
import com.service.spring.service.UserActivationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activation")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserActivationController {
    private final UserActivationService userActivationService;

    @Autowired
    public UserActivationController(UserActivationService userActivationService) {
        this.userActivationService = userActivationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUserActivation(@RequestBody UserActivationVO userActivationVO) {
        int result = userActivationService.registerUserActivation(userActivationVO);
        if (result > 0) {
            return ResponseEntity.ok("User activation registered successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user activation.");
        }
    }

    @DeleteMapping("/delete/{activationId}")
    public ResponseEntity<String> deleteUserActivation(@PathVariable int activationId) {
        int result = userActivationService.deleteUserActivation(activationId);
        if (result > 0) {
            return ResponseEntity.ok("User activation deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User activation not found.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUserActivation(@RequestBody UserActivationVO userActivationVO) {
        int result = userActivationService.updateUserActivation(userActivationVO);
        if (result > 0) {
            return ResponseEntity.ok("User activation updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User activation not found.");
        }
    }

    @GetMapping("/{activationId}")
    public ResponseEntity<UserActivationVO> getActivationDetail(@PathVariable int activationId) {
        UserActivationVO activation = userActivationService.getActivationDetail(activationId);
        if (activation != null) {
            return ResponseEntity.ok(activation);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/all/{seekerId}")
    public ResponseEntity<List<UserActivationVO>> getAllActivationsById(@PathVariable int seekerId) {
        List<UserActivationVO> activations = userActivationService.getAllActivationById(seekerId);
        if (!activations.isEmpty()) {
            return ResponseEntity.ok(activations);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @GetMapping("/number/{seekerId}")
    public int getActivationNumber(@PathVariable int seekerId) {
        return userActivationService.getActivationNumber(seekerId);
    }
}