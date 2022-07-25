package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();		
		
		System.out.print("Enter the number of tax payers: ");
		int payers = sc.nextInt();
		
		for(int i=1; i<=payers; i++) {
			System.out.printf("Tax payers #%d data:",i);
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.next();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			if(type == 'c' || type == 'C') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}else if(type == 'i' || type == 'I') {
				System.out.print("Health expenditures: ");
				Double healtExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healtExpenditures));
			}
		}
		
		double total = 0.0;
		System.out.println();
		System.out.println("TAXES PAID: ");
		for (TaxPayer tp : list) {
			double tax = tp.tax();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
			total += tax;
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", total));
		
		
		sc.close();
	}

}
