package day0526.ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("shop") //���̵� shop���� ���� ����
public class ShopController {

	//dao �ڵ� ����
	
	@Autowired //������ dao�� �Ѱ��̹Ƿ� @Autowired, @Resource ��� ����
			   //�ƴϸ� �������̽��� ��ӹ޾Ƶ� �������
	ShopDao dao;
	
	public void process()
	{
		ShopDto dto1=new ShopDto();
		dto1.setSang("����");
		dto1.setSu(2);
		dto1.setDan(1000);
		
		//����Ÿ �߰� �� ���
		dao.insertShop(dto1);
		dao.writeShop();
		
		//��ǰ�� ���� �� ���
		dao.updateShop("���");
		dao.writeShop();
	}
}
