package day0526.ex5;

import org.springframework.stereotype.Component;

@Component //�ڵ����� xml�� ����ϴµ� Ŭ�������� id�� �ȴ�(ù���ڴ� �ҹ��ڷ� �ٲ�)
//�� id�� car
public class Car {
	Tire tire;
	//tire ������ 
	
	//Ŭ������ ���ؼ� ����
	Car(Tire tire)
	{
		this.tire=tire; //��������� ���ؼ�
	}
	
	public void writeTire()
	{
		System.out.println("�� ���� �귣����� "+tire.getTireName()+"�Դϴ�");
	}
	
}
