package day0526.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//������ �˰��ִ� �ڹٹ������ �����ؼ� ȣ���غ���
		System.out.println("������ �ڹ� ������� ������ ȣ��");
		MessageInter m1=new Message1();
		m1.sayHello("ȫ�浿");
		
		MessageInter m2=new Message2();
		m2.sayHello("��ȿ��");
		
		System.out.println("������������ ��ü ������ ȣ��");
		ApplicationContext context=
				new ClassPathXmlApplicationContext("day0526/appcontext1.xml");//��ġ�� ã�Ƽ� xml���� ����
		
		MessageInter m3=(Message1)context.getBean("mesBean1");
		m3.sayHello("���缮");
		//�ٸ����
		//��ȯŸ���� ������Ʈ�̱� ������ ����ȯ �ʿ�
		MessageInter m4=context.getBean("mesBean2",Message2.class);
		m4.sayHello("ĵ��");		
	}

}
