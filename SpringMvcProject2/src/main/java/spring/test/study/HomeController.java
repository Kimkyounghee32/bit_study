package spring.test.study;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
		public String menu() {
		//jsp�� �����Ϸ��� �Ʊ�� ���������� �����Ѵ�
		 return "day0527/menu";
		}
	
	@GetMapping("/shop/{path}")
	public String pathEx(Model model,//���� �Ķ���ͷ� ����
			@PathVariable("path") String p) //p��� ������ �о�´�
	{
		String msg="";
		if(p.equals("addcart"))
			msg="��ٱ��Ͽ� ������ ��ǰ�� �߰��߾��!!";
		else if(p.equals("listcart"))
			msg="��ٱ��Ͽ� ��� ��ǰ�� ����߾��!!";
		else if(p.equals("delcart"))
			msg="��ٱ��Ͽ� ������ ��ǰ�� �����߾��!!";
		else
			msg="��ΰ� �߸��Ǿ����ϴ�!!";
			
		//�� ���� �޾��� ���� �𵨾�Ʈ����Ʈ ���
		model.addAttribute("msg", msg);
		return "day0527/cartresult";
	}
	
}
