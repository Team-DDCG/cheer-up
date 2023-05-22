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

import com.service.spring.domain.CompanyFitVO;
import com.service.spring.service.CompanyFitService;

@RestController
@RequestMapping("/api/company-fit")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class CompanyFitController {
	 @Autowired
	    private CompanyFitService companyFitService;

	    @PostMapping("/")
	    public ResponseEntity<String> registerCompanyFit(@RequestBody CompanyFitVO companyFit) {
	        try {
	            int result = companyFitService.registerCompanyFit(companyFit);
	            if (result > 0) {
	                return ResponseEntity.ok("CompanyFit registered successfully.");
	            } else {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register CompanyFit.");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	        }
	    }

	    @DeleteMapping("/{fitId}")
	    public ResponseEntity<String> deleteCompanyFit(@PathVariable int fitId) {
	        try {
	            int result = companyFitService.deleteCompanyFit(fitId);
	            if (result > 0) {
	                return ResponseEntity.ok("CompanyFit deleted successfully.");
	            } else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CompanyFit not found.");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	        }
	    }

	    @PutMapping("/")
	    public ResponseEntity<String> updateCompanyFit(@RequestBody CompanyFitVO companyFit) {
	        try {
	            int result = companyFitService.updateCompanyFit(companyFit);
	            if (result > 0) {
	                return ResponseEntity.ok("CompanyFit updated successfully.");
	            } else {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update CompanyFit.");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<CompanyFitVO> getCompanyFit(@PathVariable int id) {
	        try {
	            CompanyFitVO companyFit = companyFitService.getCompanyFit(id);
	            if (companyFit != null) {
	                return ResponseEntity.ok(companyFit);
	            } else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }

}
