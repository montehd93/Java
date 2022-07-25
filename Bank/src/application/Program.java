package application;

import java.util.Locale;
import java.util.Scanner;

import utils.Account;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account acc;
		System.out.println("Voc� deseja cadastrar uma conta em nosso banco?");
		System.out.print("O mesmo ir� ter deposito inicial?(S/N)");
		char entrada = sc.next().charAt(0);
		sc.nextLine();
		System.out.println("Por favor insira seu nome: ");
		String nome = sc.nextLine();
		System.out.println("Informe o n�mero da conta:");
		int numeroConta = sc.nextInt();
		double money = 0;
		if (entrada == 'S' || entrada == 's') {
			System.out.println("Informe o valor do dep�sito");
			money = sc.nextDouble();
			acc = new Account(nome, numeroConta, money);
		} else {
			acc = new Account(nome, numeroConta);
		}
		System.out.println("Conta criada: " + acc);

		boolean fim = false;
		while (!fim) {
			System.out.print("Deseja realizar um dep�sito ou retirada(D/R)? ");
			entrada = sc.next().charAt(0);
			if (entrada == 'D' || entrada == 'd') {
				sc.nextLine();
				System.out.println("Insira o valor a depositar");
				money = sc.nextDouble();
				Account.depositMoney(money);
			} else if (entrada == 'R' || entrada == 'r') {
				sc.nextLine();
				System.out.println("Insira o valor a retirar");
				money = sc.nextDouble();
				Account.withdrawMoney(money);
			} else {
				System.out.println("Insira os caracteres corr�tos informados!");
			}
			System.out.println("Conta atualizada: " + acc);
			System.out.println("Deseja realizar mais transa��es?(S/N) ");
			entrada = sc.next().charAt(0);
			sc.nextLine();
			if (entrada == 'n' || entrada == 'N') {
				fim = true;
			}
		}
		sc.close();
	}
}
