package contacts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonContact extends AbstractContact{
    private String name;
    private String surname;
    private String gender;
    private String birthdate;
    private String number;

    PersonContact(Scanner scanner){
        super();
        isPerson = true;
        System.out.println("Enter the name:");
        name = Validate.formatName(scanner.nextLine());
        System.out.println("Enter the surname:");
        surname = Validate.formatName(scanner.nextLine());
        System.out.println("Enter the birth date:");
        birthdate = Validate.formatDate(scanner.nextLine());
        System.out.println("Enter the gender");
        gender = Validate.formatGender(scanner.nextLine());
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

    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }

    public String  getBirthdate(){
        return this.birthdate;
    }
    public void setBirthdate(String birthdate){
        this.birthdate = birthdate;
    }
    @Override
    public String toListString(){
        return name + " " + surname;
    }

    @Override
    public String toSearchFormat() {
        return (name + " " + surname + " " + gender + " " + birthdate + " " + number).toLowerCase();
    }

    @Override
    public String toString(){
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + birthdate + "\n" +
                "Gender: " + gender + "\n" +
                "Number: " + number + "\n" +
                "Time created: " + createdTime + "\n" +
                "Time last edit: " + lastUpdateTime;
    }
}
