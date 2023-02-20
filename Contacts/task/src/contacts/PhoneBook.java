package contacts;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private List<AbstractContact> phoneBook;
    private Scanner scanner;

    PhoneBook(Scanner scanner) {
        phoneBook = new LinkedList<>();
        this.scanner = scanner;
    }

    public void add() {
        ContactFactory contactFactory = new ContactFactory(scanner);
        ContactType type;

        System.out.println("Enter the type (person, organization):");
        try {
            type = ContactType.valueOf(scanner.nextLine().toUpperCase());
        } catch (Exception e) {
            System.out.println("Invalid type");
            return;
        }
        AbstractContact contact = contactFactory.getContact(type);

        phoneBook.add(contact);
        System.out.println("A record added.");

    }


    public void remove() {
        if (this.phoneBook.size() == 0) {
            System.out.println("No records to remove!");
            return;
        }

        int numberOfContact;

        this.list();

        System.out.println("Select a record:");
        numberOfContact = Integer.parseInt(scanner.nextLine());

        if (!Validate.isValidInput(numberOfContact, this.phoneBook.size())) {
            return;
        }

        AbstractContact toRemove = this.phoneBook.get(numberOfContact - 1);
        this.phoneBook.remove(toRemove);
        System.out.println("The record removed!");
    }

    public void edit() {
        if (this.phoneBook.size() == 0) {
            System.out.println("No records to edit!");
            return;
        }
        System.out.println("");
        System.out.println("[record] Enter action (edit, delete, menu): ");
        String action = scanner.nextLine();
        switch (action) {
            case "edit" -> {
                int numberOfContact;
                this.list();
                System.out.println("Select a record:");
                numberOfContact = Integer.parseInt(scanner.nextLine());

                if (!Validate.isValidInput(numberOfContact, this.phoneBook.size())) {
                    return;
                }

                String[] fields = phoneBook.get(numberOfContact - 1).getFields();
                AbstractContact toEdit = phoneBook.get(numberOfContact - 1);
                System.out.println("Select a field " + Arrays.toString(fields).replace("[", "(").replace("]", ")") + ":");
                String fieldName = scanner.nextLine();

                if (!Arrays.toString(fields).contains(fieldName.toLowerCase())) {
                    return;
                }
                System.out.println("Enter " + fieldName + ":");
                String fieldValue = Validate.validate(scanner.nextLine(), fieldName);
                toEdit.setField(fieldName, fieldValue);
                toEdit.setLastUpdateTime(LocalDateTime.now().withSecond(0).withNano(0));
                System.out.println("Saved");
                System.out.println(phoneBook.get(numberOfContact - 1).toString());
                this.edit();
            }
            case "delete" -> {
                int numberOfContact;
                this.list();
                System.out.println("Select a record:");
                numberOfContact = Integer.parseInt(scanner.nextLine());

                if (!Validate.isValidInput(numberOfContact, this.phoneBook.size())) {
                    return;
                }
                phoneBook.remove(numberOfContact - 1);
                this.edit();
            }
            case "menu" -> {
                return;
            }
        }


    }


    public void count() {
        int size = phoneBook.size();
        System.out.printf("The Phone Book has %d records.\n", size);
    }

    public void list() {
        for (int number = 0; number < phoneBook.size(); number++) {
            AbstractContact toPrint = phoneBook.get(number);
            System.out.printf("%d. %s\n", number + 1, toPrint.toListString());
            /*if (phoneBook.get(number).isPerson()){
                PersonContact toPrint = (PersonContact) phoneBook.get(number);
                System.out.printf("%d. %s\n",number+1,toPrint.toListString());
            } else {
                OrganizationContact toPrint = (OrganizationContact) phoneBook.get(number);
                System.out.printf("%d. %s\n",number+1,toPrint.toListString());
            }*/
        }
    }

    public void info() {
        this.list();
        System.out.println("");
        System.out.println("[list] Enter action ([number], back):");
        String action = scanner.nextLine().toLowerCase();
        if (action.equals("back")) {
            return;
        }

        int numberOfContact = Integer.parseInt(action);
        if (!Validate.isValidInput(numberOfContact, this.phoneBook.size())) {
            return;
        }
        AbstractContact toShow = phoneBook.get(numberOfContact - 1);
        System.out.println(toShow.toString());
        System.out.println("");
        System.out.println("[record] Enter action (edit, delete, menu): ");
        action = scanner.nextLine();
        switch (action) {
            case "edit" -> {
                this.list();

                String[] fields = phoneBook.get(numberOfContact - 1).getFields();
                AbstractContact toEdit = phoneBook.get(numberOfContact - 1);
                System.out.println("Select a field " + Arrays.toString(fields).replace("[", "(").replace("]", ")") + ":");
                String fieldName = scanner.nextLine();

                if (!Arrays.toString(fields).contains(fieldName.toLowerCase())) {
                    return;
                }
                System.out.println("Enter " + fieldName + ":");
                String fieldValue = Validate.validate(scanner.nextLine(), fieldName);
                toEdit.setField(fieldName, fieldValue);
                toEdit.setLastUpdateTime(LocalDateTime.now().withSecond(0).withNano(0));
                System.out.println("Saved");
                System.out.println(phoneBook.get(numberOfContact - 1).toString());
                break;
            }
            case "delete" -> {
                phoneBook.remove(numberOfContact - 1);
                break;
            }
            case "menu" -> {
                return;
            }

        /*if (phoneBook.get(numberOfContact-1).isPerson()){
            PersonContact toShow = (PersonContact) phoneBook.get(numberOfContact-1);
            System.out.println(toShow.toString());
        } else {
            OrganizationContact toShow = (OrganizationContact) phoneBook.get(numberOfContact-1);
            System.out.println(toShow.toString());
        }*/

        }
    }

    public void search() {
        List<Integer> indexes = new ArrayList<>();
        List<AbstractContact> contacts = new ArrayList<>();
        System.out.println("Enter search query: ");
        String query = scanner.nextLine().toLowerCase();
        Pattern pattern = Pattern.compile(query);
        for (int n = 0; n < phoneBook.size(); n++) {
            Matcher matcher = pattern.matcher(phoneBook.get(n).toSearchFormat());
            if (matcher.find()) {
                indexes.add(n);
                contacts.add(phoneBook.get(n));
            }
        }
        if (indexes.size() == 1) {
            System.out.println("Found 1 result:");
        } else {
            System.out.println("Found " + indexes.size() + " results:");
        }
        for (int n = 0; n < indexes.size(); n++) {
            System.out.printf("%d. %s\n", n + 1, phoneBook.get(indexes.get(n)).toListString());
        }
        System.out.println("");
        System.out.println("[search] Enter action ([number], back, again):");
        String action = scanner.nextLine();
        switch (action) {
            case "back":
                return;
            case "again":
                this.search();
        }
        int numberOfContact = Integer.parseInt(action);
        AbstractContact toShow = phoneBook.get(indexes.get(numberOfContact - 1));
        System.out.println(toShow.toString());
        System.out.println("");
        System.out.println("[record] Enter action (edit, delete, menu): ");
        action = scanner.nextLine();
        switch (action) {
            case "edit" -> {
                this.list();

                String[] fields = phoneBook.get(numberOfContact - 1).getFields();
                AbstractContact toEdit = phoneBook.get(numberOfContact - 1);
                System.out.println("Select a field " + Arrays.toString(fields).replace("[", "(").replace("]", ")") + ":");
                String fieldName = scanner.nextLine();

                if (!Arrays.toString(fields).contains(fieldName.toLowerCase())) {
                    return;
                }
                System.out.println("Enter " + fieldName + ":");
                String fieldValue = Validate.validate(scanner.nextLine(), fieldName);
                toEdit.setField(fieldName, fieldValue);
                toEdit.setLastUpdateTime(LocalDateTime.now().withSecond(0).withNano(0));
                System.out.println("Saved");
                System.out.println(phoneBook.get(numberOfContact - 1).toString());
                break;
            }
            case "delete" -> {
                phoneBook.remove(numberOfContact - 1);
                break;
            }
            case "menu" -> {
                return;
            }
        }
    }

    public void exit () {
        System.exit(0);
    }
}
