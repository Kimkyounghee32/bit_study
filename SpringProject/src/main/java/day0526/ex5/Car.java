package day0526.ex5;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //자동으로 xml에 등록하는데 클래스명이 id가 된다(첫글자는 소문자로 바뀜) //즉 id는 car
public class Car {
	
	//1.Autowired 로 인젝션
	//Autowired 주입될 빈이 한개만 있을 경우 가능
	// @Autowired  //같은 타입이 자동 주입
	
	//2. 리소스로 인젝션
	//@Resource(name = "koreaTire") // 정확한 이름의 빈을 찾아서 주입하는 방식
	
	@Resource(name="canadaTire")
	Tire tire;
	
	/*
	 * //클래스를 통해서 받음 Car(Tire tire) { 
	 * this.tire=tire; //멤버변수를 통해서 
	 * }
	 */
	
	public void writeTire()
	{
		System.out.println("내 차의 브랜드명은 "+
				tire.getTireName()+"입니다");
	}
	
}
