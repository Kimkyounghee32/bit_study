package com.spring.shop;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import shop.data.ShopDao;
import shop.data.ShopDto;
import upload.util.SpringFileWriter;

@Controller
public class ShopUpdateController {
	@Autowired
	ShopDao dao;
	
	@GetMapping("/updateform")
	public ModelAndView updateForm(@RequestParam String num)
	{
		ModelAndView mview=new ModelAndView();
		//넘버에 해당하는 dto를 받아서 넘에 넣어줌
		ShopDto dto=dao.getData(num);
		//dto라는 이름으로 저장하고
		mview.addObject("dto",dto);
		//updateform으로 이동
		mview.setViewName("shop/updateform");
		return mview;
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute ShopDto dto,
			HttpServletRequest request)
	{
		//이미지가 업로드될 저장 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
		
		//이미지를 업로드 안했을경우에는 photo 에 null 라고 저장을 하고
		//여러개인 경우는 컴마로 연결해서 저장을 하자
		String photo="";
		//이미지를 한개도 안넣었을경우 확인해보니 첫 이미지명이 빈문자열이다
		String s=dto.getUpload().get(0).getOriginalFilename();
		if(s.equals(""))
			photo=null;
		else {
			SpringFileWriter sfw=new SpringFileWriter();
			for(MultipartFile file:dto.getUpload())
			{
				//폴더에 이미지를 저장하고 저장된 파일명 리턴
				String fname=sfw.writeFile(file, path);
				//file,path를 집어 넣은 fname을 photo에 집어넣고 컴마도 넣어줌
				photo+=fname+",";				
			}
			//마지막 컴마 제거
			photo=photo.substring(0,photo.length()-1);
		}
		
		//dto 에 photo 저장
		dto.setPhoto(photo);
		System.out.println("photo="+photo);
		//db 에 추가
		dao.updateShop(dto);
		
		return "redirect:content?num="+dto.getNum();
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String num)
	{
		dao.deleteShop(num);
		return "redirect:list";
	}

}
