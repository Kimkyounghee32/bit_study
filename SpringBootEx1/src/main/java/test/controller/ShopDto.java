package test.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Lombok 이 잘 설치 되었다면 아래의 어노테이션을 추가해보자
//@Setter
//@Getter
//@ToString

//위의 3가지 어노테이션은 @Data로 대체 가능
@Data
public class ShopDto {
	private String sang;
	private int su;
	private int dan;
}
