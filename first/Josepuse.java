package first;

import java.util.LinkedList;
import java.util.Scanner;

public class Josepuse {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<>();
		int point = 0, index;
		int personCount = scan.nextInt(); // ������ 
		int kill = Integer.parseInt(scan.nextLine().trim()); // ���°
		
		
		for (int i = 1; i <= personCount; i++) {
			list.add(i); // �ο� ����� ����
		}
		index = kill - 1;
		
		for (int j = 0; j < personCount - 1; j++) { // �ϳ� ������ ���� ������
			point += index;
			while (point >= list.size()) {
				point = point - list.size();
			}
			System.out.println(list.get(point));
			list.remove(point);
		}
	}
}
