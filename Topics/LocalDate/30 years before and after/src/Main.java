import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateToParse = scanner.nextLine();

        LocalDate date = LocalDate.parse(dateToParse);

        System.out.println(date.minusYears(30));
        System.out.println(date.plusYears(30));
    }
}