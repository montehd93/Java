package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import utils.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		System.out.printf("How many employees will be registered? ");
		int quantity = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= quantity; i++) {
			System.out.printf("Employee #%s:%n", (i));
			System.out.printf("Id: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			System.out.printf("Name: ");
			String name = sc.nextLine();
			System.out.printf("Salary: ");
			Double salary = sc.nextDouble();
			sc.nextLine();
			list.add(new Employee(id, name, salary));
			System.out.println();
		}
		System.out.printf("Enter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();
		sc.nextLine();
		Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.printf("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.raiseSalary(percentage);
			System.out.println();
		}
		System.out.println("List of employees:");
		for (Employee x : list) {
			System.out.println(x.toString());
		}

		sc.close();
	}

}
