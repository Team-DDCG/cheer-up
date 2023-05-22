package com.service.spring.controller;

import com.service.spring.domain.Category1VO;
import com.service.spring.service.Category1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category1")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class Category1Controller {

    @Autowired
    private Category1Service category1Service; // 대분류
    
    
    @GetMapping("/{category1Id}")
    public ResponseEntity<Category1VO> getCategory1(@PathVariable int category1Id) {
        try {
            Category1VO category1 = category1Service.read(category1Id);
            if (category1 != null) {
                return ResponseEntity.ok(category1);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Category1VO>> getAllCategory1() {
    	try {
			List<Category1VO> category1List = category1Service.listAll();
			if (!category1List.isEmpty()) {
				return ResponseEntity.ok(category1List);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(category1List);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}