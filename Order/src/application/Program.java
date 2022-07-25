package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthdate = sc.next();
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		Order order = new Order(date,OrderStatus.valueOf(status), new Client(name, email, sdf2.parse(birthdate)));
		System.out.print("How many items to this order? ");
		int toLoop = sc.nextInt();

		for (int i = 1; i <= toLoop; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String product = sc.next();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem item = new OrderItem(quantity, price, new Product(product,price));
			order.addItem(item);
		}
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}
