package training4;

public class MineSweeperTest {

	public static void main(String[] args) {
		/* �ǽ� 4 ���� ã�� ���α׷� */
		int m = Integer.parseInt(args[0]); //���� �迭�� ũ�� 5
		int n = Integer.parseInt(args[1]); //���� �迭�� ũ�� 10
		double p = Double.parseDouble(args[2]);// ���ڰ� ���� Ȯ��
		
		boolean[][] bombs = new boolean[m+2][n+2];
		
		
		for (int i = 1; i <= m; i++)
			for(int j = 1; j <=n; j++) 
				bombs[i][j] = (Math.random() < p); 
		
		for (int i = 1; i <= m; i++) {
			for(int j = 1; j<=n; j++) {
				if(bombs[i][j]) //���̸� ����
					System.out.print("* "); //���ڰ� ����
				else //���� �ƴϸ� ����
					System.out.print("- "); //���ڰ� ����
			}
		System.out.println();
		}
		
		System.out.println();
		
		//������ ���� �� ���� ���ڴ� *, 
		//���ڸ� ������ ���� ���Ҵ� �̿��� ���� ���� ���
		int bombsCount = 0; //������ ���� ī��Ʈ ���
		
		for (int i = 1; i <= m; i++) {
			for(int j = 1; j<=n; j++) {
				if(bombs[i][j]) //���̸� ����
					System.out.print("* "); //���ڰ� ����
				else {
					bombsCount = 0;// ī��Ʈ �ʱ�ȭ
					
					if(bombs[i - 1][j - 1] == true)
						bombsCount++;
					if(bombs[i - 1][j] == true)
						bombsCount++;
					if(bombs[i - 1][j + 1] == true)
						bombsCount++;
					if(bombs[i][j +1] == true)
						bombsCount++;
					if(bombs[i][j-1] == true)
						bombsCount++;
					if(bombs[i + 1][j - 1] == true)
						bombsCount++;
					if(bombs[i + 1][j] == true)
						bombsCount++;
					if(bombs[i + 1][j + 1] == true)
						bombsCount++;
					
					System.out.printf("%d ", bombsCount); //���� ���� ���
				}
			}
			System.out.println();
		}
		//���ڴ� *, ���ڸ� ������ ���� ���Ҹ� �̿��� ���� ���� ���
	}
	
}


