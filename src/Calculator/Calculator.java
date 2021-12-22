package Calculator;
import java.util.Scanner;



public class Calculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to calculate?\n" +
                "type \"n\" for number of monthly payments,\n" +
                "type \"a\" for annuity monthly payment amount,\n" +
                "type \"p\" for loan principal:");
        String choice = scanner.nextLine();
         if (choice.equals("m")){
             Scanner p = new Scanner(System.in);
             Scanner month = new Scanner(System.in);
             Scanner ia = new Scanner(System.in);
             System.out.println("Enter the loan principal:");
             String p_ = p.nextLine();
             System.out.println("Enter the monthly payment:");
             String month_ = month.nextLine();
             System.out.println("Enter the loan interest:");
             int ia_ = ia.nextInt();
             System.out.println("It will take 8 years and 2 months to repay this loan!");
             int formule = ia_ * (1/12) * (1/100);
             System.out.println(formule);
         }

    }
}
