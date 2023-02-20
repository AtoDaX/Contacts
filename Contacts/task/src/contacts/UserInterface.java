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
        int n = 0;
        while (true) {
            if (n!=0){
                System.out.println("");

            }
            n+=1;
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

            }
            case "remove" -> {
                Command removeCommand = new RemoveCommand(this.phoneBook);
                removeCommand.execute();

            }
            case "edit" -> {
                Command editCommand = new EditCommand(this.phoneBook);
                editCommand.execute();

            }
            case "list" -> {
                Command infoCommand = new InfoCommand(this.phoneBook);
                infoCommand.execute();

            }
            case "count" -> {
                Command countCommand = new CountCommand(this.phoneBook);
                countCommand.execute();

            }
            case "exit" -> {
                Command exitCommand = new ExitCommand(this.phoneBook);


                exitCommand.execute();

            }
            case "search" -> {
                Command searchCommand = new SearchCommand(this.phoneBook);
                searchCommand.execute();

            }
            default -> System.out.println("");
        }
    }
}
