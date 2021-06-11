package hello.test;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	//두가지 매핑주소가 같은 메서드 호출되게 하려면
	@GetMapping({"/info/my","/board/list"})
	
	public ModelAndView process1() 
	{
		
		ModelAndView mview=new ModelAndView();
		mview.addObject("name","강오동");
		mview.addObject("addr","제주도");
		mview.setViewName("result2");
		return mview;
	}
	
	//세션과 리퀘스트 동시에 값을 넣은 후 포워드해보자
	@GetMapping("/stu/info")
	private String process2(HttpSession session,Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("mes", "리퀘스트에 저장된 문자열");//리퀘스트에 저장
		session.setAttribute("myid", "angel"); //세션에 저장
		return "result3";//포워드 파일명
	}
	
	@GetMapping("/guest/form")
	private ModelAndView process3(HttpSession session,Model model) {
		
		ModelAndView mview2=new ModelAndView();
		mview2.addObject("name", "이영희");
		mview2.addObject("java", "98");
		mview2.addObject("spring", "99");
		mview2.setViewName("result4");
		session.setAttribute("birth", "960411"); //세션에 저장
		return mview2;
	}
}
