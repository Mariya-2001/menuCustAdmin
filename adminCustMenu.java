import java.util.ArrayList;
import java.util.Scanner;

public class adminCustMenu {
    static final String adminPIN = "1234";
    static final String[] priority = {"Low","Medium","High"};


    static ArrayList<Integer> Num = new ArrayList<>();
    static ArrayList<String> desc = new ArrayList<>();
    static ArrayList<String> priorities = new ArrayList<>();

    public static void main(String[] args){
        Scanner sca = new Scanner(System.in);

        while (true){
            System.out.println("1. Customer ");
            System.out.println("2. Admin ");
            System.out.println("3. Exit ");
            System.out.println("Please Cust/Admin Enter your Choice: ");

            int choice = sca.nextInt();
            sca.nextLine();

            if (choice == 1)
                custMenu(sca);
            else if ( choice == 2 )
                adminMenu(sca);
            else if ( choice == 3 )
                break;
            else
                System.out.println("Invalid");
        }
        System.out.println("Bye!");
        sca.close();
    }
    static void custMenu(Scanner sca){
        while (true){
            System.out.println("1- Ticket to be Created..");
            System.out.println("Go Back!");
            System.out.println("Choice Number: ");

            int choice = sca.nextInt();
            sca.nextLine();

            if (choice == 1 ) {
                System.out.println("Enter The Ticket Number Please:  ");

                Num.add(sca.nextInt());
                sca.nextLine();

                System.out.println("Please Enter The Description:  ");
                desc.add(sca.nextLine());

                System.out.print("Please Enter The Priority:(1=Low,2=Medium,3=High): ");
                int Prio = sca.nextInt();
                sca.nextLine();

                priorities.add((Prio >= 1 && Prio <= 3) ? priority[Prio - 1] : "Medium");
                System.out.println("The Ticket is Successfully Created!..");
            }
            else if (choice == 2) return;
            else
                System.out.println("Invalid!!!");
            }
        }
        static void adminMenu(Scanner sca){
            System.out.println("Please Enter The PIN: ");
            if(!sca.nextLine().equals(adminPIN)){
                System.out.println("Invalid PIN, Try Again Please");
                return;
            }
            while (true){
                System.out.println("1. View The Ticket ");
                System.out.println("2. Press to Update the Ticket ");
                System.out.println("3. Go Back / EXIT..");
                System.out.println("Enter Your Choice: ");

                int choice = sca.nextInt();
                sca.nextLine();

                if (choice == 3) return;

                System.out.println("Please Enter the Ticket Number: ");
                int number = sca.nextInt();
                sca.nextLine();

                int i = Num.indexOf(number);

                if (i == -1){
                    System.out.println("Not Found");
                    continue;
                }
                if (choice == 1){
                    System.out.println("The Description you wrote is: " +desc.get(i));
                    System.out.println("The Priority You Choose is: " +priorities.get(i));
                }
                else if (choice == 2){
                    System.out.println("Your New Description: ");
                    desc.set(i,sca.nextLine());
                    System.out.println("Thi has Been Updated");
                }
                else{
                    System.out.println("Invalid!");
                }
            }
    }

}