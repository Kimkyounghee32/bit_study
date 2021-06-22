package com.example.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j //로그 라이브러리 (로그: 정보를 제공하는 일련의 기록인 로그(log)를 생성하도록 시스템을 작성하는 활동)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	   @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		   //AuthenticationManagerBuilder 객체 오버 라이딩은 가상의 계정을 만들어 주는 설정
		   //password는 passwordEncoder()에 의해 인코딩 되고, 비밀번호는 간단하게 '1111' string으로 설정
	        String password = passwordEncoder().encode("1111");
	        
	        
	        //그 후 각각의 계정을 생성하고, 권한을 부여
	        auth.inMemoryAuthentication().withUser("user").password(password).roles("USER");
	        auth.inMemoryAuthentication().withUser("emp").password(password).roles("EMP");
	    }

	@Bean //Bean을 주입한 PasswordEncoder는 BCryptPasswordEncoder라는 스프링 시큐리티 자체 인코딩을 이용하여 암호화
	    // BCryptPasswordEncoder는 Spring Security에서 제공하는 비밀번호 암호화 객체입니다.
	    // Service에서 비밀번호를 암호화할 수 있도록 Bean으로 등록합니다.
	   public PasswordEncoder passwordEncoder() {
		   return new BCryptPasswordEncoder();
		
	}
	   
	   @Override
	   
	   //HttpSecurity 객체 오버 라이딩은 시큐리티 설정의 핵심 부분으로, 
	   //각각의 권한에. antMatchers("controller mapping url명"). permitAll()이나, hasRole("권한명")으로 연결
	   //.anyRequest(). authenticated()는 이것을 제외한 모든 url 연결에는 인증이 사용됨
	   //.and() 로 묶어주었고, .formLogin() 을 사용하여 스프링 시큐리티에서 제공하는 기본 form Login 형태를 이용하도록 해줌
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .authorizeRequests()
	                	.antMatchers("/", "/index").permitAll() //로그인없이도 접근할 수 있는 url
	                	.antMatchers("/user").hasRole("USER")
	                	.antMatchers("/emp").hasRole("emp")
	                	.antMatchers("/login").permitAll()
	                	//.anyRequest().authenticated()  //로그인페이지를 제외한 모든페이지는 반드시 로그인을해야보여진다
	                	.and()
	                .formLogin()
	        			.loginPage("/login")
	        			.permitAll()
	        			.and()
	        		.logout()
	        			.permitAll();
	    }


	
}
