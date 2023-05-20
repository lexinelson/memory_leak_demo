import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        System.out.println("Welcome to the command line word processor!");
        while (true) {
            if (!getInputAndWrite() || !writeAnotherLine()) break;
        }
        System.out.println("Goodbye!");
    }

    public static boolean getInputAndWrite() {
        System.out.println("Please write the line you would like to save.");
        Scanner scanner = new Scanner(System.in);
        return writeLineToFile(scanner.nextLine());
    }

    public static boolean writeLineToFile(String inputToWrite) {
        try (FileWriter writer = new FileWriter("target/saved_input.txt", true)) {
            writer.write(inputToWrite + "\n");
            return true;
        } catch (IOException e) {
            System.out.println("ERROR - " + e.getMessage());
            return false;
        }
    }

    public static boolean writeAnotherLine() {
        System.out.print("\nWould you like to write another line? (Y/N) >> ");
        Scanner scanner = new Scanner(System.in);
        char response = scanner.nextLine().trim().toLowerCase().charAt(0);
        if (response != 'y' && response != 'n') {
            return writeAnotherLine();
        } else {
            return response == 'y';
        }
    }
}