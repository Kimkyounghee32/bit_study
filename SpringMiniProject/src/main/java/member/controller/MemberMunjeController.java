package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.MemberDao;
import spring.dto.MemberDto;

@Controller
public class MemberMunjeController {

		
	 @Autowired 
	MemberDao dao;
	
	@GetMapping("/member/updateform")
	public ModelAndView updateform(String num)
	{
		ModelAndView mview=new ModelAndView();
		//넘버에 해당하는 dto를 받아서 넘에 넣어줌
		MemberDto dto=dao.getMember(num);
		//dto라는 이름으로 저장하고
		mview.addObject("dto",dto);
		//updateform으로 이동
		mview.setViewName("/member/updateform");
		return mview;
	}
	
	@PostMapping("/member/update")
	public String passCheck(@RequestParam  String num,
			@RequestParam  String pass,@ModelAttribute MemberDto dto)
	{
		int n=dao.passCheck(num, pass);
		if(n==1)
		{
			//pass가 일치할 경우 수정후 멤버목록으로 이동
			dao.updateOfMember(dto);
			return "redirect:list";
		}else{
			//일치하지 않을 경우 passfail.jsp로 포워드
			return "/member/passfail"; 
		}
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String num, HttpSession session)
	{
		dao.deleteMember(num);
		return "redirect:list";
	}
}