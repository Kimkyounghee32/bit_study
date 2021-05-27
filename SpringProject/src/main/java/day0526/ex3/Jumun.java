package day0526.ex3;

public class Jumun {
	Shop shop;
	int cnt;

	public void setShop(Shop shop) {
		this.shop=shop;
	}
	
	public void setCnt(int cnt) {
		this.cnt=cnt;
	}
	
	public void showJumun()
	{
		System.out.println("**주문상품 확인**");
		System.out.println("상품명:"+shop.getSangpum());
		System.out.println("가격:"+shop.getPrice());
		System.out.println("색상:"+shop.getColor());
		System.out.println("주문수량:"+cnt);
	}
}
