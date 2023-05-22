package com.service.spring.controller;

import com.service.spring.domain.CompanyVO;
import com.service.spring.service.CompanyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Integer> registerCompany(@RequestBody CompanyVO vo) {
        try {
            int result = companyService.registerCompany(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateCompany(@RequestBody CompanyVO vo) {
        try {
            int result = companyService.updateCompany(vo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Integer> deleteCompany(@PathVariable int companyId) {
        try {
            int result = companyService.deleteCompany(companyId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/category/{category2Id}")
    public ResponseEntity<List<CompanyVO>> getCompaniesByCategory(@PathVariable int category2Id) {
        try {
            List<CompanyVO> companies = companyService.getCompanyNameByCategory(category2Id);
            if (!companies.isEmpty()) {
                return ResponseEntity.ok(companies);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(companies);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}