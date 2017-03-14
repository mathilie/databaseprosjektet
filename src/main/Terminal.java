package main;
import java.util.Scanner;

public class Terminal {
		
		public static String testfunc(int nbr){
			return "test"+nbr;
		}
		
		public static void main(String[] args) {
	        System.out.println(
	        		  "Press 1 for: Legge inn treningskt\n"
	        		+ "Press 2 for: Hente ut data om1kter\n"
	        		+ "Press 3 for: Hente ut alle treningsnotater\n"
	        		+ "Press 4 for: Avslutt program\n"
	        		);
//		    Data data = new Data();
//		    data.menu();
		
		    Scanner scanner = new Scanner(System.in);
		    
		    int choice = scanner.nextInt();
			    switch (choice) {
			        case 1:
			        	int shape = scanner.nextInt();
//			        	System.out.println("Dato for treningsøkt? dd/mm/åååå");
//			        	String date = scanner.next();
			        	System.out.println("Tidspunkt for treningsøkt? tt:ss");
			        	String time = scanner.next();
			        	System.out.println("Varighet for treningsøkt? tt:ss");
			        	String duration = scanner.nextLine();
			        	break;
			        case 2:
			        	System.out.println("# blabla #"); 
			        	System.out.println(testfunc(choice));
			            break;
			        case 3:
			        	System.out.println("# blabla #"); 
			        	System.out.println(testfunc(choice));
			            break;
			        case 4:
			        	System.out.println("### Avslutter program ###");
			            break;
			        default:
		    }
		}

}
