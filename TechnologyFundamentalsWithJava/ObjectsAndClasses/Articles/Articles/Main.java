package Articles;

import Articles.Articles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int commandsCount = Integer.parseInt(scanner.nextLine());

        Articles article = new Articles(input[0], input[1], input[2]);

        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            String[] splitTheCommand = command.split(": ");

            switch (splitTheCommand[0]) {
                case "Edit":
                    article.editContent(splitTheCommand[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(splitTheCommand[1]);
                    break;
                case "Rename":
                    article.renameTitle(splitTheCommand[1]);
                    break;
            }
        }

        System.out.println(article);
    }
}