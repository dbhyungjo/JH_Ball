package training4;

public class MineSweeperTest {

	public static void main(String[] args) {
		/* 실습 4 지뢰 찾기 프로그램 */
		int m = Integer.parseInt(args[0]); //게임 배열의 크기 5
		int n = Integer.parseInt(args[1]); //게임 배열의 크기 10
		double p = Double.parseDouble(args[2]);// 지뢰가 있을 확률
		
		boolean[][] bombs = new boolean[m+2][n+2];
		
		
		for (int i = 1; i <= m; i++)
			for(int j = 1; j <=n; j++) 
				bombs[i][j] = (Math.random() < p); 
		
		for (int i = 1; i <= m; i++) {
			for(int j = 1; j<=n; j++) {
				if(bombs[i][j]) //참이면 지뢰
					System.out.print("* "); //지뢰가 있음
				else //참이 아니면 노지
					System.out.print("- "); //지뢰가 없음
			}
		System.out.println();
		}
		
		System.out.println();
		
		//인접한 지뢰 수 세기 지뢰는 *, 
		//지뢰를 숨기지 않은 원소는 이웃한 지뢰 개수 출력
		int bombsCount = 0; //인접한 지뢰 카운트 계산
		
		for (int i = 1; i <= m; i++) {
			for(int j = 1; j<=n; j++) {
				if(bombs[i][j]) //참이면 지뢰
					System.out.print("* "); //지뢰가 있음
				else {
					bombsCount = 0;// 카운트 초기화
					
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
					
					System.out.printf("%d ", bombsCount); //지뢰 개수 출력
				}
			}
			System.out.println();
		}
		//지뢰는 *, 지뢰를 숨기지 않은 원소를 이웃한 지뢰 개수 출력
	}
	
}


