package array;

//@���α׷� ���� : �迭���� Ư���� ã��
 /* #���ǽ�
�迭 a���� 3�� ����ϴ� ���ǹ�
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
				System.out.println("��ã��");
	
	}

}
