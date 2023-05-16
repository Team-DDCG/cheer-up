package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/test1")
    public UserInfoVO test1(){

		UserInfoVO user = new UserInfoVO();

		user.setUserName("lee");
		
        return user;

    }
	@GetMapping("/")
	public void test() {
		System.out.println("postman test");
	}
	
	@RequestMapping("/test")
	public String test2() {
		System.out.println("test");
		return "postman test";
	}
	
	@PostMapping("/login")
	public UserInfoVO login(HttpServletRequest request, @RequestBody UserInfoVO pvo) throws Exception {
		System.out.println("오나?");
		UserInfoVO rvo = userInfoService.login(pvo);
		
//		UserInfoVO user = new UserInfoVO();
//
//		user.setUserName("lee");
//		System.out.println(request);
//		return user;
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