package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the full path: ");
		String path = sc.next();

		Map<String, Integer> election = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");
				String name = fields[0];
				Integer votes = Integer.parseInt(fields[1]);

				if (election.containsKey(name)) {
					votes += election.get(name);
					election.remove(name);
					election.put(name, votes);
				} else {
					election.put(name, votes);
				}

				line = br.readLine();
			}

			for (String k : election.keySet()) {
				System.out.println(k + ": " + election.get(k));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		sc.close();

	}

}
