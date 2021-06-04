package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.data.MemberDao;
import member.data.MemberDto;

@Controller
public class Boardcontroller {
	
	@Autowired
	MemberDao dao;
	
	@GetMapping({"/", "/list"})
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("mes","스프링 부트 NCS");
		
		List<MemberDto> list=dao.getAllDatas();
		
		mview.addObject("list", list);
		mview.setViewName("list");
		return mview;
	}

	
	@GetMapping("/writeform") 
	public String form() { 
		return "writeform"; 
		}
	

	@PostMapping("/insert")
	public String insert(@ModelAttribute MemberDto dto)
	{
		//db에 데이타 추가
		dao.insertMember(dto); //insertMember에 dto를 보내고
		// 목록으로 이동
		return "redirect:list";
	}
	
	
	
	@GetMapping("/updateform") 
	public ModelAndView updateform(@RequestParam Long num) 
	
	{ 
		ModelAndView mview=new ModelAndView(); 
		MemberDto dto=dao.getData(num);
		mview.addObject("dto", dto); 
		mview.setViewName("updateform"); 
		return mview; 
	}
	
	
	
	 @PostMapping("/update") 
	 public String update(@ModelAttribute MemberDto dto) 
	 {
		 //db에 데이타 수정 
		 dao.updateMember(dto); 
		 //목록으로 이동 
		 return "redirect:list"; 
	}
	 
	
	@GetMapping("/delete")
	public String delete(@RequestParam Long num)
	{
		dao.deleteMember(num);
		return "redirect:list";
	}
}
