package contacts;

import java.util.Scanner;

public class ContactFactory {
    Scanner scanner;

    ContactFactory(Scanner scanner){
        this.scanner = scanner;
    }
    public AbstractContact getContact(ContactType type){
        AbstractContact toReturn = null;
        switch (type){
            case PERSON -> toReturn = new PersonContact(scanner);
            case ORGANIZATION -> toReturn = new OrganizationContact(scanner);
        }
        return toReturn;
    }
}
