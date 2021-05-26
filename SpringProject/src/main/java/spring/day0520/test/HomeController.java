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
	public String hello(Model model) //�޼������ ũ�� �������. �ڱ� ������� �ش�
	{
		//request�� ����
		model.addAttribute("sangpum","���콺");
		model.addAttribute("price","23000��");
		model.addAttribute("color","�����");
		
		return "shop/list"; //����������
	}
	
	@RequestMapping(value = "/stu/list", method = RequestMethod.GET)
	public String hello2(Model model) //�޼������ ũ�� �������. �ڱ� ������� �ش�
	{
		//request�� ����
		model.addAttribute("name","�����");
		model.addAttribute("addr","��⵵ �����ֽ�");
		model.addAttribute("hp","010-2065-6493");
		
		return "shop/result"; //����������
	}
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String hello3(Model model) //�޼������ ũ�� �������. �ڱ� ������� �ش�
	{
		//request�� ����
		model.addAttribute("name","�����");
		model.addAttribute("buseo","����");
		model.addAttribute("pay","545,655,555");
		
		return "member/info"; //����������
	}
}
