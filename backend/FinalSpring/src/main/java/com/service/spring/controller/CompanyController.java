package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.service.spring.DTO.CategoryDTO;
import com.service.spring.DTO.CompanyDataDTO;
import com.service.spring.domain.CompanyVO;
import com.service.spring.domain.UserSeekerVO;
import com.service.spring.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<String> registerCompany(@RequestBody CompanyVO companyVO) {
        try {
            int result = companyService.registerCompany(companyVO);
            if (result == 1) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Company registered successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to register company.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error.");
        }
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable int companyId, @RequestBody CompanyVO companyVO) {
        try {
            companyVO.setCompanyId(companyId);
            int result = companyService.updateCompany(companyVO);
            if (result == 1) {
                return ResponseEntity.status(HttpStatus.OK).body("Company updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error.");
        }
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable int companyId) {
        try {
            int result = companyService.deleteCompany(companyId);
            if (result == 1) {
                return ResponseEntity.status(HttpStatus.OK).body("Company deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error.");
        }
    }

    @GetMapping("/category2/{category2Id}")
    public ResponseEntity<List<CompanyVO>> getCompanyNameByCategory(@PathVariable int category2Id) {
        try {
            List<CompanyVO> companyList = companyService.getCompanyNameByCategory(category2Id);
            if (!companyList.isEmpty()) {
                return ResponseEntity.ok(companyList);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<CompanyVO>> findAllCompanyByName(@PathVariable String keyword) {
        try {
            List<CompanyVO> companyList = companyService.findAllCompanyByName(keyword);
            if (!companyList.isEmpty()) {
                return ResponseEntity.ok(companyList);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/position/{companyName}")
    public ResponseEntity<String[]> getCompanyPositionByName(@PathVariable String companyName) {
        try {
            List<CompanyDataDTO> positions = companyService.getCompanyPositionByName(companyName);
            
            List<String> result = new ArrayList<>();
            for(CompanyDataDTO c : positions) {
            	result.add(c.getPosition());
            }
            
            String[] resultArray = result.toArray(new String[0]);
            return ResponseEntity.ok(resultArray);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/{companyName}")
    public ResponseEntity<CompanyVO> getCompanyDataByName(@PathVariable String companyName) {
        try {
            CompanyVO companyData = companyService.getCompanyDataByName(companyName);
            return ResponseEntity.ok(companyData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PutMapping("/categories/{seekerId}")
    public ResponseEntity<String> saveCategories(@PathVariable int seekerId, @RequestBody CategoryDTO dto) {
        try {
        	dto.setSeekerId(seekerId);
            int result = companyService.saveCategories(dto);
            if (result == 1) {
                return ResponseEntity.ok("Categories saved successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save categories.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
