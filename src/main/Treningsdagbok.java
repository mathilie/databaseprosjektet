package main;

import java.util.List;
import java.util.ArrayList;
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
		String tidspunkt = s.next();
		System.out.println("\n Legg til varighet:\n");
		String varighet = s.next();
		System.out.println("\n Legg til dagsform:\n");
		String dagsform = s.next();
		System.out.println("\n Legg til luft:\n");
		String luft = s.next();
		System.out.println("\n Legg til ventilasjon:\n");
		String ventilasjon = s.next();
		System.out.println("\n Legg til antall tilskuere:\n");
		String tilskuere = s.next();
		System.out.println("\n Er dette en :\n");
		int SorK = Sork();
		List<List<String>> øvOgRes = øvelser();
		db.lagInnendØrsØkt(dato, tidspunkt, varighet, dagsform,(String[]) øvOgRes.get(0).toArray(),(String[]) øvOgRes.get(1).toArray(), luft, ventilasjon, tilskuere, SorK);
	}
	
		
		
		
		private List<List<String>> øvelser() {
			List<String> øvelser = db.getØvelser();
			List<List<String>> returnList = new ArrayList<List<String>>();
			for(int j=0;j<2;j++) returnList.add(new ArrayList<String>());
			boolean finished=false;
			while (!finished){
				System.out.println("Legg til øvelse eller skriv done når du er ferdig: \n");
				for (int i = 0; i<øvelser.size();i+=2){
					System.out.println(øvelser.get(i)+"| "+øvelser.get(i+1)+"\n");
				}
				
				if(s.hasNext()){
					String inn = s.next();
					if("done".equals(inn)) return returnList;
					if(øvelser.contains(inn)) returnList.get(0).add(inn);
					System.out.println("skriv inn resultat");
					returnList.get(1).add(s.next());
				}
				System.out.println();
			}
				
		return null;
	}

		
		
		

		private int Sork() {
			int SorK;
			while(true) {
				System.out.println(""
						+ "__________________"
						+ "1|Styrkeøkt\t\t|\n"
						+ "2|kondisjonsøkt\t\t|\n");
					switch(s.nextInt()) {
					case 1:
						SorK = Database.STYRKE;
						return SorK;
					case 2:
						SorK = Database.KONDISJON;
						return SorK;
						default:
							System.out.println("Feil input. Tallet må være mellom 1 og 2;");
					}
			}
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
		System.out.println("\n Legg til luft:\n");
		String luft = s.next();
		System.out.println("\n Legg til ventilasjon:\n");
		String ventilasjon = s.next();
		System.out.println("\n Legg til antall tilskuere:\n");
		String tilskuere = s.next();
		System.out.println("\n Er dette en :\n");
		int SorK = Sork();
		List<List<String>> øvOgRes = øvelser();
	}
	
	


	private void lagMal() {
		// TODO Auto-generated method stub
		
	}


	private void fåTips() {
		// TODO Auto-generated method stub
		
	}
	
}
