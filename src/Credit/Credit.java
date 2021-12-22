package Credit;
import java.util.Scanner;

public class Credit {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the loan principal:");
        int principal = scanner.nextInt();
        System.out.println(principal);
        System.out.println("What do you want to calculate?\n" +
                "type \"m\" – for number of monthly payments,\n" +
                "type \"p\" – for the monthly payment:");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        if (choice.equals("m")){
            System.out.println("Enter the monthly payment:");
            Scanner Scamer = new Scanner(System.in);
            int month = Scamer.nextInt();
            int sum = principal / month;
            System.out.println("It will take " + sum + " months to repay the loan");
        }
        if (choice.equals("p")){
            System.out.println("Enter the number payment:");
            Scanner scanr = new Scanner(System.in);
            int payment = scanr.nextInt();
            int sum2 = principal / payment;
            System.out.println("Your monthly payment =" + sum2);
        }
    }
}