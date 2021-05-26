package fOR;

import java.util.Scanner;

/*
for ( i=1; i <=100; i++) {
1.  1-100 사이의 소수를 
모두 출력하고 몇개인지 갯수를 구하라

소수? 1을 제외하고 자기자신만을 약수로
     가지고 있는수
(다중 for문)
*/

public class Test1 {
	
	/* 1. 스캐너 입력 값의 약수 구하기
	    public static void main(String[] args){
	        int num1 = 0;
	        int i;
	        Scanner sc = new Scanner(System.in);
	        System.out.print("수 입력 : ");
	        num1 = sc.nextInt();
	        for(i=1; i<=num1; i++) {
	            if(num1%i==0) {		//홀수
	                System.out.println(i);
	            }
	        }sc.close();
	    }
	}

*/

	
	//1~100까지의 소수 구하기
public static void main(String[] args){
	for (int i = 1; i <= 100; i++) {
		int count=0;
		
		for(int j=1; j<=i; j++) {
			if(i% j == 0) {
				count ++;
			}
		}
		if (count ==2) {
			System.out.println(i + "는 소수입니다.");
			}
		
		//구한 소수 갯수 구하기
		
		//System.out.println("total" + count + "개" );
		
		}
	}
}