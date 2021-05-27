package day0526.ex4;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration //현재파일을 설정파일로 사용한다고 알려줌
@ImportResource("classpath:day0526/appcontext4.xml")

public class ApplicationConfig {
	
	@Bean //bean으로 설정 (메서드명을 id로 인식)
	public Student student1() 
	{
		//이름과 나이는 생성자 주입
		Student s=new Student("강호동",23);
		
		//취미는 setter 주입
		ArrayList<String> hobby=new ArrayList<String>();
		hobby.add("낚시");
		hobby.add("여행");
		hobby.add("드라이브");
		
		s.setHobby(hobby);
		return s;
	}
	
	@Bean //bean으로 설정 (메서드명을 id로 인식)
	public Student student2() 
	{
		//이름과 나이는 생성자 주입
		Student s=new Student("캔디",12);
		
		//취미는 setter 주입
		ArrayList<String> hobby=new ArrayList<String>();
		hobby.add("독서");
		hobby.add("공예");
		hobby.add("운동");
		s.setHobby(hobby);
		
		return s;
	}
	
}
