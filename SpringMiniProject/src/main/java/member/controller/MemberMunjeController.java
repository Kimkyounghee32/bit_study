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
	public ModelAndView updateform(@RequestParam String num)
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
		//비번이 맞는지 체크
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
	
	@GetMapping("/member/delete")
	public String delete(@RequestParam String num, HttpSession session)
	{
		//로그인안하면 널값이니 널체크를 해줘야한다
		String loginId=(String)session.getAttribute("myid");
		//세션에 저장된 아이디가 널이거나 admin 이 아니면 adminfail 로 포워드
		//admin 일경우에만 삭제후 목록으로 이동
		if(loginId==null || !loginId.equals("admin"))
			return "/member/adminfail";
		else {
			dao.deleteMember(num);
			return "redirect:list";
		}
	}
}