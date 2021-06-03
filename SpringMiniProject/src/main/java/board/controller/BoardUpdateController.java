package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.BoardDao;
import spring.dto.BoardDto;
import upload.util.SpringFileWriter;

@Controller
public class BoardUpdateController {
	
	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/updateform")
	public ModelAndView updateForm(@RequestParam int num,
			@RequestParam String pageNum)
	{
		ModelAndView mview=new ModelAndView();
		BoardDto dto=dao.getData(num);
		
		mview.addObject("dto",dto);
		mview.addObject("pageNum",pageNum);
		mview.setViewName("/board/updateform");
		return mview;
	}
	
	
	@PostMapping("/board/update")
	//일단 dto가 먼저 읽어오고, 그 다음 따로 읽어야하는 페이지넘,
	//경로 구해야하니까 리퀘스트 넣어줌
	public String update(@ModelAttribute BoardDto dto, 
			@RequestParam String pageNum, HttpServletRequest request)
	{
		//이미지가 업로드될 폴더 구하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);
		
		//이미지를 업로드 안했을경우에는 upload 에 "no" 라고 저장을 하고
		//여러개인 경우는 컴마로 연결해서 저장을 하자
		String upload="";
		String f=dto.getPhoto().get(0).getOriginalFilename();
		if(f.equals(""))
			upload="null";
		else { //업로드 했을 경우
			SpringFileWriter sfw=new SpringFileWriter();
			for(MultipartFile file:dto.getPhoto())
			{
				//폴더에 이미지 저장하기(저장된 이미지명 반환)
				//= 폴더에 이미지를 저장하고 저장된 파일명 리턴
				String fileName=sfw.writeFile(file, path);
				//file,path를 집어 넣은 fname을 photo에 집어넣고 컴마도 넣어줌
				upload+=fileName+",";
				
			}
			//마지막 컴마제거
			upload=upload.substring(0,upload.length()-1);
			
			//dto에 업로드 파일명 저장
			dto.setUploadname(upload);
			//db에 insert
			dao.updateBoard(dto);	
			
		}
		return "redirect:content?num="+dto.getNum()+"&pageNum="+pageNum;
		//새글이면 1페이지로 가고 //답글일 경우 보던페이지로 이동
		//여기까지하면 목록도 나오고(결과확인 가능), 저장도 되어야함
	}
	
	
	@GetMapping("/board/delete")
	public String delete(@RequestParam int num, @RequestParam String pageNum)
	{
		dao.deleteBoard(num);
		return "redirect:list?pageNum="+pageNum;
	}
	
}
