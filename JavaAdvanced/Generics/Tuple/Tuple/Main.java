package Generics.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Tuple<String, String, String> tupleOne = new Tuple<>();
        Tuple<String, Integer, Boolean> tupleTwo = new Tuple<>();
        Tuple<String, Double, String> tupleThree = new Tuple<>();

        String[] inputOne = reader.readLine().split("\\s+");
        String[] inputTwo = reader.readLine().split("\\s+");
        String[] inputThree = reader.readLine().split("\\s+");

        tupleOne.setItemOne(inputOne[0] + " " + inputOne[1]);
        tupleOne.setItemTwo(inputOne[2]);
        tupleOne.setItemThree(inputOne[3]);

        tupleTwo.setItemOne(inputTwo[0]);
        tupleTwo.setItemTwo(Integer.parseInt(inputTwo[1]));
        if (inputTwo[2].equals("drunk")) {
            tupleTwo.setItemThree(true);
        } else {
            tupleTwo.setItemThree(false);
        }

        tupleThree.setItemOne(inputThree[0]);
        tupleThree.setItemTwo(Double.parseDouble(inputThree[1]));
        tupleThree.setItemThree(inputThree[2]);

        System.out.println(tupleOne.toString());
        System.out.println(tupleTwo.toString());
        System.out.println(tupleThree.toString());
    }
}