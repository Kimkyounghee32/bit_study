package day0526.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JumunMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Shop �� color �� ����������
		 * price �� sangpum �� setter ����(���� �������..)
		 * 
		 * Jumun �� shop �� cnt ��� setter ��������
		 * 
		 * Jumun Ŭ���� ������ showJumun ȣ���ϱ�
		 * 
		 */
		ApplicationContext context=
				new ClassPathXmlApplicationContext("day0526/appcontext3.xml");
		
		Jumun j=(Jumun)context.getBean("j");
		j.showJumun();
		
	}

}
