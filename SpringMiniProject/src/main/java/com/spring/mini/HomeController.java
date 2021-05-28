package com.spring.mini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping({"/", "/home"})
	public String main() {
		
		//tiles layout ������ ������ ������
		return "/layout/main";
	}
	
	@GetMapping({"/login"})
	public String login() {
		
		return "/login/loginmain";
	}
	
	@GetMapping({"/member/list"})
	public String memberlist() {
		
		return "/member/memberlist";  //������/���ϸ� �̷��� ���ܵ�
	}
	
	@GetMapping({"/board/list"})
	public String boardlist() {
		
		return "/board/boardlist";  //������/���ϸ�
	}
	
}
