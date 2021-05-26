package day0526.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//기존에 알고있던 자바방식으로 생성해서 호출해보자
		System.out.println("기존의 자바 방식으로 생성후 호출");
		MessageInter m1=new Message1();
		m1.sayHello("홍길동");
		
		MessageInter m2=new Message2();
		m2.sayHello("이효리");
		
		System.out.println("스프링에서의 객체 생성과 호출");
		ApplicationContext context=
				new ClassPathXmlApplicationContext("day0526/appcontext1.xml");//위치를 찾아서 xml파일 선언
		
		MessageInter m3=(Message1)context.getBean("mesBean1");
		m3.sayHello("유재석");
		//다른방법
		//반환타입이 오브젝트이기 때문에 형변환 필요
		MessageInter m4=context.getBean("mesBean2",Message2.class);
		m4.sayHello("캔디");		
	}

}
