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
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date bDate = sdf.parse(sc.next());
		Client c = new Client(name, email, bDate);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order o = new Order(new Date(), status, c);

		System.out.print("How many items to this order? ");
		Integer qtdOrder = sc.nextInt();

		for (int i = 1; i <= qtdOrder; i++) {
			System.out.println("Enter #" + i + " data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer productQtd = sc.nextInt();
			o.addItem(new OrderItem(productQtd, productPrice, new Product(productName, productPrice)));
		}
		System.out.println();
		System.out.println(o);

		sc.close();
	}

}
