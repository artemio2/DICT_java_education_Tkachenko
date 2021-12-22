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
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
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

        } else if (command.equals("2")) {
            System.out.print("Enter size of matrix: ");
            int row = Integer.parseInt(scanner.next());
            int col = Integer.parseInt(scanner.next());
            System.out.println("Enter matrix: ");
            double[][] matrix = readMatrix(row, col);

            System.out.print("Enter constant: ");
            double constant = Double.parseDouble(scanner.next());

            System.out.println("The result is: ");
            printMatrix(multiplicationByConstant(matrix, constant));

        }else if (command.equals("0")) {
            System.exit(0);

        }else if (command.equals("3")) {
            System.out.print("Enter size of first matrix: ");
            int rowOne = Integer.parseInt(scanner.next());
            int colOne = Integer.parseInt(scanner.next());
            System.out.println("Enter first matrix: ");
            double[][] matrixNumberOne = readMatrix(rowOne, colOne);

            System.out.print("Enter size of second matrix: ");
            int rowTwo = Integer.parseInt(scanner.next());
            int colTwo = Integer.parseInt(scanner.next());
            System.out.println("Enter second matrix: ");

            double[][] matrixNumberTwo = readMatrix(rowTwo, colTwo);
            System.out.println("The result is: ");
            printMatrix(multiplicationByMatrix(matrixNumberOne, matrixNumberTwo));
        }else if (command.equals("4")) {
            printTransposeMenu();
        }

    }
    private static boolean checkSameSize ( int rowOne, int colOne, int rowTwo, int colTwo){
        if (rowOne != rowTwo || colOne != colTwo) {
            System.out.println("The operation cannot be performed.");
            return false;
        }
        return true;
    }

    private static double[][] readMatrix ( int row, int col){
        double[][] matrix = new double[row][col];

        for (int i = 0; i < row; i++) {
            for (int ii = 0; ii < col; ii++) {
                matrix[i][ii] = Double.parseDouble(scanner.next());
            }
        }
        return matrix;
    }

    private static void printMatrix ( double[][] matrix){
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
    private static double[][] multiplicationByConstant(double[][] matrix, double constant) {
        int row = matrix.length;
        int col = matrix[0].length;


        double[][] result = new double[row][col];


        for (int i = 0; i < row; i++) {
            for (int ii = 0; ii < col; ii++) {
                result[i][ii] = matrix[i][ii] * constant;
            }
        }
        return result;
    }
    private static double[][] multiplicationByMatrix(double[][] matrixOne, double[][] matrixTwo) {
        int rowOne = matrixOne.length;
        int colTwo = matrixTwo[0].length;
        int colOne = matrixOne[0].length;

        double[][] result = new double[rowOne][colTwo];

        int indexOne = 0;

        for (int i = 0; i < rowOne; i++) {
            int indexTwo = 0;

            for (int ii = 0; ii < colTwo; ii++) {

                for (int j = 0; j < colOne; j++) {
                    result[i][ii] += matrixOne[indexOne][j] * matrixTwo[j][indexTwo];
                }
                indexTwo++;
            }
            indexOne++;
        }
        return result;
    }
    private static void printTransposeMenu() {
        System.out.println();
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");

        String command = scanner.next();

        System.out.print("Enter matrix size: ");
        int row = Integer.parseInt(scanner.next());
        int col = Integer.parseInt(scanner.next());
        System.out.println("Enter matrix: ");
        double[][] matrix = readMatrix(row, col);

        if (command.equals("1")) {
            System.out.println("The result is: ");
            printMatrix(transposeMainDiagonal(matrix));

        } else if (command.equals("2")) {
            System.out.println("The result is: ");
            printMatrix(transposeSideDiagonal(matrix));

        } else if (command.equals("3")) {
            System.out.println("The result is: ");
            printMatrix(transposeVerticalLine(matrix));

        } else if (command.equals("4")) {
            System.out.println("The result is: ");
            printMatrix(transposeHorizontalLine(matrix));

        }

    }


    private static double[][] transposeMainDiagonal(double[][] matrix) {
        int row = matrix[0].length;
        int col = matrix.length;

        double[][] result = new double[row][col];

        for (int i  = 0; i < row; i++) {
            for (int ii = 0; ii < col; ii++) {
                result[i][ii] = matrix[ii][i];
            }
        }


        return result;
    }

    private static double[][] transposeSideDiagonal(double[][] matrix) {
        int row = matrix[0].length;
        int col = matrix.length;

        double[][] result = new double[row][col];


        for (int i  = 0; i < row; i++) {
            for (int ii = 0; ii < col; ii++) {
                result[i][ii] = matrix[row - 1 - ii][col - 1 - i];
            }
        }

        return result;
    }


    private static double[][] transposeVerticalLine(double[][] matrix) {
        int row = matrix[0].length;
        int col = matrix.length;

        double[][] result = new double[row][col];

        for (int i  = 0; i < row; i++) {
            for (int ii = 0; ii < col; ii++) {
                result[i][ii] = matrix[i][col - 1 - ii];
            }
        }
        return result;
    }

    private static double[][] transposeHorizontalLine(double[][] matrix) {
        int row = matrix[0].length;
        int col = matrix.length;

        double[][] result = new double[row][col];

        for (int i  = 0; i < row; i++) {
            for (int ii = 0; ii < col; ii++) {
                result[i][ii] = matrix[row - 1 - i][ii];
            }
        }
        return result;
    }

}