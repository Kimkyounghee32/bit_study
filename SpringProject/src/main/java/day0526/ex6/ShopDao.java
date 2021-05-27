package day0526.ex6;

import org.springframework.stereotype.Component;

@Component("sdao") 
//아이디를 직접 지정하지 않을 경우 shopdao가 아이디가 됨
//아이디를 직접 지정하는 방식 = ("") 로 명칭해주면 됨
public class ShopDao implements ShopDaoInter {
	
	//멤버변수 선언
	ShopDto dto;

	@Override
	public void insertShop(ShopDto dto) {
		// TODO Auto-generated method stub
		this.dto=dto;
		System.out.println("상품 추가!!");
	}

	@Override
	public void updateShop(String sang) {
		// TODO Auto-generated method stub
		dto.setSang(sang);//변경
		System.out.println(sang+" 상품 업데이트");
	}

	@Override
	public void writeShop() {
		// TODO Auto-generated method stub
		System.out.println("** 상품 출력 **");
		System.out.println("상품:"+dto.getSang());
		System.out.println("수량:"+dto.getSu());
		System.out.println("단가:"+dto.getDan());
	}

}

