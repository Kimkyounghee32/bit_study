package fOR;

/* ���α׷� ���� : 
	���ǽ� + for��
	2.�� 
	xy+yx=121 �� ������ x,y ��� ���ϱ�
	��, x y �� 1-9 ������ ���ڸ�������
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
