import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        List<String> result = new ArrayList<>();

        for (int i = input.length - 1; i >= 0; i--) {
            String[] element = input[i].split("\\s+");
            result.addAll(Arrays.asList(element));
        }

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).equals("")) {
                result.removeAll(Arrays.asList(result.get(i)));
            }
        }

        for (String item : result) {
            System.out.print(item + " ");
        }
    }
}