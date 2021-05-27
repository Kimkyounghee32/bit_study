package day0526.ex5;

import org.springframework.stereotype.Component;

@Component //xml 에 자동 등록
public class CanadaTire implements Tire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "캐나다 타이어";
	}

}

