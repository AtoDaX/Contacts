import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime l1 = LocalTime.parse(scanner.nextLine());
        LocalTime l2 = LocalTime.parse(scanner.nextLine());

        int diff = Math.abs(l1.toSecondOfDay()-l2.toSecondOfDay());
        System.out.println(diff);
    }
}