package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.printf("Insira o valor de linhas da matriz :");
		int m = sc.nextInt();
		System.out.printf("Insira o outro valor de colunas da matriz :");
		int n = sc.nextInt();

		int[][] matriz = new int[m][n];

		sc.nextLine();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}
		System.out.println("Digite o numero que deseja verificar na matriz");
		int verificar = sc.nextInt();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (verificar == matriz[i][j]) {
					System.out.println("Position " + i + "," + j + ":");
					if (j > 0) {
						System.out.println("Left: " + matriz[i][j - 1]);
					}
					if (j < matriz[i].length - 1) {
						System.out.println("Right: " + matriz[i][j + 1]);
					}
					if (i > 0) {
						System.out.println("Up: " + matriz[i - 1][j]);
					}
					if (i < matriz.length - 1) {
						System.out.println("Down: " + matriz[i + 1][j]);
					}
				}
			}
		}

		sc.close();
	}

}
