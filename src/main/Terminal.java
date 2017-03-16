package main;
import java.util.Scanner;
//import Database;


public class Terminal {
    public Scanner scanner = new Scanner(System.in);
    public String choice;
    public Database db1= new Database();
    public String date;
    public String time;
    public String duration;
    public int shape;
    public String exercisesTemp;
    public String[] exercises = new String[20]; //max number of exercises
    public String[] results;

    public void leggeInnTreningsokt(){
        System.out.println("\n ### Legge inn treningsøkt ###\n");
        System.out.println("\n DATO(ÅÅÅÅ-MM-DD):\n");
        date = scanner.nextLine();
        System.out.println("TIDSPUNKT? tt-ss\n");
        time = scanner.nextLine();
        System.out.println("\n VARIGHET(tt-ss):\n");
        duration = scanner.nextLine();
        System.out.println("DAGSFORM? [1-10] 1 dårligst, 10 best\n");
        shape = scanner.nextInt();
        System.out.println("\n ØVELSER(string[]) Skriv siste(ignorerte) økt som \"end\".:\n");
        int i=0;
        while(true){
            exercisesTemp=scanner.nextLine();
            if(exercisesTemp != "end"){
                exercises[i]=exercisesTemp;
            }
            else{
                System.out.println("break\n");
                break;
            }
            i++;
            System.out.println("\n");
        }
        duration = scanner.nextLine();
        System.out.println(
                "### Type trening: ###\n"
                        + "Press 1 for: Innendørsøkt\n"
                        + "Press 2 for: Utendørsøkt\n"
                        + "Press 3 for: Styrkeøkt\n"
                        + "Press otherKey for: Abort&MainMenu\n"
        );
        choice = scanner.nextLine();
        switch (choice) {
            case "1":

                break;
            case "2":
                break;
            case "3":
                break;
            default:
                this.mainMenu();
                break;
        }
    }

    public void mainMenu(){
        System.out.println(
                "### Hovedmeny ###\n"
                        + "Press 1 for: Legge inn treningsokt\n"
                        + "Press 2 for: Hente ut data om1kter\n"
                        + "Press 3 for: Hente ut alle treningsnotater\n"
                        + "Press 4 for: Avslutt program\n"
        );
        choice = scanner.nextLine();
        switch (choice) {
            case "1":
                this.leggeInnTreningsokt();

                break;
            case "2":
                System.out.println("# blabla 2# \n");
                break;
            case "3":
                System.out.println("# blabla 3# \n");
                break;
            case "4":
                System.out.println("### Avslutter program ### \n");
                //System.exit;
                break;
            default:
        }

    }
    // public static String testfunc(int nbr){
    // 	return "test"+nbr;
    // }

    public static void main(String[] args) {
        Terminal action = new Terminal();
        action.mainMenu();
    }

}
