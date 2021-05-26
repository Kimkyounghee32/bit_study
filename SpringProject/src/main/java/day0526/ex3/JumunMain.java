package day0526.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JumunMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Shop 은 color 는 생성자주입
		 * price 와 sangpum 은 setter 주입(값은 마음대로..)
		 * 
		 * Jumun 은 shop 과 cnt 모두 setter 주입한후
		 * 
		 * Jumun 클래스 생성후 showJumun 호출하기
		 * 
		 */
		ApplicationContext context=
				new ClassPathXmlApplicationContext("day0526/appcontext3.xml");
		
		Jumun j=(Jumun)context.getBean("j");
		j.showJumun();
		
	}

}
