package day0526.ex5;

import org.springframework.stereotype.Component;

@Component //자동으로 xml에 등록하는데 클래스명이 id가 된다(첫글자는 소문자로 바뀜)
//즉 아이디가 koreaTire 가 된다
//모든 컴포넌트는 상속받은 클래스에만 붙일 수 있음
public class KoreaTire implements Tire {
	
	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "한국 금호 타이어";
	}

}
