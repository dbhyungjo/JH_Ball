package hihi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Word {
	private String english;
	private String korean;

	public Word(String english, String korean) {
		this.english = english;
		this.korean = korean;
	}

	public String getEnglish() {
		return english;
	}

	public String getKorean() {
		return korean;
	}
	
	public String toString() {
		return english;
	}
}

public class WordQuiz {
	private String name;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Word> v;

	public WordQuiz(String name) {
		this.name = name;
		v = new ArrayList<Word>();
		v.add(new Word("love", "사랑"));
		v.add(new Word("animal", "동물"));
		v.add(new Word("emotion", "감정"));
		v.add(new Word("human", "인간"));
		v.add(new Word(" stock", "주식"));
		v.add(new Word("trade", "거래"));
		v.add(new Word("society", "사회"));
		v.add(new Word("baby", "아기"));
		v.add(new Word("honey", "애인"));
		v.add(new Word("doll", "인형"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("picture", "사진"));
		v.add(new Word("painting", "그림"));
		v.add(new Word("fault", "오류"));
		v.add(new Word("example", "보기"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("statue", "조각상"));
	}

	private void wordQuiz() {
		System.out.println("현재" + v.size() + "개의 단어가 들어 있습니다. -1을 입력하면 테스트를 종료합니다.");
		ArrayList<Integer> temp = new ArrayList<>();
		int a = 0;
		int rand = 0;
		int quiz = (int)(Math.random() * v.size()); //정답 인덱스 번호
		int loc = (int)(Math.random() * 4); //정답 번호
		int cnt = 0;
		int size = v.size();
		
		while (true) {
			System.out.println(v.get(quiz) + "?");
			while(cnt < 4){
				rand = (int)(Math.random() * v.size());
				if(loc == cnt) {
					System.out.print("("+(cnt+ 1)+")" + v.get(quiz).getKorean());
					temp.add(rand);
					cnt++;
				}
				else if(loc != rand) {
					if(temp.contains(rand)) {continue;}
					System.out.print("("+(cnt+1)+")" + v.get(rand).getKorean());
					temp.add(rand);
					cnt++;
				}else {
					continue;
				}
			}		
			a = sc.nextInt();
			
			if (a < 0)
				break;
			else if(a-1 == loc)
				System.out.println("정답!!");
			else
				System.out.println("오답!!");
			
//			v.remove(quiz);
			if(v.size() == 0) {
				System.out.println("대단하세요");
			}
			
			quiz = (int)(Math.random() * v.size());
			loc = (int)(Math.random() * 4);
			cnt = 0;
			temp.clear();
		}
	}

	private void insertWords() {//단어추가
		System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
		while(true) {
			System.out.println("영어 한글 입력 >> ");
			String English = sc.next();
			
			if(English.equals("그만"))
					break;
			
			String Korean = sc.next();
			v.add(new Word(English, Korean));
		}
		
	}

private void finish() {
		System.out.println("\""+name+"\"를 종료합니다");
		sc.close();		
}

	public void run() {
		System.out.println("**** 영어 단어 테스트 프로그램 \"" + name + "\"입니다. ****");
		while (true) {
			System.out.println("단어 테스트 : 1, 단어 삽입 : 2, 종료 : 3 >>> ");
		try {
			int menu = sc.nextInt();
			switch (menu) {
			case 1:wordQuiz();	break;
			case 2:insertWords();break;
			case 3:finish();return;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		} catch (InputMismatchException e) {
			sc.next();
			System.out.println("숫자를 입력하세요.");
		}
		System.out.println();
	}
}


	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		WordQuiz quiz = new WordQuiz("유조형 영어");
		quiz.run();
	}// main();

}
