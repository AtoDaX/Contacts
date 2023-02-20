import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String ldt = scn.next();
        int dta = scn.nextInt();
        int hts = scn.nextInt();

        LocalDateTime dateTime = LocalDateTime.parse(ldt);

        dateTime = dateTime.plusDays(dta);
        dateTime = dateTime.minusHours(hts);

        System.out.println(dateTime);
    }
}