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
		v.add(new Word("love", "���"));
		v.add(new Word("animal", "����"));
		v.add(new Word("emotion", "����"));
		v.add(new Word("human", "�ΰ�"));
		v.add(new Word(" stock", "�ֽ�"));
		v.add(new Word("trade", "�ŷ�"));
		v.add(new Word("society", "��ȸ"));
		v.add(new Word("baby", "�Ʊ�"));
		v.add(new Word("honey", "����"));
		v.add(new Word("doll", "����"));
		v.add(new Word("bear", "��"));
		v.add(new Word("picture", "����"));
		v.add(new Word("painting", "�׸�"));
		v.add(new Word("fault", "����"));
		v.add(new Word("example", "����"));
		v.add(new Word("eye", "��"));
		v.add(new Word("statue", "������"));
	}

	private void wordQuiz() {
		System.out.println("����" + v.size() + "���� �ܾ ��� �ֽ��ϴ�. -1�� �Է��ϸ� �׽�Ʈ�� �����մϴ�.");
		ArrayList<Integer> temp = new ArrayList<>();
		int a = 0;
		int rand = 0;
		int quiz = (int)(Math.random() * v.size()); //���� �ε��� ��ȣ
		int loc = (int)(Math.random() * 4); //���� ��ȣ
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
				System.out.println("����!!");
			else
				System.out.println("����!!");
			
//			v.remove(quiz);
			if(v.size() == 0) {
				System.out.println("����ϼ���");
			}
			
			quiz = (int)(Math.random() * v.size());
			loc = (int)(Math.random() * 4);
			cnt = 0;
			temp.clear();
		}
	}

	private void insertWords() {//�ܾ��߰�
		System.out.println("���� �ܾ �׸��� �Է��ϸ� �Է��� �����մϴ�.");
		while(true) {
			System.out.println("���� �ѱ� �Է� >> ");
			String English = sc.next();
			
			if(English.equals("�׸�"))
					break;
			
			String Korean = sc.next();
			v.add(new Word(English, Korean));
		}
		
	}

private void finish() {
		System.out.println("\""+name+"\"�� �����մϴ�");
		sc.close();		
}

	public void run() {
		System.out.println("**** ���� �ܾ� �׽�Ʈ ���α׷� \"" + name + "\"�Դϴ�. ****");
		while (true) {
			System.out.println("�ܾ� �׽�Ʈ : 1, �ܾ� ���� : 2, ���� : 3 >>> ");
		try {
			int menu = sc.nextInt();
			switch (menu) {
			case 1:wordQuiz();	break;
			case 2:insertWords();break;
			case 3:finish();return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
			}
		} catch (InputMismatchException e) {
			sc.next();
			System.out.println("���ڸ� �Է��ϼ���.");
		}
		System.out.println();
	}
}


	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		WordQuiz quiz = new WordQuiz("������ ����");
		quiz.run();
	}// main();

}
