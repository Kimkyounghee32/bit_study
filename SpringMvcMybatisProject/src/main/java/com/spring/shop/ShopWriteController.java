package com.spring.shop;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import shop.data.ShopDao;
import shop.data.ShopDto;
import upload.util.SpringFileWriter;

@Controller
public class ShopWriteController {
	@Autowired//�ڵ�����
	ShopDao dao;
	
	@GetMapping({"/addform"})
	public String form(Model model)
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		model.addAttribute("day",sdf.format(date));
		return "shop/addform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute ShopDto dto,
			HttpServletRequest request)
	{
		//�̹����� ���ε�� ��� ���ϱ�
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
		//System.out.println("11"+dto.getUpload().get(0).getOriginalFilename());
		//System.out.println(path);
		
		//�̹����� ���ε� ��������쿡�� photo �� "no" ��� ������ �ϰ�
		//�������� ���� �ĸ��� �����ؼ� ������ ����
		String photo="";
		//System.out.println("11"+dto.getUpload().get(0).getOriginalFilename());
		//�̹����� �Ѱ��� �ȳ־������ Ȯ���غ��� ù �̹������� ���ڿ��̴�
		String s=dto.getUpload().get(0).getOriginalFilename();
		if(s.equals(""))
			photo="no";
		else {
			SpringFileWriter sfw=new SpringFileWriter();
			for(MultipartFile file:dto.getUpload())
			{
				//������ �̹����� �����ϰ� ����� ���ϸ� ����
				String fname=sfw.writeFile(file, path);
				//file,path�� ���� ���� fname�� photo�� ����ְ� �ĸ��� �־���
				photo+=fname+",";				
			}
			//������ �ĸ� ����
			photo=photo.substring(0,photo.length()-1);
		}
		
		//dto �� photo ����
		dto.setPhoto(photo);
		System.out.println("photo="+photo);
		//db �� �߰�
		dao.insertShop(dto);
		
		return "redirect:list";
	}
	
	

}