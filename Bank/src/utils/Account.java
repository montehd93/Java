package utils;

public class Account {
	private String nome;
	private int contaNumero;
	private static double valueInAccount;
	private static double fee = 5.00;
	public Account(String nome, int contaNumero, double valueInAccount) {
		this.nome = nome;
		this.contaNumero = contaNumero;
		depositMoney(valueInAccount);
	}
	public Account(String nome, int contaNumero) {
		this.nome = nome;
		this.contaNumero = contaNumero;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getContaNumero() {
		return contaNumero;
	}
	public double getValueInAccount() {
		return valueInAccount;
	}
	
	public static double depositMoney(double deposit) {
		return valueInAccount += deposit;
	}
	public static double withdrawMoney(double withdraw) {
		return valueInAccount -= (withdraw + fee);
	}
	public String toString() {
		return getNome() + ", numero da conta " + getContaNumero() + ", com valor total de " + String.format("%.2f", getValueInAccount());
	}
}
 