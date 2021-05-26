package fOR;

/* 프로그램 개요 : 
	조건식 + for문
	2.번 
	xy+yx=121 이 나오는 x,y 모두 구하기
	단, x y 는 1-9 사이의 한자리숫자임
	*/

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

					for(int i =1; i<=9; i++) {
						 for( int j = 1; j<=i; j++) {
							 if((i*j)+(j*i)==121) {
								 System.out.println(i+","+j);
							 }
					}
			}
	}
}
