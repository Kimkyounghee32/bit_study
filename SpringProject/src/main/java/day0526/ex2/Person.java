package day0526.ex2;

public class Person {
	String schoolName;
	MyInfo info;
	
	//info 정보는 생성자를 통해서 주입
	
	public Person(MyInfo info) {
		// TODO Auto-generated constructor stub
		this.info=info;
	}
	
	//학교명은 setter 주입
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	

	public void write()
	{
		System.out.println("** 학생 정보 출력 **");
		System.out.println("학교명 : "+schoolName);
		System.out.println("이름 :"+info.name);
		System.out.println("나이 :"+info.age);
		System.out.println("주 소 :"+info.addr);		
	}
}