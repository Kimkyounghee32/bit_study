package day0526.ex5;

import org.springframework.stereotype.Component;

@Component //�ڵ����� xml�� ����ϴµ� Ŭ�������� id�� �ȴ�(ù���ڴ� �ҹ��ڷ� �ٲ�)
//�� ���̵� koreaTire �� �ȴ�
//��� ������Ʈ�� ��ӹ��� Ŭ�������� ���� �� ����
public class KoreaTire implements Tire {
	
	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "�ѱ� ��ȣ Ÿ�̾�";
	}

}
