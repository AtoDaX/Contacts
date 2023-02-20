package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook(scanner);

        UserInterface UI = new UserInterface(scanner,phoneBook);

        UI.start();
        scanner.close();
    }
}
