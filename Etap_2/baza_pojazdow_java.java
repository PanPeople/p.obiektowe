import java.util.Scanner; // Import the Scanner class
import java.io.IOException;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.InputMismatchException;
import java.util.Vector;
import java.util.Collections;
import java.io.FileWriter; // Import the FileWriter class
// Import the IOException class to handle errors

public class baza_pojazdow_java {

	// sta³e zmienne
	static int ilosc_parametrow = 6;
	static int l1 = 5, l2 = 16, l3 = 16, l4 = 10, l5 = 12, l6 = 12, l7 = 24;
	static String[] nazwy_parametrow = { "marka", "model", "rocznik", "pojemnoœæ", "przebieg", "typ skrzyni biegów",
			"id" };

	// zmienne globalne
	static int ilosc_elementow = 0;

	public static void main(String[] args) {

		while (true) {

			String temp_value;

			Vector<pojazd> cars = new Vector<>();

			String temp_value_tab[] = { "0", "0", "0", "0.0", "0", "0" };

			ilosc_elementow = 0;

			int i = 0;
			try {
				File file_base = new File("baza.txt");
				Scanner myReader = new Scanner(file_base);
				while (myReader.hasNextLine()) {
					temp_value = myReader.nextLine();

					temp_value_tab[i] = temp_value;
					i++;

					if (i == 6) {
						pojazd temp = new pojazd(temp_value_tab[0], temp_value_tab[1],
								Integer.parseInt(temp_value_tab[2]), Float.parseFloat(temp_value_tab[3]),
								Integer.parseInt(temp_value_tab[4]), temp_value_tab[5]);

						cars.add(temp);
						i = 0;
						ilosc_elementow++;

					}
					// System.out.println(temp_value);
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			clearConsole();
			System.out.println("Katalog samochodów:");// z /n
			// System.out.print("Katalog samochodow:"); //bez /n
			System.out.println("_________________________");
			System.out.println("Menu:");
			System.out.println("1.Wyœwietlenie listy samochodów");
			System.out.println("2.Wprowadzenie danych nowego samochodu");
			System.out.println("3.Wyœwietlanie warunkowe");
			System.out.println("4.Wyœwietlanie pojedyncze");
			System.out.println("5.Sortowanie");
			System.out.println("6.Usuniêcie samochodu z katalogu");
			System.out.println("7.WYJŒCIE");

			// czynnosc = scanObj.nextLine(); // Read user input

			String czynnosc = System.console().readLine();

			// scanObj.close();

			clearConsole();
			switch (czynnosc) // switch, gdzie wybieramy ró¿ne funkcje naszego programu
			{
			case "1":// 1
			{
				showAll(cars);
				exit_o();
				break;
			}

			case "2":// 2
			{
				addCar(cars);
				exit_o();
				break;
			}

			case "3":// 2
			{
				search(cars);
				exit_o();
				break;
			}

			case "4":// 2
			{
				showOne(cars);
				// ta funkcja nie u¿ywa exit_o
				break;
			}

			case "5":// 2
			{
				sort(cars);
				exit_o();
				break;
			}

			case "6":// 2
			{
				deleteOne(cars);
				exit_o();
				break;
			}

			case "7":// 7
			{

				// scanObj.close();
				System.exit(0);

				break;
			}
			default: {

				break;
			}
			}

		}

	}

	public static void clearConsole() {
		// Clears Screen in java
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}
	}

	public static void header() {

		// cout.width(l1);
		System.out.print(nazwy_parametrow[6]);
		System.out.print(" | ");
		// cout.width(l2);
		System.out.print(nazwy_parametrow[0]);
		System.out.print(" | ");
		// cout.width(l3);
		System.out.print(nazwy_parametrow[1]);
		System.out.print(" | ");
		// cout.width(l4);
		System.out.print(nazwy_parametrow[2]);
		System.out.print(" | ");
		// cout.width(l5);
		System.out.print(nazwy_parametrow[3]);
		System.out.print(" | ");
		// cout.width(l6);
		System.out.print(nazwy_parametrow[4]);
		System.out.print(" | ");
//	cout.width(l7);
		System.out.println(nazwy_parametrow[5]);
		System.out.print(" | ");

		// pusty wiersz
		// cout.width(l1);
		System.out.print("");
		System.out.print(" | ");

//	cout.width(l2); 
		System.out.print("");
		System.out.print(" | ");
//	cout.width(l3);
		System.out.print("");
		System.out.print(" | ");
//	cout.width(l4);
		System.out.print("");
		System.out.print(" | ");
//	cout.width(l5);
		System.out.print("");
		System.out.print(" | ");
//	cout.width(l6);
		System.out.print("");
		System.out.print(" | ");
//	cout.width(l7); 
		System.out.print("");
		System.out.println(" | ");
	}

	public static void exit_o() {

		System.out.println("");
		// Scanner scanObj = new Scanner(System.in); // Create a Scanner object
		String czynnosc;

		do {
			System.out.println("Nacisnij \"p\" aby powrocic...");
			czynnosc = System.console().readLine();

		} while (!(czynnosc.equalsIgnoreCase("p")));

		clearConsole();
	}

	public static void showAll(Vector<pojazd> cars) {

		header();

		for (int i = 0; i < ilosc_elementow; i++) {
			System.out.print(i + " | ");
			cars.get(i).show();
		}

	}

	public static void addCar(Vector<pojazd> cars) {

		String v1 = "0", v2 = "0", v3 = "0", v4 = "0", v5 = "0", v6 = "0";

		int v0 = ilosc_elementow;

		Scanner scanObj = new Scanner(System.in); // Create a Scanner object

		System.out.println("Stworzysz element o indexie: " + v0);

		System.out.println("Podaj nowy: " + nazwy_parametrow[0]);
		v1 = scanObj.nextLine();

		System.out.println("Podaj nowy: " + nazwy_parametrow[1]);
		v2 = scanObj.nextLine();

		System.out.println("Podaj nowy: " + nazwy_parametrow[2]);
		v3 = scanObj.nextLine();

		System.out.println("Podaj nowy: " + nazwy_parametrow[3]);
		v4 = scanObj.nextLine();

		System.out.println("Podaj nowy: " + nazwy_parametrow[4]);
		v5 = scanObj.nextLine();

		System.out.println("Podaj nowy: " + nazwy_parametrow[5]);
		v6 = scanObj.nextLine();

		try {
			FileWriter myWriter = new FileWriter("baza.txt", true);

			myWriter.write(v1 + "\n");
			myWriter.write(v2 + "\n");
			myWriter.write(v3 + "\n");
			myWriter.write(v4 + "\n");
			myWriter.write(v5 + "\n");
			myWriter.write(v6 + "\n");

			myWriter.close();

			System.out.println("Pomyœlnie dodano element: ");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		header();

		// cout.width(l1);
		System.out.print(v0 + " | ");
		// cout.width(l2);
		System.out.print(v1 + " | ");
		// cout.width(l3);
		System.out.print(v2 + " | ");
		// cout.width(l4);
		System.out.print(v3 + " | ");
		// cout.width(l5);
		System.out.print(v4 + " | ");
		// cout.width(l6);
		System.out.print(v5 + " | ");
		// cout.width(l7);
		System.out.println(v6 + " | ");

	}

	public static void search(Vector<pojazd> cars) {

		System.out.println("Wyœwietlanie warunkowe: ");

		int v1 = 0, v3 = 0;
		String choose = "0";

		boolean valuePassed = true;

		String value_1[] = { "*", "*", "*" };
		float value_2_min = 0.0F, value_2_max = 0.0F;
		int value_3_min[] = { 0, 0, 0 }, value_3_max[] = { 0, 0, 0 };

		Scanner scanObj = new Scanner(System.in); // Create a Scanner object

		for (int i = 0; i < ilosc_parametrow; i++) {

			System.out.println(nazwy_parametrow[i]);

			if ((i == 0) || (i == 1) || (i == 5)) {// string

				System.out.println("0. obojetnie");
				System.out.println("1. konkretnie");

				choose = scanObj.nextLine();

				if (choose.equalsIgnoreCase("1")) {
					System.out.println("Podaj wartosc:");
					value_1[v1] = scanObj.nextLine();

				} else {
					value_1[v1] = "*";
				}

				v1++;

			} else if (i == 3) {// float
				System.out.println("0. obojetnie");
				System.out.println("1. konkretnie");
				System.out.println("2. przedzial");

				choose = scanObj.nextLine();

				if (choose.equalsIgnoreCase("1")) {
					System.out.println("Pamiêtaj jesteœmy w Polsce wiêc float piszemy z PRZECINKIEM");
					valuePassed = true;
					do {
						try {
							System.out.println("Podaj wartosc:");
							value_2_min = scanObj.nextFloat();
							valuePassed = true;

						} catch (InputMismatchException e) {
							// System.out.println("Nie poda³eœ dobrej wartoœci ");
							scanObj.next();
							valuePassed = false;
						}
					} while (!valuePassed);

					value_2_max = value_2_min;
				} else if (choose.equalsIgnoreCase("2")) {
					System.out.println("Pamiêtaj jesteœmy w Polsce wiêc float piszemy z PRZECINKIEM");

					valuePassed = true;
					do {
						try {
							System.out.println("Podaj wartosc min:");
							value_2_min = scanObj.nextFloat();
							valuePassed = true;

						} catch (InputMismatchException e) {
							// System.out.println("Nie poda³eœ dobrej wartoœci ");
							scanObj.next();
							valuePassed = false;
						}
					} while (!valuePassed);

					System.out.println("Pamiêtaj jesteœmy w Polsce wiêc float piszemy z PRZECINKIEM");

					valuePassed = true;
					do {
						try {
							System.out.println("Podaj wartosc max:");
							value_2_max = scanObj.nextFloat();
							valuePassed = true;

						} catch (InputMismatchException e) {
							// System.out.println("Nie poda³eœ dobrej wartoœci ");
							scanObj.next();
							valuePassed = false;
						}
					} while (!valuePassed);

				} else {
					value_2_min = 0.0F;
					value_2_max = 100.0F;
				}

			} else if ((i == 2) || (i == 4)) {// int
				System.out.println("0. obojetnie");
				System.out.println("1. konkretnie");
				System.out.println("2. przedzial");

				choose = scanObj.nextLine();

				if (choose.equalsIgnoreCase("1")) {
					value_3_min[v3] = 0;
					valuePassed = true;
					do {
						try {
							System.out.println("Podaj wartosc:");
							value_3_min[v3] = scanObj.nextInt();
							valuePassed = true;

						} catch (InputMismatchException e) {
							// System.out.println("Nie poda³eœ dobrej wartoœci ");
							scanObj.next();
							valuePassed = false;
						}
					} while (!valuePassed);

					value_3_max[v3] = value_3_min[v3];
				} else if (choose.equalsIgnoreCase("2")) {
					valuePassed = true;
					do {
						try {
							System.out.println("Podaj wartosc min:");
							value_3_min[v3] = scanObj.nextInt();
							valuePassed = true;

						} catch (InputMismatchException e) {
							// System.out.println("Nie poda³eœ dobrej wartoœci ");
							scanObj.next();
							valuePassed = false;
						}
					} while (!valuePassed);

					valuePassed = true;
					do {
						try {
							System.out.println("Podaj wartosc max:");
							value_3_max[v3] = scanObj.nextInt();
							valuePassed = true;

						} catch (InputMismatchException e) {
							// System.out.println("Nie poda³eœ dobrej wartoœci ");
							scanObj.next();
							valuePassed = false;
						}
					} while (!valuePassed);
				} else {
					value_3_min[v3] = 0;
					value_3_max[v3] = 9999999;
				}

				v3++;
			}

		}

		System.out.println("");
		System.out.println("Znalezione samochody: ");
		System.out.println("");

		header();

		int found = 0;

		for (int j = 0; j < ilosc_elementow; j++) {

			if (cars.get(j).search_for_Search(value_1, value_2_min, value_2_max, value_3_min, value_3_max)) {
				// cout.width(l1);
				System.out.print(j);
				System.out.print(" | ");
				cars.get(j).show();

				found = 1;
			}

		}

		if (found == 0) {

			// cout.width(l1);
			System.out.print("brak" + " | ");
			// cout.width(l2);
			System.out.print("brak" + " | ");
			// cout.width(l3);
			System.out.print("brak" + " | ");
			// cout.width(l4);
			System.out.print("brak" + " | ");
			// cout.width(l5);
			System.out.print("brak" + " | ");
			// cout.width(l6);
			System.out.print("brak" + " | ");
			// cout.width(l7);
			System.out.println("brak" + " | ");
		}

	}

	public static void showOne(Vector<pojazd> cars) {

		String a;

		int elementow_na_strone = 1;

		int j = 0;

		while (true) {

			header();

			for (int i = 0; i < elementow_na_strone; i++) {

				if (i + j < (ilosc_elementow)) {

					System.out.print(i + j);
					System.out.print(" | ");
					cars.get(i + j).show();
					System.out.println("");
				}
			}

			System.out.println("Nacisnij \"d\"(->) lub \"a\"(<-) aby przemieszczaæ sie po liœcie lub \"p\" aby wyjœæ");

			a = System.console().readLine();

			if (a.equalsIgnoreCase("a")) {
				if (j == 0) {

				} else {
					j -= elementow_na_strone;
				}

			}
			if (a.equalsIgnoreCase("d")) {
				if (j >= (ilosc_elementow - 1)) {
					// empty
				} else {
					j += elementow_na_strone;

				}
			}
			if (a.equalsIgnoreCase("p")) {
				clearConsole();
				break;
			}
			clearConsole();

		}

	}// end of showOne()

	public static void sort(Vector<pojazd> cars) {

		System.out.println("Sortowanie po wybranym parametrze: ");

		System.out.println("Parametry do wyboru (podaj numer parametru) :");

		String a;

		for (int i = 0; i < ilosc_parametrow; i++) {
			System.out.println(i + 1 + ". " + nazwy_parametrow[i]);
		}

		a = System.console().readLine();

		/*
		 * if ((a > ilosc_parametrow) || (a <= 0)) {
		 * 
		 * }
		 */

		clearConsole();

		quickSort(cars, 0, ilosc_elementow - 1, a);

		showAll(cars);

	}

	public static void quickSort(Vector<pojazd> cars, int left, int right, String a) {

		int i = left;
		int j = right;

		do {

			while (cars.get(i).compare_for_quickSort(cars.get((left + right) / 2), a, 1))
				// while (cars[i].marka < cars[(left + right) / 2].marka)
				i++;

			while (cars.get(j).compare_for_quickSort(cars.get((left + right) / 2), a, 2))
				j--;

			if (i <= j) {
				// swap(cars[i], cars[j]);
				Collections.swap(cars, i, j);
				i++;
				j--;
			}
		} while (i <= j);

		if (left < j)
			quickSort(cars, left, j, a);

		if (right > i)
			quickSort(cars, i, right, a);

	}

	public static void deleteOne(Vector <pojazd> cars) {
		
		
		showAll(cars);

		Scanner scanObj = new Scanner(System.in); // Create a Scanner object
		
		
		System.out.println("");
		System.out.println("Jaki samochod chcesz usunac? Podaj odpowiednie id:" );

		int a=0;
		
		boolean valuePassed = true;
		do {
			try {
				a = scanObj.nextInt();
				

			} catch (InputMismatchException e) {
				System.out.println("Z³e id... ");
				scanObj.next();
				valuePassed = false;
			}
			
			if( (a >=0) && (a< ilosc_elementow)) {
				valuePassed = true;
			}
			else {
				System.out.println("Z³e id... ");
				valuePassed = false;
			}
			
			
		} while (!valuePassed );
		
		//&& !(a >= 0 && a< ilosc_elementow)
		
		cars.remove(a);
		
		System.out.println("Usuniêto pojazd.");
		
		
		 File myObj = new File("baza.txt"); 
		 myObj.delete();
		
		
		for (int i = 0; i < ilosc_elementow - 1; i++) {
		
		cars.get(i).putToFile();
		
		}
		
	}

}
