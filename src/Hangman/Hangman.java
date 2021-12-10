package Hangman;
import java.util.Random;
import java.util.Scanner;


public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArray = {"java", "python", "javascript", "kotlin"};
        System.out.println("HANGMAN");
        int rnd = new Random().nextInt(strArray.length);
        String w = strArray[rnd];
        String temp_word = w.replaceAll("[a-z]", "-");
        StringBuilder hidden_word = new StringBuilder(temp_word);
        System.out.println(hidden_word);
        int i = 0;
        while (i < 8) {
            System.out.print("\nInput a letter:");
            String input = scanner.nextLine();

            if (!w.contains(input)) {
                System.out.println("That letter doesnt appear in the word!");
                i++;
            }
            else{
                for (int z = 0; z < hidden_word.length(); z++) {
                    if (w.charAt(z) == input.charAt(0)){
                        hidden_word.setCharAt(z, input.charAt(0));

                    }
                }
                System.out.println(hidden_word);

            }

        }
        System.out.println("Thanks for playing!");
        System.out.println("Well see how well you did in the next stage");
        }
    }

