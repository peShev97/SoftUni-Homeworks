package InterfacesAndAbstraction.Telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();

        for (String number : numbers) {
            boolean isValid = true;

            for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.append("Calling... " + number)
                        .append(System.lineSeparator());
            } else {
                result.append("Invalid number!")
                        .append(System.lineSeparator());
            }
        }

        return result.toString();
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();

        for (String url : urls) {
            boolean isValid = true;

            for (int i = 0; i < url.length(); i++) {
                if (Character.isDigit(url.charAt(i))) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.append("Browsing: " + url + "!")
                        .append(System.lineSeparator());
            } else {
                result.append("Invalid URL!")
                        .append(System.lineSeparator());
            }
        }

        return result.toString();
    }
}