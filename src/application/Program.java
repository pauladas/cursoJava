package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the full file path: ");
		String path = sc.next();
		System.out.print("Enter salary: ");
		Double salary = sc.nextDouble();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			List<Employee> list = new ArrayList<>();

			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			List<String> names = list.stream()
									.filter(p -> p.getSalary() > salary)
									.map(p -> p.getEmail())
									.sorted((x,y) -> x.toUpperCase().compareTo(y.toUpperCase()))
									.collect(Collectors.toList());
			
			System.out.println("Email of people whose salary is more than 2000.00");
			names.forEach(System.out::println);
			
			Double sum = list.stream()
							.filter(p -> p.getName().charAt(0) == 'M')
							.map(p -> p.getSalary())
							.reduce(0.0, (x,y) -> x + y);
			
			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));

		} catch (Exception e) {
			System.out.println("Error -> " + e);
		}

		sc.close();

	}

}
