import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        Pattern pattern1 = Pattern.compile("\\b" + part,Pattern.CASE_INSENSITIVE);
        Pattern pattern2 = Pattern.compile(part + "\\b",Pattern.CASE_INSENSITIVE);

        Matcher m1 = pattern1.matcher(line);
        Matcher m2 = pattern2.matcher(line);

        boolean answer = m1.find()||m2.find();

        if (answer){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


        // write your code here
    }
}