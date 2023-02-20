package contacts;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private PhoneBook phoneBook;
    public UserInterface(Scanner scanner, PhoneBook phoneBook) {
        this.scanner = scanner;
        this.phoneBook = phoneBook;
    }

    public void start()  {
        while (true) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            String userCommand;
            if (scanner.hasNext()){
                userCommand = scanner.nextLine();
            }else {
                continue;
            }

            try {
                process(userCommand);
            } catch (InputValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void process(String command) throws InputValidationException {
        switch (command) {
            case "add" -> {
                Command addCommand = new AddCommand(this.phoneBook);
                addCommand.execute();
                System.out.println("");
            }
            case "remove" -> {
                Command removeCommand = new RemoveCommand(this.phoneBook);
                removeCommand.execute();
                System.out.println("");
            }
            case "edit" -> {
                Command editCommand = new EditCommand(this.phoneBook);
                editCommand.execute();
                System.out.println("");
            }
            case "list" -> {
                Command infoCommand = new InfoCommand(this.phoneBook);
                infoCommand.execute();
                System.out.println("");
            }
            case "count" -> {
                Command countCommand = new CountCommand(this.phoneBook);
                countCommand.execute();
                System.out.println("");
            }
            case "exit" -> {
                Command exitCommand = new ExitCommand(this.phoneBook);
                exitCommand.execute();
                System.out.println("");
            }
            case "search" -> {
                Command searchCommand = new SearchCommand(this.phoneBook);
                searchCommand.execute();
                System.out.println("");
            }
            default -> System.out.println("Invalid input! Try again.\n");
        }
    }
}
