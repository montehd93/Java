package application;

import java.util.Locale;
import java.util.Scanner;

import utils.CurrencyConverter;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		CurrencyConverter currency = new CurrencyConverter();
		
		System.out.print("What is the dollar price? ");
		currency.value = sc.nextDouble();
		System.out.println();
		System.out.print("How many dollars will be bought? ");
		currency.quantity = sc.nextDouble();
		System.out.println();
		System.out.printf("Amount to be paid in reais = %.2f", currency.totalConverter());
		
		sc.close();
	}

}
