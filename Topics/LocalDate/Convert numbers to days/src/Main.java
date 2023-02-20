import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int year = scn.nextInt();
        int da1 = scn.nextInt();
        int da2 = scn.nextInt();
        int da3 = scn.nextInt();
        LocalDate ld = LocalDate.ofYearDay(year,da1);
        System.out.println(ld);
        ld = LocalDate.ofYearDay(year,da2);
        System.out.println(ld);
        ld = LocalDate.ofYearDay(year,da3);
        System.out.println(ld);
    }
}