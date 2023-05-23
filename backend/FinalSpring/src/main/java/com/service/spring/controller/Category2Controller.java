package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.domain.Category2VO;
import com.service.spring.service.Category2Service;

@RestController
@RequestMapping("/api/category2")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class Category2Controller {
	 @Autowired
	    private Category2Service category2Service; // 소분류

	 @GetMapping("/{category2Id}")
	    public ResponseEntity<Category2VO> getCategory2(@PathVariable int category2Id) {
	        try {
	            Category2VO category2 = category2Service.read(category2Id);
	            if (category2 != null) {
	                return ResponseEntity.ok(category2);
	            } else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }

	    @GetMapping("/")
	    public ResponseEntity<List<Category2VO>> getAllCategory2() {
	        try {
	            List<Category2VO> category2List = category2Service.listAll();
	            if (!category2List.isEmpty()) {
	                return ResponseEntity.ok(category2List);
	            } else {
	                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }
}
