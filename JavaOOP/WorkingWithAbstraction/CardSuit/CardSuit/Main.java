package WorkingWithAbstraction.CardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String card = reader.readLine().toUpperCase();
        String suit = reader.readLine().toUpperCase();

        System.out.println(String.format("Card name: %s of %s; Card power: %d", Cards.valueOf(card), Suits.valueOf(suit),
                Cards.valueOf(card).getValue() + Suits.valueOf(suit).getPower()));
    }
}