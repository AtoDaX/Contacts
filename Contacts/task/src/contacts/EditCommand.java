package contacts;

public class EditCommand implements Command {
    private PhoneBook phoneBook;

    public EditCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.edit();
    }
}
