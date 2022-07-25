package application;

import java.util.Locale;
import java.util.Scanner;

import model.exceptions.DomainException;
import model.utils.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdraw = sc.nextDouble();
			Account acc = new Account(number, holder, balance, withdraw);
			
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			acc.withdraw(amount);
			System.out.println(acc);
			
		}catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
