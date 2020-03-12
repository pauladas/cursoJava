package application;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		Set<Integer> c = new HashSet<>();
		Set<Integer> total = new HashSet<>();

		System.out.print("How many students for course A? ");
		Integer nStudents = sc.nextInt();
		for (int i = 0; i < nStudents; i++) {
			int num = sc.nextInt();
			a.add(num);
		}

		System.out.print("How many students for course B? ");
		nStudents = sc.nextInt();
		for (int i = 0; i < nStudents; i++) {
			int num = sc.nextInt();
			b.add(num);
		}

		System.out.print("How many students for course C? ");
		nStudents = sc.nextInt();
		for (int i = 0; i < nStudents; i++) {
			int num = sc.nextInt();
			c.add(num);
		}

		total.addAll(a);
		total.addAll(b);
		total.addAll(c);

		System.out.println("Total students: " + total.size());

		sc.close();

	}

}
