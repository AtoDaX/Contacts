package contacts;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class OrganizationContact extends AbstractContact{
    private String name;
    private String address;
    private String number;

    OrganizationContact(Scanner scanner){
        super();
        isPerson = false;
        System.out.println("Enter the organization name:");
        name = scanner.nextLine();
        System.out.println("Enter the address:");
        address = scanner.nextLine();
        System.out.println("Enter the number:");
        number = Validate.formatPhone(scanner.nextLine());
    }
    protected String getName(){
        return this.name;
    }
    protected void setName(String name){
        this.name = name;
    }

    protected String getNumber(){
        return this.number;
    }
    protected void setNumber(String number){
        this.number = Validate.formatPhone(number);
    }

    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    @Override
    public String toListString(){
        return this.name;
    }

    @Override
    public String toSearchFormat() {
        return (name + " " + address + " " + number).toLowerCase();
    }

    @Override
    public String toString(){
        return "Organization name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Number: " + number + "\n" +
                "Time created: " + createdTime + "\n" +
                "Time last edit: " + lastUpdateTime;
    }
}
