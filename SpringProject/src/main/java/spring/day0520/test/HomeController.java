package spring.day0520.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "views/home"; // /WEB-INF/views/home.jsp
	}
	
	@RequestMapping(value = "/shop/list", method = RequestMethod.GET)
	public String hello(Model model) //메서드명은 크게 상관없다. 자기 마음대로 준다
	{
		//request에 저장
		model.addAttribute("sangpum","블라우스");
		model.addAttribute("price","23000원");
		model.addAttribute("color","노랑색");
		
		return "shop/list"; //포워드파일
	}
	
	@RequestMapping(value = "/stu/list", method = RequestMethod.GET)
	public String hello2(Model model) //메서드명은 크게 상관없다. 자기 마음대로 준다
	{
		//request에 저장
		model.addAttribute("name","김경희");
		model.addAttribute("addr","경기도 남양주시");
		model.addAttribute("hp","010-2065-6493");
		
		return "shop/result"; //포워드파일
	}
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String hello3(Model model) //메서드명은 크게 상관없다. 자기 마음대로 준다
	{
		//request에 저장
		model.addAttribute("name","김경희");
		model.addAttribute("buseo","개발");
		model.addAttribute("pay","545,655,555");
		
		return "member/info"; //포워드파일
	}
}
