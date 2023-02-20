package contacts;

public class InfoCommand implements Command{
    private PhoneBook phoneBook;

    public InfoCommand(PhoneBook phoneBook){
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.info();
    }
}
