import java.io.FileWriter;
import java.io.IOException;

public class pojazd {
	private
	String marka;
	String model;
	int rocznik;
	float pojemnosc;
	int przebieg;
	String typ_skrzyni_biegow;

	public pojazd(String a, String b, int c, float d, int e, String f) {
		this.marka = a;
		this.model = b;
		this.rocznik = c;
		this.pojemnosc = d;
		this.przebieg = e;
		this.typ_skrzyni_biegow = f;
	}

	public void show() {
		// cout.width(l2);
		System.out.print(marka);
		System.out.print(" | ");
		// cout.width(l3);
		System.out.print(model);
		System.out.print(" | ");
		// cout.width(l4);
		System.out.print(rocznik);
		System.out.print(" | ");
		// cout.width(l5);
		System.out.print(pojemnosc);
		System.out.print(" | ");
		// cout.width(l6);
		System.out.print(przebieg);
		System.out.print(" | ");
		// cout.width(l7);
		System.out.print(typ_skrzyni_biegow);
		System.out.println(" | ");
		// cout.width(l2);

	}

	public boolean search_for_Search(String value_1[], float value_2_min, float value_2_max, int value_3_min[],
			int value_3_max[]) {
		if ((marka.equalsIgnoreCase(value_1[0]) || value_1[0].equalsIgnoreCase("*")) && (model.equalsIgnoreCase(value_1[1])  || value_1[1].equalsIgnoreCase("*"))
				&& (typ_skrzyni_biegow.equalsIgnoreCase(value_1[2])  || value_1[2].equalsIgnoreCase("*"))
				&& (rocznik >= value_3_min[0] && rocznik <= value_3_max[0])
				&& (pojemnosc >= value_2_min && pojemnosc <= value_2_max)
				&& (przebieg >= value_3_min[1] && przebieg <= value_3_max[1])) {
			return true;
		} else {
			return false;
		}

	}

	
	public boolean compare_for_quickSort(pojazd car_2, String a,int b) {

		switch (a)
		{
		case "1": {


			if (b == 1) {
				if (car_2.marka.compareTo(marka)>0) {
					return true;
				}
				else {
					return false;
				}
			}
			else if (b == 2) {
				if (marka.compareTo(car_2.marka) >0) {
					return true;
				}
				else {
					return false;
				}
			}


			break;
		}
		case "2": {
			if (b == 1) {
				if (car_2.model.compareTo(model)>0) {
					return true;
				}
				else {
					return false;
				}
			}
			else if (b == 2) {
				if (model.compareTo(car_2.model) >0) {
					return true;
				}
				else {
					return false;
				}
			}


			break;
		}
		case "3": {

			if (b == 1) {
				if (rocznik < car_2.rocznik) {
					return true;
				}
				else {
					return false;
				}
			}
			else if (b == 2) {
				if (rocznik > car_2.rocznik) {
					return true;
				}
				else {
					return false;
				}
			}


			break;
		}
		case "4": {

			if (b == 1) {
				if (pojemnosc < car_2.pojemnosc) {
					return true;
				}
				else {
					return false;
				}
			}
			else if (b == 2) {
				if (pojemnosc > car_2.pojemnosc) {
					return true;
				}
				else {
					return false;
				}
			}



			break;
		}
		case "5": {

			if (b == 1) {
				if (przebieg < car_2.przebieg) {
					return true;
				}
				else {
					return false;
				}
			}
			else if (b == 2) {
				if (przebieg > car_2.przebieg) {
					return true;
				}
				else {
					return false;
				}
			}

			break;
		}
		case "6": {

			if (b == 1) {
				if (car_2.typ_skrzyni_biegow.compareTo(typ_skrzyni_biegow)>0) {
					return true;
				}
				else {
					return false;
				}
			}
			else if (b == 2) {
				if (typ_skrzyni_biegow.compareTo(car_2.typ_skrzyni_biegow)>0) {
					return true;
				}
				else {
					return false;
				}
			}


			break;
		}
		default: {
			if (b == 1) {
				if (car_2.marka.compareTo(marka)>0) {
					return true;
				}
				else {
					return false;
				}
			}
			else if (b == 2) {
				if (marka.compareTo(car_2.marka)>0) {
					return true;
				}
				else {
					return false;
				}
			}
			break;
		}


		}//switch

		return true;
	}//boolean

	
	public void putToFile() {
		try {
			FileWriter myWriter = new FileWriter("baza.txt",true);

			myWriter.write(marka + "\n");
			myWriter.write(model + "\n");
			myWriter.write(rocznik + "\n");
			myWriter.write(pojemnosc + "\n");
			myWriter.write(przebieg + "\n");
			myWriter.write(typ_skrzyni_biegow + "\n");


			myWriter.close();

			//System.out.println("Pomyœlnie dodano element: ");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
		
	}
	
}
