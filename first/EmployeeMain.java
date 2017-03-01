package first;

import java.util.LinkedList;

public class EmployeeMain {
	public static LinkedList<Employee> list = new LinkedList<>();

	public static void main(String[] args) {

		Employee emp1 = new Employee(1, "1");
		Employee emp2 = new Employee(2, "2");
		Employee emp3 = new Employee(3, "3");
		Employee emp4 = new Employee(4, "4");

		for (int i = 0; i < 30; i++) {
			list.add(emp1);
			list.add(emp2);
			list.add(emp3);
			list.add(emp4);
		}

		check("4", 7); // 1번 사람의 7일뒤 당직

	}

	public static void check(String name, int day) {
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				index = i;
				break;
			}
		}
		System.out.println(list.get(index + day).getName() + "님이 당직 입니다.");
	}
}
