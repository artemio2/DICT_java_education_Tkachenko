package Matrix;
import java.util.Scanner;

public class Matrix {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean on = true;

    public static void main(String[] args) {
        while (on) {
            printMenu();
            String command = scanner.next();
            checkCommand(command);
        }
    }

    private static void printMenu() {
        System.out.println("1. Add matrices");
        System.out.println("0. Exit");

    }

    private static void checkCommand(String command) {
        if (command.equals("1")) {
            System.out.print("Enter size of first matrix: ");
            int rowOne = Integer.parseInt(scanner.next());
            int colOne = Integer.parseInt(scanner.next());
            System.out.println("Enter first matrix: ");
            double[][] matrixNumberOne = readMatrix(rowOne, colOne);

            System.out.print("Enter size of second matrix: ");
            int rowTwo = Integer.parseInt(scanner.next());
            int colTwo = Integer.parseInt(scanner.next());
            System.out.println("Enter second matrix: ");

            if (checkSameSize(rowOne, colOne, rowTwo, colTwo)) {
                double[][] matrixNumberTwo = readMatrix(rowTwo, colTwo);
                System.out.println("The result is: ");
                printMatrix(addition(matrixNumberOne, matrixNumberTwo));
            }
        }
        if (command.equals("0")) {
            on = false;
        }
    }
    private static boolean checkSameSize(int rowOne, int colOne, int rowTwo, int colTwo) {
        if (rowOne != rowTwo || colOne != colTwo) {
            System.out.println("The operation cannot be performed.");
            return false;
        }
        return true;
    }

    private static double[][] readMatrix(int row, int col) {
        double[][] matrix = new double[row][col];

        for (int i = 0; i < row; i++) {
            for (int ii = 0; ii < col; ii++) {
                matrix[i][ii] = Double.parseDouble(scanner.next());
            }
        }
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;


        for (int i = 0; i < row; i++) {
            for (int ii = 0; ii < col; ii++) {
                System.out.print(matrix[i][ii] + " ");
            }
            System.out.println();
        }
    }
    private static double[][] addition ( double[][] matrixOne, double[][] matrixTwo){
        int row = matrixOne.length;
        int col = matrixOne[0].length;

        double[][] result = new double[row][col];

        for (int i = 0; i < row; i++) {
            for (int ii = 0; ii < col; ii++) {
                result[i][ii] = matrixOne[i][ii] + matrixTwo[i][ii];
            }
        }
        return result;
    }

}