package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();

        ArrayDeque<String> lastCommandType = new ArrayDeque<>();
        ArrayDeque<String> lastCommandContent = new ArrayDeque<>();

        for (int i = 0; i < lines; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]) {
                case "1":
                    text.append(command[1]);
                    lastCommandType.push(command[0]);
                    lastCommandContent.push(command[1]);
                    break;
                case "2":
                    int count = Integer.parseInt(command[1]);

                    StringBuilder removedString = new StringBuilder();
                    if (count <= text.length()) {
                        int indexToRemove = text.length() - 1;
                        for (int j = 0; j < count; j++) {
                            removedString.append(text.charAt(indexToRemove));
                            text.deleteCharAt(indexToRemove);
                            indexToRemove--;
                        }
                    }

                    lastCommandType.push(command[0]);
                    removedString.reverse();
                    String remove = "";

                    for (int k = 0; k < removedString.length(); k++) {
                        char symbol = removedString.charAt(k);
                        remove += symbol;
                    }
                    lastCommandContent.push(remove);
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]) - 1;

                    if (index >= 0 && index < text.length()) {
                        System.out.println(text.charAt(index));
                    }
                    break;
                case "4":
                    String commandType = lastCommandType.pop();
                    String commandContent = lastCommandContent.pop();

                    switch (commandType) {
                        case "1":
                            int lastIndex = text.length() - 1;

                            for (int j = 0; j < commandContent.length(); j++) {
                                text.deleteCharAt(lastIndex);
                                lastIndex--;
                            }
                            break;
                        case "2":
                            text.append(commandContent);
                            break;
                    }
                    break;
            }
        }
    }
}