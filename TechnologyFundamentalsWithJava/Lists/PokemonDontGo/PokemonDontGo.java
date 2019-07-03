import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int sumDestroyed = 0;
        while (!input.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                int saveNumber = input.get(0);
                sumDestroyed += saveNumber;
                input.set(0, input.get(input.size() - 1));

                addOrRemove(input, saveNumber);
            } else if (index > input.size() - 1) {
                int saveNumber = input.get(input.size() - 1);
                sumDestroyed += saveNumber;
                input.set(input.size() - 1, input.get(0));

                addOrRemove(input, saveNumber);
            } else {
                int saveNumber = input.get(index);
                input.remove(index);
                sumDestroyed += saveNumber;

                addOrRemove(input, saveNumber);
            }
        }
        System.out.println(sumDestroyed);
    }

    public static List<Integer> addOrRemove(List<Integer> list, int number) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= number) {
                list.set(i, list.get(i) + number);
            } else {
                list.set(i, list.get(i) - number);
            }
        }
        return list;
    }
}