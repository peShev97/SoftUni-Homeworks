import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] commands = command.split(" ");
            switch (commands[0]) {
                case "exchange":
                    int indexEx = Integer.parseInt(commands[1]);
                    numbers = exchange(numbers, indexEx);
                    break;
                case "max":
                    switch (commands[1]) {
                        case "even":
                            maxEven(numbers);
                            break;
                        case "odd":
                            maxOdd(numbers);
                            break;
                    }
                    break;
                case "min":
                    switch (commands[1]) {
                        case "even":
                            minEven(numbers);
                            break;
                        case "odd":
                            minOdd(numbers);
                            break;
                    }
                    break;
                case "first":
                    int indexFirst = Integer.parseInt(commands[1]);
                    switch (commands[2]) {
                        case "even":
                            firstEven(numbers, indexFirst);
                            break;
                        case "odd":
                            firstOdd(numbers, indexFirst);
                            break;
                    }
                    break;
                case "last":
                    int indexLast = Integer.parseInt(commands[1]);
                    switch (commands[2]) {
                        case "even":
                            lastEven(numbers, indexLast);
                            break;
                        case "odd":
                            lastOdd(numbers, indexLast);
                            break;
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                System.out.print(numbers[i] + "]");
            } else {
                System.out.print(numbers[i] + ", ");
            }
        }
    }

    public static int[] exchange(int[] initialArray, int index) {
        if (index < 0 || index >= initialArray.length) {
            System.out.println("Invalid index");
        } else {
            int count = 0;
            int[] newArray = new int[initialArray.length];
            for (int i = index + 1; i < initialArray.length; i++) {
                newArray[count] = initialArray[i];
                count++;
            }

            for (int i = 0; i <= index; i++) {
                newArray[count] = initialArray[i];
                count++;
            }
            initialArray = newArray;
        }
        return initialArray;
    }

    public static void maxEven(int[] initialArray) {
        int maxEvenIndex = 0;
        int maxEven = 0;
        int evenCount = 0;
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] % 2 == 0) {
                evenCount++;
                if (initialArray[i] >= maxEven) {
                    maxEven = initialArray[i];
                    maxEvenIndex = i;
                }
            }
        }
        if (evenCount == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(maxEvenIndex);
        }
    }

    public static void maxOdd(int[] initialArray) {
        int maxOddIndex = 0;
        int maxOdd = 0;
        int oddCount = 0;
        for (int i = 0; i < initialArray.length; i++) {
            if (!(initialArray[i] % 2 == 0)) {
                oddCount++;
                if (initialArray[i] >= maxOdd) {
                    maxOdd = initialArray[i];
                    maxOddIndex = i;
                }
            }
        }
        if (oddCount == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(maxOddIndex);
        }
    }

    public static void minEven(int[] initialArray) {
        int minEvenIndex = 0;
        int minEven = Integer.MAX_VALUE;
        int evenCount = 0;
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] % 2 == 0) {
                evenCount++;
                if (initialArray[i] <= minEven) {
                    minEven = initialArray[i];
                    minEvenIndex = i;
                }
            }
        }
        if (evenCount == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(minEvenIndex);
        }
    }

    public static void minOdd(int[] initialArray) {
        int minOddIndex = 0;
        int minOdd = Integer.MAX_VALUE;
        int oddCount = 0;
        for (int i = 0; i < initialArray.length; i++) {
            if (!(initialArray[i] % 2 == 0)) {
                oddCount++;
                if (initialArray[i] <= minOdd) {
                    minOdd = initialArray[i];
                    minOddIndex = i;
                }
            }
        }
        if (oddCount == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(minOddIndex);
        }
    }

    public static void firstEven(int[] initialArray, int count) {
        if (count > initialArray.length) {
            System.out.println("Invalid count");
        } else {
            int[] evenNums = new int[initialArray.length];
            int evenNumsCount = 0;
            int evenCount = 0;
            for (int i = 0; i < initialArray.length; i++) {
                if (initialArray[i] % 2 == 0) {
                    evenCount++;
                    if (evenCount > count) {
                        break;
                    }
                    evenNums[evenNumsCount] = initialArray[i];
                    evenNumsCount++;
                }
            }

            if (evenCount == 0) {
                System.out.println("[]");
            } else {
                System.out.print("[");
                for (int i = 0; i < evenNumsCount; i++) {
                    if (i == evenNumsCount - 1) {
                        System.out.print(evenNums[i] + "]");
                    } else {
                        System.out.print(evenNums[i] + ", ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void firstOdd(int[] initialArray, int count) {
        if (count > initialArray.length) {
            System.out.println("Invalid count");
        } else {
            int[] oddNums = new int[initialArray.length];
            int oddNumsCount = 0;
            int oddCount = 0;
            for (int i = 0; i < initialArray.length; i++) {
                if (!(initialArray[i] % 2 == 0)) {
                    oddCount++;
                    if (oddCount > count) {
                        break;
                    }
                    oddNums[oddNumsCount] = initialArray[i];
                    oddNumsCount++;
                }
            }

            if (oddCount == 0) {
                System.out.println("[]");
            } else {
                System.out.print("[");
                for (int i = 0; i < oddNumsCount; i++) {
                    if (i == oddNumsCount - 1) {
                        System.out.print(oddNums[i] + "]");
                    } else {
                        System.out.print(oddNums[i] + ", ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void lastEven(int[] initialArray, int count) {
        if (count > initialArray.length) {
            System.out.println("Invalid count");
        } else {
            int[] evenNums = new int[initialArray.length];
            int evenNumsCount = 0;
            int evenCount = 0;
            for (int i = initialArray.length - 1; i >= 0; i--) {
                if (initialArray[i] % 2 == 0) {
                    evenCount++;
                    if (evenCount > count) {
                        break;
                    }
                    evenNums[evenNumsCount] = initialArray[i];
                    evenNumsCount++;
                }
            }

            if (evenCount == 0) {
                System.out.println("[]");
            } else {
                System.out.print("[");
                for (int i = evenNumsCount - 1; i >= 0; i--) {
                    if (i == 0) {
                        System.out.print(evenNums[i] + "]");
                    } else {
                        System.out.print(evenNums[i] + ", ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void lastOdd(int[] initialArray, int count) {
        if (count > initialArray.length) {
            System.out.println("Invalid count");
        } else {
            int[] oddNums = new int[initialArray.length];
            int oddNumsCount = 0;
            int oddCount = 0;
            for (int i = initialArray.length - 1; i >= 0; i--) {
                if (!(initialArray[i] % 2 == 0)) {
                    oddCount++;
                    if (oddCount > count) {
                        break;
                    }
                    oddNums[oddNumsCount] = initialArray[i];
                    oddNumsCount++;
                }
            }

            if (oddCount == 0) {
                System.out.println("[]");
            } else {
                System.out.print("[");
                for (int i = oddNumsCount - 1; i >= 0; i--) {
                    if (i == 0) {
                        System.out.print(oddNums[i] + "]");
                    } else {
                        System.out.print(oddNums[i] + ", ");
                    }
                }
                System.out.println();
            }
        }
    }
}