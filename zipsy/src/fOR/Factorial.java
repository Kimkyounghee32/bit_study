package fOR;

/*
 * @프로그램 개요 
 * #for문 1번 문제 팩토리얼   
 
   1 != 1
   2 ! =2
   3 ! =6 
   4 ! =24...10까지 출력
   */

import java.math.BigInteger;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    for (int i = 0; i <= 10; i++)
	      System.out.format("%3d! = %d%n", i, factorial(i));
	  }
	  public static BigInteger factorial(int n) {
	    BigInteger fac = BigInteger.ONE;

	    for (int i = 1; i <= n; i++)
	      fac = fac.multiply(BigInteger.valueOf(i));

	    return fac;
	  }
		
	}
