package day0526.ex2;

public class MyInfo {
	String name;
	int age;
	String addr;
	
	//이름,나이,주소등은 생성자를 통해 값을 주입받아야함
	public MyInfo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "MyInfo [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	
	
}
