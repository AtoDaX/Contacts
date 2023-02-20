import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern1 = ".*[a-z].*";
        String pattern2 = ".*[A-Z].*";
        String pattern3 = ".*[0-9].*";
        String pattern4 = ".{12,}";

        String pass = scanner.nextLine();

        if (pass.matches(pattern1)&&
            pass.matches(pattern2)&&
            pass.matches(pattern3)&&
            pass.matches(pattern4)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}