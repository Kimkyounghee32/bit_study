package fOR;

	/*
	 * @프로그램 개요 
	 * #for문 1번 문제 팩토리얼   
	 
	   1 != 1
	   2 ! =2
	   3 ! =6 
	   4 ! =24...10까지 출력
	   */
			
		/*
	1. 안됨
			public static void main(String[] args) {

				Scanner scan = new Scanner(System.in);
				
					int x = 0;
					int fac = 1;
				
					System.out.println("정수를 입력하세요 :  ");
					x = scan.nextInt();
				
					for (int i=x; i <= 10; i++) {
						fac = fac * i;
					}
					System.out.println( x + "!은 " + fac);
			}

	2. 1부터 10까지의 팩토리얼 합을 구해버림
			public static void main(String[] args) {
				int temp = 1;
				
				for(int i = 1; i<=10; i++) {
					temp = temp * i;
				}
				
				System.out.println(temp);	
			}
		}
			*/
			
			/*
			public static int factorial(int n) {
				if (n==1) return 1;
				else return n * factorial(n-1);
				}
			
			public static void main(String[] args) {
				System.out.println(factorial(10));
			}
		}
		
		
	3.  //@프로그램 개요 : for문으로 1~10까지 각각의 팩토리얼 값 구하기
			// 팩토리얼 10까지는 나왔으나 값이 모두 0으로 표기됨

		public class EX1 {

		public static void main(String[] args) {
			int n = 1;
			int result = 0;
			int end = 10;
			
			for(int i=n; i<=end; i++) {
				result = factorial2(i);
						System.out.println(i + "!= " + result);
			}
		}

		public static int factorial1(int n) {
			int x = 1;
			
			for (int i = 1; i<=n; i++) {
				x = x * i;
			}
			
			return x;
		}

		public static int factorial2( int n ) { //재귀
			if(n <= 1) {
				return n;
			}else {
				return factorial2(n-1 * n);
				
			}
		}
	}

	4.
	public static void main(String[] args) {
			// TODO Auto-generated method stub

			Scanner scan = new Scanner(System.in);
			
				int n = scan.nextInt(); //입력받은 숫자를 저장할 변수
				int fac = n; //팩토리얼 계산 결과 저장 변수
				
				//계산 과정 출력
				for (int i=n; i >= 1; i--) {
					if(i == 1) {
						System.out.println(i + "! = " + i);
					}else {
						System.out.println(i + "! = " + i + " * " + (i-1) + "!");
					}
				}
				
				//n부터 n-1까지 전부 곱함(팩토리얼 계산)
					for(int i=n-1; i>=1; i--) {
						fac = fac * i;
				}
					
				System.out.println(fac);
		}
	}
		*/

		
		
