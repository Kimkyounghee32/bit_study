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
		//�ѹ��� �ش��ϴ� dto�� �޾Ƽ� �ѿ� �־���
		MemberDto dto=dao.getMember(num);
		//dto��� �̸����� �����ϰ�
		mview.addObject("dto",dto);
		//updateform���� �̵�
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
			//pass�� ��ġ�� ��� ������ ���������� �̵�
			dao.updateOfMember(dto);
			return "redirect:list";
		}else{
			//��ġ���� ���� ��� passfail.jsp�� ������
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