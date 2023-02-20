import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String ldt = scn.nextLine();

        LocalDateTime dateTime = LocalDateTime.parse(ldt);

        dateTime = dateTime.plusHours(11);

        LocalDate dat = dateTime.toLocalDate();

        System.out.println(dat);
    }
}