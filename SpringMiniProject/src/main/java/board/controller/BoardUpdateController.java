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
	//�ϴ� dto�� ���� �о����, �� ���� ���� �о���ϴ� ��������,
	//��� ���ؾ��ϴϱ� ������Ʈ �־���
	public String update(@ModelAttribute BoardDto dto, 
			@RequestParam String pageNum, HttpServletRequest request)
	{
		//�̹����� ���ε�� ���� ���ϱ�
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);
		
		//�̹����� ���ε� ��������쿡�� upload �� "no" ��� ������ �ϰ�
		//�������� ���� �ĸ��� �����ؼ� ������ ����
		String upload="";
		String f=dto.getPhoto().get(0).getOriginalFilename();
		if(f.equals(""))
			upload="null";
		else { //���ε� ���� ���
			SpringFileWriter sfw=new SpringFileWriter();
			for(MultipartFile file:dto.getPhoto())
			{
				//������ �̹��� �����ϱ�(����� �̹����� ��ȯ)
				//= ������ �̹����� �����ϰ� ����� ���ϸ� ����
				String fileName=sfw.writeFile(file, path);
				//file,path�� ���� ���� fname�� photo�� ����ְ� �ĸ��� �־���
				upload+=fileName+",";
				
			}
			//������ �ĸ�����
			upload=upload.substring(0,upload.length()-1);
			
			//dto�� ���ε� ���ϸ� ����
			dto.setUploadname(upload);
			//db�� insert
			dao.updateBoard(dto);	
			
		}
		return "redirect:content?num="+dto.getNum()+"&pageNum="+pageNum;
		//�����̸� 1�������� ���� //����� ��� ������������ �̵�
		//��������ϸ� ��ϵ� ������(���Ȯ�� ����), ���嵵 �Ǿ����
	}
	
	
	@GetMapping("/board/delete")
	public String delete(@RequestParam int num, @RequestParam String pageNum)
	{
		dao.deleteBoard(num);
		return "redirect:list?pageNum="+pageNum;
	}
	
}