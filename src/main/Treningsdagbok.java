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
		
		System.out.println("Legg til dato: YYYY-MM-DD\n");
		String dato = s.next();
		System.out.println("\n Legg til tidspunkt:\n");
		String tidspunkt = s.next();
		System.out.println("\n Legg til varighet:\n");
		String varighet = s.next();
		System.out.println("\n Legg til dagsform:\n");
		String dagsform = s.next();
		System.out.println("\n Legg til Øvelser:\n");
		String Øvelser = s.next();
		System.out.println("\n Legg til resultater:\n");
		String resultater = s.next();
		System.out.println("\n Legg til temperatur:\n");
		String temp = s.next();
		System.out.println("\n Legg til vær:\n");
		String vØr = s.next();
		System.out.println("\n Legg til Sork:\n");
		int SorK = Sork();
		
		db.lagUtendØrsØktØkt(dato, tidspunkt, varighet, dagsform, Øvelser, resultater, temp, vØr, SorK);
	}


	private void lagMal() {
	System.out.println("Her er alle dine treningsøkter:");
	System.out.println("_______________________________");
	List<String> alleØkter = db.getØkter();
	for (int j = 0; j < alleØkter.size(); j++) {
		System.out.println("|Økt nummer: " + j + "|\tØvelser: ");
		List<String> enØkt = db.getØvelser(alleØkter.get(j));
		for (int i = 0; i < enØkt.size(); i += 2) {
			System.out.print(enØkt.get(i+1)+ "\t");
		}
	}
	System.out.println("Velg nummereret til den treningsøkten du vil ha som mal.");
	String treningsID = s.next();
	System.out.println("Lag navn på din trenings mal.");
	String navn = s.next();
	db.lagMal(treningsID, navn);
	}


	private void fåTips() {
		// TODO Auto-generated method stub
		
	}
	
}
