package seedu.connoisseur;

import seedu.connoisseur.parser.Parser;

import java.util.Scanner;

public class Connoisseur {
    /**
     * Main entry-point for the java.connoisseur.Connoisseur application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

        ui.printGreeting();
        String input;
        boolean isExit = false;

        while (in.hasNext()) {
            input = in.nextLine().trim();


            isExit = Parser.determineCommand(input);

            if (isExit) {
                break;
            }

        }
        ui.printExitMessage();
        in.close();

    }
}

