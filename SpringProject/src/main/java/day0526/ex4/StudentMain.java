package day0526.ex4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentMain {
	
	public static void writeStudent(Student s)
	{
		System.out.println("**학생정보**");
		System.out.println("이름:"+s.getName());
		System.out.println("나이:"+s.getAge());
		System.out.println("취미");
		for(String h:s.getHobby())
			System.out.println("\t"+h);
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		//환경설정을 xml이 아닌 자바클래스에서 설정
		AnnotationConfigApplicationContext abs=
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student s1=(Student)abs.getBean("student1");
		writeStudent(s1);
		Student s2=(Student)abs.getBean("student2");
		writeStudent(s2);
		
	}

}
