package day0526.ex5;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TireMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		org.springframework.context.ApplicationContext context=
				new ClassPathXmlApplicationContext("day0526/appcontext5.xml");
		
		Car car=(Car)context.getBean("car");
		car.writeTire();

	}

}
