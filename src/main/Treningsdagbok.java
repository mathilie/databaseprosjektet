package main;

import java.util.Scanner;

public class Treningsdagbok {

	private Scanner s = new Scanner(System.in);
	private Database db = new Database();
	
	public static void main(String[] args) {
		Treningsdagbok t = new Treningsdagbok();
		t.mainMenu();
	}

	
	private void mainMenu(){
		while(true) {
		System.out.println("Hva vil du gjøre?\n"
				+ "________________________\n"
				+ "1| Legge til trening\t|\n"
				+ "2| Lage Mal\t\t|\n"
				+ "3| se Får treningstips\t|"
				+ "4| Avslutt \t\t|\n"
				+ "-------------------------\n"
				+ "");
			switch(s.nextInt()) {
			case 1:
				lagTrening();
			case 2:
				lagMal();
			case 3:
				fåTips();
			case 4:
				System.exit(0);
				default:
					System.out.println("Feil input. Tallet må være mellom 1 og 4;");
			}
		}
		
	}


	private void lagTrening() {
		while(true) {
		System.out.println("Hva slags trening vil du lage?\n"
				+ "__________________"
				+ "1|Innendørs\t\t|\n"
				+ "2|Utendørs\t\t|\n"
				+ "3|Tilbake til hovedmeny\t|\n");
			switch(s.nextInt()) {
			case 1:
				lagInnendørs();
			case 2:
				lagUtendørs();
			case 3:
				break;
				default:
					System.out.println("Feil input. Tallet må være mellom 1 og 4;");
			}
		}
	}


	private void lagInnendørs() {
		System.out.println("Legg til dato: YYYY-MM-DD\n");
		String dato = s.next();
		System.out.println("\n Legg til tidspunkt:\n");
		
		
		
		db.lagInnendØrsØkt(dato, tidspunkt, varighet, dagsform, Øvelser, resultater, luft, ventilasjon, tilskuere, SorK);
	}


	private void lagUtendørs() {
		// TODO Auto-generated method stub
		
	}


	private void lagMal() {
		// TODO Auto-generated method stub
		
	}


	private void fåTips() {
		// TODO Auto-generated method stub
		
	}
	
}
