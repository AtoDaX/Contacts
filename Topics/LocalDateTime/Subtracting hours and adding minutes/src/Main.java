import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String ldt = scn.nextLine();
        int hts = scn.nextInt();
        int dta = scn.nextInt();


        LocalDateTime dateTime = LocalDateTime.parse(ldt);
        dateTime = dateTime.minusHours(hts);

        dateTime = dateTime.plusMinutes(dta);


        System.out.println(dateTime);
    }
}