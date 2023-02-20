package contacts;

public class ExitCommand implements Command{
    private PhoneBook phoneBook;

    public ExitCommand(PhoneBook phoneBook){
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.exit();
    }
}
