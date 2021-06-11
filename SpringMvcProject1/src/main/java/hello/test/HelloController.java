package hello.test;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	//�ΰ��� �����ּҰ� ���� �޼��� ȣ��ǰ� �Ϸ���
	@GetMapping({"/info/my","/board/list"})
	
	public ModelAndView process1() 
	{
		
		ModelAndView mview=new ModelAndView();
		mview.addObject("name","������");
		mview.addObject("addr","���ֵ�");
		mview.setViewName("result2");
		return mview;
	}
	
	//���ǰ� ������Ʈ ���ÿ� ���� ���� �� �������غ���
	@GetMapping("/stu/info")
	private String process2(HttpSession session,Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("mes", "������Ʈ�� ����� ���ڿ�");//������Ʈ�� ����
		session.setAttribute("myid", "angel"); //���ǿ� ����
		return "result3";//������ ���ϸ�
	}
	
	@GetMapping("/guest/form")
	private ModelAndView process3(HttpSession session,Model model) {
		
		ModelAndView mview2=new ModelAndView();
		mview2.addObject("name", "�̿���");
		mview2.addObject("java", "98");
		mview2.addObject("spring", "99");
		mview2.setViewName("result4");
		session.setAttribute("birth", "960411"); //���ǿ� ����
		return mview2;
	}
}
