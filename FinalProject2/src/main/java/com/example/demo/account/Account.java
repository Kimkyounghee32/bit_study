package com.example.demo.account;


import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor //파라미터가 없는 기본 생성자 생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만들어 준다
@Data
@Alias("useraccount")
public class Account {
	private int num;
	private String email;
    private String username;
    private String hp;
    private String password;
}
