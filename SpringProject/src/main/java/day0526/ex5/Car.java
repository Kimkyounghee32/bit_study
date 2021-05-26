package day0526.ex5;

import org.springframework.stereotype.Component;

@Component //자동으로 xml에 등록하는데 클래스명이 id가 된다(첫글자는 소문자로 바뀜)
//즉 id는 car
public class Car {
	Tire tire;
	//tire 변수를 
	
	//클래스를 통해서 받음
	Car(Tire tire)
	{
		this.tire=tire; //멤버변수를 통해서
	}
	
	public void writeTire()
	{
		System.out.println("내 차의 브랜드명은 "+tire.getTireName()+"입니다");
	}
	
}
