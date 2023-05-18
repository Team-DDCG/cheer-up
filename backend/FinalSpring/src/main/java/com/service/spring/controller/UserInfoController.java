package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.domain.UserInfoVO;
import com.service.spring.service.UserInfoService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping("/register")
	public int registerUserInfo(HttpServletRequest request, @RequestBody UserInfoVO pvo) throws Exception {
		int result = userInfoService.registerUserInfo(pvo); 
	    
	    if (result > 0) {
	        return result; 
	    } else {
	        return 0; 
	    } 
		
	}

	@PostMapping("/login")
	public UserInfoVO login(HttpServletRequest request, @RequestBody UserInfoVO pvo) throws Exception {
		UserInfoVO rvo = userInfoService.login(pvo);
		
		if (rvo != null) {
			request.getSession().setAttribute("vo", rvo);
			System.out.println(rvo);
			return rvo;
//			return "login_result"; // 적절한 뷰 이름으로 수정 필요
		} else {
//			return "redirect:/index.jsp"; //
			System.out.println("안옴");
			return null;
		}
	}
	
	
}