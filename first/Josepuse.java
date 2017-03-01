package first;

import java.util.LinkedList;
import java.util.Scanner;

public class Josepuse {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<>();
		int point = 0, index;
		int personCount = scan.nextInt(); // 사람명수 
		int kill = Integer.parseInt(scan.nextLine().trim()); // 몇번째
		
		
		for (int i = 1; i <= personCount; i++) {
			list.add(i); // 인원 명수를 저장
		}
		index = kill - 1;
		
		for (int j = 0; j < personCount - 1; j++) { // 하나 남을때 까지 돌리기
			point += index;
			while (point >= list.size()) {
				point = point - list.size();
			}
			System.out.println(list.get(point));
			list.remove(point);
		}
	}
}
