package fOR;

/*
 * @���α׷� ���� 
 * #for�� 1�� ���� ���丮��   
 
   1 != 1
   2 ! =2
   3 ! =6 
   4 ! =24...10���� ���
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
