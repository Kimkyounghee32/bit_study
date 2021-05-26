package day0526.ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("shop") //아이디를 shop으로 직접 지정
public class ShopController {

	//dao 자동 주입
	
	@Autowired //주입할 dao가 한개이므로 @Autowired, @Resource 모두 가능
			   //아니면 인터페이스로 상속받아도 상관없음
	ShopDao dao;
	
	public void process()
	{
		ShopDto dto1=new ShopDto();
		dto1.setSang("딸기");
		dto1.setSu(2);
		dto1.setDan(1000);
		
		//데이타 추가 후 출력
		dao.insertShop(dto1);
		dao.writeShop();
		
		//상품명 수정 후 출력
		dao.updateShop("사과");
		dao.writeShop();
	}
}
