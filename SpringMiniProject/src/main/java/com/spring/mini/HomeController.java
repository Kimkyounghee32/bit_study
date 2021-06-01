package com.spring.mini;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.MemberDao;
import spring.dto.MemberDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	MemberDao dao;
	
	@GetMapping({"/", "/home"})
	public String main() {
		
		//tiles layout ������ ������ ������
		return "/layout/main";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "/login/loginmain";
	}
	
	@PostMapping("/loginprocess")
	public String loginCheck(@RequestParam String id, 
			@RequestParam String pass,HttpSession session)
	{
		int n=dao.loginCheck(id, pass);
		if(n==1)
		{
			
			//��������(2��)
			session.setAttribute("loginok","yes");
			session.setAttribute("myid", id);
			
			//�������� �� ������������ �����̷�Ʈ
			return "redirect:home";
			
		}else {
			
			//loginfail.jsp�� ������
			return "/login/loginfail"; 
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		//���ǿ��� myid,loginok ���� �� �������� �̵�
		
		session.removeAttribute("loginok");
		session.removeAttribute("myid");
		
		
		return "redirect:home";
	}
	

	@GetMapping("/board/list")
	public String boardlist() {
		
		return "/board/boardlist";  //������/���ϸ�
	}
	
}
