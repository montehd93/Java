package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.printf("Enter department's name:");
		String department = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.printf("Name: ");
		String name = sc.nextLine();
		System.out.printf("Level: ");
		String level = sc.nextLine();
		System.out.printf("Base Salary: ");
		double salary = sc.nextDouble();
		sc.nextLine();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), salary, new Department(department));
		
		System.out.printf("How many contracts to this worker? ");
		int contracts = sc.nextInt();

		for (int i = 1; i <= contracts; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.printf("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			sc.nextLine();
			System.out.printf("Value per hour: ");
			double value = sc.nextDouble();
			System.out.printf("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, value, hours);
			worker.addContract(contract);
		}
		System.out.printf("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		sc.nextLine();
		System.out.println();

		System.out.println("Name: "+ worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for "+  monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		sc.close();
	}

}
