package spring.study.bit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //��Ʈ�ѷ� ������̼��ؾ� �ڵ����� ������ ���

//���� ������ �ۿ� �ᵵ�� �׷��� ������ Ŭ���� �ȿ� �����ּ� ���ֱ�
public class TestController {
	
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	//�⺻������ ���� �����̳�
	//�� ����̱� ������ �޼��� ��� �⺻�� �����Ҽ��ִ�.
	//������ ��ġ�
	//@RequestMapping("/shop/detail")
	//public String hello1(Model model)
	//������Ʈ�� ������ ���� ���� �ʿ�
	//{	
		//Request�� mes ����
	//	model.addAttribute("mes", "������ ��ſ� �������Դϴ�!!");
	//	return "result1"; //     /WEB-INF/views/result1.jsp �� ������
	//}
	
	//���2
		@GetMapping("/shop/detail") //������5���� ����
		public ModelAndView hello2()
		{
			ModelAndView mview=new ModelAndView();
			//request �� ����
			mview.addObject("mes", "������ ������ �����???");
			//�������� ���ϸ� ����
			mview.setViewName("result1");
			return mview;
		}

	
}
