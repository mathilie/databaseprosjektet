package main;
import java.util.Scanner;

public class Terminal {
		
		public static String testfunc(int nbr){
			return "test"+nbr;
		}
		
		public static void main(String[] args) {
	        System.out.println(
	        		  "Press 1 for: Legge inn treningsøkt\n"
	        		+ "Press 2 for: Hente ut data om økter\n"
	        		+ "Press 3 for: Hente ut alle treningsnotater\n"
	        		+ "Press 4 for: Avslutt program\n"
	        		);
//		    Data data = new Data();
//		    data.menu();
		
		    Scanner scanner = new Scanner(System.in);
		    
		    int choice = scanner.nextInt();
		    scanner.close();
			    switch (choice) {
			        case 1:
			        	Scanner scanner2 = new Scanner(System.in);
			        	System.out.println("### Legge inn treningsøkt ###"); 
			        	System.out.println("Dagsform under treningsøkt? [1-4] 1 dårligst, 4 best");
			        	int shape = scanner2.nextInt();
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
