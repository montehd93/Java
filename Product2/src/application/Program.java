package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Product #"+ i + " data:");
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			if(type == 'c' || type == 'C' ) {
				list.add(new Product(name, price));
			}else if(type == 'u' || type == 'U' ) {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String date = sc.next();
				list.add(new UsedProduct(name, price, sdf.parse(date)));
			}else if(type == 'i' || type == 'I' ) {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}else {
				System.out.println("Wrong Letter, only c,u or i");
			}	
		}
		System.out.println("PRICE TAGS:");
		
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		sc.close(); 
	}

}
