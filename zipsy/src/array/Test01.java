package array;

//@프로그램 개요 : 배열에서 특정값 찾기
 /* #조건식
배열 a에서 3을 출력하는 조건문
int[] a={1,2,3,4,5}; */

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			int[] arr={1,2,3,4,5};
			int key = 4,i;
			
			for (i=0; i<arr.length; i++)
				if(arr[i] == key)
					break;
			
			if (i<arr.length)
				System.out.println(i);
			else
				System.out.println("못찾음");
	
	}

}
