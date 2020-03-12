package application;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Set<Integer> set = new HashSet<>();

		Integer loop = 3;

		while (loop > 0) {
			String course;
			if (loop == 3) {
				course = "A";
			} else if (loop == 2) {
				course = "B";
			} else {
				course = "C";
			}
			System.out.print("How many students for course " + course + "? ");
			Integer nStudents = sc.nextInt();

			while (nStudents > 0) {
				Integer n = sc.nextInt();
				set.add(n);
				nStudents--;
			}
			
			loop--;

		}

		System.out.println("Total students: " + set.size());

		sc.close();

	}

}
