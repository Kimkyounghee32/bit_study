package day0526.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class Main {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			//ShopController �� process �޼��� ȣ���ϱ�
			ApplicationContext context=
					new ClassPathXmlApplicationContext("day0526/appcontext6.xml");

		
		//���̵� �������༭ ���̵�� ���� �ȴ� => ("shop");
			ShopController shopCont=(ShopController)context.getBean("shop");
			shopCont.process();

	}
	
}
