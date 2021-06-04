package shop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.Loader.Simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.shop.data.MysqlShopMapper;
import boot.shop.data.ShopDto;

@Controller
public class ShopListController {
	
	@Autowired
	MysqlShopMapper mapper;
	
	@GetMapping({"/", "/list"})
	public ModelAndView list()
	{
		//데이터와 뷰를 동시에 설정가능
		ModelAndView mview=new ModelAndView(); 
		//총갯수
		int totalCount=mapper.getTotalCount();
		mview.addObject("totalCount", totalCount); //뷰로 보낼 데이터값
		//목록 가져오기
		List<ShopDto> list=mapper.getAllDatas();
		mview.addObject("list", list);
		mview.setViewName("list"); //뷰의 이름
		return mview;
	}
	
	@GetMapping("/addform")
	public String form()
	{
		return "addform";
	}
	
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute ShopDto dto,
			HttpServletRequest request)
	{
		String path=request.getSession().getServletContext().getRealPath("/photo");
		System.out.println(path);
		//파일명 앞에 붙일 날짜 구하기
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		//같은 날짜에 업로드한거 저장되는 이미지명이 겹칠 수도 있으므로 이미지명 시분초까지 저장되도록함
		String fileName="photo"+sdf.format(new Date())+"_"+dto.getUpload().getOriginalFilename();
		//dto에 업로드될 파일명 저장
		dto.setPhoto(fileName);
		
		//업로드
		MultipartFile uploadFile=dto.getUpload();
		try {
			uploadFile.transferTo(new File(path+"\\"+fileName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		//db insert
		mapper.insertShop(dto);
		return "redirect:list";
	}
}
