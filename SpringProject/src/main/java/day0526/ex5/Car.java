package day0526.ex5;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //�ڵ����� xml�� ����ϴµ� Ŭ�������� id�� �ȴ�(ù���ڴ� �ҹ��ڷ� �ٲ�) //�� id�� car
public class Car {
	
	//1.Autowired �� ������
	//Autowired ���Ե� ���� �Ѱ��� ���� ��� ����
	// @Autowired  //���� Ÿ���� �ڵ� ����
	
	//2. ���ҽ��� ������
	//@Resource(name = "koreaTire") // ��Ȯ�� �̸��� ���� ã�Ƽ� �����ϴ� ���
	
	@Resource(name="canadaTire")
	Tire tire;
	
	/*
	 * //Ŭ������ ���ؼ� ���� Car(Tire tire) { 
	 * this.tire=tire; //��������� ���ؼ� 
	 * }
	 */
	
	public void writeTire()
	{
		System.out.println("�� ���� �귣����� "+
				tire.getTireName()+"�Դϴ�");
	}
	
}
