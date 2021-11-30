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
			System.out.printf("몇장을 구매하시겠습니까?");
			Page = sc.nextInt();
			if(Page >5) {
				System.out.printf("5장 이하까지만 구매 가능합니다\n");
				continue;
			}
			break;
		}	
		int[][] Lotto_Table = new int[Page][6];
		
		
		
		for(int i = 0; i < Page; i++) { //입력 후 숫자 확인
			for(int j = 0; j < 6; j++) {

				System.out.printf("%d번째 게임 %d번째 숫자 입력 : ",i+1, j+1);
					Lotto_Table[i][j] = sc.nextInt();		
					
							if(Lotto_Table[i][j] > 45) {
								System.out.println("45이하의 숫자만 입력해주세요");
								j=-1;
								continue;
							}
						
							for(int k = 0; k < j; k++)
								if(Lotto_Table[i][j] == Lotto_Table[i][k]) {
									System.out.println("중복된 숫자입니다.");
									j=-1;
									continue;
								}
						/*if (Lotto_Table[i][j] == z) {
							System.out.println("중복된 숫자가 있습니다. 다시 입력하세요");					
							i=0;
							break;			
					}*/
				}
			}
		

		
		System.out.println("********당첨 번호********");
		
		int[] num = new int[6];
		
		for(int i = 0; i < 6; i++){//당첨번호 출력
			num[i] = random.nextInt(44) + 1;
				for(int j = 0; j < i; j++)
					if(num[i] == num[j]) {
						i--;
					}
		}
		
		for(int i = 0; i < 6; i++)
			System.out.printf("%d   ", num[i]);
		
		System.out.println();
		System.out.println("********당첨 확인********");
		System.out.println("나의 번호********");
		
		for(int i = 0; i < Page; i++) {
				count = 0;
				
					for(int j = 0; j < 6; j++) {
						System.out.printf("%d   ",Lotto_Table[i][j]);
							for(int k = 0; k <6; k++)
								if(Lotto_Table[i][j] == num[k])
									count += 1;
					}
					
					if(count == 6)
						System.out.println("1등 당첨");
					if(count == 5)
						System.out.println("2등 당첨");
					if(count == 4)
						System.out.println("3등 당첨");
					if(count == 3)
						System.out.println("4등 당첨");
					if(count == 2)
						System.out.println("5등 당첨");
					if(count < 2)
						System.out.println("낙첨");
			}
	}

}

