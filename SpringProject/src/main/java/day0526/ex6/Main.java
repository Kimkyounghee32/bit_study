package day0526.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class Main {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			//ShopController 의 process 메서드 호출하기
			ApplicationContext context=
					new ClassPathXmlApplicationContext("day0526/appcontext6.xml");

		
		//아이디를 지정해줘서 아이디는 샵이 된다 => ("shop");
			ShopController shopCont=(ShopController)context.getBean("shop");
			shopCont.process();

	}
	
}
