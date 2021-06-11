package hello.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormTestController {
	
	@GetMapping("/test/form")
	public String form1()
	{
		return "form1"; //form1.jsp로 포워드하라ㅏ
	}
	
	@GetMapping("/test/read")
	public ModelAndView read1(
	/*
	 * @RequestParam(value = "name") String name,
	 * 
	 * @RequestParam(value = "age") int age
	 */
	
		//폼태그의 name 과 읽는 변수명을 같게 할 경우 value는 생략가능
		//이 경우에 필수입력이므로 입력 안하면 에러난다
		//@RequestParam String name,
		//@RequestParam int age
		
		//입력을 안해도 에러가 안나게 하려면
		//1. 디폴트값 설정
		@RequestParam (defaultValue = "lee") String name,
		@RequestParam (defaultValue =  "10") int age,
		//pageNum 값 안넘어올땐 1로 초기값 지정
		@RequestParam (defaultValue = "1") String pageNum
			
		)
	
	{	
		ModelAndView mview=new ModelAndView();
		String data=name+"님의 나이는 "+age+"세입니다";
		data+="<br>현재 페이지번호는 "+pageNum+"페이지 입니다";
		mview.addObject("data",data);
		mview.setViewName("read1");
		return mview;
	}
}
