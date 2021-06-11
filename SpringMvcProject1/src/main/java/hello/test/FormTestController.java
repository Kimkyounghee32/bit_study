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
		return "form1"; //form1.jsp�� �������϶�
	}
	
	@GetMapping("/test/read")
	public ModelAndView read1(
	/*
	 * @RequestParam(value = "name") String name,
	 * 
	 * @RequestParam(value = "age") int age
	 */
	
		//���±��� name �� �д� �������� ���� �� ��� value�� ��������
		//�� ��쿡 �ʼ��Է��̹Ƿ� �Է� ���ϸ� ��������
		//@RequestParam String name,
		//@RequestParam int age
		
		//�Է��� ���ص� ������ �ȳ��� �Ϸ���
		//1. ����Ʈ�� ����
		@RequestParam (defaultValue = "lee") String name,
		@RequestParam (defaultValue =  "10") int age,
		//pageNum �� �ȳѾ�ö� 1�� �ʱⰪ ����
		@RequestParam (defaultValue = "1") String pageNum
			
		)
	
	{	
		ModelAndView mview=new ModelAndView();
		String data=name+"���� ���̴� "+age+"���Դϴ�";
		data+="<br>���� ��������ȣ�� "+pageNum+"������ �Դϴ�";
		mview.addObject("data",data);
		mview.setViewName("read1");
		return mview;
	}
}
