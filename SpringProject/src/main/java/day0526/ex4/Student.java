package day0526.ex4;

import java.util.ArrayList;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Student {
	private String name;
	private ArrayList<String> hobby;
	private int age;
	
	
	//name�ϰ� age�� �����ڷ� ����
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	//hobby�� setter��
	//�ϴ� ��ü ���Ͱ��� �صѰԿ�
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<String> getHobby() {
		return hobby;
	}


	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
}
