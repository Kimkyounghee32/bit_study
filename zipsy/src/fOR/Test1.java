package fOR;

import java.util.Scanner;

/*
for ( i=1; i <=100; i++) {
1.  1-100 ������ �Ҽ��� 
��� ����ϰ� ����� ������ ���϶�

�Ҽ�? 1�� �����ϰ� �ڱ��ڽŸ��� �����
     ������ �ִ¼�
(���� for��)
*/

public class Test1 {
	
	/* 1. ��ĳ�� �Է� ���� ��� ���ϱ�
	    public static void main(String[] args){
	        int num1 = 0;
	        int i;
	        Scanner sc = new Scanner(System.in);
	        System.out.print("�� �Է� : ");
	        num1 = sc.nextInt();
	        for(i=1; i<=num1; i++) {
	            if(num1%i==0) {		//Ȧ��
	                System.out.println(i);
	            }
	        }sc.close();
	    }
	}

*/

	
	//1~100������ �Ҽ� ���ϱ�
public static void main(String[] args){
	for (int i = 1; i <= 100; i++) {
		int count=0;
		
		for(int j=1; j<=i; j++) {
			if(i% j == 0) {
				count ++;
			}
		}
		if (count ==2) {
			System.out.println(i + "�� �Ҽ��Դϴ�.");
			}
		
		//���� �Ҽ� ���� ���ϱ�
		
		//System.out.println("total" + count + "��" );
		
		}
	}
}