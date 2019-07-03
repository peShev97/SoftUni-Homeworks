import java.util.Scanner;

public class Login {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            char symbol = username.charAt(i);
            password += symbol;
        }

        String pass = scanner.nextLine();
        int counter = 0;
        while (!pass.equals(password)) {
            counter++;
            if (counter == 4) {
                System.out.printf("User %s blocked!", username);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            pass = scanner.nextLine();
        }
        System.out.printf("User %s logged in.", username);
    }
}