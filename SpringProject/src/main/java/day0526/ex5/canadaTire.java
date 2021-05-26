package day0526.ex5;

import org.springframework.stereotype.Component;

@Component //xml에 자동등록
public class canadaTire implements Tire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "캐나다 타이어";
	}

}
