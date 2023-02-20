package contacts;

public class RemoveCommand implements Command{
    private PhoneBook phoneBook;

    public RemoveCommand(PhoneBook phoneBook){
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.remove();
    }
}
