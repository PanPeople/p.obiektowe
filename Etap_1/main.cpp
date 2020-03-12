#include<iostream>

#include<fstream>//obsługa plików

#include<vector>//obsługa wektorów

#include<string>//osbługa zmiennej string

#include <stdlib.h>     

#include <cctype>

#include <conio.h>// _getch()


#define lokalizacja "C:\\Users\\PanPeople\\Desktop\\baza_2.txt"


using namespace std;



//stałe zmienne
const int ilosc_parametrow = 6;
const int l1 = 5, l2 = 16, l3 = 16, l4 = 10, l5 = 12, l6 = 12, l7 = 24;
string nazwy_parametrow[ilosc_parametrow + 1] = { "marka" ,"model" , "rocznik" , "pojemnosc" , "przebieg" , "typ skrzyni biegow", "id" };


//zmienne globalne
int ilosc_elementow = 0;


//klasy
class pojazd {


	string marka;
	string model;
	int rocznik;
	float pojemnosc;
	int przebieg;
	string typ_skrzyni_biegow;
public:
	pojazd(string a, string b, int c, float d, int e, string f) {
		marka = a;
		model = b;
		rocznik = c;
		pojemnosc = d;
		przebieg = e;
		typ_skrzyni_biegow = f;
	}


	/*
	friend ostream& operator<< (ostream& wyjscie, const pojazd temp) {
		return wyjscie << cout.width(l2) << temp.marka << " | " <<
			cout.width(l3) << temp.model << " | " <<
			cout.width(l4) << temp.rocznik << " | " <<
			cout.width(l5) << temp.pojemnosc << " | " <<
			cout.width(l6) << temp.przebieg << " | " <<
			cout.width(l7) << temp.typ_skrzyni_biegow << " | " << endl;
	}
	*/

	friend ostream& operator<< (ostream& wyjscie, const pojazd temp) {
		return wyjscie << temp.marka << endl << temp.model << endl <<temp.rocznik << endl <<temp.pojemnosc << endl <<temp.przebieg << endl << temp.typ_skrzyni_biegow << endl;
	}


	void show() {
		cout.width(l2); cout << marka; cout << " | ";
		cout.width(l3); cout << model; cout << " | ";
		cout.width(l4); cout << rocznik; cout << " | ";
		cout.width(l5); cout << pojemnosc; cout << " | ";
		cout.width(l6); cout <<przebieg; cout << " | ";
		cout.width(l7); cout << typ_skrzyni_biegow; cout << " | " << endl;
	}



	bool compare_for_quickSort(pojazd car_2, int a,int b) {

		switch (a)
		{
		case 1: {


			if (b == 1) {
				if (marka < car_2.marka) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else if (b == 2) {
				if (marka > car_2.marka) {
					return 1;
				}
				else {
					return 0;
				}
			}


			break;
		}
		case 2: {
			if (b == 1) {
				if (model < car_2.model) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else if (b == 2) {
				if (model > car_2.model) {
					return 1;
				}
				else {
					return 0;
				}
			}


			break;
		}
		case 3: {

			if (b == 1) {
				if (rocznik < car_2.rocznik) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else if (b == 2) {
				if (rocznik > car_2.rocznik) {
					return 1;
				}
				else {
					return 0;
				}
			}


			break;
		}
		case 4: {

			if (b == 1) {
				if (pojemnosc < car_2.pojemnosc) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else if (b == 2) {
				if (pojemnosc > car_2.pojemnosc) {
					return 1;
				}
				else {
					return 0;
				}
			}



			break;
		}
		case 5: {

			if (b == 1) {
				if (przebieg < car_2.przebieg) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else if (b == 2) {
				if (przebieg > car_2.przebieg) {
					return 1;
				}
				else {
					return 0;
				}
			}

			break;
		}
		case 6: {

			if (b == 1) {
				if (typ_skrzyni_biegow < car_2.typ_skrzyni_biegow) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else if (b == 2) {
				if (typ_skrzyni_biegow > car_2.typ_skrzyni_biegow) {
					return 1;
				}
				else {
					return 0;
				}
			}


			break;
		}
		default: {
			if (b == 1) {
				if (marka < car_2.marka) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else if (b == 2) {
				if (marka > car_2.marka) {
					return 1;
				}
				else {
					return 0;
				}
			}
			break;
		}


		}//switch

	}//bool

	bool search_for_Search(string value_1[],float value_2_min,float value_2_max,int value_3_min[],int value_3_max[]){
		if ((value_1[0] ==marka || value_1[0] == "*") && (value_1[1] ==model || value_1[1] == "*") && (value_1[2] ==typ_skrzyni_biegow || value_1[2] == "*") && (rocznik >= value_3_min[0] && rocznik <= value_3_max[0]) && (pojemnosc >= value_2_min && pojemnosc <= value_2_max) && (przebieg >= value_3_min[1] && przebieg <= value_3_max[1])) {
			return 1;
		}
		else {
			return 0;
		}



	}



};//class


//deklaracje funkcji:
void header();
void exit_o();
void showAll(vector<pojazd>& cars);
void addCar(vector<pojazd>& cars);
void search(vector<pojazd>& cars);
void showOne(vector<pojazd>& cars);
void sort(vector<pojazd>& cars);
void quickSort(vector<pojazd>& cars, int left, int right, int a);
void deleteOne(vector<pojazd>& cars);

int main() {



	while (1) {

		fstream file;

		string temp_value;

		vector<pojazd>cars;

		string temp_value_tab[ilosc_parametrow] = { "0","0","0","0.0","0","0" };

		ilosc_elementow = 0;


		file.open(lokalizacja, std::ios::in);

		//ładowanie rekordów do vectora
		int i = 0;
		while (getline(file, temp_value)) {
			temp_value_tab[i] = temp_value;
			i++;

			if (i == 6) {
				pojazd temp(temp_value_tab[0], temp_value_tab[1], stoi(temp_value_tab[2]), stof(temp_value_tab[3]), stoi(temp_value_tab[4]), temp_value_tab[5]);
				cars.push_back(temp);
				i = 0;
				ilosc_elementow++;
			}


		}


		cout << "Katalog samochodow:" << endl;
		cout << "_________________________" << endl;

		cout << "Menu:" << endl;

		cout << "1.Wyswietlenie listy samochodow" << endl;
		cout << "2.Wprowadzenie danych nowego samochodu" << endl;
		cout << "3.Wyswietlanie warunkowe" << endl;
		cout << "4.Wyswietlanie pojedyncze" << endl;
		cout << "5.Sortowanie" << endl;
		cout << "6.Usuniecie samochodu z katalogu" << endl;
		cout << "7.WYJSCIE" << endl;
		//cout << cars[0];

		char czynnosc = _getch(); //pobieramy znak z klawiatury
		system("cls");
		switch (czynnosc) //switch, gdzie wybieramy różne funkcje naszego programu
		{
		case 49://1
		{
			showAll(cars);
			exit_o();
			break;
		}

		case 50://2
		{
			addCar(cars);
			exit_o();
			break;
		}

		case 51://3
		{
			search(cars);
			exit_o();
			break;
		}

		case 52://4
		{
			showOne(cars);
			break;
		}
		case 53://5
		{
			sort(cars);
			exit_o();
			break;
		}

		case 54://6
		{
			deleteOne(cars);
			exit_o();
			break;
		}
		case 55://7
		{
			file.close();
			exit(0);
			break;
		}
		default:
		{

			break;
		}
		}


		//cars.erase(cars.begin(), cars.begin()+ilosc_elementow-1);

		file.close();
	}


	/*
	string a = "zda$nie a b c";

	a.erase(0, a.find("$")+1);
	cout << a << endl;
	*/

}

void header() {
	cout.width(l1); cout << nazwy_parametrow[6]; cout << " | ";
	cout.width(l2); cout << nazwy_parametrow[0]; cout << " | ";
	cout.width(l3); cout << nazwy_parametrow[1]; cout << " | ";
	cout.width(l4); cout << nazwy_parametrow[2]; cout << " | ";
	cout.width(l5); cout << nazwy_parametrow[3]; cout << " | ";
	cout.width(l6); cout << nazwy_parametrow[4]; cout << " | ";
	cout.width(l7); cout << nazwy_parametrow[5]; cout << " | " << endl;

	//pusty wiersz
	cout.width(l1); cout << ""; cout << " | ";
	cout.width(l2); cout << ""; cout << " | ";
	cout.width(l3); cout << ""; cout << " | ";
	cout.width(l4); cout << ""; cout << " | ";
	cout.width(l5); cout << ""; cout << " | ";
	cout.width(l6); cout << ""; cout << " | ";
	cout.width(l7); cout << ""; cout << " | " << endl;
}

void exit_o() {
	cout << endl;
	cout << "Nacisnij ESC aby powrocic..." << endl;
	while (_getch() != 27);
	system("cls");
}

void showAll(vector<pojazd>& cars) {

	header();

	for (int i = 0; i < ilosc_elementow; i++) {

		cout.width(l1);
		cout << i;
		cout << " | ";
		//cout << cars[i];
		cars[i].show();
	}




}

void addCar(vector<pojazd>& cars) {

	string v1 = "0", v2 = "0", v3 = "0", v4 = "0", v5 = "0", v6 = "0";

	int v0 = ilosc_elementow;


	cout << "Stworzysz element o indexie: " << v0 << endl;

	cout << "Podaj nowy: " << nazwy_parametrow[0] << endl;
	cin >> v1;

	cout << "Podaj nowy: " << nazwy_parametrow[1] << endl;
	cin >> v2;

	cout << "Podaj nowy: " << nazwy_parametrow[2] << endl;
	cin >> v3;

	cout << "Podaj nowy: " << nazwy_parametrow[3] << endl;
	cin >> v4;

	cout << "Podaj nowy: " << nazwy_parametrow[4] << endl;
	cin >> v5;

	cout << "Podaj nowy: " << nazwy_parametrow[5] << endl;
	cin >> v6;


	fstream file;
	file.open("C:\\Users\\PanPeople\\Desktop\\baza_2.txt", ios::app);


	file << v1 << endl;
	file << v2 << endl;
	file << v3 << endl;
	file << v4 << endl;
	file << v5 << endl;
	file << v6 << endl;

	system("cls");

	cout << "Pomyślnie dodano element:" << endl;

	file.close();

	//wyswietlenie dodanego elementu
	header();

	cout.width(l1);
	cout << v0 << " | ";
	cout.width(l2);
	cout << v1 << " | ";
	cout.width(l3);
	cout << v2 << " | ";
	cout.width(l4);
	cout << v3 << " | ";
	cout.width(l5);
	cout << v4 << " | ";
	cout.width(l6);
	cout << v5 << " | ";
	cout.width(l7);
	cout << v6 << " | " << endl;

}

void showOne(vector<pojazd>& cars) {

	int a;

	int elementow_na_strone = 1;

	header();

	for (int i = 0; i < ilosc_elementow; i++) {
		cout.width(l1);
		cout << i;
		cout << " | ";
		//cout << cars[i];
		cars[i].show();

		cout << endl;
		//cout << "Nacisnij spacje aby kontynuowac..." << endl;
		//while (_getch() != 32);
		cout << "Nacisnij -> lub <- aby przemiieszczac sie po liscie lub ESC aby wyjsc" << endl;

		while (1) {

			a = _getch();

			if (a == 224) {

				a = _getch();

				if (a == 77) {//w prawo

					if (i == ilosc_elementow - 1) {
						system("cls");

						header();

						cout.width(l1);
						cout << "brak" << " | ";
						cout.width(l2);
						cout << "brak" << " | ";
						cout.width(l3);
						cout << "brak" << " | ";
						cout.width(l4);
						cout << "brak" << " | ";
						cout.width(l5);
						cout << "brak" << " | ";
						cout.width(l6);
						cout << "brak" << " | ";
						cout.width(l7);
						cout << "brak" << " | " << endl;

						cout << endl;
						cout << "Nacisnij <- aby przemiieszczac sie po liscie lub ESC aby wyjsc" << endl;

						while (1) {
							int a;

							a = _getch();

							if (a == 224) {

								a = _getch();

								if (a == 77) {//w prawo

								}
								else if (a == 75) {//w lewo
									if (i != 0) {
										system("cls");
										header();
										i -= 1;
										break;
									}

								}
								else {
									cout << endl;
									cout << "Nacisnij <- aby przemiieszczac sie po liscie lub ESC aby wyjsc" << endl;
								}
							}
							else {

								if (a == 27) {
									system("cls");
									break;
								}
								cout << endl;
								cout << "Nacisnij <- aby przemiieszczac sie po liscie lub ESC aby wyjsc" << endl;
							}

						}

						break;

					}
					system("cls");
					header();
					break;

				}
				else if (a == 75) {//w lewo

					if (i != 0) {
						system("cls");
						header();
						i -= 2;
						break;
					}

				}
				else {
					cout << endl;
					cout << "Nacisnij -> lub <- aby przemiieszczac sie po liscie lub ESC aby wyjsc" << endl;
				}
			}
			else {

				if (a == 27) {
					system("cls");
					break;
				}

				cout << endl;
				cout << "Nacisnij -> lub <- aby przemiieszczac sie po liscie lub ESC aby wyjsc" << endl;
			}

		}

		if (a == 27) {
			cout << endl;
			system("cls");
			break;
		}

	}

}

void search(vector<pojazd>& cars) {

	cout << "Wyswietlanie warunkowe: " << endl;


	int v1 = 0, v3 = 0;
	int choose = 0;


	string value_1[3];
	float value_2_min, value_2_max;
	int value_3_min[2], value_3_max[2];

	for (int i = 0; i < ilosc_parametrow; i++) {

		cout << nazwy_parametrow[i] << endl;

		if ((i == 0) || (i == 1) || (i == 5)) {//string

			cout << "0. obojetnie" << endl;
			cout << "1. konkretnie" << endl;

			cin >> choose;

			if (choose == 1) {
				cout << "Podaj wartosc:" << endl;
				cin >> value_1[v1];
			}
			else {
				value_1[v1] = "*";
			}

			v1++;

		}
		else if (i == 3) {//float
			cout << "0. obojetnie" << endl;
			cout << "1. konkretnie" << endl;
			cout << "2. przedzial" << endl;

			cin >> choose;

			if (choose == 1) {
				cout << "Podaj wartosc:" << endl;
				cin >> value_2_min;
				value_2_max = value_2_min;
			}
			else if (choose == 2) {
				cout << "Podaj wartosc min:" << endl;
				cin >> value_2_min;

				cout << "Podaj wartosc max:" << endl;
				cin >> value_2_max;
			}
			else {
				value_2_min = 0.0;
				value_2_max = 100.0;
			}

		}
		else if ((i == 2) || (i == 4)) {//int
			cout << "0. obojetnie" << endl;
			cout << "1. konkretnie" << endl;
			cout << "2. przedzial" << endl;

			cin >> choose;

			if (choose == 1) {
				cout << "Podaj wartosc:" << endl;
				cin >> value_3_min[v3];
				value_3_max[v3] = value_3_min[v3];
			}
			else if (choose == 2) {
				cout << "Podaj wartosc min:" << endl;
				cin >> value_3_min[v3];

				cout << "Podaj wartosc max:" << endl;
				cin >> value_3_max[v3];
			}
			else {
				value_3_min[v3] = 0;
				value_3_max[v3] = 9999999;
			}

			v3++;
		}


	}

	cout << endl;
	cout << "Znalezione samochody: " << endl;
	cout << endl;

	header();

	int found = 0;

	for (int j = 0; j < ilosc_elementow; j++) {
		/*
		if ((value_1[0] == cars[j].marka || value_1[0] == "*") && (value_1[1] == cars[j].model || value_1[1] == "*") && (value_1[2] == cars[j].typ_skrzyni_biegow || value_1[2] == "*") && (cars[j].rocznik >= value_3_min[0] && cars[j].rocznik <= value_3_max[0]) && (cars[j].pojemnosc >= value_2_min && cars[j].pojemnosc <= value_2_max) && (cars[j].przebieg >= value_3_min[1] && cars[j].przebieg <= value_3_max[1])) {
		*/
		if(cars[j].search_for_Search(value_1, value_2_min, value_2_max, value_3_min, value_3_max)){
			cout.width(l1);
			cout << j;
			cout << " | ";
			cars[j].show();

			found = 1;
		}

	}

	if (found == 0) {

		cout.width(l1);
		cout << "brak" << " | ";
		cout.width(l2);
		cout << "brak" << " | ";
		cout.width(l3);
		cout << "brak" << " | ";
		cout.width(l4);
		cout << "brak" << " | ";
		cout.width(l5);
		cout << "brak" << " | ";
		cout.width(l6);
		cout << "brak" << " | ";
		cout.width(l7);
		cout << "brak" << " | " << endl;
	}


}

void sort(vector<pojazd>& cars) {

	cout << "Sortowanie po wybranym parametrze: " << endl;

	cout << "Parametry do wyboru (podaj numer parametru) :" << endl;

	int a;

	for (int i = 0; i < ilosc_parametrow; i++) {
		cout << i + 1 << ". " << nazwy_parametrow[i] << endl;
	}

	cin >> a;

	/*
	if ((a > ilosc_parametrow) || (a <= 0)) {

	}
	*/

	system("cls");

	quickSort(cars, 0, ilosc_elementow - 1, a);

	showAll(cars);

}

void quickSort(vector<pojazd>& cars, int left, int right, int a) {

	int i = left;
	int j = right;

	do{
	
		
		while (cars[i].compare_for_quickSort(cars[(left + right) / 2], a,1))
		//while (cars[i].marka < cars[(left + right) / 2].marka)
			i++;

		while (cars[j].compare_for_quickSort(cars[(left + right) / 2], a, 2))
			j--;

		if (i <= j)
		{
			swap(cars[i], cars[j]);

			i++;
			j--;
		}
	} while (i <= j);

	if (left < j) quickSort(cars, left, j, a);

	if (right > i) quickSort(cars, i, right, a);

}


void deleteOne(vector<pojazd>& cars) {

	showAll(cars);

	cout << endl;
	cout << "Jaki samochod chcesz usunac? Podaj odpowiednie id:" << endl;

	int a;
	cin >> a;

	while ((a < 0) || (a >= ilosc_elementow)) {
		cout << "Id poza zakresem." << endl;
		cin >> a;
	}

	cars.erase(cars.begin() + a);


	fstream file;


	file.open(lokalizacja,ios::out | ios::trunc);



	for (int i = 0; i < ilosc_elementow - 1; i++) {
		
	//	file << cars[i].marka << endl<< cars[i].model << endl<< cars[i].rocznik << endl<< cars[i].pojemnosc << endl<< cars[i].przebieg << endl<< cars[i].typ_skrzyni_biegow <<endl;
		//cars[i].put();
		file << cars[i];
	}

	file.close();
}