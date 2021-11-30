import java.util.Scanner;
import java.util.Random;

public class lotto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int Page;
		//int temp;
		int count = 0;
		
		System.out.println("********Lotto********");
		
		while(true){
			System.out.printf("������ �����Ͻðڽ��ϱ�?");
			Page = sc.nextInt();
			if(Page >5) {
				System.out.printf("5�� ���ϱ����� ���� �����մϴ�\n");
				continue;
			}
			break;
		}	
		int[][] Lotto_Table = new int[Page][6];
		
		
		
		for(int i = 0; i < Page; i++) { //�Է� �� ���� Ȯ��
			for(int j = 0; j < 6; j++) {

				System.out.printf("%d��° ���� %d��° ���� �Է� : ",i+1, j+1);
					Lotto_Table[i][j] = sc.nextInt();		
					
							if(Lotto_Table[i][j] > 45) {
								System.out.println("45������ ���ڸ� �Է����ּ���");
								j=-1;
								continue;
							}
						
							for(int k = 0; k < j; k++)
								if(Lotto_Table[i][j] == Lotto_Table[i][k]) {
									System.out.println("�ߺ��� �����Դϴ�.");
									j=-1;
									continue;
								}
						/*if (Lotto_Table[i][j] == z) {
							System.out.println("�ߺ��� ���ڰ� �ֽ��ϴ�. �ٽ� �Է��ϼ���");					
							i=0;
							break;			
					}*/
				}
			}
		

		
		System.out.println("********��÷ ��ȣ********");
		
		int[] num = new int[6];
		
		for(int i = 0; i < 6; i++){//��÷��ȣ ���
			num[i] = random.nextInt(44) + 1;
				for(int j = 0; j < i; j++)
					if(num[i] == num[j]) {
						i--;
					}
		}
		
		for(int i = 0; i < 6; i++)
			System.out.printf("%d   ", num[i]);
		
		System.out.println();
		System.out.println("********��÷ Ȯ��********");
		System.out.println("���� ��ȣ********");
		
		for(int i = 0; i < Page; i++) {
				count = 0;
				
					for(int j = 0; j < 6; j++) {
						System.out.printf("%d   ",Lotto_Table[i][j]);
							for(int k = 0; k <6; k++)
								if(Lotto_Table[i][j] == num[k])
									count += 1;
					}
					
					if(count == 6)
						System.out.println("1�� ��÷");
					if(count == 5)
						System.out.println("2�� ��÷");
					if(count == 4)
						System.out.println("3�� ��÷");
					if(count == 3)
						System.out.println("4�� ��÷");
					if(count == 2)
						System.out.println("5�� ��÷");
					if(count < 2)
						System.out.println("��÷");
			}
	}

}

