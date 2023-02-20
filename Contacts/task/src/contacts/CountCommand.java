package contacts;

public class CountCommand implements Command{
    private PhoneBook phoneBook;

    public CountCommand(PhoneBook phoneBook){
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.count();
    }
}
