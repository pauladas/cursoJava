package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter contract data ");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date: ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		Double contractValue = sc.nextDouble();
		System.out.print("Enter the number of installments: ");
		Integer nInstallments = sc.nextInt();

		Contract contract = new Contract(number, date, contractValue);

		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, nInstallments);

		System.out.println("Installments:");
		for (Installment x : contract.getInstallments()) {
			System.out.println(x);
		}

		sc.close();

	}

}
